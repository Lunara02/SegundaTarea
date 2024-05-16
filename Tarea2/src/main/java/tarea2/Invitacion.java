package tarea2;

import java.time.Instant;
import java.util.ArrayList;
/**
 * La clase Invitacion representa una invitación para un evento.
 * Contiene información sobre la hora de la invitación y la lista de empleados invitados.
 * Puede invitar a empleados individualmente o a todos los empleados de un departamento.
 *
 * @author Cristobal Gonzalez
 */
public class Invitacion {
    private Instant hora;
    private ArrayList<Empleado> invitados;
    /**
     * Constructor para la clase Invitacion.
     * Inicializa la lista de invitados.
     */
    public Invitacion() {
        invitados = new ArrayList<>();
    }
    /**
     * Invita a un empleado.
     *
     * @param e El empleado a invitar.
     */
    public void invitar(Empleado e) {
        invitados.add(e);
    }
    /**
     * Invita a todos los empleados de un departamento.
     *
     * @param d El departamento del cual invitar a los empleados.
     */
    public void invitar(Departamento d) {
        invitados.addAll(d.getEmpleados());
    }
    /**
     * Obtiene la lista de empleados invitados.
     *
     * @return La lista de empleados invitados.
     */
    public ArrayList<Empleado> getInvitados() {
        return invitados;
    }
}