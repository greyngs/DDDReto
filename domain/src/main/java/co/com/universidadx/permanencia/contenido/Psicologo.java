package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.generic.values.Experiencia;
import co.com.universidadx.permanencia.contenido.values.PsicologoId;
import co.com.universidadx.permanencia.generic.values.Nombre;

public class Psicologo extends Entity<PsicologoId> {
    protected Nombre nombre;
    protected Experiencia experiencia;

    public Psicologo(PsicologoId entityId, Nombre nombre, Experiencia experiencia) {
        super(entityId);
        this.nombre = nombre;
        this.experiencia = experiencia;
    }
}
