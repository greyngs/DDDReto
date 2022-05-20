package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.analitica.values.AnalistaId;
import co.com.universidadx.permanencia.contenido.values.Experiencia;
import co.com.universidadx.permanencia.sesion.values.Nombre;

public class Analista extends Entity<AnalistaId> {
    protected Nombre nombre;
    protected Experiencia experiencia;

    public Analista(AnalistaId entityId, Nombre nombre, Experiencia experiencia) {
        super(entityId);
        this.nombre = nombre;
        this.experiencia = experiencia;
    }
}
