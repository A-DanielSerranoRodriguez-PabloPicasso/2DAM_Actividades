package hlc.ud04.appsec.sampleapp.controlacceso;

import java.util.HashMap;
import java.util.Map;

import hlc.ud04.appsec.sampleapp.passwd.models.GestorPasswdPermisos;
import hlc.ud04.appsec.sampleapp.passwd.models.PasswdPermisos;
import hlc.ud04.appsec.sampleapp.passwd.models.PersistenciaPasswdPermisos;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;

public class ControlAccesoPasswd implements ControlAcceso {

	/**
	 * "Permisos" posee lo mismo que "Operaciones", indicando tambien si puede
	 * hacerlo todo o nada
	 */
	private enum Permisos {
		LECTURA, ESCRITURA, TODO, NADA
	}

	private Map<String, Permisos> perms;
	private static Permisos permisoUsuario;
	private static boolean checked = false;

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		if (!checked) {
			setPerms();
			GestorPasswdPermisos gpd = new PersistenciaPasswdPermisos("db/base.db");
			PasswdPermisos ppUsuario = gpd.getUsuario(usuario.getUid());
			String sPermiso = ppUsuario.getPermiso();
			permisoUsuario = perms.get(sPermiso);
			checked = true;
		}

		if (permisoUsuario != null)
			if (permisoUsuario == Permisos.TODO)
				return true;
			else if (permisoUsuario == Permisos.ESCRITURA)
				return permisoUsuario.name().equals(operacion.name());
			else if (permisoUsuario == Permisos.LECTURA)
				return permisoUsuario.name().equals(operacion.name());

		return false;
	}

	private void setPerms() {
		perms = new HashMap<>();
		perms.put("rw", Permisos.TODO);
		perms.put("r", Permisos.LECTURA);
		perms.put("w", Permisos.ESCRITURA);
		perms.put("n", Permisos.NADA);
	}

}
