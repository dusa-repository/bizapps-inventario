package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F0116 database table.
 * 
 */
@Embeddable
public class F0116PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ALAN8")
	private double alan8;

	@Column(name="ALEFTB")
	private long aleftb;

	public F0116PK() {
	}
	public double getAlan8() {
		return this.alan8;
	}
	public void setAlan8(double alan8) {
		this.alan8 = alan8;
	}
	public long getAleftb() {
		return this.aleftb;
	}
	public void setAleftb(long aleftb) {
		this.aleftb = aleftb;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F0116PK)) {
			return false;
		}
		F0116PK castOther = (F0116PK)other;
		return 
			(this.alan8 == castOther.alan8)
			&& (this.aleftb == castOther.aleftb);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.alan8) ^ (java.lang.Double.doubleToLongBits(this.alan8) >>> 32)));
		hash = hash * prime + ((int) (this.aleftb ^ (this.aleftb >>> 32)));
		
		return hash;
	}
}