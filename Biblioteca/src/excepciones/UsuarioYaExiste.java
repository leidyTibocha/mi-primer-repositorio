package excepciones;

public class UsuarioYaExiste extends Exception {

    public UsuarioYaExiste (String mensaje){
        super(mensaje);
    }
}
