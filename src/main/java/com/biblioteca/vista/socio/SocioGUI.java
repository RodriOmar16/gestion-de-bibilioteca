package com.biblioteca.vista.socio;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class SocioGUI extends JPanel{
	public SocioGUI() {
		initComponents();
	}
	
	private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelFiltros = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        labelApellido = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        labelDni = new javax.swing.JLabel();
        textDni = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        labelNroTel = new javax.swing.JLabel();
        textNroTel = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        buttonNuevo = new javax.swing.JButton(new ImageIcon("src/main/resources/images/plus.png"));
        buttonLimpiar = new javax.swing.JButton(new ImageIcon("src/main/resources/images/broom.png"));
        panelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResultado = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1368, 700));
        setSize(new java.awt.Dimension(1368, 700));

        panelPrincipal.setPreferredSize(new java.awt.Dimension(1366, 700));

        panelFiltros.setPreferredSize(new java.awt.Dimension(1360, 180));

        labelNombre.setText("Nombre");
        
        textNombre.setPreferredSize(new java.awt.Dimension(64, 30));

        labelApellido.setText("Apellido");

        labelDni.setText("Documento");

        labelEmail.setText("Email");

        labelId.setText("Id");
        
        textID.setPreferredSize(new java.awt.Dimension(64, 30));

        labelNroTel.setText("Nro. Telefono");

        buttonBuscar.setText("Buscar");

        //buttonNuevo.setText("N");
        buttonNuevo.setBorder(null);
        buttonNuevo.setContentAreaFilled(false);
        
        //buttonLimpiar.setText("L");
        buttonLimpiar.setBorder(null);
        buttonLimpiar.setContentAreaFilled(false);
        buttonLimpiar.setToolTipText("Limpiar filtros");

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDni)
                    .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textDni, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(textID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(450, 450, 450)))
                        .addComponent(buttonLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscar))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApellido)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail))
                        .addGap(42, 42, 42)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNroTel)
                            .addComponent(textNroTel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(buttonNuevo)
                .addGap(138, 138, 138))
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNuevo)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelApellido))
                                .addComponent(labelEmail))
                            .addComponent(labelNroTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textNroTel)
                            .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDni))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonBuscar)
                            .addComponent(buttonLimpiar))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        /*javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDni)
                    .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textDni, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(textID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(398, 398, 398)))
                        .addComponent(buttonLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBuscar))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelApellido)
                            .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail))
                        .addGap(42, 42, 42)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNroTel)
                            .addComponent(textNroTel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(buttonNuevo)
                .addGap(138, 138, 138))
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNuevo)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelApellido))
                                .addComponent(labelEmail))
                            .addComponent(labelNroTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textNroTel)
                            .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelDni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDni))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonBuscar)
                            .addComponent(buttonLimpiar))))
                .addContainerGap(22, Short.MAX_VALUE))
        );*/

        panelResultados.setPreferredSize(new java.awt.Dimension(1360, 508));
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Apellido", "Email", "Teléfono", "DNI", "Acciones"}, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        // Solo la última columna ("Acciones") es editable
		        return column == 6;
		    }
		};
        tableResultado.setModel(modelo);
        
        jScrollPane1.setViewportView(tableResultado);
        if (tableResultado.getColumnModel().getColumnCount() > 0) {
            tableResultado.getColumnModel().getColumn(0).setResizable(false);
            tableResultado.getColumnModel().getColumn(5).setResizable(false);
            tableResultado.getColumnModel().getColumn(6).setResizable(false);
        };

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        setLayout(new BorderLayout()); // si no se define antes
        add(panelPrincipal, BorderLayout.CENTER);

        /*javax.swing.GroupLayout layout = new javax.swing.GroupLayout(/*getContentPane()panelPrincipalLayout);
        .setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );*/

    }// </editor-fold> 
	
	//JButton
	public javax.swing.JButton getButtonBuscar(){ return this.buttonBuscar; };
	public javax.swing.JButton getButtonNuevo() { return this.buttonNuevo; };
	public javax.swing.JButton getButtonLimpiar(){ return this.buttonLimpiar; }
	
	//JScrollPane
	public javax.swing.JScrollPane getScrollPane(){ return this.jScrollPane1; }
	
	//JTable
	javax.swing.JTable getTable(){ return this.tableResultado; }
	
	//JPanel
	public javax.swing.JPanel getPanelFiltros(){ return panelFiltros; }
	public javax.swing.JPanel getPrincipal()   { return panelPrincipal; }
	public javax.swing.JPanel getResultados()  { return panelResultados; }
	
	//JTextField
	public javax.swing.JTextField getTextApellido(){ return textApellido; }
	public javax.swing.JTextField getTextDni(){ return textDni; }
    public javax.swing.JTextField getTextEmail(){ return textEmail; }
    public javax.swing.JTextField getTextId(){ return textID; }
    public javax.swing.JTextField getTextNombre(){ return textNombre; }
    public javax.swing.JTextField getTextNroTel(){ return textNroTel; }
	
	// Variables declaration - do not modify                     
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResultado;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelDni;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNroTel;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textDni;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNroTel;
}
