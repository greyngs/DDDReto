package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Observacion implements ValueObject<String> {
    private final String value;

    public Observacion(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La observacion no puede estar en blanco");
        }
        if(this.value.length() > 300){
            throw new IllegalArgumentException("La observacion no permite mas de 300 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
