package proyecto_gm.Carreras;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import proyecto_gm.Utilitario;
import proyecto_gm.ConexionBD;

public class DatosCarrera {

    static Connection conn = ConexionBD.getConnection();

    public static List<Carreras> listar() {
        List<Carreras> lista = new ArrayList<>();

        try (CallableStatement cstmt = conn.prepareCall("{ CALL listar_carreras() }")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Carreras carrera = new Carreras();
                carrera.setId(rs.getInt("IdCarrera"));
                carrera.setDescripcion(rs.getString("descripcion"));
                lista.add(carrera);
            }
        } catch (SQLException e) {
            Utilitario.MostrarMensaje("Error al cargar datos: " + e.getMessage(), Utilitario.TipoMensaje.error);
        }
        return lista;
    }

    public static void insertar(Carreras carrera) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL insertar_carreras(?) }")) { 
            cstmt.setString(1, carrera.getDescripcion());
            cstmt.execute();
            Utilitario.MostrarMensaje("Carrera registrada exitosamente.", Utilitario.TipoMensaje.informativo);
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje("Error al insertar carrera: " + ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }

    public static void actualizar(Carreras carrera) {
        try (CallableStatement cstmt = conn.prepareCall("{ CALL actualizar_carreras(?, ?) }")) {
            cstmt.setInt(1, carrera.getId());
            cstmt.setString(2, carrera.getDescripcion());
            cstmt.execute();
            Utilitario.MostrarMensaje("Carrera actualizada exitosamente.", Utilitario.TipoMensaje.informativo);
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje("Error al actualizar carrera: " + ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }

    public static void eliminar(int id) {

        try (CallableStatement cstmt = conn.prepareCall("{ CALL eliminar_carreras(?) }")) {
            cstmt.setInt(1, id);
            cstmt.execute();
            Utilitario.MostrarMensaje("Carrera eliminada exitosamente.", Utilitario.TipoMensaje.informativo);
        } catch (SQLException ex) {
            Utilitario.MostrarMensaje("Error al eliminar carrera: " + ex.getMessage(), Utilitario.TipoMensaje.error);
        }
    }
}
