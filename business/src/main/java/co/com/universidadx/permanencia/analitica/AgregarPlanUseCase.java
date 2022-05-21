package co.com.universidadx.permanencia.analitica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.universidadx.permanencia.analitica.commands.AgregarPlan;

public class AgregarPlanUseCase extends UseCase<RequestCommand<AgregarPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlan> agregarPlanRequestCommand) {
        var command = agregarPlanRequestCommand.getCommand();
        var analitica = Analitica.from(
                command.getAnaliticaId(), repository().getEventsBy(command.getAnaliticaId().value())
        );
        analitica.agregarPlan(command.getMeta(), command.getEstrategia());

        emit().onResponse(new ResponseEvents(analitica.getUncommittedChanges()));

    }
}
