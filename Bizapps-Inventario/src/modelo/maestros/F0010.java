package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the F0010 database table.
 * 
 */
@Entity
public class F0010 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CCCO")
	private String ccco;

	@Column(name="CCABIN")
	private String ccabin;

	@Column(name="CCAGE")
	private String ccage;

	@Column(name="CCAGEM")
	private String ccagem;

	@Column(name="CCAGR1")
	private double ccagr1;

	@Column(name="CCAGR2")
	private double ccagr2;

	@Column(name="CCAGR3")
	private double ccagr3;

	@Column(name="CCAGR4")
	private double ccagr4;

	@Column(name="CCAGR5")
	private double ccagr5;

	@Column(name="CCAGR6")
	private double ccagr6;

	@Column(name="CCAGR7")
	private double ccagr7;

	@Column(name="CCALGM")
	private String ccalgm;

	@Column(name="CCALTC")
	private String ccaltc;

	@Column(name="CCAN8")
	private double ccan8;

	@Column(name="CCAN8C")
	private double ccan8c;

	@Column(name="CCAPFJ")
	private BigDecimal ccapfj;

	@Column(name="CCAPPN")
	private double ccappn;

	@Column(name="CCARFJ")
	private BigDecimal ccarfj;

	@Column(name="CCARPN")
	private double ccarpn;

	@Column(name="CCATCS")
	private String ccatcs;

	@Column(name="CCBKTX")
	private String ccbktx;

	@Column(name="CCCALD")
	private String cccald;

	@Column(name="CCCRCD")
	private String cccrcd;

	@Column(name="CCCRDY")
	private double cccrdy;

	@Column(name="CCCRYC")
	private String cccryc;

	@Column(name="CCCRYR")
	private String cccryr;

	@Column(name="CCDAG")
	private BigDecimal ccdag;

	@Column(name="CCDFF")
	private double ccdff;

	@Column(name="CCDFYJ")
	private BigDecimal ccdfyj;

	@Column(name="CCDNLT")
	private String ccdnlt;

	@Column(name="CCDOT1")
	private String ccdot1;

	@Column(name="CCDOT2")
	private String ccdot2;

	@Column(name="CCDPRC")
	private String ccdprc;

	@Column(name="CCDTPN")
	private String ccdtpn;

	@Column(name="CCFP")
	private double ccfp;

	@Column(name="CCFRP")
	private double ccfrp;

	@Column(name="CCFRY")
	private double ccfry;

	@Column(name="CCGLIE")
	private String ccglie;

	@Column(name="CCJOBN")
	private String ccjobn;

	@Column(name="CCMCUA")
	private String ccmcua;

	@Column(name="CCMCUB")
	private String ccmcub;

	@Column(name="CCMCUC")
	private String ccmcuc;

	@Column(name="CCMCUD")
	private String ccmcud;

	@Column(name="CCNAME")
	private String ccname;

	@Column(name="CCNNP")
	private double ccnnp;

	@Column(name="CCNWXJ")
	private BigDecimal ccnwxj;

	@Column(name="CCPID")
	private String ccpid;

	@Column(name="CCPNC")
	private double ccpnc;

	@Column(name="CCPNF")
	private double ccpnf;

	@Column(name="CCPTCO")
	private String ccptco;

	@Column(name="CCSGBK")
	private String ccsgbk;

	@Column(name="CCSMI")
	private String ccsmi;

	@Column(name="CCSMS")
	private String ccsms;

	@Column(name="CCSMU")
	private String ccsmu;

	@Column(name="CCSTMT")
	private String ccstmt;

	@Column(name="CCTHCO")
	private String ccthco;

	@Column(name="CCTSCO")
	private String cctsco;

	@Column(name="CCTSID")
	private double cctsid;

	@Column(name="CCTXBM")
	private double cctxbm;

	@Column(name="CCTXBO")
	private double cctxbo;

	@Column(name="CCUPMJ")
	private BigDecimal ccupmj;

	@Column(name="CCUPMT")
	private double ccupmt;

	@Column(name="CCUSER")
	private String ccuser;

	@Column(name="CCX1")
	private String ccx1;

	@Column(name="CCX2")
	private String ccx2;

	public F0010() {
	}

	public String getCcco() {
		return this.ccco;
	}

	public void setCcco(String ccco) {
		this.ccco = ccco;
	}

	public String getCcabin() {
		return this.ccabin;
	}

	public void setCcabin(String ccabin) {
		this.ccabin = ccabin;
	}

	public String getCcage() {
		return this.ccage;
	}

	public void setCcage(String ccage) {
		this.ccage = ccage;
	}

	public String getCcagem() {
		return this.ccagem;
	}

	public void setCcagem(String ccagem) {
		this.ccagem = ccagem;
	}

	public double getCcagr1() {
		return this.ccagr1;
	}

	public void setCcagr1(double ccagr1) {
		this.ccagr1 = ccagr1;
	}

	public double getCcagr2() {
		return this.ccagr2;
	}

	public void setCcagr2(double ccagr2) {
		this.ccagr2 = ccagr2;
	}

	public double getCcagr3() {
		return this.ccagr3;
	}

	public void setCcagr3(double ccagr3) {
		this.ccagr3 = ccagr3;
	}

	public double getCcagr4() {
		return this.ccagr4;
	}

	public void setCcagr4(double ccagr4) {
		this.ccagr4 = ccagr4;
	}

	public double getCcagr5() {
		return this.ccagr5;
	}

	public void setCcagr5(double ccagr5) {
		this.ccagr5 = ccagr5;
	}

	public double getCcagr6() {
		return this.ccagr6;
	}

	public void setCcagr6(double ccagr6) {
		this.ccagr6 = ccagr6;
	}

	public double getCcagr7() {
		return this.ccagr7;
	}

	public void setCcagr7(double ccagr7) {
		this.ccagr7 = ccagr7;
	}

	public String getCcalgm() {
		return this.ccalgm;
	}

	public void setCcalgm(String ccalgm) {
		this.ccalgm = ccalgm;
	}

	public String getCcaltc() {
		return this.ccaltc;
	}

	public void setCcaltc(String ccaltc) {
		this.ccaltc = ccaltc;
	}

	public double getCcan8() {
		return this.ccan8;
	}

	public void setCcan8(double ccan8) {
		this.ccan8 = ccan8;
	}

	public double getCcan8c() {
		return this.ccan8c;
	}

	public void setCcan8c(double ccan8c) {
		this.ccan8c = ccan8c;
	}

	public BigDecimal getCcapfj() {
		return this.ccapfj;
	}

	public void setCcapfj(BigDecimal ccapfj) {
		this.ccapfj = ccapfj;
	}

	public double getCcappn() {
		return this.ccappn;
	}

	public void setCcappn(double ccappn) {
		this.ccappn = ccappn;
	}

	public BigDecimal getCcarfj() {
		return this.ccarfj;
	}

	public void setCcarfj(BigDecimal ccarfj) {
		this.ccarfj = ccarfj;
	}

	public double getCcarpn() {
		return this.ccarpn;
	}

	public void setCcarpn(double ccarpn) {
		this.ccarpn = ccarpn;
	}

	public String getCcatcs() {
		return this.ccatcs;
	}

	public void setCcatcs(String ccatcs) {
		this.ccatcs = ccatcs;
	}

	public String getCcbktx() {
		return this.ccbktx;
	}

	public void setCcbktx(String ccbktx) {
		this.ccbktx = ccbktx;
	}

	public String getCccald() {
		return this.cccald;
	}

	public void setCccald(String cccald) {
		this.cccald = cccald;
	}

	public String getCccrcd() {
		return this.cccrcd;
	}

	public void setCccrcd(String cccrcd) {
		this.cccrcd = cccrcd;
	}

	public double getCccrdy() {
		return this.cccrdy;
	}

	public void setCccrdy(double cccrdy) {
		this.cccrdy = cccrdy;
	}

	public String getCccryc() {
		return this.cccryc;
	}

	public void setCccryc(String cccryc) {
		this.cccryc = cccryc;
	}

	public String getCccryr() {
		return this.cccryr;
	}

	public void setCccryr(String cccryr) {
		this.cccryr = cccryr;
	}

	public BigDecimal getCcdag() {
		return this.ccdag;
	}

	public void setCcdag(BigDecimal ccdag) {
		this.ccdag = ccdag;
	}

	public double getCcdff() {
		return this.ccdff;
	}

	public void setCcdff(double ccdff) {
		this.ccdff = ccdff;
	}

	public BigDecimal getCcdfyj() {
		return this.ccdfyj;
	}

	public void setCcdfyj(BigDecimal ccdfyj) {
		this.ccdfyj = ccdfyj;
	}

	public String getCcdnlt() {
		return this.ccdnlt;
	}

	public void setCcdnlt(String ccdnlt) {
		this.ccdnlt = ccdnlt;
	}

	public String getCcdot1() {
		return this.ccdot1;
	}

	public void setCcdot1(String ccdot1) {
		this.ccdot1 = ccdot1;
	}

	public String getCcdot2() {
		return this.ccdot2;
	}

	public void setCcdot2(String ccdot2) {
		this.ccdot2 = ccdot2;
	}

	public String getCcdprc() {
		return this.ccdprc;
	}

	public void setCcdprc(String ccdprc) {
		this.ccdprc = ccdprc;
	}

	public String getCcdtpn() {
		return this.ccdtpn;
	}

	public void setCcdtpn(String ccdtpn) {
		this.ccdtpn = ccdtpn;
	}

	public double getCcfp() {
		return this.ccfp;
	}

	public void setCcfp(double ccfp) {
		this.ccfp = ccfp;
	}

	public double getCcfrp() {
		return this.ccfrp;
	}

	public void setCcfrp(double ccfrp) {
		this.ccfrp = ccfrp;
	}

	public double getCcfry() {
		return this.ccfry;
	}

	public void setCcfry(double ccfry) {
		this.ccfry = ccfry;
	}

	public String getCcglie() {
		return this.ccglie;
	}

	public void setCcglie(String ccglie) {
		this.ccglie = ccglie;
	}

	public String getCcjobn() {
		return this.ccjobn;
	}

	public void setCcjobn(String ccjobn) {
		this.ccjobn = ccjobn;
	}

	public String getCcmcua() {
		return this.ccmcua;
	}

	public void setCcmcua(String ccmcua) {
		this.ccmcua = ccmcua;
	}

	public String getCcmcub() {
		return this.ccmcub;
	}

	public void setCcmcub(String ccmcub) {
		this.ccmcub = ccmcub;
	}

	public String getCcmcuc() {
		return this.ccmcuc;
	}

	public void setCcmcuc(String ccmcuc) {
		this.ccmcuc = ccmcuc;
	}

	public String getCcmcud() {
		return this.ccmcud;
	}

	public void setCcmcud(String ccmcud) {
		this.ccmcud = ccmcud;
	}

	public String getCcname() {
		return this.ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public double getCcnnp() {
		return this.ccnnp;
	}

	public void setCcnnp(double ccnnp) {
		this.ccnnp = ccnnp;
	}

	public BigDecimal getCcnwxj() {
		return this.ccnwxj;
	}

	public void setCcnwxj(BigDecimal ccnwxj) {
		this.ccnwxj = ccnwxj;
	}

	public String getCcpid() {
		return this.ccpid;
	}

	public void setCcpid(String ccpid) {
		this.ccpid = ccpid;
	}

	public double getCcpnc() {
		return this.ccpnc;
	}

	public void setCcpnc(double ccpnc) {
		this.ccpnc = ccpnc;
	}

	public double getCcpnf() {
		return this.ccpnf;
	}

	public void setCcpnf(double ccpnf) {
		this.ccpnf = ccpnf;
	}

	public String getCcptco() {
		return this.ccptco;
	}

	public void setCcptco(String ccptco) {
		this.ccptco = ccptco;
	}

	public String getCcsgbk() {
		return this.ccsgbk;
	}

	public void setCcsgbk(String ccsgbk) {
		this.ccsgbk = ccsgbk;
	}

	public String getCcsmi() {
		return this.ccsmi;
	}

	public void setCcsmi(String ccsmi) {
		this.ccsmi = ccsmi;
	}

	public String getCcsms() {
		return this.ccsms;
	}

	public void setCcsms(String ccsms) {
		this.ccsms = ccsms;
	}

	public String getCcsmu() {
		return this.ccsmu;
	}

	public void setCcsmu(String ccsmu) {
		this.ccsmu = ccsmu;
	}

	public String getCcstmt() {
		return this.ccstmt;
	}

	public void setCcstmt(String ccstmt) {
		this.ccstmt = ccstmt;
	}

	public String getCcthco() {
		return this.ccthco;
	}

	public void setCcthco(String ccthco) {
		this.ccthco = ccthco;
	}

	public String getCctsco() {
		return this.cctsco;
	}

	public void setCctsco(String cctsco) {
		this.cctsco = cctsco;
	}

	public double getCctsid() {
		return this.cctsid;
	}

	public void setCctsid(double cctsid) {
		this.cctsid = cctsid;
	}

	public double getCctxbm() {
		return this.cctxbm;
	}

	public void setCctxbm(double cctxbm) {
		this.cctxbm = cctxbm;
	}

	public double getCctxbo() {
		return this.cctxbo;
	}

	public void setCctxbo(double cctxbo) {
		this.cctxbo = cctxbo;
	}

	public BigDecimal getCcupmj() {
		return this.ccupmj;
	}

	public void setCcupmj(BigDecimal ccupmj) {
		this.ccupmj = ccupmj;
	}

	public double getCcupmt() {
		return this.ccupmt;
	}

	public void setCcupmt(double ccupmt) {
		this.ccupmt = ccupmt;
	}

	public String getCcuser() {
		return this.ccuser;
	}

	public void setCcuser(String ccuser) {
		this.ccuser = ccuser;
	}

	public String getCcx1() {
		return this.ccx1;
	}

	public void setCcx1(String ccx1) {
		this.ccx1 = ccx1;
	}

	public String getCcx2() {
		return this.ccx2;
	}

	public void setCcx2(String ccx2) {
		this.ccx2 = ccx2;
	}

}