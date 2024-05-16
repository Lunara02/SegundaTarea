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
    @Test
    @DisplayName("Reunion No iniciada")
    void ReunionNoInicializada() throws nosetFechayHora, fechaPasada{
        ReunionP.setFechayHora(2100,3,20,12,0,0);
        try {
            ReunionP.getInforme();
        } catch (reunionNoTerminada e){
            assertTrue(true);
        }
    }
    @Test
    @DisplayName("Reunion No finalizada")
    void ReunionNoFinalizada() throws InterruptedException, noInvitado, nosetFechayHora, fechaPasada{
        ReunionP.setFechayHora(2100,3,20,12,0,0);
        ReunionP.llego(emp1);
        ReunionP.iniciar();
        Thread.sleep(2000);
        ReunionP.llego(emp2);
        try {
            ReunionP.getInforme();
        } catch (reunionNoTerminada e){
            assertTrue(true);
        }
    }
    @Test
    @DisplayName("Reunion Finalizada")
    void ReunionFinalizada() throws InterruptedException, noInvitado, reunionNoTerminada, nosetFechayHora, reunionNoFinalizada, fechaPasada{
        ReunionP.setFechayHora(2100,3,20,12,0,0);
        ReunionP.llego(emp1);
        ReunionP.iniciar();
        Thread.sleep(2000);
        ReunionP.llego(emp2);
        ReunionP.finalizar();
        ReunionP.getInforme();
    }
    @Test
    @DisplayName("Fecha y Hora null")
    void FechayHoranull() throws InterruptedException, noInvitado, reunionNoTerminada, reunionNoFinalizada {
        ReunionP.llego(emp1);
        ReunionP.iniciar();
        Thread.sleep(2000);
        ReunionP.llego(emp2);
        ReunionP.finalizar();
        try {
            ReunionP.getInforme();
        } catch (nosetFechayHora e){
            assertTrue(true);
        }
    }
    @Test
    @DisplayName("Fecha y Hora Elegidas")
    void FechayHoraElegidas() throws InterruptedException, noInvitado, reunionNoTerminada, nosetFechayHora, reunionNoFinalizada, fechaPasada{
        ReunionP.setFechayHora(2100,3,20,12,0,0);
        ReunionP.llego(emp1);
        ReunionP.iniciar();
        Thread.sleep(2000);
        ReunionP.llego(emp2);
        ReunionP.finalizar();
        ReunionP.getInforme();
    }
}