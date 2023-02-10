package main;

import java.util.Date;
import java.util.List;
import java.util.Set;

import hibernate.persistence.EmpleadoDao;
import hibernate.persistence.LocalidadDao;
import hibernate.persistence.RestEmpleadoDao;
import hibernate.persistence.RestauranteDao;
import hibernate.persistence.dao.EmpleadoDaoImpl;
import hibernate.persistence.dao.LocalidadDaoImpl;
import hibernate.persistence.dao.RestEmpleadoImp;
import hibernate.persistence.dao.RestauranteDaoImpl;
import hibernate.persistence.models.Empleado;
import hibernate.persistence.models.Localidad;
import hibernate.persistence.models.RestEmpleado;
import hibernate.persistence.models.RestEmpleadoId;
import hibernate.persistence.models.Restaurante;
import hibernate.utils.HibernateUtils;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * TODO DAO RESTAURANTE
		 * 
		 * Consultas:
		 * 
		 * - Mostrar con filtros de nombre, fecha_apertura y horario
		 * 
		 * - Mostrar con filtro de localidad -> mostrar datos empleados de cada
		 * restaurante
		 */

		// ###################################################

		/*
		 * Comprobamos que Malaga (cod_localidad = 420) existe. Si no existe, lo
		 * insertamos, si existe, lo dejamos como esta
		 */
		System.out.println("\n1. Insertar localidad\n");
		LocalidadDao locDao = new LocalidadDaoImpl(HibernateUtils.getSession());

		System.out.println("Buscando localidad: Malaga");
		Localidad localidad = locDao.searchByIdentifier("cod_localidad", true, 420);

		if (localidad == null) {
			System.out.println("Localidad no encontrada, insertando");
			locDao.insert(new Localidad(420, "Malaga"));
			localidad = locDao.searchByIdentifier("cod_localidad", true, 420);
		} else
			System.out.println("Localidad encontrada, no se ha hecho nada");
		System.out.println();

		// ###################################################

		/*
		 * Creamos 2 restaurantes en malaga
		 * 
		 * Primero comprobamos que existen, si no existen los creamos, si existen los
		 * dejamos
		 */
		System.out.println("\n2. Insertar restaurantes\n");

		RestauranteDao restDao = new RestauranteDaoImpl(HibernateUtils.getSession());

		System.out.println("Buscando restaurante: El Deo");
		Restaurante rest = restDao.searchByCodRest("69");

		if (rest == null) {
			System.out.println("Restaurante no encontrado, insertando");
			rest = new Restaurante("69", locDao.searchByCodLocalidad(420), "El Deo", "ABC123", new Date(),
					"L-M 9:30 a 10:00");
			restDao.insert(rest);
		} else
			System.out.println("Restaurante encontrado, no se ha hecho nada");

		System.out.println("Buscando restaurante: La Biznaga");
		rest = restDao.searchByCodRest("420");

		if (rest == null) {
			System.out.println("Restaurante no encontrado, insertando");
			rest = new Restaurante("420", locDao.searchByCodLocalidad(420), "La Biznaga", "ZYX987", new Date(),
					"L-D 8:00 a 23:00");
			restDao.insert(rest);
		} else
			System.out.println("Restaurante encontrado, no se ha hecho nada");
		System.out.println();

		// ###################################################

		/*
		 * Creamos empleado si no existe
		 */
		System.out.println("\n3. Insertar empleado\n");
		EmpleadoDao empDao = new EmpleadoDaoImpl(HibernateUtils.getSession());
		System.out.println("Buscando empleado: Dani");
		Empleado emp = empDao.searchByDniEmpleado("12345678D");

		if (emp == null) {
			System.out.println("Empleado no encontrado, insertando");
			emp = new Empleado("12345678D", "Dani", new Date());
			empDao.insert(emp);
		} else
			System.out.println("Empleado encontrado, no se ha hecho nada");
		System.out.println();

		/*
		 * Añadimos el empleado a un restaurante con la funcion que queramos.
		 * 
		 * Asignamos a 11111111H como CAMARERO
		 */
		System.out.println("\n4. Insertar empleados como trabajadores en un restaurante\n");
		RestEmpleadoDao restEmpDao = new RestEmpleadoImp(HibernateUtils.getSession());
		System.out.println("Buscando trabajador: 1234568D");
		RestEmpleado restEmp = restEmpDao.searchByEmpleadoDni("12345678D");

		if (restEmp == null) {
			System.out.println("Empleado no encontrado, insertando");
			RestEmpleadoId restEmpId = new RestEmpleadoId("420", "12345678D");
			restEmp = new RestEmpleado(restEmpId, emp, "COCINERO", rest);
			restEmpDao.insert(restEmp);
		} else
			System.out.println("Empleado encontrado, no se ha hecho nada");
		System.out.println();

		System.out.println("Buscando trabajador: 1111111H");
		restEmp = restEmpDao.searchByEmpleadoDni("1111111H");

		if (restEmp == null) {
			System.out.println("Empleado no encontrado, insertando");
			restEmpDao.insert(new RestEmpleado(new RestEmpleadoId("420", "1111111H"),
					empDao.searchByDniEmpleado("1111111H"), "CAMARERO", rest));
		} else
			System.out.println("Empleado encontrado, no se ha hecho nada");
		System.out.println();

		/*
		 * Filtros
		 * 
		 * - Nombre, fecha_apertura, horarios
		 * 
		 * - Nombre localidad
		 */
		System.out.println(
				"\n5. Filtrando restaurantes por nombre/fecha apertura/horario (se muestra por fecha en el ejemplo)\n");
		System.out.println("Filtrando restaurantes por fecha: 2023-2-9");
		List<Restaurante> rests = restDao.filterSearchRestDatos(null, "2023-2-9", null);
//		List<Restaurante> rests = restDao.filterSearchRestDatos(null, null, "L-M");
//		List<Restaurante> rests = restDao.filterSearchRestDatos("El Deo", null, null);

		if (rests.size() > 0) {
			System.out.println("Restaurantes encontrados:");
			for (Restaurante restaurante : rests) {
				System.out.println("\t- " + restaurante.getNombre());
			}
		} else
			System.out.println("No existen restaurantes");
		System.out.println();

		System.out.println("\n6. Filtrando restaurantes por localidad\n");
		System.out.println("Filtrando restaurantes por localidad: Malaga");
		rests = restDao.filterSearchRestLocalidad(locDao.searchByNombre("Malaga").getCodLocalidad());

		if (rests.size() > 0) {
			System.out.println("Restaurantes econtrados:");
			for (Restaurante restaurante : rests) {
				Set<RestEmpleado> empleados = restaurante.getRestEmpleados();
				System.out.println("\t- " + restaurante.getNombre());

				if (empleados.size() > 0) {
					System.out.println("\t\t+ Empleados:");
					for (RestEmpleado empleado : empleados) {
						System.out.println("\t\t\t· " + empleado.getEmpleado().getNombre());
					}
				} else
					System.out.println("\t\t+ Sin empleados");
				System.out.println();
			}
		}
		
		HibernateUtils.getSession().close();
	}

}
