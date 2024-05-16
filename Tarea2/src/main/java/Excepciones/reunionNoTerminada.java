package Excepciones;

/**
 * La clase reunionNoTerminada es una excepción que se lanza cuando se intenta
 * realizar una operación relacionada con una reunión que no ha sido iniciada o ya ha terminado.
 * Extiende la clase Exception.
 *
 * @author Cristobal Gonzalez
 */
public class reunionNoTerminada extends Exception {

    /**
     * Constructor para la clase reunionNoTerminada.
     * Llama al constructor de la clase base (Exception) con un mensaje predeterminado
     * que indica que la reunión no ha sido iniciada o ya ha terminado.
     */
    public reunionNoTerminada() {
        super("[REUNION NO INICIADA O TERMINADA]\n");
    }
}
