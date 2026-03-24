package proyecto_gm.Instituciones;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosInstituciones {

    static Connection conn = ConexionBD.getConnection();

    public static void mostrarDatos(DefaultTableModel modelo) {
        modelo.setRowCount(0); 
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_instituciones()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("IdInstitucionEducativa"),
                    rs.getString("Ruc"),
                    rs.getString("RazonSocial"),
                    rs.getString("Direccion"),
                    rs.getString("Sede")};
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void insertarDatos(Instituciones institucion, JTable tabla) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL insertar_instituciones(?, ?, ?, ?) }");
            cstmt.setString(1, institucion.getRuc());
            cstmt.setString(2, institucion.getRazonSocial());
            cstmt.setString(3, institucion.getDireccion());
            cstmt.setString(4, institucion.getSede());
            cstmt.execute();
            cstmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizarDatos(Instituciones institucion) {
        try {
            CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_instituciones(?, ?, ?, ?, ?) }");
            cstmt.setString(1, institucion.getId());
            cstmt.setString(2, institucion.getRuc());
            cstmt.setString(3, institucion.getRazonSocial());
            cstmt.setString(4, institucion.getDireccion());
            cstmt.setString(5, institucion.getSede());
            cstmt.execute();
            cstmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void eliminarDatos(JTable tabla, int filaModelo) { 
    String id = tabla.getModel().getValueAt(filaModelo, 0).toString(); 
    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try (CallableStatement stmt = conn.prepareCall("{ CALL eliminar_instituciones(?) }")) {
            stmt.setString(1, id);
            stmt.execute();

            ((DefaultTableModel) tabla.getModel()).removeRow(filaModelo); 
            JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
      }
   }

    public static boolean validarNumeros(String datos) {
        return datos.matches("[0-9]*");
    }
    
    public static boolean insertarDesdeExcel(String ruc, String razon, String direccion, String sede) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_instituciones(?, ?, ?, ?) }")) {
            cstmt.setString(1, ruc);
            cstmt.setString(2, razon);
            cstmt.setString(3, direccion);
            cstmt.setString(4, sede);
            cstmt.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Error en inserción individual: " + ex.getMessage());
            return false;
        }
    }
}
