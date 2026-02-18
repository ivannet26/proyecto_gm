/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Archivos;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;


public class frmArchivos extends javax.swing.JInternalFrame {

    private static frmArchivos instancia;
    
    public frmArchivos() {
        initComponents();
        actualizarTabla();
    }
    
    public static frmArchivos getInstancia(){
        if(instancia ==null){
            instancia = new frmArchivos();
        }
        return instancia;
    }
    
    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }

   private void actualizarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ARCHIVO", "FECHA GUARDADO"}, 0);
        DatosArchivos dao = new DatosArchivos();
        
        for (Object[] fila : dao.listarArchivos()) {
            Object[] filaMostrar = { fila[0], fila[2] }; 
            modelo.addRow(filaMostrar);
        }
        tblArchivos.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnImportar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArchivos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("ARCHIVOS");
        setMaximumSize(null);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-importar-25.png"))); // NOI18N
        btnImportar.setToolTipText("importar datos");
        btnImportar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImportar.setFocusable(false);
        btnImportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImportar.setMaximumSize(new java.awt.Dimension(26, 26));
        btnImportar.setMinimumSize(new java.awt.Dimension(26, 26));
        btnImportar.setName("registrar"); // NOI18N
        btnImportar.setPreferredSize(new java.awt.Dimension(50, 48));
        btnImportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImportar);

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnBorrar.setToolTipText("Eliminar");
        btnBorrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrar.setFocusable(false);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrar.setName("cancelar"); // NOI18N
        btnBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBorrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        tblArchivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArchivosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArchivos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       actualizarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
    
    
        int resultado = selector.showOpenDialog(this);

   
        if (resultado == JFileChooser.APPROVE_OPTION) { 
            File archivo = selector.getSelectedFile();

            
            if (archivo != null) {
                try {
                    byte[] pdfBytes = Files.readAllBytes(archivo.toPath());
                    String nombre = archivo.getName();

                    
                    Timestamp fechaPC = new Timestamp(System.currentTimeMillis());

                    Connection con = ConexionBD.getConnection(); 
                   
                    String sql = "INSERT INTO documentos_pdf (nombre_archivo, contenido_bytes, fecha_guardado) VALUES (?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, nombre);
                    ps.setBytes(2, pdfBytes);
                    ps.setTimestamp(3, fechaPC); 

                    if (ps.executeUpdate() > 0) {
                        JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente");
                        actualizarTabla(); 
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int fila = tblArchivos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un archivo de la tabla");
            return;
        }

        String nombre = tblArchivos.getValueAt(fila, 0).toString();
        try (Connection con = ConexionBD.getConnection()) {
            String sql = "DELETE FROM documentos_pdf WHERE nombre_archivo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
            
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Registro eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error de seguridad: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArchivosMouseClicked
        int fila = tblArchivos.getSelectedRow();
        if (fila == -1) return;
        String nombreArchivo = tblArchivos.getValueAt(fila, 0).toString();
        int respuesta = JOptionPane.showConfirmDialog(this, 
                "¿Desea abrir el archivo: " + nombreArchivo + "?", 
                "Confirmar apertura", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            DatosArchivos dao = new DatosArchivos();
            byte[] bytesRecuperados = dao.obtenerBytes(nombreArchivo);

            if (bytesRecuperados != null) {
                try {
                    File archivoTemp = File.createTempFile("temp_", ".pdf");
                    Files.write(archivoTemp.toPath(), bytesRecuperados);               
                    Desktop.getDesktop().open(archivoTemp);   
                    archivoTemp.deleteOnExit(); 
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al abrir PDF: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_tblArchivosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnImportar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblArchivos;
    // End of variables declaration//GEN-END:variables
}
