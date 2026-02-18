package proyecto_gm.Horarios;

import javax.swing.JOptionPane;
import proyecto_gm.Empleado.Empleados;

public class frmHorarios extends javax.swing.JInternalFrame {

    private frmListaHorarios frmLista;
    private Horarios horarioActual;
    private Empleados empleadoActual;
    private boolean esNuevo;


    public frmHorarios(frmListaHorarios parent, Empleados empleado, Horarios horario) {
        initComponents();
        this.frmLista = parent;
        this.empleadoActual = empleado;
        this.horarioActual = horario;

        if (horarioActual == null) {
            setTitle("Nuevo Horario");
            esNuevo = true;
            lblDNI.setText(empleado.getDni());
            lblDatos.setText(empleado.getNombres() + " " + empleado.getApellidos());
        } else {
            setTitle("Editar Horario");
            esNuevo = false;
            cargarDatos();
        }

        lblDNI.setEnabled(false);
        lblDatos.setEnabled(false);

        this.setVisible(true);  
    }

    private void cargarDatos() {
        lblDNI.setText("DNI: " + horarioActual.getDni());
        lblDatos.setText("Celular: " + horarioActual.getCelular());

        txtLunesE.setText(horarioActual.getLunes_he());
        txtLunesS.setText(horarioActual.getLunes_hs());
        txtMartesE.setText(horarioActual.getMartes_he());
        txtMartesS.setText(horarioActual.getMartes_hs());
        txtMiercolesE.setText(horarioActual.getMiercoles_he());
        txtMiercolesS.setText(horarioActual.getMiercoles_hs());
        txtJuevesE.setText(horarioActual.getJueves_he());
        txtJuevesS.setText(horarioActual.getJueves_hs());
        txtViernesE.setText(horarioActual.getViernes_he());
        txtViernesS.setText(horarioActual.getViernes_hs());
        txtSabadoE.setText(horarioActual.getSabado_he());
        txtSabadoS.setText(horarioActual.getSabado_hs());
        txtDomingoE.setText(horarioActual.getDomingo_he());
        txtDomingoS.setText(horarioActual.getDomingo_hs());
    }

