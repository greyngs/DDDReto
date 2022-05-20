package co.com.universidadx.permanencia.sesion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.sesion.commands.CrearSesion;

public class CrearSesionUseCase extends UseCase<RequestCommand<CrearSesion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSesion> crearSesionRequestCommand) {
        var command = crearSesionRequestCommand.getCommand();
        var Sesion = new Sesion(command.getSesionId(), command.getObservacion());

        emit().onResponse(new ResponseEvents(Sesion.getUncommittedChanges()));
    }
}
