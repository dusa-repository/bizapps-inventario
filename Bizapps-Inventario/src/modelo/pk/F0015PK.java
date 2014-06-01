package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F0015 database table.
 * 
 */
@Embeddable
public class F0015PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CXCRCD")
	private String cxcrcd;

	@Column(name="CXCRDC")
	private String cxcrdc;

	@Column(name="CXAN8")
	private Double cxan8;

	@Column(name="CXRTTYP")
	private String cxrttyp;

	@Column(name="CXEFT")
	private Long cxeft;

	public F0015PK() {
	}
	public String getCxcrcd() {
		return this.cxcrcd;
	}
	public void setCxcrcd(String cxcrcd) {
		this.cxcrcd = cxcrcd;
	}
	public String getCxcrdc() {
		return this.cxcrdc;
	}
	public void setCxcrdc(String cxcrdc) {
		this.cxcrdc = cxcrdc;
	}
	public Double getCxan8() {
		return this.cxan8;
	}
	public void setCxan8(Double cxan8) {
		this.cxan8 = cxan8;
	}
	public String getCxrttyp() {
		return this.cxrttyp;
	}
	public void setCxrttyp(String cxrttyp) {
		this.cxrttyp = cxrttyp;
	}
	public Long getCxeft() {
		return this.cxeft;
	}
	public void setCxeft(Long cxeft) {
		this.cxeft = cxeft;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F0015PK)) {
			return false;
		}
		F0015PK castOther = (F0015PK)other;
		return 
			this.cxcrcd.equals(castOther.cxcrcd)
			&& this.cxcrdc.equals(castOther.cxcrdc)
			&& (this.cxan8 == castOther.cxan8)
			&& this.cxrttyp.equals(castOther.cxrttyp)
			&& (this.cxeft == castOther.cxeft);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cxcrcd.hashCode();
		hash = hash * prime + this.cxcrdc.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.cxan8) ^ (java.lang.Double.doubleToLongBits(this.cxan8) >>> 32)));
		hash = hash * prime + this.cxrttyp.hashCode();
		hash = hash * prime + ((int) (this.cxeft ^ (this.cxeft >>> 32)));
		
		return hash;
	}
}