    private boolean validarCampos() {
        if (txtLunesE.getText().trim().isEmpty() || txtLunesS.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar al menos el horario del lunes.", "Validación", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        javax.swing.JTextField[] camposHora = {
            txtLunesE, txtLunesS,
            txtMartesE, txtMartesS,
            txtMiercolesE, txtMiercolesS,
            txtJuevesE, txtJuevesS,
            txtViernesE, txtViernesS,
            txtSabadoE, txtSabadoS,
            txtDomingoE, txtDomingoS
        };

        String formatoHora = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        for (javax.swing.JTextField campo : camposHora) {
            String hora = campo.getText().trim();
            if (!hora.isEmpty()) {
                if (!hora.matches(formatoHora)) {
                    JOptionPane.showMessageDialog(this, 
                        "Error de formato en: \"" + hora + "\"\n" +
                        "Por favor use el formato HH:mm (Ejemplo: 08:00, 13:30)", 
                        "Formato Incorrecto", JOptionPane.ERROR_MESSAGE);
                    campo.requestFocus();
                    return false;
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblDNI = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDatos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtLunesE = new javax.swing.JTextField();
        txtMartesE = new javax.swing.JTextField();
        txtMiercolesE = new javax.swing.JTextField();
        txtJuevesE = new javax.swing.JTextField();
        txtViernesE = new javax.swing.JTextField();
        txtSabadoE = new javax.swing.JTextField();
        txtLunesS = new javax.swing.JTextField();
        txtDomingoE = new javax.swing.JTextField();
        txtMartesS = new javax.swing.JTextField();
        txtMiercolesS = new javax.swing.JTextField();
        txtJuevesS = new javax.swing.JTextField();
        txtViernesS = new javax.swing.JTextField();
        txtSabadoS = new javax.swing.JTextField();
        txtDomingoS = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel2.setText("-");

        jLabel3.setText("DIA");

        jLabel4.setText("HORA ENTRADA");

        jLabel5.setText("HORA SALIDA");

        jLabel6.setText("LUNES");

        jLabel7.setText("MARTES");

        jLabel8.setText("MIERCOLES");

        jLabel9.setText("JUEVES");

        jLabel10.setText("VIERNES");

        jLabel11.setText("SABADO");

        jLabel12.setText("DOMINGO");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("DNI:");

        jLabel13.setText("Empleado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtLunesE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txtLunesS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMartesE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMiercolesE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJuevesE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViernesE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSabadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDomingoE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMartesS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMiercolesS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJuevesS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViernesS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSabadoS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDomingoS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel4)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(lblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 14, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLunesE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtLunesS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMartesS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMartesE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMiercolesS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMiercolesE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJuevesS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJuevesE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViernesS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViernesE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSabadoS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSabadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomingoS, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDomingoE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       // 1. VALIDACIÓN (La misma para Nuevo y Editar)
        // Si las horas están mal escritas, se detiene aquí y no guarda nada.
        if (!validarCampos()) return;

        // 2. PREPARAR EL OBJETO
        Horarios h;
        
        if (esNuevo) {
            h = new Horarios(); // Si es nuevo, creamos uno de cero
            h.setDni(empleadoActual.getDni()); // Le ponemos el DNI del empleado seleccionado
            h.setCelular(empleadoActual.getCelular());
        } else {
            h = horarioActual; // Si es editar, usamos el que ya existía (para conservar el ID)
            // No cambiamos DNI ni Nombre porque eso no se edita
        }

        // 3. LLENAR LAS HORAS (Esto es igual para ambos)
        h.setLunes_he(txtLunesE.getText().trim());
        h.setLunes_hs(txtLunesS.getText().trim());
        
        h.setMartes_he(txtMartesE.getText().trim());
        h.setMartes_hs(txtMartesS.getText().trim());
        
        h.setMiercoles_he(txtMiercolesE.getText().trim());
        h.setMiercoles_hs(txtMiercolesS.getText().trim());
        
        h.setJueves_he(txtJuevesE.getText().trim());
        h.setJueves_hs(txtJuevesS.getText().trim());
        
        h.setViernes_he(txtViernesE.getText().trim());
        h.setViernes_hs(txtViernesS.getText().trim());
        
        h.setSabado_he(txtSabadoE.getText().trim());
        h.setSabado_hs(txtSabadoS.getText().trim());
        
        h.setDomingo_he(txtDomingoE.getText().trim());
        h.setDomingo_hs(txtDomingoS.getText().trim());

        // 4. GUARDAR EN BASE DE DATOS
        if (esNuevo) {
            DatosHorarios.insertar(h); // Llama al INSERT
        } else {
            DatosHorarios.actualizar(h); // Llama al UPDATE
        }

        // 5. ACTUALIZAR LA TABLA DE ATRÁS Y CERRAR
        if (frmLista != null) {
            frmLista.cargarDatos(); // Refresca la lista grande
        }
        this.dispose(); // Cierra la ventanita
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JTextField txtDomingoE;
    private javax.swing.JTextField txtDomingoS;
    private javax.swing.JTextField txtJuevesE;
    private javax.swing.JTextField txtJuevesS;
    private javax.swing.JTextField txtLunesE;
    private javax.swing.JTextField txtLunesS;
    private javax.swing.JTextField txtMartesE;
    private javax.swing.JTextField txtMartesS;
    private javax.swing.JTextField txtMiercolesE;
    private javax.swing.JTextField txtMiercolesS;
    private javax.swing.JTextField txtSabadoE;
    private javax.swing.JTextField txtSabadoS;
    private javax.swing.JTextField txtViernesE;
    private javax.swing.JTextField txtViernesS;
    // End of variables declaration//GEN-END:variables
}
