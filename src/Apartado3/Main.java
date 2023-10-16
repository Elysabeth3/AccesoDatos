package Apartado3;

import Apartado2.Detector;

public class Main {
    public static void main(String[] args) {
        String ruta = "LogoAcceso.bmp";

        Detector detector = new Detector(ruta);

        if (detector.detectarFormato().equalsIgnoreCase("BMP")){
            ArchivoBMP archivoBMP = DetectorCabecerasBMP.detectorCabecerasBMP(ruta);

            if (archivoBMP != null) {
                System.out.println("Tamaño: " + archivoBMP.getTamanyo() + " bytes");
                System.out.println("Ancho: " + archivoBMP.getAncho() + " pixels");
                System.out.println("Alto: " + archivoBMP.getAlto() + " pixels");
                System.out.println("Compresion: " + archivoBMP.getCompresion());
            }
        } else {
            System.out.println("El archivo no es un archivo BMP");
        }

    }
}