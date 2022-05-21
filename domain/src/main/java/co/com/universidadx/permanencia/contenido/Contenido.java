package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;
import co.com.universidadx.permanencia.contenido.events.EjercicioCreado;
import co.com.universidadx.permanencia.contenido.values.*;

import java.util.List;
import java.util.Map;

public class Contenido extends AggregateEvent<ContenidoId> {
    protected Psicologo psicologo;
    protected Map<EjercicioId, Ejercicio> ejercicios;
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

    public static Contenido from(ContenidoId entityId, List<DomainEvent> events){
        var contenido = new Contenido(entityId);
        events.forEach(contenido::applyEvent);
        return contenido;
    }

    public void agregarEjercicio(Nombre nombre, Descripcion descripcion) {
        var ejercicioId = new EjercicioId();
        appendChange(new EjercicioCreado(ejercicioId, nombre, descripcion)).apply();
    }
}
