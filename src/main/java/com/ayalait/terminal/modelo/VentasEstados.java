package com.ayalait.terminal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ventas_estados")
public class VentasEstados implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_venta_estado;
	private String descripcion;

	public int getId_venta_estado() {
		return id_venta_estado;
	}

	public void setId_venta_estado(int id_venta_estado) {
		this.id_venta_estado = id_venta_estado;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
