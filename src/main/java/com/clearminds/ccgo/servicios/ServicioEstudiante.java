package com.clearminds.ccgo.servicios;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.clearminds.ccgo.bdd.ConexionBDD;
import com.clearminds.ccgo.dtos.Estudiante;
import com.clearminds.ccgo.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase {

	String fechaActual = DateUtil.obtenerFecha(new Date());

	public void insertarEstudiante(Estudiante estudiante) throws BDDException {
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		Statement stmt = null;

		try {
			stmt = ConexionBDD.obtenerConexion().createStatement();
			String sql = "insert into estudiantes(nombre,apellido,edad, fecha_modificacion) values('"
					+ estudiante.getNombre() + "' , '" + estudiante.getApellido() + "' , '" + estudiante.getEdad()
					+ "' , '" + fechaActual + "')";

			System.out.println("Script: " + sql);

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		} finally {
			cerrarConexion();
		}
	}

	public void actualizarEstudiante(Estudiante estudiante) throws BDDException {

		abrirConexion();
		System.out.println("Actualizando estudiante: " + estudiante);
		Statement stmt = null;

		try {
			stmt = ConexionBDD.obtenerConexion().createStatement();
			String sql = " update estudiantes set nombre='" + estudiante.getNombre() + "' , apellido='"
					+ estudiante.getApellido() + "'" + " , edad= '" + estudiante.getEdad() + "'" + " where id= "
					+ estudiante.getId();

			System.out.println("Script: " + sql);

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar un estudiante");
		} finally {
			cerrarConexion();
		}
	}
}
