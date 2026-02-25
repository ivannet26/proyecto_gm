package proyecto_gm.Horarios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosHorarios {

    public static List<Horarios> listar() {
        List<Horarios> lista = new ArrayList<>();
        Connection conn = ConexionBD.getConnection();

        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_horario() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Horarios h = new Horarios();
                h.setIdhorario(rs.getInt("idhorario"));
                h.setDni(rs.getString("dni"));
                h.setNombre_apellidos(rs.getString("nombre_completo")); 
                h.setDescripcion(rs.getString("descripcion")); 
                h.setCelular(rs.getString("celular"));
                h.setLunes_he(rs.getString("lunes_he"));
                h.setLunes_hs(rs.getString("lunes_hs"));
                h.setMartes_he(rs.getString("martes_he"));
                h.setMartes_hs(rs.getString("martes_hs"));
                h.setMiercoles_he(rs.getString("miercoles_he"));
                h.setMiercoles_hs(rs.getString("miercoles_hs"));
                h.setJueves_he(rs.getString("jueves_he"));
                h.setJueves_hs(rs.getString("jueves_hs"));
                h.setViernes_he(rs.getString("viernes_he"));
                h.setViernes_hs(rs.getString("viernes_hs"));
                h.setSabado_he(rs.getString("sabado_he"));
                h.setSabado_hs(rs.getString("sabado_hs"));
                h.setDomingo_he(rs.getString("domingo_he"));
                h.setDomingo_hs(rs.getString("domingo_hs"));
                lista.add(h);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar horarios: " + e.getMessage());
        }
        return lista;
    }

    public static void insertar(Horarios h) {
        Connection conn = ConexionBD.getConnection();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_horario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
            cstmt.setString(1, h.getDni());
            cstmt.setString(2, h.getNombre_apellidos()); 
            cstmt.setInt(3, h.getIdcarrera());          
            cstmt.setString(4, h.getCelular());
            cstmt.setString(5, h.getLunes_he());
            cstmt.setString(6, h.getLunes_hs());
            cstmt.setString(7, h.getMartes_he());
            cstmt.setString(8, h.getMartes_hs());
            cstmt.setString(9, h.getMiercoles_he());
            cstmt.setString(10, h.getMiercoles_hs());
            cstmt.setString(11, h.getJueves_he());
            cstmt.setString(12, h.getJueves_hs());
            cstmt.setString(13, h.getViernes_he());
            cstmt.setString(14, h.getViernes_hs());
            cstmt.setString(15, h.getSabado_he());
            cstmt.setString(16, h.getSabado_hs());
            cstmt.setString(17, h.getDomingo_he());
            cstmt.setString(18, h.getDomingo_hs());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Horario registrado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + ex.getMessage());
        }
    }

    public static void actualizar(Horarios h) {
        Connection conn = ConexionBD.getConnection();
 
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_horario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }")) {
            cstmt.setInt(1, h.getIdhorario());
            cstmt.setString(2, h.getDni());
            cstmt.setString(3, h.getNombre_apellidos()); 
            cstmt.setInt(4, h.getIdcarrera());          
            cstmt.setString(5, h.getCelular());
            cstmt.setString(6, h.getLunes_he());
            cstmt.setString(7, h.getLunes_hs());
            cstmt.setString(8, h.getMartes_he());
            cstmt.setString(9, h.getMartes_hs());
            cstmt.setString(10, h.getMiercoles_he());
            cstmt.setString(11, h.getMiercoles_hs());
            cstmt.setString(12, h.getJueves_he());
            cstmt.setString(13, h.getJueves_hs());
            cstmt.setString(14, h.getViernes_he());
            cstmt.setString(15, h.getViernes_hs());
            cstmt.setString(16, h.getSabado_he());
            cstmt.setString(17, h.getSabado_hs());
            cstmt.setString(18, h.getDomingo_he());
            cstmt.setString(19, h.getDomingo_hs());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Horario actualizado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
        }
    }

    public static void eliminar(int id) {
        Connection conn = ConexionBD.getConnection();

        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_horario(?) }")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Horario eliminado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar horario: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // ESTE SÍ VA AQUÍ: Busca si ya existe un horario
    public static Horarios buscarPorDni(String dni) {
        List<Horarios> lista = listar(); 
        for (Horarios h : lista) {
            if (h.getDni() != null && h.getDni().equals(dni)) {
                return h; // Encontrado
            }
        }
        return null; // No existe
    }

}