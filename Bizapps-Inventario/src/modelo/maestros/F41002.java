package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F41002PK;


/**
 * The persistent class for the F41002 database table.
 * 
 */
@Entity
public class F41002 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F41002PK id;

	@Column(name="UMCNV1")
	private double umcnv1;

	@Column(name="UMCONV")
	private double umconv;

	@Column(name="UMEXPO")
	private Object umexpo;

	@Column(name="UMEXSO")
	private Object umexso;

	@Column(name="UMJOBN")
	private Object umjobn;

	@Column(name="UMPID")
	private Object umpid;

	@Column(name="UMPUPC")
	private BigDecimal umpupc;

	@Column(name="UMSEPC")
	private BigDecimal umsepc;

	@Column(name="UMTDAY")
	private double umtday;

	@Column(name="UMUPMJ")
	private BigDecimal umupmj;

	@Column(name="UMUSER")
	private Object umuser;

	@Column(name="UMUSTR")
	private Object umustr;

	public F41002() {
	}

	public F41002PK getId() {
		return this.id;
	}

	public void setId(F41002PK id) {
		this.id = id;
	}

	public double getUmcnv1() {
		return this.umcnv1;
	}

	public void setUmcnv1(double umcnv1) {
		this.umcnv1 = umcnv1;
	}

	public double getUmconv() {
		return this.umconv;
	}

	public void setUmconv(double umconv) {
		this.umconv = umconv;
	}

	public Object getUmexpo() {
		return this.umexpo;
	}

	public void setUmexpo(Object umexpo) {
		this.umexpo = umexpo;
	}

	public Object getUmexso() {
		return this.umexso;
	}

	public void setUmexso(Object umexso) {
		this.umexso = umexso;
	}

	public Object getUmjobn() {
		return this.umjobn;
	}

	public void setUmjobn(Object umjobn) {
		this.umjobn = umjobn;
	}

	public Object getUmpid() {
		return this.umpid;
	}

	public void setUmpid(Object umpid) {
		this.umpid = umpid;
	}

	public BigDecimal getUmpupc() {
		return this.umpupc;
	}

	public void setUmpupc(BigDecimal umpupc) {
		this.umpupc = umpupc;
	}

	public BigDecimal getUmsepc() {
		return this.umsepc;
	}

	public void setUmsepc(BigDecimal umsepc) {
		this.umsepc = umsepc;
	}

	public double getUmtday() {
		return this.umtday;
	}

	public void setUmtday(double umtday) {
		this.umtday = umtday;
	}

	public BigDecimal getUmupmj() {
		return this.umupmj;
	}

	public void setUmupmj(BigDecimal umupmj) {
		this.umupmj = umupmj;
	}

	public Object getUmuser() {
		return this.umuser;
	}

	public void setUmuser(Object umuser) {
		this.umuser = umuser;
	}

	public Object getUmustr() {
		return this.umustr;
	}

	public void setUmustr(Object umustr) {
		this.umustr = umustr;
	}

}