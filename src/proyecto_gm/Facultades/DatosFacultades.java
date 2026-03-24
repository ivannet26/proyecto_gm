package proyecto_gm.Facultades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosFacultades {
    static final Connection conn = ConexionBD.getConnection();
    public static List<Facultades> listar() {
            List<Facultades> lista = new ArrayList<>();
            try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_facultades() }")) {
                ResultSet rs = cstmt.executeQuery();
                while (rs.next()) {
                    Facultades facultad = new Facultades();
                    facultad.setId(rs.getInt("IdFacultad"));
                    facultad.setDescripcion(rs.getString("descripcion"));
                    lista.add(facultad);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al listar facultades: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            }
            return lista;
        }

    public static void insertar(Facultades facultad) {
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_facultades(?) }")) {
            cstmt.setString(1, facultad.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Facultad registrada exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar facultad: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizar(Facultades facultad) {

        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_facultades(?, ?) }")) {
            cstmt.setInt(1, facultad.getId());
            cstmt.setString(2, facultad.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Facultad actualizada exitosamente.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar facultad: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(int id) {
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_facultades(?) }")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Facultad eliminada exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar facultad: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
