package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F01151 database table.
 * 
 */
@Embeddable
public class F01151PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EAAN8")
	private double eaan8;

	@Column(name="EAIDLN")
	private double eaidln;

	@Column(name="EARCK7")
	private double earck7;

	public F01151PK() {
	}
	public double getEaan8() {
		return this.eaan8;
	}
	public void setEaan8(double eaan8) {
		this.eaan8 = eaan8;
	}
	public double getEaidln() {
		return this.eaidln;
	}
	public void setEaidln(double eaidln) {
		this.eaidln = eaidln;
	}
	public double getEarck7() {
		return this.earck7;
	}
	public void setEarck7(double earck7) {
		this.earck7 = earck7;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F01151PK)) {
			return false;
		}
		F01151PK castOther = (F01151PK)other;
		return 
			(this.eaan8 == castOther.eaan8)
			&& (this.eaidln == castOther.eaidln)
			&& (this.earck7 == castOther.earck7);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.eaan8) ^ (java.lang.Double.doubleToLongBits(this.eaan8) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.eaidln) ^ (java.lang.Double.doubleToLongBits(this.eaidln) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.earck7) ^ (java.lang.Double.doubleToLongBits(this.earck7) >>> 32)));
		
		return hash;
	}
}