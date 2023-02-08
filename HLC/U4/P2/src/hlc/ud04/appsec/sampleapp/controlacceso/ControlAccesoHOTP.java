package hlc.ud04.appsec.sampleapp.controlacceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;

public class ControlAccesoHOTP implements ControlAcceso {

	/**
	 * "Permisos" posee lo mismo que "Operaciones", indicando tambien si puede
	 * hacerlo todo o nada
	 */
	private enum Permisos {
		LECTURA, ESCRITURA, TODO, NADA
	}

	private Map<String, Permisos> perms;
	private static Permisos permisoUsuario;
	private final String ARCHIVO_PERMISOS = "db/controlAccesoHOTP.txt";

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		BufferedReader br;
		File archivo = new File(ARCHIVO_PERMISOS);

		System.out.println(archivo.exists());

		if (!archivo.exists())
			return false;
		else {
			setPerms();
			String linea = "";

			try {
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					String[] partes = linea.split(":");

					if (Long.parseLong(partes[0]) == usuario.getUid()) {
						br.close();
						if (partes.length > 1)
							permisoUsuario = perms.get(partes[1]);
						else
							return false;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

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
