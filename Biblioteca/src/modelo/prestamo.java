package modelo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

public class Prestamo implements Serializable {
    private String dni_usuario;
    private String id_libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;

    public Prestamo(String dni_usuario, String id_libro, LocalDate fechaPrestamo, LocalDate fechaLimite, LocalDate fechaDevolucion) {
        this.dni_usuario = dni_usuario;
        this.id_libro = id_libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = fechaDevolucion;
    }

    

    public String getDni_usuario() {
        return dni_usuario;
    }
    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaLimite() {
        return fechaLimite;
    }
    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void infoPrestamo(){
        System.out.println("Fecha prestamo: " + this.fechaPrestamo);
        System.out.println("Fecha limite: " + this.fechaLimite);
        System.out.println("Fecha devolucion: " + this.fechaDevolucion);
        System.out.println("dni usuario: " + this.dni_usuario);
        System.out.println("id libro: " + this.id_libro);
        System.out.println("-----------------------------------------------------------");
    }

    // ¿El préstamo está vencido?
    public boolean estaVencido() {
        return LocalDate.now().isAfter(fechaLimite);
    }

    // ¿Ya fue devuelto?
    public boolean fueDevuelto() {
        return fechaDevolucion != null;
    }

    // ¿Cuántos días de retraso tiene?
    public long diasDeRetraso() {
        if (!estaVencido() || fueDevuelto()) {
            return 0;
        }
        return ChronoUnit.DAYS.between(fechaLimite, LocalDate.now());
    }

    // ¿Cuánto debe de multa?
    public double calcularMulta() {
        long dias = diasDeRetraso();
        return dias * 1000; // $1000 por día
    }

    public void marcarComoDevuelto() {
    this.fechaDevolucion = LocalDate.now();
    }


    
}
