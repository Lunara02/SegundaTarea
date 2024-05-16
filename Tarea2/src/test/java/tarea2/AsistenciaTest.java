package tarea2;

import Excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AsistenciaTest {
    private Empleado emp1;
    private Empleado emp2;
    private Invitacion Lista;
    private ReunionPresencial ReunionP;

    @BeforeEach
    void setUp() throws noInvitados {
        emp1 = new Empleado("id1", "nombre1", "apellido1", "correo1");
        emp2 = new Empleado("id2", "Lavalosa", "goku","hmry");
        Lista = new Invitacion();
        Lista.invitar(emp2);
        ReunionP = new ReunionPresencial(4,"Pedro",Lista, "Reunion 1", tipoReunion.MARKETING);
    }
    @Test
    @DisplayName("LLego empleado no invitado")
    void TestNoInvitados() {
        ReunionP.iniciar();
        try {
            ReunionP.llego(emp1);
        } catch (noInvitado e){
            assertTrue(true);
        }
    }
    @Test
    @DisplayName("LLego empleado invitado")
    void TestInvitado() throws noInvitado{
        ReunionP.iniciar();
        ReunionP.llego(emp2);
    }
}