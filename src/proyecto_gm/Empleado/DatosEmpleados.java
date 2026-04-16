package proyecto_gm.Empleado;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto_gm.Area.Area;
import proyecto_gm.Cargo.Cargo;
import proyecto_gm.ConexionBD;
import proyecto_gm.Utilitario;
import java.sql.PreparedStatement;

/**
 *
 * @author jeanv
 */
public class DatosEmpleados {

    static Connection conn = ConexionBD.getConnection();

    // Limpiar campos
   


    // Cargar opciones para los combo boxes
    public static List<Area> listaAreas() {
        List<Area> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_areas() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdArea");
                String descripcion = rs.getString("descripcion");
                lista.add(new Area(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Áreas", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }


    public static List<Cargo> listaCargo() {
        List<Cargo> lista = new ArrayList<>();
        try ( CallableStatement cstmt = conn.prepareCall("{ CALL listar_cargos }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idCargo");
                String descripcion = rs.getString("descripcion");
                lista.add(new Cargo(id, descripcion));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al cargar Cargos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }


    
    // Listar datos
    public static void Listar(DefaultTableModel modelo, String estado) {
        modelo.setRowCount(0);
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = conn.prepareCall("{ CALL listar_emple(?)}");
            
            cstmt.setString(1, estado);
            
            // 
            rs = cstmt.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Id"), // 0
                    rs.getString("Apellidos"), // 1
                    rs.getString("Nombres"), // 2
                    rs.getString("FechaNacimiento"), //3
                    rs.getString("Correo"), //4
                    rs.getString("Dni"), // 5
                    rs.getString("Celular"), // 6
                    rs.getString("Distrito"), // 7
                    rs.getString("Direccion"), // 8
                    rs.getString("IdArea"), // 9
                    rs.getString("Area"), // 10
                    rs.getString("IdCargo"), //11
                    rs.getString("Cargo"), // 12 
                    rs.getString("TipoEmpleado"),
                    rs.getString("IdTipoEmpleado")// 13
                };
                modelo.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                /* manejar error */ }
            if (cstmt != null) try {
                cstmt.close();
            } catch (SQLException e) {
                /* manejar error */ }
        }
    }
    
    public static void Listar(DefaultTableModel modelo){
        
            Listar(modelo, "T");
    }
    // Método para capturar el ID del tipo de empleado desde los RadioButtons
    public static String CapturarTipoEmpleado(ButtonGroup opciones) {
        String idTipoEmpleado = "";
        ButtonModel selectedRadioButton = opciones.getSelection();
        if (selectedRadioButton != null) {
            String tipoEmpleado = selectedRadioButton.getActionCommand();

            // Aquí defines el mapping de tipo a ID según tu lógica
            switch (tipoEmpleado) {
                case "Practicante":
                    idTipoEmpleado = "1";
                    break;
                case "completo":
                    idTipoEmpleado = "2";
                    break;
                case "Partime":
                    idTipoEmpleado = "3";
                    break;
                default:
                    // o puedes lanzar un error
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de empleado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return idTipoEmpleado;
    }
    //insertar 13/07/2025
    public static void Insertar(Empleados empleado){
        
        CallableStatement cstmt = null;
        try{
            // Preparar la llamada al procedimiento almacenado
            cstmt = conn.prepareCall("{ CALL insertar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");

            // Extraer los datos del objeto empleado
            String codigoEmpleado = empleado.getId();
            int idEmpleado = Integer.parseInt(codigoEmpleado.replace("E", ""));
            // Setear los parámetros para el procedimiento
            cstmt.setInt(1, idEmpleado);
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDistrito());
            cstmt.setString(9, empleado.getDireccion());
            //cstmt.setInt(10, empleado.getIdArea());  // Usar el ID de Área
            cstmt.setInt(10, empleado.getArea().getIdArea()); 
            //cstmt.setInt(11, empleado.getIdCargo()); // Usar el ID de Cargo
            cstmt.setInt(11, empleado.getCargo().getIdCargo()); 
            cstmt.setInt(12, empleado.getIdTipo() ); // id tipo empleado
            
            // Ejecutar la inserción
            cstmt.execute();
             Utilitario.MostrarMensaje("Insercion exitosa", Utilitario.TipoMensaje.informativo);
         } catch (SQLException e) {
             Utilitario.MostrarMensaje("Error "+e.getMessage(), Utilitario.TipoMensaje.error);
            
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    Utilitario.MostrarMensaje("Error " + e.getMessage(), Utilitario.TipoMensaje.error);
                }
            }
        }
    }
    public static void Eliminar(String idEmpleado ){
        CallableStatement cstmt = null;
        try{
         cstmt = conn.prepareCall("{ CALL eliminar_empleados(?) }");
                    cstmt.setString(1, idEmpleado);
                    cstmt.execute();
        }catch(SQLException ex){
            Utilitario.MostrarMensaje("Error al eliminar "+ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }
    public static void Actualizar(Empleados empleado){
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{ CALL actualizar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
            cstmt.setString(1, empleado.getId());
            cstmt.setString(2, empleado.getApellidos());
            cstmt.setString(3, empleado.getNombres());
            cstmt.setString(4, empleado.getfNacimiento());
            cstmt.setString(5, empleado.getCorreo());
            cstmt.setString(6, empleado.getDni());
            cstmt.setString(7, empleado.getCelular());
            cstmt.setString(8, empleado.getDistrito());
            cstmt.setString(9, empleado.getDireccion());
            cstmt.setInt(10, empleado.getArea().getIdArea());
            cstmt.setInt(11, empleado.getCargo().getIdCargo());
            //cstmt.setInt(10, empleado.getIdArea());
            //cstmt.setInt(11, empleado.getIdCargo());
            cstmt.setInt(12, empleado.getIdTipo());

            cstmt.execute(); // se actualiza los datos en la BD

            
            Utilitario.MostrarMensaje("Actualizacion exitos", Utilitario.TipoMensaje.informativo);

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Utilitario.MostrarMensaje("Error:"+e.getMessage(), Utilitario.TipoMensaje.informativo);
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                   
                    Utilitario.MostrarMensaje("Error:"+e.getMessage(), Utilitario.TipoMensaje.informativo);
                }
            }
        }
    }
 
