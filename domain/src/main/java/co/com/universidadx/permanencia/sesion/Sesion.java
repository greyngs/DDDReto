package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.generic.values.EstadoT;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;
import co.com.universidadx.permanencia.sesion.values.EstudianteId;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

import java.util.List;

public class Sesion extends AggregateEvent<SesionId> {
    protected Estudiante estudiante;
    protected Practicante practicante;
    protected Cita cita;
    protected EstadoT estadoT;
    protected Observacion observacion;

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

    public void finalizarLaSesion(Observacion observacion) {
        appendChange(new SesionFinalizada(observacion)).apply();
    }


}
