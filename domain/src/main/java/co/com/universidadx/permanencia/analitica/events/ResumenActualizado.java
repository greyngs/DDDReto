package co.com.universidadx.permanencia.analitica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.Resumen;

public class ResumenActualizado extends DomainEvent {
    private final Resumen resumen;

    public ResumenActualizado(Resumen resumen) {
        super("co.com.universidadx.permanencia.ResumenActualizado");
        this.resumen = resumen;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
