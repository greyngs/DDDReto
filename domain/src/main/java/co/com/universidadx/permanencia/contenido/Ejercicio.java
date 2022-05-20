package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.contenido.values.Descripcion;
import co.com.universidadx.permanencia.contenido.values.EjercicioId;
import co.com.universidadx.permanencia.contenido.values.Nombre;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio extends Entity<EjercicioId> {
    protected Nombre nombre;
    protected Set<Descripcion> descripciones;

    public Ejercicio(EjercicioId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
        this.descripciones = new HashSet<>();
    }

    public void agregarDescripcion(Descripcion descripcion) {
        this.descripciones.add(descripcion);
        // Validaciones aqui
    }
}
