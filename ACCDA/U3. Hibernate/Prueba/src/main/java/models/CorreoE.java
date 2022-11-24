package models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "correo_electronico")
public class CorreoE implements Serializable {
	@Id
	private int id;
	private String direccion;
	@ManyToOne
	@JoinColumn(name = "id_profesor")
	private Profesor profesor;

	public CorreoE(int id, String direccion, Profesor profesor) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.profesor = profesor;
	}

}
