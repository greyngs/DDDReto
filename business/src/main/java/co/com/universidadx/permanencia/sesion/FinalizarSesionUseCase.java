package co.com.universidadx.permanencia.sesion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.sesion.commands.FinalizarSesion;
import co.com.universidadx.permanencia.sesion.services.ConsultarObersavionDeSesion;
import co.com.universidadx.permanencia.sesion.services.ConsultarResumenDeSesion;

public class FinalizarSesionUseCase extends UseCase<RequestCommand<FinalizarSesion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<FinalizarSesion> finalizarSesionRequestCommand) {
        var command = finalizarSesionRequestCommand.getCommand();
        var observacionService = getService(ConsultarObersavionDeSesion.class).orElseThrow();
        var resumenService = getService(ConsultarResumenDeSesion.class).orElseThrow();
        var sesion = Sesion.from(
                command.getSesionId(), repository().getEventsBy(command.getSesionId().value())
        );

        sesion.finalizarLaSesion(observacionService.consultarPorSesionId(command.getSesionId()), resumenService.consultarPorSesionId(command.getSesionId()));

        emit().onResponse(new ResponseEvents(sesion.getUncommittedChanges()));
    }
}
