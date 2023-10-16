package Apartado2;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class Ordenador {
    private String ruta1;
    private String ruta2;

    private List<String> contenido1;
    private List<String> contenido2;
    private List<String> contenidoOrdenado;

    public Ordenador(String ruta1, String ruta2) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
    }

    public List<String> getContenidoOrdenado() {
        leerArchivos();
        contenidoOrdenado.addAll(contenido1);
        contenidoOrdenado.addAll(contenido2);
        Collections.sort(contenidoOrdenado);
        return contenidoOrdenado;
    }

    public void leerArchivos(){
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta1))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido1.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader lector = new BufferedReader(new FileReader(ruta2))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido2.add(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escribirArchivo(String ruta){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
            for (String linea : contenidoOrdenado) {
                escritor.write(linea);
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}