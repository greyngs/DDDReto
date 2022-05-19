package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {
    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El numero no puede estar en blanco");
        }
        if(this.value.length() != 10){
            throw new IllegalArgumentException("El numero debe ser de 10 digitos");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
