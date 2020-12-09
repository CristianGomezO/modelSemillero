package com.clearminds.ccgo.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.ccgo.bdd.ConexionBDD;
import com.clearminds.ccgo.excepciones.BDDException;

public class ServicioBase {
	Connection conexion = null;

	public void abrirConexion() throws BDDException {
		conexion = ConexionBDD.obtenerConexion();
	}

	public void cerrarConexion() {

		try {
			if (conexion != null) {
				conexion.close();
				System.out.println("Conexión cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar la conexión");
		}
	}
}
