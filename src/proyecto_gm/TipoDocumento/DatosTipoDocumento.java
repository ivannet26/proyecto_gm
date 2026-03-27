package proyecto_gm.TipoDocumento;

import java.awt.Component;
import java.awt.Container;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Modulo.Modulo;
import proyecto_gm.Utilitario;

public class DatosTipoDocumento {

    static Connection conn = ConexionBD.getConnection();

    public static void Limpiar(Container contenedor) {
        Component[] components = contenedor.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
        }
    }
    
    public static void Habilitar(Container contenedor, boolean habilitar) {
    for (Component component : contenedor.getComponents()) {
        if (component instanceof JTextField || component instanceof JComboBox) {
            component.setEnabled(habilitar);
        } else if (component instanceof JButton) {
            String button = ((JButton) component).getName();
            boolean esEditable = "guardar".equals(button) || "deshacer".equals(button);
            component.setEnabled(esEditable == habilitar);
        }} 
}
    public static List<Modulo> obtenerModulos() {
        List<Modulo> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_modulo() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("IdModulo");
                String descripcion = rs.getString("Descripcion");
                lista.add(new Modulo(Id, descripcion));
            }
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
        return lista;
    }

    public static void Mostrar(DefaultTableModel modelo) {
        try ( PreparedStatement pstmt = conn.prepareStatement("CALL listar_tipodocumento()")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("IdTipoDocumento"),
                    rs.getString("Descripcion"),
                    rs.getString("Modulo")});
            }
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }

    public static boolean Insertar(TipoDocumento tip, JTable tabla) {
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL insertar_tipodocumento(?, ?, ?) }")) {
            cstmt.setInt(1, tip.getIdTipoDocumento());
            cstmt.setString(2, tip.getIdModulo());
            cstmt.setString(3, tip.getDescripcion());
            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);

            return true;
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
            return false;
        }
    }

    public static void Editar(Container contenedor, JTable tabla, JTextField[] camposTexto, JComboBox[] combos) {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            Habilitar(contenedor, true);
            camposTexto[0].setEnabled(false);
            camposTexto[1].requestFocus();
            for (int i = 0; i < camposTexto.length; i++) {
                Object valor = tabla.getValueAt(filaSeleccionada, i);
                camposTexto[i].setText(valor != null ? valor.toString() : "");
            }
            Object valorCelda = tabla.getValueAt(filaSeleccionada, 2);
            String moduloDescripcion = valorCelda != null ? valorCelda.toString() : "";

            for (int i = 0; i < combos[0].getItemCount(); i++) {
                Object item = combos[0].getItemAt(i);
                if (item instanceof Modulo) {
                    Modulo mod = (Modulo) item;
                    if (mod.getDescripcion().equals(moduloDescripcion)) {
                        combos[0].setSelectedIndex(i);
                        break;
                    }}}
        } else {Utilitario.MostrarMensaje("Debes seleccionar una fila para editar.", Utilitario.TipoMensaje.alerta);
        }}
    
    public static void Actualizar(TipoDocumento tip, JTable tabla, JComboBox<Modulo> cboModulo) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_tipodocumento(?, ?, ?) }")) {
            String idModulo = tip.getIdModulo();

            cstmt.setInt(1, tip.getIdTipoDocumento());   
            cstmt.setString(2, tip.getDescripcion());   
            cstmt.setString(3, idModulo);                

            cstmt.execute();

            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
            Mostrar(modelo);

            Utilitario.MostrarMensaje("Datos actualizados correctamente.", Utilitario.TipoMensaje.informativo);
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }

    public static void Eliminar(JTable tabla) {
       int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String codigoTipo = tabla.getModel().getValueAt(fila, 0).toString();
            
            Object[] opciones = {"Sí", "No"};
            int confirmar = javax.swing.JOptionPane.showOptionDialog(
                    null, 
                    "¿Eliminar tipo de documento?", 
                    "Confirmación", 
                    javax.swing.JOptionPane.YES_NO_OPTION, 
                    javax.swing.JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
            );

            if (confirmar == 0) {
                try (CallableStatement stmt = conn.prepareCall("{ CALL eliminar_tipodocumento(?) }")) {
                    stmt.setString(1, codigoTipo);
                    stmt.execute();

                    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                    modelo.setRowCount(0); 
                    Mostrar(modelo);       

                    Utilitario.MostrarMensaje("Registro eliminado correctamente.", Utilitario.TipoMensaje.informativo);

                } catch (SQLException ex) {
                    Utilitario.MostrarMensaje(ex.getMessage(), Utilitario.TipoMensaje.error);
                }
            }
        } else {
            Utilitario.MostrarMensaje("Debes seleccionar una fila para eliminar.", Utilitario.TipoMensaje.alerta);
        }
    }
}
