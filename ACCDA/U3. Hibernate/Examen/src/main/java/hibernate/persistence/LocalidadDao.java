package hibernate.persistence;

import hibernate.persistence.models.Localidad;

public interface LocalidadDao extends CommonDao<Localidad> {

	/**
	 * Busca una localidad por su codigo de localidad
	 * 
	 * @param cod int
	 * @return Localidad
	 */
	public Localidad searchByCodLocalidad(final int cod);

	/**
	 * Busca una localidad por su nombre
	 * 
	 * @param nombre String
	 * @return Localidad
	 */
	public Localidad searchByNombre(final String nombre);

}
