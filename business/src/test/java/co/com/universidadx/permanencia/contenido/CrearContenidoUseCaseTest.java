package co.com.universidadx.permanencia.contenido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.universidadx.permanencia.contenido.commands.CrearContenido;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Guia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearContenidoUseCaseTest {
    private CrearContenidoUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearContenidoUseCase();
    }

    @Test
    public void crearContenidoHappyPass() {
        var contenidoId = ContenidoId.of("zzzzz");
        var guia = new Guia("Se debe presentar el contenido y mostrar simpatia");
        var command = new CrearContenido(contenidoId, guia);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var contenidoCreado = (ContenidoCreado)events.get(0);
        Assertions.assertEquals("zzzzz", contenidoCreado.aggregateRootId());
        Assertions.assertEquals("Se debe presentar el contenido y mostrar simpatia", contenidoCreado.getGuia().value());
    }
}
