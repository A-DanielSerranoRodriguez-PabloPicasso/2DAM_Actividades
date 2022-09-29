package models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Empleado implements Serializable {
	private String empresa;
	private int edad, numEmpleados;

	/**
	 * @param empresa      String
	 * @param edad         int
	 * @param numEmpleados int
	 */
	public Empleado(String empresa, int edad, int numEmpleados) {
		this.empresa = empresa;
		this.edad = edad;
		this.numEmpleados = numEmpleados;
	}

	/**
	 * @return empresa String
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa String
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return edad int
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad int
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return numEmpleados int
	 */
	public int getNumEmpleados() {
		return numEmpleados;
	}

	/**
	 * @param numEmpleados int
	 */
	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	@Override
	public String toString() {
		return "Empresa: " + getEmpresa() + "\nEdad: " + getEdad() + "\nNumero empleados: " + getNumEmpleados();
	}

}
