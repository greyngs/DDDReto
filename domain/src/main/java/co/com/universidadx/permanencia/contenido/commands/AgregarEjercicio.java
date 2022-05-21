package co.com.universidadx.permanencia.contenido.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.contenido.values.Descripcion;
import co.com.universidadx.permanencia.contenido.values.Nombre;

public class AgregarEjercicio extends Command {
    private final ContenidoId contenidoId;
    private final Nombre nombre;
    private final Descripcion descripcion;

    public AgregarEjercicio(ContenidoId contenidoId, Nombre nombre, Descripcion descripcion) {
        this.contenidoId = contenidoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ContenidoId getContenidoId() {
        return contenidoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
