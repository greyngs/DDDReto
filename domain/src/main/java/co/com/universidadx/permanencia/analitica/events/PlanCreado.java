package co.com.universidadx.permanencia.analitica.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.universidadx.permanencia.analitica.values.Estrategia;
import co.com.universidadx.permanencia.analitica.values.Meta;
import co.com.universidadx.permanencia.analitica.values.PlanId;

public class PlanCreado extends DomainEvent {
    private final PlanId planId;
    private final Meta meta;
    private final Estrategia estrategia;

    public PlanCreado(PlanId planId, Meta meta, Estrategia estrategia) {
        super("co.com.universidadx.permanencia.PlanCreado");
        this.planId = planId;
        this.meta = meta;
        this.estrategia = estrategia;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Meta getMeta() {
        return meta;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }
}
