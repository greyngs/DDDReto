package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import co.com.universidadx.permanencia.contenido.values.PsicologoId;

public class PlanId  extends Identity {
    public PlanId(String id) {
        super(id);
    }

    public static PlanId of(String id) {
        return new PlanId(id);
    }
}
