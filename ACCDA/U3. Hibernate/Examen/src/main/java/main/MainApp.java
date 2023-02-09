package main;

import java.util.Date;

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

		/*
		 * TODO
		 * 
		 * Crear empleado
		 * 
		 * Asignar ese empleado al restaurante
		 * 
		 * Asignar empleado con DNI 11111111H como camarero
		 */

		// ###################################################

		/*
		 * Comprobamos que Malaga (cod_localidad = 420) existe. Si no existe, lo
		 * insertamos, si existe, lo dejamos como esta
		 */
		LocalidadDao locDao = new LocalidadDaoImpl(HibernateUtils.getSession());

		Localidad localidad = locDao.searchByIdentifier("cod_localidad", true, 420);

		if (localidad == null) {
			locDao.insert(new Localidad(420, "Malaga"));
			localidad = locDao.searchByIdentifier("cod_localidad", true, 420);
		}

		// ###################################################

		/*
		 * Creamos 2 restaurantes en malaga
		 * 
		 * Primero comprobamos que existen, si no existen los creamos, si existen los
		 * dejamos
		 */

		RestauranteDao restDao = new RestauranteDaoImpl(HibernateUtils.getSession());
		Restaurante rest = restDao.searchByCodRest("69");

		if (rest == null) {
			rest = new Restaurante("69", locDao.searchByCodLocalidad(420), "El Deo", "ABC123", new Date(),
					"L-M 9:30 a 10:00");
			restDao.insert(rest);
		}

		rest = restDao.searchByCodRest("420");

		if (rest == null) {
			rest = new Restaurante("420", locDao.searchByCodLocalidad(420), "La Biznaga", "ZYX987", new Date(),
					"L-D 8:00 a 23:00");
			restDao.insert(rest);
		}

		// ###################################################

		/*
		 * Creamos empleado si no existe
		 */

		EmpleadoDao empDao = new EmpleadoDaoImpl(HibernateUtils.getSession());
		Empleado emp = empDao.searchByDniEmpleado("12345678D");

		if (emp == null) {
			emp = new Empleado("12345678D", "Dani", new Date());
			empDao.insert(emp);
		}

		/*
		 * Añadimos el empleado a un restaurante con la funcion que queramos.
		 * 
		 * Asignamos a 11111111H como CAMARERO
		 */

		RestEmpleadoId restEmpId = new RestEmpleadoId("420", "12345678D");
		RestEmpleado restEmp = new RestEmpleado(restEmpId, emp, "Cocinero", rest);

		RestEmpleadoDao restEmpDao = new RestEmpleadoImp(HibernateUtils.getSession());

//		restEmpDao.insert(restEmp);

//		restEmpDao.insert(new RestEmpleado(new RestEmpleadoId("420", "11111111H"),
//				empDao.searchByDniEmpleado("11111111H"), "CAMARERO", rest));

		/*
		 * Filtros
		 * 
		 * - Nombre, fecha_apertura, horarios
		 * 
		 * - Nombre localidad
		 */

		HibernateUtils.getSession().close();
	}

}
