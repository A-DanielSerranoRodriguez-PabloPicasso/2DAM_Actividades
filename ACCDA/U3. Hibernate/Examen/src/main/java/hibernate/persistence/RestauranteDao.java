package hibernate.persistence;

import java.util.List;

import hibernate.persistence.models.Restaurante;

public interface RestauranteDao extends CommonDao<Restaurante> {

	/**
	 * Busca un restaurante por su codigo de restaurante
	 * 
	 * @param cod String
	 * @return Restaurante
	 */
	public Restaurante searchByCodRest(String cod);

	/**
	 * Realiza una busqueda filtrada de los restaurantes
	 * 
	 * @param nombre        String
	 * @param fecha_apertur String
	 * @param horario       String
	 * @return List<Restaurante>
	 */
	public List<Restaurante> filterSearchRestDatos(final String nombre, final String fecha_apertura,
			final String horario);

	/**
	 * Realiza una busqueda filtrada de los restaurantes
	 * 
	 * @param codLocalidad int
	 * @return List<Restaurante>
	 */
	public List<Restaurante> filterSearchRestLocalidad(final int codLocalidad);
}
