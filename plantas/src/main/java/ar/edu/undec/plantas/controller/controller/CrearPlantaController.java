package ar.edu.undec.plantas.controller.controller;

import ar.edu.undec.plantas.controller.dto.PlantaDTO;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.CategoriaNuloException;
import ar.edu.undec.plantas.core.exception.NombreCientificoNuloException;
import ar.edu.undec.plantas.core.exception.NombreVulgarNuloException;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/plantacion")
@CrossOrigin(origins = "*")
public class CrearPlantaController {

    @Autowired
    ICrearPlantaInput crearPlantaInput;


    public CrearPlantaController(ICrearPlantaInput crearPlantaInput) {
        this.crearPlantaInput = crearPlantaInput;
    }


    @PostMapping("/plantas")
    public ResponseEntity<?> crearPlanta(@RequestBody PlantaDTO laPlantaDTO) {
        Planta planta= new Planta();
        planta.setAlturaMaxima(laPlantaDTO.getAlturaMaxima());
        planta.setEpocaPlantado(laPlantaDTO.getEpocaPlnatado());
        planta.setCategoria(laPlantaDTO.getCategoria());
        planta.setNombreVulgar(laPlantaDTO.getNombreVulgar());
        planta.setNombreCientifico(laPlantaDTO.getNombreCientifico());

        try {

            return ResponseEntity.status(HttpStatus.OK).body(crearPlantaInput.crearPlanta(planta));
        } catch (PlantaExisteException existePlanta) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existePlanta.getMessage());
        }
        catch (NombreCientificoNuloException nombreCientificoNull) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(nombreCientificoNull.getMessage());
        }
        catch (NombreVulgarNuloException nombreVulgarNull) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(nombreVulgarNull.getMessage());
        }
        catch (CategoriaNuloException categoriaNull) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(categoriaNull.getMessage());
        }
        catch (Exception error500){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error500.getMessage());
        }

    }
}


