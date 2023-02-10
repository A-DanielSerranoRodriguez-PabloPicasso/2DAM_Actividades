package hibernate.persistence;

import hibernate.persistence.models.RestEmpleado;

public interface RestEmpleadoDao extends CommonDao<RestEmpleado> {

	/**
	 * Busca un empleado del restaurante por su DNI
	 * 
	 * @param dni String
	 * @return RestEmpleado
	 */
	public RestEmpleado searchByEmpleadoDni(final String dni);

}
