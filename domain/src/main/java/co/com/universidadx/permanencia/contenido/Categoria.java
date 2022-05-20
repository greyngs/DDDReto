package co.com.universidadx.permanencia.contenido;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.contenido.values.CategoriaId;
import co.com.universidadx.permanencia.contenido.values.Tipo;

public class Categoria extends Entity<CategoriaId> {
    protected Tipo tipo;

    public Categoria(CategoriaId entityId, Tipo tipo) {
        super(entityId);
        this.tipo = tipo;
    }
}
