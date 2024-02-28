package com.ayalait.terminal.vo;

import java.io.Serializable;

import com.ayalait.terminal.modelo.*;


public class RequestAbrirCaja implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private AperturaCaja caja;

	public AperturaCaja getCaja() {
		return caja;
	}

	public void setCaja(AperturaCaja caja) {
		this.caja = caja;
	}

	

	

}
