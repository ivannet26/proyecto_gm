package proyecto_gm.Periodos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosPeriodo {
    
    static final Connection conn = ConexionBD.getConnection();

    public static void listar(DefaultTableModel modelo) {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar
        String sql = "{CALL listar_periodos()}";

        try (CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            
            // Definir las columnas
            String[] cabeceras = {"ID", "Descripción"};
            modelo.setColumnIdentifiers(cabeceras);

            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("IdPeriodo"),
                    rs.getString("Descripcion")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar periodos: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

   public static boolean insertar(Periodos periodo) {
        
        String sql = "{CALL insertar_periodos(?, ?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, 0); 
            int mesActual = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1;
            cstmt.setInt(2, mesActual);
            cstmt.setString(3, periodo.getDescripcion());
            cstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar periodo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean actualizar(Periodos periodo) {
        String sql = "{CALL actualizar_periodos(?, ?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            
            
            // El ID se convierte a entero para enviarlo a la BD
            cstmt.setInt(1, Integer.parseInt(periodo.getId()));
            cstmt.setString(2, periodo.getDescripcion());
            cstmt.executeUpdate();
            return true;

        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar periodo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean eliminar(int id) {
        String sql = "{CALL eliminar_periodos(?)}";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, id);
            cstmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar periodo: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static List<Periodos> obtenerLista() {
        List<Periodos> listaPeriodos = new ArrayList<>();
        String sql = "{CALL listar_periodos()}";
        
        try (CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            
            while(rs.next()) {
                Periodos p = new Periodos();
                // Aunque el ID es int en la BD, la clase Periodos lo usa como String.
                p.setId(String.valueOf(rs.getInt("IdPeriodo")));
                p.setDescripcion(rs.getString("Descripcion"));
                listaPeriodos.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de periodos: " + ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPeriodos;
    }
}