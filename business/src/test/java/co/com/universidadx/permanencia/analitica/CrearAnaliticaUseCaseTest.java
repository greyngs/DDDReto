package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.universidadx.permanencia.analitica.commands.CrearAnalitica;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.sesion.values.SesionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearAnaliticaUseCaseTest {
    private CrearAnaliticaUseCase useCase;

    @BeforeEach
    public void setup() {
        useCase = new CrearAnaliticaUseCase();
    }

    @Test
    public void crearAnaliticaHappyPass() {
        var analiticaId = AnaliticaId.of("yyyyy");
        var resumen = new Resumen("Los estudiantes reportan mejoria en sus notas");
        var sesionId = SesionId.of("xxxxx");
        var contenidoId = ContenidoId.of("zzzzz");
        var command = new CrearAnalitica(analiticaId, resumen, sesionId, contenidoId);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var analiticaCreada = (AnaliticaCreada)events.get(0);
        Assertions.assertEquals("yyyyy", analiticaCreada.aggregateRootId());
        Assertions.assertEquals("Los estudiantes reportan mejoria en sus notas", analiticaCreada.getResumen().value());
    }
}
