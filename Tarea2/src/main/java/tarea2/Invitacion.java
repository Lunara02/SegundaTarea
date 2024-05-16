package tarea2;

import java.time.Instant;
import java.util.ArrayList;

public class Invitacion {
    private Instant hora;
    private ArrayList<Empleado> invitados;

    public Invitacion() {
        invitados = new ArrayList<>();
    }
    public void invitar(Empleado e) {
        invitados.add(e);
    }
    public void invitar(Departamento d) {
        invitados.addAll(d.getEmpleados());
    }

}