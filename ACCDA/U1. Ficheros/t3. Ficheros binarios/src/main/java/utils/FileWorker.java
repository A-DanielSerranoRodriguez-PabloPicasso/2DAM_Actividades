package utils;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Empleado;
import models.NoHeaderObjectOutputStream;

public class FileWorker {
	public static boolean guardarEmpleados(ArrayList<Empleado> empleados) {
		File fichDat = new File("src/main/resources/dat/empleados.dat");

		if (!fichDat.exists()) {
			ObjectOutputStream oos = null;
			try {
				fichDat.createNewFile();
				oos = new ObjectOutputStream(new FileOutputStream(fichDat));

				for (Empleado empleado : empleados)
					oos.writeObject(empleado);

				oos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			ObjectInputStream ois = null;
			NoHeaderObjectOutputStream nhoos = null;

			try {
				ois = new ObjectInputStream(new FileInputStream(fichDat));
				nhoos = new NoHeaderObjectOutputStream(new FileOutputStream(fichDat, true));

				for (Empleado empleado : empleados)
					if (nhoos != null) {
						nhoos.writeObject(empleado);
						nhoos.flush();
					}
			} catch (EOFException e) {
				// Nada
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
					nhoos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	public static void imprimirFicheroEmpleados(ArrayList<Empleado> empleados, boolean pantalla) {
		File fichDat = new File("src/main/resources/dat/empleados.dat");
		ObjectInputStream ois = null;
		Empleado empleado;

		if (pantalla) {
			try {
				ois = new ObjectInputStream(new FileInputStream(fichDat));

				while ((empleado = (Empleado) ois.readObject()) != null) {
					System.out.println(empleado.toString());
				}
			} catch (EOFException e) {
				// Nada
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			File fichTxt = new File("src/main/resources/txt/empleados.txt");
			BufferedWriter br = null;
			if (!fichDat.exists())
				guardarEmpleados(empleados);

			try {
				br = new BufferedWriter(new FileWriter(fichTxt, true));
				ois = new ObjectInputStream(new FileInputStream(fichDat));

				if (!fichTxt.exists()) {
					while ((empleado = (Empleado) ois.readObject()) != null) {
						br.write(empleado.toString() + "\n");
					}
				} else {
					while ((empleado = (Empleado) ois.readObject()) != null) {
						br.write(empleado.toString() + "\n");
					}
				}

				br.flush();
			} catch (EOFException e) {
				// Nada
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
