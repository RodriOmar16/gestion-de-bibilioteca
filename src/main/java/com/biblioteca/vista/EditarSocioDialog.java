package com.biblioteca.vista;

import javax.swing.JDialog;

import com.biblioteca.controller.SocioController;
import com.biblioteca.model.Socio;

import java.awt.GridLayout;

import javax.swing.*;

public class EditarSocioDialog extends JDialog {
    private JTextField txtNombre, txtApellido, txtDni;
    private JButton btnGuardar;
    private Socio socioOriginal;
    private SocioController controlador;

    public EditarSocioDialog(int id, JFrame parent, Socio socio, SocioController controlador) {
        super(parent, "Editar Socio", true);
        this.controlador = controlador;
        this.socioOriginal = socio;

        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(socio.getNombre());
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField(socio.getApellido());
        add(txtApellido);

        add(new JLabel("DNI:"));
        txtDni = new JTextField(socio.getDni());
        add(txtDni);

        btnGuardar = new JButton("Guardar");
        add(new JLabel()); // espacio vacío
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            socioOriginal.setNombre(txtNombre.getText());
            socioOriginal.setApellido(txtApellido.getText());
            socioOriginal.setDni(Integer.parseInt(txtDni.getText()));
            controlador.actualizarSocio(id, socioOriginal.getNombre(), socioOriginal.getApellido(), socioOriginal.getCorreo(), socioOriginal.getNroTel(), socioOriginal.getDni());
            dispose();
        });

        pack();
        setLocationRelativeTo(parent);
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
}