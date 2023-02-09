package hibernate.persistence.dao;

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

}
