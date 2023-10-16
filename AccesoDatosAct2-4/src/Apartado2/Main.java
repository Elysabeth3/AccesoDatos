package Apartado2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivo1Nombre;
        String archivo2Nombre;
        String archivoDestinoNombre;


        System.out.print("Ingrese el nombre del primer archivo ordenado: ");
        archivo1Nombre = scanner.nextLine();

        System.out.print("Ingrese el nombre del segundo archivo ordenado: ");
        archivo2Nombre = scanner.nextLine();

        System.out.print("Ingrese el nombre del archivo de destino (ordenado.txt): ");
        archivoDestinoNombre = scanner.nextLine();

        Ordenador ordenador1 = new Ordenador(archivo1Nombre,archivo2Nombre);

        ordenador1.escribirArchivo(archivoDestinoNombre);

    }
}
