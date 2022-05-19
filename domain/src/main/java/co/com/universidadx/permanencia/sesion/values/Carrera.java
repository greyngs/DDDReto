package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Carrera implements ValueObject<Carrera.Opciones> {
    private final Opciones value;

    public Carrera(Opciones value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.equals(Opciones.INGSISTEMAS)){
            throw new IllegalArgumentException("La carrera de Ingenier de sistemas no esta disponible en el momento");
        }

    }

    public enum Opciones {
        MEDICINA, PSICOLOGIA, INGSISTEMAS
    }

    @Override
    public Opciones value() {
        return value;
    }
}
