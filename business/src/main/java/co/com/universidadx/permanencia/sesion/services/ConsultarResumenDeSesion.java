package co.com.universidadx.permanencia.sesion.services;

import co.com.universidadx.permanencia.analitica.values.Resumen;
import co.com.universidadx.permanencia.sesion.values.SesionId;

public interface ConsultarResumenDeSesion {
    Resumen consultarPorSesionId(SesionId sesionId);
}
