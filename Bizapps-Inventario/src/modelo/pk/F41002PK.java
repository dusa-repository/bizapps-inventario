package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F41002 database table.
 * 
 */
@Embeddable
public class F41002PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	//CODIGO
	@Column(name="UMMCU")
	private String ummcu;

	//F4101
	@Column(name="UMITM")
	private double umitm;

	//
	@Column(name="UMUM")
	private String umum;

	//
	@Column(name="UMRUM")
	private String umrum;

	public F41002PK() {
	}
	public String getUmmcu() {
		return this.ummcu;
	}
	public void setUmmcu(String ummcu) {
		this.ummcu = ummcu;
	}
	public double getUmitm() {
		return this.umitm;
	}
	public void setUmitm(double umitm) {
		this.umitm = umitm;
	}
	public String getUmum() {
		return this.umum;
	}
	public void setUmum(String umum) {
		this.umum = umum;
	}
	public String getUmrum() {
		return this.umrum;
	}
	public void setUmrum(String umrum) {
		this.umrum = umrum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F41002PK)) {
			return false;
		}
		F41002PK castOther = (F41002PK)other;
		return 
			this.ummcu.equals(castOther.ummcu)
			&& (this.umitm == castOther.umitm)
			&& this.umum.equals(castOther.umum)
			&& this.umrum.equals(castOther.umrum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ummcu.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.umitm) ^ (java.lang.Double.doubleToLongBits(this.umitm) >>> 32)));
		hash = hash * prime + this.umum.hashCode();
		hash = hash * prime + this.umrum.hashCode();
		
		return hash;
	}
}