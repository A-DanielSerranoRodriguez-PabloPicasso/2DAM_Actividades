package hibernate.services.interfaces;

import models.Cliente;

public interface ClienteManagmentServiceI {
	public void insertNewCliente(final Cliente newCliente);

	public void updateCliente(final Cliente updatedCliente);

	public void deleteCliente(final Cliente deltedCliente);

	public Cliente searchById(final int clienteId);

	public Cliente searchByNif(final String nif);

	public Cliente searchByNombre(final String nombre);

	public Cliente searchByCorreo(final String correo);

	public Cliente searchByTelefono(final String telefono);

}
