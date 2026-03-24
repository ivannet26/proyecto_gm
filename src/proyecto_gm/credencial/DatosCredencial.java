package proyecto_gm.credencial;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;


public class DatosCredencial {
    
    static final Connection conn = ConexionBD.getConnection();

    public static List<Credencial> listar() {
        List<Credencial> lista = new ArrayList<>();
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_credencial() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Credencial c = new Credencial();
                c.setIdCredencial(rs.getString("IdCredencial"));
                c.setCorreo(rs.getString("Correo"));
                c.setClave(rs.getString("Clave"));
                c.setAlias(rs.getString("Alias"));
                c.setDescripcion(rs.getString("Descripcion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar credenciales: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public static void insertar(Credencial c) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_credencial(?, ?, ?, ?) }")) {
            cstmt.setString(1, c.getCorreo());
            cstmt.setString(2, c.getClave());
            cstmt.setString(3, c.getAlias());
            cstmt.setString(4, c.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Credencial registrada exitosamente.", "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar credencial: " + ex.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizar(Credencial c) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_credencial(?, ?, ?, ?, ?) }")) {
            cstmt.setString(1, c.getIdCredencial());
            cstmt.setString(2, c.getCorreo());
            cstmt.setString(3, c.getClave());
            cstmt.setString(4, c.getAlias());
            cstmt.setString(5, c.getDescripcion());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Credencial actualizada exitosamente.", "Actualización Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar credencial: " + ex.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminar(String id) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_credencial(?) }")) {
            cstmt.setString(1, id);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Credencial eliminada exitosamente.", "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar credencial: " + ex.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
