package ar.edu.undec.plantas.core.usecase;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.CategoriaNuloException;
import ar.edu.undec.plantas.core.exception.NombreCientificoNuloException;
import ar.edu.undec.plantas.core.exception.NombreVulgarNuloException;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;

public class CrearPlantaUseCase implements ICrearPlantaInput {

    private ICrearPlantaRepositorio crearPlantaRepositorio;
    public CrearPlantaUseCase(ICrearPlantaRepositorio crearPlantaRepositorio) {
        this.crearPlantaRepositorio = crearPlantaRepositorio;
    }

    public boolean crearPlanta(Planta laPlanta) throws PlantaExisteException, NombreCientificoNuloException, CategoriaNuloException, NombreVulgarNuloException {
        if (crearPlantaRepositorio.existePlanta(laPlanta.getNombreCientifico())) {
            throw new PlantaExisteException("La planta ya existe");

        } else {
            if (laPlanta.getNombreCientifico() == null) {
                throw new NombreCientificoNuloException();
            } else {
                if (laPlanta.getCategoria() == null) {
                    throw new CategoriaNuloException();
                } else {
                    if (laPlanta.getNombreVulgar() == null) {
                        throw new NombreVulgarNuloException();

                }else{
                    return crearPlantaRepositorio.guardarPlanta(laPlanta);

                }
            }
        }
        }
    }
}
