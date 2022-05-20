package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;
import co.com.universidadx.permanencia.analitica.events.ContenidoAgregadoAReporte;
import co.com.universidadx.permanencia.analitica.events.ReporteCreado;

public class AnaliticaEventChange extends EventChange {
    public AnaliticaEventChange(Analitica analitica) {
        apply((AnaliticaCreada event) ->{
            analitica.resumen = event.getResumen();
        });

        apply((ReporteCreado event) -> {
            var reporteId = event.getReporteId();
            var reporte = new Reporte(reporteId, event.getFecha());
            analitica.reportes.put(reporteId, reporte);
        });

        /*apply((ContenidoAgregadoAReporte event) -> {
            analitica.reporte.get(event.getReporteId()).agregarReporte(event.getContenido());
        });*/
    }
}
