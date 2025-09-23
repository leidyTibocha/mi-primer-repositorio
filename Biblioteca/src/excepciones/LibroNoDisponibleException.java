package excepciones;

public class LibroNoDisponibleException extends Exception{
    
    public LibroNoDisponibleException(String mensaje){
        super(mensaje);
    }
}
