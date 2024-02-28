package com.ayalait.terminal.service;

import org.springframework.http.ResponseEntity;


public interface ParametrosService {
	
	ResponseEntity<String> obtenerCajas();
	
	ResponseEntity<String> datosCajaIP(String ip);
	
	ResponseEntity<String> obtenerTipoCuadreCaja();
	
	ResponseEntity<String> obtenerTurnos();
	
	ResponseEntity<String> obtenerTipoArqueo();
	
	ResponseEntity<String> obtenerBilletes();
	
	ResponseEntity<String> cargarConfiguraciones();

	ResponseEntity<String> obtenerEstadoVentas();

	ResponseEntity<String> ventasCausasDevueltos();
	
	ResponseEntity<String> obtenerFormasCobros();

}
