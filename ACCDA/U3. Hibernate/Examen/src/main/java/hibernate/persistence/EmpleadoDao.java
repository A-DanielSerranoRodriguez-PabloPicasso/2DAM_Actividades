package hibernate.persistence;

import hibernate.persistence.models.Empleado;

public interface EmpleadoDao extends CommonDao<Empleado> {
	
	public Empleado searchByDniEmpleado(String dni);
	
}
