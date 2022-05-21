package co.com.universidadx.permanencia.contenido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.contenido.commands.AgregarEjercicio;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;
import co.com.universidadx.permanencia.contenido.events.EjercicioCreado;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Descripcion;
import co.com.universidadx.permanencia.contenido.values.Guia;
import co.com.universidadx.permanencia.contenido.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarEjercicioUseCaseTest {
    @InjectMocks
    private AgregarEjercicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnEjercicioHappyPass(){
        //arrange
        var ejercicioId = ContenidoId.of("ddddd");
        var nombre = new Nombre("JJJ");
        var descripcion = new Descripcion("LLL");
        var command = new AgregarEjercicio( ejercicioId,  nombre,  descripcion);

        when(repository.getEventsBy("ddddd")).thenReturn(history());
        useCase.addRepository(repository);
        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getContenidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EjercicioCreado)events.get(0);
        Assertions.assertEquals("JJJ", event.getNombre().value());

    }

    private List<DomainEvent> history() {
        var guia = new Guia("DDD");
        var event = new ContenidoCreado(guia);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }

}
