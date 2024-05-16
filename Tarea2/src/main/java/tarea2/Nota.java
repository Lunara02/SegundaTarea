package tarea2;

import java.io.FileWriter;
import java.io.IOException;
/**
 * La clase Nota representa una nota que se puede guardar en un archivo de texto.
 * Al crear una instancia de Nota, se guarda el contenido de la nota en un archivo con el nombre especificado.
 * Si ocurre un error durante la escritura del archivo, se maneja imprimiendo el mensaje de error en la consola.
 *
 * @author Cristobal Gonzalez
 */
public class Nota {
    private String contenido;
    private String nombreArchivo;
    /**
     * Constructor para la clase Nota.
     *
     * @param contenido El contenido de la nota a guardar.
     * @param nombreArchivo El nombre del archivo en el que se guardará la nota.
     */
    public Nota(String contenido, String nombreArchivo) {
        try {
            FileWriter nota = new FileWriter(nombreArchivo);
            nota.write(contenido);
            nota.close();
        } catch (IOException a) {
            a.getMessage();
            a.printStackTrace();
        }
    }
}
