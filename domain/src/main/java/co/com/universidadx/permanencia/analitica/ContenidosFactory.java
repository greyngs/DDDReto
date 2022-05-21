package co.com.universidadx.permanencia.analitica;

import co.com.universidadx.permanencia.analitica.values.Contenido;

import java.util.HashSet;
import java.util.Set;

public class ContenidosFactory {
    private final Set<Contenido> contenidos;

    private ContenidosFactory() {
        this.contenidos = new HashSet<>();
    }

    public ContenidosFactory agregarContenido(Contenido contenido) {
        contenidos.add(contenido);
        return this;
    }

    public static ContenidosFactory builder() {
        return new ContenidosFactory();
    }

    public Set<Contenido> contenidos() {
        return contenidos;
    }
}
