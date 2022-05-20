package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.analitica.events.AnaliticaCreada;

public class AnaliticaEventChange extends EventChange {
    public AnaliticaEventChange(Analitica analitica) {
        apply((AnaliticaCreada event) ->{
            analitica.resumen = event.getResumen();
        });
    }
}
