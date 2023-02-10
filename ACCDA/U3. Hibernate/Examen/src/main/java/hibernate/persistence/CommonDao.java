package hibernate.persistence;

import java.util.List;

public interface CommonDao<T> {

	/**
	 * Inserta el objeto en la base de datos
	 * 
	 * @param object T
	 */
	public void insert(final T object);

	/**
	 * Actualiza el objeto en la base de datos
	 * 
	 * @param object T
	 */
	public void update(final T object);

	/**
	 * Elimina el objeto de la base de datos
	 * 
	 * @param object T
	 */
	public void delete(final T object);

	/**
	 * Busca un objeto en la base de datos
	 * 
	 * @param atributo Columna en la que buscar
	 * @param numeric  Booleano que indica si la columna tiene un valor numerico o
	 *                 no
	 * @param id       Object con el objeto por el que vamos a buscar (1, "hola",
	 *                 etc)
	 * @return T
	 */
	public T searchByIdentifier(final String atributo, final boolean numeric, final Object id);

	/**
	 * Recoge todos los objetos de la base de datos
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

}
