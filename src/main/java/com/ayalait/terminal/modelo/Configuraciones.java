package com.ayalait.terminal.modelo;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="configuraciones")
@NamedQuery(name="Configuraciones.findAll", query="SELECT c FROM Configuraciones c")
public class Configuraciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String valor;

	public Configuraciones() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}