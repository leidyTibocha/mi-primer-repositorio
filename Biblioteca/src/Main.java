
import java.util.Scanner;
import servicios.Biblioteca;
import servicios.BibliotecaImpl;


public class Main {
    public static void main(String[] args) {
        //biblioteca, scanner,
        Biblioteca biblioteca = new BibliotecaImpl(null, null, null, null);
        Scanner scanner = new Scanner(System.in);
        int opcionMenu = 0;

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
        
            try {
                switch (opcionMenu) {
                    case 1 -> {
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
                        opcionMenu = scanner.nextInt();    
                    }

                    case 2 -> {
                        System.out.println("\n===== GESTIÓN DE USUARIOS =====");
                        System.out.println("1. Registrar usuario");
                        System.out.println("2. Buscar usuario por DNI");
                        System.out.println("3. Mostrar usuarios registrados");
                        System.out.println("4. Mostrar total de usuarios");
                        System.out.println("5. Mostrar historial de préstamos de un usuario");
                        System.out.println("6. Mostrar cantidad de préstamos por usuario");
                        System.out.println("7. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionMenu = scanner.nextInt();
                    }

                    case 3 -> {
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
                        opcionMenu = scanner.nextInt();
                    }

                    case 4 -> {
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
                        opcionMenu = scanner.nextInt();
                    }


                    case 5 -> {
                        System.out.println("\n===== GUARDAR / CARGAR DATOS =====");
                        System.out.println("1. Guardar datos");
                        System.out.println("2. Cargar datos");
                        System.out.println("3. Volver al menú principal");
                        System.out.print("Seleccione una opción: ");
                        opcionMenu = scanner.nextInt();
                    }

                    case 6 -> {
                        System.out.println("Saliendo del programa");
                    }


                }
            
            } catch (Exception e) {

            }

        }


        scanner.close();
    }   

}
