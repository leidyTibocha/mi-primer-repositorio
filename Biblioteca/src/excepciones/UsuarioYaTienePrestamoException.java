package excepciones;

public class UsuarioYaTienePrestamoException extends Exception{

    public UsuarioYaTienePrestamoException(String mensaje){
        super(mensaje);
    }
}
