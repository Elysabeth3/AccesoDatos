package Apartado3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo a mostrar: ");
        String nombreArchivo = scanner.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contadorLineas = 0;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                contadorLineas++;

                if (contadorLineas % 23 == 0) {
                    System.out.print("Presione la barra espaciadora para continuar...");
                    char tecla = (char) System.in.read();
                    if (tecla != ' ' && tecla != '\n') {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
