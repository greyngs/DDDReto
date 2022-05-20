package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.Identity;

public class AnalistaId extends Identity {
    public AnalistaId(String id) {
        super(id);
    }

    public static AnalistaId of(String id) {
        return new AnalistaId(id);
    }
}
