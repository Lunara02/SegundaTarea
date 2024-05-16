package tarea2;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(getNombre());
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadEmpleado() {
        return empleados.size();
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
}
