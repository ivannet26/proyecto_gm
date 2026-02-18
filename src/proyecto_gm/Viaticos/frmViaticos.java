package proyecto_gm.Viaticos;

import javax.swing.*;
import proyecto_gm.Empleado.Empleados;
import proyecto_gm.Periodos.Periodos;
import proyecto_gm.Empleado.DatosEmpleados;
import proyecto_gm.Periodos.DatosPeriodo;
import proyecto_gm.Utilitario;
public class frmViaticos extends javax.swing.JInternalFrame {

    private Viaticos viatico;
    private frmListaViaticos frmLista;

    public frmViaticos(Viaticos v, frmListaViaticos frmLista) {
        initComponents();
        this.viatico = v;
        this.frmLista = frmLista;
        txtId.setEditable(false);

        llenarCombos();

        if (viatico != null) { // Editar
            txtId.setText(String.valueOf(viatico.getId()));
            txtDescripcion.setText(viatico.getDescripcion());
            txtPasaje.setText(String.valueOf(viatico.getPasaje()));
            txtMenu.setText(String.valueOf(viatico.getMenu()));
        }
    }

    private boolean validarCampos() {
    
    java.awt.Component[] componentes = getContentPane().getComponents();
    for (java.awt.Component c : componentes) {
        if (c instanceof javax.swing.JTextField) {
            JTextField txt = (JTextField) c;
            if (txt == txtId) {
                continue;}
            if (txt.getText().trim().isEmpty()) {
                String nombreCampo = txt.getName() != null ? txt.getName() : "campo";
                Utilitario.MostrarMensaje("El campo " + nombreCampo + " no puede estar vacío.", Utilitario.TipoMensaje.alerta);
                txt.requestFocus();
                return false;
            }}}
    if (cboEmpleado.getSelectedIndex() == -1) {
        Utilitario.MostrarMensaje("Debe seleccionar un empleado.", Utilitario.TipoMensaje.alerta);
        cboEmpleado.requestFocus();
        return false;}
    if (cboPeriodo.getSelectedIndex() == -1) {
        Utilitario.MostrarMensaje("Debe seleccionar un periodo.", Utilitario.TipoMensaje.alerta);
        cboPeriodo.requestFocus();
        return false;}
    return true; 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtMenu = new javax.swing.JTextField();
        cboPeriodo = new javax.swing.JComboBox<>();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPasaje = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);

        jLabel6.setText("MENÚ:");

        txtMenu.setName("menu"); // NOI18N
        txtMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMenuKeyTyped(evt);
            }
        });

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("DESCRIPCIÓN:");

        txtDescripcion.setName("descripcion"); // NOI18N
        txtDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescripcionFocusLost(evt);
            }
        });

        jLabel3.setText("PASAJE:");

        txtPasaje.setName("pasaje"); // NOI18N
        txtPasaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasajeKeyTyped(evt);
            }
        });

        jLabel5.setText("PERIODO:");

        jLabel7.setText("EMPLEADO:");

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

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiar.png"))); // NOI18N
        btnLimpiar.setToolTipText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimpiar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(txtId))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcion)
                            .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPasaje))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMenuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenuKeyTyped
        char c = evt.getKeyChar();
        String text = txtMenu.getText();

        if (!Character.isDigit(c) && c != '.') {
            evt.consume(); // Solo se permiten dígitos y punto
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Solo un punto decimal
        } else if (text.contains(".") && text.substring(text.indexOf(".") + 1).length() >= 2) {
            if (txtMenu.getCaretPosition() > text.indexOf(".")) {
                evt.consume(); // Solo dos decimales permitidos
            }
        }
    }//GEN-LAST:event_txtMenuKeyTyped

    private void txtDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionFocusLost
        // TODO add your handling code here:
        String text = txtDescripcion.getText().trim();
        txtDescripcion.setText(text);
    }//GEN-LAST:event_txtDescripcionFocusLost

    private void txtPasajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasajeKeyTyped
        char c = evt.getKeyChar();
        String text = txtPasaje.getText();

        if (!Character.isDigit(c) && c != '.') {
            evt.consume(); // Solo se permiten dígitos y punto
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Solo un punto decimal
        } else if (text.contains(".") && text.substring(text.indexOf(".") + 1).length() >= 2) {
            if (txtPasaje.getCaretPosition() > text.indexOf(".")) {
                evt.consume(); // Solo dos decimales permitidos
            }
        }
    }//GEN-LAST:event_txtPasajeKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if (!validarCampos()) return;

    if (viatico == null) viatico = new Viaticos();

    viatico.setDescripcion(txtDescripcion.getText());
    viatico.setPasaje(Float.parseFloat(txtPasaje.getText()));
    viatico.setMenu(Float.parseFloat(txtMenu.getText()));
    viatico.setIdEmpleado(((Empleados) cboEmpleado.getSelectedItem()).getId());
    viatico.setIdPeriodo(((Periodos) cboPeriodo.getSelectedItem()).getId());

    boolean exito;
    if (txtId.getText().isEmpty()) {
        exito = DatosViaticos.insertar(viatico);
        if (exito) Utilitario.MostrarMensaje("Registrado correctamente", Utilitario.TipoMensaje.informativo);
    } else {
        viatico.setId(Integer.parseInt(txtId.getText()));
        exito = DatosViaticos.actualizar(viatico);
        if (exito) Utilitario.MostrarMensaje("Actualizado correctamente", Utilitario.TipoMensaje.informativo);
    }

    if (exito) {
        frmLista.cargarDatos();
        limpiarCampos();
        dispose();
    } else {
        Utilitario.MostrarMensaje("Error al guardar los datos.", Utilitario.TipoMensaje.error);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        limpiarCampos();
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtDescripcion.setText("");
        txtPasaje.setText("");
        txtMenu.setText("");
        cboEmpleado.setSelectedIndex(-1);
        cboPeriodo.setSelectedIndex(-1);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed
    
    private void limpiarCampos() {
        txtId.setText("");
        txtDescripcion.setText("");
        txtPasaje.setText("");
        txtMenu.setText("");
        cboEmpleado.setSelectedIndex(-1);
        cboPeriodo.setSelectedIndex(-1);
    }
    
    private void llenarCombos() {
        cboEmpleado.removeAllItems();
        cboPeriodo.removeAllItems();

        DatosEmpleados datosEmpleado = new DatosEmpleados();
        DatosPeriodo datosPeriodo = new DatosPeriodo();

        // Llenar combo de empleados
        for (Empleados emp : datosEmpleado.listar()) {
            cboEmpleado.addItem(emp);
        }

        // Llenar combo de periodos
        for (Periodos per : DatosPeriodo.obtenerLista()) {
            cboPeriodo.addItem(per);
        }
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    public static javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Empleados> cboEmpleado;
    private javax.swing.JComboBox<Periodos> cboPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMenu;
    private javax.swing.JTextField txtPasaje;
    // End of variables declaration//GEN-END:variables
}
