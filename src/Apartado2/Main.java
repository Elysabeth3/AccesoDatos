package Apartado2;

import Apartado2.Detector;

import java.io.File;
public class Main {
    public static void main(String[] args) {
        String ruta;
        ruta = "LogoAcceso.png";
        File archivo = new File(ruta);

        if (archivo.exists()){
            System.out.println("El archivo exsiste correctamente");
            System.out.println("Su formato es: ");
            Detector detectarFormato = new Detector(ruta);
            System.out.println(detectarFormato.detectarFormato());
        } else {
            System.out.println("El archivo no exsiste");
        }

    }
}