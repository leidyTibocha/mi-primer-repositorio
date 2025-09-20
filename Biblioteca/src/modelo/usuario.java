package modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    public String nombres;
    public String apellidos;
    protected String dni;
    protected String correo_electronico;
    protected LocalDate fechaIncripcion;
    protected ArrayList <Prestamo> historialPrestamos;


    public Usuario(String nombres, String apellidos, String dni, String correo_electronico, LocalDate fechaIncripcion, ArrayList<Prestamo> historialPrestamos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.correo_electronico = correo_electronico;
        this.fechaIncripcion = fechaIncripcion;
        this.historialPrestamos = historialPrestamos;
    }

      public void mostrarHistorialPrestamos(){
        for(Prestamo p: historialPrestamos){
            p.infoPrestamo();
        }
    }
      public void cantidadPrestamos(){
        System.out.println("Cantidad de prestamos: " + historialPrestamos.size());
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    public LocalDate getFechaIncripcion() {
        return fechaIncripcion;
    }
    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaIncripcion = fechaIncripcion;
    }

    public void mostrarInfoUsuario(){
        System.out.println("Nombre y apellidos " + this.nombres + " " + this.apellidos);
        System.out.println("DNI: " + this.dni);
        System.out.println("Correo electronico: " + this.correo_electronico);
        System.out.println("Fecha de inscripcion: " + this.fechaIncripcion);
    }

}
