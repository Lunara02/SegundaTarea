package tarea2;
import Excepciones.*;
/**
 * La clase ReunionVirtual representa una reunión virtual.
 * Extiende la clase Reunion e incluye información adicional sobre el enlace utilizado para la reunión.
 *
 * @author Sebastian Vega
 */
public class ReunionVirtual extends Reunion {
    private String enlace;
    /**
     * Constructor para la clase ReunionVirtual.
     *
     * @param duracionPrevista Duración prevista de la reunión en minutos.
     * @param organizador organizador de la reunión.
     * @param listaInvitados La lista de invitados a la reunión.
     * @param enlace enlace utilizado para la reunión virtual.
     * @param tipoReunion tipo de reunión (presencial o virtual).
     * @throws noInvitados si la lista de invitados es null.
     */
    public ReunionVirtual(int duracionPrevista, String organizador, Invitacion listaInvitados, String enlace, tipoReunion tipoReunion) throws noInvitados {
        super(duracionPrevista, organizador, listaInvitados, enlace, tipoReunion);
        this.enlace = enlace;
    }
    /**
     * Obtiene el enlace utilizado para la reunión virtual.
     *
     * @return enlace de la reunión virtual.
     */
    public String getEnlace() {
        return this.enlace;
    }
}
