package tarea2;

import java.io.FileWriter;
import java.io.IOException;

public class Nota {
    private String contenido;
    private String nombreArchivo;

    public Nota(String contenido, String nombreArchivo) {
        try {
            FileWriter nota = new FileWriter(nombreArchivo);
            nota.write(contenido);
            nota.close();
        } catch (IOException a) {
            // Si ocurre un error durante la escritura del archivo, se imprime el mensaje de error en la consola.
            a.getMessage();
            a.printStackTrace();
        }
    }
}
