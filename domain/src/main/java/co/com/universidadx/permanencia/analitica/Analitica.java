package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.events.*;
import co.com.universidadx.permanencia.analitica.values.*;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.generic.values.Fecha;
import co.com.universidadx.permanencia.sesion.values.SesionId;

import java.util.List;
import java.util.Map;

public class Analitica extends AggregateEvent<AnaliticaId> {
    protected Analista analista;
    protected Map<ReporteId, Reporte> reportes;
    protected Map<PlanId, Plan> planes;
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

    public void actualizarResumen(Resumen resumen) {
        appendChange(new ResumenActualizado(resumen)).apply();
    }

    public void agregarPlan(Meta meta, Estrategia estrategia){
        var planId = new PlanId();
        appendChange(new PlanCreado(planId, meta, estrategia)).apply();
    }

    public void agregarReporte(Fecha fecha){
        var reporteId = new ReporteId();
        appendChange(new ReporteCreado(reporteId, fecha)).apply();
    }

    public void agregarContenidoDeReporte(ReporteId reporteId, Contenido contenido){
        appendChange(new ContenidoAgregadoAReporte(reporteId, contenido)).apply();
    }

    public Map<ReporteId, Reporte> reportes(){
        return reportes;
    }
}
