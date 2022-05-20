package co.com.universidadx.permanencia.contenido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Guia;

public class CrearContenido extends Command {
    private final ContenidoId contenidoId;
    private final Guia guia;

    public CrearContenido(ContenidoId contenidoId, Guia guia) {
        this.contenidoId = contenidoId;
        this.guia = guia;
    }

    public ContenidoId getContenidoId() {
        return contenidoId;
    }

    public Guia getGuia() {
        return guia;
    }
}
