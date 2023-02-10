package hibernate.persistence;

import hibernate.persistence.models.Empleado;

public interface EmpleadoDao extends CommonDao<Empleado> {

	/**
	 * Busca un empleado por su DNI
	 * 
	 * @param dni String
	 * @return Empleado
	 */
	public Empleado searchByDniEmpleado(String dni);

}
