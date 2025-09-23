package excepciones;

public class PrestamoYaVencidoException extends Exception{

    public PrestamoYaVencidoException(String mensaje){
        super(mensaje);
    }
}
