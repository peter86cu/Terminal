package com.ayalait.terminal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;


import com.ayalait.terminal.dao.*;
import com.ayalait.terminal.modelo.*;

@Service
public class ParametrosServiceImpl implements ParametrosService {

	@Autowired
	ParametrosDao service;

	// @Cacheable(cacheNames="cajas")
	@Override
	public ResponseEntity<String> obtenerCajas() {
		try {
			List<Caja> cajas = service.obtenerCaja();
			if (!cajas.isEmpty())
				return new ResponseEntity<String>(new Gson().toJson(cajas), HttpStatus.OK);
			return new ResponseEntity<String>("No existen cajas disponibles en la base de datos.",
					HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<String> datosCajaIP(String ip) {
		try {
			Caja datosCaja = service.obtenerDatosCajaIP(ip);
			if (datosCaja != null) {
				return new ResponseEntity<String>(new Gson().toJson(datosCaja), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(
						"No existe la caja con la ip: " + ip + " .Contactar a un Administrador.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}
	@Cacheable(cacheNames="tipoCuadre")
	@Override
	public ResponseEntity<String> obtenerTipoCuadreCaja() {
		try {
			List<TipoCuadre> lstTipo = service.obtenerTipoCuadreCaja();
			if (!lstTipo.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstTipo), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen formas de pagos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}
	@Cacheable(cacheNames="turnos")
	@Override
	public ResponseEntity<String> obtenerTurnos() {
		try {
			List<Turnos> lstTurnos = service.obtenerTurnos();
			if (!lstTurnos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstTurnos), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen formas de pagos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@Cacheable(cacheNames="tipoArqueo")
	@Override
	public ResponseEntity<String> obtenerTipoArqueo() {
		try {
			List<TipoArqueo> lstTA = service.obtenerTipoArqueo();
			if (!lstTA.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstTA), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen tipos de arqueos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@Cacheable(cacheNames="billetes")
	@Override
	public ResponseEntity<String> obtenerBilletes() {
		try {
			List<Billetes> lst = service.obtenerBilletes();
			if (!lst.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lst), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen billetes en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Cacheable(cacheNames="configuraciones")
	@Override
	public ResponseEntity<String> cargarConfiguraciones() {
		try {
			List<Configuraciones> lst = service.cargarConfiguraciones();
			if (!lst.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lst), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen configuraciones en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Cacheable(cacheNames="estadoVentas")
	@Override
	public ResponseEntity<String> obtenerEstadoVentas() {
		try {
			List<VentasEstados> lstEstadoV= service.obtenerEstadosVentas();
			if(!lstEstadoV.isEmpty()){
				return new ResponseEntity<String>(new Gson().toJson(lstEstadoV), HttpStatus.OK);

			}else{
				return new ResponseEntity<String>("No existen estado de ventas en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e){
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
		}
	@Cacheable(cacheNames="estadoVentasDevueltos")
	@Override
	public ResponseEntity<String> ventasCausasDevueltos() {
		try {
			List<VentasCausaDevueltos> lstEstadoV= service.obtenerVentasCausasDevueltos();
			if(!lstEstadoV.isEmpty()){
				return new ResponseEntity<String>(new Gson().toJson(lstEstadoV), HttpStatus.OK);

			}else{
				return new ResponseEntity<String>("No existen estado de ventas devueltos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e){
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Cacheable(cacheNames="formasCobros")
	@Override
	public ResponseEntity<String> obtenerFormasCobros() {
		try {
			List<FormasCobro> lst=service.listadoFormasCobros();
			if(!lst.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lst), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen formas de cobro en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		
		
		
		
			
	}

}
