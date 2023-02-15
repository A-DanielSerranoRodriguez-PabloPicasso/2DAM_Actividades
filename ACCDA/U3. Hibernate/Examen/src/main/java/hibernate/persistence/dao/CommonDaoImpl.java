package hibernate.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.persistence.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T> {

	private Class<T> entityClass;
	protected Session session;
	private Transaction transaction;

	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		/*
		 * Obtiene la clase a usar.
		 * 
		 * Primero, tenemos que llamar a la propia clase y conseguirla. Despues, obtiene
		 * su superclase generica. Para obtener la clase que usamos en si, obtenemos el
		 * primer argumento de tipo.
		 */
		entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.session = session;
		transaction = this.session.getTransaction();
	}

	/**
	 * Comienza una transaccion en la base de datos
	 */
	private void beginTransaction() {
		if (!transaction.isActive())
			transaction.begin();
	}

	/**
	 * Finaliza una transaccion en la base de datos
	 */
	private void endTransaction() {
		session.flush();

		if (transaction.isActive())
			transaction.commit();
	}

	@Override
	public void insert(T object) {
		beginTransaction();

		session.save(object);

		endTransaction();
	}

	@Override
	public void update(T object) {
		beginTransaction();

		session.update(object);

		endTransaction();
	}

	@Override
	public void delete(T object) {
		beginTransaction();

		session.delete(object);

		endTransaction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchByIdentifier(String atributo, boolean numeric, Object id) {
		List<T> list;
		T object = null;
		String query = "from " + entityClass.getName() + " where " + atributo + " = ";

		if (numeric)
			query += id;
		else
			query += "'" + id + "'";

		beginTransaction();

		list = session.createQuery(query).list();

		if (list.size() > 0)
			object = list.get(0);

		endTransaction();
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		List<T> list;
		beginTransaction();

		list = session.createQuery("from " + entityClass.getName()).list();

		endTransaction();
		return list;
	}

}