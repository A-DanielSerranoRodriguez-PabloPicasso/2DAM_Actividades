package models;
// Generated 25 ene 2023 9:47:57 by Hibernate Tools 5.5.9.Final

import java.util.Date;

/**
 * Repara generated by hbm2java
 */
public class Repara implements java.io.Serializable {

	private ReparaId id;
	private Mecanico mecanico;
	private Vehiculo vehiculo;
	private Double presupuesto;
	private Integer tiempoEstimado;
	private Date fechaLimite;
	private String piezas;
	private String diagnostico;
	private Boolean finalizada;

	public Repara() {
	}

	public Repara(ReparaId id, Mecanico mecanico, Vehiculo vehiculo) {
		this.id = id;
		this.mecanico = mecanico;
		this.vehiculo = vehiculo;
	}

	public Repara(ReparaId id, Mecanico mecanico, Vehiculo vehiculo, Double presupuesto, Integer tiempoEstimado,
			Date fechaLimite, String piezas, String diagnostico, Boolean finalizada) {
		this.id = id;
		this.mecanico = mecanico;
		this.vehiculo = vehiculo;
		this.presupuesto = presupuesto;
		this.tiempoEstimado = tiempoEstimado;
		this.fechaLimite = fechaLimite;
		this.piezas = piezas;
		this.diagnostico = diagnostico;
		this.finalizada = finalizada;
	}

	public ReparaId getId() {
		return this.id;
	}

	public void setId(ReparaId id) {
		this.id = id;
	}

	public Mecanico getMecanico() {
		return this.mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Double getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Integer getTiempoEstimado() {
		return this.tiempoEstimado;
	}

	public void setTiempoEstimado(Integer tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public Date getFechaLimite() {
		return this.fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getPiezas() {
		return this.piezas;
	}

	public void setPiezas(String piezas) {
		this.piezas = piezas;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Boolean getFinalizada() {
		return this.finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

}
