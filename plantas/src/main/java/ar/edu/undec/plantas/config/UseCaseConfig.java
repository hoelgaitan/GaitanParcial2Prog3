package ar.edu.undec.plantas.config;
import ar.edu.undec.plantas.core.usecase.CrearPlantaUseCase;
import ar.edu.undec.plantas.persistencia.CrearPlantaRepoImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Autowired
    CrearPlantaRepoImplementacion crearPlantaRepoImplementacion;

    @Bean
    public CrearPlantaUseCase crearPlantaUseCase() {
        return new CrearPlantaUseCase(crearPlantaRepoImplementacion);
    }
}
