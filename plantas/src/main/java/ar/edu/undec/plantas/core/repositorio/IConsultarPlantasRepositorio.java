package ar.edu.undec.plantas.core.repositorio;

import ar.edu.undec.plantas.core.dominio.Planta;

import java.util.List;

public interface IConsultarPlantasRepositorio {
    List<Planta> obtenerPlantas();
}
