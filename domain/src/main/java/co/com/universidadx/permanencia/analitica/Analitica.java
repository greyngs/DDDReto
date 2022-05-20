package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.ContenidoAgregadoAReporte;
import co.com.universidadx.permanencia.analitica.events.ReporteCreado;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Contenido;
import co.com.universidadx.permanencia.analitica.values.ReporteId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.generic.values.Fecha;

import java.util.List;
import java.util.Map;

public class Analitica extends AggregateEvent<AnaliticaId> {
    protected Analista analista;
    protected Map<ReporteId, Reporte> reportes;
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

    public static Analitica from(AnaliticaId entityId, List<DomainEvent> events){
        var analitica = new Analitica(entityId);
        events.forEach(analitica::applyEvent);
        return analitica;
    }

    public void agregarReporte(Fecha fecha){
        var reporteId = new ReporteId();
        appendChange(new ReporteCreado(reporteId, fecha)).apply();
    }

    public void agregarContenidoDeReporte(ReporteId reporteId, Contenido contenido){
        appendChange(new ContenidoAgregadoAReporte(reporteId, contenido)).apply();
    }
}
