package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F4108 database table.
 * 
 */
@Embeddable
public class F4108PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="IOLOTN")
	private String iolotn;

	@Column(name="IOITM")
	private Double ioitm;

	@Column(name="IOMCU")
	private String iomcu;

	public F4108PK() {
	}
	public String getIolotn() {
		return this.iolotn;
	}
	public void setIolotn(String iolotn) {
		this.iolotn = iolotn;
	}
	public Double getIoitm() {
		return this.ioitm;
	}
	public void setIoitm(Double ioitm) {
		this.ioitm = ioitm;
	}
	public String getIomcu() {
		return this.iomcu;
	}
	public void setIomcu(String iomcu) {
		this.iomcu = iomcu;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4108PK)) {
			return false;
		}
		F4108PK castOther = (F4108PK)other;
		return 
			this.iolotn.equals(castOther.iolotn)
			&& (this.ioitm == castOther.ioitm)
			&& this.iomcu.equals(castOther.iomcu);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iolotn.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.ioitm) ^ (java.lang.Double.doubleToLongBits(this.ioitm) >>> 32)));
		hash = hash * prime + this.iomcu.hashCode();
		
		return hash;
	}
}