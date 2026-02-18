package proyecto_gm.Transferencias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import proyecto_gm.Cuentas.Cuentas;
import proyecto_gm.Periodos.Periodos;

public class frmTransferencias extends javax.swing.JInternalFrame {
    
    boolean esNuevo;
    Transferencia transferenciaActual;
    frmListaTransferencias frmLista;

    public frmTransferencias(frmListaTransferencias parent, Transferencia transf) {
        initComponents();
        this.frmLista = parent;
        this.transferenciaActual = transf;

        cargarCombos();

        if (transferenciaActual == null) {
            setTitle("Nueva Transferencia");
            esNuevo = true;
        } else {
            setTitle("Editar Transferencia");
            esNuevo = false;
            cargarDatos();
        }
    }
    
    private void cargarCombos() {
        // Cargar Periodos
        List<Periodos> listaPeriodos = DatosTransferencias.getPeriodos();
        cboPeriodo.setModel(new DefaultComboBoxModel<>(new Vector<>(listaPeriodos)));

        // Cargar Cuentas
        List<Cuentas> listaCuentas = DatosTransferencias.getCuentas();
        cboOrigen.setModel(new DefaultComboBoxModel<>(new Vector<>(listaCuentas)));
        cboDestino.setModel(new DefaultComboBoxModel<>(new Vector<>(listaCuentas)));
    }
    
    private void cargarDatos() {
        txtId.setText(String.valueOf(transferenciaActual.getId()));
        txtNroOperacion.setText(transferenciaActual.getNroOperacion());

        try {
            String fechaOriginal = transferenciaActual.getFecha();
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoEntrada.parse(fechaOriginal);
            txtFecha.setDate(fecha);
        } catch (ParseException e) {
            txtFecha.setDate(null);
            System.err.println("Error al parsear fecha: " + e.getMessage());
        }

        seleccionarItemComboPeriodo(cboPeriodo, transferenciaActual.getPeriodo());
        seleccionarItemComboCuenta(cboOrigen, transferenciaActual.getCuentaOrigen());
        seleccionarItemComboCuenta(cboDestino, transferenciaActual.getCuentaDestino());
    }
    
    // Métodos para seleccionar el item correcto en los combos
    private void seleccionarItemComboPeriodo(JComboBox<Periodos> combo, String id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).getId().equals(id)) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private void seleccionarItemComboCuenta(JComboBox<Cuentas> combo, String id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (String.valueOf(combo.getItemAt(i).getIdCuenta()).equals(id)) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }
    
    private boolean validarCampos() {
        if (txtNroOperacion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo N° Operación es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (txtFecha.getDate() == null) {
            JOptionPane.showMessageDialog(this, "El campo Fecha es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cboPeriodo.getSelectedIndex() == -1 || cboOrigen.getSelectedIndex() == -1 || cboDestino.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item en todos los combos.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cboOrigen.getSelectedItem().equals(cboDestino.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "La cuenta de origen no puede ser igual a la de destino.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtNroOperacion = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cboDestino = new javax.swing.JComboBox<>();
        cboOrigen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboPeriodo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setClosable(true);
        setTitle("TRANSFERENCIAS");

        jLabel6.setText("Fecha:");

        txtNroOperacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNroOperacionFocusLost(evt);
            }
        });
        txtNroOperacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroOperacionKeyTyped(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nro. Operación:");

        jLabel3.setText("Periodo:");

        jLabel4.setText("C. Origen:");

        jLabel5.setText("C. Destino:");

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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroOperacion)
                            .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(17, 17, 17)
                                .addComponent(cboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(txtNroOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroOperacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNroOperacionFocusLost
        String texto = txtNroOperacion.getText().trim();
        txtNroOperacion.setText(texto);
    }//GEN-LAST:event_txtNroOperacionFocusLost

    private void txtNroOperacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroOperacionKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtNroOperacion.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroOperacionKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!validarCampos()) {
            return;
        }

        Periodos periodo = (Periodos) cboPeriodo.getSelectedItem();
        Cuentas cuentaOrigen = (Cuentas) cboOrigen.getSelectedItem();
        Cuentas cuentaDestino = (Cuentas) cboDestino.getSelectedItem();

        Transferencia transferencia = new Transferencia();
        transferencia.setPeriodo(periodo.getId());
        transferencia.setNroOperacion(txtNroOperacion.getText().trim());
        transferencia.setCuentaOrigen(String.valueOf(cuentaOrigen.getIdCuenta()));
        transferencia.setCuentaDestino(String.valueOf(cuentaDestino.getIdCuenta()));
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaSeleccionada = txtFecha.getDate();
        transferencia.setFecha(formatoSalida.format(fechaSeleccionada));

        if (esNuevo) {
            DatosTransferencias.insertar(transferencia);
        } else {
            transferencia.setId(Integer.parseInt(txtId.getText()));
            DatosTransferencias.actualizar(transferencia);
        }

        frmLista.cargarDatos();
        this.dispose();     // Cierra este formulario                                        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<Cuentas> cboDestino;
    private javax.swing.JComboBox<Cuentas> cboOrigen;
    private javax.swing.JComboBox<Periodos> cboPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNroOperacion;
    // End of variables declaration//GEN-END:variables
}
