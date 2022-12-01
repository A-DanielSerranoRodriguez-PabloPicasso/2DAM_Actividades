package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {
	@Id
	private int id;
	private String nombre;
	private String ape1;
	private String ape2;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ProfesorModulo", joinColumns = { @JoinColumn(name = "IdProfesor") }, inverseJoinColumns = {
			@JoinColumn(name = "IdModulo") })
	private Set<Modulo> modulos = new HashSet<Modulo>();

	public Profesor(int id, String nombre, String ape1, String ape2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public Set<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
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

	public void addModulo(Modulo modulo) {
		modulos.add(modulo);
	}

}
