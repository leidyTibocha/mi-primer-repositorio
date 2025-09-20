package servicios;
import modelo.*;
import excepciones.*;
import java.util.*;

public class BibliotecaImpl implements Biblioteca {
    private final List<Libro> librosAlmacenados = new ArrayList<>();
    private final List<Prestamo> prestamosAlmacenados = new ArrayList<>();
    private final Map<String, Usuario> usuariosAlmacenados = new HashMap<>();

    @Override
    public void ingresarLibro(Libro libro) throws CopiaYaExiste {
        for (Libro l : librosAlmacenados) {
        if (l.getId_libro().equals(libro.getId_libro())) {
            throw new CopiaYaExiste("Ya existe un libro con ese ID");
        }
    }
        
    }

    @Override
    public void registrarUsuario(Usuario usuario, String dni) throws UsuarioYaExiste {
        boolean usuarioYaExiste = usuariosAlmacenados.values().stream()
        .anyMatch(u -> u.getDni().equals(dni));

        if(usuarioYaExiste){
            throw new UsuarioYaExiste("El usuario ya esta registrario");
        }else{
            usuariosAlmacenados.put(dni, usuario);
        }

    }

    @Override
    public void realizarPrestamo(Prestamo prestamo)  throws LibroNoEncontradoException, LibroNoDisponibleException, UsuarioNoEncontradoException{
        // LibroNoEncontradoException, LibroNoDisponibleException, UsuarioNoEncontradoException, UsuarioYaTienePrestamoException

        boolean libroExiste = librosAlmacenados.stream() //no existe el libro
        .anyMatch(l -> l.getId_libro().equals(prestamo.getId_libro()));
        boolean libroNoDisponible  = prestamosAlmacenados.stream() //osea que ya fue prestado
        .anyMatch(p -> p.getId_libro().equals(prestamo.getId_libro()));
        boolean usuarioNoEncontrado = usuariosAlmacenados.values().stream() //usuario no existe
        .anyMatch(u -> u.getDni().equals(prestamo.getDni_usuario()));

        if(libroExiste == false ){
            throw new LibroNoEncontradoException("No se encontro el libro, verifique el id del libro");
        }else if(libroNoDisponible){
            throw new LibroNoDisponibleException("El libro ya fue prestado, intente con otra copia");
        }else if(usuarioNoEncontrado == false){
            throw new UsuarioNoEncontradoException("No se encontro el dni del usuario, asegurese que dni este correcto o que este registrado");
        }else{
            prestamosAlmacenados.add(prestamo);
        }

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
    public Libro buscarLibroPorId(String idLibro) throws LibroNoEncontradoException{
        return librosAlmacenados.stream()
            .filter(l -> Objects.equals(l.getId_libro(), idLibro))
            .findFirst()
            .orElseThrow(() -> new LibroNoEncontradoException("No se encontró libro con ID: " + idLibro));
    }
    

    @Override
    public void mostrarCopiasObra(String idIsbn) throws LibroNoEncontradoException {
        boolean copiaValida = librosAlmacenados.stream()
        .anyMatch(l -> l.getId_isbn().equals(idIsbn));


        if(copiaValida){
            System.out.println("ID OBRA: "  + idIsbn);
            librosAlmacenados.stream()
            .filter(l -> l.getId_isbn().equals(idIsbn))
            .forEach(l -> l.mostrarInfoLibro());
        }else {
            throw new LibroNoEncontradoException("No se encontro la obra, verifique que este bien escrita");
        }
    }

    @Override
    public void mostrarPorGenero(Generos genero) { //verificar que el genero exista o noas va alanzar excepcion
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
