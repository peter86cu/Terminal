package com.ayalait.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.terminal.dao.*;
import com.ayalait.terminal.modelo.*;
import com.ayalait.terminal.util.*;


@Service
public class AperturaTerminalServiceImpl implements AperturaTerminalService {

	@Autowired
	AperturaTerminalDao daoTerminal;

	@Autowired
	ArqueoTerminalJpaSpring daoArqueoTerminal;

	@Autowired
	DetalleArqueoTerminalJpaSpring daoDetalle;


	@Override
	public ResponseEntity<String> obtenerAperturaTerminalPorUsuario(String usuario, String fecha) {

		return daoTerminal.buscasApertura(usuario, fecha);
	}


	@Override
	public ResponseEntity<String> guardarAperturaTerminal(String data) {
		try {
			AperturasTerminal request = new Gson().fromJson(data, AperturasTerminal.class);
			daoTerminal.guardarAperturaTerminal(request);
			return new ResponseEntity<String>(Constants.CAJA_OK, HttpStatus.OK);


		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}


	}


	@Override
	public ResponseEntity<String> guardarArqueoTerminal(String arqueo) {

		try {
			ArqueoTerminal request= new Gson().fromJson(arqueo, ArqueoTerminal.class);
			daoArqueoTerminal.save(request);

			return new ResponseEntity<String>(Constants.RESULTADO_OK, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}


	}


	@Override
	public ResponseEntity<String> guardarDetalleArqueoTermina(String detalles) {
		try {
			ArqueoTerminalDetalle request= new Gson().fromJson(detalles, ArqueoTerminalDetalle.class);
			daoDetalle.save(request);
			return new ResponseEntity<String>(Constants.RESULTADO_OK, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}


	}


	@Override
	public ResponseEntity<String> obtenerAperturaTerminalPorId(int idApertura) {
		try {
			AperturasTerminal apertura= daoTerminal.obtenerAperturaTerminalPorId(idApertura);
			if(apertura!=null)
				return new ResponseEntity<String>(new Gson().toJson(apertura), HttpStatus.OK);
			return new ResponseEntity<String>(Constants.RESULTADO_NOK, HttpStatus.BAD_REQUEST);


		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<String> eliminarArqueoYDetalle(int idArqueo) {
		try {
			daoArqueoTerminal.deleteById(idArqueo);
			daoDetalle.eliminarDetallePorIdArqueo(idArqueo);
			return new ResponseEntity<String>("Eliminado los datos del arqueo y el detalle.", HttpStatus.BAD_REQUEST);

		}catch (Exception e){
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
		}


		@Override
		public ResponseEntity<String> cerrarAperturaTerminal(String data) {

			try {

				AperturasTerminal request= new Gson().fromJson(data, AperturasTerminal.class);
				daoTerminal.guardarAperturaTerminal(request);
				return new ResponseEntity<String>(Constants.RESULTADO_OK, HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);

			}

		}


		@Override
		public ResponseEntity<String> eliminarAperturaTerminalPorUsuario(int id) {
			try {
				daoTerminal.eliminarAperturaTerminal(id);
				return new ResponseEntity<String>("Apertura de terminal con id: "+id+" eliminada correctamente.", HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

			}
		}


	}
