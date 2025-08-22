package com.biblioteca.vista.libro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import com.biblioteca.controller.LibroController;
import com.biblioteca.model.Libro;

public class NuevoEditarLibroDialog extends JDialog{
	private String titulo;
	private JTextField textId, textNombre, textAutores, textGenero, textCantidad;
	private JLabel labelId, labelNombre, labelAutores, labelGenero, labelCantidad;
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
		
		int row = titulo.equals("Editar")? 6 : 5;
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
		if(row == 6) {
			this.labelId = new JLabel("Id:");
			this.panelPrincipal.add(this.labelId);
			this.textId = new JTextField(String.valueOf(this.libroOriginal.getId()));
			this.textId.setEnabled(false);
			this.panelPrincipal.add(this.textId);
		}
		this.labelNombre  = new JLabel("Nombre:");
		this.labelAutores = new JLabel("Autores:");
		this.labelGenero  = new JLabel("Genero");
		this.labelCantidad  = new JLabel("Cantidad");
		
		this.panelPrincipal.add(this.labelNombre);
		this.textNombre = new JTextField(row == 6 ? this.libroOriginal.getNombre() : "");
		this.panelPrincipal.add(this.textNombre);
		
		this.panelPrincipal.add(this.labelAutores);
		this.textAutores = new JTextField(row == 6 ? this.libroOriginal.getAutor() : "");
		this.panelPrincipal.add(this.textAutores);
		
		this.panelPrincipal.add(this.labelGenero);
		this.textGenero = new JTextField(row == 6 ? this.libroOriginal.getGenero() : "");
		this.panelPrincipal.add(this.textGenero);
		
		this.panelPrincipal.add(this.labelCantidad);
		this.textCantidad = new JTextField(row == 6 ? String.valueOf(this.libroOriginal.getCantidad()) : "");
		this.panelPrincipal.add(this.textCantidad);
		
		this.buttonGuardar = new JButton(row == 6 ? "Guardar" : "Grabar");
		this.panelPrincipal.add(buttonGuardar);
		this.buttonGuardar.addActionListener(e -> {
			String accion = row == 5 ? "actualizar" : "grabar";
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas "+accion+" este elemento?", "Confirmar", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
            	if(row == 5) guardarCambios();
            	else grabarLibro();
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
		if(this.textAutores.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar al menos un Autor del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textGenero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar el género del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!esInteger(this.textCantidad.getText())) {
			JOptionPane.showMessageDialog(null, "Ingresar una cantidad vàlida para el Libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textCantidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar el género del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		this.libroOriginal.setNombre(this.textNombre.getText());
		this.libroOriginal.setAutor(this.textAutores.getText());
		this.libroOriginal.setGenero(this.textGenero.getText());
		this.libroOriginal.setCantidad(Integer.parseInt(this.textCantidad.getText()));
		
		String res = this.controller.actualizarLibro(this.libroOriginal/*this.libroOriginal.getId(), this.libroOriginal.getNombre(), this.libroOriginal.getAutor(), this.libroOriginal.getGenero(), this.libroOriginal.getCantidad()*/);
		if(!res.isEmpty()) {
        	JOptionPane.showMessageDialog(null, res, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
        }
		JOptionPane.showMessageDialog(null, "Libro modificado correctamente.", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		dispose();
		return;
	}
	private void grabarLibro() {
		if(this.textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Nombre del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textAutores.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar al menos un Autor del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textGenero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar el género del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textCantidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar el género del libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!esInteger(this.textCantidad.getText())) {
			JOptionPane.showMessageDialog(null, "Ingresar una cantidad válida para el Libro.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		this.libroOriginal.setNombre(this.textNombre.getText());
		this.libroOriginal.setAutor(this.textAutores.getText());
		this.libroOriginal.setGenero(this.textGenero.getText());
		this.libroOriginal.setCantidad(Integer.parseInt(this.textCantidad.getText()));
		
		String res = this.controller.agregarNuevoLibro(this.libroOriginal, Integer.parseInt(this.textCantidad.getText()));
		if(!res.isEmpty()) {
        	JOptionPane.showMessageDialog(null, res, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
        }
		JOptionPane.showMessageDialog(null, "Libro creado correctamente.", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		dispose();
		return;
	}
}
