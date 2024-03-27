package com.ayalait.terminal.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ayalait.terminal.modelo.*;

@Repository
public class AperturaCajaDaoImpl implements AperturaCajaDao {

	@Autowired
	AperturaCajaJpaSpring dao;
	
	@Override
	public void abrirCaja(AperturaCaja caja) {
		dao.save(caja);
	}



	@Override
	public void eliminarAperturaCaja(String id) {
		dao.deleteById(id);
	}

	@Override
	public AperturaCaja recuperarAperturaCaja(String id) {
		
		return dao.findById(id).orElse(null);
	}

	@Override
	public AperturaCaja obtenerEstadoCaja(String date) {		
		return dao.findByAperturaCaja(date);
	}

	@Override
	public List<AperturaCaja> listadoAperturaPorMesyAnno(int mes, int anno) {
		return dao.findAperturasMensuales(mes, anno);
	}



	@Override
	public List<Object> obtenerAperturaDiaPorFecha(String fecha) {
		return dao.findAperturaDiaPorFecha(fecha);
	}

}
