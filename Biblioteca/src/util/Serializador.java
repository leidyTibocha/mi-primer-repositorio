package util;
import java.io.*;

public class Serializador {

    // MEtodo para GUARDAR cualquier objeto
    public static void guardar(Object objeto, String nombreArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(objeto);
            System.out.println("Datos guardados en: " + nombreArchivo);
        }
    }
    
    // Método para CARGAR cualquier objeto
    public static Object cargar(String nombreArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return ois.readObject();
        }
    }

}
