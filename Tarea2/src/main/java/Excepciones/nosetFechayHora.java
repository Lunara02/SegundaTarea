package Excepciones;

/**
 * Esta clase representa una excepción que se lanza cuando no se ha establecido una fecha y hora
 * para una reunión
 * @author Braian Urra
 */
public class nosetFechayHora extends Exception {

    /**
     * Constructor para la clase nosetFechayHora.
     * Llama al constructor de la clase base (Exception) con un mensaje predeterminado
     * que indica que no se han elegido fecha y hora de la reunion
     */
    public nosetFechayHora() {
        super("[NO SE HA ELEGIDO FECHA Y HORA]");
    }
}