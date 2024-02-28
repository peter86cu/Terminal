package com.ayalait.terminal.dao;
import java.util.ArrayList;
import java.util.List;

import com.ayalait.terminal.Terminal;
import com.ayalait.terminal.vo.ResponseApertura;
import com.ayalait.utils.ErrorState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import com.ayalait.terminal.modelo.*;

@Repository
public class AperturaTerminalDaoImpl implements AperturaTerminalDao {

	private ErrorState error= new ErrorState();
	@Autowired
	AperturaTerminalJpaSpring dao;

	@Override
	public ResponseEntity<String> buscasApertura(String usuario,String fecha) {
		AperturasTerminal terminal= new AperturasTerminal();
		List<AperturasTerminal> lstTerminales= new ArrayList<AperturasTerminal>();

		terminal= dao.buscasApertura(usuario,fecha);
		if(terminal==null) {
			lstTerminales=dao.buscasAperturasAnterior(usuario, fecha);
			if(lstTerminales.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(terminal), HttpStatus.OK);

			}else {
				String dias="";
				List<String> lstFechas = new ArrayList<>();
				ResponseApertura resultado= new ResponseApertura();
				for(AperturasTerminal diasSinCerrar: lstTerminales) {
					dias+=diasSinCerrar.getFechaInicio()+"\r\n";
					lstFechas.add(diasSinCerrar.getFechaInicio());
				}
				resultado.setLstAperturas(lstTerminales);
				resultado.setFechas(lstFechas);
				resultado.setMensaje("Debe cerrar la terminal para las fechas: "+dias);
				error.setCode(406);
				error.setMenssage("Debe cerrar la terminal para las fechas: "+dias);
				return new ResponseEntity<String>(new Gson().toJson(resultado), HttpStatus.ACCEPTED);

			}
		}else {
			return new ResponseEntity<String>(new Gson().toJson(terminal), HttpStatus.OK);

		}
	}

	@Override
	public void guardarAperturaTerminal(AperturasTerminal apertura) {
		dao.save(apertura);

	}

	@Override
	public AperturasTerminal obtenerAperturaTerminalPorId(int idApertura) {

		return dao.findById(idApertura).orElse(null);
	}

	@Override
	public void eliminarAperturaTerminal(int id) {
		dao.deleteById(id);
	}




}
