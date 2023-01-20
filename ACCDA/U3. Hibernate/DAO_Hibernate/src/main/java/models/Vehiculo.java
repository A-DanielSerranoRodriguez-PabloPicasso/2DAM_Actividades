package models;
// Generated 13 ene 2023 9:28:56 by Hibernate Tools 5.5.9.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Vehiculo generated by hbm2java
 */
public class Vehiculo implements java.io.Serializable {

	private int id;
	private Concesionario concesionario;
	private String nombreComercial;
	private String marca;
	private String modelo;
	private String tipo;
	private String color;
	private Integer potencia;
	private Double precio;
	private Boolean disponible;
	private Integer cantidadStock;
	private Date fechaEntradaConcesionario;
	private Set proposicions = new HashSet(0);
	private Set registroventases = new HashSet(0);
	private Set clientes = new HashSet(0);
	private Set reparas = new HashSet(0);

	public Vehiculo() {
	}

	public Vehiculo(int id, String nombreComercial, String tipo) {
		this.id = id;
		this.nombreComercial = nombreComercial;
		this.tipo = tipo;
	}

	public Vehiculo(int id, Concesionario concesionario, String nombreComercial, String marca, String modelo,
			String tipo, String color, Integer potencia, Double precio, Boolean disponible, Integer cantidadStock,
			Date fechaEntradaConcesionario, Set proposicions, Set registroventases, Set clientes, Set reparas) {
		this.id = id;
		this.concesionario = concesionario;
		this.nombreComercial = nombreComercial;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.color = color;
		this.potencia = potencia;
		this.precio = precio;
		this.disponible = disponible;
		this.cantidadStock = cantidadStock;
		this.fechaEntradaConcesionario = fechaEntradaConcesionario;
		this.proposicions = proposicions;
		this.registroventases = registroventases;
		this.clientes = clientes;
		this.reparas = reparas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Concesionario getConcesionario() {
		return this.concesionario;
	}

	public void setConcesionario(Concesionario concesionario) {
		this.concesionario = concesionario;
	}

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPotencia() {
		return this.potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return this.disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getCantidadStock() {
		return this.cantidadStock;
	}

	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public Date getFechaEntradaConcesionario() {
		return this.fechaEntradaConcesionario;
	}

	public void setFechaEntradaConcesionario(Date fechaEntradaConcesionario) {
		this.fechaEntradaConcesionario = fechaEntradaConcesionario;
	}

	public Set getProposicions() {
		return this.proposicions;
	}

	public void setProposicions(Set proposicions) {
		this.proposicions = proposicions;
	}

	public Set getRegistroventases() {
		return this.registroventases;
	}

	public void setRegistroventases(Set registroventases) {
		this.registroventases = registroventases;
	}

	public Set getClientes() {
		return this.clientes;
	}

	public void setClientes(Set clientes) {
		this.clientes = clientes;
	}

	public Set getReparas() {
		return this.reparas;
	}

	public void setReparas(Set reparas) {
		this.reparas = reparas;
	}

}
