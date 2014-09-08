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
	private Double wpan8;

	@Column(name="WPIDLN")
	private Double wpidln;

	@Column(name="WPCNLN")
	private Double wpcnln;

	@Column(name="WPRCK7")
	private Double wprck7;

	public F0115PK() {
	}
	public Double getWpan8() {
		return this.wpan8;
	}
	public void setWpan8(Double wpan8) {
		this.wpan8 = wpan8;
	}
	public Double getWpidln() {
		return this.wpidln;
	}
	public void setWpidln(Double wpidln) {
		this.wpidln = wpidln;
	}
	public Double getWpcnln() {
		return this.wpcnln;
	}
	public void setWpcnln(Double wpcnln) {
		this.wpcnln = wpcnln;
	}
	public Double getWprck7() {
		return this.wprck7;
	}
	public void setWprck7(Double wprck7) {
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