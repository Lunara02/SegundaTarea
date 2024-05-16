package tarea2;

import Excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Empleado emp1;
    private Invitacion Lista;
    private ReunionPresencial ReunionP;

    @BeforeEach
    void setUp() {
        emp1 = new Empleado("200404", "Pedro", "Perez", "PePe@hotmail.com");
        Lista = new Invitacion();
    }

    @Test
    @DisplayName("Lista invitados vacia")
    void InvitadosVacio() {
        try {
            ReunionP = new ReunionPresencial(4,"Pedro",Lista, "Reunion 1", tipoReunion.MARKETING);
        } catch (noInvitados e){
            assertTrue(true);
        }
    }
}