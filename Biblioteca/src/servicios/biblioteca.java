package servicios;
import modelo.*;
import excepciones.*;

public interface Biblioteca {
    //ingresar
     void ingresarLibro(Libro libro) throws CopiaYaExiste;
     void registrarUsuario(Usuario usuario, String dni) throws UsuarioYaExiste;
     void realizarPrestamo(Prestamo prestamo) throws LibroNoEncontradoException, LibroNoDisponibleException, UsuarioNoEncontradoException;


     //mostrar total
     void mostrarTodosLibros();
     void mostrarUsuariosRegistrados();
     void mostrarTodosPrestamos();

     // libros
     void buscarLibroPorId (String id_libro) throws LibroNoEncontradoException;
     void mostrarCopiasObra(String id_obra) throws LibroNoEncontradoException ;
     void mostrarPorGenero(Generos genero) ;
     void mostrarPorGeneros();
     void mostrarCantidadLibros();
     void mostrarCantidadLibrosPorGenero();


     //prestamos
     void buscarPrestamoPorDNI(String dni) throws PrestamoNoEncontradoException;
     void buscarPrestamoPorIdLibro(String idLibro) throws PrestamoNoEncontradoException;
     void mostrarPrestamosVencidos() ;
     void mostrarCantidadPrestamos();
     void mostrarPrestamosPorGeneros();

     //usuarios
     void buscarUsuarioPorDni(String dni) throws UsuarioNoEncontradoException;
     void mostrarTotalUsuarios();
     void mostrarHistorialPrestamos();
     void cantidadPrestamosUsuarios();
  

     //serializador, guardar y cargar datos
     void guardarDatos();
     void cargarDatos();


}
