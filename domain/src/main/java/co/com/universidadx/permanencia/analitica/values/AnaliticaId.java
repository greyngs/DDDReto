package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.Identity;

public class AnaliticaId extends Identity {
    public AnaliticaId(String id) {
        super(id);
    }

    public static AnaliticaId of(String id) {
        return new AnaliticaId(id);
    }
}
