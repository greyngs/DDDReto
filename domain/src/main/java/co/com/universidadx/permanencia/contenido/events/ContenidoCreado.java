package co.com.universidadx.permanencia.contenido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.contenido.values.Guia;

public class ContenidoCreado extends DomainEvent {
    private final Guia guia;

    public ContenidoCreado(Guia guia) {
        super("co.com.universidadx.permanencia.ContenidoCreado");
        this.guia = guia;
    }

    public Guia getGuia() {
        return guia;
    }
}
