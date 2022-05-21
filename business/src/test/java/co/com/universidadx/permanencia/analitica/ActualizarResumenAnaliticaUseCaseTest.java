package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.ResumenActualizado;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarResumenAnaliticaUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @InjectMocks
    private ActualizarResumenAnaliticaUseCase useCase;

    @Test
    void actualizarResumenDeAnalitica(){
        var event = new SesionFinalizada(new Observacion("JEJE"), AnaliticaId.of("ddddd"), new Resumen("JIJI"));
        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var resumenActualizado = (ResumenActualizado)events.get(0);
        Assertions.assertEquals("JEJE",resumenActualizado.getResumen().value());
    }
    private List<DomainEvent> history() {
        var resumen = new Resumen("JEJE");
        var event = new AnaliticaCreada(resumen);
        return List.of(event);
    }
}
