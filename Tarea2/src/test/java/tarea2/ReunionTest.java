package tarea2;

import Excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Empleado emp1;
    private Invitacion Lista;
    private ReunionPresencial reunionP;

    @BeforeEach
    void setUp() {
        emp1 = new Empleado("id2", "Lavalosa", "goku","hmry");
        Lista = new Invitacion();
    }
}