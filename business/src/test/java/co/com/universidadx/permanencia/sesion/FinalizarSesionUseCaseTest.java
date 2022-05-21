package co.com.universidadx.permanencia.sesion;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.sesion.commands.FinalizarSesion;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;
import co.com.universidadx.permanencia.sesion.services.ConsultarObersavionDeSesion;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinalizarSesionUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarObersavionDeSesion service;

    @InjectMocks
    private FinalizarSesionUseCase useCase;

    @Test
    void finalizarSesion(){
        var observacion = new Observacion("ddd");
        var command = new FinalizarSesion(SesionId.of("wwwww"), observacion);
        when(repository.getEventsBy("wwwww")).thenReturn(history());
        when(service.consultarPorSesionId(any(SesionId.class))).thenReturn(new Observacion("xxx"));
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (SesionFinalizada)events.get(0);
        Assertions.assertEquals("xxx", event.getObservacion().value());
    }

    private List<DomainEvent> history() {
        var observacion = new Observacion("ddd");
        var event = new SesionCreada(
                observacion);
        return List.of(event);
    }
}
