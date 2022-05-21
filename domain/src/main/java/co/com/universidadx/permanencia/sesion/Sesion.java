package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.generic.values.EstadoT;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

import java.util.List;

public class Sesion extends AggregateEvent<SesionId> {
    protected Estudiante estudiante;
    protected Practicante practicante;
    protected Cita cita;
    protected EstadoT estadoT;
    protected Observacion observacion;
    protected AnaliticaId analiticaId;
    protected Resumen resumen;

    public Sesion(SesionId entityId, Observacion observacion) {
        super(entityId);
        appendChange(new SesionCreada(observacion)).apply();
        subscribe(new SesionEventChangue(this));
    }

    public Sesion(SesionId entityId) {
        super(entityId);
        subscribe(new SesionEventChangue(this));
    }

    public static Sesion from(SesionId entityId, List<DomainEvent> events){
        var sesion = new Sesion(entityId);
        events.forEach(sesion::applyEvent);
        return sesion;
    }

    public void finalizarLaSesion(Observacion observacion, Resumen resumen) {
        appendChange(new SesionFinalizada(observacion, analiticaId, resumen)).apply();
    }

}
