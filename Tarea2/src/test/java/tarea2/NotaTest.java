package tarea2;

import Excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class NotaTest {
    private Empleado emp1;
    private Empleado emp2;
    private Empleado emp3;
    private Invitacion Lista;
    private ReunionPresencial ReunionP;

    @BeforeEach
    void setUp() throws noInvitados {
        emp1 = new Empleado("200404", "Pedro", "Perez", "PePe@hotmail.com");
        emp2 = new Empleado("ID2345", "Jose", "Vera","JoVe20@gmail.com");
        emp3 = new Empleado("123456", "Juan", "Campos","JuCa@hotmail.com");
        Lista = new Invitacion();
        Lista.invitar(emp2);
        Lista.invitar(emp1);
        Lista.invitar(emp3);
        ReunionP = new ReunionPresencial(4,"Pedro",Lista, "Reunion 1", tipoReunion.MARKETING);
    }
}