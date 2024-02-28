package com.ayalait.terminal.service;

import org.springframework.http.ResponseEntity;

public interface VentasService {

	ResponseEntity<String> obtenerVentaPorId(int idVenta);
	
	ResponseEntity<String> addVentas(String venta);
	
	ResponseEntity<String> addDetalleVentas(String datos);
	
	ResponseEntity<String> guardarVentasCobro(String datos);

	ResponseEntity<String> eliminarProductoVentaDetalle(int id);

	ResponseEntity<String> obtener10UltimasVentas(boolean acceso,String id);
	
	ResponseEntity<String> guardarDevolucionVenta(String datos);
	
	ResponseEntity<String> actualizarTransaccionTarjeta(int idVenta,String datos);

	
}
