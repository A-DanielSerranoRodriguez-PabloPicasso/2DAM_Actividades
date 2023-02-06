package hlc.ud04.appsec.sampleapp.passwd.models;

public class PasswdPermisos {
	private long id;
	private String permiso;

	public PasswdPermisos(long id, String usuario) {
		this.id = id;
		this.permiso = usuario;
	}

	public long getId() {
		return id;
	}

	public String getPermiso() {
		return permiso;
	}

}
