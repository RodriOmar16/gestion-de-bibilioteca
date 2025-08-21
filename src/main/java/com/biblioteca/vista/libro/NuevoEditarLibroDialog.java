package com.biblioteca.vista.libro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import com.biblioteca.controller.LibroController;
import com.biblioteca.model.Libro;

public class NuevoEditarLibroDialog extends JDialog{
	private String titulo;
	private JTextField textId, textNombre, textAutores, textGenero;
	private JLabel labelId, labelNombre, labelAutores, labelGenero;
	private JButton buttonGuardar, buttonCancelar;
	private JPanel panelPrincipal;
	private LibroController controller;
	private Libro libroOriginal;
	
	public NuevoEditarLibroDialog(JFrame parent, LibroController controlador, Libro libro, String titulo) {
		super(parent, titulo + " Libro", true);
		this.titulo        = titulo;
		this.controller    = controlador;
		this.libroOriginal = libro;
		setLayout(new BorderLayout());
		
		int row = titulo.equals("Editar")? 5 : 4;
		this.panelPrincipal = new JPanel(new GridLayout(row,2,10,10));
		this.panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));
		
		armarDialog(row);
		configGenerales();
		
		pack();
		setLocationRelativeTo(parent);
	}
	
	private boolean esInteger(String entrada) {
	    try {
	        Integer.parseInt(entrada);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private boolean esDouble(String entrada) {
	    try {
	        Double.parseDouble(entrada);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private void armarDialog(int row){
		if(row == 5) {
			this.labelId = new JLabel("Id:");
			this.panelPrincipal.add(this.labelId);
			this.textId = new JTextField(String.valueOf(this.libroOriginal.getId()));
			this.textId.setEnabled(false);
			this.panelPrincipal.add(this.textId);
		}
		this.labelNombre  = new JLabel("Nombre:");
		this.labelAutores = new JLabel("Autores:");
		this.labelGenero  = new JLabel("Genero");
		
		this.panelPrincipal.add(this.labelNombre);
		this.textNombre = new JTextField(row == 5 ? this.libroOriginal.getNombre() : "");
		this.panelPrincipal.add(this.textNombre);
		
		this.panelPrincipal.add(this.labelAutores);
		this.textAutores = new JTextField(row == 5 ? this.libroOriginal.getAutor() : "");
		this.panelPrincipal.add(this.textAutores);
		
		this.panelPrincipal.add(this.labelGenero);
		this.textGenero = new JTextField(row == 5 ? this.libroOriginal.getGenero() : "");
		this.panelPrincipal.add(this.textGenero);
		
		this.buttonGuardar = new JButton(row == 5 ? "Guardar" : "Grabar");
		this.panelPrincipal.add(buttonGuardar);
		this.buttonGuardar.addActionListener(e -> {
			String accion = row == 5 ? "actualizar" : "grabar";
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas "+accion+" este elemento?", "Confirmar", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
            	if(row == 5) guardarCambios();
            	else grabarSocio();
            }
        	return;
		});
	}
	private void configGenerales() {
		add(this.panelPrincipal, BorderLayout.CENTER);
		setPreferredSize(new Dimension(500,350));
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void guardarCambios() {
		if(this.textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Nombre del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	private void grabarSocio() {
		
	}
}
