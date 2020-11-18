package ar.edu.undec.plantas.persistencia.entity;

import javax.persistence.*;

@Entity(name="plantas")
@SequenceGenerator(name="plantas_id_seq", initialValue = 1, sequenceName = "plantas_id_seq",allocationSize = 1)


public class PlantaEntity {

        @Id
        @Column(name= "idplanta")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planta_id_seq")

        private Integer id;
        @Column(name = "nombreCientifico")
        private String nombrecientifico;

        @Column(name = "nombreVulgar")
        private String nombrevulgar;

        @Column(name = "categoria")
        private String categoria;

        @Column(name = "epocaPlantado")
        private String epocaplantado;

        @Column(name = " alturaMaxima")
        private Integer alturamaxima;

    public PlantaEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecientifico() {
        return nombrecientifico;
    }

    public void setNombrecientifico(String nombrecientifico) {
        this.nombrecientifico = nombrecientifico;
    }

    public String getNombrevulgar() {
        return nombrevulgar;
    }

    public void setNombrevulgar(String nombrevulgar) {
        this.nombrevulgar = nombrevulgar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEpocaplantado() {
        return epocaplantado;
    }

    public void setEpocaplantado(String epocaplantado) {
        this.epocaplantado = epocaplantado;
    }

    public Integer getAlturamaxima() {
        return alturamaxima;
    }

    public void setAlturamaxima(Integer alturamaxima) {
        this.alturamaxima = alturamaxima;
    }


}
