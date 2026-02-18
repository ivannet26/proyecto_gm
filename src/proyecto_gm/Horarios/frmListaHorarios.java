package proyecto_gm.Horarios;

import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import proyecto_gm.Empleado.DatosEmpleados;
import proyecto_gm.Empleado.Empleados;

public class frmListaHorarios extends javax.swing.JInternalFrame {
    private static frmListaHorarios instancia;
    DefaultTableModel modelo;
    List<Horarios> listaHorarios;
    TableRowSorter<DefaultTableModel> sorter;

public frmListaHorarios() {
        initComponents();

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Celular");
        modelo.addColumn("Lunes");
        modelo.addColumn("Martes");
        modelo.addColumn("Miércoles");
        modelo.addColumn("Jueves");
        modelo.addColumn("Viernes");
        modelo.addColumn("Sábado");
        modelo.addColumn("Domingo");
        tblHorario.setModel(modelo);
 
        sorter = new TableRowSorter<>(modelo);
        tblHorario.setRowSorter(sorter);
        
        cargarDatos(); 
        
        this.setSize(1100, 600);
        this.setLocation(0, 0);
        this.setVisible(true);
    }

    public static frmListaHorarios getInstancia() {
        if (instancia == null) {
            instancia = new frmListaHorarios();
        }
        return instancia;
    }

    @Override
    public void dispose() {
        super.dispose();
        instancia = null;
    }

    public void cargarDatos() {
        modelo.setRowCount(0);
        listaHorarios = DatosHorarios.listar();

        for (Horarios h : listaHorarios) {
            modelo.addRow(new Object[]{
                h.getIdhorario(),
                h.getDni(),
                h.getCelular(),
                h.getLunes_he() + " - " + h.getLunes_hs(),
                h.getMartes_he() + " - " + h.getMartes_hs(),
                h.getMiercoles_he() + " - " + h.getMiercoles_hs(),
                h.getJueves_he() + " - " + h.getJueves_hs(),
                h.getViernes_he() + " - " + h.getViernes_hs(),
                h.getSabado_he() + " - " + h.getSabado_hs(),
                h.getDomingo_he() + " - " + h.getDomingo_hs()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("HORARIOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla"));

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "TELEFONO", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ));
        jScrollPane1.setViewportView(tblHorario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnAgregar.setToolTipText("Nuevo");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 921, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1131, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed


        List<Empleados> todosLosEmpleados = proyecto_gm.Empleado.DatosEmpleados.listar();
        List<Horarios> horariosOcupados = DatosHorarios.listar();
        
        java.util.ArrayList<Empleados> empleadosDisponibles = new java.util.ArrayList<>();

        for (Empleados emp : todosLosEmpleados) {
            boolean estaOcupado = false;
            
            for (Horarios h : horariosOcupados) {
                if (h.getDni() != null && h.getDni().equals(emp.getDni())) {
                    estaOcupado = true;
                    break; 
                }
            }
            
            if (!estaOcupado) {
                empleadosDisponibles.add(emp);
            }
        }

        if (empleadosDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "¡No hay empleados pendientes!\nTodos tienen un horario asignado.", 
                "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] opciones = new String[empleadosDisponibles.size()];
        for (int i = 0; i < empleadosDisponibles.size(); i++) {
            Empleados e = empleadosDisponibles.get(i);
            String texto = e.getDni() + " - " + e.getNombres() + " " + e.getApellidos();
            opciones[i] = texto;
        }

        String seleccion = (String) JOptionPane.showInputDialog(
                this, 
                "Seleccione un empleado para crear su horario:", 
                "Empleados Sin Horario",
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
        );

        if (seleccion != null) {

            int indice = -1;
            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].equals(seleccion)) {
                    indice = i;
                    break;
                }
            }
            
            if (indice != -1) {

                Empleados empSeleccionado = empleadosDisponibles.get(indice);

                frmHorarios frm = new frmHorarios(this, empSeleccionado, null);
                
                javax.swing.JDesktopPane desktop = this.getDesktopPane();
                if (desktop != null) {
                    desktop.add(frm);
                    frm.setVisible(true);
                    frm.toFront();
                } else {
                    this.getParent().add(frm);
                    frm.setVisible(true);
                    frm.toFront();
                }
            }
        }           
    }   

    private void abrirFormularioHorario(Empleados emp, Horarios hor) {
        frmHorarios frm = new frmHorarios(this, emp, hor);
        javax.swing.JDesktopPane desktop = this.getDesktopPane();
        if (desktop != null) {
            desktop.add(frm);
            frm.setVisible(true);
            frm.toFront();
        } else {
            this.getParent().add(frm);
            frm.setVisible(true);
            frm.toFront();
        }      
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int fila = tblHorario.getSelectedRow();     
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un horario para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Horarios seleccionado = listaHorarios.get(tblHorario.convertRowIndexToModel(fila));
        Empleados emp = proyecto_gm.Empleado.DatosEmpleados.buscarEmpleadoLocal(seleccionado.getDni());
        if (emp != null) {
            frmHorarios frm = new frmHorarios(this, emp, seleccionado);
            javax.swing.JDesktopPane desktop = this.getDesktopPane();
            if (desktop != null) {
                desktop.add(frm);
                frm.setVisible(true);
                frm.toFront();
            } else {
                this.getParent().add(frm);
                frm.setVisible(true);
                frm.toFront();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron datos del empleado (DNI: " + seleccionado.getDni() + ")", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblHorario.getSelectedRow();
        if (fila >= 0) {
            Horarios seleccionado = listaHorarios.get(tblHorario.convertRowIndexToModel(fila));

            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Seguro que deseas eliminar el horario de este empleado?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DatosHorarios.eliminar(seleccionado.getIdhorario());
                cargarDatos();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un horario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables
}
