/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class InventarioRecibos extends javax.swing.JFrame {
    private Connection conexion;
    private boolean hacerVisible;
    private ArrayList<Integer> listaIDCosecha, listaIDCafe, listaIDProductor;
    private DefaultTableModel modelRecibos;
    /**
     * Creates new form Inventario
     */
    public InventarioRecibos() {
        initComponents();
    }
    public InventarioRecibos(Connection conexion) {
        initComponents();
        hacerVisible = true;
        this.conexion = conexion;
        listaIDCosecha = new ArrayList<>();
        listaIDCafe = new ArrayList<>();
        listaIDProductor = new ArrayList<>();
        modelRecibos = (DefaultTableModel) tabla_recibos.getModel();
        
        try {
            ResultSet cConsulta;
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            // Obtengo el listado de las Cosechas existentes
            cConsulta = sentencia.executeQuery("SELECT * FROM Cosecha");
            while (cConsulta.next()) {
                listaIDCosecha.add(cConsulta.getInt("Id"));
                cosecha.addItem(cConsulta.getString("Nombre"));
            }
            // Obtengo el listado de todos los tipos de Café Pergamino
            cConsulta = sentencia.executeQuery("SELECT Id, Nombre FROM Cafe WHERE Pergamino = 1");
            while (cConsulta.next()) {
                tipo_cafe.addItem(cConsulta.getString("Nombre")+" Pergamino");
                listaIDCafe.add(cConsulta.getInt("Id"));
            }
            // Obtengo el listado de todos los Productor
            cConsulta = sentencia.executeQuery("SELECT Id, Nombre FROM Productor");
            while (cConsulta.next()) {
                listaIDProductor.add(cConsulta.getInt("Id"));
                productor.addItem(cConsulta.getString("Nombre"));
            }
            
            panel_busqueda_avanzada.setVisible(false);
            this.setLocationRelativeTo(null);   // Para centrar esta ventana sobre la pantalla.
        } catch (SQLException ex) {
            hacerVisible = false;
            JOptionPane.showMessageDialog(this, "Error al intentar recuperar datos."+ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(InventarioRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tipo_cafe = new javax.swing.JComboBox<>();
        mostrar_inventario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_recibos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        saldo_total = new javax.swing.JTextField();
        panel_busqueda_avanzada = new javax.swing.JPanel();
        check_fecha = new javax.swing.JRadioButton();
        fecha_inicio = new com.toedter.calendar.JDateChooser();
        etiqueta_fecha_inicio = new javax.swing.JLabel();
        fecha_fin = new com.toedter.calendar.JDateChooser();
        etiqueta_fecha_fin = new javax.swing.JLabel();
        check_cosecha = new javax.swing.JRadioButton();
        cosecha = new javax.swing.JComboBox<>();
        productor = new javax.swing.JComboBox<>();
        check_productor = new javax.swing.JRadioButton();
        check_recibos_activos = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        ordenar_por = new javax.swing.JComboBox<>();
        check_busqueda_avanzada = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventario de Recibos");

        jLabel1.setText("Tipo de café:");

        mostrar_inventario.setText("Mostrar inventario");
        mostrar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_inventarioActionPerformed(evt);
            }
        });

        tabla_recibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Recibo No.", "Fecha", "Cosecha", "Café", "Productor", "Número de Envío", "Num. sacos de Nylon", "Num. sacos de Yuta", "Peso total", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_recibos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabla_recibos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Saldo total:");

        saldo_total.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldo_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        panel_busqueda_avanzada.setBackground(new java.awt.Color(204, 204, 255));

        check_fecha.setText("Fecha:");
        check_fecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_fechaItemStateChanged(evt);
            }
        });

        fecha_inicio.setDateFormatString("yyyy/MM/dd");
        fecha_inicio.setEnabled(false);

        etiqueta_fecha_inicio.setText("Inicio:");
        etiqueta_fecha_inicio.setEnabled(false);

        fecha_fin.setDateFormatString("yyyy/MM/dd");
        fecha_fin.setEnabled(false);

        etiqueta_fecha_fin.setText("Fin:");
        etiqueta_fecha_fin.setEnabled(false);

        check_cosecha.setText("Cosecha:");
        check_cosecha.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_cosechaItemStateChanged(evt);
            }
        });

        cosecha.setEnabled(false);

        productor.setEnabled(false);

        check_productor.setText("Productor:");
        check_productor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_productorItemStateChanged(evt);
            }
        });

        check_recibos_activos.setText("Recibos con Saldo = 0");

        jLabel3.setText("Ordenar por");

        ordenar_por.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saldo", "Cafe" }));

        javax.swing.GroupLayout panel_busqueda_avanzadaLayout = new javax.swing.GroupLayout(panel_busqueda_avanzada);
        panel_busqueda_avanzada.setLayout(panel_busqueda_avanzadaLayout);
        panel_busqueda_avanzadaLayout.setHorizontalGroup(
            panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busqueda_avanzadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_busqueda_avanzadaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ordenar_por, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_busqueda_avanzadaLayout.createSequentialGroup()
                        .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_productor)
                            .addComponent(check_cosecha)
                            .addComponent(check_fecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cosecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_busqueda_avanzadaLayout.createSequentialGroup()
                                .addComponent(etiqueta_fecha_inicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(etiqueta_fecha_fin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(check_recibos_activos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_busqueda_avanzadaLayout.setVerticalGroup(
            panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_busqueda_avanzadaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(check_fecha)
                        .addComponent(etiqueta_fecha_inicio))
                    .addComponent(fecha_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etiqueta_fecha_fin)
                        .addComponent(fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_cosecha)
                    .addComponent(cosecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_productor)
                    .addComponent(productor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(check_recibos_activos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_busqueda_avanzadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ordenar_por, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        check_busqueda_avanzada.setText("Búsqueda avanzada");
        check_busqueda_avanzada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_busqueda_avanzadaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldo_total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo_cafe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check_busqueda_avanzada))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_busqueda_avanzada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrar_inventario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(tipo_cafe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mostrar_inventario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_busqueda_avanzada))
                    .addComponent(panel_busqueda_avanzada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldo_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_inventarioActionPerformed
        modelRecibos.setRowCount(0);
        Calendar fechaI = fecha_inicio.getCalendar(), fechaF = fecha_fin.getCalendar();
        String fechaInicio = (fechaI!=null) ? ""+fechaI.get(Calendar.YEAR)+"-"+(fechaI.get(Calendar.MONTH)+1)+"-"+fechaI.get(Calendar.DAY_OF_MONTH) : "";
        String fechaFin = (fechaF!=null) ? ""+fechaF.get(Calendar.YEAR)+"-"+(fechaF.get(Calendar.MONTH)+1)+"-"+fechaF.get(Calendar.DAY_OF_MONTH) : "";
        // Siempre se dará que tipo_cafe.getSelectedIndex() != -1
        String instruccion = "SELECT Recibo.Codigo idRecibo, Recibo.Fecha, Cosecha.Nombre Cosecha, Cafe.Nombre Cafe, Productor.Nombre Productor, Recibo.NumEnvio, Recibo.SacosNylon, Recibo.SacosYuta, Recibo.Peso, Recibo.Saldo FROM Recibo ";
        instruccion+= "INNER JOIN Cosecha ON Recibo.Cosecha_Id = Cosecha.Id ";
        instruccion+= "INNER JOIN Cafe ON Recibo.Cafe_Id = Cafe.Id ";
        instruccion+= "INNER JOIN Productor ON Recibo.Productor_Id = Productor.Id ";
        instruccion+= "WHERE Recibo.Saldo "+(check_recibos_activos.isSelected()?"=":">")+" 0";
        if (check_busqueda_avanzada.isSelected()) {
            instruccion+= (check_fecha.isSelected()?" AND Fecha BETWEEN '"+fechaInicio+"' AND '"+fechaFin+"' ":"");
            instruccion+= (check_cosecha.isSelected()?" AND Cosecha.Id = "+listaIDCosecha.get(cosecha.getSelectedIndex()):"");
            instruccion+= (check_productor.isSelected()?" AND Productor.Id = "+listaIDProductor.get(productor.getSelectedIndex()):"");
        }
        instruccion+= " ORDER BY "+(String)ordenar_por.getSelectedItem();
        System.out.println("Instruccion = "+instruccion);
        try {
            float saldoTotal = 0.0f;
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            // Obtengo el listado de todos los recibos que concuerdan con la búsqueda
            ResultSet cConsulta = sentencia.executeQuery(instruccion);
            while (cConsulta.next()) {
                saldoTotal+= cConsulta.getFloat("Saldo");
                modelRecibos.addRow(new String[]{
                    ""+(tabla_recibos.getRowCount()+1),
                    cConsulta.getString("idRecibo"),
                    cConsulta.getString("Fecha"),
                    cConsulta.getString("Cosecha"),
                    cConsulta.getString("Cafe"),
                    cConsulta.getString("Productor"),
                    cConsulta.getString("NumEnvio"),
                    cConsulta.getString("SacosNylon"),
                    cConsulta.getString("SacosYuta"),
                    cConsulta.getString("Peso"),
                    cConsulta.getString("Saldo")
                });
            }
            // Muestra del Saldo total del Café seleccionado
            saldo_total.setText(""+saldoTotal);
        } catch (SQLException ex) {
            Logger.getLogger(InventarioRecibos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mostrar_inventarioActionPerformed

    private void check_busqueda_avanzadaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_busqueda_avanzadaItemStateChanged
        panel_busqueda_avanzada.setVisible(check_busqueda_avanzada.isSelected());
    }//GEN-LAST:event_check_busqueda_avanzadaItemStateChanged

    private void check_fechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_fechaItemStateChanged
        boolean selec = check_fecha.isSelected();
        etiqueta_fecha_inicio.setEnabled(selec);
        etiqueta_fecha_fin.setEnabled(selec);
        fecha_inicio.setEnabled(selec);
        fecha_fin.setEnabled(selec);
        if (selec)
            ordenar_por.addItem("Fecha");
        else
            ordenar_por.removeItem("Fecha");
    }//GEN-LAST:event_check_fechaItemStateChanged

    private void check_cosechaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_cosechaItemStateChanged
        cosecha.setEnabled(check_cosecha.isSelected());
        if (check_cosecha.isSelected())
            ordenar_por.addItem("Cosecha");
        else
            ordenar_por.removeItem("Cosecha");
    }//GEN-LAST:event_check_cosechaItemStateChanged

    private void check_productorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_productorItemStateChanged
        productor.setEnabled(check_productor.isSelected());
        if (check_productor.isSelected())
            ordenar_por.addItem("Productor");
        else
            ordenar_por.removeItem("Productor");
    }//GEN-LAST:event_check_productorItemStateChanged

    public boolean getHacerVisible() { return hacerVisible; }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventarioRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioRecibos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioRecibos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton check_busqueda_avanzada;
    private javax.swing.JRadioButton check_cosecha;
    private javax.swing.JRadioButton check_fecha;
    private javax.swing.JRadioButton check_productor;
    private javax.swing.JRadioButton check_recibos_activos;
    private javax.swing.JComboBox<String> cosecha;
    private javax.swing.JLabel etiqueta_fecha_fin;
    private javax.swing.JLabel etiqueta_fecha_inicio;
    private com.toedter.calendar.JDateChooser fecha_fin;
    private com.toedter.calendar.JDateChooser fecha_inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostrar_inventario;
    private javax.swing.JComboBox<String> ordenar_por;
    private javax.swing.JPanel panel_busqueda_avanzada;
    private javax.swing.JComboBox<String> productor;
    private javax.swing.JTextField saldo_total;
    private javax.swing.JTable tabla_recibos;
    private javax.swing.JComboBox<String> tipo_cafe;
    // End of variables declaration//GEN-END:variables
}
