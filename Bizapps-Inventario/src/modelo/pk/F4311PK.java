package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F4311 database table.
 * 
 */
@Embeddable
public class F4311PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PDDOCO")
	private double pddoco;

	@Column(name="PDDCTO")
	private String pddcto;

	@Column(name="PDKCOO")
	private String pdkcoo;

	@Column(name="PDSFXO")
	private String pdsfxo;

	@Column(name="PDLNID")
	private double pdlnid;

	public F4311PK() {
	}
	public double getPddoco() {
		return this.pddoco;
	}
	public void setPddoco(double pddoco) {
		this.pddoco = pddoco;
	}
	public String getPddcto() {
		return this.pddcto;
	}
	public void setPddcto(String pddcto) {
		this.pddcto = pddcto;
	}
	public String getPdkcoo() {
		return this.pdkcoo;
	}
	public void setPdkcoo(String pdkcoo) {
		this.pdkcoo = pdkcoo;
	}
	public String getPdsfxo() {
		return this.pdsfxo;
	}
	public void setPdsfxo(String pdsfxo) {
		this.pdsfxo = pdsfxo;
	}
	public double getPdlnid() {
		return this.pdlnid;
	}
	public void setPdlnid(double pdlnid) {
		this.pdlnid = pdlnid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4311PK)) {
			return false;
		}
		F4311PK castOther = (F4311PK)other;
		return 
			(this.pddoco == castOther.pddoco)
			&& this.pddcto.equals(castOther.pddcto)
			&& this.pdkcoo.equals(castOther.pdkcoo)
			&& this.pdsfxo.equals(castOther.pdsfxo)
			&& (this.pdlnid == castOther.pdlnid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.pddoco) ^ (java.lang.Double.doubleToLongBits(this.pddoco) >>> 32)));
		hash = hash * prime + this.pddcto.hashCode();
		hash = hash * prime + this.pdkcoo.hashCode();
		hash = hash * prime + this.pdsfxo.hashCode();
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.pdlnid) ^ (java.lang.Double.doubleToLongBits(this.pdlnid) >>> 32)));
		
		return hash;
	}
}