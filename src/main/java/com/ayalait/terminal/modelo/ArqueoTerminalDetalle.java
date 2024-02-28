package com.ayalait.terminal.modelo;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="arqueos_detalle")
public class ArqueoTerminalDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_arqueo_detalle")
	private int idArqueoDetalle;

	@Column(name="id_arqueo")
	private int idArqueo;

	@Column(name="id_billete")
	private int idBillete;

	private int valor;

	public ArqueoTerminalDetalle() {
	}

	public int getIdArqueoDetalle() {
		return this.idArqueoDetalle;
	}

	public void setIdArqueoDetalle(int idArqueoDetalle) {
		this.idArqueoDetalle = idArqueoDetalle;
	}

	public int getIdArqueo() {
		return this.idArqueo;
	}

	public void setIdArqueo(int idArqueo) {
		this.idArqueo = idArqueo;
	}

	public int getIdBillete() {
		return this.idBillete;
	}

	public void setIdBillete(int idBillete) {
		this.idBillete = idBillete;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}