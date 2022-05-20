package co.com.universidadx.permanencia.contenido.values;

import co.com.sofka.domain.generic.Identity;
import co.com.universidadx.permanencia.contenido.Psicologo;

public class PsicologoId extends Identity {
    public PsicologoId(String id) {
        super(id);
    }

    public static PsicologoId of(String id) {
        return new PsicologoId(id);
    }
}
