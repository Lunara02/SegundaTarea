package Excepciones;

/**
 * La clase noInvitados es una excepción que se lanza cuando se intenta
 * acceder a la lista de invitados de una Invitacion que no tiene ningún empleado invitado.
 * Extiende la clase Exception.
 * @author Braian Urra
 */
public class noInvitados extends Exception {

    /**
     * Constructor para la clase noInvitados.
     * Llama al constructor de la clase base (Exception) con un mensaje predeterminado
     * que indica que no hay ningún empleado invitado.
     */
    public noInvitados() {
        super("[NO HAY INVITADOS]\n");
    }
}
