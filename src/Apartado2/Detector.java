package Apartado2;

import java.io.*;

public class Detector {
    private String ruta;

    public Detector(String ruta){
        this.ruta = ruta;
    }

    public String detectarFormato() {
        try (FileInputStream input = new FileInputStream(this.ruta)) {
            byte[] header = new byte[8];
            int bytesRead = input.read(header);
            if (bytesRead != 8) {
                return "Formato desconocido (archivo demasiado corto)";
            }

            String cabeceraHexadecimal = bytesAHexacecimal(header);

            if (cabeceraHexadecimal.startsWith("89504E470D0A1A0A")) {
                return "PNG";
            } else if (cabeceraHexadecimal.startsWith("FFD8FF")) {
                return "JPEG";
            } else if (cabeceraHexadecimal.startsWith("474946383961")) {
                return "GIF";
            } else if (cabeceraHexadecimal.startsWith("424D")) {
                return "BMP";
            } else if (cabeceraHexadecimal.startsWith("00000100")) {
                return "ICO";
            } else {
                return "Formato desconocido";
            }

        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
    }

    private String bytesAHexacecimal(byte[] bytes) {
        StringBuilder stringHexadecimal = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            stringHexadecimal.append(String.format("%02X", b));
        }
        return stringHexadecimal.toString();
    }
}
