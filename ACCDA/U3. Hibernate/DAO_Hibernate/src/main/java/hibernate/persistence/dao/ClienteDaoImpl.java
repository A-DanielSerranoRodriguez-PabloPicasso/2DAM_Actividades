package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.persistence.interfaces.ClienteDaoI;
import models.Cliente;

public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	private Session session;

	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	private void checkActiveTransaction() {
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
	}

	public Cliente searchByNif(String nif) {
		checkActiveTransaction();
		List<Cliente> lista = session.createQuery("from cliente where nif ='" + nif + "'").list();
		return lista.get(0);
	}

	public Cliente searchByNombre(String nombre) {
		checkActiveTransaction();
		List<Cliente> lista = session.createQuery("from cliente where nombre ='" + nombre + "'").list();
		return lista.get(0);
	}

	public Cliente searchByCorreo(String correo) {
		checkActiveTransaction();
		List<Cliente> lista = session.createQuery("from cliente where correo ='" + correo + "'").list();
		return lista.get(0);
	}

	public Cliente searchByTelefono(String telefono) {
		checkActiveTransaction();
		List<Cliente> lista = session.createQuery("from cliente where telefono ='" + telefono + "'").list();
		return lista.get(0);
	}

}
