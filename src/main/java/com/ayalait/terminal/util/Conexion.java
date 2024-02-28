package com.ayalait.terminal.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

	static String url;
	static String driver;

	static String userBD;
	static String passBD;

	public Conexion() {
		try {

			cargarServer();

		} catch (IOException var2) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, (String) null, var2);
		}
	}

	void cargarServer() throws IOException {
		Properties p = new Properties();

		try {

			URL url = this.getClass().getClassLoader().getResource("application.properties");
			if (url == null) {
				throw new IllegalArgumentException("application.properties" + " is not found 1");
			} else {
				InputStream propertiesStream = url.openStream();

				// InputStream propertiesStream =
				// ClassLoader.getSystemResourceAsStream("application.properties");
				p.load(propertiesStream);
				propertiesStream.close();
				this.userBD = p.getProperty("spring.datasource.username");
				this.passBD = p.getProperty("spring.datasource.password");
				this.url = p.getProperty("spring.datasource.url");
				this.driver = p.getProperty("spring.datasource.driver-class-name");
			}
		} catch (FileNotFoundException var3) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, (String) null, var3);
		}

	}

	public  Connection getConexion() {
		Connection con = null;

		try {
			Class.forName(driver);
			 con = DriverManager.getConnection(url, userBD, passBD);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	public static Connection getConexionFuncionMySQL() {
		Connection rs = null;

		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, userBD, passBD);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs;
	}

	public static int getUpdate(String consulta) {

		int retorno = 0;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, userBD, passBD);
			PreparedStatement stmt;
			stmt = con.prepareStatement(consulta);
			retorno = stmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return retorno;
	}

}