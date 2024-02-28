package com.ayalait.terminal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayalait.terminal.modelo.*;

@Repository
public class ParametrosDaoImpl implements ParametrosDao {

	@Autowired
	CajaJpaSpring daoCaja;
	
	@Autowired
	TipoCuadreJpaSpring daoTipoCuadre;
	
	@Autowired
	TipoArqueoJpaSpring daoTipoArqueo;
	
	@Autowired
	TurnosJpaSpring daoTurnos;
	
	@Autowired
	BilletesJpaSpring daoBilletes;
	
	@Autowired
	ConfigJpaSpring daoConfig;

	@Autowired
	EstadosVentasJPA daoEstadoVenta;

	@Autowired
	VentasDevueltosJpaSpring daoVentasDevueltos;
	
	@Autowired
	FormaCobroJpaSpring daoFormasCobro;
	
	@Override
	public List<Caja> obtenerCaja() {
		return daoCaja.findAll();
	}

	@Override
	public Caja obtenerDatosCajaIP(String ip) {
		
		return daoCaja.obtenerDatosCajaIP(ip);
	}

	@Override
	public List<TipoCuadre> obtenerTipoCuadreCaja() {
		return daoTipoCuadre.findAll();
	}

	@Override
	public List<TipoArqueo> obtenerTipoArqueo() {
		
		return daoTipoArqueo.findAll();
	}

	@Override
	public List<Turnos> obtenerTurnos() {
		return daoTurnos.findAll();
	}

	@Override
	public List<Billetes> obtenerBilletes() {
		return daoBilletes.findAll();
	}

	@Override
	public List<Configuraciones> cargarConfiguraciones() {
		return daoConfig.findAll();
	}

	@Override
	public List<VentasEstados> obtenerEstadosVentas() {
		return daoEstadoVenta.findAll();
	}

	@Override
	public List<VentasCausaDevueltos> obtenerVentasCausasDevueltos() {
		return daoVentasDevueltos.findAll();
	}

	@Override
	public List<FormasCobro> listadoFormasCobros() {
		return daoFormasCobro.findAll();
	}

}
