package co.com.universidadx.permanencia.contenido.values;

import co.com.sofka.domain.generic.Identity;
import co.com.universidadx.permanencia.sesion.values.PracticanteId;

public class CategoriaId extends Identity {
    public CategoriaId(String id) {
        super(id);
    }

    public static CategoriaId of(String id) {
        return new CategoriaId(id);
    }
}
