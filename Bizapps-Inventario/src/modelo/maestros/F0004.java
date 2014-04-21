package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0004PK;


/**
 * The persistent class for the F0004 database table.
 * 
 */
@Entity
public class F0004 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0004PK id;

	@Column(name="DTCDL")
	private double dtcdl;

	@Column(name="DTCNUM")
	private Object dtcnum;

	@Column(name="DTDL01")
	private Object dtdl01;

	@Column(name="DTJOBN")
	private Object dtjobn;

	@Column(name="DTLN2")
	private Object dtln2;

	@Column(name="DTMRCT")
	private Object dtmrct;

	@Column(name="DTMRTY")
	private Object dtmrty;

	@Column(name="DTPID")
	private Object dtpid;

	@Column(name="DTUCD1")
	private Object dtucd1;

	@Column(name="DTUPMJ")
	private BigDecimal dtupmj;

	@Column(name="DTUPMT")
	private double dtupmt;

	@Column(name="DTUSEQ")
	private double dtuseq;

	@Column(name="DTUSER")
	private Object dtuser;

	public F0004() {
	}

	public F0004PK getId() {
		return this.id;
	}

	public void setId(F0004PK id) {
		this.id = id;
	}

	public double getDtcdl() {
		return this.dtcdl;
	}

	public void setDtcdl(double dtcdl) {
		this.dtcdl = dtcdl;
	}

	public Object getDtcnum() {
		return this.dtcnum;
	}

	public void setDtcnum(Object dtcnum) {
		this.dtcnum = dtcnum;
	}

	public Object getDtdl01() {
		return this.dtdl01;
	}

	public void setDtdl01(Object dtdl01) {
		this.dtdl01 = dtdl01;
	}

	public Object getDtjobn() {
		return this.dtjobn;
	}

	public void setDtjobn(Object dtjobn) {
		this.dtjobn = dtjobn;
	}

	public Object getDtln2() {
		return this.dtln2;
	}

	public void setDtln2(Object dtln2) {
		this.dtln2 = dtln2;
	}

	public Object getDtmrct() {
		return this.dtmrct;
	}

	public void setDtmrct(Object dtmrct) {
		this.dtmrct = dtmrct;
	}

	public Object getDtmrty() {
		return this.dtmrty;
	}

	public void setDtmrty(Object dtmrty) {
		this.dtmrty = dtmrty;
	}

	public Object getDtpid() {
		return this.dtpid;
	}

	public void setDtpid(Object dtpid) {
		this.dtpid = dtpid;
	}

	public Object getDtucd1() {
		return this.dtucd1;
	}

	public void setDtucd1(Object dtucd1) {
		this.dtucd1 = dtucd1;
	}

	public BigDecimal getDtupmj() {
		return this.dtupmj;
	}

	public void setDtupmj(BigDecimal dtupmj) {
		this.dtupmj = dtupmj;
	}

	public double getDtupmt() {
		return this.dtupmt;
	}

	public void setDtupmt(double dtupmt) {
		this.dtupmt = dtupmt;
	}

	public double getDtuseq() {
		return this.dtuseq;
	}

	public void setDtuseq(double dtuseq) {
		this.dtuseq = dtuseq;
	}

	public Object getDtuser() {
		return this.dtuser;
	}

	public void setDtuser(Object dtuser) {
		this.dtuser = dtuser;
	}

}