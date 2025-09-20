package servicios;
import modelo.*;

import java.util.*;

public class BibliotecaImpl implements Biblioteca {
    private final List<Libro> librosAlmacenados = new ArrayList<>();
    private final List<Prestamo> prestamosAlmacenados = new ArrayList<>();
    private final Map<String, Usuario> usuariosAlmacenados = new HashMap<>();

    @Override
    public void ingresarLibro(Libro libro) {
        librosAlmacenados.add(libro);
    }

    @Override
    public void registrarUsuario(Usuario usuario, String dni) {
        usuariosAlmacenados.put(dni, usuario);
    }

    @Override
    public void realizarPrestamo(Prestamo prestamo) {
        prestamosAlmacenados.add(prestamo);
    }

    @Override
    public void mostrarTodosLibros() {
        System.out.println("TODOS LOS LIBROS");
        librosAlmacenados.forEach(l -> {
            System.out.println("______________________________________");
            l.mostrarInfoLibro();
        });
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
        prestamosAlmacenados.forEach(Prestamo::infoPrestamo);
    }

    @Override
    public void buscarLibroPorId(String idLibro) {
        librosAlmacenados.stream()
                .filter(l -> Objects.equals(l.getId_libro(), idLibro))
                .findFirst()
                .ifPresent(Libro::mostrarInfoLibroCompleta);
    }

    @Override
    public void buscarCopiasObra(String idIsbn) {
        librosAlmacenados.stream()
                .filter(l -> Objects.equals(l.getId_isbn(), idIsbn))
                .forEach(Libro::mostrarInfoLibroCompleta);
    }

    @Override
    public void buscarPorGenero(Generos genero) {
        librosAlmacenados.stream()
                .filter(l -> l.getGenero() == genero)
                .forEach(Libro::mostrarGeneroLibroInfo);
    }

    @Override
    public void mostrarPorGeneros() {
        Arrays.stream(Generos.values()).forEach(g -> {
            System.out.println("      " + g.getDescripcion());
            librosAlmacenados.stream()
                    .filter(l -> l.getGenero() == g)
                    .forEach(Libro::mostrarGeneroLibroInfo);
        });
    }

    @Override
    public void mostrarCantidadLibros() {
        System.out.println("Cantidad total de libros: " + librosAlmacenados.size());
    }

    @Override
    public void mostrarCantidadLibrosPorGenero() {
        Arrays.stream(Generos.values())
                .forEach(g -> {
                    long cantidad = librosAlmacenados.stream()
                            .filter(l -> l.getGenero() == g)
                            .count();
                    System.out.println(g.getDescripcion() + ": " + cantidad);
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
                .filter(p -> Objects.equals(p.getDni_usuario(), dni))
                .forEach(Prestamo::infoPrestamo);
    }

    @Override
    public void buscarPrestamoPorIdLibro(String idLibro) {
        prestamosAlmacenados.stream()
                .filter(p -> Objects.equals(p.getId_libro(), idLibro))
                .forEach(Prestamo::infoPrestamo);
    }

    @Override
    public void mostrarPrestamosVencidos() {
        System.out.println("VENCIDOS: ");
        prestamosAlmacenados.stream()
                .filter(Prestamo::estaVencido)
                .forEach(Prestamo::infoPrestamo);
    }

    @Override
    public void mostrarCantidadPrestamos() {
        System.out.println("Cantidad total de préstamos: " + prestamosAlmacenados.size());
    }

    @Override
    public void mostrarPrestamosPorGeneros() {
        for (Generos g : Generos.values()) {
            System.out.println(g.getDescripcion());

            prestamosAlmacenados.stream()
                    .filter(p -> librosAlmacenados.stream()
                            .anyMatch(l -> l.getGenero() == g &&
                                           Objects.equals(l.getId_libro(), p.id_libro)))
                    .forEach(Prestamo::infoPrestamo);
        }
    }

    @Override
    public void buscarUsuarioPorDni(String dni) {
        Optional.ofNullable(usuariosAlmacenados.get(dni))
                .ifPresent(Usuario::mostrarInfoUsuario);
    }

    @Override
    public void mostrarTotalUsuarios() {
        System.out.println("Total usuarios: " + usuariosAlmacenados.size());
    }

    @Override
    public void mostrarHistorialPrestamos() {
        usuariosAlmacenados.values()
                .forEach(Usuario::mostrarHistorialPrestamos);
    }

    @Override
    public void cantidadPrestamosUsuarios() {
        usuariosAlmacenados.values()
                .forEach(Usuario::cantidadPrestamos);
    }
}
