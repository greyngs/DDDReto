package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estrategia implements ValueObject<String> {
    private final String value;

    public Estrategia(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La estrategia no puede estar en blanco");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("La estrategia no permite mas de 200 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
