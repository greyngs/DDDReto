package co.com.universidadx.permanencia.sesion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class FinalizarSesion extends Command {
    private final SesionId sesionId;
    private final Observacion observacion;

    public FinalizarSesion(SesionId sesionId, Observacion observacion) {
        this.sesionId = sesionId;
        this.observacion = observacion;
    }

    public SesionId getSesionId() {
        return sesionId;
    }

    public Observacion getObservacion() {
        return observacion;
    }
}
