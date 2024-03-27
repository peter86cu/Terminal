package com.ayalait.terminal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ayalait.terminal.service.*;

@RestController
public class CajaController {
	@Autowired
	AperturaCajaService service;

	@GetMapping(value = "caja/validar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> validarCajaAbierta( @RequestParam("fecha") String fecha)
			throws Exception {

		return service.obtenerAperturaCajaPorFecha(fecha);

	}	
	
	@GetMapping(value = "caja/open-day", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerOpenDay( @RequestParam("fecha") String fecha)
			throws Exception {

		return service.obtenerAperturaDiaPorFecha(fecha);

	}

	@GetMapping(value = "historico/cambio", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerHistoricoCambioPorIdApertura(@RequestParam("id") String id, @RequestParam("moneda") String moneda) throws Exception {

		return service.obtenerHistoricoCambioIdApertura(id, moneda);

	}

	@PostMapping(value = "caja/abrir", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> abrirCaja( @RequestBody String datos) throws Exception {

		return service.abrirCaja(datos);

	}

	@PostMapping(value = "cambio/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarHistoricoCambio( @RequestBody String datos)
			throws Exception {

		return service.guardarHistoricoCambio(datos);

	}
	
	@PostMapping(value = "caja/listado-mes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerListadoAperturasMensuales(@RequestParam("mes") int mes, @RequestParam("anno") int anno)
			throws Exception {

		return service.listadoAperturaPorMesyAnno(mes, anno);

	}


}
