package proyecto_gm.RecibosHonorarios;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosRecibosHonorarios {

    static Connection conn;

    static {
        conn = ConexionBD.getConnection();
        if (conn == null) {
            System.err.println("Error: no se pudo conectar a la base de datos.");
        }
    }


    public static String GenerarCodigo() {
        String codigoGenerado = "";
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            cstmt.setString(1, "reciboshonorarios");
            cstmt.setString(2, "IdReciboHonorario");
            cstmt.registerOutParameter(3, Types.INTEGER);

            cstmt.execute();

            int idGenerado = cstmt.getInt(3); // Recibe directamente el número
            codigoGenerado = String.valueOf(idGenerado);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return codigoGenerado;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try (PreparedStatement pstmt = conn.prepareStatement("CALL listar_recibos_honorarios()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("Id"),
                    rs.getString("NroRecibo"),
                    rs.getString("Ruc"),
                    rs.getString("Nombres"),
                    rs.getString("Apellidos"),
                    rs.getString("Distrito"),
                    rs.getString("Direccion"),
                    rs.getString("FormaPago"),
                    rs.getString("Concepto"),
                    rs.getString("ImporteNeto"),
                    rs.getString("RetencionIr"),
                    rs.getString("ImporteTotal"),
                    rs.getDate("FechaEmision")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static boolean Insertar(ReciboHonorario rec, JTable tabla) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_recibo_honorario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }")) {

            cstmt.setString(1, rec.getNroRecibo());
            cstmt.setString(2, rec.getRuc());
            cstmt.setString(3, rec.getNombres());
            cstmt.setString(4, rec.getApellidos());
            cstmt.setString(5, rec.getDistrito());
            cstmt.setString(6, rec.getDireccion());
            cstmt.setString(7, rec.getFormaPago());
            cstmt.setString(8, rec.getConcepto());
            cstmt.setFloat(9, rec.getImporteNeto());
            cstmt.setFloat(10, rec.getRetencionIr());
            cstmt.setFloat(11, rec.getImporteTotal());

            // ✅ ahora usamos la fecha desde el objeto ReciboHonorario
            if (rec.getFecha() != null) {
                cstmt.setDate(12, new java.sql.Date(rec.getFecha().getTime()));
            } else {
                cstmt.setNull(12, java.sql.Types.DATE);
            }

            cstmt.execute();

            JOptionPane.showMessageDialog(null, "Recibo registrado satisfactoriamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);
            tabla.setModel(modelo); 
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void Actualizar(ReciboHonorario recibo, JTable tabla) {
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Error: La conexión a la base de datos no está inicializada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CallableStatement cstmt = null;
        try {
            // Tomamos el código del recibo y limpiamos espacios
            String codigo = recibo.getCodigoRecibo() != null ? recibo.getCodigoRecibo().trim() : "";
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código del recibo no está definido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Extraemos solo los números del código
            String numeros = codigo.replaceAll("[^0-9]", "");
            if (numeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código del recibo no contiene un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(numeros); // ✅ ID listo para la BD

            // Preparamos la llamada al procedimiento almacenado
            cstmt = conn.prepareCall("{ CALL actualizar_recibo_honorario(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setInt(1, id);
            cstmt.setString(2, recibo.getNroRecibo());
            cstmt.setString(3, recibo.getRuc());
            cstmt.setString(4, recibo.getNombres());
            cstmt.setString(5, recibo.getApellidos());
            cstmt.setString(6, recibo.getDistrito());
            cstmt.setString(7, recibo.getDireccion());
            cstmt.setString(8, recibo.getFormaPago());
            cstmt.setString(9, recibo.getConcepto());
            cstmt.setFloat(10, recibo.getImporteNeto());
            cstmt.setFloat(11, recibo.getRetencionIr());
            cstmt.setFloat(12, recibo.getImporteTotal());

            // Fecha
            java.util.Date fechaUtil = recibo.getFecha();
            if (fechaUtil != null) {
                cstmt.setDate(13, new java.sql.Date(fechaUtil.getTime()));
            } else {
                cstmt.setNull(13, java.sql.Types.DATE);
            }

            cstmt.execute();

            // Refrescar tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosRecibosHonorarios.Mostrar(modelo);

            JOptionPane.showMessageDialog(null, "Recibo actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) cstmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    public static void Eliminar(JTable tabla) {
        CallableStatement cstmt = null;
        try {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                Object[] opciones = {"Sí", "No"};
                int opcion = JOptionPane.showOptionDialog(
                        null, 
                        "¿Está seguro de que quiere eliminar la fila seleccionada?", 
                        "Confirmación", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        opciones, 
                        opciones[0]
                );
                
                if (opcion == 0) {
                    String id = tabla.getModel().getValueAt(fila, 0).toString();

                    cstmt = conn.prepareCall("{ CALL eliminar_recibo_honorario(?) }");
                    cstmt.setString(1, id);
                    cstmt.execute();

                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);

                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    tabla.clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean Validar(JTextField[] campos, JComboBox[] combos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                campo.requestFocus();
                return false;
            }
        }

        for (JComboBox combo : combos) {
            if (combo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(
                        null, "Debe escoger un distrito y una forma de pago.", "Advertencia", JOptionPane.WARNING_MESSAGE
                );
                combo.requestFocus();
                return false;
            }
        }

        if (campos[0].getText().length() != 11) {
            JOptionPane.showMessageDialog(null, "El RUC debe contener 11 dígitos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            campos[0].requestFocus();
            return false;
        }
        return true;
    }

    public static void Limpiar(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof JComboBox) {
                ((JComboBox) componente).setSelectedIndex(-1);
            } else if (componente instanceof Container) {
                Limpiar((Container) componente);
            } else {
            }
        }
    }

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();

            camposTexto[0].setText(tabla.getValueAt(filaSeleccionada, 0).toString());
            camposTexto[1].setText(tabla.getValueAt(filaSeleccionada, 1).toString());
            camposTexto[2].setText(tabla.getValueAt(filaSeleccionada, 2).toString());
            camposTexto[3].setText(tabla.getValueAt(filaSeleccionada, 3).toString());
            camposTexto[4].setText(tabla.getValueAt(filaSeleccionada, 4).toString());
            camposTexto[5].setText(tabla.getValueAt(filaSeleccionada, 5).toString());
            camposTexto[6].setText(tabla.getValueAt(filaSeleccionada, 6).toString());
            camposTexto[7].setText(tabla.getValueAt(filaSeleccionada, 7).toString());
            camposTexto[8].setText(tabla.getValueAt(filaSeleccionada, 8).toString());
            camposTexto[9].setText(tabla.getValueAt(filaSeleccionada, 9).toString());
            camposTexto[10].setText(tabla.getValueAt(filaSeleccionada, 10).toString());

            String distrito = tabla.getValueAt(filaSeleccionada, 5).toString();
            String pago = tabla.getValueAt(filaSeleccionada, 7).toString();

            for (int i = 0; i < combos[0].getItemCount(); i++) {
                if (combos[0].getItemAt(i).equals(distrito)) {
                    combos[0].setSelectedIndex(i);  // Seleccionar la categoría correspondiente
                    break;
                }
            }

            for (int i = 0; i < combos[1].getItemCount(); i++) {
                if (combos[1].getItemAt(i).equals(pago)) {
                    combos[1].setSelectedIndex(i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para editar.");
        }
    }
}
