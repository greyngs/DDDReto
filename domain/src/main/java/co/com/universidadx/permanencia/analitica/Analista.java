package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.analitica.values.AnalistaId;
import co.com.universidadx.permanencia.contenido.values.ContenidoId;
import co.com.universidadx.permanencia.generic.values.Experiencia;
import co.com.universidadx.permanencia.generic.values.Nombre;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public class Analista extends Entity<AnalistaId> {
    protected Nombre nombre;
    protected Experiencia experiencia;

    public Analista(AnalistaId entityId, Nombre nombre, Experiencia experiencia) {
        super(entityId);
        this.nombre = nombre;
        this.experiencia = experiencia;
    }
}
