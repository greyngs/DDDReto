package co.com.universidadx.permanencia.analitica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.ReporteId;
import co.com.universidadx.permanencia.generic.values.Fecha;

public class ReporteCreado extends DomainEvent {
    private final ReporteId reporteId;
    private final Fecha fecha;

    public ReporteCreado(ReporteId reporteId, Fecha fecha) {
        super("co.com.universidadx.permanencia.ReporteCreado");
        this.reporteId = reporteId;
        this.fecha = fecha;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
