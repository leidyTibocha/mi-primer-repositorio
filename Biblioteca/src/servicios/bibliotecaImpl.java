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
        usuariosAlmacenados.forEach((dni, usuario) -> {
        System.out.println("Identificador: " + dni);
        usuario.mostrarInfoUsuario();
    });
    }
    @Override
    public void mostrarTodosPrestamos() {
       for (Prestamo p : prestamosAlmacenados) {
        p.infoPrestamo();
       }
    }
    @Override
    public void buscarLibroPorId(String id_libro) {
      for (Libro libro : librosAlmacenados) {
        if(libro.getId_libro().equals(id_libro)){
            libro.mostrarInfoLibroCompleta();
            break;
        }
      }
    }

    @Override
    public void buscarCopiasObra(String id_libro) {
      for (Libro libro : librosAlmacenados) {
        if(libro.getId_isbn().equals(id_libro)){
            libro.mostrarInfoLibroCompleta();
        }
      }
    }

    @Override
    public void buscarPorGenero(Generos genero) {//mostrar los libros de ese genero
        for (Libro libro : librosAlmacenados) {
            if(libro.getGenero() == genero){
                libro.mostrarGeneroLibroInfo();
            }
        }
    }
    @Override
    public void mostrarPorGeneros() {//mostrar todos los generos y sus libros
     
        Generos[] generos = Generos.values();
        for(Generos e: generos){
            System.out.println("      " + e.getDescripcion());
            for(Libro libro : librosAlmacenados){
                if (libro.getGenero() == e) {
                    libro.mostrarGeneroLibroInfo();
                }
            }
        }
      
    }
    @Override
    public void mostrarCantidadLibros() {
        System.out.println(librosAlmacenados.size());        
    }
    @Override
    public void mostrarCantidadLibrosPorGenero() {
       Generos[] generos = Generos.values();

       for(Generos e: generos){
            System.out.println(e.getDescripcion());
            int cantidadLibros = 0;
            
            for(Libro libro : librosAlmacenados){
                if (libro.getGenero() == e) {
                    cantidadLibros ++;
                }
            }

             System.out.println( cantidadLibros);
        }
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