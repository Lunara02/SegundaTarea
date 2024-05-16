package Excepciones;

/**
 * Esta clase representa una excepción que se lanza cuando se intenta finalizar una reunión
 * que no ha sido inicializada previamente.
 * @author Braian Urra
 */
public class reunionNoFinalizada extends Exception {

    /**
     * Constructor para la clase reunionNoFinalizada.
     * Llama al constructor de la clase base (Exception) con un mensaje predeterminado
     * que indica que no se puede terminar la reunion si no ha sido finalizada.
     */
    public reunionNoFinalizada() {
        super("[NO SE PUEDE TERMINAR REUNION SI NO HA SIDO INICIALIZADA]");
    }
}