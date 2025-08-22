package com.biblioteca.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;

import com.biblioteca.dao.LibroDAO;
import com.biblioteca.model.Libro;
import com.biblioteca.vista.libro.NuevoEditarLibroDialog;

import interfaces.AccionFilaController;

public class LibroController implements AccionFilaController{
	//Atributos
	private LibroDAO libroDAO;
	
	//Constructor
	public LibroController() {
		this.libroDAO = new LibroDAO();
	}
	
	//Methods
	public String agregarNuevoLibro(Libro l, int cantidad/*,String nombre, String autores, String genero, int cantidad*/) {
		String res = "";
		//Libro l = new Libro(nombre,autores,genero);
		res = this.libroDAO.insertar(l, cantidad);		
		return res;
	}
	
	public String eliminarLibro(int id) {
		String res = this.libroDAO.eliminar(id);
		return res;
	}
	
	public String actualizarLibro(Libro l/*int id, String pNom, String pAutores, String pGenero, int cantidad*/) {
		String res = this.libroDAO.actualizar(l.getId(), l.getNombre(), l.getAutor(), l.getGenero(), l.getCantidad());
		return res;
	}
	
	public ArrayList<Libro> buscarLibro(Map<String, Object> filtros){
		return this.libroDAO.buscarConFiltros(filtros);
	}
	
	public Libro buscarLibro(int id) {
		return this.libroDAO.buscar(id);
	}
	
	@Override
	public Libro obtenerEntidadPorId(int id) {
		return buscarLibro(id);
	}

	@Override
	public String eliminarEntidad(int id) {
		return eliminarLibro(id);
	}

	@Override
	public void abrirEditor(JFrame parent, Object entidad) {
		Libro libro = (Libro) entidad;
		int cantidad = this.libroDAO.cantidadLibro(libro.getId());
		if(cantidad == -1) {
			System.out.println("Ocurrió un problema al obtener la cantidad.");
		}else {
			libro.setCantidad(cantidad);
		}
		NuevoEditarLibroDialog dialog = new NuevoEditarLibroDialog(parent, this, libro, "Editar"); 
		dialog.setVisible(true);
	}

}
