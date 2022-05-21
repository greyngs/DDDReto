package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;

public class ActualizarResumenAnaliticaUseCase extends UseCase<TriggeredEvent<SesionFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<SesionFinalizada> sesionFinalizadaTriggeredEvent) {
        var event = sesionFinalizadaTriggeredEvent.getDomainEvent();
        var analitica = Analitica.from(
                event.getAnaliticaId(),
                repository().getEventsBy(event.getAnaliticaId().value())
        );

        analitica.actualizarResumen(event.getResumen());

        emit().onResponse(new ResponseEvents(analitica.getUncommittedChanges()));
    }
}
