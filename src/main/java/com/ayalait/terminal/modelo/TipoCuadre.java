package com.ayalait.terminal.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipo_cuadre_caja")
public class TipoCuadre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_cuadre;
	private String descripcion;
	public int getId_cuadre() {
		return id_cuadre;
	}
	public void setId_cuadre(int id_cuadre) {
		this.id_cuadre = id_cuadre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
