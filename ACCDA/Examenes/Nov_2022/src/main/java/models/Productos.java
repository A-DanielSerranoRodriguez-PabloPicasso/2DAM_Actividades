package models;

import java.io.Serializable;

/**
 * Model class of productos.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Productos implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Integer id;

	/** producto. */
	private String producto;

	/** proveedor_id. */
	private Integer proveedorId;

	/** categoria_id. */
	private Integer categoriaId;

	/** cantidad_por_unidad. */
	private String cantidadPorUnidad;

	/** precio_unidad. */
	private Double precioUnidad;

	/** unidades_existencia. */
	private Integer unidadesExistencia;

	/** unidades_pedido. */
	private Integer unidadesPedido;

	/** nivel_nuevo_pedido. */
	private Integer nivelNuevoPedido;

	/** suspendido. */
	private Integer suspendido;

	/**
	 * Constructor vacio.
	 */
	public Productos() {
	}

	/**
	 * Constructor completo.
	 */
	public Productos(Integer id, String producto, Integer proveedorId, Integer categoriaId, String cantidadPorUnidad,
			Double precioUnidad, Integer unidadesExistencia, Integer unidadesPedido, Integer nivelNuevoPedido,
			Integer suspendido) {
		this.id = id;
		this.producto = producto;
		this.proveedorId = proveedorId;
		this.categoriaId = categoriaId;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.precioUnidad = precioUnidad;
		this.unidadesExistencia = unidadesExistencia;
		this.unidadesPedido = unidadesPedido;
		this.nivelNuevoPedido = nivelNuevoPedido;
		this.suspendido = suspendido;
	}

	/**
	 * Set the id.
	 * 
	 * @param id id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set the producto.
	 * 
	 * @param producto producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Get the producto.
	 * 
	 * @return producto
	 */
	public String getProducto() {
		return this.producto;
	}

	/**
	 * Set the proveedor_id.
	 * 
	 * @param proveedorId proveedor_id
	 */
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}

	/**
	 * Get the proveedor_id.
	 * 
	 * @return proveedor_id
	 */
	public Integer getProveedorId() {
		return this.proveedorId;
	}

	/**
	 * Set the categoria_id.
	 * 
	 * @param categoriaId categoria_id
	 */
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * Get the categoria_id.
	 * 
	 * @return categoria_id
	 */
	public Integer getCategoriaId() {
		return this.categoriaId;
	}

	/**
	 * Set the cantidad_por_unidad.
	 * 
	 * @param cantidadPorUnidad cantidad_por_unidad
	 */
	public void setCantidadPorUnidad(String cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}

	/**
	 * Get the cantidad_por_unidad.
	 * 
	 * @return cantidad_por_unidad
	 */
	public String getCantidadPorUnidad() {
		return this.cantidadPorUnidad;
	}

	/**
	 * Set the precio_unidad.
	 * 
	 * @param precioUnidad precio_unidad
	 */
	public void setPrecioUnidad(Double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	/**
	 * Get the precio_unidad.
	 * 
	 * @return precio_unidad
	 */
	public Double getPrecioUnidad() {
		return this.precioUnidad;
	}

	/**
	 * Set the unidades_existencia.
	 * 
	 * @param unidadesExistencia unidades_existencia
	 */
	public void setUnidadesExistencia(Integer unidadesExistencia) {
		this.unidadesExistencia = unidadesExistencia;
	}

	/**
	 * Get the unidades_existencia.
	 * 
	 * @return unidades_existencia
	 */
	public Integer getUnidadesExistencia() {
		return this.unidadesExistencia;
	}

	/**
	 * Set the unidades_pedido.
	 * 
	 * @param unidadesPedido unidades_pedido
	 */
	public void setUnidadesPedido(Integer unidadesPedido) {
		this.unidadesPedido = unidadesPedido;
	}

	/**
	 * Get the unidades_pedido.
	 * 
	 * @return unidades_pedido
	 */
	public Integer getUnidadesPedido() {
		return this.unidadesPedido;
	}

	/**
	 * Set the nivel_nuevo_pedido.
	 * 
	 * @param nivelNuevoPedido nivel_nuevo_pedido
	 */
	public void setNivelNuevoPedido(Integer nivelNuevoPedido) {
		this.nivelNuevoPedido = nivelNuevoPedido;
	}

	/**
	 * Get the nivel_nuevo_pedido.
	 * 
	 * @return nivel_nuevo_pedido
	 */
	public Integer getNivelNuevoPedido() {
		return this.nivelNuevoPedido;
	}

	/**
	 * Set the suspendido.
	 * 
	 * @param suspendido suspendido
	 */
	public void setSuspendido(Integer suspendido) {
		this.suspendido = suspendido;
	}

	/**
	 * Get the suspendido.
	 * 
	 * @return suspendido
	 */
	public Integer getSuspendido() {
		return this.suspendido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Productos other = (Productos) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return id + ";" + producto + ";" + proveedorId + ";" + categoriaId + ";" + cantidadPorUnidad + ";"
				+ precioUnidad + ";" + unidadesExistencia + ";" + unidadesPedido + ";" + nivelNuevoPedido + ";"
				+ suspendido;
	}

}
