package hibernate.persistence.interfaces;

import java.util.List;

public interface CommonDaoI<T> {

	public void insert(final T param);

	public void update(final T param);

	public void delete(final T param);

	public T searchById(final int id);

	public List<T> searchAll();

}
