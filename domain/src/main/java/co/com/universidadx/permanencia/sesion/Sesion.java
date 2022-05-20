package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.values.EstudianteId;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class Sesion extends AggregateEvent<SesionId> {
    protected Estudiante estudiante;
    protected Practicante practicante;
    protected Cita cita;
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


}
