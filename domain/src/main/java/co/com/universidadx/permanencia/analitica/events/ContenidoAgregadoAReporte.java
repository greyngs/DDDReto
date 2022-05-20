package co.com.universidadx.permanencia.analitica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.Contenido;
import co.com.universidadx.permanencia.analitica.values.ReporteId;

public class ContenidoAgregadoAReporte extends DomainEvent {
    private final ReporteId reporteId;
    private final Contenido contenido;

    public ContenidoAgregadoAReporte(ReporteId reporteId, Contenido contenido) {
        super("co.com.universidadx.permanencia.ContenidoAgregadoAReporte");
        this.reporteId = reporteId;
        this.contenido = contenido;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
