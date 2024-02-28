package com.ayalait.terminal.controller;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.ayalait.terminal.util.Conexion;

public class Test {

	public static void main(String[] args) throws SQLException {
		Conexion con=new Conexion();
		Connection connection = con.getConexion();
        CallableStatement statement = null;
        try {
            System.out.println("> Conectado a la base de datos");
            //Preparamos la llamada a la rutina de la base de datos
            statement = connection.prepareCall("{?= call precio_venta(?)}");
            //Registra el tipo de dato de salida
            statement.registerOutParameter(1, Types.VARCHAR);
            //registra el tipo de entrada
            statement.setString(2, "07d2d7bd-e4a8-4870-a83f-afee457ad47e");
            //llama a la funcion
            statement.execute();
            //recoge resultado
            String output = statement.getString(1);
            System.out.println(output);
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

	}

}
