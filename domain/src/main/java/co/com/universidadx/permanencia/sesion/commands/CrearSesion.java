package co.com.universidadx.permanencia.sesion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.sesion.Cita;
import co.com.universidadx.permanencia.sesion.Estudiante;
import co.com.universidadx.permanencia.sesion.Practicante;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class CrearSesion extends Command {
    private final SesionId sesionId;
    private final Observacion observacion;

    public CrearSesion(SesionId sesionId, Observacion observacion) {
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
