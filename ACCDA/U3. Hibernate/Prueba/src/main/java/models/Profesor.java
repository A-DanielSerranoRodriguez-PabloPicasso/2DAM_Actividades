package models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private Set<CorreoE> correosE;

	public Profesor(int id, String nombre, String ape1, String ape2) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
	}

	public void setCorreosE(Set<CorreoE> correos) {
		correosE = correos;
	}

}
