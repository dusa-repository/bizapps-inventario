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
	private Double umcnv1;

	//
	@Column(name="UMCONV")
	private Double umconv;

	//
	@Column(name="UMEXPO")
	private String umexpo;

	//
	@Column(name="UMEXSO")
	private String umexso;

	@Column(name="UMJOBN")
	private String umjobn;

	@Column(name="UMPID")
	private String umpid;

	//
	@Column(name="UMPUPC")
	private BigDecimal umpupc;

	//
	@Column(name="UMSEPC")
	private BigDecimal umsepc;

	@Column(name="UMTDAY")
	private Double umtday;

	//
	@Column(name="UMUPMJ")
	private BigDecimal umupmj;

	//
	@Column(name="UMUSER")
	private String umuser;

	//
	@Column(name="UMUSTR")
	private String umustr;

	public F41002() {
	}

	public F41002PK getId() {
		return this.id;
	}

	public void setId(F41002PK id) {
		this.id = id;
	}

	public Double getUmcnv1() {
		return this.umcnv1;
	}

	public void setUmcnv1(Double umcnv1) {
		this.umcnv1 = umcnv1;
	}

	public Double getUmconv() {
		return this.umconv;
	}

	public void setUmconv(Double umconv) {
		this.umconv = umconv;
	}

	public String getUmexpo() {
		return this.umexpo;
	}

	public void setUmexpo(String umexpo) {
		this.umexpo = umexpo;
	}

	public String getUmexso() {
		return this.umexso;
	}

	public void setUmexso(String umexso) {
		this.umexso = umexso;
	}

	public String getUmjobn() {
		return this.umjobn;
	}

	public void setUmjobn(String umjobn) {
		this.umjobn = umjobn;
	}

	public String getUmpid() {
		return this.umpid;
	}

	public void setUmpid(String umpid) {
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

	public Double getUmtday() {
		return this.umtday;
	}

	public void setUmtday(Double umtday) {
		this.umtday = umtday;
	}

	public BigDecimal getUmupmj() {
		return this.umupmj;
	}

	public void setUmupmj(BigDecimal umupmj) {
		this.umupmj = umupmj;
	}

	public String getUmuser() {
		return this.umuser;
	}

	public void setUmuser(String umuser) {
		this.umuser = umuser;
	}

	public String getUmustr() {
		return this.umustr;
	}

	public void setUmustr(String umustr) {
		this.umustr = umustr;
	}

}