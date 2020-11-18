package ar.edu.undec.plantas.controllerUnitTest;

import ar.edu.undec.plantas.controller.controller.CrearPlantaController;
import ar.edu.undec.plantas.controller.dto.PlantaDTO;
import ar.edu.undec.plantas.core.dominio.Planta;
import ar.edu.undec.plantas.core.exception.CampoNuloException;
import ar.edu.undec.plantas.core.exception.PlantaExisteException;
import ar.edu.undec.plantas.core.usecase.input.ICrearPlantaInput;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CrearPlantaControllerUnitTest {

    @Mock
    private ICrearPlantaInput crearPlantaInput;


        @Test
        public void crearPlanta_PlantaNoExiste_Devuelve200() throws PlantaExisteException, CampoNuloException {
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        when(crearPlantaInput.crearPlanta(any(Planta.class))).thenReturn(true);

        CrearPlantaController crearPlantaController = new CrearPlantaController(crearPlantaInput);
        ResponseEntity responseEntity = crearPlantaController.crearPlanta(laPlantaDTO);
        boolean resultado = (boolean) responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertTrue(resultado);
    }


   /*
    //palacios
    @Test
    public void crearJugador_JugadorExisteException_Devuelve412() throws PlantaExisteException {
        //Completar Test
        //JugadorDTO elJugador=new JugadorDTO("Lionel Messi",LocalDate.of(1987,6,24),"10",1.7,80.5,"Izquierdo");
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);

       //CrearJugadorController crearJugadorController= new CrearJugadorController(crearJugadorInput);
        CrearPlantaController crearPlantaController= new CrearPlantaController(crearPlantaInput);

      //  when(crearJugadorInput.crearJugador(any(Jugador.class))).thenThrow(JugadorExisteException.class);
        when(crearPlantaInput.crearPlanta(any(Planta.class))).thenThrow(PlantaExisteException.class);

        //ResponseEntity responseEntity=crearJugadorController.crearJugador(elJugador);
         ResponseEntity responseEntity=crearPlantaController.crearPlanta(laPlantaDTO);

         boolean resultado = (boolean) responseEntity.getBody();

        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

    */
/*
    @Test
    public void crearPlanta_PlantaExisteException_Devuelve412() throws PlantaExisteException {
        //Completar Test
        PlantaDTO laPlantaDTO=new PlantaDTO("Erythrina crista-galli","Ceibo","Faboideae","Primavera",10);
        when(crearPlantaInput.crearPlanta(any(Planta.class))).thenThrow(PlantaExisteException.class);
        ResponseEntity responseEntity=null;


        Assertions.assertEquals(HttpStatus.PRECONDITION_FAILED, responseEntity.getStatusCode());
    }

    @Test
    public void crearPlanta_ExcepcionNoPrevista_Devuelve500() throws PlantaExisteException {
        //Completar Test

    }

 */



}
