package hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import hibernate.persistence.dao.VehiculoDaoImpl;
import hibernate.persistence.interfaces.VehiculoDaoI;
import hibernate.services.interfaces.VehiculoManagmentServiceI;
import models.Vehiculo;

public class VehiculoManagmentServiceImpl implements VehiculoManagmentServiceI {

	private VehiculoDaoI vehiculoDao;

	public VehiculoManagmentServiceImpl(final Session session) {
		vehiculoDao = new VehiculoDaoImpl(session);
	}

	private boolean verifyVehiculo(Vehiculo vehiculo) {
		return (vehiculo != null && vehiculo.getId() != 0);
	}

	public void insertNewVehiculo(Vehiculo newVehiculo) {
		if (verifyVehiculo(newVehiculo))
			vehiculoDao.insert(newVehiculo);
	}

	public void updateVehiculo(Vehiculo updatedVehiculo) {
		if (verifyVehiculo(updatedVehiculo))
			vehiculoDao.update(updatedVehiculo);
	}

	public void deleteVehiculo(Vehiculo deltedVehiculo) {
		if (verifyVehiculo(deltedVehiculo))
			vehiculoDao.delete(deltedVehiculo);
	}

	public Vehiculo searchById(int vehiculoId) {
		Vehiculo vehiculo = null;

		if (vehiculoId != 0)
			vehiculo = vehiculoDao.searchById(vehiculoId);

		return vehiculo;
	}

	public List<Vehiculo> searchByMarca(String marca) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		if (!marca.isBlank())
			vehiculos = vehiculoDao.searchByMarca(marca);

		return vehiculos;
	}

	public List<Vehiculo> searchByModelo(String modelo) {
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		if (!modelo.isBlank())
			vehiculos = vehiculoDao.searchByModelo(modelo);

		return vehiculos;
	}
}
