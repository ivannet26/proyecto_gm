package proyecto_gm.Departamentos;

public class Departamentos {
    
    private int id; 
    private String descripcion;

    public Departamentos(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Departamentos(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Departamentos() {
        
    }

    public Departamentos(String id, String descripcion) {
        this.id = Integer.parseInt(id); 
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}