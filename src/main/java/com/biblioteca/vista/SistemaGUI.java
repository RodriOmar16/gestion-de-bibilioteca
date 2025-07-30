package com.biblioteca.vista;

import java.awt.CardLayout;

import javax.swing.*;

import com.biblioteca.vista.socio.SocioControllerGUI;

public class SistemaGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SistemaGUI() {
        setTitle("Sistema de Biblioteca");
        setSize(1368, 730);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        SocioControllerGUI socioGUI = new SocioControllerGUI();
        LibroGUI libroGUI = new LibroGUI();
        PrestamoGUI prestamoGUI = new PrestamoGUI();
        PanelHome home = new PanelHome();
        
        mainPanel.add(home, "Inicio");
        mainPanel.add(socioGUI, "Socio");
        mainPanel.add(libroGUI, "Libro");
        mainPanel.add(prestamoGUI, "Prestamo");

        JMenuBar menuBar = new JMenuBar();
        JMenu menuInicio = new JMenu("Inicio");
        JMenu menuSocios = new JMenu("Socios");
        JMenu menuLibros = new JMenu("Libros");
        JMenu menuPrestamos = new JMenu("Prestamos");

        JMenuItem homeItem = new JMenuItem("Ir a Inicio");
        homeItem.addActionListener(e -> cardLayout.show(mainPanel, "Inicio"));
        menuInicio.add(homeItem);
        
        JMenuItem socioItem = new JMenuItem("Ver Socios");
        socioItem.addActionListener(e -> cardLayout.show(mainPanel, "Socio"));
        menuSocios.add(socioItem);

        JMenuItem libroItem = new JMenuItem("Ver Libros");
        libroItem.addActionListener(e -> cardLayout.show(mainPanel, "Libro"));
        menuLibros.add(libroItem);

        JMenuItem prestamoItem = new JMenuItem("Ver Prestamos");
        prestamoItem.addActionListener(e -> cardLayout.show(mainPanel, "Prestamo"));
        menuPrestamos.add(prestamoItem);

        menuBar.add(menuInicio);
        menuBar.add(menuSocios);
        menuBar.add(menuLibros);
        menuBar.add(menuPrestamos);
        
        setJMenuBar(menuBar);
        add(mainPanel);

        setVisible(true);
    }
}