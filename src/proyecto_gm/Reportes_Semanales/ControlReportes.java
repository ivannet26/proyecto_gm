
package proyecto_gm.Reportes_Semanales;
public class ControlReportes {
    private int id;
    private String fecha;
    private String apellidosNombres;
    private String celular;
    private String cargo;
    private String area;
    private String horaEntrada1;
    private String horaSalida1;
    private String breakTiempo;
    private String horaEntrada2;
    private String horaSalida2;
    private String totalHorasLaboradas;
    private String totalHorasConBreak;
    private String actividad;
    private String coordinador;

    public ControlReportes() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    
    public String getApellidosNombres() { return apellidosNombres; }
    public void setApellidosNombres(String apellidosNombres) { this.apellidosNombres = apellidosNombres; }
    
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
    
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
    
    public String getHoraEntrada1() { return horaEntrada1; }
    public void setHoraEntrada1(String horaEntrada1) { this.horaEntrada1 = horaEntrada1; }
    
    public String getHoraSalida1() { return horaSalida1; }
    public void setHoraSalida1(String horaSalida1) { this.horaSalida1 = horaSalida1; }
    
    public String getBreakTiempo() { return breakTiempo; }
    public void setBreakTiempo(String breakTiempo) { this.breakTiempo = breakTiempo; }
    
    public String getHoraEntrada2() { return horaEntrada2; }
    public void setHoraEntrada2(String horaEntrada2) { this.horaEntrada2 = horaEntrada2; }
    
    public String getHoraSalida2() { return horaSalida2; }
    public void setHoraSalida2(String horaSalida2) { this.horaSalida2 = horaSalida2; }
    
    public String getTotalHorasLaboradas() { return totalHorasLaboradas; }
    public void setTotalHorasLaboradas(String totalHorasLaboradas) { this.totalHorasLaboradas = totalHorasLaboradas; }
    
    public String getTotalHorasConBreak() { return totalHorasConBreak; }
    public void setTotalHorasConBreak(String totalHorasConBreak) { this.totalHorasConBreak = totalHorasConBreak; }
    
    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }
    
    public String getCoordinador() { return coordinador; }
    public void setCoordinador(String coordinador) { this.coordinador = coordinador; }
}
