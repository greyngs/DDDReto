package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Guia;

public class Contenido extends AggregateEvent<ContenidoId> {
    protected Psicologo psicologo;
    protected Ejercicio ejercicio;
    protected Categoria categoria;
    protected Guia guia;

    public Contenido(ContenidoId entityId, Guia guia) {
        super(entityId);
        appendChange(new ContenidoCreado(guia)).apply();
        subscribe(new ContenidoEventChange(this));
    }

    public Contenido(ContenidoId entityId) {
        super(entityId);
        subscribe(new ContenidoEventChange(this));
    }
}
