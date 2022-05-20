package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;

public class Analitica extends AggregateEvent<AnaliticaId> {
    protected Analista analista;
    protected Reporte reporte;
    protected Plan plan;
    protected Resumen resumen;

    public Analitica(AnaliticaId entityId, Resumen resumen) {
        super(entityId);
        appendChange(new AnaliticaCreada(resumen)).apply();
        subscribe(new AnaliticaEventChange(this));
    }

    public Analitica(AnaliticaId entityId) {
        super(entityId);
        subscribe(new AnaliticaEventChange(this));
    }
}
