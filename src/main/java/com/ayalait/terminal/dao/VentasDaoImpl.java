package com.ayalait.terminal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayalait.terminal.modelo.*;
import com.ayalait.terminal.vo.RequestVentaDevoluciones;
import com.google.gson.Gson;

import java.util.List;

@Repository
public class VentasDaoImpl implements VentasDao {

	
	@Autowired
	VentasJPA daoVentas;

	@Autowired
	VentasDetallesJPA daoDetalle;
	
	@Autowired
	VentasCobroJPA daoVentaC;
	
	@Autowired
	VentasDevolucionJPA daoDevolucion;
	
	@Autowired
	VentasProductosDevueltosJpaSpring daoDevoProductos;
	

	@Override
	public void addVentas(Ventas venta) {
		daoVentas.save(venta);
		
	}

	@Override
	public void addDetalleVentas(VentasDetalle detalle) {
		daoDetalle.save(detalle);
		
	}

	@Override
	public void guardarVentaCobro(VentasCobro venta) {
		daoVentaC.save(venta);
		
	}

	@Override
	public Ventas obtenerVentaPorId(int idVenta) {
		return daoVentas.findById(idVenta).orElse(null);
	}

	@Override
	public void eliminarProductoDetalleVenta(int idVentaDetalle) {
		daoDetalle.deleteById(idVentaDetalle);
	}

	@Override
	public List<Ventas> ultimas10Ventas(boolean acceso, String idUsuario) {
			if(acceso)
				return daoVentas.obtener10UltimasVentasPorUsuario(idUsuario);
				return daoVentas.obtener10UltimasVentas();
	}

	@Override
	public void addVentasDevolucion(String devolucion) {
		RequestVentaDevoluciones request= new Gson().fromJson(devolucion, RequestVentaDevoluciones.class);		
		daoDevolucion.save(request.getDevolucion());
		for(VentasProductosDevolucion productos: request.getLstProductos()) {
			daoDevoProductos.save(productos);
		}
		
	}

	@Override
	public void actualizarTransaccionTarjetaVenta(int idVenta, String id_transaccion) {
		daoVentas.actualizarTransaccionTarjetaVenta(idVenta, id_transaccion);
		
	}

	


}
