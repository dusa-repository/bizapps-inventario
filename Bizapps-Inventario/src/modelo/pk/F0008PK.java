package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F0008 database table.
 * 
 */
@Embeddable
public class F0008PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CDDTPN")
	private String cddtpn;

	@Column(name="CDDFYJ")
	private Long cddfyj;

	@Column(name="CDFQ")
	private String cdfq;

	public F0008PK() {
	}
	public String getCddtpn() {
		return this.cddtpn;
	}
	public void setCddtpn(String cddtpn) {
		this.cddtpn = cddtpn;
	}
	public Long getCddfyj() {
		return this.cddfyj;
	}
	public void setCddfyj(Long cddfyj) {
		this.cddfyj = cddfyj;
	}
	public String getCdfq() {
		return this.cdfq;
	}
	public void setCdfq(String cdfq) {
		this.cdfq = cdfq;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F0008PK)) {
			return false;
		}
		F0008PK castOther = (F0008PK)other;
		return 
			this.cddtpn.equals(castOther.cddtpn)
			&& (this.cddfyj == castOther.cddfyj)
			&& this.cdfq.equals(castOther.cdfq);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cddtpn.hashCode();
		hash = hash * prime + ((int) (this.cddfyj ^ (this.cddfyj >>> 32)));
		hash = hash * prime + this.cdfq.hashCode();
		
		return hash;
	}
}