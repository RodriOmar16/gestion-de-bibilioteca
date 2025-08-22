package com.biblioteca.vista.libro;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class LibroGUI extends JPanel{
	public LibroGUI() {
        initComponents();
    }
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelFiltros = new javax.swing.JPanel();
        labelId = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelAutor = new javax.swing.JLabel();
        textAutor = new javax.swing.JTextField();
        labelGenero = new javax.swing.JLabel();
        textGenero = new javax.swing.JTextField();
        buttonNuevo = new javax.swing.JButton(new ImageIcon("src/main/resources/images/plus.png"));
        buttonBuscar = new javax.swing.JButton();
        buttonLimpiar = new javax.swing.JButton(new ImageIcon("src/main/resources/images/broom.png"));
        panelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1368, 700));
        setSize(new java.awt.Dimension(1368, 700));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(1366, 700));

        panelFiltros.setPreferredSize(new java.awt.Dimension(1360, 180));

        labelId.setText("Id");

        labelNombre.setText("Nombre");

        labelAutor.setText("Autores");

        labelGenero.setText("Género");

        //buttonNuevo.setText("N");
        buttonNuevo.setBorder(null);
        buttonNuevo.setContentAreaFilled(false);
        buttonNuevo.setToolTipText("Nuevo libro");

        buttonBuscar.setText("Buscar");

        //buttonLimpiar.setText("L");
        buttonLimpiar.setBorder(null);
        buttonLimpiar.setContentAreaFilled(false);
        buttonLimpiar.setToolTipText("Limpiar filtros");

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelId))
                .addGap(40, 40, 40)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addGap(42, 42, 42)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAutor))
                .addGap(42, 42, 42)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGenero)
                    .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(buttonLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscar)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNuevo)
                .addGap(104, 104, 104))
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelFiltrosLayout.createSequentialGroup()
                                    .addComponent(labelGenero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelFiltrosLayout.createSequentialGroup()
                                    .addComponent(labelAutor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelFiltrosLayout.createSequentialGroup()
                                    .addComponent(labelId)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(buttonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonBuscar)
                            .addComponent(buttonLimpiar))))
                .addGap(70, 70, 70))
        );

        panelResultados.setPreferredSize(new java.awt.Dimension(1360, 508));

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Autor/es", "Género", "Acciones"}, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        // Solo la última columna ("Acciones") es editable
		        return column == 4;
		    }
		};
        
		tablaResultado.setModel(modelo);
		
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1259, 456));

        
        /*tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Autores", "Género"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });*/
        jScrollPane1.setViewportView(tablaResultado);

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelResultadosLayout.setVerticalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        setLayout(new BorderLayout()); // si no se define antes
        add(panelPrincipal, BorderLayout.CENTER);
        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();*/
    }// </editor-fold>  
	
	 // Variables declaration - do not modify                     
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextField textGenero;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNombre;
    // End of variables declaration           
}
