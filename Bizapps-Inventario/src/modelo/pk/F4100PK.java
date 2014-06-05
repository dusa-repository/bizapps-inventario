package modelo.pk;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the F4100 database table.
 * 
 */
@Embeddable
public class F4100PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="LMMCU")
	private String lmmcu;

	@Column(name="LMLOCN")
	private String lmlocn;

	public F4100PK() {
	}
	public String getLmmcu() {
		return this.lmmcu;
	}
	public void setLmmcu(String lmmcu) {
		this.lmmcu = lmmcu;
	}
	public String getLmlocn() {
		return this.lmlocn;
	}
	public void setLmlocn(String lmlocn) {
		this.lmlocn = lmlocn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F4100PK)) {
			return false;
		}
		F4100PK castOther = (F4100PK)other;
		return 
			this.lmmcu.equals(castOther.lmmcu)
			&& this.lmlocn.equals(castOther.lmlocn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.lmmcu.hashCode();
		hash = hash * prime + this.lmlocn.hashCode();
		
		return hash;
	}
}