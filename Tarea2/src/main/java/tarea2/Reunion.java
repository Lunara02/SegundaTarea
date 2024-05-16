package tarea2;

import Excepciones.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * La clase Reunion es una clase abstracta que representa una reunión.
 * Proporciona funcionalidades básicas para gestionar una reunión, como iniciar, finalizar, registrar asistencia, generar informes y crear notas.
 * Las clases hijas concretas (ReunionPresencial y ReunionVirtual) implementan detalles específicos de cada tipo de reunión.
 *
 * @author Sebastian Vega
 */

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
    private String Note = new String("");

    /**
     * Constructor para la clase Reunion.
     *
     * @param duracionPrevista Duración prevista de la reunión en horas.
     * @param Organizador El organizador de la reunión.
     * @param Invitados La lista de invitados a la reunión.
     * @param NombreSala El nombre de la sala donde se llevará a cabo la reunión.
     * @param A El tipo de reunión (TECNICA, MARKETING, OTRO).
     * @throws Exception si ocurre un error al crear la reunión.
     */

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

    /**
     * Establece la fecha y hora para la reunión.
     *
     * @param Year     El año de la fecha.
     * @param Months   El mes de la fecha (1 para enero, 2 para febrero, etc.).
     * @param Days     El día del mes.
     * @param Hours    La hora del día en formato de 24 horas.
     * @param Minutes  Los minutos de la hora.
     * @param Seconds  Los segundos del minuto.
     * @throws fechaPasada si la fecha y hora establecidas están en el pasado.
     */

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

    /**
     * Obtiene la lista de empleados que asistieron a la reunión.
     *
     * @return La lista de empleados que asistieron.
     */

    public ArrayList<Empleado> getAsistencias() {
        return asistencia.getAsistencias();
    }

    /**
     * Obtiene la lista de empleados que estuvieron ausentes en la reunión.
     *
     * @return La lista de empleados que estuvieron ausentes.
     */

    public ArrayList<Empleado> getAusencias() {
        return asistencia.getAusencias();
    }

    /**
     * Obtiene la lista de empleados que llegaron tarde a la reunión.
     *
     * @return La lista de empleados que llegaron tarde.
     */

    public ArrayList<Empleado> getRetrasos() {
        return asistencia.getRetrasos();
    }

    /**
     * Obtiene el total de empleados que asistieron a la reunión, incluyendo los que llegaron tarde.
     *
     * @return El total de empleados que asistieron.
     */

    public int getTotalAsistencias() {
        return getAsistencias().size() + getRetrasos().size();
    }

    /**
     * Calcula el porcentaje de asistencia a la reunión.
     *
     * @return El porcentaje de asistencia.
     */

    public int getPorcentajeAsistencia() {
        return (int)(((float) getTotalAsistencias() / (asistencia.getTotal())) * 100);
    }

    /**
     * Calcula la duración real de la reunión en formato HH:MM:SS.
     *
     * @return La duración real de la reunión.
     */

    public String calcularTiempoReal() {
        Duration DuracionReu = Duration.between(horaInicio, horaFin);
        Long Horas = DuracionReu.toHours();
        Long Minutos = DuracionReu.toMinutes();
        Long Segundos = DuracionReu.toSeconds();
        return new String(String.format("%02d:%02d:%02d", Horas, Minutos, Segundos));
    }

    /**
     * Inicia la reunión, registrando la hora de inicio.
     */

    public void iniciar() {
        horaInicio = Instant.now();
    }

    /**
     * Finaliza la reunión, registrando la hora de finalización.
     * @throws reunionNoFinalizada si la reunion no ha sido iniciada y se intenta finalizar
     */

    public void finalizar() throws reunionNoFinalizada {
        if(horaInicio == null){
            throw new reunionNoFinalizada();
        }
        horaFin = Instant.now();
    }

    /**
     * Registra la llegada de un empleado a la reunión.
     *
     * @param z El empleado que llega a la reunión.
     * @throws noInvitado si el empleado no está en la lista de invitados.
     */

    public void llego(Empleado z)throws noInvitado {
        if(Lista.contains(z)) {
            z.setHoraLlegada();
            asistencia.newAsistente(z, horaInicio, horaFin);
        }
        else{
            throw new noInvitado(z.getNombre());
        }
    }

    /**
     * Genera un informe detallado de la reunión, incluyendo información sobre la sala, el tema,
     * el organizador, la fecha y hora prevista, la duración prevista, la hora de inicio y fin real,
     * la asistencia de los empleados (incluyendo puntuales, retrasados y ausentes) y genera un archivo
     * de nota con el contenido del informe y otro para las notas del informe.
     *
     * @throws reunionNoTerminada si la reunión no ha sido iniciada o ya ha terminado.
     * @throws nosetFechayHora si no se ha establecido el horario
     */

    public void getInforme()throws reunionNoTerminada, nosetFechayHora {
        if (horaInicio == null || horaFin == null){
            throw new reunionNoTerminada();
        }
        if(horaPrevista == null){
            throw new nosetFechayHora();
        }
        Contenido = Contenido + NombreSala + "\n" + "Tema = " + TIPO + "\n";
        Contenido = Contenido + "ORGANIZADOR = "+ Organizador + "\n";
        Contenido = Contenido + "Fecha y hora prevista = " + horaPrevista.toString().substring(0,9) + " | " + horaPrevista.toString().substring(11,19) + "\n";
        Contenido = Contenido + "Duracion prevista = " + duracionPrevista.toHours() + "h" + "\n\n";
        Contenido = Contenido + "Inicio = " + horaInicio.toString().substring(11,19) + "\n";
        Contenido = Contenido + "Fin = " +  horaFin.toString().substring(11,19) + "\n";
        Contenido = Contenido + "Duracion = " + calcularTiempoReal() + "\n\n";
        Contenido = Contenido + "ASISTENCIA:" + "\n";
        Contenido = Contenido + "Asistencia total = " + getTotalAsistencias() + "\n";
        Contenido = Contenido + "Porcentaje asistencia = " + getPorcentajeAsistencia() + "%" + "\n";
        Contenido = Contenido + "Puntuales = " + asistencia.getAsistencias().size() + "\n";
        Contenido = Contenido + "Retrasados = " + asistencia.getRetrasos().size() + "\n";
        Contenido = Contenido + "Ausentes = " + asistencia.getAusencias().size() + "\n\n";
        Contenido = Contenido + "[NOMBRE]" + "\t" + "[APELLIDO]"+ "\t" + "[ID]" + "\t\t" + "[CORREO]" + "\t\t\t" + "[HORA]" + "\t\t" + "[ASISTENCIA]" + "\n\n";
        for(int x = 0; x < asistencia.getAsistencias().size(); x++){
            Contenido = Contenido + asistencia.getAsistencias().get(x).getNombre() + "\t\t" + asistencia.getAsistencias().get(x).getApellido() + "\t\t" + asistencia.getAsistencias().get(x).getId() + "\t\t" + asistencia.getAsistencias().get(x).getCorreo() + "\t\t" + asistencia.getAsistencias().get(x).getHoraLlegada().toString().substring(11,19) + "\t" + "PUNTUAL" + "\n";
        }
        for(int x = 0; x < asistencia.getRetrasos().size(); x++){
            Contenido = Contenido + asistencia.getRetrasos().get(x).getNombre() + "\t\t" + asistencia.getRetrasos().get(x).getApellido() + "\t\t" + asistencia.getRetrasos().get(x).getId() + "\t\t" + asistencia.getRetrasos().get(x).getCorreo() + "\t\t" + asistencia.getRetrasos().get(x).getHoraLlegada().toString().substring(11,19) + "\t" + "RETRASADO" + "\n";
        }
        for(int x = 0; x < asistencia.getAusencias().size(); x++){
            Contenido = Contenido + asistencia.getAusencias().get(x).getNombre() + "\t\t" + asistencia.getAusencias().get(x).getApellido() + "\t\t" + asistencia.getAusencias().get(x).getId() + "\t\t" + asistencia.getAusencias().get(x).getCorreo() + "\t\t" + "?" + "\t\t" + "AUSENTE" + "\n";
        }
        Nota Info = new Nota(Contenido, "[INFORME]");
        Nota InfoNotas = new Nota(Note, "[NOTAS]");
    }

    /**
     * Agrega una nota a las notas actuales con una marca de tiempo.
     * Este método añade la nota proporcionada a las notas existentes
     * con la hora actual
     *
     * @param Note La nota que se va a añadir.
     * @throws reunionNoTerminada si la reunión no ha comenzado
     */
    public void Notas(String Note) throws reunionNoTerminada{
        if(horaInicio == null){
            throw new reunionNoTerminada();
        }
        this.Note = this.Note + "[" + Instant.now().toString().substring(11,19) + "]: ";
        this.Note = this.Note + Note + "\n\n";
    }
}