package proyecto_gm.Empleado;

import com.mysql.cj.util.Util;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import proyecto_gm.Area.Area;
import proyecto_gm.Cargo.Cargo;
import proyecto_gm.Utilitario;
import proyecto_gm.Exportar;

/**
 *
 * @author jeanv
 */
public class frmEmpleado extends javax.swing.JInternalFrame {

    boolean esNuevo = false;
    protected Empleados registro  = new Empleados(); 
    private Utilitario.EstadoProceso estadoProceso;
    
    /**
     * Creates new form frmEmpleado
     */
    private void ObtenerDatos(){
        txtApe.setText(registro.getApellidos()); 
        txtNom.setText(registro.getNombres());
        txtCel.setText(registro.getCelular());
        txtCorreo.setText(registro.getCorreo());
        txtDirec.setText(registro.getDireccion());
        cboArea.setSelectedItem(registro.getIdArea());
        txtId.setText(registro.getId());
        txtDni.setText(registro.getDni());
        txtFecNac.setText(registro.getfNacimiento());
        //cboCargo.setSelectedItem(registro.getIdCargo());
        //cboCargo.setSelectedItem(registro.getCargo());
        cboCargo.getModel().setSelectedItem(registro.getCargo());
        cboArea.getModel().setSelectedItem(registro.getArea());
        txtDistrito.setText(registro.getDistrito());
        
         switch(registro.getIdTipo()){
             case 1:
                 rbEstable.setSelected(true);
                 break;
             case 2:
                 rbPracticante.setSelected(true);
                 break;
             case 3:
                 rbPartime.setSelected(true);
                 break;
             default:
                 rbEstable.setSelected(false);
                 rbPracticante.setSelected(false);
                 rbPartime.setSelected(false);
                 
                 break;
         }
        //cboCargo.setSelectedItem(new Cargo(2, "Sub Gerente"));
//        Cargo c = new Cargo();
//        c.setIdCargo(2);
//        c.setDescripcion("Sub Gerente");
        //cboCargo.getModel().setSelectedItem(c);
    }
    public frmEmpleado(Empleados registro,Utilitario.EstadoProceso estado ) {
        
        initComponents();
        this.registro = registro;
        //  Establecer comandos para los radio buttons
        rbPracticante.setActionCommand("Practicante");
        rbEstable.setActionCommand("completo");
        rbPartime.setActionCommand("Partime");
        this.estadoProceso = estado;
 
        rbPartime.setSelected(true);

    }
    
