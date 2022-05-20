package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;

public class ContenidoEventChange extends EventChange {
    public ContenidoEventChange(Contenido contenido) {
        apply((ContenidoCreado event) ->{
            contenido.guia = event.getGuia();
        });
    }
}
