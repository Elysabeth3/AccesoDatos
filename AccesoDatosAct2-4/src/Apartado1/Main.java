package Apartado1;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sobrescribir = false;
        String oracion = "";
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();



        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            System.out.print("El archivo ya existe. ¿Desea sobrescribirlo? (S/N): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            sobrescribir = respuesta.equals("s");
        }

        BlocNotas blocDeNotas = new BlocNotas(nombreArchivo, sobrescribir);
        do {
            System.out.print("Ingrese una oración (o escriba 'salir' para terminar): ");
             oracion = scanner.nextLine();
        } while (blocDeNotas.EscribirNotas(oracion));
    }



}
