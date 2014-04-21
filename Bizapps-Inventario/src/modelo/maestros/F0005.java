package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0005PK;


/**
 * The persistent class for the F0005 database table.
 * 
 */
@Entity
public class F0005 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0005PK id;

	@Column(name="DRDL01")
	private Object drdl01;

	@Column(name="DRDL02")
	private Object drdl02;

	@Column(name="DRHRDC")
	private Object drhrdc;

	@Column(name="DRJOBN")
	private Object drjobn;

	@Column(name="DRPID")
	private Object drpid;

	@Column(name="DRSPHD")
	private Object drsphd;

	@Column(name="DRUDCO")
	private Object drudco;

	@Column(name="DRUPMJ")
	private BigDecimal drupmj;

	@Column(name="DRUPMT")
	private double drupmt;

	@Column(name="DRUSER")
	private Object druser;

	public F0005() {
	}

	public F0005PK getId() {
		return this.id;
	}

	public void setId(F0005PK id) {
		this.id = id;
	}

	public Object getDrdl01() {
		return this.drdl01;
	}

	public void setDrdl01(Object drdl01) {
		this.drdl01 = drdl01;
	}

	public Object getDrdl02() {
		return this.drdl02;
	}

	public void setDrdl02(Object drdl02) {
		this.drdl02 = drdl02;
	}

	public Object getDrhrdc() {
		return this.drhrdc;
	}

	public void setDrhrdc(Object drhrdc) {
		this.drhrdc = drhrdc;
	}

	public Object getDrjobn() {
		return this.drjobn;
	}

	public void setDrjobn(Object drjobn) {
		this.drjobn = drjobn;
	}

	public Object getDrpid() {
		return this.drpid;
	}

	public void setDrpid(Object drpid) {
		this.drpid = drpid;
	}

	public Object getDrsphd() {
		return this.drsphd;
	}

	public void setDrsphd(Object drsphd) {
		this.drsphd = drsphd;
	}

	public Object getDrudco() {
		return this.drudco;
	}

	public void setDrudco(Object drudco) {
		this.drudco = drudco;
	}

	public BigDecimal getDrupmj() {
		return this.drupmj;
	}

	public void setDrupmj(BigDecimal drupmj) {
		this.drupmj = drupmj;
	}

	public double getDrupmt() {
		return this.drupmt;
	}

	public void setDrupmt(double drupmt) {
		this.drupmt = drupmt;
	}

	public Object getDruser() {
		return this.druser;
	}

	public void setDruser(Object druser) {
		this.druser = druser;
	}

}