package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "superusuarios")
public class SuperUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = -1;
	private String nombre;
	private String apellidos;
	private String user;

	/**
	 * Creates a "SuperUsuario"
	 * 
	 * @param nombre    String
	 * @param apellidos String
	 */
	public SuperUsuario(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		user();
	}

	/**
	 * Obtains the ID. Empty when generated, assigned when inserted in BBDD by
	 * Hibernate.
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Obtains the name.
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtains the surnames.
	 * 
	 * @return String
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Obtains the user identification. A shuffle between a fixed "String" (2DAM)
	 * and the first 2 letters of the name and first surname.
	 * 
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Generates the user identification. A shuffle between a fixed "String" (2DAM)
	 * and the first 2 letters of the name and first surname.
	 */
	private void user() {
		user = "2dam" + nombre.charAt(0) + nombre.charAt(1) + apellidos.charAt(0) + apellidos.charAt(1);
		user = user.toUpperCase();
	}

}
