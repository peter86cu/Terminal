package com.ayalait.terminal.modelo;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "caja")
public class Caja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idcaja;

	private String nombre;

	private String ip;
	
	private int idsucursal;
	
	private int estado;

	public String getIdcaja() {
		return idcaja;
	}

	public void setIdcaja(String idcaja) {
		this.idcaja = idcaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	




}