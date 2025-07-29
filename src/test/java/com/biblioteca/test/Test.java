package com.biblioteca.test;

import java.sql.Connection;

import com.biblioteca.db.BaseDeDatos;
import com.biblioteca.vista.SistemaGUI;

public class Test {

	public static void main(String[] args) {
		/*Connection conn = BaseDeDatos.getConexion();
        BaseDeDatos.cerrar();*/
		new SistemaGUI();
	}

}
