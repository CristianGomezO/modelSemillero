package com.clearmindsccgo.bdd.test;

import com.clearminds.ccgo.dtos.Estudiante;
import com.clearminds.ccgo.excepciones.BDDException;
import com.clearminds.ccgo.servicios.ServicioEstudiante;

public class TestServicio {
	public static void main(String[] args) {
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		
		try {
			srvEstudiante.insertarEstudiante(new Estudiante("Cristian", "Gómez", 18));
		} catch (BDDException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
