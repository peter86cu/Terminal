package com.ayalait.terminal.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="ventas_productos_devueltos")
public class VentasProductosDevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

     @Id
	private String id;
	private String id_devolucion;
	private String id_producto;
	private int cantidad;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_devolucion() {
		return id_devolucion;
	}
	public void setId_devolucion(String id_devolucion) {
		this.id_devolucion = id_devolucion;
	}
	public String getId_producto() {
		return id_producto;
	}
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
