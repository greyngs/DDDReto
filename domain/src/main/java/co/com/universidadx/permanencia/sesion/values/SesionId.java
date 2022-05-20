package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.Identity;

public class SesionId extends Identity {
    public SesionId(String id) {
        super(id);
    }

    public static SesionId of(String id) {
        return new SesionId(id);
    }
}
