package com.biblioteca.vista;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.biblioteca.controller.SocioController;

public class SocioControllerGUI extends JPanel{
	private SocioGUI vista;
	private SocioController controlador;
	
	public SocioControllerGUI() {
		this.vista = new SocioGUI();
		this.controlador = new SocioController();
		
		add(vista);
		
		iniciarVistaControlada();
		darAccionesBotones();
	}
	
	public void iniciarVistaControlada() {
		
		this.vista.getTable().setRowHeight(30); // para que los íconos se vean bien
		this.vista.getTable().getColumn("Acciones").setCellRenderer(new IconCellRendererEditor(this.vista.getTable(), controlador));
		this.vista.getTable().getColumn("Acciones").setCellEditor(new IconCellRendererEditor(this.vista.getTable(), controlador));
	}
	
	private void darAccionesBotones() {
		this.vista.getButtonNuevo().addActionListener(e -> { nuevoSocio(); });
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
	
	public Map<String, Object> buscarSocios() {
	    Map<String, Object> filtros = new HashMap<>();

	    /*if (!txtNombre.getText().isEmpty()) {
	        filtros.put("nombre", txtNombre.getText());
	    }
	    if (!txtApellido.getText().isEmpty()) {
	        filtros.put("apellido", txtApellido.getText());
	    }
	    if (!txtCorreo.getText().isEmpty()) {
	        filtros.put("correo", txtCorreo.getText());
	    }
	    if (!txtTelefono.getText().isEmpty()) {
	        filtros.put("nro_tel", txtTelefono.getText());
	    }
	    if (!txtDni.getText().isEmpty()) {
	        try {
	            filtros.put("dni", Integer.parseInt(txtDni.getText()));
	        } catch (NumberFormatException e) {
	            // Podés mostrar un mensaje de error al usuario
	        }
	    }
	    if (!txtId.getText().isEmpty()) {
	        try {
	            filtros.put("id", Integer.parseInt(txtId.getText()));
	        } catch (NumberFormatException e) {
	            // Validación también aquí
	        }
	    }*/
	    return filtros;
	    //ArrayList<Socio> resultado = socioDAO.buscarConFiltros(filtros);
	    //mostrarResultadoEnTabla(resultado);
	}
	
	public void nuevoSocio() {
		NuevoSocioDialog dialog = new NuevoSocioDialog((JFrame) SwingUtilities.getWindowAncestor(this), controlador);
        dialog.setVisible(true);
	}
}
