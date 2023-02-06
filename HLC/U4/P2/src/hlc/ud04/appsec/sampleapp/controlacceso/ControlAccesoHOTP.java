package hlc.ud04.appsec.sampleapp.controlacceso;

import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;

public class ControlAccesoHOTP implements ControlAcceso {

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
    return false;
  }

}
