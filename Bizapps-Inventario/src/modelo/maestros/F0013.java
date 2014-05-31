package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the F0013 database table.
 * 
 */
@Entity
public class F0013 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CVCRCD")
	private String cvcrcd;

	@Column(name="CVCDEC")
	private String cvcdec;

	@Column(name="CVCKR")
	private String cvckr;

	@Column(name="CVDL01")
	private String cvdl01;

	@Column(name="CVEC")
	private String cvec;

	@Column(name="CVJOBN")
	private String cvjobn;

	@Column(name="CVPID")
	private String cvpid;

	@Column(name="CVUPMJ")
	private BigDecimal cvupmj;

	@Column(name="CVUPMT")
	private Double cvupmt;

	@Column(name="CVUSER")
	private String cvuser;

	public F0013() {
	}

	public String getCvcrcd() {
		return this.cvcrcd;
	}

	public void setCvcrcd(String cvcrcd) {
		this.cvcrcd = cvcrcd;
	}

	public String getCvcdec() {
		return this.cvcdec;
	}

	public void setCvcdec(String cvcdec) {
		this.cvcdec = cvcdec;
	}

	public String getCvckr() {
		return this.cvckr;
	}

	public void setCvckr(String cvckr) {
		this.cvckr = cvckr;
	}

	public String getCvdl01() {
		return this.cvdl01;
	}

	public void setCvdl01(String cvdl01) {
		this.cvdl01 = cvdl01;
	}

	public String getCvec() {
		return this.cvec;
	}

	public void setCvec(String cvec) {
		this.cvec = cvec;
	}

	public String getCvjobn() {
		return this.cvjobn;
	}

	public void setCvjobn(String cvjobn) {
		this.cvjobn = cvjobn;
	}

	public String getCvpid() {
		return this.cvpid;
	}

	public void setCvpid(String cvpid) {
		this.cvpid = cvpid;
	}

	public BigDecimal getCvupmj() {
		return this.cvupmj;
	}

	public void setCvupmj(BigDecimal cvupmj) {
		this.cvupmj = cvupmj;
	}

	public double getCvupmt() {
		return this.cvupmt;
	}

	public void setCvupmt(Double cvupmt) {
		this.cvupmt = cvupmt;
	}

	public String getCvuser() {
		return this.cvuser;
	}

	public void setCvuser(String cvuser) {
		this.cvuser = cvuser;
	}

}