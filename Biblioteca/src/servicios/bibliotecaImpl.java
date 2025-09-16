package servicios;
import modelo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaImpl implements Biblioteca{
    List<Libro> librosAlmacenados = new ArrayList<>();
    List<Prestamo> prestamosAlmacenados = new ArrayList<>();
    Map<String, Usuario> usuariosAlmacenados = new HashMap<>();

    
    public void ingresarLibro(Libro libro) {
       librosAlmacenados.add(libro);
    }
   
    public void registrarUsuario(Usuario usuario, String dni) {
        usuariosAlmacenados.put(dni, usuario);
    }
  
    public void realizarPrestamo(Prestamo prestamo) {
       prestamosAlmacenados.add(prestamo);
    }

    @Override
    public void mostrarTodosLibros() {
        System.out.println("TODOS LOS LIBROS");
        for(Libro l: librosAlmacenados){
            System.out.println("______________________________________");
            l.mostrarInfoLibro();
        }
    }
    @Override
    public void mostrarUsuariosRegistrados() {
        usuariosAlmacenados.forEach((dni, usuario) -> usuario.mostrarInfoUsuario());
    }
    @Override
    public void mostrarTodosPrestamos() {
       for (Prestamo p : prestamosAlmacenados) {
        p.infoPrestamo();
       }
    }
    @Override
    public void buscarLibroPorId() {
      
    }
    @Override
    public void buscarCopiasObra() {
       
    }
    @Override
    public void buscarPorGenero() {
        
    }
    @Override
    public void mostrarPorGeneros() {
      
    }
    @Override
    public void mostrarCantidadLibros() {
        
    }
    @Override
    public void mostrarCantidadLibrosPorGenero() {
       
    }
    @Override
    public void buscarPrestamoPorId() {
        
    }
    @Override
    public void buscarPrestamoPorDNI() {
       
    }
    @Override
    public void buscarPrestamoPorIdLibro() {
       
    }
    @Override
    public void mostrarFechaPrestamos() {
      
    }
    @Override
    public void mostrarFechasLimitesPrestamos() {
        
    }
    @Override
    public void mostrarFechasDevolucion() {
       
    }
    @Override
    public void mostrarPrestamosVencidos() {
       
    }
    @Override
    public void mostrarCantidadPrestamos() {
       
    }
    @Override
    public void mostrarPrestamosPorGeneros() {

    }
    @Override
    public void buscarUsuarioPorDni() {
       
    }
    @Override
    public void mostrarTotalUsuarios() {
       
    }
    @Override
    public void mostrarHistorialPrestamos() {
       
    }
    @Override
    public void cantidadPrestamosUsuarios() {
        //
    }

}