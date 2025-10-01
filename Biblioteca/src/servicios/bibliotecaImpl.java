package servicios;
import excepciones.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Year;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import modelo.*;
import util.Serializador;

    public class BibliotecaImpl implements Biblioteca {
    private List<Libro> librosAlmacenados = new ArrayList<>();
    private List<Prestamo> prestamosAlmacenados = new ArrayList<>();
    private Map<String, Usuario> usuariosAlmacenados = new HashMap<>();
    private ScheduledExecutorService scheduler;

    public BibliotecaImpl() {
        cargarDatos();
        iniciarHiloVencidos();
    }


        //ingresar
    @Override
    public void ingresarLibro(Libro libro) throws CopiaYaExiste {
        boolean existe = librosAlmacenados.stream()
        .anyMatch(l -> l.getId_libro().equals(libro.getId_libro()));

        if (existe) {
            throw new CopiaYaExiste("Ya existe un libro con ese ID");
        }
        librosAlmacenados.add(libro);
        
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws UsuarioYaExiste {
        if (usuariosAlmacenados.containsKey(usuario.getDni())) {
            throw new UsuarioYaExiste("El usuario ya está registrado");
        }

        usuariosAlmacenados.put(usuario.getDni(), usuario);


    }

    @Override
    public void realizarPrestamo(Prestamo prestamo)  throws LibroNoEncontradoException, LibroNoDisponibleException, UsuarioNoEncontradoException{
        // LibroNoEncontradoException, LibroNoDisponibleException, UsuarioNoEncontradoException, UsuarioYaTienePrestamoException

        boolean libroExiste = librosAlmacenados.stream() //no existe el libro
        .anyMatch(l -> l.getId_libro().equals(prestamo.getId_libro()));
        boolean libroNoDisponible = prestamosAlmacenados.stream()
            .anyMatch(p -> p.getId_libro().equals(prestamo.getId_libro()) && !p.fueDevuelto());
       boolean usuarioExiste = usuariosAlmacenados.containsKey(prestamo.getDni_usuario());


        if(libroExiste == false ){
            throw new LibroNoEncontradoException("No se encontro el libro, verifique el id del libro");
        }else if(libroNoDisponible){
            throw new LibroNoDisponibleException("El libro ya fue prestado, intente con otra copia");
        }else if(!usuarioExiste){
            throw new UsuarioNoEncontradoException("No se encontro el dni del usuario, asegurese que dni este correcto o que este registrado");
        }
        
        prestamosAlmacenados.add(prestamo);
        

    }


     //mostrar total
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


    
    // libros
    @Override
    public void buscarLibroPorId(String idLibro) throws LibroNoEncontradoException{
        Libro libro = librosAlmacenados.stream()
            .filter(l -> Objects.equals(l.getId_libro(), idLibro))
            .findFirst()
            .orElseThrow(() -> new LibroNoEncontradoException("No se encontró libro con ID: " + idLibro));


        libro.mostrarInfoLibroCompleta();
    }
    

    @Override
    public void mostrarCopiasObra(String idIsbn) throws LibroNoEncontradoException {
        boolean copiaValida = librosAlmacenados.stream()
        .anyMatch(l -> l.getId_isbn().equals(idIsbn));


        if(!copiaValida){
            throw new LibroNoEncontradoException("No se encontro la obra, verifique que este bien escrita");
        }

         System.out.println("ID OBRA: "  + idIsbn);
            librosAlmacenados.stream()
            .filter(l -> l.getId_isbn().equals(idIsbn))
            .forEach(l -> l.mostrarInfoLibro());
    }

    @Override
    public void mostrarPorGenero(Generos genero) { 
         System.out.println("      " + genero.getDescripcion());
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

    
    public  boolean codigoRepetido(String codigo){
          boolean existe = librosAlmacenados.stream()
          .anyMatch(l -> l.getId_libro().equals(codigo));

          return existe;
     }

    
    
     //prestamos
    @Override
    public void buscarPrestamoPorDNI(String dni) throws PrestamoNoEncontradoException{
       List<Prestamo> prestamos = prestamosAlmacenados.stream()
        .filter(p -> p.getDni_usuario().equals(dni))
        .collect(Collectors.toList());
        
        if (prestamos.isEmpty()) {
            throw new PrestamoNoEncontradoException("No hay préstamos para DNI: " + dni);
        }
        
        prestamos.forEach(Prestamo::infoPrestamo);
        
    }

    @Override
    public void buscarPrestamoPorIdLibro(String idLibro) throws PrestamoNoEncontradoException {
        List<Prestamo> prestamos = prestamosAlmacenados.stream()
        .filter(p -> Objects.equals(p.getId_libro(), idLibro))
        .collect(Collectors.toList());

        if (prestamos.isEmpty()) {
            throw new PrestamoNoEncontradoException("No hay préstamos para el libro: " + idLibro);
        }

        prestamos.forEach(Prestamo::infoPrestamo);
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
    public void mostrarPrestamosPorGeneros () {
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
    public Usuario buscarUsuarioPorDni(String dni) throws UsuarioNoEncontradoException {
       Usuario usuario = usuariosAlmacenados.get(dni);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("No se encontró usuario con DNI: " + dni);
        }
        return usuario;
    }


    //usuarios
    @Override
    public void mostrarUsuarioPorDni(String dni) throws UsuarioNoEncontradoException {
       Usuario usuario = usuariosAlmacenados.get(dni);
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("No se encontró usuario con DNI: " + dni);
        }
        usuario.mostrarInfoUsuario();
        
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


    
    //serializador, guardar y cargar datos
     @Override
    public void guardarDatos() {
        try {
            Serializador.guardar(librosAlmacenados, "libros.dat");
            Serializador.guardar(usuariosAlmacenados, "usuarios.dat");  
            Serializador.guardar(prestamosAlmacenados, "prestamos.dat");
            System.out.println("Todos los datos fueron guardados correctamente");

             // CERRAR EL HILO
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
            System.out.println("Sistema de notificaciones desactivado");
        }
        
        } catch (IOException e) {
            System.err.println("Error guardando datos: " + e.getMessage());
        }
    }

    // Método para CARGAR todos los datos
    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        try {
            // Intentar cargar libros
            try {
                List<Libro> libros = (List<Libro>) Serializador.cargar("libros.dat");
                librosAlmacenados.clear();
                librosAlmacenados.addAll(libros);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se encontraron libros previos");
            }
            
            // Intentar cargar usuarios
            try {
                Map<String, Usuario> usuarios = (Map<String, Usuario>) Serializador.cargar("usuarios.dat");
                usuariosAlmacenados.clear();
                usuariosAlmacenados.putAll(usuarios);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se encontraron usuarios previos");
            }
            
            // Intentar cargar préstamos
            try {
                List<Prestamo> prestamos = (List<Prestamo>) Serializador.cargar("prestamos.dat");
                prestamosAlmacenados.clear();
                prestamosAlmacenados.addAll(prestamos);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se encontraron préstamos previos");
            }
            
        } catch (Exception e) {
            System.out.println("Error general cargando datos: " + e.getMessage());
        }
}
    

    //hilos 
    private void verificarYNotificarVencidos() {
        List<Prestamo> vencidos = prestamosAlmacenados.stream()
            .filter(Prestamo::estaVencido)
            .filter(p -> !p.fueDevuelto()) // Solo los no devueltos
            .collect(Collectors.toList());
        
        if (!vencidos.isEmpty()) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println(" ALERTA AUTOMATICA: " + vencidos.size() + " prestamo(s) vencido(s)");
            System.out.println("=".repeat(50));
            
            vencidos.forEach(p -> {
                System.out.println("Libro ID: " + p.getId_libro() + 
                                " | Usuario: " + p.getDni_usuario() +
                                " | Días de retraso: " + p.diasDeRetraso());
            });
            System.out.println("=".repeat(50) + "\n");
        }
    }


    private void iniciarHiloVencidos() {
        scheduler = Executors.newScheduledThreadPool(1);
        
        // El vigilante ejecuta cada 15 segundos
        scheduler.scheduleAtFixedRate(() -> {
            verificarYNotificarVencidos();
        }, 10, 15, TimeUnit.SECONDS);  // 10s delay inicial, después cada 15s
        
        System.out.println("Sistema de notificaciones de vencidos ACTIVADO");
    }

    @Override
    public String generarCodigoLibro() {
    String codigo;
    do {
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sufijo = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(CARACTERES.length());
            sufijo.append(CARACTERES.charAt(index));
        }

        codigo = "LIB-" + Year.now().getValue() + "-" + sufijo;

    } while (codigoRepetido(codigo)); // vuelve a intentar si está repetido

    return codigo;
}

}
