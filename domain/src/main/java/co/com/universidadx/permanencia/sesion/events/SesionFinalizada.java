package co.com.universidadx.permanencia.sesion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.sesion.values.Observacion;

public class SesionFinalizada extends DomainEvent {
    private final Observacion observacion;

    public SesionFinalizada(Observacion observacion) {
        super("co.com.universidadx.permanencia.SesionFinalizada");
        this.observacion = observacion;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
