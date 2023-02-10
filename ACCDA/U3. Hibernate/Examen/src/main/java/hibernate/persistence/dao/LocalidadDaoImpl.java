package hibernate.persistence.dao;

import org.hibernate.Session;

import hibernate.persistence.LocalidadDao;
import hibernate.persistence.models.Localidad;

public class LocalidadDaoImpl extends CommonDaoImpl<Localidad> implements LocalidadDao {

	public LocalidadDaoImpl(Session session) {
		super(session);
	}

	public Localidad searchByCodLocalidad(int cod) {
		return searchByIdentifier("cod_localidad", true, cod);
	}

	@Override
	public Localidad searchByNombre(String nombre) {
		return searchByIdentifier("nombre", false, nombre);
	}

}
