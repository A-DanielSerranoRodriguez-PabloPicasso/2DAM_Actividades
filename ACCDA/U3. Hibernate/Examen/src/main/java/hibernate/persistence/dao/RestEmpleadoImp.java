package hibernate.persistence.dao;

import org.hibernate.Session;

import hibernate.persistence.RestEmpleadoDao;
import hibernate.persistence.models.RestEmpleado;

public class RestEmpleadoImp extends CommonDaoImpl<RestEmpleado> implements RestEmpleadoDao {

	public RestEmpleadoImp(Session session) {
		super(session);
	}

	@Override
	public RestEmpleado searchByEmpleadoDni(String dni) {
		return searchByIdentifier("dni_empleado", false, dni);
	}

}
