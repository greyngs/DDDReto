package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.analitica.commands.AgregarContenido;

public class AgregarContenidoUseCase extends UseCase<RequestCommand<AgregarContenido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarContenido> agregarContenidoRequestCommand) {
        var command = agregarContenidoRequestCommand.getCommand();
        var analitica = Analitica.from(
                command.getAnaliticaId(), repository().getEventsBy(command.getAnaliticaId().value())
        );

        if (analitica.reportes().get(command.getReporteId()).contenidos().size() >= 3) {
            throw new BusinessException(
                    command.getAnaliticaId().value(),
                    "No puede tener mas de 4 contenidos"
            );
        }

        ContenidosFactory factory = ContenidosFactory.builder()
                .agregarContenido(command.getContenido());
        //analitica.agregarContenidoDeReporte(command.getReporteId(), factory);
        //agregarDirectricesDeMentoria(command.getMentoriaId(), factory);

        emit().onResponse(new ResponseEvents(analitica.getUncommittedChanges()));
    }
}
