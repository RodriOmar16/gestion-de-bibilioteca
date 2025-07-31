package com.biblioteca.vista.socio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.biblioteca.controller.SocioController;
import com.biblioteca.model.Socio;

public class NuevoEditarSocioDialog extends JDialog{
	//Atributos
	private JTextField textNombre, textApellido, textEmail, textNroTel, textDni, textId;
	private JButton buttonGuardar, buttonCancelar;
	private JPanel panelPrincipal;
	private SocioController controller;
	private Socio socioOriginal;
	
	//Constructor
	public NuevoEditarSocioDialog(JFrame parent, SocioController controlador, Socio socio, String titulo) {
		super(parent, titulo + " Socio", true);
		this.controller    = controlador;
		this.socioOriginal = socio;
		
		setLayout(new BorderLayout());

		int row = titulo.equals("Editar") ? 7 : 6 ;
		
		this.panelPrincipal = new JPanel(new GridLayout(row, 2, 10, 10));
		this.panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
		
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
		if(row == 7) {
			this.panelPrincipal.add(new JLabel("Id:"));
	        textId = new JTextField(String.valueOf(socioOriginal.getId()));
	        textId.setEnabled(false);
	        this.panelPrincipal.add(textId);
		}
		
		this.panelPrincipal.add(new JLabel("Nombre:"));
        textNombre = new JTextField(row == 7 ? socioOriginal.getNombre() : "");
        this.panelPrincipal.add(textNombre);

        this.panelPrincipal.add(new JLabel("Apellido:"));
        textApellido = new JTextField(row == 7 ? socioOriginal.getApellido() : "");
        this.panelPrincipal.add(textApellido);
        
        this.panelPrincipal.add(new JLabel("Email:"));
        textEmail = new JTextField(row == 7 ? socioOriginal.getCorreo() : "");
        this.panelPrincipal.add(textEmail);
        
        this.panelPrincipal.add(new JLabel("Nro. Teléfono:"));
        textNroTel = new JTextField(row == 7 ? socioOriginal.getNroTel() : "");
        this.panelPrincipal.add(textNroTel);

        this.panelPrincipal.add(new JLabel("DNI:"));
        textDni = new JTextField(row == 7 ? String.valueOf(socioOriginal.getDni()) : "");
        this.panelPrincipal.add(textDni);

        buttonGuardar = new JButton(row == 7 ? "Guardar" : "Grabar");
        this.panelPrincipal.add(buttonGuardar);
        buttonGuardar.addActionListener(e -> { 
        	String accion = row == 7 ? "actualizar" : "grabar";
        	int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas "+accion+" este elemento?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
            	if(row == 7) guardarCambios();
            	else grabarSocio();
            }
        	return;
        });
        
        buttonCancelar = new JButton("Cancelar");
        this.panelPrincipal.add(buttonCancelar);
        buttonCancelar.addActionListener(e -> { dispose(); });
	}
    private void configGenerales(){
    	add(this.panelPrincipal, BorderLayout.CENTER);
		setPreferredSize(new Dimension(500, 350)); // más grande que los formularios regulares
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    
    public void guardarCambios() {
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
				
		socioOriginal.setNombre(textNombre.getText());
        socioOriginal.setApellido(textApellido.getText());
        socioOriginal.setCorreo(textEmail.getText());
        socioOriginal.setNroTel(textNroTel.getText());
        socioOriginal.setDni(Integer.parseInt(textDni.getText()));
        String res = controller.actualizarSocio(socioOriginal.getId(), socioOriginal.getNombre(), socioOriginal.getApellido(), socioOriginal.getCorreo(), socioOriginal.getNroTel(), socioOriginal.getDni());
        if(!res.isEmpty()) {
        	JOptionPane.showMessageDialog(null, res, "Advertencia", JOptionPane.INFORMATION_MESSAGE);
			return;
        }
        JOptionPane.showMessageDialog(null, "Socio modificado correctamente.", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
		dispose();
		return;
	}
}
