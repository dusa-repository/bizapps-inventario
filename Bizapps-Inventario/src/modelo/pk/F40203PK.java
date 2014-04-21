package modelo.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the F40203 database table.
 * 
 */
@Embeddable
public class F40203PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FSDCTO")
	private String fsdcto;

	@Column(name="FSLNTY")
	private String fslnty;

	@Column(name="FSTRTY")
	private String fstrty;

	public F40203PK() {
	}
	public String getFsdcto() {
		return this.fsdcto;
	}
	public void setFsdcto(String fsdcto) {
		this.fsdcto = fsdcto;
	}
	public String getFslnty() {
		return this.fslnty;
	}
	public void setFslnty(String fslnty) {
		this.fslnty = fslnty;
	}
	public String getFstrty() {
		return this.fstrty;
	}
	public void setFstrty(String fstrty) {
		this.fstrty = fstrty;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof F40203PK)) {
			return false;
		}
		F40203PK castOther = (F40203PK)other;
		return 
			this.fsdcto.equals(castOther.fsdcto)
			&& this.fslnty.equals(castOther.fslnty)
			&& this.fstrty.equals(castOther.fstrty);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fsdcto.hashCode();
		hash = hash * prime + this.fslnty.hashCode();
		hash = hash * prime + this.fstrty.hashCode();
		
		return hash;
	}
}