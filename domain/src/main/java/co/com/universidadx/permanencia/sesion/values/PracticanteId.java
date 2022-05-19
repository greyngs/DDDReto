package co.com.universidadx.permanencia.sesion.values;

import co.com.sofka.domain.generic.Identity;

public class PracticanteId extends Identity {
    public PracticanteId(String id) {
        super(id);
    }

    public static PracticanteId of(String id) {
        return new PracticanteId(id);
    }
}
