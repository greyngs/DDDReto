package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.analitica.commands.AgregarReporte;

public class AgregarReporteUseCase extends UseCase<RequestCommand<AgregarReporte>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReporte> agregarReporteRequestCommand) {
        var command = agregarReporteRequestCommand.getCommand();
        var analitica = Analitica.from(
                command.getAnaliticaId(), repository().getEventsBy(command.getAnaliticaId().value())
        );
        analitica.agregarReporte(command.getFecha());
        emit().onResponse(new ResponseEvents(analitica.getUncommittedChanges()));
    }
}
