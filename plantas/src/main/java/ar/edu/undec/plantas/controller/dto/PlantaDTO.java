package ar.edu.undec.plantas.controller.dto;

import ar.edu.undec.plantas.core.exception.PlantaExisteException;

public class PlantaDTO {
    private String nombreCientifico;
    private String nombreVulgar;
    private String categoria;
    private String epocaPlnatado;
    private int alturaMaxima;

    public PlantaDTO(String nombreCientifico, String nombreVulgar, String categoria, String epocaPlnatado, int alturaMaxima) throws PlantaExisteException {
       if(validar(nombreCientifico,nombreVulgar,categoria)){
           this.nombreCientifico = nombreCientifico;
           this.nombreVulgar = nombreVulgar;
           this.categoria = categoria;
           this.epocaPlnatado = epocaPlnatado;
           this.alturaMaxima = alturaMaxima;
       }

    }

    private boolean validar(String nombreCientifico, String nombreVulgar, String categoria) throws PlantaExisteException {
        if(nombreCientifico == null)
            throw new PlantaExisteException("La planta ya existe");
        if(nombreVulgar == null)
            throw new PlantaExisteException("La planta ya existe");
        if(categoria == null)
            throw new PlantaExisteException("La planta ya existe");

        return true;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
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

    public String getEpocaPlnatado() {
        return epocaPlnatado;
    }

    public void setEpocaPlnatado(String epocaPlnatado) {
        this.epocaPlnatado = epocaPlnatado;
    }

    public int getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(int alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }
}
