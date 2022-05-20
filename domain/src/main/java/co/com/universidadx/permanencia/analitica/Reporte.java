package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.analitica.values.Contenido;
import co.com.universidadx.permanencia.analitica.values.ReporteId;
import co.com.universidadx.permanencia.generic.values.Fecha;

public class Reporte extends Entity<ReporteId> {
    protected Contenido contenido;
    protected Fecha fecha;

    public Reporte(ReporteId entityId, Contenido contenido, Fecha fecha) {
        super(entityId);
        this.contenido = contenido;
        this.fecha = fecha;
    }
}
