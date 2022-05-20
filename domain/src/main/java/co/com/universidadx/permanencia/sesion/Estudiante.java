package co.com.universidadx.permanencia.sesion;

import co.com.sofka.domain.generic.Entity;
import co.com.universidadx.permanencia.sesion.values.Carrera;
import co.com.universidadx.permanencia.sesion.values.Email;
import co.com.universidadx.permanencia.sesion.values.EstudianteId;
import co.com.universidadx.permanencia.generic.values.Nombre;

public class Estudiante extends Entity<EstudianteId> {
    protected Nombre nombre;
    protected Carrera carrera;
    protected Email email;

    public Estudiante(EstudianteId entityId, Nombre nombre, Carrera carrera, Email email) {
        super(entityId);
        this.nombre = nombre;
        this.carrera = carrera;
        this.email = email;
    }

    public void modificarEmail(Email email) {
        this.email = email;
    }

    public void cambiarCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
