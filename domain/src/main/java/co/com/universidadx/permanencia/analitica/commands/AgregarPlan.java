package co.com.universidadx.permanencia.analitica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.universidadx.permanencia.analitica.values.AnaliticaId;
import co.com.universidadx.permanencia.analitica.values.Estrategia;
import co.com.universidadx.permanencia.analitica.values.Meta;

public class AgregarPlan extends Command {
    private final AnaliticaId analiticaId;
    private final Meta meta;
    private final Estrategia estrategia;

    public AgregarPlan(AnaliticaId analiticaId, Meta meta, Estrategia estrategia) {
        this.analiticaId = analiticaId;
        this.meta = meta;
        this.estrategia = estrategia;
    }

    public AnaliticaId getAnaliticaId() {
        return analiticaId;
    }

    public Meta getMeta() {
        return meta;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }
}
