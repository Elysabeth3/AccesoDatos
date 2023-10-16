import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del archivo a buscar: ");
        String nombreArchivo = scanner.nextLine();

        System.out.print("Ingrese la cadena a buscar: ");
        String cadenaABuscar = scanner.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.contains(cadenaABuscar)) {
                    System.out.println("Línea " + numeroLinea + ": " + linea);
                }
            }

            if (numeroLinea == 0) {
                System.out.println("El archivo está vacío.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no existe: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}