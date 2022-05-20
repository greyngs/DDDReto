package co.com.universidadx.permanencia.contenido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.contenido.commands.CrearContenido;

public class CrearContenidoUseCase extends UseCase<RequestCommand<CrearContenido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearContenido> crearContenidoRequestCommand) {
        var command = crearContenidoRequestCommand.getCommand();
        var Contenido = new Contenido(command.getContenidoId(), command.getGuia());

        emit().onResponse(new ResponseEvents(Contenido.getUncommittedChanges()));
    }
}
