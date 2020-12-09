package com.clearminds.ccgo.servicios;

import java.sql.SQLException;
import java.sql.Statement;

import com.clearminds.ccgo.bdd.ConexionBDD;
import com.clearminds.ccgo.dtos.Estudiante;
import com.clearminds.ccgo.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		Statement stmt = null;

		try {
			stmt = ConexionBDD.obtenerConexion().createStatement();
			String sql = "insert into estudiantes(nombre,apellido) values('" + estudiante.getNombre() + "' , '"
					+ estudiante.getApellido() + "')";
			
			System.out.println("Script: "+ sql);
			
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
		finally {
			cerrarConexion();
		}

	}
}
