package co.com.universidadx.permanencia.analitica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Contenido;
import co.com.universidadx.permanencia.analitica.values.ReporteId;

public class AgregarContenido extends Command {
    private final AnaliticaId analiticaId;
    private final ReporteId reporteId;
    private final Contenido contenido;

    public AgregarContenido(AnaliticaId analiticaId, ReporteId reporteId, Contenido contenido) {
        this.analiticaId = analiticaId;
        this.reporteId = reporteId;
        this.contenido = contenido;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public ReporteId getReporteId() {
        return reporteId;
    }

    public Contenido getContenido() {
        return contenido;
    }
}
