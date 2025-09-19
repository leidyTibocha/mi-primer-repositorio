package servicios;
import modelo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    
        for(Generos e: Generos.values()){
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
        Arrays.stream(Generos.values())
        .forEach(genero -> {
            long cantidad = librosAlmacenados.stream()
                .filter(libro -> libro.getGenero() == genero)
                .count();
            System.out.println(genero.getDescripcion() + ": " + cantidad);
        });
    }
    
    @Override
    public void buscarPrestamoPorId(String id) {
        prestamosAlmacenados.stream()
        .filter(p -> Objects.equals(p.id_prestamo, id))
        .findFirst()
        .ifPresent(Prestamo::infoPrestamo);

        
    }
    @Override
    public void buscarPrestamoPorDNI(String dni) {
        prestamosAlmacenados.stream()
        .filter(prestamo -> prestamo.getDni_usuario().equals(dni))
        .forEach(Prestamo::infoPrestamo);

        }
    @Override
    public void buscarPrestamoPorIdLibro(String idLibro) {
       prestamosAlmacenados.stream()
       .filter(prestamo -> prestamo.getId_libro().equals(idLibro))
       .forEach(Prestamo::infoPrestamo);
    }
 
    @Override
    public void mostrarPrestamosVencidos() {
    System.out.println("VENCIDOS: ");
    prestamosAlmacenados.stream()
    .filter(prestamos -> prestamos.estaVencido() == true)
    .forEach(prestamo -> prestamo.infoPrestamo());

    }
    @Override
    public void mostrarCantidadPrestamos() {
       System.out.println(prestamosAlmacenados.size());
    }
    @Override
    public void mostrarPrestamosPorGeneros() {
        for (Generos g : Generos.values()) {
        System.out.println(g.getDescripcion());

        prestamosAlmacenados.stream()
            .filter(p -> librosAlmacenados.stream()
                .anyMatch(l -> l.getGenero() == g && Objects.equals(l.getId_libro(), p.id_libro)))
            .forEach(Prestamo::infoPrestamo);
        }


    }
    
    @Override
    public void buscarUsuarioPorDni(String dni) {
       usuariosAlmacenados.forEach((dni_usuario, usuario) -> {
        if (dni_usuario.equalsIgnoreCase(dni)) {
            usuario.mostrarInfoUsuario();
        }
       });
    }

    @Override
    public void mostrarTotalUsuarios() {
       System.out.println("Total usuarios: " + usuariosAlmacenados.size());
    }
    @Override
    public void mostrarHistorialPrestamos() {
       usuariosAlmacenados.forEach((dni, usuario) -> usuario.mostrarHistorialPrestamos());
    }
    @Override
    public void cantidadPrestamosUsuarios() {
        usuariosAlmacenados.forEach((dni, usuario) -> usuario.cantidadPrestamos());
    }

}