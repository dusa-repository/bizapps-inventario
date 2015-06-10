package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F0111 database table.
 * 
 */
@Embeddable
public class F0111PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="WWAN8")
	private double wwan8;

	@Column(name="WWIDLN")
	private double wwidln;

	public F0111PK() {
	}
	public double getWwan8() {
		return this.wwan8;
	}
	public void setWwan8(double wwan8) {
		this.wwan8 = wwan8;
	}
	public double getWwidln() {
		return this.wwidln;
	}
	public void setWwidln(double wwidln) {
		this.wwidln = wwidln;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F0111PK)) {
			return false;
		}
		F0111PK castOther = (F0111PK)other;
		return 
			(this.wwan8 == castOther.wwan8)
			&& (this.wwidln == castOther.wwidln);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wwan8) ^ (java.lang.Double.doubleToLongBits(this.wwan8) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wwidln) ^ (java.lang.Double.doubleToLongBits(this.wwidln) >>> 32)));
		
		return hash;
	}
}