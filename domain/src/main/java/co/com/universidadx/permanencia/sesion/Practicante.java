package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.generic.values.Nombre;
import co.com.universidadx.permanencia.sesion.values.PracticanteId;
import co.com.universidadx.permanencia.sesion.values.Telefono;

public class Practicante extends Entity<PracticanteId> {
    protected Nombre nombre;
    protected Telefono telefono;

    public Practicante(PracticanteId entityId, Nombre nombre, Telefono telefono) {
        super(entityId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarTelefono(Telefono telefono) {
        this.telefono = telefono;
    }
}
