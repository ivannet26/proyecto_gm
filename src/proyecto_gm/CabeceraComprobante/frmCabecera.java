package proyecto_gm.CabeceraComprobante;

import javax.swing.JOptionPane;
import javax.swing.JTable; 

public class frmCabecera extends javax.swing.JInternalFrame {
    
    boolean esNuevo;
    frmListarCabecera frmListar; // Referencia al formulario padre
    String numeroComprobanteOriginal; // Para guardar el ID original al editar

    // NUEVA VARIABLE para guardar la referencia a la tabla
    private JTable tablaPrincipal;
    
    public frmCabecera(frmListarCabecera frmListar, boolean esNuevo, CabeceraComprobante cab, JTable tabla) {
        initComponents();
        this.frmListar = frmListar;
        this.esNuevo = esNuevo;
        this.tablaPrincipal = tabla; 

        DatosCabeceraComprobante.CargarCombo(cboProveedores, cboTipoDocumento);

        if (esNuevo) {
            setTitle("AGREGAR NUEVO COMPROBANTE");
            txtNumeroFactura.setEditable(true);
        } else {
            setTitle("EDITAR COMPROBANTE");
            this.numeroComprobanteOriginal = cab.getNumeroComprobante();
            cargarDatos(cab);
            txtNumeroFactura.setEditable(false); 
        }
    }


    private void cargarDatos(CabeceraComprobante cab) {
        txtNumeroFactura.setText(cab.getNumeroComprobante());
        txtFechaEmision.setText(cab.getFechaEmision());
        txtFechaVencimiento.setText(cab.getFechaVencimiento());
        txtSubTotal.setText(String.valueOf(cab.getSubTotal())); 
        txtIgv.setText(String.valueOf(cab.getIgv()));
        txtTotal.setText(String.valueOf(cab.getTotal()));
        cboProveedores.setSelectedItem(cab.getIdProveedores()); 
        cboTipoDocumento.setSelectedItem(cab.getIdTipoDocumento());
    }
    
    private boolean validarCampos() {
        if (txtNumeroFactura.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Número de Comprobante no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            txtNumeroFactura.requestFocus();
            return false;
        }
        if (txtFechaEmision.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Fecha de Emisión no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            txtFechaEmision.requestFocus();
            return false;
        }
        if (txtSubTotal.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Sub Total no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            txtSubTotal.requestFocus();
            return false;
        }
        return true;
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroFactura = new javax.swing.JTextField();
        txtFechaEmision = new javax.swing.JTextField();
        txtFechaVencimiento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIgv = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboProveedores = new javax.swing.JComboBox<>();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();

        jLabel1.setText("Numero de Comprobante:");

        jLabel2.setText("Fecha de Emision:");

        jLabel3.setText("Fecha de Vencimiento:");

        txtFechaEmision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaEmisionKeyTyped(evt);
            }
        });

        txtFechaVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaVencimientoKeyTyped(evt);
            }
        });

        jLabel9.setText("Sub Total:");

        jLabel10.setText("Igv:");

        jLabel4.setText("Total:");

        txtSubTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalFocusLost(evt);
            }
        });
        txtSubTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSubTotalKeyTyped(evt);
            }
        });

        txtIgv.setEditable(false);

        txtTotal.setEditable(false);

        jLabel5.setText("Proveedores:");

        jLabel6.setText("Tipo de Documento");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setToolTipText("Cancelar");
        btnDeshacer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeshacer.setFocusable(false);
        btnDeshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel4))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipoDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaEmisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaEmisionKeyTyped
        char c = evt.getKeyChar();
        if (c == evt.VK_BACK_SPACE) {
            String fecha = txtFechaEmision.getText();
            int length = fecha.length();
            if (length > 0) {
                fecha = fecha.substring(0, length - 1);
                txtFechaEmision.setText(fecha);
            }
        } else if (!(Character.isDigit(c))) {
            evt.consume(); 
        }

        String fecha = txtFechaEmision.getText();
        int length = fecha.length();
        if (length == 2 || length == 5) { 
            fecha += "/";
            txtFechaEmision.setText(fecha);
        }

        if (length >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaEmisionKeyTyped

    private void txtFechaVencimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaVencimientoKeyTyped
        char c = evt.getKeyChar();
        if (c == evt.VK_BACK_SPACE) {
            String fecha = txtFechaVencimiento.getText();
            int length = fecha.length();
            if (length > 0) {
                fecha = fecha.substring(0, length - 1);
                txtFechaVencimiento.setText(fecha);
            }
        } else if (!(Character.isDigit(c))) {
            evt.consume();
        }

        String fecha = txtFechaVencimiento.getText();
        int length = fecha.length();
        if (length == 2 || length == 5) {
            fecha += "/";
            txtFechaVencimiento.setText(fecha);
        }

        if (length >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaVencimientoKeyTyped

    private void txtSubTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalFocusLost
         try {
            float subtotal = Float.parseFloat(txtSubTotal.getText());
            float igv = (float) (Math.round((subtotal * 0.18) * 100.0) / 100.0);
            txtIgv.setText(String.valueOf(igv));

            float total = subtotal + igv;
            txtTotal.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            // Manejar el caso en que el texto no sea un número válido
            txtIgv.setText("");
            txtTotal.setText("");
        }
    }//GEN-LAST:event_txtSubTotalFocusLost

    private void txtSubTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubTotalKeyTyped
        char c = evt.getKeyChar();
        String text = txtSubTotal.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); 
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); 
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume();
        } else if (text.equals("0") && c != '.') {
            evt.consume(); 
        }
    }//GEN-LAST:event_txtSubTotalKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validarCampos()) {
            String proveedor = cboProveedores.getSelectedItem().toString();
            String tipoDocumento = cboTipoDocumento.getSelectedItem().toString();
            
            CabeceraComprobante cab = new CabeceraComprobante(
                    txtNumeroFactura.getText(),
                    txtFechaEmision.getText(),
                    txtFechaVencimiento.getText(),
                    Float.parseFloat(txtSubTotal.getText()),
                    Float.parseFloat(txtIgv.getText()),
                    Float.parseFloat(txtTotal.getText()),
                    proveedor,
                    tipoDocumento
            );

            if (esNuevo) {
                DatosCabeceraComprobante.Insertar(cab, this.tablaPrincipal);
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DatosCabeceraComprobante.Actualizar(cab, this.tablaPrincipal);
                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDeshacerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboProveedores;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtFechaVencimiento;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumeroFactura;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
