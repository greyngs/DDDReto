package co.com.universidadx.permanencia.contenido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.contenido.commands.AgregarEjercicio;

public class AgregarEjercicioUseCase extends UseCase<RequestCommand<AgregarEjercicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEjercicio> agregarEjercicioRequestCommand) {
        var command = agregarEjercicioRequestCommand.getCommand();
        var contenido = Contenido.from(
                command.getContenidoId(),repository().getEventsBy(command.getContenidoId().value())
        );
        contenido.agregarEjercicio(command.getNombre(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(contenido.getUncommittedChanges()));
    }
}
