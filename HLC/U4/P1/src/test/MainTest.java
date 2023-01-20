package test;

import hlc.ud04.appsec.sampleapp.auth.otp.GeneradorHOTP;

public class MainTest {

	public static void main(String[] args) {
		GeneradorHOTP ghopt = new GeneradorHOTP();
		
		System.out.println(ghopt.genera("aaa", 30));
	}
}
