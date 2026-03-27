package proyecto_gm.CabeceraComprobante;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import proyecto_gm.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;

public class DatosCabeceraComprobante {

    static Connection conn = ConexionBD.getConnection();


    // Cargar opciones para los combo boxes
    public static void CargarCombo(JComboBox cboProveedores, JComboBox cboTipoDocumento) {
        try {
            // Preparamos la consultas
            PreparedStatement pstmtProveedores = conn.prepareStatement("SELECT Nombres FROM proveedores");
            PreparedStatement pstmtTipoDocumento = conn.prepareStatement("SELECT Descripcion FROM tiposdocumentos");

            // Las ejecutamos
            ResultSet proveedores = pstmtProveedores.executeQuery();
            ResultSet tiposdocumentos = pstmtTipoDocumento.executeQuery();

            // Agregamos los provedores
            while (proveedores.next()) {
                String nomProveedores = proveedores.getString("Nombres");
                cboProveedores.addItem(nomProveedores);
            }
            // Agregamos los Tipo doc
            while (tiposdocumentos.next()) {
                String nomTiposDocumentos = tiposdocumentos.getString("Descripcion");
                cboTipoDocumento.addItem(nomTiposDocumentos);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Mostrar datos
    public static void Listar(DefaultTableModel modelo) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("CALL listar_cabeceracomprobante()");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString("Numero de Comprobante"), rs.getString("Fecha de Emision"),
                    rs.getString("Fecha de Vencimiento"), rs.getString("Sub Total"), rs.getString("Igv"), rs.getString("Total"), rs.getString("Proveedores"),
                    rs.getString("Tipo de Documento")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Insertar(CabeceraComprobante cab, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cabeceracomprobante(?, ?, ?, ?,?,?, ?, ?) }");

            cstmt.setString(1, cab.getNumeroComprobante());
            cstmt.setString(2, cab.getFechaEmision());
            cstmt.setString(3, cab.getFechaVencimiento());
            cstmt.setFloat(4, cab.getSubTotal());
            cstmt.setFloat(5, cab.getIgv());
            cstmt.setFloat(6, cab.getTotal());
            cstmt.setString(7, cab.getIdProveedores());
            cstmt.setString(8, cab.getIdTipoDocumento());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosCabeceraComprobante.Listar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Actualizar(CabeceraComprobante cab, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL actualizar_cabeceracomprobante(?, ?, ?, ?, ?, ?, ?, ?) }");

            cstmt.setString(1, cab.getNumeroComprobante());
            cstmt.setString(2, cab.getFechaEmision());
            cstmt.setString(3, cab.getFechaVencimiento());
            cstmt.setFloat(4, cab.getSubTotal());
            cstmt.setFloat(5, cab.getIgv());
            cstmt.setFloat(6, cab.getTotal());
            cstmt.setString(7, cab.getIdProveedores());
            cstmt.setString(8, cab.getIdTipoDocumento());
            cstmt.execute();

            // Actualizamos la tabla
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);

            DatosCabeceraComprobante.Listar(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar datos
    public static void Eliminar(JTable tabla) {
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

                    CallableStatement stmt = conn.prepareCall("{ CALL eliminar_cabeceracomprobante(?) }");
                    stmt.setString(1, id);
                    stmt.execute();

                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
        

    
