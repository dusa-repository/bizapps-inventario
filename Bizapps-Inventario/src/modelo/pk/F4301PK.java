package modelo.pk;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The primary key class for the F4301 database table.
 * 
 */
@Embeddable
public class F4301PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PHDOCO")
	private double phdoco;

	@Column(name="PHDCTO")
	private String phdcto;

	@Column(name="PHKCOO")
	private String phkcoo;

	@Column(name="PHSFXO")
	private String phsfxo;

	public F4301PK() {
		phsfxo = "NOT NULL";
	}
	public double getPhdoco() {
		return this.phdoco;
	}
	public void setPhdoco(double phdoco) {
		this.phdoco = phdoco;
	}
	public String getPhdcto() {
		return this.phdcto;
	}
	public void setPhdcto(String phdcto) {
		this.phdcto = phdcto;
	}
	public String getPhkcoo() {
		return this.phkcoo;
	}
	public void setPhkcoo(String phkcoo) {
		this.phkcoo = phkcoo;
	}
	public String getPhsfxo() {
		return this.phsfxo;
	}
	public void setPhsfxo(String phsfxo) {
		this.phsfxo = phsfxo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4301PK)) {
			return false;
		}
		F4301PK castOther = (F4301PK)other;
		return 
			(this.phdoco == castOther.phdoco)
			&& this.phdcto.equals(castOther.phdcto)
			&& this.phkcoo.equals(castOther.phkcoo)
			&& this.phsfxo.equals(castOther.phsfxo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.phdoco) ^ (java.lang.Double.doubleToLongBits(this.phdoco) >>> 32)));
		hash = hash * prime + this.phdcto.hashCode();
		hash = hash * prime + this.phkcoo.hashCode();
		hash = hash * prime + this.phsfxo.hashCode();
		
		return hash;
	}
	@Override
	public String toString() {
		return "ID";
	}
	
	
}