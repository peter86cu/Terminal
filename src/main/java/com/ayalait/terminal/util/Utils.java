package com.ayalait.terminal.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Utils {
	
	
public static int precioVentaProducto(String id) throws SQLException {
	Conexion con=new Conexion();
	Connection connection = con.getConexion();
    CallableStatement statement = null;
    int precio=0;
    try {
        //Preparamos la llamada a la rutina de la base de datos
        statement = connection.prepareCall("{?= call precio_venta(?)}");
        //Registra el tipo de dato de salida
        statement.registerOutParameter(1, Types.VARCHAR);
        //registra el tipo de entrada
        statement.setString(2, id);
        //llama a la funcion
        statement.execute();
        //recoge resultado
         precio = statement.getInt(1);
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());            
    } finally {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    return precio;
}



public static int ejecutarFuncion(String id) throws SQLException {
	Conexion con=new Conexion();
	Connection connection = con.getConexion();
    CallableStatement statement = null;
    int precio=0;
    try {
        //Preparamos la llamada a la rutina de la base de datos
        statement = connection.prepareCall("{?= call precio_venta(?)}");
        //Registra el tipo de dato de salida
        statement.registerOutParameter(1, Types.VARCHAR);
        //registra el tipo de entrada
        statement.setString(2, id);
        //llama a la funcion
        statement.execute();
        //recoge resultado
         precio = statement.getInt(1);
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());            
    } finally {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    return precio;
}

public static int monedaProducto(String id) throws SQLException {
	Conexion con=new Conexion();
	Connection connection = con.getConexion();
    CallableStatement statement = null;
    int precio=0;
    try {
        
        //Preparamos la llamada a la rutina de la base de datos
        statement = connection.prepareCall("{?= call get_moneda_producto(?)}");
        //Registra el tipo de dato de salida
        statement.registerOutParameter(1, Types.VARCHAR);
        //registra el tipo de entrada
        statement.setString(2, id);
        //llama a la funcion
        statement.execute();
        //recoge resultado
         precio = statement.getInt(1);
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());            
    } finally {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    return precio;
}

}
