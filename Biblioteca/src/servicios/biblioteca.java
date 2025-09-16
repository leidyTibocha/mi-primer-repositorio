package servicios;
import modelo.*;
public interface Biblioteca {
    //ingresar
     void ingresarLibro(Libro libro);
     void registrarUsuario(Usuario usuario, String dni);
     void realizarPrestamo(Prestamo prestamo);

     //mostrar total
     void mostrarTodosLibros();
     void mostrarUsuariosRegistrados();
     void mostrarTodosPrestamos();

     // libros
     void buscarLibroPorId (String id_libro);
     void buscarCopiasObra(String id_obra);
     void buscarPorGenero(Generos genero);
     void mostrarPorGeneros();
     void mostrarCantidadLibros();
     void mostrarCantidadLibrosPorGenero();


     //prestamos
     void buscarPrestamoPorId();
     void buscarPrestamoPorDNI();
     void buscarPrestamoPorIdLibro();
     void mostrarFechaPrestamos();
     void mostrarFechasLimitesPrestamos();
     void mostrarFechasDevolucion();
     void mostrarPrestamosVencidos();
     void mostrarCantidadPrestamos();
     void mostrarPrestamosPorGeneros();

     //usuarios
     void buscarUsuarioPorDni();
     void mostrarTotalUsuarios();
     void mostrarHistorialPrestamos();
     void cantidadPrestamosUsuarios();





}
