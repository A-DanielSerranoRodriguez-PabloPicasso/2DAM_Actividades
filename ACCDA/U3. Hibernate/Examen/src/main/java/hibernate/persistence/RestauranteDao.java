package hibernate.persistence;

import hibernate.persistence.models.Restaurante;

public interface RestauranteDao extends CommonDao<Restaurante>{

	public Restaurante searchByCodRest(String cod);
	
}
