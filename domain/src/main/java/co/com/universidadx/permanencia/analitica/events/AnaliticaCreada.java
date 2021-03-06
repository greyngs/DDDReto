package co.com.universidadx.permanencia.analitica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.sesion.values.SesionId;


public class AnaliticaCreada extends DomainEvent {
    private final Resumen resumen;

    public AnaliticaCreada(Resumen resumen) {
        super("co.com.universidadx.permanencia.AnaliticaCreada");
        this.resumen = resumen;
    }

    public Resumen getResumen() {
        return resumen;
    }
}
