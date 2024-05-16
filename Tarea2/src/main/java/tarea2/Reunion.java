package tarea2;

import Excepciones.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista = null;
    private Duration duracionPrevista;
    private Instant horaInicio = null;
    private Instant horaFin = null;
    private String Organizador;
    private String NombreSala;
    private String Contenido = new String("");
    private Asistencia asistencia;
    private String TIPO;
    private ArrayList<Empleado> Lista;

    public Reunion(int duracionPrevista, String Organizador, Invitacion Invitados, String NombreSala, tipoReunion A) throws noInvitados{
        this.duracionPrevista = Duration.ofHours(duracionPrevista);
        this.Organizador = Organizador;
        this.NombreSala = NombreSala;
        if(Invitados.getInvitados().size() == 0){
            throw new noInvitados();
        }
        this.asistencia = new Asistencia(Invitados.getInvitados());
        this.TIPO = A.toString();
        this.Lista = Invitados.getInvitados();
    }

    public void setFechayHora(int Year, int Months, int Days, int Hours, int Minutes, int Seconds) throws fechaPasada {
        fecha = new Date(Year - 1900, Months - 1, Days);
        fecha.setSeconds(Seconds);
        fecha.setMinutes(Minutes);
        fecha.setHours(Hours);
        horaPrevista = fecha.toInstant();
        if (horaPrevista.isBefore(Instant.now())){
            throw new fechaPasada();
        }
    }

    public ArrayList<Empleado> getAsistencias() {
        return asistencia.getAsistencias();
    }

    public ArrayList<Empleado> getAusencias() {
        return asistencia.getAusencias();
    }

    public ArrayList<Empleado> getRetrasos() {
        return asistencia.getRetrasos();
    }
}