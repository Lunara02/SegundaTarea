package Excepciones;

/**
 * La clase fechaPasada es una excepción  que se lanza cuando se intenta
 * utilizar una fecha que está en el pasado y no es válida
 * Extiende la clase Exception.
 * @author Braian Urra
 */
public class fechaPasada extends Exception {

    /**
     * Constructor para la clase fechaPasada.
     * Llama al constructor de la clase base (Exception) con un mensaje predeterminado.
     */
    public fechaPasada() {
        super("[FECHA NO VALIDA]\n");
    }
}
