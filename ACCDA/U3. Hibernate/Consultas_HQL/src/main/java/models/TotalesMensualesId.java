package models;
// Generated 9 dic 2022 9:21:41 by Hibernate Tools 5.5.9.Final

import java.math.BigInteger;
import java.util.Date;

/**
 * TotalesMensualesId generated by hbm2java
 */
public class TotalesMensualesId implements java.io.Serializable {

	private Integer anyo;
	private Integer mes;
	private Date fecha;
	private BigInteger cargo;
	private Double importe;
	private Double total;
	private long numPedidos;

	public TotalesMensualesId() {
	}

	public TotalesMensualesId(long numPedidos) {
		this.numPedidos = numPedidos;
	}

	public TotalesMensualesId(Integer anyo, Integer mes, Date fecha, BigInteger cargo, Double importe, Double total,
			long numPedidos) {
		this.anyo = anyo;
		this.mes = mes;
		this.fecha = fecha;
		this.cargo = cargo;
		this.importe = importe;
		this.total = total;
		this.numPedidos = numPedidos;
	}

	public Integer getAnyo() {
		return this.anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public Integer getMes() {
		return this.mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigInteger getCargo() {
		return this.cargo;
	}

	public void setCargo(BigInteger cargo) {
		this.cargo = cargo;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public long getNumPedidos() {
		return this.numPedidos;
	}

	public void setNumPedidos(long numPedidos) {
		this.numPedidos = numPedidos;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TotalesMensualesId))
			return false;
		TotalesMensualesId castOther = (TotalesMensualesId) other;

		return ((this.getAnyo() == castOther.getAnyo()) || (this.getAnyo() != null && castOther.getAnyo() != null
				&& this.getAnyo().equals(castOther.getAnyo())))
				&& ((this.getMes() == castOther.getMes()) || (this.getMes() != null && castOther.getMes() != null
						&& this.getMes().equals(castOther.getMes())))
				&& ((this.getFecha() == castOther.getFecha()) || (this.getFecha() != null
						&& castOther.getFecha() != null && this.getFecha().equals(castOther.getFecha())))
				&& ((this.getCargo() == castOther.getCargo()) || (this.getCargo() != null
						&& castOther.getCargo() != null && this.getCargo().equals(castOther.getCargo())))
				&& ((this.getImporte() == castOther.getImporte()) || (this.getImporte() != null
						&& castOther.getImporte() != null && this.getImporte().equals(castOther.getImporte())))
				&& ((this.getTotal() == castOther.getTotal()) || (this.getTotal() != null
						&& castOther.getTotal() != null && this.getTotal().equals(castOther.getTotal())))
				&& (this.getNumPedidos() == castOther.getNumPedidos());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAnyo() == null ? 0 : this.getAnyo().hashCode());
		result = 37 * result + (getMes() == null ? 0 : this.getMes().hashCode());
		result = 37 * result + (getFecha() == null ? 0 : this.getFecha().hashCode());
		result = 37 * result + (getCargo() == null ? 0 : this.getCargo().hashCode());
		result = 37 * result + (getImporte() == null ? 0 : this.getImporte().hashCode());
		result = 37 * result + (getTotal() == null ? 0 : this.getTotal().hashCode());
		result = 37 * result + (int) this.getNumPedidos();
		return result;
	}

}
