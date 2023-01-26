package models;
// Generated 25 ene 2023 9:47:57 by Hibernate Tools 5.5.9.Final

import java.util.HashSet;
import java.util.Set;

import hibernate.persistence.models.AbstractEntity;

/**
 * Cliente generated by hbm2java
 */
public class Cliente extends AbstractEntity implements java.io.Serializable {

	private int id;
	private String nif;
	private String nombre;
	private String apellidos;
	private String correo;
	private String telefono;
	private String direccion;
	private Set vehiculos = new HashSet(0);
	private Set proposicions = new HashSet(0);

	public Cliente() {
	}

	public Cliente(String nif) {
		this.nif = nif;
	}

	public Cliente(String nif, String nombre, String apellidos, String correo, String telefono, String direccion,
			Set vehiculos, Set proposicions) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.vehiculos = vehiculos;
		this.proposicions = proposicions;
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(Set vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Set getProposicions() {
		return this.proposicions;
	}

	public void setProposicions(Set proposicions) {
		this.proposicions = proposicions;
	}

}
