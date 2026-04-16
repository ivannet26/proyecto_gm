
package proyecto_gm.Reportes_Semanales;

import proyecto_gm.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatosReporte {
    
  
    static final Connection con = ConexionBD.getConnection();

   
    public ResultSet listarTodosLosReportes() {
        String sql = "SELECT * FROM reporte_semanal ORDER BY id DESC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al listar reportes: " + e.getMessage());
            return null;
        }
    }

 
 
    public boolean existeRegistro(String fecha, String apellidosNombres) {
        String sql = "SELECT id FROM reporte_semanal WHERE fecha = ? AND apellidos_nombres = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, apellidosNombres);
            ResultSet rs = ps.executeQuery();
            return rs.next(); 
        } catch (Exception e) {
            System.out.println("Error al verificar registro: " + e.getMessage());
            return false;
        }
    }

   
    public boolean insertarReporte(String fecha, String apellidosNombres, String celular, String cargo, String area,
                                   String horaEntrada1, String horaSalida1, String breakTiempo, 
                                   String horaEntrada2, String horaSalida2, String actividad, String coordinador) {
        
        String sql = "INSERT INTO reporte_semanal (fecha, apellidos_nombres, celular, cargo, area, "
                   + "hora_entrada_1, hora_salida_1, break_tiempo, hora_entrada_2, hora_salida_2, actividad, coordinador) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, apellidosNombres);
            ps.setString(3, celular);
            ps.setString(4, cargo);
            ps.setString(5, area);
            ps.setString(6, horaEntrada1);
            ps.setString(7, horaSalida1);
            ps.setString(8, breakTiempo);
            ps.setString(9, horaEntrada2);
            ps.setString(10, horaSalida2);
            ps.setString(11, actividad);
            ps.setString(12, coordinador);
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar reporte desde Java: " + e.getMessage());
            return false;
        }
    }


    public boolean actualizarReporte(int id, String horaEntrada1, String horaSalida1, String breakTiempo, 
                                     String horaEntrada2, String horaSalida2, String totalHorasLaboradas, 
                                     String totalHorasConBreak, String actividad, String coordinador) {
        
        String sql = "UPDATE reporte_semanal SET hora_entrada_1=?, hora_salida_1=?, break_tiempo=?, "
                   + "hora_entrada_2=?, hora_salida_2=?, total_horas_laboradas=?, total_horas_con_break=?, "
                   + "actividad=?, coordinador=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, horaEntrada1);
            ps.setString(2, horaSalida1);
            ps.setString(3, breakTiempo);
            ps.setString(4, horaEntrada2);
            ps.setString(5, horaSalida2);
            ps.setString(6, totalHorasLaboradas);
            ps.setString(7, totalHorasConBreak);
            ps.setString(8, actividad);
            ps.setString(9, coordinador);
            ps.setInt(10, id);
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar reporte desde Java: " + e.getMessage());
            return false;
        }
    }
    

    public boolean eliminarReporte(int id) {
        String sql = "DELETE FROM reporte_semanal WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar reporte: " + e.getMessage());
            return false;
        }
    }
    
    public ResultSet listarReportesPorFechas(java.util.Date fechaInicio, java.util.Date fechaFin) {
        String sql = "SELECT * FROM reporte_semanal "
                   + "WHERE STR_TO_DATE(fecha, '%d/%m/%Y') BETWEEN ? AND ? "
                   + "ORDER BY STR_TO_DATE(fecha, '%d/%m/%Y') ASC";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            ps.setDate(2, new java.sql.Date(fechaFin.getTime()));
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println("Error al filtrar fechas: " + e.getMessage());
            return null;
        }
    }
}