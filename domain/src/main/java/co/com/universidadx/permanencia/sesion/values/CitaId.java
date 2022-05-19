package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.Identity;

public class CitaId extends Identity {
    public CitaId(String id) {
        super(id);
    }

    public static CitaId of(String id) {
        return new CitaId(id);
    }
}
