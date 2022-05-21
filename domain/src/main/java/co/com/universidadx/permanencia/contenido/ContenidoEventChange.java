package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.contenido.events.ContenidoCreado;
import co.com.universidadx.permanencia.contenido.events.EjercicioCreado;
import co.com.universidadx.permanencia.contenido.values.EjercicioId;

public class ContenidoEventChange extends EventChange {
    public ContenidoEventChange(Contenido contenido) {
        apply((ContenidoCreado event) ->{
            contenido.guia = event.getGuia();
        });

        apply((EjercicioCreado event) -> {
            var ejercicioId = event.getEjercicioId();
            var ejercicio = new Ejercicio(ejercicioId, event.getNombre(), event.getDescripcion());
            contenido.ejercicios.put(ejercicioId, ejercicio);
        });
    }
}
