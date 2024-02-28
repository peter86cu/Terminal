package com.ayalait.terminal.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "apertura_dia")
public class AperturaCaja implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private String fechaapertura;
    private String fechacierre;
    private String usuario_apertura;
    private String usuario_cierre;
    private String estado;
   

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFechaapertura() {
		return fechaapertura;
	}
	public void setFechaapertura(String fechaapertura) {
		this.fechaapertura = fechaapertura;
	}
	public String getFechacierre() {
		return fechacierre;
	}
	public void setFechacierre(String fechacierre) {
		this.fechacierre = fechacierre;
	}
	
	
	
	public String getUsuario_apertura() {
		return usuario_apertura;
	}
	public void setUsuario_apertura(String usuario_apertura) {
		this.usuario_apertura = usuario_apertura;
	}
	public String getUsuario_cierre() {
		return usuario_cierre;
	}
	public void setUsuario_cierre(String usuario_cierre) {
		this.usuario_cierre = usuario_cierre;
	}
	public AperturaCaja() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


	
    
}
