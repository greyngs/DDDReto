package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.contenido.values.Descripcion;
import co.com.universidadx.permanencia.contenido.values.EjercicioId;
import co.com.universidadx.permanencia.contenido.values.Nombre;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio extends Entity<EjercicioId> {
    protected Nombre nombre;
    protected Descripcion descripcion;

    public Ejercicio(EjercicioId entityId, Nombre nombre, Descripcion descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
