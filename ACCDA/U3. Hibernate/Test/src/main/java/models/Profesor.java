package models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {
	@Id
	private int id;

	private String nombre;

	@Column(name = "primer_apellido")
	private String ape1;

	@Column(name = "segundo_apellido")
	private String ape2;

	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
	private Set<Correo> correos;

	public Profesor() {

	}

	public Profesor(int id, String nombre, String ape1, String ape2) {
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public Set<Correo> getCorreos() {
		return correos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public void setCorreos(Set<Correo> correos) {
		this.correos = correos;
	}
}
