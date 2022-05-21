package co.com.universidadx.permanencia.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoT implements ValueObject<EstadoT.Estados> {
    private final Estados value;

    public EstadoT(Estados value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Estados value() {
        return value;
    }

    public enum Estados {
        INICIADO, FINALIZADO, PAUSA
    }
}
