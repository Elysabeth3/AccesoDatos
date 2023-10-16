package Apartado3;

import java.io.FileInputStream;
import java.io.IOException;

public class DetectorCabecerasBMP{
        public static ArchivoBMP detectorCabecerasBMP(String filePath) {
            try (FileInputStream input = new FileInputStream(filePath)) {
                input.skip(18);

                int ancho = readLittleEndianInt(input);
                int alto = readLittleEndianInt(input);

                input.skip(2);

                int compresion = readLittleEndianInt(input);

                return new ArchivoBMP((int) input.getChannel().size(), ancho, alto, compresion);
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
                return null;
            }
        }

        private static int readLittleEndianInt(FileInputStream input) throws IOException {
            byte[] buffer = new byte[4];
            input.read(buffer);
            return (buffer[0] & 0xFF) | ((buffer[1] & 0xFF) << 8) | ((buffer[2] & 0xFF) << 16) | ((buffer[3] & 0xFF) << 24);
        }
}
