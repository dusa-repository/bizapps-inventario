package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F0115 database table.
 * 
 */
@Embeddable
public class F0115PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="WPAN8")
	private double wpan8;

	@Column(name="WPIDLN")
	private double wpidln;

	@Column(name="WPCNLN")
	private double wpcnln;

	@Column(name="WPRCK7")
	private double wprck7;

	public F0115PK() {
	}
	public double getWpan8() {
		return this.wpan8;
	}
	public void setWpan8(double wpan8) {
		this.wpan8 = wpan8;
	}
	public double getWpidln() {
		return this.wpidln;
	}
	public void setWpidln(double wpidln) {
		this.wpidln = wpidln;
	}
	public double getWpcnln() {
		return this.wpcnln;
	}
	public void setWpcnln(double wpcnln) {
		this.wpcnln = wpcnln;
	}
	public double getWprck7() {
		return this.wprck7;
	}
	public void setWprck7(double wprck7) {
		this.wprck7 = wprck7;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F0115PK)) {
			return false;
		}
		F0115PK castOther = (F0115PK)other;
		return 
			(this.wpan8 == castOther.wpan8)
			&& (this.wpidln == castOther.wpidln)
			&& (this.wpcnln == castOther.wpcnln)
			&& (this.wprck7 == castOther.wprck7);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wpan8) ^ (java.lang.Double.doubleToLongBits(this.wpan8) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wpidln) ^ (java.lang.Double.doubleToLongBits(this.wpidln) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wpcnln) ^ (java.lang.Double.doubleToLongBits(this.wpcnln) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.wprck7) ^ (java.lang.Double.doubleToLongBits(this.wprck7) >>> 32)));
		
		return hash;
	}
}