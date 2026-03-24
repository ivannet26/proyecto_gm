package proyecto_gm.Perfil;

/**
 *
 * @author Cristian
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosPerfil {
    
    static final Connection conn = ConexionBD.getConnection();

    public static List<Perfil> listar() {
        List<Perfil> listaPerfiles = new ArrayList<>();
        try {
            try (CallableStatement stmt = conn.prepareCall("CALL listar_perfiles()");
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Perfil perfil = new Perfil(rs.getString("codperfil"), rs.getString("nomperfil"));
                    listaPerfiles.add(perfil);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar perfiles: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return listaPerfiles;
    }

    // Método para insertar un perfil
    public static boolean insertar(Perfil perfil) {
        boolean exito = false;
        try {
            try (CallableStatement stmt = conn.prepareCall("{CALL insertar_perfil(?, ?, ?)}")) {
                stmt.setString(1, perfil.getCodigo());
                stmt.setString(2, perfil.getNombre());
                stmt.setString(3, "01");  // Codmodulo está fijo como "01"
                if (stmt.executeUpdate() > 0) exito = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar perfil: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return exito;
    }

    // Método para actualizar un perfil
    public static boolean actualizar(Perfil perfil) {
        boolean exito = false;
        try {
            try (CallableStatement stmt = conn.prepareCall("{CALL actualizar_perfil(?, ?, ?)}")) {
                stmt.setString(1, perfil.getCodigo());
                stmt.setString(2, perfil.getNombre());
                stmt.setString(3, "01");  
                if (stmt.executeUpdate() > 0) exito = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar perfil: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return exito;
    }

    // Método para eliminar un perfil
    public static boolean eliminar(String codigo) {
        boolean exito = false;
        try {
            try (CallableStatement stmt = conn.prepareCall("{CALL eliminar_perfil(?, ?)}")) {
                stmt.setString(1, codigo);
                stmt.setString(2, "01");  
                stmt.execute();
                exito = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar perfil: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return exito;
    }
}
