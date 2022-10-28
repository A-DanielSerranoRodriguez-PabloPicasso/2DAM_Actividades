package model;

public class Categoria {
	private String categoria, descripcion;

	public Categoria(String categoria, String descripcion) {
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
