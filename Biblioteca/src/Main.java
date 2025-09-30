
import excepciones.*;
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
                        
                        System.out.println("\n===== GESTIÓN DE LIBROS =====");
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
                        scanner.next();
                        
                        switch (opcionSubMenus) {

                            case 1 -> {
                                try{
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
                                //BUSCAR libro por id
                                try {

                                    System.out.println("Ingrese el codigo unico del libro: ");
                                    String codigo = scanner.nextLine();
                                    String resultado = codigo.replaceAll("\\s+", "");
                                    biblioteca.buscarLibroPorId(resultado);
                                    
                                } catch (LibroNoEncontradoException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }

                            }

                            case 3 -> {
                                try{
                                System.out.println("Ingrese el codigo general de la obra: ");
                                String codigo = scanner.nextLine().replaceAll("\\s+", "");
                                biblioteca.mostrarCopiasObra(resultado);

                                }catch(LibroNoEncontradoException e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 4 -> {

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
                                biblioteca.mostrarPorGeneros();
                            }

                            case 6 -> {
                                
                                biblioteca.mostrarTodosLibros();
                            }

                            case 7 -> {
                                biblioteca.mostrarCantidadLibros();
                            }

                            case 8 -> {
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
                        scanner.next();
                        
                        switch(opcionSubMenus){
                         
                            case 1 ->{

                            }

                            case 2 ->{
                                try{
                                System.out.println("Ingrese el dni del usuario: ");
                                String dni = scanner.nextLine().replaceAll("\\s+", "");
                                biblioteca.buscarUsuarioPorDni(dni);
                                

                                }catch(UsuarioNoEncontradoException e){
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }

                            case 3 ->{
                                biblioteca.mostrarUsuariosRegistrados();
                            }

                            case 4 ->{
                                biblioteca.mostrarTotalUsuarios();
                            }

                            case 5 ->{

                            }

                            case 6 ->{
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
                        scanner.next();

                        switch (opcionSubMenus) {
                         
                            case 1 ->{

                            }

                            case 2 ->{

                            }
                            
                            case 3 ->{
                                
                            }

                            case 4 ->{
                                biblioteca.mostrarTodosPrestamos();
                            }

                            case 5 ->{
                                biblioteca.mostrarPrestamosVencidos();
                            }

                            case 6 ->{
                                biblioteca.mostrarCantidadPrestamos();
                            }

                            case 7 ->{
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
                        scanner.next();

                        switch (opcionSubMenus) {
                            case 1 -> {
                                biblioteca.mostrarTodosLibros();
                            }

                            case 2 ->{
                                biblioteca.mostrarUsuariosRegistrados();
                            }

                            case 3 -> {
                                biblioteca.mostrarTodosPrestamos();
                            }

                            case 4 -> {
                                biblioteca.mostrarCantidadLibrosPorGenero();
                            }

                            case 5 -> {
                                biblioteca.mostrarTotalUsuarios();
                            }

                            case 6 -> {
                                biblioteca.mostrarCantidadPrestamos();
                            }

                            case 7 -> {
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
                        scanner.next();

                        switch (opcionSubMenus) {
                            case 1 -> {

                            }

                            case 2 -> {

                            }

                            case 3 -> {

                            }
                        }

                        }
                    }

                    case 6 -> {
                        System.out.println("Saliendo del programa");
                    }


                }
            
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese solamente lo solicitado");
            }

        }


        scanner.close();
    }   

}
