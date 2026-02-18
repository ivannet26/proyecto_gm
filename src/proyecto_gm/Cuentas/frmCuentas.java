package proyecto_gm.Cuentas;

import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class frmCuentas extends javax.swing.JInternalFrame {
    private Cuentas cuentaActual;
    private final frmListaCuentas frmLista; // Referencia al formulario de lista para poder refrescarlo
    private boolean esNuevo;

    public frmCuentas(Cuentas cuenta, frmListaCuentas frmLista) {
        initComponents();
        this.cuentaActual = cuenta;
        this.frmLista = frmLista;

        
        // Cargar combos
        DatosCuentas.cargarBancos(cboBanco);
        
        if (cuentaActual == null) {
            this.setTitle("Nueva Cuenta");
            esNuevo = true;
            try {
                // Generar y mostrar el nuevo ID
                txtId.setText(String.valueOf(DatosCuentas.generarNuevoId()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al generar ID: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                txtId.setText("Error");
            }
            txtId.setEnabled(false);
        } else {
            this.setTitle("Editar Cuenta");
            esNuevo = false;
            cargarDatos();
        }
    }

    private void cargarDatos() {
        txtId.setText(String.valueOf(cuentaActual.getIdCuenta()));
        txtId.setEnabled(false);
        txtNombres.setText(cuentaActual.getNombres());
        txtCCC.setText(cuentaActual.getNroCuenta());
        txtCCI.setText(cuentaActual.getNroCuentaInterbancaria());

        // Seleccionar Tipo Propietario
        String tipoPropietario = "P".equals(cuentaActual.getTipoPropietario()) ? "Persona Natural" : "Empresa";
        cboTipoPropietario.setSelectedItem(tipoPropietario);

        // Seleccionar Banco (Requiere que el objeto Banco tenga un `equals` bien implementado)
        for (int i = 0; i < cboBanco.getItemCount(); i++) {
            if (cboBanco.getItemAt(i).getId() == cuentaActual.getIdBanco()) {
                cboBanco.setSelectedIndex(i);
                break;
            }
        }

        // Seleccionar Moneda
        if ("S".equals(cuentaActual.getTipoMoneda())) {
            rbSoles.setSelected(true);
        } else {
            rbDolares.setSelected(true);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCCC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCCI = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTipoPropietario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboBanco = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        rbSoles = new javax.swing.JRadioButton();
        rbDolares = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel5.setText("Cuenta bancaria");

        txtCCC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCCCFocusLost(evt);
            }
        });
        txtCCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCCCKeyTyped(evt);
            }
        });

        jLabel7.setText("CCI");

        txtCCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCCIKeyTyped(evt);
            }
        });

        jLabel2.setText("Tipo Propietario:");

        cboTipoPropietario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));
        cboTipoPropietario.setFocusCycleRoot(true);

        jLabel4.setText("Banco:");

        jLabel6.setText("Moneda:");

        rbSoles.setText("Soles");
        rbSoles.setActionCommand("Soles");

        rbDolares.setText("Dólares");
        rbDolares.setActionCommand("Dólares");

        jLabel3.setText("Nombres:");

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnRegresar.setToolTipText("Cancelar");
        btnRegresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegresar.setName("cancelar"); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRegresar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboTipoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(46, 46, 46)
                            .addComponent(txtCCI))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCCC))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rbSoles)
                            .addGap(36, 36, 36)
                            .addComponent(rbDolares)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboTipoPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDolares)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(rbSoles)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        String texto = txtNombres.getText().trim();
        txtNombres.setText(texto);
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtCCCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCCCFocusLost
        String texto = txtCCC.getText().trim();
        txtCCC.setText(texto);
    }//GEN-LAST:event_txtCCCFocusLost

    private void txtCCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCCKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtCCC.getText().length() >= 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCCCKeyTyped

    private void txtCCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCIKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtCCI.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCCIKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // 1. Validar campos
        if (txtNombres.getText().trim().isEmpty() || txtCCC.getText().trim().isEmpty() || txtCCI.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtCCC.getText().trim().length() != 20) {
             JOptionPane.showMessageDialog(this, "El número de cuenta debe tener 14 dígitos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtCCI.getText().trim().length() != 25) {
             JOptionPane.showMessageDialog(this, "El CCI debe tener 20 dígitos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }


        // 2. Recolectar datos del formulario
        Cuentas cuentaParaGuardar = new Cuentas();
        cuentaParaGuardar.setIdCuenta(Integer.parseInt(txtId.getText()));
        cuentaParaGuardar.setNombres(txtNombres.getText().trim());
        cuentaParaGuardar.setNroCuenta(txtCCC.getText().trim());
        cuentaParaGuardar.setNroCuentaInterbancaria(txtCCI.getText().trim());

        Banco bancoSeleccionado = (Banco) cboBanco.getSelectedItem();
        cuentaParaGuardar.setIdBanco(bancoSeleccionado.getId());

        String tipoPropietario = "Persona Natural".equals(cboTipoPropietario.getSelectedItem().toString()) ? "P" : "E";
        cuentaParaGuardar.setTipoPropietario(tipoPropietario);

        String tipoMoneda = rbSoles.isSelected() ? "S" : "D";
        cuentaParaGuardar.setTipoMoneda(tipoMoneda);

        // 3. Decidir si insertar o actualizar
        try {
            if (esNuevo) {
                DatosCuentas.insertar(cuentaParaGuardar);
                JOptionPane.showMessageDialog(this, "Cuenta registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DatosCuentas.actualizar(cuentaParaGuardar);
                JOptionPane.showMessageDialog(this, "Cuenta actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

            // 4. Actualizar la tabla del formulario de lista y cerrar este formulario
            frmLista.cargarDatosTabla();
            this.dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Banco> cboBanco;
    private javax.swing.JComboBox<String> cboTipoPropietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rbDolares;
    private javax.swing.JRadioButton rbSoles;
    private javax.swing.JTextField txtCCC;
    private javax.swing.JTextField txtCCI;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
