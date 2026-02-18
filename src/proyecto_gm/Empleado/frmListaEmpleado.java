package proyecto_gm.Empleado;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import proyecto_gm.Area.Area;
import proyecto_gm.Cargo.Cargo;
import proyecto_gm.Utilitario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proyecto_gm.ConexionBD; // Asegúrate de importar tu conexión


public class frmListaEmpleado extends javax.swing.JInternalFrame {
    private static frmListaEmpleado instancia;
    static JDesktopPane panelPadre;

    public frmListaEmpleado(JDesktopPane panel) {
        initComponents();
        this.panelPadre = panel;
        cargarAreas();
    }
    
    public static frmListaEmpleado getInstancia(JDesktopPane panel) {
        if (instancia == null) {
            instancia = new frmListaEmpleado(panel);
        }
        return instancia;
    }

    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnReporte = new javax.swing.JToggleButton();
        cmbArea = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnImportar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Personal");
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

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "APELLIDOS", "NOMBRES", "FEC. NACIMIENTO", "CORREO", "DNI", "CELULAR", "DISTRITO", "DIRECCIÓN", "IdArea", "ÁREA", "IdCargo", "CARGO", "TIP. EMPLEADO", "IdTipoEmpleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEmpleados.setFocusable(false);
        tblEmpleados.setRowHeight(25);
        tblEmpleados.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblEmpleados.setShowGrid(true);
        tblEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEmpleados);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNuevo.setName("nuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEditar.setName("editar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnRefrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-refrescar-20.png"))); // NOI18N
        btnRefrescar.setToolTipText("Refrescar");
        btnRefrescar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefrescar);
        jToolBar1.add(jSeparator1);

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-doc-25.png"))); // NOI18N
        btnReporte.setToolTipText("Generar reporte");
        btnReporte.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReporte.setFocusable(false);
        btnReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReporte);

        cmbArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreaActionPerformed(evt);
            }
        });
        jToolBar1.add(cmbArea);
        jToolBar1.add(jSeparator2);

        btnImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-importar-25.png"))); // NOI18N
        btnImportar.setToolTipText("Importar datos");
        btnImportar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnImportar.setFocusable(false);
        btnImportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImportar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Buscar");

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

        btnBuscar.setText("Aceptar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Estado:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activo", "Inactivo" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(btnBuscar)
                .addComponent(jLabel2)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     frmEmpleado frm = new frmEmpleado(null,Utilitario.EstadoProceso.NUEVO);
     panelPadre.add(frm);
      frm.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if(tblEmpleados.getSelectedRows().length==0){
            Utilitario.MostrarMensaje("Debe seleccionar registro", Utilitario.TipoMensaje.alerta);
            return;
        }
        //Utilitario util = new Utilitario();
        Utilitario util = new Utilitario();


        DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();
        int indiceSeleccionado =  tblEmpleados.getSelectedRow();
        int indiceSeleccionadoModelo = tblEmpleados.convertRowIndexToModel(indiceSeleccionado);
        
         String id = modelo.getValueAt(indiceSeleccionadoModelo, 0).toString();
         String nombres = modelo.getValueAt(indiceSeleccionadoModelo, 1).toString();
         String apellidos = modelo.getValueAt(indiceSeleccionadoModelo, 2).toString();
         String fecha =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 3);
        String correo =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 4);
        String dni =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 5);
        String celular =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 6);
        String distrito =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 7);
        String direccion =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 8);
        String idArea =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 9);
        String area =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 10);
        String idCargo =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 11);
        String cargo =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 12);
        String tipEmpleado =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 13);
        String idtipEmpleado =Utilitario.LeerValortexto(modelo, indiceSeleccionadoModelo, 14);


        Empleados registro = new Empleados();
        registro.setId(id);
        registro.setNombres(nombres);
        registro.setApellidos(apellidos);
        registro.setfNacimiento(fecha);
        registro.setCorreo(correo);
        registro.setDni(dni);
        registro.setCelular(celular);
        registro.setDistrito(distrito);
        registro.setDireccion(direccion);
        //id ce cargo
        registro.setIdCargo(Integer.parseInt(idCargo));
        //nombre de cargo
        registro.setCargo(new Cargo(Integer.parseInt(idCargo), cargo));
        
        //id area
        registro.setIdArea(Integer.parseInt(idArea));
        registro.setArea(new Area(Integer.parseInt(idArea) , area));
        
        registro.setIdTipo(Integer.parseInt(idtipEmpleado));
        //nombre de area
        
        frmEmpleado frm = new frmEmpleado(registro,Utilitario.EstadoProceso.EDITAR);
   
        panelPadre.add(frm);
        frm.setVisible(true); 
    }//GEN-LAST:event_btnEditarActionPerformed
    private TableRowSorter<DefaultTableModel> sorter;
    private void cargarFiltroTabla(){
        
        
        
        sorter = new TableRowSorter<>((DefaultTableModel)tblEmpleados.getModel());
        tblEmpleados.setRowSorter(sorter);
        
    }
    private void filtroCombinado(){
        
        List<RowFilter<Object, Object>> filters = new ArrayList<>();
        String textoBusqueda = txtBusqueda.getText();
        if(!textoBusqueda.isEmpty()){
            try{
            // Crear un filtro personalizado que maneje la lógica OR para el campo de búsqueda
                // y la combinación de nombres + apellidos
                RowFilter<Object, Object> textFilter = new RowFilter<Object, Object>() {
                    @Override
                    public boolean include(Entry<?, ?> entry) {
                        
                        String id = entry.getValue(0).toString().toLowerCase(); // Columna ID
                        String apellidos = entry.getValue(1).toString().toLowerCase(); // Columna APELLIDOS
                        String nombres = entry.getValue(2).toString().toLowerCase(); // Columna NOMBRES
                        String dni = entry.getValue(5).toString().toLowerCase(); // Columna DNI

                        String nombreCompleto = (nombres + " " + apellidos).toLowerCase();
                        String buscarLower = textoBusqueda.toLowerCase();

                        // Buscar en DNI, Nombres, Apellidos, (Nombres + Apellidos), ID
                        return dni.contains(buscarLower) ||
                                nombres.contains(buscarLower) ||
                                apellidos.contains(buscarLower) ||
                                nombreCompleto.contains(buscarLower) ||
                                id.contains(buscarLower);
                    }
                };
                filters.add(textFilter);
            } catch (PatternSyntaxException ex) {
                System.err.println("Error en la expresión regular del filtro de texto: " + ex.getMessage());
                // Considera notificar al usuario
            }
            

                // Aplicar todos los filtros combinados con AND
                if (filters.isEmpty()) {
                    sorter.setRowFilter(null); // Si no hay filtros, mostrar todo
                } else {
                   // Combinar todos los filtros en un único RowFilter "AND"
                    RowFilter<Object, Object> compoundRowFilter = new RowFilter<Object, Object>() {
                        @Override
                        public boolean include(Entry<?, ?> entry) {
                            for (RowFilter<Object, Object> filter : filters) {
                                if (!filter.include(entry)) {
                                    // Si alguna de las condiciones de filtro no se cumple,
                                    // entonces esta fila no debe incluirse (lógica AND)
                                    return false;
                                }
                            }
                            // Si la fila pasó todos los filtros individuales, incluirla
                            return true;
                        }
                    };
                    sorter.setRowFilter(compoundRowFilter);
                }

                }
    }
    private void filtrar(String valorBuscado){
        try{
            if(valorBuscado.equals("")){
                sorter.setRowFilter(null);
                        
            }else{
                sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + Pattern.quote(valorBuscado) + ".*", 0, 1, 2, 3,4,5,6));
            }
            //int idArea = ((Area)this.cboArea.getSelectedItem()).getIdArea();
            //String desArea = ((Area)this.cboArea.getSelectedItem()).getDescripcionArea();          
            //System.out.println("Area:" + idArea + "-"+  desArea);
            //System.out.println("Cargo:" + valorCargoSeleccionaedo);                        
        }catch(PatternSyntaxException ex){
            System.err.println("Error en la expresión regular del filtro: " + ex.getMessage());
                // Puedes mostrar un JOptionPane aquí si quieres notificar al usuario
                //JOptionPane.showMessageDialog(this, "Error en el patrón de búsqueda.", "Error de Filtro", JOptionPane.ERROR_MESSAGE);
           
        }
    }
    private void filtrarCombo(String valorBuscado){
    //9 Area Id
        try{
            if(valorBuscado.equals("")){
                sorter.setRowFilter(null);
            }else{
                sorter.setRowFilter(RowFilter.regexFilter("(?i).*"+ Pattern.quote(valorBuscado)+".*", 9,10));
            }
        }catch(PatternSyntaxException ex){

        }
    //11 cargo Id
    }
    protected void Cargar() {
        DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();
        DatosEmpleados.Listar(modelo);

        if (tblEmpleados.getColumnCount() > 12) {
            TableColumnModel tcm = tblEmpleados.getColumnModel();
            tcm.removeColumn(tcm.getColumn(14)); 
            tcm.removeColumn(tcm.getColumn(11)); 
            tcm.removeColumn(tcm.getColumn(9));  
        }
        tblEmpleados.setCellSelectionEnabled(false);
        tblEmpleados.setRowSelectionAllowed(true);
    }
    
    static void CargarLista(){
            DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();       
         DatosEmpleados.Listar(modelo);
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos el registro seleccionado y bloqueamos los campos
        if(tblEmpleados.getSelectedRowCount() == 0){
            Utilitario.MostrarMensaje("Debe seleccioanr registro a elminar ", Utilitario.TipoMensaje.alerta);
        }
        //selecioanr id de empleado
        int indice = tblEmpleados.getSelectedRow();
        int id =  Integer.parseInt(tblEmpleados.getValueAt(indice, 0).toString());
        System.err.println("id seleccionado:" +  id);
        boolean estado = DatosEmpleados.Eliminar(id);
        if(estado){
            Cargar();
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Cargar();
        cargarFiltroTabla();                             
    }//GEN-LAST:event_formInternalFrameOpened
   
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         filtrar(txtBusqueda.getText());                          
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        if(evt.getKeyChar()== KeyEvent.VK_ENTER){
           if(!txtBusqueda.getText().trim().equals("")){
               filtrar(txtBusqueda.getText());
           }else{
                filtrar("");
           }           
       }
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        Cargar();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
       
        String nombreEstado = this.cboEstado.getSelectedItem().toString().toLowerCase();
        
        DefaultTableModel modelo = (DefaultTableModel) tblEmpleados.getModel();
            switch (nombreEstado) {
                case "activo":
                    DatosEmpleados.Listar(modelo,"A");
                    
                    break;
                case "inactivo":
                    DatosEmpleados.Listar(modelo, "I");
                    
                default:
                    DatosEmpleados.Listar(modelo);
                    break;
            }         
    }//GEN-LAST:event_cboEstadoActionPerformed
    
    public void cargarAreas() {
        cmbArea.removeAllItems();
        try {
            Connection con = ConexionBD.getConnection();
            String sql = "SELECT descripcion FROM areas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbArea.addItem(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        String areaSeleccionada = cmbArea.getSelectedItem().toString();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("PAR_AREA", areaSeleccionada);

        reportes.GeneradorReportes gen = new reportes.GeneradorReportes();
        gen.mostrarReporte("RPTEmpleado", parametros);

        btnReporte.setSelected(false);
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void cmbAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreaActionPerformed

    }//GEN-LAST:event_cmbAreaActionPerformed
    
    public void importarDesdeExcel(String ruta) {
        try (FileInputStream fis = new FileInputStream(new File(ruta))) {
            Workbook wb = new XSSFWorkbook(fis);
            Sheet s = wb.getSheetAt(0);
            org.apache.poi.ss.usermodel.DataFormatter fmt = new org.apache.poi.ss.usermodel.DataFormatter();
            int contador = 0;

            for (int i = 1; i <= s.getLastRowNum(); i++) {
                Row row = s.getRow(i);
                if (row == null) continue;

                String idRaw = fmt.formatCellValue(row.getCell(0)).replace("E", "").trim();
                if (idRaw.isEmpty()) continue;

                int id = Integer.parseInt(idRaw);
                String apellidos = fmt.formatCellValue(row.getCell(1));
                String nombres = fmt.formatCellValue(row.getCell(2));
                String fechaNac = fmt.formatCellValue(row.getCell(3));
                String correo = fmt.formatCellValue(row.getCell(4));
                String dni = fmt.formatCellValue(row.getCell(5));
                String celular = fmt.formatCellValue(row.getCell(6));
                String distrito = fmt.formatCellValue(row.getCell(7));
                String direccion = fmt.formatCellValue(row.getCell(8));
                int idArea = Integer.parseInt(fmt.formatCellValue(row.getCell(9)));
                int idCargo = Integer.parseInt(fmt.formatCellValue(row.getCell(10)));
                int idTipo = Integer.parseInt(fmt.formatCellValue(row.getCell(11)));

                if (DatosEmpleados.insertarDesdeExcel(id, apellidos, nombres, fechaNac, correo, dni, celular, distrito, direccion, idArea, idCargo, idTipo)) {
                    contador++;
                }
            }
            JOptionPane.showMessageDialog(this, "Se registraron " + contador + " empleados.");
            Cargar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al importar: " + e.getMessage());
        }
    }

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Archivos Excel", "xlsx"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            importarDesdeExcel(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnImportarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImportar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JToggleButton btnReporte;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    protected static javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
