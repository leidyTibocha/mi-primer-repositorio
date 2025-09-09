package modelo;
import java.time.LocalDate;

public class Prestamo {
    public String id_prestamo;
    protected String dni_usuario;
    public String id_usuario;
    protected LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;

    public Prestamo(String id_prestamo, String dni_usuario, String id_usuario, LocalDate fechaPrestamo,
            LocalDate fechaLimite, LocalDate fechaDevolucion) {
        this.id_prestamo = id_prestamo;
        this.dni_usuario = dni_usuario;
        this.id_usuario = id_usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = fechaDevolucion;
    }

    
    public String getId_prestamo() {
        return id_prestamo;
    }
    public void setId_prestamo(String id_prestamo) {
        this.id_prestamo = id_prestamo;
    }
    public String getDni_usuario() {
        return dni_usuario;
    }
    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }
    public String getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    
}
