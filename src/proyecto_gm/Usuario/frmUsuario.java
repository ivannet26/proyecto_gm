package proyecto_gm.Usuario;

import java.sql.CallableStatement;
import proyecto_gm.InterfazBase.frmMantenimientoBasico;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.util.List;
import proyecto_gm.Utilitario;
import proyecto_gm.ConexionBD;

/**
 *
 * @author sistemas
 */
public class frmUsuario extends frmMantenimientoBasico {
    private static frmUsuario instancia;
    public frmUsuario() {
        super();
        initComponents();
        inicializaComboPerfil();

        DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
        modelo.setRowCount(0);

        DatosUsuario.Mostrar(modelo);
        Limpiar();
        bloquearCampos(false);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
    }
    public static frmUsuario getInstancia() {
        if (instancia == null) {
            instancia = new frmUsuario();
        }
        return instancia;
    }

    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }
    

    private void inicializaComboPerfil() {

        List<String> listaNombresPerfiles = DatosUsuario.obtenerNombresPerfiles();

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (String nombrePerfil : listaNombresPerfiles) {
            modelo.addElement(nombrePerfil);
        }

        cboPerfil.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cboPerfil = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle(" Usuarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 0, -1, -1));

        jPanel2.setForeground(new java.awt.Color(102, 255, 0));

        jLabel4.setText("Estado");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        txtId.setEditable(false);

        jLabel2.setText("Username");

        jLabel3.setText("Contraseña");

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Contraseña", "Estado", "Perfil"
            }
        ));
        jScrollPane2.setViewportView(tblUsuario);

        jLabel8.setText("Perfil");

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setName("agregar"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.setName("editar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

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

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setName("deshacer"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtPass)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
        bloquearCampos(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String username = txtUsername.getText();
        String password = new String(txtPass.getPassword());
        String estado = cboEstado.getSelectedItem().toString();
        String estadoDB = estado.equals("Activo") ? "A" : "I";
        String nombrePerfil = (String) cboPerfil.getSelectedItem();
        String codPerfil = DatosUsuario.getCodigoPerfilPorNombre(nombrePerfil);
        String id = txtId.getText();

        if (id.isEmpty()) {
            try ( CallableStatement cstmt = ConexionBD.getConnection().prepareCall("{ CALL insertar_usuario(?, ?, ?, ?) }")) {
                cstmt.setString(1, username);
                cstmt.setString(2, password);
                cstmt.setString(3, estadoDB);
                cstmt.setString(4, codPerfil);
                cstmt.execute();
                Utilitario.MostrarMensaje("Usuario guardado correctamente", Utilitario.TipoMensaje.informativo);

                DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
                modelo.setRowCount(0);
                DatosUsuario.Mostrar(modelo);

                Limpiar();
                bloquearCampos(false);
                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(true);
            } catch (SQLException ex) {
                Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            }
        } else {
            try ( CallableStatement cstmt = ConexionBD.getConnection().prepareCall("{ CALL actualizar_usuario(?, ?, ?, ?, ?) }")) {
                cstmt.setInt(1, Integer.parseInt(id));
                cstmt.setString(2, username);
                cstmt.setString(3, password);
                cstmt.setString(4, estadoDB);
                cstmt.setString(5, codPerfil);
                cstmt.execute();

                Utilitario.MostrarMensaje("Datos actualizados correctamente", Utilitario.TipoMensaje.informativo);

                DefaultTableModel modelo = (DefaultTableModel) tblUsuario.getModel();
                modelo.setRowCount(0);
                DatosUsuario.Mostrar(modelo);

                Limpiar();
                bloquearCampos(false);
                btnGuardar.setEnabled(false);
                btnNuevo.setEnabled(true);
            } catch (SQLException ex) {
                Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblUsuario.getSelectedRow();
        if (fila >= 0) {
            String idUsuario = tblUsuario.getValueAt(fila, 0).toString();
            DatosUsuario.Eliminar(tblUsuario);
        } else {
            Utilitario.MostrarMensaje("Debe seleccionar un usuario para eliminar", Utilitario.TipoMensaje.alerta);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblUsuario.getSelectedRow();
        if (fila >= 0) {

            txtId.setText(tblUsuario.getValueAt(fila, 0).toString());
            txtUsername.setText(tblUsuario.getValueAt(fila, 1).toString());
            txtPass.setText(tblUsuario.getValueAt(fila, 2).toString());
            cboEstado.setSelectedItem(tblUsuario.getValueAt(fila, 3).toString());
            String nombrePerfil = tblUsuario.getValueAt(fila, 4).toString();
            cboPerfil.setSelectedItem(nombrePerfil);

            txtUsername.setEnabled(false);

            bloquearCampos(true);
            btnGuardar.setEnabled(true);
            btnNuevo.setEnabled(false);
        } else {
            Utilitario.MostrarMensaje("Debe seleccionar un usuario para editar", Utilitario.TipoMensaje.alerta);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
        bloquearCampos(true);
        txtId.setEnabled(false);
        txtUsername.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEstadoActionPerformed
    private void Limpiar() {
        txtId.setText("");
        txtUsername.setText("");
        txtPass.setText("");
        cboEstado.setSelectedIndex(0);
        cboPerfil.setSelectedIndex(0);
    }

    private void Habilitar(boolean habilitar) {
        txtUsername.setEnabled(habilitar);
        txtPass.setEnabled(habilitar);
        cboEstado.setEnabled(habilitar);
        cboPerfil.setEnabled(habilitar);
    }

    private void bloquearCampos(boolean habilitar) {
        txtId.setEnabled(false);
        txtUsername.setEnabled(false);
        txtPass.setEnabled(habilitar);
        cboEstado.setEnabled(habilitar);
        cboPerfil.setEnabled(habilitar);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
