package com.ayalait.terminal.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.terminal.modelo.*;



public interface ArqueoTerminalJpaSpring extends JpaRepository<ArqueoTerminal, Integer>{
	@Query(value="SELECT * FROM apertura_caja WHERE fechaapertura = :fecha AND caja=:idcaja", nativeQuery=true)
	AperturaCaja findByAperturaCaja(@Param("fecha") String fecha,@Param("idcaja") String idcaja);
}
