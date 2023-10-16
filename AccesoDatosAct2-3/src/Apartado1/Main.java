package Apartado1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileInputStream fIn = new FileInputStream("entrada.dat");
             FileOutputStream fOut = new FileOutputStream("salida.dat")) {
            byte[] buffer = new byte[128];
            int bytesRead;

            while ((bytesRead = fIn.read(buffer)) != -1) {
                fOut.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("Error de E/S: " + ex.getLocalizedMessage());
        }
    }
}
