package tarea2;
import Excepciones.*;
/**
 * La clase ReunionPresencial representa una reunión presencial.
 * Extiende la clase Reunion e incluye información adicional sobre la sala donde se llevará a cabo la reunión.
 *
 * @author Cristobal Gonzalez
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    /**
     * Constructor para la clase ReunionPresencial.
     *
     * @param duracionPrevista Duración prevista de la reunión en minutos.
     * @param organizador El organizador de la reunión.
     * @param listaInvitados La lista de invitados a la reunión.
     * @param sala El nombre de la sala donde se llevará a cabo la reunión.
     * @param tipoReunion El tipo de reunión.
     * @throws Exception si ocurre un error al crear la reunión.
     */
    public ReunionPresencial(int duracionPrevista, String organizador, Invitacion listaInvitados, String sala, tipoReunion tipoReunion) throws noInvitados{
        super(duracionPrevista, organizador, listaInvitados, sala, tipoReunion);
        this.sala = sala;
    }
    /**
     * Obtiene el nombre de la sala donde se llevará a cabo la reunión.
     *
     * @return El nombre de la sala de la reunión.
     */
    public String getSala() {
        return this.sala;
    }
}