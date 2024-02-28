package com.ayalait.terminal.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.terminal.modelo.*;


public interface CajaJpaSpring extends JpaRepository<Caja, String>{
	
	
	@Query(value="SELECT * FROM caja WHERE ip=:ip", nativeQuery=true)
	Caja obtenerDatosCajaIP(@Param("ip") String ip);
}
