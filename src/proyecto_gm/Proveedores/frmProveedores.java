package proyecto_gm.Proveedores;

import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyecto_gm.Departamentos.Ubigeo;

public class frmProveedores extends javax.swing.JInternalFrame {

    private DatosProveedores datos = new DatosProveedores();
    private boolean esNuevo = false;
    private Proveedores proveedorActual;
    private frmListaProveedores frmLista;

    public frmProveedores(frmListaProveedores frmLista) {
        initComponents();
        this.frmLista = frmLista;
        this.esNuevo = true;
        this.proveedorActual = new Proveedores();
        setTitle("Nuevo Proveedor");
        cargarDepartamentos();
        cargarEstadoProveedor();
        txtId.setEnabled(false);
    }

    public frmProveedores(frmListaProveedores frmLista, int idProveedor) {
        initComponents();
        this.frmLista = frmLista;
        this.esNuevo = false;
        setTitle("Editar Proveedor");
        cargarDepartamentos();
        cargarEstadoProveedor();
        cmbDepartamento.setSelectedIndex(-1);
        cmbprovincia.setModel(new DefaultComboBoxModel<>());
        cmbdistrito.setModel(new DefaultComboBoxModel<>());
        this.proveedorActual = datos.obtenerPorId(idProveedor);
        if (proveedorActual != null) {
            cargarDatosEnFormulario();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron los datos del proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

        txtId.setEnabled(false);

        if (!esNuevo) {
            cmbEstado.setSelectedItem(proveedorActual.getEstado());
        } else {
            cmbEstado.setSelectedIndex(0);
        }
    }

    private void cargarDepartamentos() {
        List<Ubigeo> lista = datos.listarDepartamentosUbigeo();
        DefaultComboBoxModel<Ubigeo> modelo = new DefaultComboBoxModel<>();
        for (Ubigeo u : lista) {
            modelo.addElement(u);
        }
        cmbDepartamento.setModel(modelo);
        cmbDepartamento.setSelectedIndex(-1);
    }

    private void cargarEstadoProveedor() {
        List<EstadoProveedor> lista = datos.listarEstadosProveedor();
        DefaultComboBoxModel<EstadoProveedor> modelo = new DefaultComboBoxModel<>();

        for (EstadoProveedor ep : lista) {
            modelo.addElement(ep);
        }

        cmbEstado.setModel(modelo);
        cmbEstado.setSelectedIndex(-1);
    }

    private void cargarDatosEnFormulario() {
        txtId.setText(String.valueOf(proveedorActual.getIdProveedor()));
        txtNombres.setText(proveedorActual.getNombres());
        txtDireccion.setText(proveedorActual.getDireccion());
        txtCorreo.setText(proveedorActual.getCorreo());
        txtTelefono.setText(proveedorActual.getTelefono());
        txtCelular.setText(proveedorActual.getCelular());
        txtRuc.setText(proveedorActual.getRuc());
        txtRubro.setText(proveedorActual.getRubro());

        // estado
        EstadoProveedor epSeleccionado = null;
        for (int i = 0; i < cmbEstado.getItemCount(); i++) {
            EstadoProveedor ep = cmbEstado.getItemAt(i);
            if (ep.getDescripcion().equals(proveedorActual.getEstado())) {
                epSeleccionado = ep;
                break;
            }
        }
        cmbEstado.setSelectedItem(epSeleccionado);

        // ubigeo
        String idUbigeo = proveedorActual.getIdUbigeo();
        if (idUbigeo == null || idUbigeo.length() != 6) {
            return;
        }

        String codDep = idUbigeo.substring(0, 2);
        String codProv = idUbigeo.substring(2, 4);
        String codDist = idUbigeo.substring(4, 6);

        // Departamento
        for (int i = 0; i < cmbDepartamento.getItemCount(); i++) {
            Ubigeo dep = cmbDepartamento.getItemAt(i);
            if (dep.getCodigo().startsWith(codDep)) {
                cmbDepartamento.setSelectedIndex(i);
                break;
            }
        }

        Ubigeo depSel = (Ubigeo) cmbDepartamento.getSelectedItem();
        if (depSel != null) {
            List<Ubigeo> provincias = datos.listarProvinciasUbigeo(depSel.getCodigo());
            DefaultComboBoxModel<Ubigeo> modeloProv = new DefaultComboBoxModel<>();
            for (Ubigeo p : provincias) {
                modeloProv.addElement(p);
            }
            cmbprovincia.setModel(modeloProv);

            for (int i = 0; i < cmbprovincia.getItemCount(); i++) {
                Ubigeo p = cmbprovincia.getItemAt(i);
                String codigo = p.getCodigo();
                if (codigo.length() >= 4 && codigo.substring(2, 4).equals(codProv)) {
                    cmbprovincia.setSelectedIndex(i);
                    break;
                }
            }
        }

        Ubigeo provSel = (Ubigeo) cmbprovincia.getSelectedItem();
        if (provSel != null) {
            List<Ubigeo> distritos = datos.listarDistritosUbigeo(codDep, codProv);
            DefaultComboBoxModel<Ubigeo> modeloDist = new DefaultComboBoxModel<>();
            for (Ubigeo d : distritos) {
                modeloDist.addElement(d);
            }
            cmbdistrito.setModel(modeloDist);

            for (int i = 0; i < cmbdistrito.getItemCount(); i++) {
                Ubigeo d = cmbdistrito.getItemAt(i);
                if (d.getCodigo().equals(idUbigeo)) {
                    cmbdistrito.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtRubro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbprovincia = new javax.swing.JComboBox<>();
        cmbdistrito = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("PROVEEDORES");

        jLabel1.setText("Id:");

        txtId.setNextFocusableComponent(txtNombres);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jLabel2.setText("Provincia:");

        txtNombres.setNextFocusableComponent(txtDireccion);

        jLabel3.setText("Dirección:");

        txtDireccion.setNextFocusableComponent(txtCorreo);

        jLabel4.setText("Correo:");

        txtCorreo.setNextFocusableComponent(txtTelefono);

        jLabel5.setText("Telefono:");

        txtTelefono.setNextFocusableComponent(txtRuc);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel6.setText("Ruc:");

        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        jLabel7.setText("Departamento:");

        cmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartamentoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombres:");

        txtRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRubroActionPerformed(evt);
            }
        });
        txtRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRubroKeyTyped(evt);
            }
        });

        jLabel9.setText("Rubro");

        jLabel10.setText("Estado:");

        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel11.setText("Celular");

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel12.setText("Distrito");

        cmbprovincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprovinciaActionPerformed(evt);
            }
        });

        cmbdistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbdistritoActionPerformed(evt);
            }
        });

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

        btnDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnDeshacer.setToolTipText("Cancelar");
        btnDeshacer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeshacer.setName("deshacer"); // NOI18N
        btnDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeshacerActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeshacer);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(9, 9, 9))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId)
                                    .addComponent(cmbDepartamento, 0, 119, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtCelular)
                                    .addComponent(cmbprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRubro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbdistrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(cmbprovincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbdistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbdistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbdistritoActionPerformed

    private void cmbprovinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprovinciaActionPerformed
        Ubigeo dep = (Ubigeo) cmbDepartamento.getSelectedItem();
        Ubigeo prov = (Ubigeo) cmbprovincia.getSelectedItem();

        if (dep == null || prov == null) {
            return;
        }

        String codDep = dep.getCodigo().length() >= 2 ? dep.getCodigo().substring(0, 2) : dep.getCodigo();
        String codProv = "";
        if (prov.getCodigo().length() >= 4) {
            codProv = prov.getCodigo().substring(2, 4);
        } else if (prov.getCodigo().length() >= 2) {
            codProv = prov.getCodigo().substring(0, 2);
        }

        List<Ubigeo> listaDist = datos.listarDistritosUbigeo(codDep, codProv);

        for (Ubigeo d : listaDist) {

        }

        DefaultComboBoxModel<Ubigeo> modeloDist = new DefaultComboBoxModel<>();
        for (Ubigeo u : listaDist) {
            modeloDist.addElement(u);
        }
        cmbdistrito.setModel(modeloDist);
        cmbdistrito.setSelectedIndex(-1);
    }//GEN-LAST:event_cmbprovinciaActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtRubroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRubroKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) || txtRubro.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtRubroKeyTyped

    private void txtRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRubroActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        Ubigeo dep = (Ubigeo) cmbDepartamento.getSelectedItem();
        if (dep == null) {
            return;
        }

        List<Ubigeo> provincias = datos.listarProvinciasUbigeo(dep.getCodigo());
        DefaultComboBoxModel<Ubigeo> modeloProv = new DefaultComboBoxModel<>();
        for (Ubigeo u : provincias) {
            modeloProv.addElement(u);
        }
        cmbprovincia.setModel(modeloProv);
        cmbprovincia.setSelectedIndex(-1);

        cmbdistrito.setModel(new DefaultComboBoxModel<>());
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        // TODO add your handling code here:
        if (txtRuc.getText().length() >= 11) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtTelefono.getText().length() >= 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (txtId.getText().length() >= 4) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void btnDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeshacerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnDeshacerActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombres.getText().trim().isEmpty() || txtRuc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Los campos Nombres y RUC son obligatorios.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        proveedorActual.setNombres(txtNombres.getText());
        proveedorActual.setDireccion(txtDireccion.getText());
        proveedorActual.setCorreo(txtCorreo.getText());
        proveedorActual.setTelefono(txtTelefono.getText());
        proveedorActual.setCelular(txtCelular.getText());
        proveedorActual.setRuc(txtRuc.getText());
        proveedorActual.setRubro(txtRubro.getText());

        EstadoProveedor ep = (EstadoProveedor) cmbEstado.getSelectedItem();
        if (ep != null) proveedorActual.setEstado(ep.getDescripcion());

        // Obtener los objetos seleccionados
        Ubigeo dep  = (Ubigeo) cmbDepartamento.getSelectedItem();
        Ubigeo prov = (Ubigeo) cmbprovincia.getSelectedItem();
        Ubigeo dist = (Ubigeo) cmbdistrito.getSelectedItem();

        // Extraer correctamente el código de 2 dígitos
        String codDep  = dep  != null ? dep.getCodigo().substring(0, 2) : "00";
        String codProv = prov != null ? prov.getCodigo().substring(prov.getCodigo().length() - 2) : "00";
        String codDist = dist != null ? dist.getCodigo().substring(dist.getCodigo().length() - 2) : "00";

        // Unión final: 6 dígitos exactos
        proveedorActual.setIdUbigeo(codDep + codProv + codDist);

        // Guardar
        boolean ok = esNuevo ? datos.insertar(proveedorActual) : datos.actualizar(proveedorActual);

        if (ok) {
            JOptionPane.showMessageDialog(this, esNuevo ? "Proveedor guardado." : "Proveedor actualizado.");
            frmLista.cargarTabla();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Ubigeo> cmbDepartamento;
    private javax.swing.JComboBox<EstadoProveedor> cmbEstado;
    private javax.swing.JComboBox<Ubigeo> cmbdistrito;
    private javax.swing.JComboBox<Ubigeo> cmbprovincia;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRubro;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

}
