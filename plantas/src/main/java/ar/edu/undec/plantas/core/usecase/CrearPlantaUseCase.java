package ar.edu.undec.plantas.core.usecase;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;

public class CrearPlantaUseCase {

    private ICrearPlantaRepositorio crearPlantaRepositorio;
    public CrearPlantaUseCase(ICrearPlantaRepositorio crearPlantaRepositorio) {
        this.crearPlantaRepositorio = crearPlantaRepositorio;
    }

    public boolean crearPlanta(Planta laPlanta) throws PlantaExisteException {
        if(crearPlantaRepositorio.existePlanta(laPlanta.getNombreCientifico())){
            throw new PlantaExisteException("La planta ya existe");

        }else
            return crearPlantaRepositorio.guardarPlanta(laPlanta);
    }
}
