package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F01151PK;


/**
 * The persistent class for the F01151 database table.
 * 
 */
@Entity
public class F01151 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F01151PK id;

	@Column(name="EACAAD")
	private Double eacaad;

	@Column(name="EACFNO1")
	private Double eacfno1;

	@Column(name="EAECLASS")
	private String eaeclass;

	@Column(name="EAEFOR")
	private String eaefor;

	@Column(name="EAEHIER")
	private Double eaehier;

	@Column(name="EAEMAL")
	private String eaemal;

	@Column(name="EAETP")
	private String eaetp;

	@Column(name="EAFALGE")
	private String eafalge;

	@Column(name="EAGEN1")
	private String eagen1;

	@Column(name="EAJOBN")
	private String eajobn;

	@Column(name="EAPID")
	private String eapid;

	@Column(name="EASYNCS")
	private Double easyncs;

	@Column(name="EAUPMJ")
	private BigDecimal eaupmj;

	@Column(name="EAUPMT")
	private Double eaupmt;

	@Column(name="EAUSER")
	private String eauser;

	public F01151() {
	}

	public F01151PK getId() {
		return this.id;
	}

	public void setId(F01151PK id) {
		this.id = id;
	}

	public Double getEacaad() {
		return this.eacaad;
	}

	public void setEacaad(Double eacaad) {
		this.eacaad = eacaad;
	}

	public Double getEacfno1() {
		return this.eacfno1;
	}

	public void setEacfno1(Double eacfno1) {
		this.eacfno1 = eacfno1;
	}

	public String getEaeclass() {
		return this.eaeclass;
	}

	public void setEaeclass(String eaeclass) {
		this.eaeclass = eaeclass;
	}

	public String getEaefor() {
		return this.eaefor;
	}

	public void setEaefor(String eaefor) {
		this.eaefor = eaefor;
	}

	public Double getEaehier() {
		return this.eaehier;
	}

	public void setEaehier(Double eaehier) {
		this.eaehier = eaehier;
	}

	public String getEaemal() {
		return this.eaemal;
	}

	public void setEaemal(String eaemal) {
		this.eaemal = eaemal;
	}

	public String getEaetp() {
		return this.eaetp;
	}

	public void setEaetp(String eaetp) {
		this.eaetp = eaetp;
	}

	public String getEafalge() {
		return this.eafalge;
	}

	public void setEafalge(String eafalge) {
		this.eafalge = eafalge;
	}

	public String getEagen1() {
		return this.eagen1;
	}

	public void setEagen1(String eagen1) {
		this.eagen1 = eagen1;
	}

	public String getEajobn() {
		return this.eajobn;
	}

	public void setEajobn(String eajobn) {
		this.eajobn = eajobn;
	}

	public String getEapid() {
		return this.eapid;
	}

	public void setEapid(String eapid) {
		this.eapid = eapid;
	}

	public Double getEasyncs() {
		return this.easyncs;
	}

	public void setEasyncs(Double easyncs) {
		this.easyncs = easyncs;
	}

	public BigDecimal getEaupmj() {
		return this.eaupmj;
	}

	public void setEaupmj(BigDecimal eaupmj) {
		this.eaupmj = eaupmj;
	}

	public Double getEaupmt() {
		return this.eaupmt;
	}

	public void setEaupmt(Double eaupmt) {
		this.eaupmt = eaupmt;
	}

	public String getEauser() {
		return this.eauser;
	}

	public void setEauser(String eauser) {
		this.eauser = eauser;
	}

}