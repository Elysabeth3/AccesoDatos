package Apartado3;

public class ArchivoBMP {
    private int tamanyo;
    private int ancho;
    private int alto;
    private int compresion;

    public ArchivoBMP(int tamanyo, int ancho, int alto, int compresion) {
        this.tamanyo = tamanyo;
        this.ancho = ancho;
        this.alto = alto;
        this.compresion = compresion;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public String getCompresion() {
        if(compresion == 0){
            return "No comprimido";
        }
        if (compresion == 1){
            return "RLE-8";
        }
        if (compresion == 2){
            return "RLE-4";
        }
        return "Comprimido desconocido";
    }
}
