package com.biblioteca.vista;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHome extends JPanel{
	private SistemaGUI sistema; 
	
	public PanelHome(SistemaGUI sistema) {
		this.sistema = sistema;
		armarPanel();
	}
	 private void armarPanel() {
        /*JButton btnSocios = new JButton("Socios");
        JButton btnLibros = new JButton("Libros");
        JButton btnPrestamos = new JButton("Préstamos");

        btnSocios.addActionListener(e -> sistema.mostrarVista("Socio"));
        btnLibros.addActionListener(e -> sistema.mostrarVista("Libro"));
        btnPrestamos.addActionListener(e -> sistema.mostrarVista("Prestamo"));

        add(btnSocios);
        add(btnLibros);
        add(btnPrestamos);*/
	 	panelPrincipal = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        buttonSocios = new javax.swing.JButton();
        buttonPrestamos = new javax.swing.JButton();
        buttonLibros = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1368, 700));
        setSize(new java.awt.Dimension(1368, 700));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(1366, 700));

        panelTitulo.setPreferredSize(new java.awt.Dimension(1368, 109));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setText("Bienvenido/a al Sistema de Gestión");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(486, 486, 486)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(labelTitulo)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        buttonSocios.setText("Socios");
        buttonSocios.setIcon(new ImageIcon("src/main/resources/images/users.png"));

        buttonPrestamos.setText("Prestamos");
        buttonPrestamos.setIcon(new ImageIcon("src/main/resources/images/prestamo.png"));

        buttonLibros.setText("Libros");
        buttonLibros.setIcon(new ImageIcon("src/main/resources/images/books.png"));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(557, 557, 557)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(buttonLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(buttonSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(buttonLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(buttonPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        setLayout(new BorderLayout()); // si no se define antes
        add(panelPrincipal, BorderLayout.CENTER);
        
        asignarAcciones();
    }
	
	public void asignarAcciones() {
		buttonSocios.addActionListener(e -> sistema.mostrarVista("Socio"));
		buttonLibros.addActionListener(e -> sistema.mostrarVista("Libro"));
		buttonPrestamos.addActionListener(e -> sistema.mostrarVista("Prestamo"));
	}
	
	private javax.swing.JButton buttonLibros;
    private javax.swing.JButton buttonPrestamos;
    private javax.swing.JButton buttonSocios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
}
