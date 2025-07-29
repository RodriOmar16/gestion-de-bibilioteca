package com.biblioteca.vista;

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

public class IconCellRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JPanel panel;
    private JButton btnEditar, btnEliminar;
    private JTable tabla;
    private SocioController controlador;

    public IconCellRendererEditor(JTable tabla, SocioController controlador) {
        this.tabla = tabla;
        this.controlador = controlador;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        btnEditar = new JButton(new ImageIcon("src/main/resources/images/pencil.png"));
        btnEliminar = new JButton(new ImageIcon("src/main/resources/images/trash-can.png"));

        btnEditar.setBorder(null);
        btnEliminar.setBorder(null);
        btnEditar.setContentAreaFilled(false);
        btnEliminar.setContentAreaFilled(false);

        panel.add(btnEditar);
        panel.add(btnEliminar);

        /*btnEditar.addActionListener(e -> {
        	System.out.println("editar");
            int fila = tabla.getEditingRow();
            int id = (int) tabla.getValueAt(fila, 0);
            Socio socio = controlador.buscarSocio(id); // método que obtiene el socio completo
            if(socio == null) {
            	JOptionPane.showMessageDialog(null, "No se encontró el socio para poder editar", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
    			return;
            }
            EditarSocioDialog dialog = new EditarSocioDialog(id, (JFrame) SwingUtilities.getWindowAncestor(tabla), socio, controlador);
            dialog.setVisible(true);
            fireEditingStopped();
        });*/btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Botón presionado!");
            }
        });



        btnEliminar.addActionListener(e -> {
            int fila = tabla.getEditingRow();
            int id = (int) tabla.getValueAt(fila, 0);
            controlador.eliminarSocio(id); // método que vos definís
            ((DefaultTableModel) tabla.getModel()).removeRow(fila);
            fireEditingStopped();
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        return panel;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
                                                 int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}