mi primer repositorio

#Gestor de Biblioteca Avanzado en Java

Un proyecto en **Java puro** que simula la gestión de una biblioteca, diseñado para practicar y aplicar **conceptos avanzados del lenguaje**.  
Este proyecto no utiliza bases de datos, sino que trabaja con **colecciones**, **serialización de objetos** y **archivos locales**.  

---

## Funcionalidades principales
- Registro de libros y usuarios.
- Préstamo y devolución de libros.
- Control de préstamos con fechas de vencimiento.
- Notificaciones de préstamos vencidos usando **hilos**.
- Persistencia de datos en archivos mediante **serialización**.
- Búsqueda, filtrado y ordenamiento de libros con **Streams y programación funcional**.

---

##  Temas de Java que se practican
- **Colecciones genéricas** (`List`, `Map`, `Set`)  
- **Streams y expresiones lambda**  
- **Manejo de excepciones personalizadas**  
- **Interfaces y clases abstractas**  
- **Programación funcional** (`Optional`, `Predicate`, `forEach`)  
- **Hilos y concurrencia** (`ExecutorService`, `ScheduledExecutorService`)  
- **Serialización y deserialización de objetos**  
- **Organización de paquetes y buenas prácticas**  

---

##  Estructura del proyecto
```

src/
├── modelo/
│    ├── Libro.java
│    ├── Usuario.java
│    ├── Prestamo.java
│
├── excepciones/
│    ├── LibroNoDisponibleException.java
│    ├── UsuarioNoEncontradoException.java
│
├── servicios/
│    ├── Biblioteca.java         // Interfaz
│    ├── BibliotecaImpl.java     // Implementación
│
├── util/
│    ├── Serializador.java       // Guardar y cargar datos
│
├── Main.java

````

---

##  Ejemplo de uso
```bash
# Compilar
javac src/**/*.java -d bin

# Ejecutar
java -cp bin Main
````

---

## Próximas mejoras

* Implementar interfaz gráfica con **JavaFX o Swing**.
* Añadir reportes de préstamos en formato `.txt` o `.json`.
* Expandir las reglas de negocio (máximo de libros prestados, sanciones, etc.).

---

##  Objetivo

Este proyecto no busca ser un sistema completo de biblioteca, sino un **mini proyecto de práctica** que concentre los temas avanzados de Java de forma clara y progresiva.

```

---
