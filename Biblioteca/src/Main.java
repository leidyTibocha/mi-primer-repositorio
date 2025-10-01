
import excepciones.*;

import java.time.LocalDate;
import java.util.*;
import modelo.*;
import servicios.Biblioteca;
import servicios.BibliotecaImpl;



public class Main {
    public static void main(String[] args) {
        //biblioteca, scanner,
        Biblioteca biblioteca = new BibliotecaImpl();
        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 0, opcionSubMenus = 0 ;

        //mensaje de bienvenida
        System.out.println("==================================================");
        System.out.println("              BIBLIOTECA MUNICIPAL       ");
        System.out.println("==================================================");



        //menu (se ejecuta solo al dar salir )
        while (opcionMenu != 6) { 

            System.out.println("           MENU PRINCIPAL");
            System.out.println(" 1.     Gestión de Libros");
            System.out.println(" 2.     Gestión de Usuarios");
            System.out.println(" 3.     Gestión de Préstamos");
            System.out.println(" 4.     Consultas y Reportes");
            System.out.println(" 5.     Guardar / Cargar Datos");
            System.out.println(" 6.     Salir");
            System.out.println("   Seleccione  una opcion: ");
        
            try {
                opcionMenu = scanner.nextInt();


                switch (opcionMenu) {
                    case 1 -> {
                        opcionSubMenus = 0;
                        while(opcionSubMenus != 9){
                        
                        System.out.println("\n======= GESTIÓN DE LIBROS =======");
                        System.out.println("1. Ingresar libro");
                        System.out.println("2. Buscar libro por ID");
                        System.out.println("3. Mostrar copias de una obra");
                        System.out.println("4. Mostrar libros por género");
                        System.out.println("5. Mostrar todos los géneros con sus libros");
                        System.out.println("6. Mostrar todos los libros");
                        System.out.println("7. Mostrar cantidad total de libros");
                        System.out.println("8. Mostrar cantidad de libros por género");
                        System.out.println("9. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionSubMenus = scanner.nextInt(); 
                        scanner.nextLine();
                        
                        
                        switch (opcionSubMenus) {

                            case 1 -> {
                                try{
                                    System.out.println("======= Ingresar Libro =======");
                                    System.out.println("Ingrese el codigo general para la obra:");
                                    String codigoGeneral = scanner.nextLine();
                                    String codigoUnico = biblioteca.generarCodigoLibro() ;


                                    System.out.println("Ingrese el titulo del libro: ");
                                    String titulo = scanner.nextLine();

                                    System.out.println("Ingrese solo los nombres del autor");
                                    String nombresAutor = scanner.nextLine();

                                    System.out.println("Ingrese los apellidos del autor:");
                                    String apellidosAutor = scanner.nextLine();

                                    System.out.println("Ingrese el año de publicacion:");
                                    int añoPublicado = scanner.nextInt();

                    
                                    Generos.mostrarGeneros();
                                    System.out.println("Escriba el código del género al que pertenece este libro:");
                                    int codigo = scanner.nextInt();

                                    Generos generoSeleccionado = Generos.fromCodigo(codigo);

                                    if (generoSeleccionado != null) {
                                        biblioteca.ingresarLibro(new Libro(codigoUnico, codigoGeneral, titulo, nombresAutor, apellidosAutor, añoPublicado, generoSeleccionado));
                                        System.out.println("Libro guardado exitosamente");
                                    } else {
                                        System.out.println(" Código de genero invalido, no se puedo guardar el libro");
                                    }
                                
                                

                                }catch(InputMismatchException e){
                                    System.out.println("Error de tipo: ingrese solo los datos pedidos");
                                }catch(CopiaYaExiste e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 2 -> {
                                System.out.println("======= Buscar libro por id =======");
                                try {

                                    System.out.println("Ingrese el codigo unico del libro: ");
                                    String codigo = scanner.nextLine().replaceAll("\\s+", "");
                                    biblioteca.buscarLibroPorId(codigo);
                                    
                                } catch (LibroNoEncontradoException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }

                            }

                            case 3 -> {
                                System.out.println("======= Mostrar copias de una obra =======");
                                try{
                                System.out.println("Ingrese el codigo general de la obra: ");
                                String codigo = scanner.nextLine().replaceAll("\\s+", "");
                                biblioteca.mostrarCopiasObra(codigo);

                                }catch(LibroNoEncontradoException e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 4 -> {
                                System.out.println("======= Mostrar libros por genero =======");

                                Generos.mostrarGeneros();
                                System.out.println("Escriba el código del genero que desea filtrar");
                                int codigo = scanner.nextInt();
                                Generos generoSeleccionado = Generos.fromCodigo(codigo);

                                  if (generoSeleccionado != null) {
                                        biblioteca.mostrarPorGenero(generoSeleccionado);
                                    } else {
                                        System.out.println(" Código de genero invalido");
                                    }
                               

                            }

                            case 5 -> {
                                System.out.println("======= Mostrar todos los Generos con sus libros =======");
                                biblioteca.mostrarPorGeneros();
                            }

                            case 6 -> {
                                System.out.println("======= Mostrar todos los Libros =======");
                                biblioteca.mostrarTodosLibros();
                            }

                            case 7 -> {
                                System.out.println("======= Mostrar cantida =======");
                                biblioteca.mostrarCantidadLibros();
                            }

                            case 8 -> {
                                System.out.println("======= Mostrar cantidad de libro por genero =======");
                                biblioteca.mostrarCantidadLibrosPorGenero();
                            }

                            case 9 -> {
                                System.out.println("Volviendo al menu principal...");
                            }
                          
                        }


                        } 
                    }

                    case 2 -> {
                        opcionSubMenus = 0;
                        while(opcionSubMenus != 7){
                        System.out.println("\n===== GESTIÓN DE USUARIOS =====");
                        System.out.println("1. Registrar usuario");
                        System.out.println("2. Buscar usuario por DNI");
                        System.out.println("3. Mostrar usuarios registrados");
                        System.out.println("4. Mostrar total de usuarios");
                        System.out.println("5. Mostrar historial de préstamos de un usuario");
                        System.out.println("6. Mostrar cantidad de préstamos por usuario");
                        System.out.println("7. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionSubMenus = scanner.nextInt();
                        scanner.nextLine();
                        
                        
                        switch(opcionSubMenus){
                         
                            case 1 ->{
                                System.out.println("======= Registrar Usuario =======");

                                try{
                                Usuario usuario;
                                System.out.println("=== Registro de Usuario (Administrador) ===");

                                System.out.print("Ingrese los nombres: ");
                                String nombres = scanner.nextLine();

                                System.out.print("Ingrese los apellidos: ");
                                String apellidos = scanner.nextLine();

                                System.out.print("Ingrese el DNI: ");
                                String dni = scanner.nextLine();

                                System.out.print("Ingrese el correo electrónico: ");
                                String correo_electronico = scanner.nextLine();

                                usuario = new Usuario(nombres, apellidos, dni, correo_electronico, null, null);

                                System.out.print("Ingrese la fecha de inscripción (yyyy-MM-dd): ");
                                String fechaStr = scanner.nextLine();
                                usuario.setFechaIncripcion(LocalDate.parse(fechaStr));

                                
                                biblioteca.registrarUsuario(usuario);

                                }catch(UsuarioYaExiste e){
                                    System.out.println("Error: " + e.getMessage());
                                }

                            }

                            case 2 ->{
                                System.out.println("======= Buscar usuario pot DNI =======");
                                try{
                                System.out.println("Ingrese el dni del usuario: ");
                                String dni = scanner.nextLine().replaceAll("\\s+", "");
                                biblioteca.mostrarUsuarioPorDni(dni);
                                }catch(UsuarioNoEncontradoException e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 3 ->{
                                System.out.println("======= Todos los usuarios registrados =======");
                                biblioteca.mostrarUsuariosRegistrados();
                            }

                            case 4 ->{
                                System.out.println("======= Cantidad total de usuarios =======");
                                biblioteca.mostrarTotalUsuarios();
                            }

                            case 5 ->{
                                System.out.println("=======  Historial de prestamos de un usuario =======");
                                System.out.println("Ingrese el dni del usuario: ");
                                String dni = scanner.nextLine();

                                try {
                                    Usuario usuario = biblioteca.buscarUsuarioPorDni(dni);

                                    usuario.mostrarHistorialPrestamos();
                                } catch (UsuarioNoEncontradoException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }

                            }

                            case 6 ->{
                                System.out.println("======= Mostrar cantidad de prestaos por usuario =======");
                                biblioteca.mostrarHistorialPrestamos();
                            }
                        
                            case 7 ->{
                                System.out.println("Volviendo al menu principal");
                            }
                        }

                        
                        }
                    }

                    case 3 -> {
                        opcionSubMenus = 0;
                        while(opcionSubMenus != 8){
                        System.out.println("\n===== GESTIÓN DE PRÉSTAMOS =====");
                        System.out.println("1. Realizar préstamo");
                        System.out.println("2. Buscar préstamo por DNI");
                        System.out.println("3. Buscar préstamo por ID del libro");
                        System.out.println("4. Mostrar todos los préstamos");
                        System.out.println("5. Mostrar préstamos vencidos");
                        System.out.println("6. Mostrar cantidad total de préstamos");
                        System.out.println("7. Mostrar préstamos por géneros");
                        System.out.println("8. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionSubMenus = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionSubMenus) {
                         
                            case 1 ->{
                                try{
                                // Pedimos los datos del préstamo
                                System.out.println("======= Registro de Préstamo =======");

                                System.out.print("Ingrese el DNI del usuario: ");
                                String dni_usuario = scanner.nextLine().replaceAll("\\s+", "");

                                System.out.print("Ingrese el ID del libro: ");
                                String id_libro = scanner.nextLine().replaceAll("\\s+", "");

                                System.out.print("Ingrese la fecha del préstamo (yyyy-MM-dd): ");
                                LocalDate fechaPrestamo = LocalDate.parse(scanner.nextLine());

                                System.out.print("Ingrese la fecha límite de devolución (yyyy-MM-dd): ");
                                LocalDate fechaLimite = LocalDate.parse(scanner.nextLine());

                                System.out.print("Ingrese la fecha de devolución (yyyy-MM-dd) o presione Enter si aún no se devuelve: ");
                                String fechaDevolucionStr = scanner.nextLine();
                                LocalDate fechaDevolucion = null;
                                if (!fechaDevolucionStr.isBlank()) {
                                    fechaDevolucion = LocalDate.parse(fechaDevolucionStr);
                                }

                                biblioteca.realizarPrestamo(new Prestamo(dni_usuario, id_libro, fechaPrestamo, fechaLimite, fechaDevolucion));

                            }catch(LibroNoEncontradoException e){
                                System.out.println("Error: " + e.getMessage());
                            }catch(LibroNoDisponibleException e){
                                System.out.println("Error: " + e.getMessage());
                            }catch(UsuarioNoEncontradoException e){
                                System.out.println("Error: " + e.getMessage());
                            }


                                


                            }

                            case 2 ->{
                                System.out.println("======= Buscar prestamo por DNI =======");
                                System.out.println("Ingrese el DNI del usuario: ");
                                String dni = scanner.nextLine().replaceAll("\\s+", "");
                                try {
                                    biblioteca.buscarPrestamoPorDNI(dni);
                                } catch (PrestamoNoEncontradoException e) {
                                    System.err.println("Error: " + e.getMessage());
                                }
                            }
                            
                            case 3 ->{
                                System.out.println("======= Buscar  prestamo por Id libro =======");
                                try{
                                System.out.println("Ingrese el id del libro: ");
                                String idLibro = scanner.nextLine().replaceAll("\\s+", "");
                                biblioteca.buscarPrestamoPorIdLibro(idLibro);
                                }catch(PrestamoNoEncontradoException e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 4 ->{
                                System.out.println("======= Todos los prestamos =======");
                                biblioteca.mostrarTodosPrestamos();
                            }

                            case 5 ->{
                                System.out.println("======= Prestamos vencidos =======");
                                biblioteca.mostrarPrestamosVencidos();
                            }

                            case 6 ->{
                                System.out.println("======= Cantiad total de prestamos =======");
                                biblioteca.mostrarCantidadPrestamos();
                            }

                            case 7 ->{
                                System.out.println("======= Prestamos por genero =======");
                                biblioteca.mostrarPrestamosPorGeneros();
                            }

                            case 8 ->{
                                System.out.println("Volviendo al menu principal..");
                            }
                        }

                        }
                    }

                    case 4 -> {
                        opcionSubMenus = 0;
                        while(opcionSubMenus != 8){
                        System.out.println("\n===== CONSULTAS Y REPORTES =====");
                        System.out.println("1. Mostrar todos los libros");
                        System.out.println("2. Mostrar todos los usuarios");
                        System.out.println("3. Mostrar todos los préstamos");
                        System.out.println("4. Mostrar cantidad de libros por género");
                        System.out.println("5. Mostrar cantidad total de usuarios");
                        System.out.println("6. Mostrar cantidad total de préstamos");
                        System.out.println("7. Mostrar préstamos vencidos");
                        System.out.println("8. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionSubMenus = scanner.nextInt();
                        scanner.nextLine();
                       

                        switch (opcionSubMenus) {
                            case 1 -> {
                                System.out.println("======= Todos los libros =======");
                                biblioteca.mostrarTodosLibros();
                            }

                            case 2 ->{
                                System.out.println("======= Todos los usuarios =======");
                                biblioteca.mostrarUsuariosRegistrados();
                            }

                            case 3 -> {
                                System.out.println("======= Todos los prestamos =======");
                                biblioteca.mostrarTodosPrestamos();
                            }

                            case 4 -> {
                                System.out.println("======= Cantidad de lirbos por por genero =======");
                                biblioteca.mostrarCantidadLibrosPorGenero();
                            }

                            case 5 -> {
                                System.out.println("======= Total usuarios =======");
                                biblioteca.mostrarTotalUsuarios();
                            }

                            case 6 -> {
                                System.out.println("======= Total prestamos =======");
                                biblioteca.mostrarCantidadPrestamos();
                            }

                            case 7 -> {
                                System.out.println("======= Prestamos vencidos =======");
                                biblioteca.mostrarPrestamosVencidos();
                            }

                            case 8 -> {
                                System.out.println("Volviendo al menu principal...");
                            }
                        }

                        }
                    }

                    case 5 -> {
                        opcionSubMenus = 0;
                        while (opcionSubMenus != 3){
                        System.out.println("\n===== GUARDAR / CARGAR DATOS =====");
                        System.out.println("1. Guardar datos");
                        System.out.println("2. Cargar datos");
                        System.out.println("3. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionSubMenus = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionSubMenus) {
                            case 1 -> {
                                System.out.println("======= Guardar datos =======");
                                biblioteca.guardarDatos();
                            }

                            case 2 -> {
                                System.out.println("======= Cargar datos =======");
                                biblioteca.cargarDatos();
                            }

                            case 3 -> {
                                System.out.println("Volviendo al menu principal....");                            
                            }
                        }

                        }
                    }

                    case 6 -> {
                        System.out.println("Guardando datos antes de salir...");
                        biblioteca.guardarDatos(); // AGREGAR ESTO
                        System.out.println("Hasta luego!");
                        scanner.close();
                        System.exit(0); // Cierra el programa
                    }


                }
            
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese solamente los datos solicitados");
                opcionMenu = 0;
                opcionSubMenus = 0;
                scanner = new Scanner(System.in);
            }catch (Exception e){
                System.out.println("Error inesperado");
            }


        }


        scanner.close();
    }   

}
