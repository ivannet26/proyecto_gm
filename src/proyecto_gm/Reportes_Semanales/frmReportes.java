/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.Reportes_Semanales;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.Desktop;
import java.io.File;

public class frmReportes extends javax.swing.JInternalFrame {

    private static frmReportes instancia;

    public static frmReportes getInstancia() {
        if (instancia == null || instancia.isClosed()) {
            instancia = new frmReportes();
        }
        return instancia;
    }
    
    private void ConfigurarTabla() {
        String[] titulos = {
            "ID", "Fecha", "Apellidos y Nombres", "Celular", "Cargo", "Área", 
            "Entrada 1", "Salida 1", "Break", "Entrada 2", "Salida 2", 
            "Horas Lab.", "Horas c/Break", "Actividad", "Coordinador"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        tblReporte.setModel(modelo);
    }
    
    public frmReportes() {
        initComponents();
        ConfigurarTabla();
        btnGenerar.doClick();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnGenerar = new javax.swing.JButton();
        btnSincronizar = new javax.swing.JButton();
        jdFechaInicio = new com.toedter.calendar.JDateChooser();
        jdFechaFin = new com.toedter.calendar.JDateChooser();
        btnExportarExcel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();

        setClosable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnGenerar.setText("Generar Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnSincronizar.setText("Sincronizar");
        btnSincronizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSincronizarActionPerformed(evt);
            }
        });

        btnExportarExcel.setText("Exportar Excel");
        btnExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jdFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnExportarExcel)
                .addGap(32, 32, 32)
                .addComponent(btnSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGenerar)
                        .addComponent(btnSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExportarExcel))
                    .addComponent(jdFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReporte.setEnabled(false);
        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
                                          
        DatosReporte datos = new DatosReporte();
        ResultSet rs;

        java.util.Date fInicio = jdFechaInicio.getDate();
        java.util.Date fFin = jdFechaFin.getDate();

      
        if (fInicio != null && fFin != null) {
            if (fInicio.after(fFin)) {
                JOptionPane.showMessageDialog(this, "La fecha de inicio debe ser anterior a la final.");
                return;
            }
            rs = datos.listarReportesPorFechas(fInicio, fFin);
        } else {

            rs = datos.listarTodosLosReportes();
        }


        if (rs != null) {
            DefaultTableModel modelo = (DefaultTableModel) tblReporte.getModel();
            modelo.setRowCount(0); 
            try {
                while (rs.next()) {
                    Object[] fila = new Object[15];
                    fila[0] = rs.getInt("id");
                    fila[1] = rs.getString("fecha");
                    fila[2] = rs.getString("apellidos_nombres");
                    fila[3] = rs.getString("celular");
                    fila[4] = rs.getString("cargo");
                    fila[5] = rs.getString("area");
                    fila[6] = rs.getString("hora_entrada_1");
                    fila[7] = rs.getString("hora_salida_1");
                    fila[8] = rs.getString("break_tiempo");
                    fila[9] = rs.getString("hora_entrada_2");
                    fila[10] = rs.getString("hora_salida_2");
                    fila[11] = rs.getString("total_horas_laboradas");
                    fila[12] = rs.getString("total_horas_con_break");
                    fila[13] = rs.getString("actividad");
                    fila[14] = rs.getString("coordinador");
                    modelo.addRow(fila);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al procesar: " + e.getMessage());
            }
        }

    
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSincronizarActionPerformed
                                              
        btnSincronizar.setEnabled(false); // Bloqueamos el botón temporalmente
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        JOptionPane.showMessageDialog(this, 
            "El barrido general ha iniciado en el servidor.\nTe avisaremos aquí mismo cuando termine para mostrar los datos.", 
            "Sincronizando...", 
            JOptionPane.INFORMATION_MESSAGE);

        javax.swing.SwingWorker<Void, Void> worker = new javax.swing.SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {

                    java.net.URL url = new java.net.URL("https://bot-reportes-equipo.onrender.com/auditar_manana");
                    java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.getResponseCode(); 

                    boolean enProgreso = true;
                    while (enProgreso) {
                        Thread.sleep(4000); 
                        
                        java.net.URL urlEstado = new java.net.URL("https://bot-reportes-equipo.onrender.com/estado_auditoria");
                        java.net.HttpURLConnection connEstado = (java.net.HttpURLConnection) urlEstado.openConnection();
                        connEstado.setRequestMethod("GET");
                        
                        java.util.Scanner scanner = new java.util.Scanner(connEstado.getInputStream());
                        String response = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                        scanner.close();
                        
                        if (response.contains("\"en_progreso\": false") || response.contains("\"en_progreso\":false")) {
                            enProgreso = false; 
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error en la consulta: " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
          
                btnSincronizar.setEnabled(true);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                
                JOptionPane.showMessageDialog(frmReportes.this, 
                    "¡Sincronización finalizada!\nTodos los reportes faltantes han sido capturados.", 
                    "Terminado", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                
                btnGenerar.doClick(); 
            }
        };
        
        worker.execute(); 
    
    }//GEN-LAST:event_btnSincronizarActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed

        if (tblReporte.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos en la tabla para exportar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }


        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel (.xlsx)", "xlsx");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar Reporte de Asistencia");
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString();
            
       
            if (!ruta.toLowerCase().endsWith(".xlsx")) {
                ruta += ".xlsx";
            }

            try {
              
                Workbook libro = new XSSFWorkbook();
                Sheet hoja = libro.createSheet("Reportes de Asistencia");

             
                Row filaEncabezados = hoja.createRow(0);
                for (int c = 0; c < tblReporte.getColumnCount(); c++) {
                    Cell celda = filaEncabezados.createCell(c);
                    celda.setCellValue(tblReporte.getColumnName(c));
                }

                for (int f = 0; f < tblReporte.getRowCount(); f++) {
                    Row filaDatos = hoja.createRow(f + 1); 
                    for (int c = 0; c < tblReporte.getColumnCount(); c++) {
                        Cell celda = filaDatos.createCell(c);
                        Object valor = tblReporte.getValueAt(f, c);
                        
                        if (valor != null) {
                            celda.setCellValue(valor.toString());
                        } else {
                            celda.setCellValue("");
                        }
                    }
                }

                
                for (int c = 0; c < tblReporte.getColumnCount(); c++) {
                    hoja.autoSizeColumn(c);
                }

             
                FileOutputStream archivo = new FileOutputStream(ruta);
                libro.write(archivo);
                archivo.close();

                JOptionPane.showMessageDialog(this, "¡Excel exportado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                
                Desktop.getDesktop().open(new File(ruta));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al exportar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }//GEN-LAST:event_btnExportarExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSincronizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser jdFechaFin;
    private com.toedter.calendar.JDateChooser jdFechaInicio;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}
