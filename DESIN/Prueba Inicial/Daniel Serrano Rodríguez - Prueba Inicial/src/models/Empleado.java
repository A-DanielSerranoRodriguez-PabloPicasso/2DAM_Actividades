package models;

public class Empleado extends Persona {
	public enum Dptms {
		Contabilidad, Logistica, Soporte_usuario
	}

	private Dptms dptm;
	private double sueldo, antigEmpr;
	private int diasVacaAnual;
	protected static int numeroEmpleados = 0;
	protected static double sueldoTotal = 0;
	protected static double sueldoMedio = 0;

	/**
	 * Crea un empleado con un DNI, nombre, apellido y departamento
	 * 
	 * @param dptm String
	 */
	public Empleado(String dni, String nmbr, String apell, Dptms dptm) {
		super(dni, nmbr, apell);
		this.dptm = dptm;
		numeroEmpleados++;
	}

	/**
	 * Crea un empleado con todoas las caracteristicas
	 * 
	 * @param dni           String
	 * @param nmbr          String
	 * @param apell         String
	 * @param dptm          String
	 * @param domic         String
	 * @param edad          int
	 * @param tlf           int
	 * @param sueldo        double
	 * @param antigEmpr     double
	 * @param diasVacaAnual int
	 */
	public Empleado(String dni, String nmbr, String apell, Dptms dptm, String domic, int edad, int tlf, double sueldo,
			double antigEmpr, int diasVacaAnual) {
		super(dni, nmbr, apell, domic, edad, tlf);
		this.dptm = dptm;
		this.sueldo = sueldo;
		this.antigEmpr = antigEmpr;
		this.diasVacaAnual = diasVacaAnual;
		numeroEmpleados++;
		sueldoTotal += sueldo;
		sueldoMedio = sueldoTotal / (double) numeroEmpleados;
	}

	// getters/setters
	/**
	 * Devuelve el departamento
	 * 
	 * @return dptm String
	 */
	public Dptms getDptm() {
		return dptm;
	}

	/**
	 * Sobreescribe el departamento
	 * 
	 * @param dptm String
	 */
	public void setDptm(Dptms dptm) {
		this.dptm = dptm;
	}

	/**
	 * Devuelve el sueldo
	 * 
	 * @return sueldo double
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * Sobreescribe el sueldo
	 * 
	 * @param sueldo double
	 */
	public void setSueldo(double sueldo) {
		sueldoTotal -= this.sueldo;
		this.sueldo = sueldo;
		sueldoTotal += sueldo;
		sueldoMedio = sueldoTotal / (double) numeroEmpleados;
	}

	/**
	 * Devuelve la antiguedad en la empresa
	 * 
	 * @return antigEmpr double
	 */
	public double getAntigEmpr() {
		return antigEmpr;
	}

	/**
	 * Sobreescribe la antiguedad en la empresa
	 * 
	 * @param antigEmpr double
	 */
	public void setAntigEmpr(double antigEmpr) {
		this.antigEmpr = antigEmpr;
	}

	/**
	 * Devuelve los dias de vacaciones anuales
	 * 
	 * @return diasVacaAnual int
	 */
	public int getDiasVacaAnual() {
		return diasVacaAnual;
	}

	/**
	 * Sobreescribe los dias de vacaciones anuales
	 * 
	 * @param diasVacaAnual int
	 */
	public void setDiasVacaAnual(int diasVacaAnual) {
		this.diasVacaAnual = diasVacaAnual;
	}

	/**
	 * Devuelve el numero de empleados
	 * 
	 * @return the numeroEmpleados
	 */
	public static int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	/**
	 * @return the sueldoMedio
	 */
	public static double getSueldoMedio() {
		return sueldoMedio;
	}

	// METHODS
	// normal

	// static
	protected static int addEmpleado() {
		return numeroEmpleados;
	}

	@Override
	public String toString() {
		return super.toString() + " Empleado [dptm=" + dptm + ", sueldo=" + sueldo + ", antigEmpr=" + antigEmpr
				+ ", diasVacaAnual=" + diasVacaAnual + "]";
	}

}
