package com.ayalait.terminal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.terminal.service.*;
@RestController
public class TerminalController {
	@Autowired
	AperturaTerminalService service;

	@GetMapping(value = "terminal/buscar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> validarCajaAbierta( @RequestParam("id") String usuarioID,
			@RequestParam("fecha") String fecha) throws Exception {

		return service.obtenerAperturaTerminalPorUsuario(usuarioID, fecha);

	}

	@GetMapping(value = "terminal/apertura", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerAperturaTerminalPorID( @RequestParam("id") int id)
			throws Exception {

		return service.obtenerAperturaTerminalPorId(id);

	}

	@PostMapping(value = "terminal/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarTerminal( @RequestBody String datos)
			throws Exception {

		return service.guardarAperturaTerminal(datos);

	}

	@PostMapping(value = "terminal/cerrar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> cerrarTerminal( @RequestBody String datos)
			throws Exception {

		return service.cerrarAperturaTerminal(datos);

	}

	@PostMapping(value = "terminal/arqueo/detalle/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarArqueoDetalleTerminal( @RequestBody String datos)
			throws Exception {

		return service.guardarDetalleArqueoTermina(datos);

	}

	@PostMapping(value = "terminal/arqueo/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> guardarArqueoTerminal( @RequestBody String datos)
			throws Exception {

		return service.guardarArqueoTerminal(datos);

	}

	@DeleteMapping(value = "terminal/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> eliminarAperturaTerminal( @RequestParam("id") int id)
			throws Exception {

		return service.eliminarAperturaTerminalPorUsuario(id);

	}


	@DeleteMapping(value = "terminal/arqueo/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> eliminarAperturayDetalle( @RequestParam("id") int id)
			throws Exception {

		return service.eliminarArqueoYDetalle(id);

	}
	
	
	
	

}
