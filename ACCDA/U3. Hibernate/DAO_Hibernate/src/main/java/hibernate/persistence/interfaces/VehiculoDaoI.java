package hibernate.persistence.interfaces;

import java.util.List;

import models.Vehiculo;

public interface VehiculoDaoI extends CommonDaoI<Vehiculo>{

	public List<Vehiculo> searchByMarca(final String marca);
	
	public List<Vehiculo> searchByModelo(final String modelo);
	
}
