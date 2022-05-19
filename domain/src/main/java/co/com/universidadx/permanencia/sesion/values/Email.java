package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El email no puede estar en blanco");
        }
        if(this.value.length() > 40){
            throw new IllegalArgumentException("El email debe ser maximo de 40 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
