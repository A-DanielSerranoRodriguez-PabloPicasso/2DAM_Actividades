package models;

abstract public class Persona {
	private String dni, nmbr, apell, domic;
	private int edad, tlf;

	/**
	 * Crea una persona con un DNI, nombre y apellidos
	 * 
	 * @param dni   String
	 * @param nmbr  String
	 * @param apell String
	 */
	protected Persona(String dni, String nmbr, String apell) {
		this.dni = dni;
		this.nmbr = nmbr;
		this.apell = apell;
	}

	/**
	 * Crea una persona con todos los atributos
	 * 
	 * @param dni   String
	 * @param nmbr  String
	 * @param apell String
	 * @param domic String
	 * @param edad  int
	 * @param tlf   int
	 */
	protected Persona(String dni, String nmbr, String apell, String domic, int edad, int tlf) {
		this.dni = dni;
		this.nmbr = nmbr;
		this.apell = apell;
		this.domic = domic;
		this.edad = edad;
		this.tlf = tlf;
	}

	// getters/setters
	/**
	 * Devuelve el DNI
	 * 
	 * @return dni int
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sobreescribre el DNI
	 * 
	 * @param dni String
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve el nombre
	 * 
	 * @return nmbr String
	 */
	public String getNmbr() {
		return nmbr;
	}

	/**
	 * Sobreescribre el nombre
	 * 
	 * @param nmbr String
	 */
	public void setNmbr(String nmbr) {
		this.nmbr = nmbr;
	}

	/**
	 * Devuelve los apellidos
	 * 
	 * @return apell String
	 */
	public String getApell() {
		return apell;
	}

	/**
	 * Sobreescribre los apellidos
	 * 
	 * @param apell String
	 */
	public void setApell(String apell) {
		this.apell = apell;
	}

	/**
	 * Devuelve el domicilio
	 * 
	 * @return domic String
	 */
	public String getDomic() {
		return domic;
	}

	/**
	 * Sobreescribre el domicilio
	 * 
	 * @param domic String
	 */
	public void setDomic(String domic) {
		this.domic = domic;
	}

	/**
	 * Devuelve la edad
	 * 
	 * @return edad int
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Sobreescribre la edad
	 * 
	 * @param edad int
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Devuelve el telefono
	 * 
	 * @return tlf int
	 */
	public int getTlf() {
		return tlf;
	}

	/**
	 * Sobreescribre el telefono
	 * 
	 * @param tlf int
	 */
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	// toString
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nmbr=" + nmbr + ", apell=" + apell + ", domic=" + domic + ", edad=" + edad
				+ ", tlf=" + tlf + "]";
	}

}
