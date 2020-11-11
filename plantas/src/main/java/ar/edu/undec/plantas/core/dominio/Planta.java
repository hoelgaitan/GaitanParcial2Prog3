package ar.edu.undec.plantas.core.dominio;

public class Planta {
   private String nombreCientifico;
   private String nombreVulgar;
   private String categoria;
   private String epocaPlantado;
   private int alturaMaxima;

    public Planta() {
    }

    public Planta(String nombreCientifico, String nombreVulgar, String categoria, String epocaPlantado, int alturaMaxima) {
        this.nombreCientifico = nombreCientifico;
        this.nombreVulgar = nombreVulgar;
        this.categoria = categoria;
        this.epocaPlantado = epocaPlantado;
        this.alturaMaxima = alturaMaxima;
    }

    public static Planta instancia(String s, String ceibo, String faboideae, String primavera, int i) {
        return new Planta(s,ceibo,faboideae,primavera,i);
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEpocaPlantado() {
        return epocaPlantado;
    }

    public void setEpocaPlantado(String epocaPlantado) {
        this.epocaPlantado = epocaPlantado;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }
}
