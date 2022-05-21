package co.com.universidadx.permanencia.sesion.services;

import co.com.universidadx.permanencia.sesion.values.Observacion;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public interface ConsultarObersavionDeSesion {
    Observacion consultarPorSesionId(SesionId sesionId);
}
