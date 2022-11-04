package models;

public class Superusuario {
	/**
	 * Atributos de un Superusuario.
	 * 
	 * User es el curso en el que esta + las 2 iniciales del nombre y el primer
	 * apellido.
	 */
	private String nombre, apellidos, user;

	/**
	 * Crea un susperusuario.
	 * 
	 * @param nombre    String
	 * @param apellidos String
	 */
	public Superusuario(String nombre, String apellidos) {
		this.nombre = nombre.trim();
		this.apellidos = apellidos.trim();
		user = "2DAM";
		adjustUser();
	}

	/**
	 * Devuelve el nombre.
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve los apellidos.
	 * 
	 * @return String
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Devuelve el user.
	 * 
	 * @return String
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Ajusta el atributo user para tener las 2 iniciales del nombre y del primer
	 * apellido.
	 */
	private void adjustUser() {
		String newUser = user + nombre.charAt(0) + nombre.charAt(1) + apellidos.charAt(0) + apellidos.charAt(1);

		user = newUser.toUpperCase();
	}

}
