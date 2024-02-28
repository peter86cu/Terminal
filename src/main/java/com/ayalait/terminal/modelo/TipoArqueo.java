package com.ayalait.terminal.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipo_arqueo")
public class TipoArqueo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
