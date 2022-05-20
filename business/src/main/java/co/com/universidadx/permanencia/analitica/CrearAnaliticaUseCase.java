package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.analitica.commands.CrearAnalitica;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.contenido.Contenido;
import co.com.universidadx.permanencia.contenido.commands.CrearContenido;

public class CrearAnaliticaUseCase extends UseCase<RequestCommand<CrearAnalitica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAnalitica> crearAnaliticaRequestCommand) {
        var command = crearAnaliticaRequestCommand.getCommand();
        var Analitica = new Analitica(command.getAnaliticaId(), command.getResumen());

        emit().onResponse(new ResponseEvents(Analitica.getUncommittedChanges()));
    }
}
