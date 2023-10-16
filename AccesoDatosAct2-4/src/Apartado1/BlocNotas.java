package Apartado1;

import java.io.*;
import java.util.Scanner;

public class BlocNotas {
    private boolean sobreEscribir;
    private String ruta;
    private int numLineas;
    public BlocNotas(String ruta, boolean sobreEscribir) {
        this.sobreEscribir = sobreEscribir;
        this.ruta = ruta;
        numLineas = 0;
    }

    public boolean EscribirNotas(String contenido) {
        if (!contenido.equals("SALIR")) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta, sobreEscribir))) {
                escritor.write(contenido);
                escritor.newLine();
                numLineas++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sobreEscribir = true;
            return true;
        }
        return false;
    }

}

