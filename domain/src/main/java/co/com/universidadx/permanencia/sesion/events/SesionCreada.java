package co.com.universidadx.permanencia.sesion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.sesion.Cita;
import co.com.universidadx.permanencia.sesion.Estudiante;
import co.com.universidadx.permanencia.sesion.Practicante;
import co.com.universidadx.permanencia.sesion.values.Observacion;

import java.util.UUID;

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
