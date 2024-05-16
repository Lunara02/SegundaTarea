package Excepciones;

public class reunionNoFinalizada extends Exception {
    public reunionNoFinalizada(){
        super("[NO SE PUEDE TERMINAR REUNION SI NO HA SIDO INICIALIZADA]");
    }
}
