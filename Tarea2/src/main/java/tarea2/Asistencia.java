package tarea2;


import java.time.Instant;
import java.util.ArrayList;
/**
 * Clase Asistencia para manejar el control de asistencia de empleados.
 * Permite registrar asistencias, retrasos y ausencias.
 * Esta clase se encarga de registrar y categorizar la llegada de los empleados en
 * tres listas: asistencias, retrasos y ausencias.
 * @author Cristobal Gonzalez
 */

public class Asistencia {
    private ArrayList<Empleado> arrAsistencias;
    private ArrayList<Empleado> arrAusencias;
    private ArrayList<Empleado> arrRetrasos;
    private int arrInvitados;

    /**
     * Constructor de la clase Asistencia.
     * @param arrInvitados ArrayList de empleados invitados.
     */
    public Asistencia(ArrayList<Empleado> arrInvitados) {
        this.arrAusencias = arrInvitados;
        this.arrAsistencias = new ArrayList<>();
        this.arrRetrasos = new ArrayList<>();
        this.arrInvitados = arrInvitados.size();
    }
    /**
     * Método para registrar personas que Asistieron a la llamada.
     * @param e Empleado que se registra.
     * @param horaInicio Hora de inicio establecida.
     * @param horaFin    Hora de fin establecida (puede ser null).
     */
    public void newAsistente(Empleado e, Instant horaInicio, Instant horaFin) {
        if (horaInicio == null || e.getHoraLlegada().equals(horaInicio)) {
            addAsistencia(e);
        } else if (e.getHoraLlegada().isAfter(horaInicio) && horaFin == null) {
            addRetraso(e);
        }
    }
    /**
     * Método para agregar un empleado a la lista de asistencias.
     * @param e Empleado que se agrega.
     */
    public void addAsistencia(Empleado e) {
        arrAusencias.remove(e);
        arrAsistencias.add(e);
    }
    /**
     * Método para agregar un empleado a la lista de retrasos.
     * @param e Empleado que se agrega.
     */
    public void addRetraso(Empleado e) {
        arrAusencias.remove(e);
        arrRetrasos.add(e);
    }
    /**
     * Método para obtener la lista de asistencias.
     * @return ArrayList de empleados que asistieron.
     */
    public ArrayList<Empleado> getAsistencias() {
        return arrAsistencias;
    }
    /**
     * Método para obtener la lista de retrasos.
     * @return ArrayList de empleados que llegaron tarde.
     */

    public ArrayList<Empleado> getRetrasos() {
        return arrRetrasos;
    }
    /**
     * Método para obtener la lista de ausencias.
     *
     * @return ArrayList de empleados que no asistieron.
     */

    public ArrayList<Empleado> getAusencias() {
        return arrAusencias;
    }

    /**
     * Método para obtener el total de invitados.
     *
     * @return Número total de empleados invitados.
     */
    public int getTotal() {
        return arrInvitados;
    }
}
