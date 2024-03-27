package com.ayalait.terminal.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.terminal.modelo.*;
import com.ayalait.terminal.dao.*;
import com.ayalait.terminal.util.*;
import com.ayalait.utils.DiaAbierto;
import com.ayalait.utils.ErrorState;
@Service
public class AperturaCajaServiceImpl implements AperturaCajaService {

	@Autowired
	AperturaCajaDao daoCaja;

	@Autowired
	HistoricoCambioJPASpring daoCambio;
	
	ErrorState error= new ErrorState();

	@Override
	public ResponseEntity<String> abrirCaja(String caja) {
		AperturaCaja request = new Gson().fromJson(caja, AperturaCaja.class);

		// if
		// (daoCaja.obtenerEstadoCaja(request.getCaja(),request.getFechaapertura())==null)
		// {

		// }
		// return new ResponseEntity<String>(util.Constants.CAJA_NOK,
		// HttpStatus.NOT_ACCEPTABLE);

		try {
			daoCaja.abrirCaja(request);
			return new ResponseEntity<String>(Constants.CAJA_OK, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@Override
	public ResponseEntity<String> eliminarAperturaCaja(String id) {
		try {
			return new ResponseEntity<String>("", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public AperturaCaja recuperarAperturaCaja(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	//@Cacheable(cacheNames="estadoTerminal")
	@Override
	public ResponseEntity<String> obtenerAperturaCajaPorFecha(String fecha) {
		try {
			AperturaCaja validarApertura = daoCaja.obtenerEstadoCaja(fecha);
			System.out.println(new Gson().toJson(validarApertura));
			if (validarApertura == null) {
				error.setCode(4005);
				error.setMenssage("El día no esta abierto.");
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);

			} else {
				return new ResponseEntity<String>(new Gson().toJson(validarApertura), HttpStatus.OK);
			}
		} catch (Exception e) {
			error.setCode(4005);
			error.setMenssage(e.getCause().getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<String> guardarHistoricoCambio(String data) {
		try {
			HistoricoCambio request = new Gson().fromJson(data, HistoricoCambio.class);

			daoCambio.save(request);

			return new ResponseEntity<String>(Constants.RESULTADO_OK, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<String> obtenerCambioMonedaPorID(String id) {
		
		try {
			HistoricoCambio historico=daoCambio.findById(id).orElse(null);
			if(historico!=null)
				return new ResponseEntity<String>(new Gson().toJson(historico), HttpStatus.OK);
				return new ResponseEntity<String>("No se obtuvieron datos.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);		}
	}

	@Override
	public ResponseEntity<String> obtenerHistoricoCambioIdApertura(String id, String moneda) {
		try {
			HistoricoCambio historico= daoCambio.obtenerHistoricoCambioPorApertura(id, moneda);
			if(historico!=null)
			return new ResponseEntity<String>(new Gson().toJson(historico), HttpStatus.OK);
			return new ResponseEntity<String>("No se obtuvieron datos.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

	@Override
	public ResponseEntity<String> listadoAperturaPorMesyAnno(int mes, int anno) {
		try {
			List<AperturaCaja> lstApertura= daoCaja.listadoAperturaPorMesyAnno(mes, anno);
			if(lstApertura.isEmpty())
				return new ResponseEntity<String>("No se obtuvieron datos.", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<String>(new Gson().toJson(lstApertura), HttpStatus.OK);
	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> obtenerAperturaDiaPorFecha(String fecha) {
		try {
			List<DiaAbierto> lstOpen= new ArrayList<DiaAbierto>();
			Iterator<Object> lstArray = daoCaja.obtenerAperturaDiaPorFecha(fecha).iterator();
			if(lstArray!=null) {
				while( lstArray.hasNext()) {
					Object[] objArray = (Object[]) lstArray.next();
					DiaAbierto open= new DiaAbierto();
					open.setId(objArray[0].toString());
					open.setEstado(objArray[1].toString());
					open.setIdmoneda(Integer.parseInt(objArray[2].toString()));
					open.setValorcompra(Double.parseDouble(objArray[3].toString()));
					open.setValorventa(Double.parseDouble(objArray[4].toString()));
					lstOpen.add(open);
				}
				if(!lstOpen.isEmpty()) {
					return new ResponseEntity<String>(new Gson().toJson(lstOpen), HttpStatus.OK);
				}else {
					error.setCode(4006);
					error.setMenssage("No se obtuvieron datos.");
					return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);
				}
				
			}else {
				error.setCode(4006);
				error.setMenssage("No se obtuvieron datos.");
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);
			}
				
			
	
		} catch (Exception e) {
			error.setCode(4006);
			error.setMenssage(e.getCause().getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);

		}
	}

}
