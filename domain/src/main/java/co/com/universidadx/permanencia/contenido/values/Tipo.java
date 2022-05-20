package co.com.universidadx.permanencia.contenido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<Tipo.Tipos> {
    private final Tipos value;

    public Tipo(Tipo.Tipos value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.equals(Tipos.MEDITACION)){
            throw new IllegalArgumentException("Meditacion esta pausada por el momento");
        }
    }

    public enum Tipos {
        TIEMPO, CONCENTRACION, MEDITACION
    }

    @Override
    public Tipos value() {
        return value;
    }
}