    private void inicializaComboAreasYCargos() {
        // Cargar áreas
        
        List<Area> listaAreas = DatosEmpleados.listaAreas(); 
        DefaultComboBoxModel<Area> modeloAreas = new DefaultComboBoxModel<>();
        for (Area a : listaAreas) {
            modeloAreas.addElement(a);
        }
        cboArea.setModel(modeloAreas); 
        
        // Cargar cargos
        List<Cargo> listaCargos = DatosEmpleados.listaCargo(); 
        DefaultComboBoxModel<Cargo> modeloCargos = new DefaultComboBoxModel<>();
        for (Cargo c : listaCargos) {
            modeloCargos.addElement(c);
        }
        cboCargo.setModel(modeloCargos);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesTipo = new javax.swing.ButtonGroup();
        txtId = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecNac = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        cboArea = new javax.swing.JComboBox<>();
        txtDirec = new javax.swing.JTextField();
        txtCel = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rbEstable = new javax.swing.JRadioButton();
        rbPracticante = new javax.swing.JRadioButton();
        rbPartime = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnDatAcad = new javax.swing.JButton();

        opcionesTipo.add(rbEstable);
        opcionesTipo.add(rbPracticante);
        opcionesTipo.add(rbPartime);

        setClosable(true);
        setIconifiable(true);
        setTitle("EMPLEADOS");
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(850, 350));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(850, 350));
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

        txtId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtApe.setFocusCycleRoot(true);
        txtApe.setNextFocusableComponent(txtNom);
        txtApe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApeFocusLost(evt);
            }
        });

        txtNom.setNextFocusableComponent(txtFecNac);
        txtNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomFocusLost(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel4.setText("Apellidos:");

        jLabel3.setText("Nombres:");

        jLabel2.setText("Fecha de nacimiento:");

        txtFecNac.setNextFocusableComponent(txtCorreo);
        txtFecNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecNacKeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("dd/mm/aaaa");

        txtCorreo.setNextFocusableComponent(txtDni);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        jLabel5.setText("Correo:");

        cboCargo.setMaximumSize(new java.awt.Dimension(30, 22));
        cboCargo.setNextFocusableComponent(rbPartime);

        cboArea.setMaximumSize(new java.awt.Dimension(30, 22));
        cboArea.setNextFocusableComponent(cboCargo);
        cboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAreaActionPerformed(evt);
            }
        });

        txtDirec.setNextFocusableComponent(cboArea);
        txtDirec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirecFocusLost(evt);
            }
        });

        txtCel.setNextFocusableComponent(txtDistrito);
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelKeyTyped(evt);
            }
        });

        txtDni.setNextFocusableComponent(txtCel);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel7.setText("DNI:");

        jLabel6.setText("Celular:");

        jLabel8.setText("Dirección:");

        jLabel9.setText("Área:");

        jLabel11.setText("Cargo:");

        jLabel10.setText("Tip. Empleado");

        rbEstable.setText("completo");
        rbEstable.setNextFocusableComponent(btnGuardar);
        rbEstable.setActionCommand("Estable");
        rbEstable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEstableActionPerformed(evt);
            }
        });

        rbPracticante.setText("Practicante");
        rbPracticante.setNextFocusableComponent(btnGuardar);
        rbPracticante.setActionCommand("Practicante");
        rbPracticante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPracticanteActionPerformed(evt);
            }
        });

        rbPartime.setText("Partime");
        rbPartime.setNextFocusableComponent(btnGuardar);
        rbPartime.setActionCommand("Por definir...");

        jLabel14.setText("Distrito:");

        txtDistrito.setNextFocusableComponent(txtDirec);
        txtDistrito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDistritoFocusLost(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(30, 28));
        btnNuevo.setMinimumSize(new java.awt.Dimension(30, 28));
        btnNuevo.setName("nuevo"); // NOI18N
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setToolTipText("editor");
        btnEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setName("editar"); // NOI18N
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setName("cancelar"); // NOI18N
        btnCancelar.setNextFocusableComponent(txtApe);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelar);

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-doc-25.png"))); // NOI18N
        btnExportar.setToolTipText("Exportar a Excel");
        btnExportar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExportar.setMaximumSize(new java.awt.Dimension(35, 33));
        btnExportar.setMinimumSize(new java.awt.Dimension(35, 33));
        btnExportar.setName("exportar"); // NOI18N
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnDatAcad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-importar-25.png"))); // NOI18N
        btnDatAcad.setToolTipText("Registrar Datos Académicos");
        btnDatAcad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDatAcad.setMaximumSize(new java.awt.Dimension(35, 33));
        btnDatAcad.setMinimumSize(new java.awt.Dimension(35, 33));
        btnDatAcad.setName("registrar"); // NOI18N
        btnDatAcad.setPreferredSize(new java.awt.Dimension(50, 48));
        btnDatAcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatAcadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDatAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnExportar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnDatAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(13, 13, 13)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12))
                                    .addComponent(txtCorreo)
                                    .addComponent(txtNom)
                                    .addComponent(txtApe)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDirec))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbPartime)
                            .addComponent(rbEstable)
                            .addComponent(rbPracticante)
                            .addComponent(jLabel10)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEstable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbPracticante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbPartime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Habilitamos los campos:
