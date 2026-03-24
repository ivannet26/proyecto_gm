package proyecto_gm.Modulo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosModulo {

    static final Connection conn = ConexionBD.getConnection();
    
    public static void listar(DefaultTableModel modelo) {
        // Limpiamos el modelo para evitar datos duplicados
        modelo.setRowCount(0);

        // Procedimiento almacenado para listar
        String sql = "{CALL listar_modulo()}";

        try (CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {

            // Columnas que se mostrarán en la tabla
            String[] cabeceras = {"ID", "Descripción"};
            modelo.setColumnIdentifiers(cabeceras);

            while (rs.next()) { 
                Object[] fila = new Object[]{  
                    rs.getInt("IdModulo"),
                    rs.getString("Descripcion")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar módulos: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean insertar(Modulo modulo) {
        // Procedimiento almacenado para insertar
        String sql = "{CALL insertar_modulo(?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, 0);
            cstmt.setString(2, modulo.getDescripcion());
            cstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar módulo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean actualizar(Modulo modulo) {
        // Procedimiento almacenado para actualizar
        String sql = "{CALL actualizar_modulo(?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, modulo.getId());
            cstmt.setString(2, modulo.getDescripcion());
            cstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar módulo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean eliminar(int id) {
        // Procedimiento almacenado para eliminar
        String sql = "{CALL eliminar_modulo(?)}"; 

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, id);
            cstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar módulo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}