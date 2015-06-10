package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F49041 database table.
 * 
 */
@Embeddable
public class F49041PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VSSTFN")
	private double vsstfn;

	@Column(name="VSSHFT")
	private String vsshft;

	@Column(name="VSEFTJ")
	private long vseftj;

	public F49041PK() {
	}
	public double getVsstfn() {
		return this.vsstfn;
	}
	public void setVsstfn(double vsstfn) {
		this.vsstfn = vsstfn;
	}
	public String getVsshft() {
		return this.vsshft;
	}
	public void setVsshft(String vsshft) {
		this.vsshft = vsshft;
	}
	public long getVseftj() {
		return this.vseftj;
	}
	public void setVseftj(long vseftj) {
		this.vseftj = vseftj;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F49041PK)) {
			return false;
		}
		F49041PK castOther = (F49041PK)other;
		return 
			(this.vsstfn == castOther.vsstfn)
			&& this.vsshft.equals(castOther.vsshft)
			&& (this.vseftj == castOther.vseftj);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.vsstfn) ^ (java.lang.Double.doubleToLongBits(this.vsstfn) >>> 32)));
		hash = hash * prime + this.vsshft.hashCode();
		hash = hash * prime + ((int) (this.vseftj ^ (this.vseftj >>> 32)));
		
		return hash;
	}
}