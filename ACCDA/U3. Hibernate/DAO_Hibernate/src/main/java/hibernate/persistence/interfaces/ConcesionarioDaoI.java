package hibernate.persistence.interfaces;

import java.util.Set;

import models.Concesionario;
import models.Vehiculo;

public interface ConcesionarioDaoI extends CommonDaoI<Concesionario> {

	public Concesionario searchByNombre(final String nombre);

	public Concesionario searchByDireccion(final String direccion);

	public Concesionario searchByContacto(final String contacto);

	public Set<Vehiculo> getVehiculos();

}
