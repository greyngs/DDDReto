package co.com.universidadx.permanencia.sesion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.Analitica;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class SesionFinalizada extends DomainEvent {
    private final Observacion observacion;
    private final AnaliticaId analiticaId;
    private final Resumen resumen;

    public SesionFinalizada(Observacion observacion, AnaliticaId analiticaId, Resumen resumen) {
        super("co.com.universidadx.permanencia.SesionFinalizada");
        this.observacion = observacion;
        this.analiticaId = analiticaId;
        this.resumen = resumen;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
