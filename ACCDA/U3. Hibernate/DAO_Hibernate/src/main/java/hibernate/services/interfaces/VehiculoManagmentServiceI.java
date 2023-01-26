package hibernate.services.interfaces;

import java.util.List;

import models.Vehiculo;

public interface VehiculoManagmentServiceI {
	public void insertNewVehiculo(final Vehiculo newVehiculo);
	
	public void updateVehiculo(final Vehiculo updatedVehiculo);
	
	public void deleteVehiculo(final Vehiculo deltedVehiculo);
	
	public Vehiculo searchById(final int vehiculoId);
	
	public List<Vehiculo> searchByMarca(final String marca);
	
	public List<Vehiculo> searchByModelo(final String marca);

	
}
