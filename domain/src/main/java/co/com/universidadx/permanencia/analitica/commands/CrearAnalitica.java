package co.com.universidadx.permanencia.analitica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class CrearAnalitica extends Command {
    private final AnaliticaId analiticaId;
    private final Resumen resumen;
    private final SesionId sesionId;
    private final ContenidoId contenidoId;

    public CrearAnalitica(AnaliticaId analiticaId, Resumen resumen, SesionId sesionId, ContenidoId contenidoId) {
        this.analiticaId = analiticaId;
        this.resumen = resumen;
        this.sesionId = sesionId;
        this.contenidoId = contenidoId;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public Resumen getResumen() {
        return resumen;
    }

    public SesionId getSesionId() {
        return sesionId;
    }

    public ContenidoId getContenidoId() {
        return contenidoId;
    }
}
