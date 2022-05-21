package co.com.universidadx.permanencia.contenido.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Descripcion;
import co.com.universidadx.permanencia.contenido.values.EjercicioId;
import co.com.universidadx.permanencia.contenido.values.Nombre;

public class EjercicioCreado extends DomainEvent {
    private final EjercicioId ejercicioId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public EjercicioCreado(EjercicioId ejercicioId, Nombre nombre, Descripcion descripcion) {
        super("co.com.universidadx.permanencia.EjercicioCreado");
        this.ejercicioId = ejercicioId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EjercicioId getEjercicioId() {
        return ejercicioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
