package com.ayalait.terminal.service;

import org.springframework.http.ResponseEntity;


public interface AperturaTerminalService {
	
	
	
	ResponseEntity<String> obtenerAperturaTerminalPorUsuario(String usuario, String fecha);
	
	ResponseEntity<String> eliminarAperturaTerminalPorUsuario(int id);
	
	ResponseEntity<String> guardarAperturaTerminal(String data); 
	
	ResponseEntity<String> cerrarAperturaTerminal(String data); 
	
	ResponseEntity<String> guardarArqueoTerminal(String arqueo);
	
	ResponseEntity<String> guardarDetalleArqueoTermina(String detalles);
	
	ResponseEntity<String> obtenerAperturaTerminalPorId(int idApertura);

	ResponseEntity<String> eliminarArqueoYDetalle(int idArqueo);

}
