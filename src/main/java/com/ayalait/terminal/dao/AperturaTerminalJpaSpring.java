package com.ayalait.terminal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.terminal.modelo.*;

public interface AperturaTerminalJpaSpring extends JpaRepository<AperturasTerminal, Integer>{
	
	//
	@Query(value="SELECT * FROM aperturas_terminal where id_usuario=:id_usuario and fecha_inicio=:fecha and  id_tipo_arqueo<>3", nativeQuery=true)
	AperturasTerminal buscasApertura(@Param("id_usuario") String id_usuario, @Param("fecha") String fecha);
	
	@Query(value="SELECT * FROM aperturas_terminal where id_usuario=:id_usuario and fecha_inicio<>(:fecha) and  fecha_hora_cierre is null", nativeQuery=true)
	List<AperturasTerminal> buscasAperturasAnterior(@Param("id_usuario") String id_usuario, @Param("fecha") String fecha);


}
