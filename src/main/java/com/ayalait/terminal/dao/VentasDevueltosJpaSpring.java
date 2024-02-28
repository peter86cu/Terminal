package com.ayalait.terminal.dao;


import com.ayalait.terminal.modelo.VentasCausaDevueltos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VentasDevueltosJpaSpring extends JpaRepository<VentasCausaDevueltos, Integer>{
	
}
