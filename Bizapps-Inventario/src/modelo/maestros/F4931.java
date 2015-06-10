package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * The persistent class for the F4931 database table.
 * 
 */
@Entity
public class F4931 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VGVTYP")
	private String vgvtyp;

	@Column(name = "VGAXLE")
	private double vgaxle;

	@Column(name = "VGBPFG")
	private String vgbpfg;

	@Column(name = "VGCPFG")
	private String vgcpfg;

	@Column(name = "VGCVOL")
	private double vgcvol;

	@Column(name = "VGCVUM")
	private String vgcvum;

	@Column(name = "VGDL01")
	private String vgdl01;

	@Column(name = "VGDSGP")
	private String vgdsgp;

	@Column(name = "VGDSGS")
	private String vgdsgs;

	@Column(name = "VGJOBN")
	private String vgjobn;

	@Column(name = "VGLCNT")
	private double vglcnt;

	@Column(name = "VGLHRD")
	private double vglhrd;

	@Column(name = "VGLHSD")
	private double vglhsd;

	@Column(name = "VGLNHC")
	private double vglnhc;

	@Column(name = "VGLNHE")
	private double vglnhe;

	@Column(name = "VGLNHF")
	private double vglnhf;

	@Column(name = "VGLNHR")
	private double vglnhr;

	@Column(name = "VGLNLE")
	private double vglnle;

	@Column(name = "VGLNLI")
	private double vglnli;

	@Column(name = "VGLNVF")
	private double vglnvf;

	@Column(name = "VGLNWE")
	private double vglnwe;

	@Column(name = "VGLNWI")
	private double vglnwi;

	@Column(name = "VGLUOM")
	private String vgluom;

	@Column(name = "VGLWRD")
	private double vglwrd;

	@Column(name = "VGLWSD")
	private double vglwsd;

	@Column(name = "VGMCU")
	private String vgmcu;

	@Column(name = "VGMLLN")
	private String vgmlln;

	@Column(name = "VGMOT")
	private String vgmot;

	@Column(name = "VGNCE")
	private double vgnce;

	@Column(name = "VGPID")
	private String vgpid;

	@Column(name = "VGSEAL")
	private double vgseal;

	@Column(name = "VGTDAY")
	private double vgtday;

	@Column(name = "VGUPMJ")
	private BigDecimal vgupmj;

	@Column(name = "VGURAB")
	private double vgurab;

	@Column(name = "VGURCD")
	private String vgurcd;

	@Column(name = "VGURDT")
	private BigDecimal vgurdt;

	@Column(name = "VGURRF")
	private String vgurrf;

	@Column(name = "VGUSER")
	private String vguser;

	@Column(name = "VGVLCP")
	private double vgvlcp;

	@Column(name = "VGVLCS")
	private double vgvlcs;

	@Column(name = "VGVLUM")
	private String vgvlum;

	@Column(name = "VGWTAX")
	private double vgwtax;

	@Column(name = "VGWTCA")
	private double vgwtca;

	@Column(name = "VGWTEM")
	private double vgwtem;

	@Column(name = "VGWTUM")
	private String vgwtum;

	public F4931() {
	}

	public String getVgvtyp() {
		return this.vgvtyp;
	}

	public void setVgvtyp(String vgvtyp) {
		this.vgvtyp = vgvtyp;
	}

	public double getVgaxle() {
		return this.vgaxle;
	}

	public void setVgaxle(double vgaxle) {
		this.vgaxle = vgaxle;
	}

	public String getVgbpfg() {
		return this.vgbpfg;
	}

	public void setVgbpfg(String vgbpfg) {
		this.vgbpfg = vgbpfg;
	}

	public String getVgcpfg() {
		return this.vgcpfg;
	}

	public void setVgcpfg(String vgcpfg) {
		this.vgcpfg = vgcpfg;
	}

	public double getVgcvol() {
		return this.vgcvol;
	}

	public void setVgcvol(double vgcvol) {
		this.vgcvol = vgcvol;
	}

	public String getVgcvum() {
		return this.vgcvum;
	}

	public void setVgcvum(String vgcvum) {
		this.vgcvum = vgcvum;
	}

	public String getVgdl01() {
		return this.vgdl01;
	}

	public void setVgdl01(String vgdl01) {
		this.vgdl01 = vgdl01;
	}

	public String getVgdsgp() {
		return this.vgdsgp;
	}

	public void setVgdsgp(String vgdsgp) {
		this.vgdsgp = vgdsgp;
	}

	public String getVgdsgs() {
		return this.vgdsgs;
	}

	public void setVgdsgs(String vgdsgs) {
		this.vgdsgs = vgdsgs;
	}

	public String getVgjobn() {
		return this.vgjobn;
	}

	public void setVgjobn(String vgjobn) {
		this.vgjobn = vgjobn;
	}

	public double getVglcnt() {
		return this.vglcnt;
	}

	public void setVglcnt(double vglcnt) {
		this.vglcnt = vglcnt;
	}

	public double getVglhrd() {
		return this.vglhrd;
	}

	public void setVglhrd(double vglhrd) {
		this.vglhrd = vglhrd;
	}

	public double getVglhsd() {
		return this.vglhsd;
	}

	public void setVglhsd(double vglhsd) {
		this.vglhsd = vglhsd;
	}

	public double getVglnhc() {
		return this.vglnhc;
	}

	public void setVglnhc(double vglnhc) {
		this.vglnhc = vglnhc;
	}

	public double getVglnhe() {
		return this.vglnhe;
	}

	public void setVglnhe(double vglnhe) {
		this.vglnhe = vglnhe;
	}

	public double getVglnhf() {
		return this.vglnhf;
	}

	public void setVglnhf(double vglnhf) {
		this.vglnhf = vglnhf;
	}

	public double getVglnhr() {
		return this.vglnhr;
	}

	public void setVglnhr(double vglnhr) {
		this.vglnhr = vglnhr;
	}

	public double getVglnle() {
		return this.vglnle;
	}

	public void setVglnle(double vglnle) {
		this.vglnle = vglnle;
	}

	public double getVglnli() {
		return this.vglnli;
	}

	public void setVglnli(double vglnli) {
		this.vglnli = vglnli;
	}

	public double getVglnvf() {
		return this.vglnvf;
	}

	public void setVglnvf(double vglnvf) {
		this.vglnvf = vglnvf;
	}

	public double getVglnwe() {
		return this.vglnwe;
	}

	public void setVglnwe(double vglnwe) {
		this.vglnwe = vglnwe;
	}

	public double getVglnwi() {
		return this.vglnwi;
	}

	public void setVglnwi(double vglnwi) {
		this.vglnwi = vglnwi;
	}

	public String getVgluom() {
		return this.vgluom;
	}

	public void setVgluom(String vgluom) {
		this.vgluom = vgluom;
	}

	public double getVglwrd() {
		return this.vglwrd;
	}

	public void setVglwrd(double vglwrd) {
		this.vglwrd = vglwrd;
	}

	public double getVglwsd() {
		return this.vglwsd;
	}

	public void setVglwsd(double vglwsd) {
		this.vglwsd = vglwsd;
	}

	public String getVgmcu() {
		return this.vgmcu;
	}

	public void setVgmcu(String vgmcu) {
		this.vgmcu = vgmcu;
	}

	public String getVgmlln() {
		return this.vgmlln;
	}

	public void setVgmlln(String vgmlln) {
		this.vgmlln = vgmlln;
	}

	public String getVgmot() {
		return this.vgmot;
	}

	public void setVgmot(String vgmot) {
		this.vgmot = vgmot;
	}

	public double getVgnce() {
		return this.vgnce;
	}

	public void setVgnce(double vgnce) {
		this.vgnce = vgnce;
	}

	public String getVgpid() {
		return this.vgpid;
	}

	public void setVgpid(String vgpid) {
		this.vgpid = vgpid;
	}

	public double getVgseal() {
		return this.vgseal;
	}

	public void setVgseal(double vgseal) {
		this.vgseal = vgseal;
	}

	public double getVgtday() {
		return this.vgtday;
	}

	public void setVgtday(double vgtday) {
		this.vgtday = vgtday;
	}

	public BigDecimal getVgupmj() {
		return this.vgupmj;
	}

	public void setVgupmj(BigDecimal vgupmj) {
		this.vgupmj = vgupmj;
	}

	public double getVgurab() {
		return this.vgurab;
	}

	public void setVgurab(double vgurab) {
		this.vgurab = vgurab;
	}

	public String getVgurcd() {
		return this.vgurcd;
	}

	public void setVgurcd(String vgurcd) {
		this.vgurcd = vgurcd;
	}

	public BigDecimal getVgurdt() {
		return this.vgurdt;
	}

	public void setVgurdt(BigDecimal vgurdt) {
		this.vgurdt = vgurdt;
	}

	public String getVgurrf() {
		return this.vgurrf;
	}

	public void setVgurrf(String vgurrf) {
		this.vgurrf = vgurrf;
	}

	public String getVguser() {
		return this.vguser;
	}

	public void setVguser(String vguser) {
		this.vguser = vguser;
	}

	public double getVgvlcp() {
		return this.vgvlcp;
	}

	public void setVgvlcp(double vgvlcp) {
		this.vgvlcp = vgvlcp;
	}

	public double getVgvlcs() {
		return this.vgvlcs;
	}

	public void setVgvlcs(double vgvlcs) {
		this.vgvlcs = vgvlcs;
	}

	public String getVgvlum() {
		return this.vgvlum;
	}

	public void setVgvlum(String vgvlum) {
		this.vgvlum = vgvlum;
	}

	public double getVgwtax() {
		return this.vgwtax;
	}

	public void setVgwtax(double vgwtax) {
		this.vgwtax = vgwtax;
	}

	public double getVgwtca() {
		return this.vgwtca;
	}

	public void setVgwtca(double vgwtca) {
		this.vgwtca = vgwtca;
	}

	public double getVgwtem() {
		return this.vgwtem;
	}

	public void setVgwtem(double vgwtem) {
		this.vgwtem = vgwtem;
	}

	public String getVgwtum() {
		return this.vgwtum;
	}

	public void setVgwtum(String vgwtum) {
		this.vgwtum = vgwtum;
	}

}