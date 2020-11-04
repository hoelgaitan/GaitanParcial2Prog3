package ar.edu.undec.computadoras.usecaseUnitTest;

import ar.edu.undec.computadoras.core.dominio.Computadora;
import ar.edu.undec.computadoras.core.exception.ComputadoraExisteException;
import ar.edu.undec.computadoras.core.repositorio.IComputadoraRepositorio;
import ar.edu.undec.computadoras.core.usecase.CrearComputadoraUseCase;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearComputadoraUseCaseUnitTest {

    @Mock
    IComputadoraRepositorio computadoraRepositorio;

    @Test
    public void crearComputadora_ComputadoraNoExiste_CreaComputadora() throws ComputadoraExisteException {

        Computadora laComputadora=Computadora.instancia("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");

        when(computadoraRepositorio.existeComputadora("I310401000GB16GB")).thenReturn(false);
        when(computadoraRepositorio.guardarComputadora(laComputadora)).thenReturn(true);

        CrearComputadoraUseCase crearComputadoraUseCase=new CrearComputadoraUseCase(computadoraRepositorio);
        boolean resultado=crearComputadoraUseCase.crearComputadora(laComputadora);

        Assertions.assertTrue(resultado);

    }

    @Test
    public void crearComputadora_ComputadoraExiste_ComputadoraExisteException(){

        Computadora laComputadora=Computadora.instancia("I310401000GB16GB","Core I3 1040",1000,"SSD",16,"PC");

        when(computadoraRepositorio.existeComputadora("I310401000GB16GB")).thenReturn(true);

        CrearComputadoraUseCase crearComputadoraUseCase=new CrearComputadoraUseCase(computadoraRepositorio);

        Assertions.assertThrows(ComputadoraExisteException.class, ()->crearComputadoraUseCase.crearComputadora(laComputadora));

    }


}
