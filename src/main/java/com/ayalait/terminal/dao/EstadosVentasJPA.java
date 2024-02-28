package com.ayalait.terminal.dao;

import com.ayalait.terminal.modelo.VentasEstados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadosVentasJPA extends JpaRepository<VentasEstados, Integer>{

}
