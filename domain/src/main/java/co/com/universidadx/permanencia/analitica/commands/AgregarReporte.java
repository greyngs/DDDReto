package co.com.universidadx.permanencia.analitica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.generic.values.Fecha;

public class AgregarReporte extends Command {
    private final AnaliticaId analiticaId;
    private final Fecha fecha;

    public AgregarReporte(AnaliticaId analiticaId, Fecha fecha) {
        this.analiticaId = analiticaId;
        this.fecha = fecha;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
