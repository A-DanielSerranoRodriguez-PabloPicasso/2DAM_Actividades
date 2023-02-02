package hlc.ud04.appsec.sampleapp.passwd.models;

public class LoginPasswd {
	private int id;
	private String usuario;
	private String secreto;

	public LoginPasswd(int id, String usuario, String passwd) {
		this.id =id;
		this.usuario = usuario;
		this.secreto = passwd;
	}
	
	public int getId() {
		return id;
	}

	public String getNumeroCuenta() {
		return usuario;
	}

	public String getPasswd() {
		return secreto;
	}

}
