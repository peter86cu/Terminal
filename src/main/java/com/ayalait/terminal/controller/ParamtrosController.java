package com.ayalait.terminal.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.terminal.service.*;


@RestController
public class ParamtrosController {

	@Autowired
	ParametrosService service;

	@GetMapping(value = "parametros/cajas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoCajas() throws Exception {
		return service.obtenerCajas();

	}

	@GetMapping(value = "parametros/caja", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> datosCaja(@RequestParam("ip") String ip) throws Exception {

		return service.datosCajaIP(ip);

	}

	@GetMapping(value = "parametros/tipocuadre", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoTipoCuadre() throws Exception {
		return service.obtenerTipoCuadreCaja();

	}

	@GetMapping(value = "parametros/turno", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoTurnos() throws Exception {
		return service.obtenerTurnos();

	}

	@GetMapping(value = "parametros/tipoarqueo", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeTipoArqueo() throws Exception {

		return service.obtenerTipoArqueo();

	}

	@GetMapping(value = "parametros/billetes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeBilletes() throws Exception {

		return service.obtenerBilletes();

	}

	@GetMapping(value = "parametros/configuraciones", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> cargarConfiguraciones() throws Exception {

		return service.cargarConfiguraciones();

	}


	@GetMapping(value = "parametros/estado-ventas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerEstadoVentas() throws Exception {

		return service.obtenerEstadoVentas();

	}

	@GetMapping(value = "parametros/estado-ventas-devueltos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerVentasDevueltos() throws Exception {

		return service.ventasCausasDevueltos();

	}
	
	
	@GetMapping(value="parametros/formas-cobros",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listaFormaCobros() throws Exception {
		
			return service.obtenerFormasCobros();
			
	}
}
