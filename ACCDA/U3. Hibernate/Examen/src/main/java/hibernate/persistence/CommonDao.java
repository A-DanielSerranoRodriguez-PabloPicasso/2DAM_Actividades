package hibernate.persistence;

import java.util.List;

public interface CommonDao<T> {

	public void insert(final T object);
	
	public void update(final T object);

	public void delete(final T object);

	public T searchByIdentifier(final String identifier, final boolean numeric, final Object id);

	public List<T> searchAll();
}
