package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.analitica.values.Estrategia;
import co.com.universidadx.permanencia.analitica.values.Meta;
import co.com.universidadx.permanencia.analitica.values.PlanId;

public class Plan extends Entity<PlanId> {
    protected Meta meta;
    protected Estrategia estrategia;

    public Plan(PlanId entityId, Meta meta, Estrategia estrategia) {
        super(entityId);
        this.meta = meta;
        this.estrategia = estrategia;
    }
}
