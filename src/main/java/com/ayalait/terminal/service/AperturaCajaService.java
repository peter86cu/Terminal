package com.ayalait.terminal.service;



import org.springframework.http.ResponseEntity;

import com.ayalait.terminal.modelo.*;

public interface AperturaCajaService {
	
	ResponseEntity<String> abrirCaja(String caja);
	
	ResponseEntity<String> eliminarAperturaCaja(String id);
	
	ResponseEntity<String> obtenerAperturaCajaPorFecha(String fecha);
	
	AperturaCaja recuperarAperturaCaja(String id);	
	
	ResponseEntity<String> guardarHistoricoCambio(String data); 
	
	ResponseEntity<String> obtenerCambioMonedaPorID(String id);
	
	ResponseEntity<String> obtenerHistoricoCambioIdApertura(String id, String moneda);
	
	ResponseEntity<String> listadoAperturaPorMesyAnno(int mes, int anno);
	
	ResponseEntity<String> obtenerAperturaDiaPorFecha(String fecha);

}
