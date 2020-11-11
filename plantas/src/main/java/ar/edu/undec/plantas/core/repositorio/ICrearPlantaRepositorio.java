package ar.edu.undec.plantas.core.repositorio;

import ar.edu.undec.plantas.core.dominio.Planta;

public interface ICrearPlantaRepositorio {
    boolean existePlanta(String nombreCientifico);

    boolean guardarPlanta(Planta laPlanta);
}
