package com.clearminds.ccgo.bdd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.clearminds.ccgo.excepciones.BDDException;

public class ConexionBDD {
	
	public static String leerPropiedad(String nombrePropiedad){
		Properties propiedades = new Properties();
		String valorPropiedad = "";
		try {
			propiedades.load(new FileInputStream("C:/Users/USER/Desktop/tallerSemillero/src/main/java/com/clearminds/ccgo/middleware/conexion.properties"));
			valorPropiedad = propiedades.getProperty(nombrePropiedad);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return valorPropiedad;
	}
	
	public static Connection obtenerConexion() throws BDDException{
		Connection conn = null;
		
		String usuario =  leerPropiedad("usuario");
		String password =  leerPropiedad("password");
		String urlConexion =  leerPropiedad("urlConexion");
		
		try {
			conn = DriverManager.getConnection(urlConexion, usuario, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la pase de datos");
		}
		return conn;
	}
}
