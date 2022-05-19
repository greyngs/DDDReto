package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.sesion.values.CitaId;
import co.com.universidadx.permanencia.sesion.values.Fecha;

public class Cita extends Entity<CitaId> {
    protected Fecha fecha;

    public Cita(CitaId entityId, Fecha fecha) {
        super(entityId);
        this.fecha = fecha;
    }

    public void cambiarFecha(Fecha fecha) {
        this.fecha = fecha;
    }
}
