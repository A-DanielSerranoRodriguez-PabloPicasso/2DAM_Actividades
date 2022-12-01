package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {
	@Id
	@Column(name = "IdModulo")
	private int id;
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "modulos")
	private Set<Profesor> profesores = new HashSet<Profesor>();

	public Modulo(int idModulo, String nombre) {
		super();
		this.id = idModulo;
		this.nombre = nombre;
	}

	public int getIdModulo() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void addProfesor(Profesor profesor) {
		profesores.add(profesor);
	}

}
