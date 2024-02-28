package com.ayalait.terminal.dao;

import com.ayalait.terminal.modelo.*;
import com.ayalait.terminal.vo.RequestVentaDevoluciones;

import java.util.List;

public interface VentasDao {
	
	void addVentas(Ventas venta);
	void addDetalleVentas(VentasDetalle detalle);
	void guardarVentaCobro(VentasCobro venta);
	Ventas obtenerVentaPorId(int idVenta);

	void eliminarProductoDetalleVenta(int idVentaDetalle);

	List<Ventas> ultimas10Ventas(boolean acceso,String idUsuario);

	void addVentasDevolucion(String devolucion);
	
	void actualizarTransaccionTarjetaVenta(int idVenta,String id_transaccion);



}
