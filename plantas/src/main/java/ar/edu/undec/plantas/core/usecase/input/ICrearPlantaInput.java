package ar.edu.undec.plantas.core.usecase.input;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.CategoriaNuloException;
import ar.edu.undec.plantas.core.exception.NombreCientificoNuloException;
import ar.edu.undec.plantas.core.exception.NombreVulgarNuloException;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;

public interface ICrearPlantaInput {
    boolean crearPlanta(Planta planta) throws PlantaExisteException, NombreCientificoNuloException, CategoriaNuloException, NombreVulgarNuloException;
}