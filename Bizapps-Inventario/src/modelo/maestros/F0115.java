package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0115PK;


/**
 * The persistent class for the F0115 database table.
 * 
 */
@Entity
public class F0115 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0115PK id;

	@Column(name="WPAR1")
	private String wpar1;

	@Column(name="WPCAAD")
	private Double wpcaad;

	@Column(name="WPCFNO1")
	private Double wpcfno1;

	@Column(name="WPFALGE")
	private String wpfalge;

	@Column(name="WPGEN1")
	private String wpgen1;

	@Column(name="WPJOBN")
	private String wpjobn;

	@Column(name="WPPH1")
	private String wpph1;

	@Column(name="WPPHTP")
	private String wpphtp;

	@Column(name="WPPID")
	private String wppid;

	@Column(name="WPSYNCS")
	private Double wpsyncs;

	@Column(name="WPUPMJ")
	private BigDecimal wpupmj;

	@Column(name="WPUPMT")
	private Double wpupmt;

	@Column(name="WPUSER")
	private String wpuser;

	public F0115() {
	}

	public F0115PK getId() {
		return this.id;
	}

	public void setId(F0115PK id) {
		this.id = id;
	}

	public String getWpar1() {
		return this.wpar1;
	}

	public void setWpar1(String wpar1) {
		this.wpar1 = wpar1;
	}

	public Double getWpcaad() {
		return this.wpcaad;
	}

	public void setWpcaad(Double wpcaad) {
		this.wpcaad = wpcaad;
	}

	public Double getWpcfno1() {
		return this.wpcfno1;
	}

	public void setWpcfno1(Double wpcfno1) {
		this.wpcfno1 = wpcfno1;
	}

	public String getWpfalge() {
		return this.wpfalge;
	}

	public void setWpfalge(String wpfalge) {
		this.wpfalge = wpfalge;
	}

	public String getWpgen1() {
		return this.wpgen1;
	}

	public void setWpgen1(String wpgen1) {
		this.wpgen1 = wpgen1;
	}

	public String getWpjobn() {
		return this.wpjobn;
	}

	public void setWpjobn(String wpjobn) {
		this.wpjobn = wpjobn;
	}

	public String getWpph1() {
		return this.wpph1;
	}

	public void setWpph1(String wpph1) {
		this.wpph1 = wpph1;
	}

	public String getWpphtp() {
		return this.wpphtp;
	}

	public void setWpphtp(String wpphtp) {
		this.wpphtp = wpphtp;
	}

	public String getWppid() {
		return this.wppid;
	}

	public void setWppid(String wppid) {
		this.wppid = wppid;
	}

	public Double getWpsyncs() {
		return this.wpsyncs;
	}

	public void setWpsyncs(Double wpsyncs) {
		this.wpsyncs = wpsyncs;
	}

	public BigDecimal getWpupmj() {
		return this.wpupmj;
	}

	public void setWpupmj(BigDecimal wpupmj) {
		this.wpupmj = wpupmj;
	}

	public Double getWpupmt() {
		return this.wpupmt;
	}

	public void setWpupmt(Double wpupmt) {
		this.wpupmt = wpupmt;
	}

	public String getWpuser() {
		return this.wpuser;
	}

	public void setWpuser(String wpuser) {
		this.wpuser = wpuser;
	}

}