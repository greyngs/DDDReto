package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.commands.AgregarPlan;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.PlanCreado;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Estrategia;
import co.com.universidadx.permanencia.analitica.values.Meta;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarPlanUseCaseTest {

    @InjectMocks
    private AgregarPlanUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnPlanHappyPass(){
        //arrange
        var analiticaId = AnaliticaId.of("ddddd");
        var meta = new Meta("JJJ");
        var estrategia = new Estrategia("LLL");
        var command = new AgregarPlan( analiticaId,  meta,  estrategia);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getAnaliticaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (PlanCreado)events.get(0);
        Assertions.assertEquals("JJJ", event.getMeta().value());

    }

    private List<DomainEvent> history() {
        var resumen = new Resumen("DDD");
        var event = new AnaliticaCreada(
                resumen);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
