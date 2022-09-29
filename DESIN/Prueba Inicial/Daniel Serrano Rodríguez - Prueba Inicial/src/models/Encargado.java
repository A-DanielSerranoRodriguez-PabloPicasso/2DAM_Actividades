package models;

public class Encargado extends Empleado {
	private String cargoEmpresa;
	private double multip;

	/**
	 * Crea un encargado con un DNI, nombre, apellido, departamento y cargo de
	 * empresa
	 * 
	 * @param cargoEmpresa String
	 */
	public Encargado(String dni, String nmbr, String apell, Dptms dptm, String cargoEmpresa) {
		super(dni, nmbr, apell, dptm);
		this.cargoEmpresa = cargoEmpresa;
		this.multip = 1.10;
	}

	/**
	 * Crea un encargado con todos los atributos
	 * 
	 * @param dni          String
	 * @param nmbr         String
	 * @param apell        String
	 * @param dptm         String
	 * @param cargoEmpresa String
	 * @param sueldo       double
	 * @param multip       double
	 */
	public Encargado(String dni, String nmbr, String apell, Dptms dptm, String domic, String cargoEmpresa, int edad,
			int tlf, double sueldo, double antigEmpr, int diasVacaAnual, double multip) {
		super(dni, nmbr, apell, dptm, domic, edad, tlf, sueldo, antigEmpr, diasVacaAnual);
		this.cargoEmpresa = cargoEmpresa;
		this.multip = multip;
	}

	// getters/setters
	/**
	 * Devuelve el cargo en la empresa
	 * 
	 * @return cargoEmpresa String
	 */
	public String getCargoEmpresa() {
		return cargoEmpresa;
	}

	/**
	 * Sobreescribe el cargo en la empresa
	 * 
	 * @param cargoEmpresa String
	 */
	public void setCargoEmpresa(String cargoEmpresa) {
		this.cargoEmpresa = cargoEmpresa;
	}

	/**
	 * Devuelve el sueldo
	 * 
	 * @return sueldo double
	 */
	public double getSueldo() {
		return super.getSueldo() * multip;
	}

	/**
	 * Sobreescribe el sueldo
	 * 
	 * @param cargoEmpresa String
	 */
	public void setSueldo(double sueldo) {
		super.setSueldo(sueldo);
	}

	@Override
	public String toString() {
		return super.toString() + " Encargado [cargoEmpresa=" + cargoEmpresa + ", multip=" + multip + "]";
	}

}
