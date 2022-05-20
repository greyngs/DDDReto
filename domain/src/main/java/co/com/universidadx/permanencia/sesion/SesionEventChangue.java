package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;

public class SesionEventChangue extends EventChange {
    public SesionEventChangue(Sesion sesion) {
        apply((SesionCreada event)->{
                    sesion.observacion = event.getObservacion();
        });

    }
}
