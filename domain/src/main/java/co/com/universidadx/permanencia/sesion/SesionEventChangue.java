package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.EventChange;
import co.com.universidadx.permanencia.generic.values.EstadoT;
import co.com.universidadx.permanencia.sesion.events.SesionCreada;
import co.com.universidadx.permanencia.sesion.events.SesionFinalizada;

public class SesionEventChangue extends EventChange {
    public SesionEventChangue(Sesion sesion) {
        apply((SesionCreada event)->{
                    sesion.observacion = event.getObservacion();
                    sesion.estadoT = new EstadoT(EstadoT.Estados.INICIADO);
        });

        apply((SesionFinalizada event) -> {
            sesion.observacion = event.getObservacion();
            sesion.estadoT = new EstadoT(EstadoT.Estados.FINALIZADO);
        });
    }
}
