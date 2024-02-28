package com.ayalait.terminal.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="arqueos")
public class ArqueoTerminal  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_arqueo")
	private int idArqueo;

	
	@Column(name="fecha_baja")
	private String fechaBaja;

	
	@Column(name="fecha_hora")
	private String fechaHora;

	@Column(name="id_apertura_cajero")
	private int idAperturaCajero;

	@Column(name="id_cuadre")
	private int idCuadre;

	@Column(name="id_estado_arqueo")
	private int idEstadoArqueo;

	@Column(name="id_sucursal")
	private int idSucursal;

	@Column(name="id_usuario")
	private String idUsuario;

	public ArqueoTerminal() {
	}

	public int getIdArqueo() {
		return this.idArqueo;
	}

	public void setIdArqueo(int idArqueo) {
		this.idArqueo = idArqueo;
	}

	public String getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getIdAperturaCajero() {
		return this.idAperturaCajero;
	}

	public void setIdAperturaCajero(int idAperturaCajero) {
		this.idAperturaCajero = idAperturaCajero;
	}

	public int getIdCuadre() {
		return this.idCuadre;
	}

	public void setIdCuadre(int idCuadre) {
		this.idCuadre = idCuadre;
	}

	public int getIdEstadoArqueo() {
		return this.idEstadoArqueo;
	}

	public void setIdEstadoArqueo(int idEstadoArqueo) {
		this.idEstadoArqueo = idEstadoArqueo;
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}