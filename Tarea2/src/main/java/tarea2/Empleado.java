package tarea2;

import java.time.Instant;

public class Empleado {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;
    private Instant horaLlegada = null;
    private String Dep;

    public Empleado(String id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    public String getId() {
        return id;
    }
    public String getApellido() {
        return apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    public void setHoraLlegada() {
        this.horaLlegada = Instant.now();
    }
    public void setDepartamento(String Depa){
        this.Dep = Depa;
    }
    public String getDepartamento(){
        return Dep;
    }
}
