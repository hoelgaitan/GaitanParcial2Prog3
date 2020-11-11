package ar.edu.undec.plantas.controller.controller;

import ar.edu.undec.plantas.controller.dto.PlantaDTO;
import ar.edu.undec.plantas.controller.dto.Response;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CrearPlantaController {
    private ICrearPlantaInput crearPlantaInput;

    public CrearPlantaController(ICrearPlantaInput crearPlantaInput) {
        this.crearPlantaInput = crearPlantaInput;
    }

    public ResponseEntity crearPlanta(PlantaDTO laPlantaDTO) {
        Planta planta = new Planta();
        planta.setNombreCientifico(laPlantaDTO.getNombreCientifico());
        planta.setNombreVulgar(laPlantaDTO.getNombreVulgar());
        planta.setCategoria(laPlantaDTO.getCategoria());
        planta.setEpocaPlantado(laPlantaDTO.getEpocaPlnatado());
        planta.setAlturaMaxima(laPlantaDTO.getAlturaMaxima());
        try {
            boolean result = crearPlantaInput.crearPlanta(planta);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (PlantaExisteException e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }

    }



}
