
package proyecto_gm.Mac;

import javax.swing.JOptionPane;
import proyecto_gm.Perfil.frmPerfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class MAC_ADDRESS extends javax.swing.JInternalFrame {

    public MAC_ADDRESS() {
        initComponents();
        listarMacs();
    }
    
   void listarMacs() {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        
        modelo.addColumn("Última Sesión");      
        modelo.addColumn("MAC Address");        
        modelo.addColumn("Nombre PC");        
        modelo.addColumn("Usuario");           
        modelo.addColumn("Inicio Instalación"); 
        modelo.addColumn("Día Finalización");  
        modelo.addColumn("Estado");             
        
        tblMac.setModel(modelo);

     
        String sql = "SELECT c.ultima_sesion, c.mac_address, c.nombre_pc, u.username, " +
                     "c.inicio_instalacion, c.dia_finalizacion, c.estado " +
                     "FROM control_mac c " +
                     "INNER JOIN usuarios u ON c.id_usuario = u.IdUsuario";

        try {
            Connection conn = ConexionBD.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                
                Object[] fila = new Object[7]; 
                
                fila[0] = rs.getString("ultima_sesion");
                fila[1] = rs.getString("mac_address");
                fila[2] = rs.getString("nombre_pc");
                fila[3] = rs.getString("username");
                fila[4] = rs.getString("inicio_instalacion");
                fila[5] = rs.getString("dia_finalizacion");
                fila[6] = rs.getString("estado"); 
                
                modelo.addRow(fila);
            }
            tblMac.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al listar: " + e.getMessage());
        }
    }

    void actualizarEstado(String nuevoEstado) {
        int fila = tblMac.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "¡Selecciona una fila primero!");
            return;
        }

        
        String macSeleccionada = tblMac.getValueAt(fila, 1).toString();

        try {
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pst = conn.prepareStatement("UPDATE control_mac SET estado = ? WHERE mac_address = ?");
            pst.setString(1, nuevoEstado);
            pst.setString(2, macSeleccionada);
            pst.executeUpdate();

            listarMacs(); 
            JOptionPane.showMessageDialog(this, "Estado cambiado a: " + nuevoEstado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error BD: " + e.getMessage());
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMac = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnDenegar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(java.awt.Color.white);
        setOpaque(true);

        tblMac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMac);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setName("deshacer"); // NOI18N
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setName("agregar"); // NOI18N
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAceptar);

        btnDenegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/limpiar.png"))); // NOI18N
        btnDenegar.setToolTipText("Denegar");
        btnDenegar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDenegar.setFocusable(false);
        btnDenegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDenegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDenegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenegarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDenegar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 681, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getAccessibleContext().setAccessibleName("MAC\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       frmPerfil ventanaPerfil = new frmPerfil();
    
   
        javax.swing.JDesktopPane escritorio = this.getDesktopPane();

        if (escritorio != null) {
            escritorio.add(ventanaPerfil);


            java.awt.Dimension tamanoEscritorio = escritorio.getSize();
            java.awt.Dimension tamanoVentana = ventanaPerfil.getSize();

            ventanaPerfil.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
     actualizarEstado("ACEPTADO");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnDenegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenegarActionPerformed
      actualizarEstado("DENEGADO");
    }//GEN-LAST:event_btnDenegarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDenegar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblMac;
    // End of variables declaration//GEN-END:variables
}
