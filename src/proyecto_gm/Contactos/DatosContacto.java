package proyecto_gm.Contactos;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.ConexionBD;
import proyecto_gm.Departamentos.Departamentos;

public class DatosContacto {

    static Connection conn = ConexionBD.getConnection();

    public static List<Departamentos> listaDepartamentos() {
        List<Departamentos> lista = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_departamentos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("IdDepartamento");
                String descripcion = rs.getString("Descripcion");
                lista.add(new Departamentos(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener departamentos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    //metodo para insertar datos (nuevo cambio)
    public static void insertarDatos(Contacto contacto, JTable tabla) {
        try {
            PreparedStatement cstmt = conn.prepareCall("{ CALL insertar_contactos(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, contacto.getNombre());
            cstmt.setString(2, contacto.getFechaNacimiento());
            cstmt.setString(3, contacto.getPersonasRelacionadas());
            cstmt.setString(4, contacto.getEmpresa());
            cstmt.setString(5, contacto.getCuenta());
            cstmt.setString(6, contacto.getClave());
            cstmt.setString(7, contacto.getCargo());
            cstmt.setString(8, contacto.getCorreo());
            cstmt.setString(9, contacto.getTelefono());
            cstmt.setString(10, contacto.getDepartamento());
            cstmt.setString(11, contacto.getDireccion());
            cstmt.setString(12, contacto.getNotas());

            cstmt.execute(); // se inserta los datos a la BD

            // Actualiza el modelo de tabla con los nuevos datos
            if(tabla != null){
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);
                DatosContacto.mostrarDatos(modelo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    // Mostrar datos
    public static void mostrarDatos(DefaultTableModel modelo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("CALL listar_contactos()");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getInt("IdContacto"),
                    rs.getString("Nombre"),
                    rs.getString("FechaNacimiento"),
                    rs.getString("PersonasRelacionadas"),
                    rs.getString("Empresa"),
                    rs.getString("Cargo"),
                    rs.getString("Correo"),
                    rs.getString("Telefono"),
                    rs.getString("Departamento"),
                    rs.getString("Direccion"),
                    rs.getString("Notas")};
                modelo.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en mostrar datos", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Actualizar datos
    public static void actualizarDatos(Contacto contacto, JTable tabla) {
        try {
            PreparedStatement cstmt = conn.prepareCall("{ CALL actualizar_contactos(?, ?, ?,?,?,?,?,?,?,?,?,?,?) }");
            cstmt.setInt(1, contacto.getId());
            cstmt.setString(2, contacto.getNombre());
            cstmt.setString(3, contacto.getFechaNacimiento());
            cstmt.setString(4, contacto.getPersonasRelacionadas());
            cstmt.setString(5, contacto.getEmpresa());
            cstmt.setString(6, contacto.getCuenta());
            cstmt.setString(7, contacto.getClave());
            cstmt.setString(8, contacto.getCargo());
            cstmt.setString(9, contacto.getCorreo());
            cstmt.setString(10, contacto.getTelefono());
            cstmt.setString(11, contacto.getDepartamento());
            cstmt.setString(12, contacto.getDireccion());
            cstmt.setString(13, contacto.getNotas());

            cstmt.execute(); 

            // Solo actualizar la tabla si NO es null
            if(tabla != null){
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.setRowCount(0);
                DatosContacto.mostrarDatos(modelo);
            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void eliminarDatos(JTable tabla) {
       try {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                Object[] opciones = {"Sí", "No"};
                int opcion = JOptionPane.showOptionDialog(
                        null, 
                        "¿Está seguro de que quiere eliminar la fila seleccionada?", 
                        "Confirmación", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        opciones, 
                        opciones[0]
                );
                
                if (opcion == 0) {
                    int id = Integer.parseInt(tabla.getModel().getValueAt(fila, 0).toString());
                    
                    PreparedStatement stmt = conn.prepareCall("{ CALL eliminar_contacto(?) }");
                    stmt.setInt(1, id);
                    stmt.execute();

                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "La fila ha sido eliminada exitosamente");                
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una fila para eliminar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
