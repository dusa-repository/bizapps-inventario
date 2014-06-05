package modelo.maestros;

import java.io.Serializable;
import javax.persistence.*;

import modelo.pk.F4100PK;

import java.math.BigDecimal;


/**
 * The persistent class for the F4100 database table.
 * 
 */
@Entity
public class F4100 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4100PK id;

	@Column(name="LMAISL")
	private String lmaisl;

	@Column(name="LMAPIK")
	private String lmapik;

	@Column(name="LMAPUT")
	private String lmaput;

	@Column(name="LMARPL")
	private String lmarpl;

	@Column(name="LMBIN")
	private String lmbin;

	@Column(name="LMCGRP")
	private String lmcgrp;

	@Column(name="LMCTNF")
	private String lmctnf;

	@Column(name="LMDISX")
	private Double lmdisx;

	@Column(name="LMDISY")
	private Double lmdisy;

	@Column(name="LMDISZ")
	private Double lmdisz;

	@Column(name="LMEQTP")
	private String lmeqtp;

	@Column(name="LMEQTY")
	private String lmeqty;

	@Column(name="LMFREZ")
	private String lmfrez;

	@Column(name="LMJOBN")
	private String lmjobn;

	@Column(name="LMKCNF")
	private String lmkcnf;

	@Column(name="LMKZON")
	private String lmkzon;

	@Column(name="LMLA03")
	private String lmla03;

	@Column(name="LMLA04")
	private String lmla04;

	@Column(name="LMLA05")
	private String lmla05;

	@Column(name="LMLA06")
	private String lmla06;

	@Column(name="LMLA07")
	private String lmla07;

	@Column(name="LMLA08")
	private String lmla08;

	@Column(name="LMLA09")
	private String lmla09;

	@Column(name="LMLA10")
	private String lmla10;

	@Column(name="LMLCOD")
	private String lmlcod;

	@Column(name="LMLHLD")
	private String lmlhld;

	@Column(name="LMLLDL")
	private String lmlldl;

	@Column(name="LMLVER")
	private String lmlver;

	@Column(name="LMMCNT")
	private String lmmcnt;

	@Column(name="LMMITM")
	private Double lmmitm;

	@Column(name="LMMIXL")
	private String lmmixl;

	@Column(name="LMMLOT")
	private String lmmlot;

	@Column(name="LMMMTH")
	private String lmmmth;

	@Column(name="LMMNUK")
	private Double lmmnuk;

	@Column(name="LMMNUP")
	private Double lmmnup;

	@Column(name="LMMPTL")
	private String lmmptl;

	@Column(name="LMMUMS")
	private String lmmums;

	@Column(name="LMNETA")
	private String lmneta;

	@Column(name="LMOT1Y")
	private String lmot1y;

	@Column(name="LMOT2Y")
	private String lmot2y;

	@Column(name="LMPCNF")
	private String lmpcnf;

	@Column(name="LMPID")
	private String lmpid;

	@Column(name="LMPZON")
	private String lmpzon;

	@Column(name="LMSTAG")
	private String lmstag;

	@Column(name="LMSTGK")
	private String lmstgk;

	@Column(name="LMSTGP")
	private String lmstgp;

	@Column(name="LMSTGR")
	private String lmstgr;

	@Column(name="LMSTY1")
	private String lmsty1;

	@Column(name="LMTDAY")
	private Double lmtday;

	@Column(name="LMUPMJ")
	private BigDecimal lmupmj;

	@Column(name="LMURAB")
	private Double lmurab;

	@Column(name="LMURAT")
	private Double lmurat;

	@Column(name="LMURCD")
	private String lmurcd;

	@Column(name="LMURDT")
	private BigDecimal lmurdt;

	@Column(name="LMURRF")
	private String lmurrf;

	@Column(name="LMUSER")
	private String lmuser;

	@Column(name="LMWSQP")
	private Double lmwsqp;

	@Column(name="LMWSQQ")
	private Double lmwsqq;

	@Column(name="LMWSQR")
	private Double lmwsqr;

	@Column(name="LMZONR")
	private String lmzonr;

	public F4100() {
	}

	public F4100PK getId() {
		return this.id;
	}

	public void setId(F4100PK id) {
		this.id = id;
	}

	public String getLmaisl() {
		return this.lmaisl;
	}

	public void setLmaisl(String lmaisl) {
		this.lmaisl = lmaisl;
	}

	public String getLmapik() {
		return this.lmapik;
	}

	public void setLmapik(String lmapik) {
		this.lmapik = lmapik;
	}

	public String getLmaput() {
		return this.lmaput;
	}

	public void setLmaput(String lmaput) {
		this.lmaput = lmaput;
	}

	public String getLmarpl() {
		return this.lmarpl;
	}

	public void setLmarpl(String lmarpl) {
		this.lmarpl = lmarpl;
	}

	public String getLmbin() {
		return this.lmbin;
	}

	public void setLmbin(String lmbin) {
		this.lmbin = lmbin;
	}

	public String getLmcgrp() {
		return this.lmcgrp;
	}

	public void setLmcgrp(String lmcgrp) {
		this.lmcgrp = lmcgrp;
	}

	public String getLmctnf() {
		return this.lmctnf;
	}

	public void setLmctnf(String lmctnf) {
		this.lmctnf = lmctnf;
	}

	public Double getLmdisx() {
		return this.lmdisx;
	}

	public void setLmdisx(Double lmdisx) {
		this.lmdisx = lmdisx;
	}

	public Double getLmdisy() {
		return this.lmdisy;
	}

	public void setLmdisy(Double lmdisy) {
		this.lmdisy = lmdisy;
	}

	public Double getLmdisz() {
		return this.lmdisz;
	}

	public void setLmdisz(Double lmdisz) {
		this.lmdisz = lmdisz;
	}

	public String getLmeqtp() {
		return this.lmeqtp;
	}

	public void setLmeqtp(String lmeqtp) {
		this.lmeqtp = lmeqtp;
	}

	public String getLmeqty() {
		return this.lmeqty;
	}

	public void setLmeqty(String lmeqty) {
		this.lmeqty = lmeqty;
	}

	public String getLmfrez() {
		return this.lmfrez;
	}

	public void setLmfrez(String lmfrez) {
		this.lmfrez = lmfrez;
	}

	public String getLmjobn() {
		return this.lmjobn;
	}

	public void setLmjobn(String lmjobn) {
		this.lmjobn = lmjobn;
	}

	public String getLmkcnf() {
		return this.lmkcnf;
	}

	public void setLmkcnf(String lmkcnf) {
		this.lmkcnf = lmkcnf;
	}

	public String getLmkzon() {
		return this.lmkzon;
	}

	public void setLmkzon(String lmkzon) {
		this.lmkzon = lmkzon;
	}

	public String getLmla03() {
		return this.lmla03;
	}

	public void setLmla03(String lmla03) {
		this.lmla03 = lmla03;
	}

	public String getLmla04() {
		return this.lmla04;
	}

	public void setLmla04(String lmla04) {
		this.lmla04 = lmla04;
	}

	public String getLmla05() {
		return this.lmla05;
	}

	public void setLmla05(String lmla05) {
		this.lmla05 = lmla05;
	}

	public String getLmla06() {
		return this.lmla06;
	}

	public void setLmla06(String lmla06) {
		this.lmla06 = lmla06;
	}

	public String getLmla07() {
		return this.lmla07;
	}

	public void setLmla07(String lmla07) {
		this.lmla07 = lmla07;
	}

	public String getLmla08() {
		return this.lmla08;
	}

	public void setLmla08(String lmla08) {
		this.lmla08 = lmla08;
	}

	public String getLmla09() {
		return this.lmla09;
	}

	public void setLmla09(String lmla09) {
		this.lmla09 = lmla09;
	}

	public String getLmla10() {
		return this.lmla10;
	}

	public void setLmla10(String lmla10) {
		this.lmla10 = lmla10;
	}

	public String getLmlcod() {
		return this.lmlcod;
	}

	public void setLmlcod(String lmlcod) {
		this.lmlcod = lmlcod;
	}

	public String getLmlhld() {
		return this.lmlhld;
	}

	public void setLmlhld(String lmlhld) {
		this.lmlhld = lmlhld;
	}

	public String getLmlldl() {
		return this.lmlldl;
	}

	public void setLmlldl(String lmlldl) {
		this.lmlldl = lmlldl;
	}

	public String getLmlver() {
		return this.lmlver;
	}

	public void setLmlver(String lmlver) {
		this.lmlver = lmlver;
	}

	public String getLmmcnt() {
		return this.lmmcnt;
	}

	public void setLmmcnt(String lmmcnt) {
		this.lmmcnt = lmmcnt;
	}

	public Double getLmmitm() {
		return this.lmmitm;
	}

	public void setLmmitm(Double lmmitm) {
		this.lmmitm = lmmitm;
	}

	public String getLmmixl() {
		return this.lmmixl;
	}

	public void setLmmixl(String lmmixl) {
		this.lmmixl = lmmixl;
	}

	public String getLmmlot() {
		return this.lmmlot;
	}

	public void setLmmlot(String lmmlot) {
		this.lmmlot = lmmlot;
	}

	public String getLmmmth() {
		return this.lmmmth;
	}

	public void setLmmmth(String lmmmth) {
		this.lmmmth = lmmmth;
	}

	public Double getLmmnuk() {
		return this.lmmnuk;
	}

	public void setLmmnuk(Double lmmnuk) {
		this.lmmnuk = lmmnuk;
	}

	public Double getLmmnup() {
		return this.lmmnup;
	}

	public void setLmmnup(Double lmmnup) {
		this.lmmnup = lmmnup;
	}

	public String getLmmptl() {
		return this.lmmptl;
	}

	public void setLmmptl(String lmmptl) {
		this.lmmptl = lmmptl;
	}

	public String getLmmums() {
		return this.lmmums;
	}

	public void setLmmums(String lmmums) {
		this.lmmums = lmmums;
	}

	public String getLmneta() {
		return this.lmneta;
	}

	public void setLmneta(String lmneta) {
		this.lmneta = lmneta;
	}

	public String getLmot1y() {
		return this.lmot1y;
	}

	public void setLmot1y(String lmot1y) {
		this.lmot1y = lmot1y;
	}

	public String getLmot2y() {
		return this.lmot2y;
	}

	public void setLmot2y(String lmot2y) {
		this.lmot2y = lmot2y;
	}

	public String getLmpcnf() {
		return this.lmpcnf;
	}

	public void setLmpcnf(String lmpcnf) {
		this.lmpcnf = lmpcnf;
	}

	public String getLmpid() {
		return this.lmpid;
	}

	public void setLmpid(String lmpid) {
		this.lmpid = lmpid;
	}

	public String getLmpzon() {
		return this.lmpzon;
	}

	public void setLmpzon(String lmpzon) {
		this.lmpzon = lmpzon;
	}

	public String getLmstag() {
		return this.lmstag;
	}

	public void setLmstag(String lmstag) {
		this.lmstag = lmstag;
	}

	public String getLmstgk() {
		return this.lmstgk;
	}

	public void setLmstgk(String lmstgk) {
		this.lmstgk = lmstgk;
	}

	public String getLmstgp() {
		return this.lmstgp;
	}

	public void setLmstgp(String lmstgp) {
		this.lmstgp = lmstgp;
	}

	public String getLmstgr() {
		return this.lmstgr;
	}

	public void setLmstgr(String lmstgr) {
		this.lmstgr = lmstgr;
	}

	public String getLmsty1() {
		return this.lmsty1;
	}

	public void setLmsty1(String lmsty1) {
		this.lmsty1 = lmsty1;
	}

	public Double getLmtday() {
		return this.lmtday;
	}

	public void setLmtday(Double lmtday) {
		this.lmtday = lmtday;
	}

	public BigDecimal getLmupmj() {
		return this.lmupmj;
	}

	public void setLmupmj(BigDecimal lmupmj) {
		this.lmupmj = lmupmj;
	}

	public Double getLmurab() {
		return this.lmurab;
	}

	public void setLmurab(Double lmurab) {
		this.lmurab = lmurab;
	}

	public Double getLmurat() {
		return this.lmurat;
	}

	public void setLmurat(Double lmurat) {
		this.lmurat = lmurat;
	}

	public String getLmurcd() {
		return this.lmurcd;
	}

	public void setLmurcd(String lmurcd) {
		this.lmurcd = lmurcd;
	}

	public BigDecimal getLmurdt() {
		return this.lmurdt;
	}

	public void setLmurdt(BigDecimal lmurdt) {
		this.lmurdt = lmurdt;
	}

	public String getLmurrf() {
		return this.lmurrf;
	}

	public void setLmurrf(String lmurrf) {
		this.lmurrf = lmurrf;
	}

	public String getLmuser() {
		return this.lmuser;
	}

	public void setLmuser(String lmuser) {
		this.lmuser = lmuser;
	}

	public Double getLmwsqp() {
		return this.lmwsqp;
	}

	public void setLmwsqp(Double lmwsqp) {
		this.lmwsqp = lmwsqp;
	}

	public Double getLmwsqq() {
		return this.lmwsqq;
	}

	public void setLmwsqq(Double lmwsqq) {
		this.lmwsqq = lmwsqq;
	}

	public Double getLmwsqr() {
		return this.lmwsqr;
	}

	public void setLmwsqr(Double lmwsqr) {
		this.lmwsqr = lmwsqr;
	}

	public String getLmzonr() {
		return this.lmzonr;
	}

	public void setLmzonr(String lmzonr) {
		this.lmzonr = lmzonr;
	}

}