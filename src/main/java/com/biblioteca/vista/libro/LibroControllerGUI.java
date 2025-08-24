package com.biblioteca.vista.libro;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.biblioteca.controller.LibroController;
import com.biblioteca.model.Libro;
import com.biblioteca.vista.IconCellRendererEditor;

public class LibroControllerGUI extends JPanel{
	private LibroGUI vista;
	private LibroController controlador;
	
	public LibroControllerGUI() {
		this.vista = new LibroGUI();
		this.controlador = new LibroController();
		
		add(vista);
		
		iniciarVistaControlada();
		darAccionesBotones();
	}
	
	private void iniciarVistaControlada() {
		this.vista.getTableResultados().addMouseListener(
			new java.awt.event.MouseAdapter() {
			    @Override
			    public void mousePressed(java.awt.event.MouseEvent e) {
			        JTable table = vista.getTableResultados();
			        int row = table.rowAtPoint(e.getPoint());
			        int column = table.columnAtPoint(e.getPoint());

			        if (table.isCellEditable(row, column)) {
			            table.editCellAt(row, column);
			            Component editor = table.getEditorComponent();
			            if (editor != null) {
			                editor.requestFocus();
			            }
			        }
			    }
			}
		);
		this.vista.getTableResultados().setRowHeight(30); // para que los íconos se vean bien
		this.vista.getTableResultados().getColumn("Acciones").setCellRenderer(new IconCellRendererEditor(this.vista.getTableResultados(), controlador));
		this.vista.getTableResultados().getColumn("Acciones").setCellEditor(new IconCellRendererEditor(this.vista.getTableResultados(), controlador));
	}
	private void darAccionesBotones() {
		this.vista.getButtonNuevo().addActionListener(e -> { nuevoLibro(); });
		this.vista.getButtonBuscar().addActionListener(e -> { buscarLibro(); });
		this.vista.getButtonLimpiar().addActionListener(e -> { limpiar(); });
	}
	
	public boolean esInteger(String entrada) {
	    try {
	        Integer.parseInt(entrada);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	public boolean esDouble(String entrada) {
	    try {
	        Double.parseDouble(entrada);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	public Map<String, Object> armarMapFiltros() {
	    Map<String, Object> filtros = new HashMap<>();

	    if (!vista.getTextNombre().getText().isEmpty()) {
	        filtros.put("nombre", vista.getTextNombre().getText());
	    }
	    if (!vista.getTextAutor().getText().isEmpty()) {
	        filtros.put("autores", vista.getTextAutor().getText());
	    }
	    if (!vista.getTextGenero().getText().isEmpty()) {
	        filtros.put("genero", vista.getTextGenero().getText());
	    }
	    if (!vista.getTextId().getText().isEmpty()) {
	        filtros.put("id", vista.getTextId().getText());
	    }
	    return filtros;
	}
	
	public void limpiar() {
		this.vista.getTextNombre().setText("");
		this.vista.getTextAutor().setText("");
		this.vista.getTextGenero().setText("");
		this.vista.getTextId().setText("");		
	}
	public void nuevoLibro() {
		NuevoEditarLibroDialog dialog = new NuevoEditarLibroDialog((JFrame) SwingUtilities.getWindowAncestor(this), controlador, null, "Nuevo");
        dialog.setVisible(true);
	}
	public void buscarLibro() {
		ArrayList<Libro> libros = this.controlador.buscarLibro(armarMapFiltros());
		DefaultTableModel modelo = (DefaultTableModel) vista.getTableResultados().getModel();
		modelo.setRowCount(0);
		
		for(Libro l : libros) {
			modelo.addRow(
				new Object[] {
						l.getId(),
						l.getNombre(),
						l.getAutor(),
						l.getGenero(),
						""
				}
			);
		}
	}
}
