package com.ayalait.terminal.dao;


import java.util.List;

import com.ayalait.terminal.modelo.*;
import org.springframework.http.ResponseEntity;

public interface AperturaCajaDao {
	
	void abrirCaja(AperturaCaja caja);


	AperturaCaja obtenerEstadoCaja( String fecha);
	
	void eliminarAperturaCaja(String id);
	
	AperturaCaja recuperarAperturaCaja(String id);	
	
	List<AperturaCaja> listadoAperturaPorMesyAnno(int mes, int anno);
	
	List<Object> obtenerAperturaDiaPorFecha(String fecha);

}
