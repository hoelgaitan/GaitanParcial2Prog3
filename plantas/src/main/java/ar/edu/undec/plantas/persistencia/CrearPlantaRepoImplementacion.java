package ar.edu.undec.plantas.persistencia;

import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.repositorio.ICrearPlantaRepositorio;
import ar.edu.undec.plantas.persistencia.CRUD.ICrearPlantaCRUD;
import ar.edu.undec.plantas.persistencia.entity.PlantaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrearPlantaRepoImplementacion implements ICrearPlantaRepositorio {

    @Autowired
    ICrearPlantaCRUD crearPlantaCRUD;

    @Override
    public boolean existePlanta(String nombreCientifico) {
        return false;
    }

    @Override
    public boolean guardarPlanta(Planta laPlanta) {
        if (!existePlanta(laPlanta.getNombreCientifico())) {
            PlantaEntity plantaEntity = new PlantaEntity();

            plantaEntity.setAlturamaxima(laPlanta.getAlturaMaxima());
            plantaEntity.setCategoria(laPlanta.getCategoria());
            plantaEntity.setEpocaplantado(laPlanta.getEpocaPlantado());
            plantaEntity.setNombrecientifico(laPlanta.getNombreCientifico());
            plantaEntity.setNombrevulgar(laPlanta.getNombreVulgar());

            this.crearPlantaCRUD.save(plantaEntity);
            return plantaEntity.getId() != null;
        } else {
            return false;
        }
    }
}
