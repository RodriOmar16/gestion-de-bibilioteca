package com.biblioteca.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import com.biblioteca.dao.LibroDAO;
import com.biblioteca.model.Libro;
//import com.biblioteca.vista.socio.NuevoEditarSocioDialog;

import interfaces.AccionFilaController;

public class LibroController implements AccionFilaController{
	//Atributos
	private LibroDAO libroDAO;
	
	//Constructor
	public LibroController() {
		this.libroDAO = new LibroDAO();
	}
	
	@Override
	public Object obtenerEntidadPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarEntidad(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void abrirEditor(JFrame parent, Object entidad) {
		// TODO Auto-generated method stub
		
	}

}
