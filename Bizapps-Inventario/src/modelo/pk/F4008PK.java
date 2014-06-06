package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F4008 database table.
 * 
 */
@Embeddable
public class F4008PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	//
	@Column(name="TATXA1")
	private String tatxa1;

	//
	@Column(name="TAITM")
	private double taitm;

	// f venci
	@Column(name="TAEFDJ")
	private long taefdj;

	public F4008PK() {
	}
	public String getTatxa1() {
		return this.tatxa1;
	}
	public void setTatxa1(String tatxa1) {
		this.tatxa1 = tatxa1;
	}
	public double getTaitm() {
		return this.taitm;
	}
	public void setTaitm(double taitm) {
		this.taitm = taitm;
	}
	public long getTaefdj() {
		return this.taefdj;
	}
	public void setTaefdj(long taefdj) {
		this.taefdj = taefdj;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4008PK)) {
			return false;
		}
		F4008PK castOther = (F4008PK)other;
		return 
			this.tatxa1.equals(castOther.tatxa1)
			&& (this.taitm == castOther.taitm)
			&& (this.taefdj == castOther.taefdj);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tatxa1.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.taitm) ^ (java.lang.Double.doubleToLongBits(this.taitm) >>> 32)));
		hash = hash * prime + ((int) (this.taefdj ^ (this.taefdj >>> 32)));
		
		return hash;
	}
}