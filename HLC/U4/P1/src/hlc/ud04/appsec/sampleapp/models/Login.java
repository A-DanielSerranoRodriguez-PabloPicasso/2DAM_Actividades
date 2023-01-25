package hlc.ud04.appsec.sampleapp.models;

import hlc.ud04.appsec.sampleapp.auth.otp.GeneradorHOTP;

public class Login {
	private String numeroCuenta;
	private String secreto;

	public Login(String numeroCuenta, String secreto) {
		this.numeroCuenta = numeroCuenta;
		this.secreto = secreto;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getSecretoHotp() {
		String generado = new GeneradorHOTP().genera(secreto, (System.currentTimeMillis() / 1000) / 30);
		return generado;
	}

}