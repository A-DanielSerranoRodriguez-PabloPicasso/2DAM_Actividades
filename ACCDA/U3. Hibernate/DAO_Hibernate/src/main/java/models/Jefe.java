package models;
// Generated 25 ene 2023 9:47:57 by Hibernate Tools 5.5.9.Final

/**
 * Jefe generated by hbm2java
 */
public class Jefe implements java.io.Serializable {

	private int id;
	private Usuario usuario;

	public Jefe() {
	}

	public Jefe(int id) {
		this.id = id;
	}

	public Jefe(int id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
