package proyecto_gm.Tipo;

import java.awt.Component;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;

public class DatosTipo {

    static Connection conn = ConexionBD.getConnection();

    public static void LimpiarTipo(Container contenedor) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
            } else if (componente instanceof Container) {
                LimpiarTipo((Container) componente);
            }
        }
    }

    public static void MostrarTipo(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        try ( PreparedStatement stmt = conn.prepareStatement("CALL listar_tipoempleado()");  ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdTipoEmpleado"),
                    rs.getString("Descripcion")
                };
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean InsertarTipo(Tipo tip, JTable tabla) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL insertar_tipoempleado(?, ?)}")) {
            stmt.setString(1, tip.getDescripcionTipo()); // IN
            stmt.registerOutParameter(2, Types.INTEGER); // OUT

            int filasAfectadas = stmt.executeUpdate();
            int nuevoId = stmt.getInt(2); // Obtener el valor OUT

            tip.setIdTipo(nuevoId);

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(new Object[]{tip.getIdTipo(), tip.getDescripcionTipo()});

            return filasAfectadas > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void ActualizarTipo(Tipo tip, JTable tabla) {
        try ( CallableStatement stmt = conn.prepareCall("{CALL actualizar_tipoempleado (?, ?)}")) {
            stmt.setInt(1, tip.getIdTipo()); // Ahora usamos IdTipoEmpleado
            stmt.setString(2, tip.getDescripcionTipo());
            stmt.executeUpdate();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            DatosTipo.MostrarTipo(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void EliminarTipo(JTable tabla) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int idTipo = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString());
            
          
            Object[] opciones = {"Sí", "No"};
            
            
            int confirm = JOptionPane.showOptionDialog(
                    null, 
                    "¿Eliminar tipo de empleado?", 
                    "Confirmar", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0] 
            );
            
           
            if (confirm == 0) {
                try (CallableStatement stmt = conn.prepareCall("{CALL eliminar_tipoempleado(?)}")) {
                    stmt.setInt(1, idTipo);
                    stmt.execute();
                    ((DefaultTableModel) tabla.getModel()).removeRow(fila);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de empleado para eliminar.");
        }
    }

    public static void HabilitarTipo(Container contenedor, boolean bloquear) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setEnabled(bloquear);
            } else if (componente instanceof JButton) {
                String button = ((JButton) componente).getName();
                boolean activar = button.equals("guardar") || button.equals("deshacer");
                ((JButton) componente).setEnabled(activar == bloquear);
            }
        }
    }

    public static boolean EditarTipo(Container contenedor, JTable tabla, JTextField[] campos) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            HabilitarTipo(contenedor, true);
            for (int i = 0; i < campos.length; i++) {
                campos[i].setText(tabla.getModel().getValueAt(fila, i).toString());
            }
            campos[0].setEnabled(false);
            campos[1].requestFocus();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
            return false;
        }
    }
}