//        tblEmpleados.clearSelection();
//        tblEmpleados.setRowSelectionAllowed(false);
        //DatosEmpleados.Habilitar(escritorio, opcionesTipo, true);
        String codigo = DatosEmpleados.GenerarCodigo("empleados", "IdEmpleado", "E", 4);
        txtId.setText(codigo);
        txtId.setEnabled(false);
        txtApe.requestFocus();

        esNuevo = true; // Indicamos que sera un nuevo registro
    }//GEN-LAST:event_btnNuevoActionPerformed
    private <T> T ObtenerIdCombo(JComboBox cbo,int indiceSeleccionado){
          //clase =  cbo.getModel().getElementAt(indiceSeleccionado);
        return (T)cbo.getModel().getElementAt(indiceSeleccionado);
    }
    private int ObtenerIdTipo(){
        int resultadoId = 0;
        if(rbEstable.isSelected()){
            resultadoId = 1;
        }else if(rbPracticante.isSelected()){
            resultadoId = 2;
        }else if(rbPartime.isSelected()){
            resultadoId = 3;
        }
        return resultadoId;
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Crear un objeto Empleados y asignar los valores
        Empleados empleado = new Empleados();
        empleado.setId(txtId.getText());
        empleado.setApellidos(txtApe.getText());
        empleado.setNombres(txtNom.getText());
        empleado.setfNacimiento(txtFecNac.getText());
        empleado.setCorreo(txtCorreo.getText());
        empleado.setDni(txtDni.getText());
        empleado.setCelular(txtCel.getText());
        empleado.setDistrito(txtDistrito.getText());
        empleado.setDireccion(txtDirec.getText());

        // Capturar los IDs reales desde métodos separados
        
        //empleado.setIdArea(Integer.parseInt(DatosEmpleados.CapturarArea(cboArea)));
        //empleado.setIdCargo(Integer.parseInt(DatosEmpleados.CapturarCargo(cboCargo)));
        //empleado.setIdTipo(Integer.parseInt(DatosEmpleados.CapturarTipoEmpleado(opcionesTipo)));
            
        //obtneer el id seleccion del combo
         int indice = 0;           
        //int idArea =  ((Area)this.cboArea.getModel().getSelectedItem()).getIdArea();
        Area areaSeleccionada = (Area)this.cboArea.getModel().getSelectedItem();
        empleado.setArea(areaSeleccionada);
         //empleado.setIdArea(idArea); 
         
        indice = 0;         
        
        //int idCargo = ((Cargo)this.cboCargo.getModel().getSelectedItem()).getIdCargo();
        //empleado.setIdCargo(idCargo);
        Cargo cargoSeleccionado = (Cargo)this.cboCargo.getModel().getSelectedItem();
        empleado.setCargo(cargoSeleccionado);
        
        empleado.setIdTipo(ObtenerIdTipo());
        
        
        // Insertar o actualizar según sea el caso
        if (estadoProceso == estadoProceso.NUEVO) {
            DatosEmpleados.Insertar(empleado);
            //DatosEmpleados.cargarTabla(this.tblEmpleados);
        } else if(estadoProceso == estadoProceso.EDITAR) {
            DatosEmpleados.Actualizar(empleado);
        }
        
        frmListaEmpleado.CargarLista();

        HabilitaBotonesMantenimiento(true);
        
  
        //actualizar la grilla del fromulario frmListaEmpleado
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Limpiamos y bloqueamos los campos:
        //DatosEmpleados.Limpiar(escritorio, rbPartime);
        //DatosEmpleados.Habilitar(escritorio, opcionesTipo, false);
        HabilitaBotonesMantenimiento(true);
        HabilitaControles(false);
        this.dispose();
        //tblEmpleados.clearSelection();
        //tblEmpleados.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnDatAcadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatAcadActionPerformed
        // TODO add your handling code here:
        Datosacad verventana = new Datosacad();
        
        //int fila = tblEmpleados.getSelectedRow();
        String dni = txtDni.getText();
        String[] datos = DatosEmpleados.DatAcadEmpleado(dni);

        
        String nombreCompleto = txtNom.getText() + " " + txtApe.getText();
        JComboBox[] combos = {verventana.cboInstitucion, verventana.cboFacultad, verventana.cboCarrera, verventana.cboCiclo};
        
         for (String dato : datos) {
                if (dato != null) {
                    for (JComboBox combo : combos) {
                        combo.setSelectedItem(dato);
                        if (dato.equals(datos[4])) {
                            verventana.txtCodEs.setText(dato);
                        }
                    }
                }
            }
         
            verventana.txtNomCom.setText(nombreCompleto);
            verventana.txtDni.setText(dni);
            //ver el formulario y su padre sea el jdesktopPane del menuPrincipal
            frmListaEmpleado.panelPadre.add((verventana));
            //escritorio.add(verventana);
            verventana.setVisible(true);
        

    }//GEN-LAST:event_btnDatAcadActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
