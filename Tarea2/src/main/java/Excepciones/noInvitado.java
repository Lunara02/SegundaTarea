package Excepciones;

/**
 * La clase noInvitado es una excepción que se lanza cuando se intenta
 * acceder a un empleado que no ha sido invitado a un evento.
 * Extiende la clase Exception.
 * @author Braian Urra
 */
public class noInvitado extends Exception {

    /**
     * Constructor para la clase noInvitado.
     * Llama al constructor de la clase base (Exception) con un mensaje personalizado que indica
     * que el empleado especificado no está invitado al evento.
     *
     * @param a El nombre del empleado que no está invitado.
     */
    public noInvitado(String a) {
        super("[ERROR]: " + a + " no esta invitado\n");
    }
}
