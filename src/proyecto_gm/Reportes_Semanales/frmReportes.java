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
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class frmReportes extends javax.swing.JInternalFrame {

    private static frmReportes instancia;
    private TableRowSorter<DefaultTableModel> sorter;

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

       DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
           @Override
           public boolean isCellEditable(int row, int column) {
               return false; 
           }
       };

       tblReporte.setModel(modelo);

       
       sorter = new TableRowSorter<>(modelo);
       tblReporte.setRowSorter(sorter);
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
        txtBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
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

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btnSincronizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    
    
    private String val(Object o) {
    return (o == null) ? "" : o.toString().trim();
    }

    
    private void crearCelda(org.apache.poi.ss.usermodel.Row fila, int col, String valor,
                            org.apache.poi.ss.usermodel.CellStyle estilo) {
        org.apache.poi.ss.usermodel.Cell c = fila.createCell(col);
        c.setCellValue(valor);
        if (estilo != null) c.setCellStyle(estilo);
    }

    private String calcularHorasLaboradas(String ent1, String sal1, String brk,
                                          String ent2, String sal2) {
        try {
            double seg = 0;
            if (!ent1.isEmpty() && !sal1.isEmpty()) {
                seg += diffSegundos(ent1, sal1);
            }
            if (!ent2.isEmpty() && !sal2.isEmpty()) {
                seg += diffSegundos(ent2, sal2);
            }
           
            return seg > 0 ? segundosAHora(seg) : "";
        } catch (Exception e) { return ""; }
    }

 
    private String calcularHorasConBreak(String ent1, String sal1, String brk,
                                         String ent2, String sal2) {
        try {
           
            if (!ent1.isEmpty() && !sal2.isEmpty()) {
                double seg = diffSegundos(ent1, sal2);
                return seg > 0 ? segundosAHora(seg) : "";
            }
       
            if (!ent1.isEmpty() && !sal1.isEmpty()) {
                double seg = diffSegundos(ent1, sal1);
                return seg > 0 ? segundosAHora(seg) : "";
            }
            return "";
        } catch (Exception e) { return ""; }
    }

    
    private double diffSegundos(String horaA, String horaB) throws Exception {
        java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("hh:mm a", java.util.Locale.US);
        java.util.Date tA = fmt.parse(horaA);
        java.util.Date tB = fmt.parse(horaB);
        double diff = tB.getTime() - tA.getTime();
        return diff / 1000.0;
    }

    
    private String segundosAHora(double seg) {
        if (seg <= 0) return "0:00:00";
        long s = (long) seg;
        return String.format("%d:%02d:%02d", s / 3600, (s % 3600) / 60, s % 60);
    }

   
    private double horaEnSegundos(String hora) {
        if (hora == null || hora.isEmpty()) return 0;
        try {
            String[] p = hora.split(":");
            return Integer.parseInt(p[0]) * 3600.0
                 + (p.length > 1 ? Integer.parseInt(p[1]) * 60.0 : 0)
                 + (p.length > 2 ? Integer.parseInt(p[2]) : 0);
        } catch (Exception e) { return 0; }
    }
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
                sorter = new TableRowSorter<>((DefaultTableModel) tblReporte.getModel());
                tblReporte.setRowSorter(sorter);
                if (!txtBusqueda.getText().trim().isEmpty()) {
                    aplicarFiltro(); // Re-aplicar filtro si había uno activo
                }
        }
        

    
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnSincronizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSincronizarActionPerformed
                                              
        btnSincronizar.setEnabled(false); 
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));


        javax.swing.SwingWorker<Void, String> worker = new javax.swing.SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                
                    java.net.URL url = new java.net.URL("https://bot-reportes-equipo.onrender.com/auditar_manana");
                    java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.getResponseCode(); 

                    boolean enProgreso = true;
                    while (enProgreso) {
                        Thread.sleep(3000); 

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
                    System.out.println("Error en sincronización: " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
                btnSincronizar.setEnabled(true);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

               
                btnGenerar.doClick(); 

                JOptionPane.showMessageDialog(frmReportes.this, 
                    "¡Sincronización finalizada!\nSe han procesado los mensajes de WhatsApp y rellenado los reportes faltantes.", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
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
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Excel (.xlsx)", "xlsx"));
        chooser.setDialogTitle("Guardar Reporte Semanal - GM Ingenieros");

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        String ruta = chooser.getSelectedFile().toString();
        if (!ruta.toLowerCase().endsWith(".xlsx")) ruta += ".xlsx";

        try (org.apache.poi.xssf.usermodel.XSSFWorkbook libro =
                 new org.apache.poi.xssf.usermodel.XSSFWorkbook()) {

            org.apache.poi.ss.usermodel.Sheet hoja = libro.createSheet("Reporte Semanal");

            
            org.apache.poi.ss.usermodel.CellStyle estiloHeader = libro.createCellStyle();
            org.apache.poi.ss.usermodel.Font fuenteHeader = libro.createFont();
            fuenteHeader.setBold(true);
            estiloHeader.setFont(fuenteHeader);
            estiloHeader.setFillForegroundColor(org.apache.poi.ss.usermodel.IndexedColors.GREY_25_PERCENT.getIndex());
            estiloHeader.setFillPattern(org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND);
            estiloHeader.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
            estiloHeader.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);

           
            org.apache.poi.ss.usermodel.CellStyle estiloNoReporte = libro.createCellStyle();
            org.apache.poi.ss.usermodel.Font fuenteNoReporte = libro.createFont();
            fuenteNoReporte.setColor(org.apache.poi.ss.usermodel.IndexedColors.RED.getIndex());
            fuenteNoReporte.setItalic(true);
            estiloNoReporte.setFont(fuenteNoReporte);
            estiloNoReporte.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);

           
            org.apache.poi.ss.usermodel.CellStyle estiloTotal = libro.createCellStyle();
            org.apache.poi.ss.usermodel.Font fuenteTotal = libro.createFont();
            fuenteTotal.setBold(true);
            fuenteTotal.setColor(org.apache.poi.ss.usermodel.IndexedColors.DARK_BLUE.getIndex());
            estiloTotal.setFont(fuenteTotal);
            estiloTotal.setFillForegroundColor(org.apache.poi.ss.usermodel.IndexedColors.LIGHT_YELLOW.getIndex());
            estiloTotal.setFillPattern(org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND);
            estiloTotal.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);

           
            java.util.Set<String> fechasUnicas     = new java.util.LinkedHashSet<>();
            java.util.Map<String, Object[]> datosFijos     = new java.util.LinkedHashMap<>();
            java.util.Map<String, java.util.Map<String, Object[]>> datosDiarios = new java.util.LinkedHashMap<>();

            for (int f = 0; f < tblReporte.getRowCount(); f++) {
                String fecha   = val(tblReporte.getValueAt(f, 1));
                String nombre  = val(tblReporte.getValueAt(f, 2));
                String celular = val(tblReporte.getValueAt(f, 3));
                String cargo   = val(tblReporte.getValueAt(f, 4));
                String area    = val(tblReporte.getValueAt(f, 5));

                fechasUnicas.add(fecha);

                if (!datosFijos.containsKey(nombre)) {
                    datosFijos.put(nombre, new Object[]{celular, cargo, area});
                    datosDiarios.put(nombre, new java.util.LinkedHashMap<>());
                }

               
                Object[] dia = new Object[9];
                dia[0] = tblReporte.getValueAt(f, 6);   
                dia[1] = tblReporte.getValueAt(f, 7);  
                dia[2] = tblReporte.getValueAt(f, 8);   
                dia[3] = tblReporte.getValueAt(f, 9);   
                dia[4] = tblReporte.getValueAt(f, 10); 
                dia[5] = tblReporte.getValueAt(f, 11);  
                dia[6] = tblReporte.getValueAt(f, 12);  
                dia[7] = tblReporte.getValueAt(f, 13);  
                dia[8] = tblReporte.getValueAt(f, 14);  

             
                if (val(dia[5]).isEmpty()) {
                    dia[5] = calcularHorasLaboradas(val(dia[0]), val(dia[1]), val(dia[2]), val(dia[3]), val(dia[4]));
                }
                if (val(dia[6]).isEmpty()) {
                    dia[6] = calcularHorasConBreak(val(dia[0]), val(dia[1]), val(dia[2]), val(dia[3]), val(dia[4]));
                }

                datosDiarios.get(nombre).put(fecha, dia);
            }

            java.util.List<String> listaFechas = new java.util.ArrayList<>(fechasUnicas);

          
            org.apache.poi.ss.usermodel.Row filaEnc = hoja.createRow(0);
            String[] headersFijos = {"ITEM", "APELLIDOS Y NOMBRES", "CELULAR", "CARGO", "ÁREA"};
            int colIdx = 0;
            for (String h : headersFijos) {
                crearCelda(filaEnc, colIdx++, h, estiloHeader);
            }
            for (String fecha : listaFechas) {
                String[] hd = {fecha, "HORA DE ENTRADA", "HORA DE SALIDA", "BREAK",
                               "HORA DE ENTRADA 2", "HORA DE SALIDA 2",
                               "TOTAL HORAS LAB.", "HORAS C/BREAK", "ACTIVIDAD", "COORDINADOR"};
                for (String h : hd) crearCelda(filaEnc, colIdx++, h, estiloHeader);
            }
         
            crearCelda(filaEnc, colIdx++, "TOTAL HORAS SEMANA", estiloHeader);
            crearCelda(filaEnc, colIdx,   "TOTAL H. C/BREAK SEMANA", estiloHeader);

           
            int filaNum = 1;
            for (java.util.Map.Entry<String, Object[]> persona : datosFijos.entrySet()) {
                org.apache.poi.ss.usermodel.Row fila = hoja.createRow(filaNum);
                String nombre = persona.getKey();
                Object[] fijos = persona.getValue();

                fila.createCell(0).setCellValue(filaNum);
                fila.createCell(1).setCellValue(nombre);
                fila.createCell(2).setCellValue(val(fijos[0]));
                fila.createCell(3).setCellValue(val(fijos[1]));
                fila.createCell(4).setCellValue(val(fijos[2]));

                int colOffset = 5;
                double totalSegLab   = 0;
                double totalSegBreak = 0;

                java.util.Map<String, Object[]> diasPersona = datosDiarios.get(nombre);

                for (String fecha : listaFechas) {
                    if (diasPersona.containsKey(fecha)) {
                        Object[] dia = diasPersona.get(fecha);

                      
                        fila.createCell(colOffset).setCellValue("");

                        for (int i = 0; i < 9; i++) {
                            String valor = val(dia[i]);
                            org.apache.poi.ss.usermodel.Cell c = fila.createCell(colOffset + 1 + i);
                            c.setCellValue(valor);
                        }

                   
                        totalSegLab   += horaEnSegundos(val(dia[5]));
                        totalSegBreak += horaEnSegundos(val(dia[6]));

                    } else {
                     
                        org.apache.poi.ss.usermodel.Cell cNoRep = fila.createCell(colOffset);
                        cNoRep.setCellValue("NO ENVIÓ REPORTE");
                        cNoRep.setCellStyle(estiloNoReporte);
                        for (int i = 1; i < 10; i++) {
                            fila.createCell(colOffset + i).setCellValue("");
                        }
                    }
                    colOffset += 10;
                }

               
                org.apache.poi.ss.usermodel.Cell cTotLab = fila.createCell(colOffset);
                cTotLab.setCellValue(segundosAHora(totalSegLab));
                cTotLab.setCellStyle(estiloTotal);

                org.apache.poi.ss.usermodel.Cell cTotBreak = fila.createCell(colOffset + 1);
                cTotBreak.setCellValue(segundosAHora(totalSegBreak));
                cTotBreak.setCellStyle(estiloTotal);

                filaNum++;
            }

            
            for (int i = 0; i < colIdx + 2; i++) hoja.autoSizeColumn(i);

            try (java.io.FileOutputStream out = new java.io.FileOutputStream(new java.io.File(ruta))) {
                libro.write(out);
                JOptionPane.showMessageDialog(this, "¡Excel exportado correctamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                if (java.awt.Desktop.isDesktopSupported()) java.awt.Desktop.getDesktop().open(new java.io.File(ruta));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear el Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnExportarExcelActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
       aplicarFiltro();
    }//GEN-LAST:event_txtBusquedaActionPerformed
    private void aplicarFiltro() {
        if (sorter == null) return;

        String texto = txtBusqueda.getText().trim();

        if (texto.isEmpty()) {
            sorter.setRowFilter(null);
            return;
        }

        try {

            String regex = "(?i)" + java.util.regex.Pattern.quote(texto);
            sorter.setRowFilter(RowFilter.regexFilter(regex));
        } catch (java.util.regex.PatternSyntaxException ex) {
            sorter.setRowFilter(null);
        }
    }
    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        javax.swing.SwingUtilities.invokeLater(() -> aplicarFiltro());
    }//GEN-LAST:event_txtBusquedaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSincronizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser jdFechaFin;
    private com.toedter.calendar.JDateChooser jdFechaInicio;
    private javax.swing.JTable tblReporte;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
