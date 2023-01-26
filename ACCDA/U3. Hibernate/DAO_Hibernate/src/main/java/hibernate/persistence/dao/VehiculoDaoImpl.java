package hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.persistence.interfaces.VehiculoDaoI;
import models.Vehiculo;

public class VehiculoDaoImpl extends CommonDaoImpl<Vehiculo> implements VehiculoDaoI {

	private Session session;

	public VehiculoDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	public List<Vehiculo> searchByMarca(String marca) {
		checkActiveTransaction();
		return session.createQuery("from vehiculo where marca ='" + marca + "'").list();
	}

	public List<Vehiculo> searchByModelo(String modelo) {
		checkActiveTransaction();
		return session.createQuery("from vehiculo where modelo ='" + modelo + "'").list();
	}

	private void checkActiveTransaction() {
		Transaction transaction = session.getTransaction();
		if (!transaction.isActive())
			transaction.begin();
	}

}
