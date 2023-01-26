package hibernate.persistence.interfaces;

import models.Cliente;

public interface ClienteDaoI extends CommonDaoI<Cliente> {
	
	public Cliente searchById(final int id);

	public Cliente searchByNif(final String nif);

	public Cliente searchByNombre(final String nombre);

	public Cliente searchByCorreo(final String correo);

	public Cliente searchByTelefono(final String telefono);

}
