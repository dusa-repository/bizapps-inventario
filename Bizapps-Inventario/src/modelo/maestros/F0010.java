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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CCCO")
	private String ccco;

	@Column(name="CCABIN")
	private Object ccabin;

	@Column(name="CCAGE")
	private Object ccage;

	@Column(name="CCAGEM")
	private Object ccagem;

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
	private Object ccalgm;

	@Column(name="CCALTC")
	private Object ccaltc;

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
	private Object ccatcs;

	@Column(name="CCBKTX")
	private Object ccbktx;

	@Column(name="CCCALD")
	private Object cccald;

	@Column(name="CCCRCD")
	private Object cccrcd;

	@Column(name="CCCRDY")
	private double cccrdy;

	@Column(name="CCCRYC")
	private Object cccryc;

	@Column(name="CCCRYR")
	private Object cccryr;

	@Column(name="CCDAG")
	private BigDecimal ccdag;

	@Column(name="CCDFF")
	private double ccdff;

	@Column(name="CCDFYJ")
	private BigDecimal ccdfyj;

	@Column(name="CCDNLT")
	private Object ccdnlt;

	@Column(name="CCDOT1")
	private Object ccdot1;

	@Column(name="CCDOT2")
	private Object ccdot2;

	@Column(name="CCDPRC")
	private Object ccdprc;

	@Column(name="CCDTPN")
	private Object ccdtpn;

	@Column(name="CCFP")
	private double ccfp;

	@Column(name="CCFRP")
	private double ccfrp;

	@Column(name="CCFRY")
	private double ccfry;

	@Column(name="CCGLIE")
	private Object ccglie;

	@Column(name="CCJOBN")
	private Object ccjobn;

	@Column(name="CCMCUA")
	private Object ccmcua;

	@Column(name="CCMCUB")
	private Object ccmcub;

	@Column(name="CCMCUC")
	private Object ccmcuc;

	@Column(name="CCMCUD")
	private Object ccmcud;

	@Column(name="CCNAME")
	private Object ccname;

	@Column(name="CCNNP")
	private double ccnnp;

	@Column(name="CCNWXJ")
	private BigDecimal ccnwxj;

	@Column(name="CCPID")
	private Object ccpid;

	@Column(name="CCPNC")
	private double ccpnc;

	@Column(name="CCPNF")
	private double ccpnf;

	@Column(name="CCPTCO")
	private Object ccptco;

	@Column(name="CCSGBK")
	private Object ccsgbk;

	@Column(name="CCSMI")
	private Object ccsmi;

	@Column(name="CCSMS")
	private Object ccsms;

	@Column(name="CCSMU")
	private Object ccsmu;

	@Column(name="CCSTMT")
	private Object ccstmt;

	@Column(name="CCTHCO")
	private Object ccthco;

	@Column(name="CCTSCO")
	private Object cctsco;

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
	private Object ccuser;

	@Column(name="CCX1")
	private Object ccx1;

	@Column(name="CCX2")
	private Object ccx2;

	public F0010() {
	}

	public String getCcco() {
		return this.ccco;
	}

	public void setCcco(String ccco) {
		this.ccco = ccco;
	}

	public Object getCcabin() {
		return this.ccabin;
	}

	public void setCcabin(Object ccabin) {
		this.ccabin = ccabin;
	}

	public Object getCcage() {
		return this.ccage;
	}

	public void setCcage(Object ccage) {
		this.ccage = ccage;
	}

	public Object getCcagem() {
		return this.ccagem;
	}

	public void setCcagem(Object ccagem) {
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

	public Object getCcalgm() {
		return this.ccalgm;
	}

	public void setCcalgm(Object ccalgm) {
		this.ccalgm = ccalgm;
	}

	public Object getCcaltc() {
		return this.ccaltc;
	}

	public void setCcaltc(Object ccaltc) {
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

	public Object getCcatcs() {
		return this.ccatcs;
	}

	public void setCcatcs(Object ccatcs) {
		this.ccatcs = ccatcs;
	}

	public Object getCcbktx() {
		return this.ccbktx;
	}

	public void setCcbktx(Object ccbktx) {
		this.ccbktx = ccbktx;
	}

	public Object getCccald() {
		return this.cccald;
	}

	public void setCccald(Object cccald) {
		this.cccald = cccald;
	}

	public Object getCccrcd() {
		return this.cccrcd;
	}

	public void setCccrcd(Object cccrcd) {
		this.cccrcd = cccrcd;
	}

	public double getCccrdy() {
		return this.cccrdy;
	}

	public void setCccrdy(double cccrdy) {
		this.cccrdy = cccrdy;
	}

	public Object getCccryc() {
		return this.cccryc;
	}

	public void setCccryc(Object cccryc) {
		this.cccryc = cccryc;
	}

	public Object getCccryr() {
		return this.cccryr;
	}

	public void setCccryr(Object cccryr) {
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

	public Object getCcdnlt() {
		return this.ccdnlt;
	}

	public void setCcdnlt(Object ccdnlt) {
		this.ccdnlt = ccdnlt;
	}

	public Object getCcdot1() {
		return this.ccdot1;
	}

	public void setCcdot1(Object ccdot1) {
		this.ccdot1 = ccdot1;
	}

	public Object getCcdot2() {
		return this.ccdot2;
	}

	public void setCcdot2(Object ccdot2) {
		this.ccdot2 = ccdot2;
	}

	public Object getCcdprc() {
		return this.ccdprc;
	}

	public void setCcdprc(Object ccdprc) {
		this.ccdprc = ccdprc;
	}

	public Object getCcdtpn() {
		return this.ccdtpn;
	}

	public void setCcdtpn(Object ccdtpn) {
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

	public Object getCcglie() {
		return this.ccglie;
	}

	public void setCcglie(Object ccglie) {
		this.ccglie = ccglie;
	}

	public Object getCcjobn() {
		return this.ccjobn;
	}

	public void setCcjobn(Object ccjobn) {
		this.ccjobn = ccjobn;
	}

	public Object getCcmcua() {
		return this.ccmcua;
	}

	public void setCcmcua(Object ccmcua) {
		this.ccmcua = ccmcua;
	}

	public Object getCcmcub() {
		return this.ccmcub;
	}

	public void setCcmcub(Object ccmcub) {
		this.ccmcub = ccmcub;
	}

	public Object getCcmcuc() {
		return this.ccmcuc;
	}

	public void setCcmcuc(Object ccmcuc) {
		this.ccmcuc = ccmcuc;
	}

	public Object getCcmcud() {
		return this.ccmcud;
	}

	public void setCcmcud(Object ccmcud) {
		this.ccmcud = ccmcud;
	}

	public Object getCcname() {
		return this.ccname;
	}

	public void setCcname(Object ccname) {
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

	public Object getCcpid() {
		return this.ccpid;
	}

	public void setCcpid(Object ccpid) {
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

	public Object getCcptco() {
		return this.ccptco;
	}

	public void setCcptco(Object ccptco) {
		this.ccptco = ccptco;
	}

	public Object getCcsgbk() {
		return this.ccsgbk;
	}

	public void setCcsgbk(Object ccsgbk) {
		this.ccsgbk = ccsgbk;
	}

	public Object getCcsmi() {
		return this.ccsmi;
	}

	public void setCcsmi(Object ccsmi) {
		this.ccsmi = ccsmi;
	}

	public Object getCcsms() {
		return this.ccsms;
	}

	public void setCcsms(Object ccsms) {
		this.ccsms = ccsms;
	}

	public Object getCcsmu() {
		return this.ccsmu;
	}

	public void setCcsmu(Object ccsmu) {
		this.ccsmu = ccsmu;
	}

	public Object getCcstmt() {
		return this.ccstmt;
	}

	public void setCcstmt(Object ccstmt) {
		this.ccstmt = ccstmt;
	}

	public Object getCcthco() {
		return this.ccthco;
	}

	public void setCcthco(Object ccthco) {
		this.ccthco = ccthco;
	}

	public Object getCctsco() {
		return this.cctsco;
	}

	public void setCctsco(Object cctsco) {
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

	public Object getCcuser() {
		return this.ccuser;
	}

	public void setCcuser(Object ccuser) {
		this.ccuser = ccuser;
	}

	public Object getCcx1() {
		return this.ccx1;
	}

	public void setCcx1(Object ccx1) {
		this.ccx1 = ccx1;
	}

	public Object getCcx2() {
		return this.ccx2;
	}

	public void setCcx2(Object ccx2) {
		this.ccx2 = ccx2;
	}

}