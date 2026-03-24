package proyecto_gm.Transferencias;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;
import proyecto_gm.Cuentas.Cuentas;
import proyecto_gm.Periodos.Periodos;

public class DatosTransferencias {
    
    static final Connection conn = ConexionBD.getConnection();

    // Obtener todos los periodos
    public static List<Periodos> getPeriodos() {
        List<Periodos> lista = new ArrayList<>();
        
        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_periodos() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Periodos p = new Periodos();
                p.setId(rs.getString("Mes"));
                p.setDescripcion(rs.getString("Descripcion"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    // Obtener todas las cuentas bancarias para transferencias
    public static List<Cuentas> getCuentas() {
        List<Cuentas> cuentas = new ArrayList<>();
        try (CallableStatement cstmt = conn.prepareCall("CALL listar_ctransferencias()")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Cuentas cuenta = new Cuentas();
                cuenta.setIdCuenta(rs.getInt("IdCuentaBancaria"));
                cuenta.setNombres(rs.getString("Nombres"));
                cuentas.add(cuenta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return cuentas;
    }

    // Obtener todas las transferencias
    public static List<Transferencia> listar() {
        List<Transferencia> lista = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement("CALL listar_transferencias");
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Transferencia t = new Transferencia();
                t.setId(rs.getInt("IdTransferenciaBancaria"));
                t.setPeriodo(rs.getString("IdPeriodo"));
                t.setNroOperacion(rs.getString("NroOperacion"));
                t.setCuentaOrigen(rs.getString("cuentaOrigen"));
                t.setCuentaDestino(rs.getString("cuentaDestino"));
                t.setFecha(rs.getString("Fecha"));
                lista.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    // Insertar una nueva transferencia
    public static void insertar(Transferencia transferencia) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_transferencia(?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, Integer.parseInt(transferencia.getPeriodo()));
            cstmt.setString(2, transferencia.getNroOperacion());
            cstmt.setString(3, transferencia.getCuentaOrigen());
            cstmt.setString(4, transferencia.getCuentaDestino());
            cstmt.setString(5, transferencia.getFecha());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Transferencia registrada.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Actualizar una transferencia existente
    public static void actualizar(Transferencia transferencia) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_transferencia(?, ?, ?, ?, ?, ?) }")) {
            cstmt.setInt(1, transferencia.getId());
            cstmt.setString(2, transferencia.getPeriodo());
            cstmt.setString(3, transferencia.getNroOperacion());
            cstmt.setString(4, transferencia.getCuentaOrigen());
            cstmt.setString(5, transferencia.getCuentaDestino());
            cstmt.setString(6, transferencia.getFecha());
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Transferencia actualizada.", "Actualización Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Eliminar una transferencia por su ID
    public static void eliminar(int id) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_transferencia(?) }")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            JOptionPane.showMessageDialog(null, "Transferencia eliminada.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
}