package mainApp;

import models.Biblioteca_dni;
import models.Empleado;
import models.Empleado.Dptms;
import models.Encargado;

public class PruebaEmpresa {

	public static void main(String[] args) {
		// EJ1
		Empleado emp1 = new Empleado("12345678Z", "Dani", "Serra", Dptms.Contabilidad);
		Empleado emp2 = new Empleado("12345678Z", "Dani", "Serra", Dptms.Contabilidad, "Casa", 2, 3, 100, 5, 6);
		emp1.setSueldo(100);

		Encargado enc1 = new Encargado("12345678Z", "Dani", "Serra", Dptms.Contabilidad, "Perro");
		Encargado enc2 = new Encargado("12345678Z", "Dani", "Serra", Dptms.Contabilidad, "Perro", "Cosa", 1, 2, 100,
				100, 100, 4);
		enc1.setSueldo(100);

		System.out.println(Empleado.getNumeroEmpleados() + "\t" + Empleado.getSueldoMedio());

		// EJ 2
		Empleado[] empleados = genera_empleados(5);
		for (int i = 0; i < empleados.length; i++) {
			System.out.println(empleados[i].getNmbr());
		}

	}

	public static Empleado[] genera_empleados(int num) {
		Empleado[] empleados = new Empleado[20];
		int numEmp = 1;
		for (int i = 0, l = empleados.length; i < l; i++) {

			empleados[i] = new Empleado(Biblioteca_dni.crea_dni_con_letra(), "nombre" + numEmp, "apellidos" + numEmp,
					selectDptm((int) (Math.random() * 3) + 1));
			
			numEmp++;
		}

		return empleados;
	}

	public static Dptms selectDptm(int num) {
		switch (num) {
		case 1:
			return Dptms.Contabilidad;
		case 2:
			return Dptms.Logistica;
		case 3:
			return Dptms.Soporte_usuario;
		default:
			return null;
		}
	}

}
