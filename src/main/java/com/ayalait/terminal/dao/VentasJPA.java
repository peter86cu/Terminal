package com.ayalait.terminal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.terminal.modelo.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VentasJPA extends JpaRepository<Ventas, Integer>{
//SELECT * FROM ventas  ORDER BY fecha_hora DESC LIMIT 10
@Query(value="SELECT * FROM ventas WHERE id_usuario =:id and estado<>1 ORDER BY fecha_hora DESC LIMIT 20", nativeQuery=true)
List<Ventas> obtener10UltimasVentasPorUsuario(@Param("id") String id);

    @Query(value="SELECT * FROM ventas where  estado<>1 ORDER BY fecha_hora DESC LIMIT 20", nativeQuery=true)
    List<Ventas> obtener10UltimasVentas();
    
    @Procedure(name = "actualizarTransaccionTarjetaVenta")
    void actualizarTransaccionTarjetaVenta(@Param("idVenta") int inputParam1, @Param("id_transaccion") String inputParam2);
}


