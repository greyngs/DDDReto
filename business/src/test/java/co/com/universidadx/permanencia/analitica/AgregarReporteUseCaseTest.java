package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.commands.AgregarReporte;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.ReporteCreado;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.ReporteId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.generic.values.Fecha;
import co.com.universidadx.permanencia.sesion.values.SesionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarReporteUseCaseTest {
    @InjectMocks
    private AgregarReporteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnReporteHappyPass(){
        //arrange
        var analiticaId = AnaliticaId.of("yyyyy");
        var fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        var command = new AgregarReporte(analiticaId, fecha);

        when(repository.getEventsBy("yyyyy")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAnaliticaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        System.out.println("Si pasa esto, soy feliz");
        //assert
        var event = (ReporteCreado)events.get(0);
        Assertions.assertEquals(LocalDate.of(2022, 05, 20), event.getFecha().value().dia()); //analiticaCreada.aggregateRootId()
    }

    private List<DomainEvent> history() {
        var resumen = new Resumen("Los estudiantes reportan mejoria en sus notas");
        var sesionId = SesionId.of("xxxxx");
        var contenidoId = ContenidoId.of("zzzzz");
        var event = new AnaliticaCreada(
                resumen,
                sesionId,
                contenidoId);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
