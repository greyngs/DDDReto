package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Meta implements ValueObject<String> {
    private final String value;

    public Meta(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("La meta no puede estar en blanco");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("La meta no permite mas de 200 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
