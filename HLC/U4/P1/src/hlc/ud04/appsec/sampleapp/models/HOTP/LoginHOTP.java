package hlc.ud04.appsec.sampleapp.models.HOTP;

import hlc.ud04.appsec.sampleapp.auth.otp.GeneradorHOTP;

public class LoginHOTP {
	private int id;
	private String usuario;
	private String secreto;

	public LoginHOTP(int id, String usuario, String secreto) {
		this.id = id;
		this.usuario = usuario;
		this.secreto = secreto;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSecretoHotp() {
		String generado = new GeneradorHOTP().genera(secreto, (System.currentTimeMillis() / 1000) / 30);
		return generado;
	}
	
	public int getId() {
		return id;
	}

}
