package com.biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

import com.biblioteca.controller.SocioController;

public class NuevoSocioDialog extends JDialog{
	private JTextField textNombre, textApellido, textEmail, textNroTel, textDni, textId;
	private JLabel labelNombre, labelApellido, labelEmail, labelNroTel, labelDni, labelId;
	private JButton buttonGrabar, buttonCancelar;
	private JPanel panelPrincipal;
	private SocioController controller;
	
	public NuevoSocioDialog(JFrame parent, SocioController controlador) {
		super(parent, "Nuevo Socio", true);
		this.controller = controlador;
		setLayout(new BorderLayout());

		this.panelPrincipal = new JPanel(new GridLayout(6, 2, 15, 15));
		this.panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
		
		armarDialog();
		configGenelares();
		pack();
        setLocationRelativeTo(parent); // centrado

	}
	
	private void armarDialog() {
		labelNombre  = new JLabel("Nombre");
		this.panelPrincipal.add(labelNombre);
		textNombre	 = new JTextField();
		this.panelPrincipal.add(textNombre);
		
		labelApellido  = new JLabel("Apellido");
		this.panelPrincipal.add(labelApellido);
		textApellido = new JTextField();
		this.panelPrincipal.add(textApellido);
		
		labelEmail  = new JLabel("Email");
		this.panelPrincipal.add(labelEmail);
		textEmail 	= new JTextField();
		this.panelPrincipal.add(textEmail);
		
		labelNroTel  = new JLabel("Nro. Telefono");
		this.panelPrincipal.add(labelNroTel);
		textNroTel 	 = new JTextField(); 
		this.panelPrincipal.add(textNroTel);
		
		labelDni  = new JLabel("Documento");
		this.panelPrincipal.add(labelDni);
		textDni   = new JTextField();
		this.panelPrincipal.add(textDni);
		
		buttonGrabar = new JButton("Grabar");
		buttonGrabar.addActionListener(e -> { grabarSocio(); });
		this.panelPrincipal.add(buttonGrabar);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(e -> { dispose(); });
		this.panelPrincipal.add(buttonCancelar);
		
		//this.panelPrincipal.setPreferredSize(new Dimension(300,200));
		//pack();
        //setLocationRelativeTo(parent);
	}
	
	public void configGenelares() {
		add(this.panelPrincipal, BorderLayout.CENTER);
		setPreferredSize(new Dimension(500, 350)); // más grande que los formularios regulares
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
	public void grabarSocio() {
		if(this.textNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Nombre del socio.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textApellido.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Apellido del socio.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Email del socio.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textNroTel.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Nro. de Teléfono del socio.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(this.textDni.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Documento del socio.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(!esInteger(this.textDni.getText())) {
			JOptionPane.showMessageDialog(null, "Se requiere ingresar Documento válido, sin puntos", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		System.out.println("Grabamos...");
		
		String res = this.controller.agregarNuevoSocio(this.textNombre.getText(), this.textApellido.getText(), this.textEmail.getText(), this.textNroTel.getText(), Integer.parseInt(this.textDni.getText()));
		if(res.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Socio creado correctamente.", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			return;
		}else { 
			JOptionPane.showMessageDialog(null, res, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return; 
		}
	}
}
