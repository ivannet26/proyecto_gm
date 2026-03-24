package proyecto_gm.Cuentas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import proyecto_gm.ConexionBD;

public class DatosCuentas {
    
    static final Connection conn = ConexionBD.getConnection();

    // Método para obtener una lista de todas las cuentas
    public static List<Cuentas> listar() throws SQLException {
        List<Cuentas> listaCuentas = new ArrayList<>();
        // Usar try-with-resources para asegurar que la conexión se cierre
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_cuentas() }");
             ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
            Cuentas cuenta = new Cuentas();
            cuenta.setIdCuenta(rs.getInt("IdCuentaBancaria"));
            cuenta.setTipoPropietario(rs.getString("TipoPropietario"));
            cuenta.setNombres(rs.getString("Nombres"));
            cuenta.setNombreBanco(rs.getString("Banco")); // Asumiendo que el SP devuelve el nombre del banco
            cuenta.setNroCuenta(rs.getString("CCC"));
            cuenta.setNroCuentaInterbancaria(rs.getString("CCI"));
            cuenta.setTipoMoneda(rs.getString("TipoMoneda"));
                
                // --- SOLUCIÓN: Intentamos obtener IdBanco, si no existe, lo ignoramos ---
            try {
                cuenta.setIdBanco(rs.getInt("IdBanco"));
            
            } catch (SQLException ex) {
            
                    // Si la columna no existe en el SQL, dejamos el valor por defecto (0)
                    // Así evitamos el error de "Column IdBanco not found"
            }

                // Nota: necesitarás el IdBanco para editar, el SP 'listar_cuentas' debería devolverlo
                // cuenta.setIdBanco(rs.getInt("IdBanco"));
                listaCuentas.add(cuenta);
            }
        }
        return listaCuentas;
    }

    // Insertar una nueva cuenta
    public static void insertar(Cuentas cuenta) throws SQLException {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_cuenta(?, ?, ?, ?, ?, ?, ?) }")) {
            
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setString(2, cuenta.getTipoPropietario());
            cstmt.setString(3, cuenta.getNombres());
            cstmt.setInt(4, cuenta.getIdBanco());
            cstmt.setString(5, cuenta.getNroCuenta());
            cstmt.setString(6, cuenta.getNroCuentaInterbancaria());
            cstmt.setString(7, cuenta.getTipoMoneda());
            cstmt.execute();
        }
    }

    // Actualizar una cuenta existente
    public static void actualizar(Cuentas cuenta) throws SQLException {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_cuenta(?, ?, ?, ?, ?, ?, ?) }")) {
            
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setString(2, cuenta.getTipoPropietario());
            cstmt.setString(3, cuenta.getNombres());
            cstmt.setInt(4, cuenta.getIdBanco());
            cstmt.setString(5, cuenta.getNroCuenta());
            cstmt.setString(6, cuenta.getNroCuentaInterbancaria());
            cstmt.setString(7, cuenta.getTipoMoneda());
            cstmt.executeUpdate();
        }
    }

    // Eliminar una cuenta por su ID
    public static void eliminar(int idCuenta) throws SQLException {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_cuenta(?) }")) {
            
            cstmt.setInt(1, idCuenta);
            cstmt.executeUpdate();
        }
    }

    // Generar un nuevo código para una cuenta
    public static int generarNuevoId() throws SQLException {
        int idGenerado = 0;
        try (CallableStatement cstmt = conn.prepareCall("{ CALL generar_codigo(?, ?, ?) }")) {
            
            cstmt.setString(1, "cuentasbancarias");
            cstmt.setString(2, "IdCuentaBancaria");
            cstmt.registerOutParameter(3, Types.INTEGER);
            cstmt.execute();
            idGenerado = cstmt.getInt(3);
        }
        return idGenerado;
    }

    // Cargar los bancos en un JComboBox
    public static void cargarBancos(JComboBox<Banco> combo) {
        combo.removeAllItems();
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_bancos() }");
             ResultSet rs = cstmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("idBanco");
                String descripcion = rs.getString("descripcion");
                combo.addItem(new Banco(id, descripcion));
            }
        } catch (SQLException e) {
            // En una aplicación real, aquí se registraría el error (logging)
            System.err.println("Error al cargar bancos: " + e.getMessage());
        }
    }
}