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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CVCRCD")
	private String cvcrcd;

	@Column(name="CVCDEC")
	private Object cvcdec;

	@Column(name="CVCKR")
	private Object cvckr;

	@Column(name="CVDL01")
	private Object cvdl01;

	@Column(name="CVEC")
	private Object cvec;

	@Column(name="CVJOBN")
	private Object cvjobn;

	@Column(name="CVPID")
	private Object cvpid;

	@Column(name="CVUPMJ")
	private BigDecimal cvupmj;

	@Column(name="CVUPMT")
	private double cvupmt;

	@Column(name="CVUSER")
	private Object cvuser;

	public F0013() {
	}

	public String getCvcrcd() {
		return this.cvcrcd;
	}

	public void setCvcrcd(String cvcrcd) {
		this.cvcrcd = cvcrcd;
	}

	public Object getCvcdec() {
		return this.cvcdec;
	}

	public void setCvcdec(Object cvcdec) {
		this.cvcdec = cvcdec;
	}

	public Object getCvckr() {
		return this.cvckr;
	}

	public void setCvckr(Object cvckr) {
		this.cvckr = cvckr;
	}

	public Object getCvdl01() {
		return this.cvdl01;
	}

	public void setCvdl01(Object cvdl01) {
		this.cvdl01 = cvdl01;
	}

	public Object getCvec() {
		return this.cvec;
	}

	public void setCvec(Object cvec) {
		this.cvec = cvec;
	}

	public Object getCvjobn() {
		return this.cvjobn;
	}

	public void setCvjobn(Object cvjobn) {
		this.cvjobn = cvjobn;
	}

	public Object getCvpid() {
		return this.cvpid;
	}

	public void setCvpid(Object cvpid) {
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

	public void setCvupmt(double cvupmt) {
		this.cvupmt = cvupmt;
	}

	public Object getCvuser() {
		return this.cvuser;
	}

	public void setCvuser(Object cvuser) {
		this.cvuser = cvuser;
	}

}