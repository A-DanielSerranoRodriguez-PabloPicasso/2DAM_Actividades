package models;
// Generated 9 dic 2022 9:21:41 by Hibernate Tools 5.5.9.Final

/**
 * DetallesId generated by hbm2java
 */
public class DetallesId implements java.io.Serializable {

	private int pedidoId;
	private int productoId;

	public DetallesId() {
	}

	public DetallesId(int pedidoId, int productoId) {
		this.pedidoId = pedidoId;
		this.productoId = productoId;
	}

	public int getPedidoId() {
		return this.pedidoId;
	}

	public void setPedidoId(int pedidoId) {
		this.pedidoId = pedidoId;
	}

	public int getProductoId() {
		return this.productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetallesId))
			return false;
		DetallesId castOther = (DetallesId) other;

		return (this.getPedidoId() == castOther.getPedidoId()) && (this.getProductoId() == castOther.getProductoId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPedidoId();
		result = 37 * result + this.getProductoId();
		return result;
	}

}
