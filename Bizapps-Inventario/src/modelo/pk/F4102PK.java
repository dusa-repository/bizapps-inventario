package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F4102 database table.
 * 
 */
@Embeddable
public class F4102PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="IBMCU")
	private String ibmcu;

	@Column(name="IBITM")
	private Double ibitm;

	public F4102PK() {
	}
	public String getIbmcu() {
		return this.ibmcu;
	}
	public void setIbmcu(String ibmcu) {
		this.ibmcu = ibmcu;
	}
	public Double getIbitm() {
		return this.ibitm;
	}
	public void setIbitm(Double ibitm) {
		this.ibitm = ibitm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4102PK)) {
			return false;
		}
		F4102PK castOther = (F4102PK)other;
		return 
			this.ibmcu.equals(castOther.ibmcu)
			&& (this.ibitm == castOther.ibitm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ibmcu.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.ibitm) ^ (java.lang.Double.doubleToLongBits(this.ibitm) >>> 32)));
		
		return hash;
	}
}