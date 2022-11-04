package model;

public class Categoria {
	/**
	 * Atributos de la clase categoria.
	 */
	private String categoria, descripcion;

	/**
	 * Construye una categoria
	 * @param categoria String
	 * @param descripcion String
	 */
	public Categoria(String categoria, String descripcion) {
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el nombre de la categoria.
	 * @return
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Devuelve la descripcion de la categoria.
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [categoria=" + categoria + ", descripcion=" + descripcion + "]";
	}
}
