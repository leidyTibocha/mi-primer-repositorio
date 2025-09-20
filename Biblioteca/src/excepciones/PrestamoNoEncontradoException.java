package excepciones;

public class PrestamoNoEncontradoException extends Exception {
    
    public PrestamoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
