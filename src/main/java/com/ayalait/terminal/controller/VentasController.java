package com.ayalait.terminal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.terminal.service.*;

@RestController
public class VentasController {
    @Autowired
    VentasService service;

    @PostMapping(value = "ventas/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> guardarVenta(@RequestBody String datos) {

        return service.addVentas(datos);
    }

    @PostMapping(value = "ventas/detalles/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> guardarDetalleVenta(@RequestBody String datos) {

        return service.addDetalleVentas(datos);
    }

    @PostMapping(value = "ventas/cobro/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> guardarVentaCobro(@RequestBody String datos) {

        return service.guardarVentasCobro(datos);
    }

    @GetMapping(value = "venta", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> obtenerVentaPorId(@RequestParam("id") int id) {

        return service.obtenerVentaPorId(id);

    }


    @PostMapping(value = "venta/detalle/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> eliminarVentaDetalleProducto(@RequestParam("idVentaDetalle") int idVentaDetalle) {

        return service.eliminarProductoVentaDetalle(idVentaDetalle);

    }


    @PostMapping(value = "venta/10ultimas", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> ultimas10Ventas(@RequestParam("id") String idUsuario, @RequestParam("acceso") boolean acceso) {

        return service.obtener10UltimasVentas(acceso,idUsuario);

    }
    
    @PostMapping(value = "ventas/devolucion/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> guardarDevolucionVenta(@RequestBody String datos) {

        return service.guardarDevolucionVenta(datos);
    }
    
    @PostMapping(value = "venta/actualizar/transaccion", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> actualizarTransaccionTarjeta(@RequestParam("idVenta") int idVenta,@RequestParam("id_transaccion") String id_transaccion) {

        return service.actualizarTransaccionTarjeta(idVenta,id_transaccion);

    }

}