    //<editor-fold defaultstate="collapsed" desc="TablaDatos"> 
    public static void cargarTabla(JTable tabla, String estado){
        DefaultTableModel  modelo = (DefaultTableModel) tabla.getModel();
        //limpiar
        modelo.setRowCount(0);
        //refresca el modelo con datos actualizado
        DatosEmpleados.Listar(modelo, estado);
    }

    // Eliminar datos
    public static boolean Eliminar(int idEmpleado ) {
        CallableStatement cstmt = null;
        boolean estadoProceso = false;
        try {
            // Obtener el indice de la fila seleccionada
                                                    
                String[] options = {"Sí", "No", "Cancelar"};
                boolean respuesta = Utilitario.MostrarMensajePregunta("¿Está seguro de que quiere eliminar la fila seleccionada?", 
                        Utilitario.TipoMensaje.pregunta);
                if(respuesta){
                      // Ejecutar el procedimiento almacenado
                    cstmt = conn.prepareCall("{ CALL eliminar_empleados(?) }");                    
                    cstmt.setInt(1, idEmpleado);
                    cstmt.execute();
                    Utilitario.MostrarMensaje("Eliminacion exitosa", Utilitario.TipoMensaje.informativo);
                    estadoProceso = true;
                }
              
           

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return estadoProceso;
    }

    // Obtener datos académicos del empleado
    public static String[] DatAcadEmpleado(String dni) {
        String[] datos = new String[5];
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = conn.prepareCall("{ CALL obtener_datos_academicos(?) }");
            cstmt.setString(1, dni);
            rs = cstmt.executeQuery();
            if (rs.next()) {
                datos[0] = rs.getString("Institucion");
                datos[1] = rs.getString("Facultad");
                datos[2] = rs.getString("Carrera");
                datos[3] = rs.getString("Ciclo");
                datos[4] = rs.getString("Codigo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al cargar datos", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return datos;
    }

    public static String GenerarCodigo(String tabla, String campoId, String prefijo, int longitud) {
        CallableStatement cstmt = null;
        String codigo_generado = "";
        try {
            cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }");
            cstmt.setString(1, tabla);
            cstmt.setString(2, campoId);
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.execute();

            codigo_generado = cstmt.getString(3);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {

            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return codigo_generado;
    }
    
    public static List<Empleados> listar() {
        List<Empleados> lista = new ArrayList<>();    
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_emple('T') }");
             ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                Empleados emp = new Empleados();
                emp.setId(rs.getString("Id"));
                emp.setNombres(rs.getString("Nombres"));
                emp.setApellidos(rs.getString("Apellidos"));
                emp.setDni(rs.getString("Dni")); 
                emp.setCelular(rs.getString("Celular")); 
                lista.add(emp);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al listar empleados", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public static Empleados buscarPorDni(String dni) {
        Empleados emp = null;

        try (CallableStatement cstmt = conn.prepareCall("{ CALL buscar_empleado_por_dni(?) }")) {
            cstmt.setString(1, dni);
            ResultSet rs = cstmt.executeQuery();

            if (rs.next()) {
                emp = new Empleados();
                emp.setId(rs.getString("Id"));
                emp.setDni(rs.getString("Dni"));
                emp.setNombres(rs.getString("Nombres"));
                emp.setApellidos(rs.getString("Apellidos"));
                emp.setCelular(rs.getString("Celular"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al buscar empleado por DNI: " + e.getMessage(), 
                "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return emp;
    }
    
    public static Empleados buscarEmpleadoLocal(String dni) {
        // Usamos el método listar() que YA EXISTE en esta clase DatosEmpleados
        java.util.List<Empleados> lista = listar(); 

        for (Empleados e : lista) {
            if (e.getDni() != null && e.getDni().equals(dni)) {
                return e; // ¡Encontrado!
            }
        }
        return null; 
    }
    
    public static boolean insertarDesdeExcel(int id, String ape, String nom, String fec, String mail, String dni, String cel, String dist, String dir, int area, int cargo, int tipo) {
        String sql = "{ CALL insertar_datos_empleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.setString(2, ape);
            cstmt.setString(3, nom);
            cstmt.setString(4, fec);
            cstmt.setString(5, mail);
            cstmt.setString(6, dni);
            cstmt.setString(7, cel);
            cstmt.setString(8, dist);
            cstmt.setString(9, dir);
            cstmt.setInt(10, area);
            cstmt.setInt(11, cargo);
            cstmt.setInt(12, tipo);
            cstmt.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error Excel: " + e.getMessage());
            return false;
        }
    }
    
    
    public static boolean existeEmpleado(String dni) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM empleados WHERE Dni = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                existe = rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return existe;
    }
}
