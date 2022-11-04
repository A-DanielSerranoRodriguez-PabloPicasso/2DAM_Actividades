package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NeptunoDAO;
import models.Categorias;
import models.Productos;
import models.Proveedores;

public class FileWorker {
	private static final String PATH = "src/main/resources/files/";

	/**
	 * Escribe categorias a un archivo
	 * 
	 * @param nombreFichero String
	 * @param rsCat         ResultSet
	 */
	public static void escribeCategoria(String nombreFichero, ResultSet rsCat) {
		File archivo = new File(PATH + nombreFichero);
		BufferedWriter bw = null;
		Categorias cat = null;

		try {
			rsCat.next();
			cat = new Categorias(rsCat.getInt(1), rsCat.getString(2), rsCat.getString(3));
		} catch (SQLException e) {
			System.out.println("Error en ResultSet");
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("CATEGORIA\n");
			bw.write("id;categoria;descripcion\n");
			bw.write(cat.toString() + "\n\n");
		} catch (IOException e) {
			System.out.println("Error de escritura en archivo");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Escribe proveedores a un archivo
	 * 
	 * @param nombreFichero String
	 * @param rsProvs       ResultSet
	 */
	public static void escribeProveedores(String nombreFichero, ResultSet rsProvs) {
		File archivo = new File(PATH + nombreFichero);
		BufferedWriter bw = null;
		ArrayList<Proveedores> proveedores = new ArrayList<>();

		try {
			rsProvs.next();
			while (!rsProvs.isAfterLast()) {
				proveedores.add(new Proveedores(rsProvs.getInt(1), rsProvs.getString(2), rsProvs.getString(3)));
				rsProvs.next();
			}
		} catch (SQLException e) {
			System.out.println("Error en ResultSet");
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write("PROVEEDORES\n");
			bw.write("id;empresa;contacto\n");

			for (Proveedores prov : proveedores) {
				bw.write(prov.toString() + "\n");
			}

			bw.write("\n");
		} catch (IOException e) {
			System.out.println("Error de escritua en archivo");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe productos a un archivo
	 * 
	 * @param nombreFichero String
	 * @param rsProds       ResultSet
	 */
	public static void escribeProductos(String nombreFichero, ResultSet rsProds) {
		File archivo = new File(PATH + nombreFichero);
		BufferedWriter bw = null;
		ArrayList<Productos> productos = new ArrayList<>();

		try {
			rsProds.next();
			while (!rsProds.isAfterLast()) {
				productos.add(new Productos(rsProds.getInt(1), rsProds.getString(2), rsProds.getInt(3),
						rsProds.getInt(4), rsProds.getString(5), rsProds.getDouble(6), rsProds.getInt(7),
						rsProds.getInt(8), rsProds.getInt(9), rsProds.getInt(10)));
				rsProds.next();
			}
		} catch (SQLException e) {
			System.out.println("Error en ResultSet");
			e.printStackTrace();
		}

		try {
			bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write("PRODUCTOS\n");
			bw.write(
					"id;producto;proveedor_id;categoria_id;cantidad_por_unidad;precio_unidad;unidades_existencia;unidades_pedido;nivel_nuevo_pedido;suspendido\n");

			for (Productos prod : productos) {
				bw.write(prod.toString() + "\n");
			}

			bw.write("\n");
		} catch (IOException e) {
			System.out.println("Error de escritua en archivo");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Obtiene los datos de un archivo y los escribe en la base de datos
	 * 
	 * @param nombreFichero String
	 */
	public static void fichero_a_tablas(String nombreFichero) {
		File archivo = new File(PATH + nombreFichero);
		BufferedReader br = null;
		String linea = null;
		NeptunoDAO nDao = null;
		int numLinea = 0;

		// Activamos las transacciones y creamos un savepoint al que volver
		try {
			nDao = new NeptunoDAO();
			nDao.disableAutocommit();
			nDao.setSavepoint();
		} catch (SQLException e) {
			System.out.println("Error conectando a la base de datos");
			e.printStackTrace();
		}

		try {
			br = new BufferedReader(new FileReader(archivo));
		} catch (FileNotFoundException e) {
			System.out.println("Error detectando el archivo");
			e.printStackTrace();
		}

		/*
		 * Leemos el archivo y comprobamos que queremos meter en la base de datos.
		 * 
		 * Dividimos las lineas que queremos meter usando el separador y las
		 * introducimos.
		 */
		try {
			while ((linea = br.readLine()) != null) {
				if (linea.equals("CATEGORIA")) {
					br.readLine();
					String parcial = br.readLine();
					numLinea += 3;
					String[] part = parcial.split(";");
					nDao.insertNewCategoria(new Categorias(Integer.parseInt(part[0]), part[1], part[2]));
					numLinea++;
				} else if (linea.equals("PROVEEDORES")) {
					br.readLine();
					String parcial = null;
					numLinea += 2;
					while (!(parcial = br.readLine()).isBlank()) {
						numLinea++;
						String[] part = parcial.split(";");
						nDao.insertNewProovedores(new Proveedores(Integer.parseInt(part[0]), part[1], part[2]));
					}
					numLinea++;
				} else if (linea.equals("PRODUCTOS")) {
					br.readLine();
					String parcial = null;
					numLinea += 2;
					while (!(parcial = br.readLine()).isBlank()) {
						numLinea++;
						String[] part = parcial.split(";");
						nDao.insertNewProductos(new Productos(Integer.parseInt(part[0]), part[1],
								Integer.parseInt(part[2]), Integer.parseInt(part[3]), part[4],
								Double.parseDouble(part[5]), Integer.parseInt(part[6]), Integer.parseInt(part[7]),
								Integer.parseInt(part[8]), Integer.parseInt(part[9])));
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error de lectura en archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de insercion de datos, linea: " + numLinea);
			try {
				nDao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				nDao.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
