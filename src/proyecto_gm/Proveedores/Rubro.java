package proyecto_gm.Proveedores;

public class Rubro {
    private String codigo;
    private String descripcion;

    public Rubro(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // ¡CLAVE! Esto es lo que mostrará el ComboBox en la pantalla de Java
    @Override
    public String toString() {
        return descripcion; 
    }
}