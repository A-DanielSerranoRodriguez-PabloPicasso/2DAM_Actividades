package models;

public class Persona {

	private String nombreApellidos, fechaNacimiento, telefonoFijo, telefonoMovil, numeroHijos, comunidad, localidad,
			intereses;

	public Persona(String nombreApellidos, String fechaNacimiento, String telefonoFijo, String telefonoMovil,
			String numeroHijos, String comunidad, String localidad, String intereses) {
		super();
		this.nombreApellidos = nombreApellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefonoFijo = telefonoFijo;
		this.telefonoMovil = telefonoMovil;
		this.numeroHijos = numeroHijos;
		this.comunidad = comunidad;
		this.localidad = localidad;
		this.intereses = intereses;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public String getNumeroHijos() {
		return numeroHijos;
	}

	public String getComunidad() {
		return comunidad;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getIntereses() {
		return intereses;
	}

}
