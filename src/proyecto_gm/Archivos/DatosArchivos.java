package proyecto_gm.Archivos;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto_gm.ConexionBD;

public class DatosArchivos {

    public boolean guardarPDF(File archivo) {
        String sql = "INSERT INTO documentos_pdf (nombre_archivo, extension, contenido_bytes, fecha_guardado) VALUES (?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            byte[] pdfBytes = Files.readAllBytes(archivo.toPath());
            String nombre = archivo.getName();
            String extension = nombre.substring(nombre.lastIndexOf(".") + 1);
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());

            ps.setString(1, nombre);
            ps.setString(2, extension);
            ps.setBytes(3, pdfBytes);
            ps.setTimestamp(4, fechaActual);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public List<Object[]> listarArchivos() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT nombre_archivo, extension, fecha_guardado FROM documentos_pdf";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getString("nombre_archivo"), 
                    rs.getString("extension"),
                    rs.getTimestamp("fecha_guardado")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public byte[] obtenerBytes(String nombre) {
        String sql = "SELECT contenido_bytes FROM documentos_pdf WHERE nombre_archivo = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBytes("contenido_bytes");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al recuperar bytes: " + e.getMessage());
        }
        return null;
    }
}