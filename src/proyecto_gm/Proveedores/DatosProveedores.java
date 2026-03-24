package proyecto_gm.Proveedores;

import proyecto_gm.Departamentos.Ubigeo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import proyecto_gm.ConexionBD;
public class DatosProveedores {

    static final Connection conn = ConexionBD.getConnection();
    
public List<Proveedores> listar() {
    
    List<Proveedores> lista = new ArrayList<>();
    String sql = "{ CALL listar_proveedores() }";

    try (CallableStatement cstmt = conn.prepareCall(sql);
         ResultSet rs = cstmt.executeQuery()) {

        while (rs.next()) {
            Proveedores prov = new Proveedores();
            prov.setIdProveedor(rs.getInt("IdProveedor"));
            
            
            prov.setIdUbigeo(rs.getString("idUbigeo"));

            prov.setDepartamento(rs.getString("Departamento"));
            prov.setProvincia(rs.getString("Provincia"));
            prov.setDistrito(rs.getString("Distrito"));
            prov.setNombres(rs.getString("Nombres"));
            prov.setDireccion(rs.getString("Direccion"));
            prov.setCorreo(rs.getString("Correo"));
            prov.setTelefono(rs.getString("Telefono"));
            prov.setCelular(rs.getString("Celular"));
            prov.setRuc(rs.getString("Ruc"));
            prov.setRubro(rs.getString("Rubro"));
            prov.setEstado(rs.getString("Estado"));

            lista.add(prov);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar proveedores: " + ex.getMessage());
    }

    return lista;
}
    public static void ajustarColumnasProveedores(JTable tabla) {
        TableColumnModel col = tabla.getColumnModel();

        col.getColumn(0).setPreferredWidth(40);   // ID
        col.getColumn(1).setPreferredWidth(100);  // RUC
        col.getColumn(2).setPreferredWidth(180);  // Nombres
        col.getColumn(3).setPreferredWidth(200);  // Dirección
        col.getColumn(4).setPreferredWidth(120);  // Rubro
        col.getColumn(5).setPreferredWidth(150);  // Correo
        col.getColumn(6).setPreferredWidth(80);   // Teléfono
        col.getColumn(7).setPreferredWidth(80);   // Celular
        col.getColumn(8).setPreferredWidth(120);  // Departamento
        col.getColumn(9).setPreferredWidth(120);  // Provincia
        col.getColumn(10).setPreferredWidth(120); // Distrito
        col.getColumn(11).setPreferredWidth(80);  // Estado
    }

    public boolean insertar(Proveedores proveedor) {
        String sql = "{ CALL insertar_proveedores(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, proveedor.getIdUbigeo());
            cstmt.setString(2, proveedor.getNombres());
            cstmt.setString(3, proveedor.getDireccion());
            cstmt.setString(4, proveedor.getCorreo());
            cstmt.setString(5, proveedor.getTelefono());
            cstmt.setString(6, proveedor.getCelular());
            cstmt.setString(7, proveedor.getRuc());
            cstmt.setString(8, proveedor.getRubro());
            cstmt.setString(9, proveedor.getEstado());

            return cstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Error al insertar proveedor: " + ex.getMessage());
            return false;
        }
    }
    public boolean actualizar(Proveedores proveedor) {
        String sql = "{ CALL actualizar_proveedores(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, proveedor.getIdProveedor());
            cstmt.setString(2, proveedor.getIdUbigeo());
            cstmt.setString(3, proveedor.getNombres());
            cstmt.setString(4, proveedor.getDireccion());
            cstmt.setString(5, proveedor.getCorreo());
            cstmt.setString(6, proveedor.getTelefono());
            cstmt.setString(7, proveedor.getCelular());
            cstmt.setString(8, proveedor.getRuc());
            cstmt.setString(9, proveedor.getRubro());
            cstmt.setString(10, proveedor.getEstado());

            return cstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Error al actualizar proveedor: " + ex.getMessage());
            return false;
        }
    }
 public boolean eliminar(int idProveedor) {
        String sql = "{ CALL eliminar_proveedores(?) }";

        try (CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setInt(1, idProveedor);
            return cstmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Error al eliminar proveedor: " + ex.getMessage());
            return false;
        }
    }
  public List<Ubigeo> listarDepartamentosUbigeo() {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaDepartamentosUbigeo()}";
        try (CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                lista.add(new Ubigeo(
                        rs.getString("idDepartamento"),
                        rs.getString("nomdep")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<Ubigeo> listarProvinciasUbigeo(String idDepartamento) {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaProvinciaUbigeo(?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, idDepartamento);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ubigeo(
                            rs.getString("idprovincia"),
                            rs.getString("nomprov")
                    ));}}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<Ubigeo> listarDistritosUbigeo(String idDepartamento, String idProvincia) {
        List<Ubigeo> lista = new ArrayList<>();
        String sql = "{CALL ListaDistritoUbigeo(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, idDepartamento);
            cs.setString(2, idProvincia);

            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ubigeo(
                            rs.getString("iddistrito"),
                            rs.getString("nomdist")
                    ));}}
                
        } catch (SQLException e) {
            e.printStackTrace();}
        return lista;}
    
public List<EstadoProveedor> listarEstadosProveedor() {
    List<EstadoProveedor> lista = new ArrayList<>();
    String sql = "{ CALL listar_estadospv() }";

    try (CallableStatement cstmt = conn.prepareCall(sql);
         ResultSet rs = cstmt.executeQuery()) {

        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String descripcion = rs.getString("descripcion");
            String tipo = rs.getString("tipo");

            EstadoProveedor ep = new EstadoProveedor(codigo, descripcion, tipo);
            lista.add(ep);
        }

    } catch (SQLException ex) {
        System.err.println("Error al listar estados proveedor: " + ex.getMessage());
    }

    return lista;
}

    
    public Proveedores obtenerPorId(int idProveedor) {
    Proveedores prov = null;

    try (CallableStatement cs = conn.prepareCall("{ CALL obtener_proveedor(?) }")) {

        cs.setInt(1, idProveedor);

        ResultSet rs = cs.executeQuery();

        if (rs.next()) {
            prov = new Proveedores();
            prov.setIdProveedor(rs.getInt("IdProveedor"));
            prov.setIdUbigeo(rs.getString("idUbigeo"));
            prov.setNombres(rs.getString("Nombres"));
            prov.setDireccion(rs.getString("Direccion"));
            prov.setCorreo(rs.getString("Correo"));
            prov.setTelefono(rs.getString("Telefono"));
            prov.setCelular(rs.getString("Celular"));
            prov.setRuc(rs.getString("Ruc"));
            prov.setRubro(rs.getString("Rubro"));
            prov.setEstado(rs.getString("Estado"));
        }
        rs.close();

    } catch (Exception e) {
        System.out.println("Error al obtener proveedor por ID: " + e.getMessage()); }
    return prov;}
    
    public boolean insertarDesdeExcel(String idUbigeo, String nombres, String direccion, String correo, String telefono, String celular, String ruc, String rubro, String estado) {
        String sql = "{ CALL insertar_proveedores(?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, idUbigeo);
            cstmt.setString(2, nombres);
            cstmt.setString(3, direccion);
            cstmt.setString(4, correo);
            cstmt.setString(5, telefono);
            cstmt.setString(6, celular);
            cstmt.setString(7, ruc);
            cstmt.setString(8, rubro);
            cstmt.setString(9, estado);
            return cstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Error en inserción Excel: " + ex.getMessage());
            return false;
        }
    }



}


