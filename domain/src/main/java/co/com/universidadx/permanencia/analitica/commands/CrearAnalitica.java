package co.com.universidadx.permanencia.analitica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;

public class CrearAnalitica extends Command {
    private final AnaliticaId analiticaId;
    private final Resumen resumen;

    public CrearAnalitica(AnaliticaId analiticaId, Resumen resumen) {
        this.analiticaId = analiticaId;
        this.resumen = resumen;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
