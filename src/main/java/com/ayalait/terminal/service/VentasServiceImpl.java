package com.ayalait.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.terminal.dao.*;
import com.ayalait.terminal.modelo.*;
import com.ayalait.terminal.util.Utils;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

	@Autowired
	VentasDao service;


	@Override
	public ResponseEntity<String> obtenerVentaPorId(int idVenta) {
		try {
			Ventas venta= service.obtenerVentaPorId(idVenta);
			if(venta!=null)
				return new ResponseEntity<String>(new Gson().toJson(venta),HttpStatus.OK);
			return new ResponseEntity<String>("Venta guardada.",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> addVentas(String venta) {
		try {
			System.out.println(venta);
			Ventas request = new Gson().fromJson(venta, Ventas.class);
			service.addVentas(request);
			return new ResponseEntity<String>("Venta guardada.",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> addDetalleVentas(String datos) {
		try {
			VentasDetalle request= new Gson().fromJson(datos, VentasDetalle.class);
			BigDecimal precioV = BigDecimal.valueOf(Utils.precioVentaProducto(request.getIdProducto()));
			request.setIdMonedaCompra(Utils.monedaProducto(request.getIdProducto()));
			request.setPrecioVenta(precioV);
			service.addDetalleVentas(request);
			return new ResponseEntity<String>("Datos guardado correctamente.",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> guardarVentasCobro(String datos) {
		try {
			VentasCobro request = new Gson().fromJson(datos, VentasCobro.class);
			service.guardarVentaCobro(request);
			return new ResponseEntity<String>("Datos guardado correctamente.",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> eliminarProductoVentaDetalle(int id) {
		try {
			service.eliminarProductoDetalleVenta(id);
			return new ResponseEntity<String>("Producto eliminado de los items.",HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> obtener10UltimasVentas(boolean acceso, String id) {
		try {
			List<Ventas> lstVentas= service.ultimas10Ventas(acceso,id);
			if(!lstVentas.isEmpty()){
				return new ResponseEntity<String>(new Gson().toJson(lstVentas),HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen ventas.",HttpStatus.BAD_REQUEST);
			}

		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);

		}
		}

	@Override
	public ResponseEntity<String> guardarDevolucionVenta(String datos) {
		try {
			service.addVentasDevolucion(datos);
			return new ResponseEntity<String>("Datos guardado correctamente.",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> actualizarTransaccionTarjeta(int idVenta, String datos) {				
		try {
			
			 service.actualizarTransaccionTarjetaVenta(idVenta, datos);
			return new ResponseEntity<String>("Venta actualizada con el id de transaccion tarjeta.",HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
