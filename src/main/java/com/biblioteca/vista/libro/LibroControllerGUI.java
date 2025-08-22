package com.biblioteca.vista.libro;

import javax.swing.JPanel;

import com.biblioteca.controller.LibroController;

public class LibroControllerGUI extends JPanel{
	private LibroGUI vista;
	private LibroController controlador;
	
	public LibroControllerGUI() {
		this.vista = new LibroGUI();
		this.controlador = new LibroController();
		
		add(vista);
		
	}
}
