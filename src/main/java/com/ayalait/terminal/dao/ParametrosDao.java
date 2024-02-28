package com.ayalait.terminal.dao;

import java.util.List;

import com.ayalait.terminal.modelo.*;

public interface ParametrosDao {
	
	List<Caja> obtenerCaja();
	
	Caja obtenerDatosCajaIP(String ip);
	
	List<TipoCuadre> obtenerTipoCuadreCaja();
	
	List<TipoArqueo> obtenerTipoArqueo();
	
	List<Turnos> obtenerTurnos();
	
	List<Billetes> obtenerBilletes();
	
	List<Configuraciones> cargarConfiguraciones();

	List<VentasEstados> obtenerEstadosVentas();

	List<VentasCausaDevueltos> obtenerVentasCausasDevueltos();
	
	List<FormasCobro> listadoFormasCobros();

}
