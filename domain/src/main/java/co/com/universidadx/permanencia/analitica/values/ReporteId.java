package co.com.universidadx.permanencia.analitica.values;

import co.com.sofka.domain.generic.Identity;
import co.com.universidadx.permanencia.contenido.values.PsicologoId;

public class ReporteId extends Identity {
    public ReporteId(String id) {
        super(id);
    }

    public ReporteId() {

    }

    public static ReporteId of(String id) {
        return new ReporteId(id);
    }
}
