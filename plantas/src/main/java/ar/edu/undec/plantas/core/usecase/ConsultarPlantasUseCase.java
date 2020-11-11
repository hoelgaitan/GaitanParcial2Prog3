package ar.edu.undec.plantas.core.usecase;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.repositorio.IConsultarPlantasRepositorio;

import java.util.Collection;

public class ConsultarPlantasUseCase {
    private IConsultarPlantasRepositorio consultarPlantasRepositorio;
    public ConsultarPlantasUseCase(IConsultarPlantasRepositorio consultarPlantasRepositorio) {
        this.consultarPlantasRepositorio = consultarPlantasRepositorio;
    }


    public Collection<Planta> consultarPlantas() {
        return this.consultarPlantasRepositorio.obtenerPlantas();
    }
}