//        try {
//            Exportar obj = new Exportar();
//            obj.exportarExcel(tblEmpleados);
//        } catch (IOException ex) {
//            Logger.getLogger(frmEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        // TODO add your handling code here:
        String text = txtCorreo.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtCorreo.setText(text);
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtFecNacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecNacKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_BACK_SPACE) {
            // permitir eliminar el carácter anterior incluso si es una diagonal
            String fecha = txtFecNac.getText();
            if (!fecha.isEmpty()) {
                // eliminar el último carácter de la cadena
                fecha = fecha.substring(0, fecha.length() - 1);
                txtFecNac.setText(fecha);
            }
        } else if (!Character.isDigit(c)) {
            evt.consume(); // Si no es un número, se ignora el evento de tecla
        }

        String fecha = txtFecNac.getText();
        int length = fecha.length();
        if (length == 2 || length == 5) { // Si se ha ingresado un día o un mes completo, se agrega el guión correspondiente
            fecha += "/";
            txtFecNac.setText(fecha);
        }

        if (length >= 10) {
            evt.consume(); // Si ya se ha ingresado la fecha completa, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtFecNacKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();
        }
        if (txtCel.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelKeyTyped

    private void txtNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusLost
        // TODO add your handling code here:
        String text = txtNom.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtNom.setText(text);
    }//GEN-LAST:event_txtNomFocusLost

    private void txtApeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeFocusLost
        // TODO add your handling code here:
        String text = txtApe.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtApe.setText(text);
    }//GEN-LAST:event_txtApeFocusLost

    private void txtDirecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecFocusLost
        // TODO add your handling code here:
        String text = txtDirec.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtDirec.setText(text);
    }//GEN-LAST:event_txtDirecFocusLost

    private void txtDistritoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDistritoFocusLost
        // TODO add your handling code here:
        String text = txtDistrito.getText().trim(); // Eliminamos los espacios del inicio y del final
        txtDistrito.setText(text);
    }//GEN-LAST:event_txtDistritoFocusLost

    private void rbEstableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEstableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEstableActionPerformed

    private void rbPracticanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPracticanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPracticanteActionPerformed
    private void HabilitaBotonesMantenimiento(boolean estado){
        
            btnNuevo.setEnabled(estado);
            btnEditar.setEnabled(estado);
            btnEliminar.setEnabled(estado);
            btnGuardar.setEnabled(!estado);
            btnCancelar.setEnabled(!estado);
    }
    private void HabilitaControles(boolean estado){
        this.txtApe.setEnabled(estado);
        this.txtCel.setEnabled(estado);
        this.txtCorreo.setEnabled(estado);
        this.txtDirec.setEnabled(estado);
        this.txtDistrito.setEnabled(estado);
        this.txtDni.setEnabled(estado);
        this.txtFecNac.setEnabled(estado);
        this.txtId.setEnabled(estado);
        this.txtNom.setEnabled(estado);
        this.cboArea.setEnabled(estado);
        this.cboCargo.setEnabled(estado);
        this.rbEstable.setEnabled(estado);
        this.rbPartime.setEnabled(estado);
        this.rbPracticante.setEnabled(estado);
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //validar si trae registro desde el formulario principal
        if(this.estadoProceso == estadoProceso.NUEVO){
            registro = null;
            HabilitaBotonesMantenimiento(false);
            HabilitaControles(true);
            
            String codigo = DatosEmpleados.GenerarCodigo("empleados", "IdEmpleado", "E", 4);
            txtId.setText(codigo);
            inicializaComboAreasYCargos();
            esNuevo = true;
        }else if(this.estadoProceso == estadoProceso.EDITAR){
            inicializaComboAreasYCargos();
            ObtenerDatos();
            HabilitaBotonesMantenimiento(false);
        }
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void cboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAreaActionPerformed
        if(this.cboArea.getSelectedIndex()>-1){
            int indice = this.cboArea.getSelectedIndex();
            Area registro = this.cboArea.getModel().getElementAt(indice);
            System.err.println("Area valor id:" + registro.getIdArea());
        }
        
    }//GEN-LAST:event_cboAreaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Agrupar las cajas de texto
        JTextField[] campos = {txtId, txtApe, txtNom, txtFecNac, txtCorreo,
            txtDni, txtCel, txtDistrito, txtDirec};

        // Agrupar los combo boxes y cargar el radio button correspondiente
        // que esta en el button group
        JComboBox[] combos = {cboArea, cboCargo};
        //DatosEmpleados.Editar(escritorio,  campos, combos, opcionesTipo);

        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Eliminamos el registro seleccionado y bloqueamos los campos
        boolean respuesta = Utilitario.MostrarMensajePregunta("¿Desea elminar el registro?", Utilitario.TipoMensaje.pregunta);
        if(respuesta == true){
            //DatosEmpleados.Eliminar(tblEmpleados);
        }
        //actualizar la lista del formulario padre
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDatAcad;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<Area> cboArea;
    private javax.swing.JComboBox<Cargo> cboCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.ButtonGroup opcionesTipo;
    private javax.swing.JRadioButton rbEstable;
    private javax.swing.JRadioButton rbPartime;
    private javax.swing.JRadioButton rbPracticante;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFecNac;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
