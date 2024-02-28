package com.ayalait.terminal.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="aperturas_terminal")
@NamedQuery(name="AperturasTerminal.findAll", query="SELECT a FROM AperturasTerminal a")
public class AperturasTerminal  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_apertura_cajero")
	private int idAperturaCajero;

	@Column(name="fecha_baja")
	private String fechaBaja;

	@Column(name="fecha_hora")
	private String fechaHora;

	@Column(name="fecha_hora_cierre")
	private String fechaHoraCierre;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="hora_inicio")
	private String horaInicio;

	@Column(name="id_apertura_dia")
	private String idAperturaDia;

	@Column(name="id_caja")
	private int idCaja;

	@Column(name="id_tipo_arqueo")
	private int idTipoArqueo;

	@Column(name="id_turno")
	private int idTurno;

	@Column(name="id_usuario_alta")
	private int idUsuarioAlta;

	@Column(name="nro_consecutivo")
	private int nroConsecutivo;

	@Column(name="id_usuario")
	private String idUsuario;

	@Column(name="id_sucursal")
	private int idSucursal;
	
	public AperturasTerminal() {
	}

	
	public int getIdAperturaCajero() {
		return idAperturaCajero;
	}


	public void setIdAperturaCajero(int idAperturaCajero) {
		this.idAperturaCajero = idAperturaCajero;
	}


	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public int getIdSucursal() {
		return idSucursal;
	}


	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
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

	public String getFechaHoraCierre() {
		return this.fechaHoraCierre;
	}

	public void setFechaHoraCierre(String fechaHoraCierre) {
		this.fechaHoraCierre = fechaHoraCierre;
	}

	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getIdAperturaDia() {
		return this.idAperturaDia;
	}

	public void setIdAperturaDia(String idAperturaDia) {
		this.idAperturaDia = idAperturaDia;
	}

	public int getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}

	public int getIdTipoArqueo() {
		return this.idTipoArqueo;
	}

	public void setIdTipoArqueo(int idTipoArqueo) {
		this.idTipoArqueo = idTipoArqueo;
	}

	public int getIdTurno() {
		return this.idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public int getIdUsuarioAlta() {
		return this.idUsuarioAlta;
	}

	public void setIdUsuarioAlta(int idUsuarioAlta) {
		this.idUsuarioAlta = idUsuarioAlta;
	}

	public int getNroConsecutivo() {
		return this.nroConsecutivo;
	}

	public void setNroConsecutivo(int nroConsecutivo) {
		this.nroConsecutivo = nroConsecutivo;
	}

}