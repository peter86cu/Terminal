package com.ayalait.terminal.dao;

import com.ayalait.terminal.Terminal;
import org.springframework.http.ResponseEntity;

import com.ayalait.terminal.modelo.*;

import java.util.List;

public interface AperturaTerminalDao {
	
	
	
	ResponseEntity<String> buscasApertura(String usuario, String fecha);
	
	void guardarAperturaTerminal(AperturasTerminal apertura);
	
	AperturasTerminal obtenerAperturaTerminalPorId(int idApertura);
	
	void eliminarAperturaTerminal(int id);


}
