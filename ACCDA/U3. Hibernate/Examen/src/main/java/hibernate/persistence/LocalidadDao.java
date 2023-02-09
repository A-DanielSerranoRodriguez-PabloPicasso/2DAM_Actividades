package hibernate.persistence;

import hibernate.persistence.models.Localidad;

public interface LocalidadDao extends CommonDao<Localidad>{
	
	public Localidad searchByCodLocalidad(int cod);

}
