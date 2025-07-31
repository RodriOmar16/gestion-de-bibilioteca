/*package com.biblioteca.vista;

import javax.swing.AbstractCellEditor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.biblioteca.controller.SocioController;
import com.biblioteca.model.Socio;
import com.biblioteca.vista.socio.NuevoEditarSocioDialog;

public class IconCellRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panel;
    private JTable tabla;
    private SocioController controlador;

    public IconCellRendererEditor(JTable tabla, SocioController controlador) {
        this.tabla = tabla;
        this.controlador = controlador;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        
        JButton btnEditar, btnEliminar;
        btnEditar = new JButton(new ImageIcon("src/main/resources/images/pencil.png"));
        btnEliminar = new JButton(new ImageIcon("src/main/resources/images/trash-can.png"));

        btnEditar.setBorder(null);
        btnEliminar.setBorder(null);
        
        btnEditar.setContentAreaFilled(false);
        btnEliminar.setContentAreaFilled(false);
        
        btnEditar.setToolTipText("Editar");
        btnEliminar.setToolTipText("Eliminar");
        
        panel.add(btnEditar);
        panel.add(btnEliminar);

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,int row, int column) {
    	
        JPanel panelEditor = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        
        JButton btnEditar = new JButton(new ImageIcon("src/main/resources/images/pencil.png"));
        JButton btnEliminar = new JButton(new ImageIcon("src/main/resources/images/trash-can.png"));
        
        btnEditar.setBorder(null);
        btnEliminar.setBorder(null);
        btnEditar.setContentAreaFilled(false);
        btnEliminar.setContentAreaFilled(false);

        btnEditar.setToolTipText("Editar");
        btnEliminar.setToolTipText("Eliminar");

        // Eventos por fila
        btnEditar.addActionListener(e -> {
            int id = (int) tabla.getValueAt(row, 0);
            Socio socio = controlador.buscarSocio(id);
            System.out.println("Socio: "+ socio);
            if (socio == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el socio para editar", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                return;
            } //else {
            NuevoEditarSocioDialog dialog = new NuevoEditarSocioDialog((JFrame) SwingUtilities.getWindowAncestor(tabla), controlador, socio, "Editar");
            dialog.setVisible(true);
            //}
            fireEditingStopped();
        	System.out.println("Editando...");
        });

        btnEliminar.addActionListener(e -> {
        	int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este socio?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        	if (respuesta == JOptionPane.YES_OPTION) {
        	    int id = (int) tabla.getValueAt(row, 0);
                String res = controlador.eliminarSocio(id);
                if(res.isEmpty()) {
                	if (tabla.isEditing()) {
                	    tabla.getCellEditor().stopCellEditing();
                	}
                	
                	if (row >= 0 && row < tabla.getRowCount()) {
                	    ((DefaultTableModel) tabla.getModel()).removeRow(row);
                	}
                	
                	fireEditingStopped();

                	System.out.println("Eliminando...");
                }
        	}
            
        });

        panelEditor.add(btnEditar);
        panelEditor.add(btnEliminar);

        return panelEditor;
    }
    @Override
    public Object getCellEditorValue() {
        return null;
    }
}*/
package com.biblioteca.vista;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import interfaces.AccionFilaController;

public class IconCellRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panelRender;
    private JTable tabla;
    private AccionFilaController controlador;

    public IconCellRendererEditor(JTable tabla, AccionFilaController controlador) {
        this.tabla = tabla;
        this.controlador = controlador;

        // Panel de renderizado (estático)
        panelRender = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JButton btnEditar = crearBoton("src/main/resources/images/pencil.png", "Editar");
        JButton btnEliminar = crearBoton("src/main/resources/images/trash-can.png", "Eliminar");

        panelRender.add(btnEditar);
        panelRender.add(btnEliminar);
    }

    private JButton crearBoton(String iconPath, String toolTip) {
        JButton boton = new JButton(new ImageIcon(iconPath));
        boton.setBorder(null);
        boton.setContentAreaFilled(false);
        boton.setToolTipText(toolTip);
        return boton;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return panelRender;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JPanel panelEditor = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JButton btnEditar = crearBoton("src/main/resources/images/pencil.png", "Editar");
        JButton btnEliminar = crearBoton("src/main/resources/images/trash-can.png", "Eliminar");

        btnEditar.addActionListener(e -> {
        	 int id = (int) tabla.getValueAt(row, 0);
             Object entidad = controlador.obtenerEntidadPorId(id);
             if (entidad == null) {
                 JOptionPane.showMessageDialog(null, "No se encontró el elemento para editar", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                 return;
             }
             JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(tabla);
             controlador.abrirEditor(parent, entidad);
             fireEditingStopped();
        });

        btnEliminar.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este elemento?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                int id = (int) tabla.getValueAt(row, 0);
                String res = controlador.eliminarEntidad(id);
                if (res.isEmpty()) {
                    ((DefaultTableModel) tabla.getModel()).removeRow(row);
                }
                fireEditingStopped();
            }
        });

        panelEditor.add(btnEditar);
        panelEditor.add(btnEliminar);
        return panelEditor;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}