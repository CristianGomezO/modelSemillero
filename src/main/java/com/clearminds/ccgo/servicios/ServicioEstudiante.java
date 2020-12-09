package com.clearminds.ccgo.servicios;

import com.clearminds.ccgo.dtos.Estudiante;
import com.clearminds.ccgo.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase{
	
	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Insertando estudiante: " + estudiante);
		cerrarConexion();
	}
}
