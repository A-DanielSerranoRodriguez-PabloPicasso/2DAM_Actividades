package hibernate.persistence.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.persistence.interfaces.CommonDaoI;
import hibernate.persistence.models.AbstractEntity;

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	private Class<T> entityClass;

	private Session session;

	private Transaction transaction;

	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
		transaction = session.getTransaction();
	}

	public void insert(final T param) {
		beginTransacction();

		session.save(param);
		session.flush();

		transaction.commit();
	}

	public void update(final T param) {
		beginTransacction();

		session.saveOrUpdate(param);

		transaction.commit();
	}

	public void delete(final T param) {
		beginTransacction();

		session.delete(param);

		transaction.commit();
	}

	public T searchById(final Long id) {
		beginTransacction();

		return (T) session.get(entityClass.getName(), id);
	}
 
	public List<T> searchAll() {
		beginTransacction();

		return session.createQuery("select T from " + this.entityClass.getName()).list();
	}

	public void beginTransacction() {
		if (!transaction.isActive())
			transaction.begin();
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
