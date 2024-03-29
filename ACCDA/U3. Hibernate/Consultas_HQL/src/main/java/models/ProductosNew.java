package models;
// Generated 9 dic 2022 9:21:41 by Hibernate Tools 5.5.9.Final

import java.math.BigDecimal;

/**
 * ProductosNew generated by hbm2java
 */
public class ProductosNew implements java.io.Serializable {

	private Integer id;
	private CategoriasNew categoriasNew;
	private ProveedoresNew proveedoresNew;
	private String producto;
	private String cantidadPorUnidad;
	private BigDecimal precioUnidad;
	private Short unidadesExistencia;
	private Short unidadesPedido;
	private Integer nivelNuevoPedido;
	private boolean suspendido;

	public ProductosNew() {
	}

	public ProductosNew(String producto, boolean suspendido) {
		this.producto = producto;
		this.suspendido = suspendido;
	}

	public ProductosNew(CategoriasNew categoriasNew, ProveedoresNew proveedoresNew, String producto,
			String cantidadPorUnidad, BigDecimal precioUnidad, Short unidadesExistencia, Short unidadesPedido,
			Integer nivelNuevoPedido, boolean suspendido) {
		this.categoriasNew = categoriasNew;
		this.proveedoresNew = proveedoresNew;
		this.producto = producto;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.precioUnidad = precioUnidad;
		this.unidadesExistencia = unidadesExistencia;
		this.unidadesPedido = unidadesPedido;
		this.nivelNuevoPedido = nivelNuevoPedido;
		this.suspendido = suspendido;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoriasNew getCategoriasNew() {
		return this.categoriasNew;
	}

	public void setCategoriasNew(CategoriasNew categoriasNew) {
		this.categoriasNew = categoriasNew;
	}

	public ProveedoresNew getProveedoresNew() {
		return this.proveedoresNew;
	}

	public void setProveedoresNew(ProveedoresNew proveedoresNew) {
		this.proveedoresNew = proveedoresNew;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCantidadPorUnidad() {
		return this.cantidadPorUnidad;
	}

	public void setCantidadPorUnidad(String cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}

	public BigDecimal getPrecioUnidad() {
		return this.precioUnidad;
	}

	public void setPrecioUnidad(BigDecimal precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public Short getUnidadesExistencia() {
		return this.unidadesExistencia;
	}

	public void setUnidadesExistencia(Short unidadesExistencia) {
		this.unidadesExistencia = unidadesExistencia;
	}

	public Short getUnidadesPedido() {
		return this.unidadesPedido;
	}

	public void setUnidadesPedido(Short unidadesPedido) {
		this.unidadesPedido = unidadesPedido;
	}

	public Integer getNivelNuevoPedido() {
		return this.nivelNuevoPedido;
	}

	public void setNivelNuevoPedido(Integer nivelNuevoPedido) {
		this.nivelNuevoPedido = nivelNuevoPedido;
	}

	public boolean isSuspendido() {
		return this.suspendido;
	}

	public void setSuspendido(boolean suspendido) {
		this.suspendido = suspendido;
	}

}
