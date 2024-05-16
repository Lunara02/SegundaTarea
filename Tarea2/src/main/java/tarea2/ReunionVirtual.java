package tarea2;
import Excepciones.*;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(int duracionPrevista, String organizador, Invitacion listaInvitados, String enlace, tipoReunion tipoReunion) throws noInvitados {
        super(duracionPrevista, organizador, listaInvitados, enlace, tipoReunion);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return this.enlace;
    }
}
