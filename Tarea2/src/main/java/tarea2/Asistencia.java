package tarea2;


import java.time.Instant;
import java.util.ArrayList;

public class Asistencia {
    private ArrayList<Empleado> arrAsistencias;
    private ArrayList<Empleado> arrAusencias;
    private ArrayList<Empleado> arrRetrasos;
    private int arrInvitados;

    public Asistencia(ArrayList<Empleado> arrInvitados) {
        this.arrAusencias = arrInvitados;
        this.arrAsistencias = new ArrayList<>();
        this.arrRetrasos = new ArrayList<>();
        this.arrInvitados = arrInvitados.size();
    }

    public void newAsistente(Empleado e, Instant horaInicio, Instant horaFin) {
        if (horaInicio == null || e.getHoraLlegada().equals(horaInicio)) {
            addAsistencia(e);
        } else if (e.getHoraLlegada().isAfter(horaInicio) && horaFin == null) {
            addRetraso(e);
        }
    }

    public void addAsistencia(Empleado e) {
        arrAusencias.remove(e);
        arrAsistencias.add(e);
    }

    public void addRetraso(Empleado e) {
        arrAusencias.remove(e);
        arrRetrasos.add(e);
    }

}
