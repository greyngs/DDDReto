package co.com.universidadx.permanencia.sesion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.universidadx.permanencia.sesion.commands.CrearSesion;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearSesionUseCaseTest {
    private CrearSesionUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearSesionUseCase();
    }

    @Test
    public void crearSesionHappyPass() {
        //arrange
        var sesionId = SesionId.of("xxxxx");
        var observacion = new Observacion("El estudiante llega llorando y la oficina esta cerrada");
        var command = new CrearSesion(sesionId, observacion);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var sesionCreada = (SesionCreada)events.get(0);
        Assertions.assertEquals("xxxxx", sesionCreada.aggregateRootId());
        Assertions.assertEquals("El estudiante llega llorando y la oficina esta cerrada",
                                sesionCreada.getObservacion().value());
    }
}
