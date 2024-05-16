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

}
