package co.com.universidadx.permanencia.contenido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Experiencia implements ValueObject<Double> {
    private final Double value;

    public Experiencia(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value < 0){
            throw new IllegalArgumentException("La experiencia debe ser ppositiva");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
