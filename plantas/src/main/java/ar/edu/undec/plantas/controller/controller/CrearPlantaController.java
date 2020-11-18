package ar.edu.undec.plantas.controller.controller;

import ar.edu.undec.plantas.controller.dto.PlantaDTO;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/plantacion")
@CrossOrigin(origins = "*")
public class CrearPlantaController {

    @Autowired
    ICrearPlantaInput crearPlantaInput;


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

            return ResponseEntity.status(HttpStatus.OK).body( e.getMessage());
        }

    }



}


/*
@Autowired
    ICrearPlantaInpunt creaPlantaInput;

    public CrearPlantaController(ICrearPlantaInpunt crearPlantaInput) {
        this.creaPlantaInput=crearPlantaInput;
    }

    @PostMapping("/plantas")
    public ResponseEntity<?> crearPlanta(@RequestBody PlantaDTO laPlantaDTO) {
        Planta planta= Planta.PlantaDTOtoPlanta(laPlantaDTO);
        try {
            //boolean resultado = creaPlantaInput.crearPlanta(planta);
            return ResponseEntity.status(HttpStatus.OK).body(creaPlantaInput.crearPlanta(planta));
        } catch (PlantaExisteException existePlanta) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existePlanta.getMessage());
        }catch (NombreCientificoNuloException nombreCientificoNulo) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(nombreCientificoNulo.getMessage());
        }catch (NombreVulgarNuloException nombreVulgarNulo) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(nombreVulgarNulo.getMessage());
        }catch (CategoriaNuloException categoriaNulo) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(categoriaNulo.getMessage());
        }

    }
* */
