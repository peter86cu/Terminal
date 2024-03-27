package com.ayalait.terminal.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.terminal.modelo.*;


public interface AperturaCajaJpaSpring extends JpaRepository<AperturaCaja, String>{
	@Query(value="SELECT * FROM apertura_dia WHERE fechaapertura = :fecha", nativeQuery=true)
	AperturaCaja findByAperturaCaja(@Param("fecha") String fecha);
	
	
	@Query(value="SELECT * FROM apertura_dia WHERE MONTH(fechaapertura) = :mes AND YEAR(fechaapertura) = :anno", nativeQuery=true)
	List<AperturaCaja>	findAperturasMensuales(int mes, int anno);	
	
	@Query(value="SELECT a.id,a.estado,h.idmoneda,h.valorcompra,h.valorventa FROM apertura_dia a JOIN historico_cambio h ON (a.id=h.idapertura) WHERE a.fechaapertura = :fecha", nativeQuery=true)
	List<Object> findAperturaDiaPorFecha(String fecha);	
}
