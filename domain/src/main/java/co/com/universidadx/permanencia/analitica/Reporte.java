package co.com.universidadx.permanencia.analitica;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.analitica.values.Contenido;
import co.com.universidadx.permanencia.analitica.values.ReporteId;
import co.com.universidadx.permanencia.generic.values.Fecha;

import java.util.HashSet;
import java.util.Set;

public class Reporte extends Entity<ReporteId> {
    protected Set<Contenido> contenidos;
    protected Fecha fecha;

    public Reporte(ReporteId entityId, Fecha fecha) {
        super(entityId);
        this.contenidos = new HashSet<>();
        this.fecha = fecha;
    }

    public void agregarContenido(Contenido contenido) {
        this.contenidos.add(contenido);
        //Validaciones aqui
    }

    public Set<Contenido> contenidos() {
        return contenidos;
    }
}
