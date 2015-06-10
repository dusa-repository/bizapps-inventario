package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F49041PK;


/**
 * The persistent class for the F49041 database table.
 * 
 */
@Entity
public class F49041 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F49041PK id;

	@Column(name="VSEXDJ")
	private BigDecimal vsexdj;

	@Column(name="VSJBCD")
	private String vsjbcd;

	@Column(name="VSJOBN")
	private String vsjobn;

	@Column(name="VSMCU")
	private String vsmcu;

	@Column(name="VSPID")
	private String vspid;

	@Column(name="VSTDAY")
	private double vstday;

	@Column(name="VSUPMJ")
	private BigDecimal vsupmj;

	@Column(name="VSUSER")
	private String vsuser;

	@Column(name="VSVEHI")
	private String vsvehi;

	public F49041() {
	}

	public F49041PK getId() {
		return this.id;
	}

	public void setId(F49041PK id) {
		this.id = id;
	}

	public BigDecimal getVsexdj() {
		return this.vsexdj;
	}

	public void setVsexdj(BigDecimal vsexdj) {
		this.vsexdj = vsexdj;
	}

	public String getVsjbcd() {
		return this.vsjbcd;
	}

	public void setVsjbcd(String vsjbcd) {
		this.vsjbcd = vsjbcd;
	}

	public String getVsjobn() {
		return this.vsjobn;
	}

	public void setVsjobn(String vsjobn) {
		this.vsjobn = vsjobn;
	}

	public String getVsmcu() {
		return this.vsmcu;
	}

	public void setVsmcu(String vsmcu) {
		this.vsmcu = vsmcu;
	}

	public String getVspid() {
		return this.vspid;
	}

	public void setVspid(String vspid) {
		this.vspid = vspid;
	}

	public double getVstday() {
		return this.vstday;
	}

	public void setVstday(double vstday) {
		this.vstday = vstday;
	}

	public BigDecimal getVsupmj() {
		return this.vsupmj;
	}

	public void setVsupmj(BigDecimal vsupmj) {
		this.vsupmj = vsupmj;
	}

	public String getVsuser() {
		return this.vsuser;
	}

	public void setVsuser(String vsuser) {
		this.vsuser = vsuser;
	}

	public String getVsvehi() {
		return this.vsvehi;
	}

	public void setVsvehi(String vsvehi) {
		this.vsvehi = vsvehi;
	}

}