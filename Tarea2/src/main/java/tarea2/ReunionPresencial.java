package tarea2;
import Excepciones.*;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(int duracionPrevista, String organizador, Invitacion listaInvitados, String sala, tipoReunion tipoReunion) throws noInvitados{
        super(duracionPrevista, organizador, listaInvitados, sala, tipoReunion);
        this.sala = sala;
    }
}