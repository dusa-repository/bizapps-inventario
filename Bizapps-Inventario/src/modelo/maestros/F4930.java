package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the F4930 database table.
 * 
 */
@Entity
public class F4930 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VMVEHI")
	private String vmvehi;

	@Column(name="VMCVOL")
	private double vmcvol;

	@Column(name="VMCVUM")
	private String vmcvum;

	@Column(name="VMDL01")
	private String vmdl01;

	@Column(name="VMDUMV")
	private String vmdumv;

	@Column(name="VMINMG")
	private String vminmg;

	@Column(name="VMJOBN")
	private String vmjobn;

	@Column(name="VMLCNT")
	private double vmlcnt;

	@Column(name="VMLRFG")
	private String vmlrfg;

	@Column(name="VMMCU")
	private String vmmcu;

	@Column(name="VMMEST")
	private String vmmest;

	@Column(name="VMMXML")
	private double vmmxml;

	@Column(name="VMNCE")
	private double vmnce;

	@Column(name="VMPID")
	private String vmpid;

	@Column(name="VMTDAY")
	private double vmtday;

	@Column(name="VMUMD1")
	private String vmumd1;

	@Column(name="VMUPMJ")
	private BigDecimal vmupmj;

	@Column(name="VMURAB")
	private double vmurab;

	@Column(name="VMURAT")
	private double vmurat;

	@Column(name="VMURCD")
	private String vmurcd;

	@Column(name="VMURDT")
	private BigDecimal vmurdt;

	@Column(name="VMURRF")
	private String vmurrf;

	@Column(name="VMUSER")
	private String vmuser;

	@Column(name="VMVEHN")
	private double vmvehn;

	@Column(name="VMVEHS")
	private String vmvehs;

	@Column(name="VMVLCP")
	private double vmvlcp;

	@Column(name="VMVLCS")
	private double vmvlcs;

	@Column(name="VMVLUM")
	private String vmvlum;

	@Column(name="VMVOWN")
	private double vmvown;

	@Column(name="VMVTYP")
	private String vmvtyp;

	@Column(name="VMWTCA")
	private double vmwtca;

	@Column(name="VMWTEM")
	private double vmwtem;

	@Column(name="VMWTUM")
	private String vmwtum;

	public F4930() {
	}

	public String getVmvehi() {
		return this.vmvehi;
	}

	public void setVmvehi(String vmvehi) {
		this.vmvehi = vmvehi;
	}

	public double getVmcvol() {
		return this.vmcvol;
	}

	public void setVmcvol(double vmcvol) {
		this.vmcvol = vmcvol;
	}

	public String getVmcvum() {
		return this.vmcvum;
	}

	public void setVmcvum(String vmcvum) {
		this.vmcvum = vmcvum;
	}

	public String getVmdl01() {
		return this.vmdl01;
	}

	public void setVmdl01(String vmdl01) {
		this.vmdl01 = vmdl01;
	}

	public String getVmdumv() {
		return this.vmdumv;
	}

	public void setVmdumv(String vmdumv) {
		this.vmdumv = vmdumv;
	}

	public String getVminmg() {
		return this.vminmg;
	}

	public void setVminmg(String vminmg) {
		this.vminmg = vminmg;
	}

	public String getVmjobn() {
		return this.vmjobn;
	}

	public void setVmjobn(String vmjobn) {
		this.vmjobn = vmjobn;
	}

	public double getVmlcnt() {
		return this.vmlcnt;
	}

	public void setVmlcnt(double vmlcnt) {
		this.vmlcnt = vmlcnt;
	}

	public String getVmlrfg() {
		return this.vmlrfg;
	}

	public void setVmlrfg(String vmlrfg) {
		this.vmlrfg = vmlrfg;
	}

	public String getVmmcu() {
		return this.vmmcu;
	}

	public void setVmmcu(String vmmcu) {
		this.vmmcu = vmmcu;
	}

	public String getVmmest() {
		return this.vmmest;
	}

	public void setVmmest(String vmmest) {
		this.vmmest = vmmest;
	}

	public double getVmmxml() {
		return this.vmmxml;
	}

	public void setVmmxml(double vmmxml) {
		this.vmmxml = vmmxml;
	}

	public double getVmnce() {
		return this.vmnce;
	}

	public void setVmnce(double vmnce) {
		this.vmnce = vmnce;
	}

	public String getVmpid() {
		return this.vmpid;
	}

	public void setVmpid(String vmpid) {
		this.vmpid = vmpid;
	}

	public double getVmtday() {
		return this.vmtday;
	}

	public void setVmtday(double vmtday) {
		this.vmtday = vmtday;
	}

	public String getVmumd1() {
		return this.vmumd1;
	}

	public void setVmumd1(String vmumd1) {
		this.vmumd1 = vmumd1;
	}

	public BigDecimal getVmupmj() {
		return this.vmupmj;
	}

	public void setVmupmj(BigDecimal vmupmj) {
		this.vmupmj = vmupmj;
	}

	public double getVmurab() {
		return this.vmurab;
	}

	public void setVmurab(double vmurab) {
		this.vmurab = vmurab;
	}

	public double getVmurat() {
		return this.vmurat;
	}

	public void setVmurat(double vmurat) {
		this.vmurat = vmurat;
	}

	public String getVmurcd() {
		return this.vmurcd;
	}

	public void setVmurcd(String vmurcd) {
		this.vmurcd = vmurcd;
	}

	public BigDecimal getVmurdt() {
		return this.vmurdt;
	}

	public void setVmurdt(BigDecimal vmurdt) {
		this.vmurdt = vmurdt;
	}

	public String getVmurrf() {
		return this.vmurrf;
	}

	public void setVmurrf(String vmurrf) {
		this.vmurrf = vmurrf;
	}

	public String getVmuser() {
		return this.vmuser;
	}

	public void setVmuser(String vmuser) {
		this.vmuser = vmuser;
	}

	public double getVmvehn() {
		return this.vmvehn;
	}

	public void setVmvehn(double vmvehn) {
		this.vmvehn = vmvehn;
	}

	public String getVmvehs() {
		return this.vmvehs;
	}

	public void setVmvehs(String vmvehs) {
		this.vmvehs = vmvehs;
	}

	public double getVmvlcp() {
		return this.vmvlcp;
	}

	public void setVmvlcp(double vmvlcp) {
		this.vmvlcp = vmvlcp;
	}

	public double getVmvlcs() {
		return this.vmvlcs;
	}

	public void setVmvlcs(double vmvlcs) {
		this.vmvlcs = vmvlcs;
	}

	public String getVmvlum() {
		return this.vmvlum;
	}

	public void setVmvlum(String vmvlum) {
		this.vmvlum = vmvlum;
	}

	public double getVmvown() {
		return this.vmvown;
	}

	public void setVmvown(double vmvown) {
		this.vmvown = vmvown;
	}

	public String getVmvtyp() {
		return this.vmvtyp;
	}

	public void setVmvtyp(String vmvtyp) {
		this.vmvtyp = vmvtyp;
	}

	public double getVmwtca() {
		return this.vmwtca;
	}

	public void setVmwtca(double vmwtca) {
		this.vmwtca = vmwtca;
	}

	public double getVmwtem() {
		return this.vmwtem;
	}

	public void setVmwtem(double vmwtem) {
		this.vmwtem = vmwtem;
	}

	public String getVmwtum() {
		return this.vmwtum;
	}

	public void setVmwtum(String vmwtum) {
		this.vmwtum = vmwtum;
	}

}