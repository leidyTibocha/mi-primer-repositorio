package modelo;
import java.io.Serializable;

public class Libro implements Serializable {
 
     private  String id_libro; //identificador unico (cada copia tiene identificador unico)
     private String id_isbn; //identificador unico para una obra(ejemplo (coraline))
     private String titulo;
     private String nombreAutor;
     private String apellidoAutor;
     private int anioPublicacion;
     private Generos genero;
     
    public Libro(String id_libro, String id_isbn, String titulo, String nombreAutor, String apellidoAutor,
               int anioPublicacion, Generos genero) {
          this.id_libro = id_libro;
          this.id_isbn = id_isbn;
          this.titulo = titulo;
          this.nombreAutor = nombreAutor;
          this.apellidoAutor = apellidoAutor;
          this.anioPublicacion = anioPublicacion;
          this.genero = genero;
     }

     public String getId_libro() {
          return id_libro;
     }
     public void setId_libro(String id_libro) {
          this.id_libro = id_libro;
     }
     public String getId_isbn() {
          return id_isbn;
     }
     public void setId_isbn(String id_isbn) {
          this.id_isbn = id_isbn;
     }
     public String getTitulo() {
          return titulo;
     }
     public void setTitulo(String titulo) {
          this.titulo = titulo;
     }
     public String getNombreAutor() {
          return nombreAutor;
     }
     public void setNombreAutor(String nombreAutor) {
          this.nombreAutor = nombreAutor;
     }
     public String getApellidoAutor() {
          return apellidoAutor;
     }
     public void setApellidoAutor(String apellidoAutor) {
          this.apellidoAutor = apellidoAutor;
     }
     public int getAñoPublicacion() {
          return anioPublicacion;
     }
     public void setAñoPublicacion(int anioPublicacion) {
          this.anioPublicacion = anioPublicacion;
     }
     public Generos getGenero() {
          return genero;
     }
     public void setGenero(Generos genero) {
          this.genero = genero;
     }

     
     public void mostrarInfoLibro(){
          System.out.println("id libro: " + this.id_libro);
          System.out.println("Titulo: " + this.titulo);
           System.out.println("Autor: " + this.nombreAutor + " " + this.apellidoAutor);
          System.out.println("Año de publicacion: " + this.anioPublicacion);
          System.out.println("Genero: " + genero.toString());
     }

     public void mostrarInfoLibroCompleta(){
          System.out.println("id libro: " + this.id_libro);
          System.out.println("id obra: " + this.id_isbn);
          System.out.println("Titulo: " + this.titulo);
          System.out.println("nombres y apellidos del autor: " + this.nombreAutor + " " + this.apellidoAutor);
          System.out.println("Año de publicacion: " + this.anioPublicacion);
          System.out.println("Genero: " + genero.toString());
     }

     public void mostrarGeneroLibroInfo(){
          System.out.println("Titulo: " + this.titulo);
          System.out.println("Autor: " + this.nombreAutor + " " + this.apellidoAutor);
          System.out.println("Año de publicacion: " + this.anioPublicacion);
          System.out.println("Genero: " + genero.toString());
     }
}
