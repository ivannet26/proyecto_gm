package proyecto_gm.Departamentos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosDepartamentos {
    
    static final Connection conn = ConexionBD.getConnection();
    
    public List<Departamentos> listar() {
        List<Departamentos> lista = new ArrayList<>();
        // Usamos try-with-resources para asegurar que la conexión se cierre
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_departamentos() }");
             ResultSet rs = cstmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("IdDepartamento");
                String descripcion = rs.getString("Descripcion");
                Departamentos depto = new Departamentos(id, descripcion);
                lista.add(depto);
            }
        } catch (SQLException ex) {
            System.err.println("Error al listar departamentos: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al listar datos: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public boolean insertar(Departamentos departamento) {
      // Asumiendo que el SP para insertar solo necesita la descripción
      String sql = "{ CALL insertar_departamentos(?, ?) }"; 
      try (CallableStatement cstmt = conn.prepareCall(sql)) {
          cstmt.setInt(1, 0);
          cstmt.setString(2, departamento.getDescripcion());
          return cstmt.executeUpdate() > 0;
      } catch (SQLException ex) {
          System.err.println("Error al insertar departamento: " + ex.getMessage());
          JOptionPane.showMessageDialog(null, "Error al insertar: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
          return false;
      }
    }

    public boolean actualizar(Departamentos departamento) {
      String sql = "{ CALL actualizar_departamentos(?, ?) }";
      try (CallableStatement cstmt = conn.prepareCall(sql)) {
          cstmt.setInt(1, departamento.getId());
          cstmt.setString(2, departamento.getDescripcion());
          return cstmt.executeUpdate() > 0;
      } catch (SQLException ex) {
          System.err.println("Error al actualizar departamento: " + ex.getMessage());
          JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
          return false;
      }
    }

    public boolean eliminar(int idDepartamento) {
        String sql = "{ CALL eliminar_departamentos(?) }";
        
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            
            cstmt.setInt(1, idDepartamento);
            return cstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Error al eliminar departamento: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}