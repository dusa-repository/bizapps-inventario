package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0015PK;


/**
 * The persistent class for the F0015 database table.
 * 
 */
@Entity
public class F0015 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0015PK id;

	@Column(name="CXCLMETH")
	private Object cxclmeth;

	@Column(name="CXCRCM")
	private Object cxcrcm;

	@Column(name="CXCRR")
	private double cxcrr;

	@Column(name="CXCRRD")
	private double cxcrrd;

	@Column(name="CXCSR")
	private Object cxcsr;

	@Column(name="CXJOBN")
	private Object cxjobn;

	@Column(name="CXPID")
	private Object cxpid;

	@Column(name="CXTRCR")
	private Object cxtrcr;

	@Column(name="CXUPMJ")
	private BigDecimal cxupmj;

	@Column(name="CXUPMT")
	private double cxupmt;

	@Column(name="CXUSER")
	private Object cxuser;

	public F0015() {
	}

	public F0015PK getId() {
		return this.id;
	}

	public void setId(F0015PK id) {
		this.id = id;
	}

	public Object getCxclmeth() {
		return this.cxclmeth;
	}

	public void setCxclmeth(Object cxclmeth) {
		this.cxclmeth = cxclmeth;
	}

	public Object getCxcrcm() {
		return this.cxcrcm;
	}

	public void setCxcrcm(Object cxcrcm) {
		this.cxcrcm = cxcrcm;
	}

	public double getCxcrr() {
		return this.cxcrr;
	}

	public void setCxcrr(double cxcrr) {
		this.cxcrr = cxcrr;
	}

	public double getCxcrrd() {
		return this.cxcrrd;
	}

	public void setCxcrrd(double cxcrrd) {
		this.cxcrrd = cxcrrd;
	}

	public Object getCxcsr() {
		return this.cxcsr;
	}

	public void setCxcsr(Object cxcsr) {
		this.cxcsr = cxcsr;
	}

	public Object getCxjobn() {
		return this.cxjobn;
	}

	public void setCxjobn(Object cxjobn) {
		this.cxjobn = cxjobn;
	}

	public Object getCxpid() {
		return this.cxpid;
	}

	public void setCxpid(Object cxpid) {
		this.cxpid = cxpid;
	}

	public Object getCxtrcr() {
		return this.cxtrcr;
	}

	public void setCxtrcr(Object cxtrcr) {
		this.cxtrcr = cxtrcr;
	}

	public BigDecimal getCxupmj() {
		return this.cxupmj;
	}

	public void setCxupmj(BigDecimal cxupmj) {
		this.cxupmj = cxupmj;
	}

	public double getCxupmt() {
		return this.cxupmt;
	}

	public void setCxupmt(double cxupmt) {
		this.cxupmt = cxupmt;
	}

	public Object getCxuser() {
		return this.cxuser;
	}

	public void setCxuser(Object cxuser) {
		this.cxuser = cxuser;
	}

}