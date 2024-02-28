package com.ayalait.terminal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ventas_causa_devueltos")
public class VentasCausaDevueltos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id_causa_devuelto;
	private String descripcion;

	public int getId_causa_devuelto() {
		return id_causa_devuelto;
	}

	public void setId_causa_devuelto(int id_causa_devuelto) {
		this.id_causa_devuelto = id_causa_devuelto;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
