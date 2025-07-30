package com.biblioteca.vista.socio;

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

import com.biblioteca.controller.SocioController;
import com.biblioteca.model.Socio;
import com.biblioteca.vista.IconCellRendererEditor;

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
		this.vista.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mousePressed(java.awt.event.MouseEvent e) {
		        JTable table = vista.getTable();
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
		});
		this.vista.getTable().setRowHeight(30); // para que los íconos se vean bien
		this.vista.getTable().getColumn("Acciones").setCellRenderer(new IconCellRendererEditor(this.vista.getTable(), controlador));
		this.vista.getTable().getColumn("Acciones").setCellEditor(new IconCellRendererEditor(this.vista.getTable(), controlador));
	}
	
	private void darAccionesBotones() {
		this.vista.getButtonNuevo().addActionListener(e -> { nuevoSocio(); });
		this.vista.getButtonBuscar().addActionListener(e -> { buscarSocio(); });
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
	    if (!vista.getTextApellido().getText().isEmpty()) {
	        filtros.put("apellido", vista.getTextApellido().getText());
	    }
	    if (!vista.getTextEmail().getText().isEmpty()) {
	        filtros.put("email", vista.getTextEmail().getText());
	    }
	    if (!vista.getTextNroTel().getText().isEmpty()) {
	        filtros.put("nro_telefono", vista.getTextNroTel().getText());
	    }
	    if (!vista.getTextDni().getText().isEmpty()) {
	        try {
	            filtros.put("dni", Integer.parseInt(vista.getTextDni().getText()));
	        } catch (NumberFormatException e) {
	        }
	    }
	    if (!vista.getTextId().getText().isEmpty()) {
	        try {
	            filtros.put("id", Integer.parseInt(vista.getTextId().getText()));
	        } catch (NumberFormatException e) {
	        }
	    }
	    return filtros;
	}
	
	public void limpiar() {
		this.vista.getTextNombre().setText("");
		this.vista.getTextApellido().setText("");
		this.vista.getTextEmail().setText("");
		this.vista.getTextNroTel().setText("");
		this.vista.getTextDni().setText("");
		this.vista.getTextId().setText("");
		
	}
	public void nuevoSocio() {
		NuevoEditarSocioDialog dialog = new NuevoEditarSocioDialog((JFrame) SwingUtilities.getWindowAncestor(this), controlador, null, "Nuevo");
        dialog.setVisible(true);
	}
	public void buscarSocio() {
		if(!this.vista.getTextDni().getText().isEmpty() && !esInteger(this.vista.getTextDni().getText())) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Documento válido, sin puntos", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		ArrayList<Socio> socios = this.controlador.buscarSocios(armarMapFiltros());
		
		DefaultTableModel modelo = (DefaultTableModel) vista.getTable().getModel();
		modelo.setRowCount(0); // limpia todas las filas
		for (Socio s : socios) {
		    modelo.addRow(new Object[]{
		        s.getId(),               // ID
		        s.getNombre(),           // Nombre
		        s.getApellido(),         // Apellido
		        s.getCorreo(),           // Email
		        s.getNroTel(),           // Teléfono
		        s.getDni(),              // DNI
		        ""                       // Columna "Acciones" (vacía, el renderer la pinta)
		    });
		}
	}
}
