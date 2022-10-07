package mainApp;

import java.util.ArrayList;

import models.Empleado;
import utils.FileWorker;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		for(int i = 0; i < 3; i++)
			empleados.add(new Empleado("Daniel", "Dan", i));
		
		FileWorker.guardarEmpleados(empleados);
		FileWorker.imprimirFicheroEmpleados(empleados, true);
	}

}
