package models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "correos_electronicos")
public class Correo implements Serializable {
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_profesor")
	private Profesor profesor;
	private String direccion;

	public Correo() {

	}

	public Correo(Profesor profesor, int id, String direccion) {
		this.profesor = profesor;
		this.id = id;
		this.direccion = direccion;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
