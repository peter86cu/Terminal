package com.ayalait.terminal.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Temp {

	public static void main(String[] args) {
		Conexion con=new Conexion();
		Connection connection = con.getConexion();
	    CallableStatement statement = null;
	    int precio=0;
	    try {
	        //Preparamos la llamada a la rutina de la base de datos
	        statement = connection.prepareCall("{?= call actualizarTransaccionTarjetaVenta(?,?)}");
	        //Registra el tipo de dato de salida
	        //statement.registerOutParameter(1, Types.VARCHAR);
	        //registra el tipo de entrada
	        statement.setInt(1,37 );
	        statement.setInt(2,37 );
	        //llama a la funcion
	        statement.execute();
	        //recoge resultado
	         //precio = statement.getInt(1);
	    } catch (SQLException ex) {
	        System.err.println(ex.getMessage());            
	    } 

	}
	
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

}
