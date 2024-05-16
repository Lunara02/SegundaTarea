package tarea2;

import java.util.ArrayList;
/**
 * La clase Departamento representa un departamento cualquiera.
 * Contiene una lista de empleados que trabajan en ese departamento.
 *
 * @author Cristobal Gonzalez
 */
public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;
    /**
     * Constructor para la clase Departamento.
     *
     * @param nombre nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado empleado a agregar.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(getNombre());
    }
    /**
     * Getter del nombre del departamento.
     *
     * @return nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter de la cantidad de empleados en el departamento.
     *
     * @return cantidad de empleados en el departamento.
     */
    public int getCantidadEmpleado() {
        return empleados.size();
    }
    /**
     * Getter de la lista de empleados en el departamento.
     *
     * @return lista de empleados en el departamento.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
