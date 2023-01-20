package hibernate.persistence.interfaces;

import java.util.Set;

import models.Cliente;
import models.Proposicion;
import models.Vehiculo;

public interface ClienteDaoI extends CommonDaoI<Cliente> {

	public Cliente searchByNif(final String nif);

	public Cliente searchByNombre(final String nombre);

	public Cliente searchByApellidos(final String apellidos);

	public Cliente searchByCorreo(final String correo);

	public Cliente searchByTelefono(final String telefono);

	public Cliente searchByDireccion(final String direccion);

	public Set<Vehiculo> getVehiculos();

	public Set<Proposicion> getProposiones();

}
