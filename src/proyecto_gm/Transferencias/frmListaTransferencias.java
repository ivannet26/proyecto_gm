package proyecto_gm.Transferencias;

import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmListaTransferencias extends javax.swing.JInternalFrame {
    private static frmListaTransferencias instancia;
    DefaultTableModel modelo;
    List<Transferencia> listaTransferencias;

    public frmListaTransferencias() {
        initComponents();
        // Configurar el modelo de la tabla
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Periodo");
        modelo.addColumn("N° Operación");
        modelo.addColumn("Cuenta Origen");
        modelo.addColumn("Cuenta Destino");
        modelo.addColumn("Fecha");
        tblTransferencias.setModel(modelo);
        
        cargarDatos();
    }
    
    public static frmListaTransferencias getInstancia() {
        if (instancia == null) {
            instancia = new frmListaTransferencias();
        }
        return instancia;
    }

    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }

    
        // Este método es público para poder ser llamado desde el formulario de edición
    public void cargarDatos() {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar

        listaTransferencias = DatosTransferencias.listar();
        for (Transferencia t : listaTransferencias) {
            modelo.addRow(new Object[]{
                t.getId(),
                t.getPeriodo(),
                t.getNroOperacion(),
                t.getCuentaOrigen(),
                t.getCuentaDestino(),
                t.getFecha()
            });
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransferencias = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("LISTA TRANSFERENCIAS");
        setToolTipText(null);

        tblTransferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PERIODO", "NRO. OPERACIÓN", "C. ORIGEN", "C. DESTINO", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransferencias.setFocusable(false);
        tblTransferencias.setRowHeight(25);
        tblTransferencias.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblTransferencias.setShowGrid(true);
        tblTransferencias.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTransferencias);
        if (tblTransferencias.getColumnModel().getColumnCount() > 0) {
            tblTransferencias.getColumnModel().getColumn(0).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblTransferencias.getColumnModel().getColumn(1).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(1).setPreferredWidth(40);
            tblTransferencias.getColumnModel().getColumn(2).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblTransferencias.getColumnModel().getColumn(3).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblTransferencias.getColumnModel().getColumn(4).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblTransferencias.getColumnModel().getColumn(5).setResizable(false);
            tblTransferencias.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jToolBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setName("nuevo"); // NOI18N
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

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblTransferencias.getSelectedRow();
        if (fila >= 0) {
            // Se obtiene el ID directamente de la tabla
            int idTransferencia = (int) tblTransferencias.getValueAt(fila, 0);

            // Diálogo de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que quiere eliminar la transferencia seleccionada?",
                    "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                DatosTransferencias.eliminar(idTransferencia);
                cargarDatos(); // Actualizar la tabla después de eliminar
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblTransferencias.getSelectedRow();
        if (fila >= 0) {
            // Se obtiene el objeto completo de la lista, no de la tabla
            Transferencia transferenciaSeleccionada = listaTransferencias.get(fila);

            // Se abre el formulario de edición y se le pasa el objeto
            frmTransferencias frm = new frmTransferencias(this, transferenciaSeleccionada);
            JDesktopPane desktopPane = getDesktopPane();
            desktopPane.add(frm);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        frmTransferencias frm = new frmTransferencias(this, null);
        JDesktopPane desktopPane = getDesktopPane();
        desktopPane.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblTransferencias;
    // End of variables declaration//GEN-END:variables
}
