package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.ContenidoAgregadoAReporte;
import co.com.universidadx.permanencia.analitica.events.PlanCreado;
import co.com.universidadx.permanencia.analitica.events.ReporteCreado;
import co.com.universidadx.permanencia.analitica.values.PlanId;

public class AnaliticaEventChange extends EventChange {
    public AnaliticaEventChange(Analitica analitica) {
        apply((AnaliticaCreada event) ->{
            analitica.resumen = event.getResumen();
        });

        apply((PlanCreado event) -> {
            var planId = event.getPlanId();
            var plan = new Plan(planId, event.getMeta(), event.getEstrategia());
            analitica.planes.put(planId, plan);
        });

        apply((ReporteCreado event) -> {
            var reporteId = event.getReporteId();
            var reporte = new Reporte(reporteId, event.getFecha());
            analitica.reportes.put(reporteId, reporte);
        });

        apply((ContenidoAgregadoAReporte event) -> {
            analitica.reportes.get(event.getReporteId()).agregarContenido(event.getContenido());
        });
    }
}
