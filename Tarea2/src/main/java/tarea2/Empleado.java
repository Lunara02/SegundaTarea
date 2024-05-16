package tarea2;

import java.time.Instant;
/**
 * La clase Empleado representa a un empleado.
 * Contiene información como el ID, nombre, apellido, correo electrónico y la hora de llegada.
 *
 * @author Cristobal Gonzalez
 */
public class Empleado {
    private String id;
    private String apellido;
    private String nombre;
    private String correo;
    private Instant horaLlegada = null;
    private String Dep;
    /**
     * Constructor de la clase Empleado.
     *
     * @param id identificador del empleado.
     * @param nombre nombre del empleado.
     * @param apellido apellido del empleado.
     * @param correo correo electrónico del empleado.
     */
    public Empleado(String id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
    /**
     * Obtiene el identificador del empleado.
     *
     * @return identificador del empleado.
     */
    public String getId() {
        return id;
    }
    /**
     * Obtiene el apellido del empleado.
     *
     * @return apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Obtiene el nombre del empleado.
     *
     * @return nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Obtiene el instante de llegada del empleado.
     *
     * @return instante de llegada del empleado.
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    /**
     * Establece el instante de llegada del empleado al momento actual.
     */
    public void setHoraLlegada() {
        this.horaLlegada = Instant.now();
    }
    /**
     * Establece el departamento del empleado.
     *
     * @param Depa departamento del empleado.
     */
    public void setDepartamento(String Depa){
        this.Dep = Depa;
    }
    /**
     * Obtiene el departamento del empleado.
     *
     * @return departamento del empleado.
     */
    public String getDepartamento(){
        return Dep;
    }
}
