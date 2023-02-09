package hibernate.persistence.dao;

import org.hibernate.Session;

import hibernate.persistence.EmpleadoDao;
import hibernate.persistence.models.Empleado;

public class EmpleadoDaoImpl extends CommonDaoImpl<Empleado> implements EmpleadoDao {

	public EmpleadoDaoImpl(Session session) {
		super(session);
	}

	@Override
	public Empleado searchByDniEmpleado(String dni) {
		return searchByIdentifier("dni_empleado", false, dni);
	}

}
