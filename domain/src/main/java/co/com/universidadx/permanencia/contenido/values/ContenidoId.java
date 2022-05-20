package co.com.universidadx.permanencia.contenido.values;

import co.com.sofka.domain.generic.Identity;

public class ContenidoId extends Identity {
    public ContenidoId(String id) {
        super(id);
    }

    public static ContenidoId of(String id) {
        return new ContenidoId(id);
    }
}
