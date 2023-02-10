package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;

import hibernate.persistence.RestauranteDao;
import hibernate.persistence.models.Restaurante;

public class RestauranteDaoImpl extends CommonDaoImpl<Restaurante> implements RestauranteDao {

	public RestauranteDaoImpl(Session session) {
		super(session);
	}

	@Override
	public Restaurante searchByCodRest(String cod) {
		return searchByIdentifier("cod_rest", false, cod);
	}

	/**
	 * Ajusta los filtros de la query, eliminando "and" sobrantes y eliminando el
	 * filtro al completo si no se ha introducido ninguno
	 * 
	 * @param filters String
	 * @return String
	 */
	private String trimFilters(String filters) {
		if (filters.substring(filters.length() - 5).equals(" and "))
			filters = filters.substring(0, filters.length() - 5);

		if (filters.matches(" where "))
			filters = "";

		return filters;
	}

	@Override
	public List<Restaurante> filterSearchRestDatos(String nombre, String fecha_apertura, String horario) {
		String query = "from Restaurante", filters = " where ";

		if (nombre != null)
			filters += "nombre = '" + nombre + "' and ";

		if (fecha_apertura != null)
			filters += "fecha_apertura = '" + fecha_apertura + "' and ";

		if (horario != null)
			filters += "horario like '%" + horario + "%'";

		filters = trimFilters(filters);

		return session.createQuery(query + filters).list();
	}

	@Override
	public List<Restaurante> filterSearchRestLocalidad(int localidad) {
		String query = "from Restaurante", filters = " where ";

		if (localidad > 0)
			filters += "cod_localidad = " + localidad;

		filters = trimFilters(filters);

		return session.createQuery(query + filters).list();
	}

}
