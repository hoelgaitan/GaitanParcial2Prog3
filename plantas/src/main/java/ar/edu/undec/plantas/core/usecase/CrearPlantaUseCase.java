package ar.edu.undec.plantas.core.usecase;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;

public class CrearPlantaUseCase {

    private ICrearPlantaRepositorio crearPlantaRepositorio;
    public CrearPlantaUseCase(ICrearPlantaRepositorio crearPlantaRepositorio) {
        this.crearPlantaRepositorio = crearPlantaRepositorio;
    }

    public boolean crearPlanta(Planta laPlanta) {
        if(crearPlantaRepositorio.existePlanta(laPlanta.getNombreCientifico())){
            return false;

        }else
            return crearPlantaRepositorio.guardarPlanta(laPlanta);
    }
}
