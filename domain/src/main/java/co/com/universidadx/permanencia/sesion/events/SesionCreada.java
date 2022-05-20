package co.com.universidadx.permanencia.sesion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.sesion.values.Observacion;

public class SesionCreada extends DomainEvent {
    private final Observacion observacion;

    public SesionCreada(Observacion observacion) {
        super("co.com.universidadx.permanencia.SesionCreada");
        this.observacion = observacion;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
