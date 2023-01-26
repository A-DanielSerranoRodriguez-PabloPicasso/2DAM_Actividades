package hibernate.services;

import org.hibernate.Session;

import hibernate.persistence.dao.ClienteDaoImpl;
import hibernate.persistence.interfaces.ClienteDaoI;
import hibernate.services.interfaces.ClienteManagmentServiceI;
import models.Cliente;

public class ClienteManagmentServiceImpl implements ClienteManagmentServiceI {

	private ClienteDaoI clienteDao;

	public ClienteManagmentServiceImpl(final Session session) {
		clienteDao = new ClienteDaoImpl(session);
	}

	private boolean verifyCliente(Cliente cliente) {
		return (cliente != null && cliente.getId() != 0);
	}

	public void insertNewCliente(Cliente newCliente) {
		if (verifyCliente(newCliente))
			clienteDao.insert(newCliente);
	}

	public void updateCliente(Cliente updatedCliente) {
		if (verifyCliente(updatedCliente))
			clienteDao.insert(updatedCliente);
	}

	public void deleteCliente(Cliente deltedCliente) {
		if (verifyCliente(deltedCliente))
			clienteDao.insert(deltedCliente);
	}

	public Cliente searchById(int clienteId) {
		Cliente cliente = null;

		if (clienteId != 0)
			cliente = clienteDao.searchById(clienteId);

		return cliente;
	}

	public Cliente searchByNif(String nif) {
		Cliente cliente = null;

		if (nif != null)
			cliente = clienteDao.searchByNif(nif);

		return cliente;
	}

	public Cliente searchByNombre(String nombre) {
		Cliente cliente = null;

		if (nombre != null)
			cliente = clienteDao.searchByNombre(nombre);

		return cliente;
	}

	public Cliente searchByCorreo(String correo) {
		Cliente cliente = null;

		if (correo != null)
			cliente = clienteDao.searchByCorreo(correo);

		return cliente;
	}

	public Cliente searchByTelefono(String telefono) {
		Cliente cliente = null;

		if (telefono != null)
			cliente = clienteDao.searchByTelefono(telefono);

		return cliente;
	}

}
