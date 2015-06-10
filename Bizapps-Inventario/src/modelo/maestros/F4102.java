package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import modelo.pk.F4102PK;


/**
 * The persistent class for the F4102 database table.
 * 
 */
@Entity
@NamedQuery(name="F4102", query="SELECT f FROM F4102 f")
public class F4102 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4102PK id;

	@Column(name="IBABCI")
	private String ibabci;

	@Column(name="IBABCM")
	private String ibabcm;

	@Column(name="IBABCS")
	private String ibabcs;

	@Column(name="IBACQ")
	private Double ibacq;

	@Column(name="IBAING")
	private String ibaing;

	@Column(name="IBAITM")
	private String ibaitm;

	@Column(name="IBANPL")
	private Double ibanpl;

	@Column(name="IBAPSC")
	private String ibapsc;

	@Column(name="IBASHL")
	private String ibashl;

	@Column(name="IBAVRT")
	private Double ibavrt;

	@Column(name="IBBACK")
	private String ibback;

	@Column(name="IBBBDD")
	private Double ibbbdd;

	@Column(name="IBBQTY")
	private Double ibbqty;

	@Column(name="IBBUYR")
	private Double ibbuyr;

	@Column(name="IBCARP")
	private Double ibcarp;

	@Column(name="IBCARS")
	private Double ibcars;

	@Column(name="IBCDCD")
	private String ibcdcd;

	@Column(name="IBCKAV")
	private String ibckav;

	@Column(name="IBCMCG")
	private String ibcmcg;

	@Column(name="IBCMDM")
	private String ibcmdm;

	@Column(name="IBCMGL")
	private String ibcmgl;

	@Column(name="IBCOMH")
	private Double ibcomh;

	@Column(name="IBCOTY")
	private String ibcoty;

	@Column(name="IBCUTH")
	private Double ibcuth;

	@Column(name="IBCYCL")
	private String ibcycl;

	@Column(name="IBDEFD")
	private Double ibdefd;

	@Column(name="IBDFENDITM")
	private String ibdfenditm;

	@Column(name="IBDFTPCT")
	private Double ibdftpct;

	@Column(name="IBDSGP")
	private String ibdsgp;

	@Column(name="IBECO")
	private String ibeco;

	@Column(name="IBECOD")
	private BigDecimal ibecod;

	@Column(name="IBECTY")
	private String ibecty;

	@Column(name="IBEXPD")
	private Double ibexpd;

	@Column(name="IBFIFO")
	private String ibfifo;

	@Column(name="IBFRGD")
	private String ibfrgd;

	@Column(name="IBFRMP")
	private Double ibfrmp;

	@Column(name="IBFUF1")
	private String ibfuf1;

	@Column(name="IBGLPT")
	private String ibglpt;

	@Column(name="IBIFLA")
	private String ibifla;

	@Column(name="IBINMG")
	private String ibinmg;

	@Column(name="IBITC")
	private String ibitc;

	@Column(name="IBJOBN")
	private String ibjobn;

	@Column(name="IBKANEXLL")
	private String ibkanexll;

	@Column(name="IBKBIT")
	private String ibkbit;

	@Column(name="IBLAF")
	private String iblaf;

	@Column(name="IBLECM")
	private String iblecm;

	@Column(name="IBLEDD")
	private Double ibledd;

	@Column(name="IBLFDJ")
	private BigDecimal iblfdj;

	@Column(name="IBLINE")
	private String ibline;

	@Column(name="IBLITM")
	private String iblitm;

	@Column(name="IBLLX")
	private Double ibllx;

	@Column(name="IBLMFG")
	private String iblmfg;

	@Column(name="IBLNPA")
	private String iblnpa;

	@Column(name="IBLNTY")
	private String iblnty;

	@Column(name="IBLOTC")
	private String iblotc;

	@Column(name="IBLOTS")
	private String iblots;

	@Column(name="IBLTCM")
	private Double ibltcm;

	@Column(name="IBLTCV")
	private Double ibltcv;

	@Column(name="IBLTFM")
	private String ibltfm;

	@Column(name="IBLTLV")
	private Double ibltlv;

	@Column(name="IBLTMF")
	private Double ibltmf;

	@Column(name="IBLTPU")
	private Double ibltpu;

	@Column(name="IBMAKE")
	private String ibmake;

	@Column(name="IBMERL")
	private String ibmerl;

	@Column(name="IBMLOT")
	private String ibmlot;

	@Column(name="IBMLQ")
	private Double ibmlq;

	@Column(name="IBMMPC")
	private Double ibmmpc;

	@Column(name="IBMOVD")
	private Double ibmovd;

	@Column(name="IBMPSP")
	private String ibmpsp;

	@Column(name="IBMPST")
	private String ibmpst;

	@Column(name="IBMRPC")
	private String ibmrpc;

	@Column(name="IBMRPD")
	private String ibmrpd;

	@Column(name="IBMRPP")
	private String ibmrpp;

	@Column(name="IBMTF1")
	private Double ibmtf1;

	@Column(name="IBMTF2")
	private Double ibmtf2;

	@Column(name="IBMTF3")
	private Double ibmtf3;

	@Column(name="IBMTF4")
	private Double ibmtf4;

	@Column(name="IBMTF5")
	private Double ibmtf5;

	@Column(name="IBMULT")
	private Double ibmult;

	@Column(name="IBOPC")
	private String ibopc;

	@Column(name="IBOPTH")
	private Double ibopth;

	@Column(name="IBOPV")
	private Double ibopv;

	@Column(name="IBORDW")
	private String ibordw;

	@Column(name="IBORIG")
	private String iborig;

	@Column(name="IBORPR")
	private String iborpr;

	@Column(name="IBOT1Y")
	private String ibot1y;

	@Column(name="IBOT2Y")
	private String ibot2y;

	@Column(name="IBOVR")
	private String ibovr;

	@Column(name="IBPCTM")
	private Double ibpctm;

	@Column(name="IBPDGR")
	private String ibpdgr;

	@Column(name="IBPEFD")
	private Double ibpefd;

	@Column(name="IBPID")
	private String ibpid;

	@Column(name="IBPOC")
	private String ibpoc;

	@Column(name="IBPRGR")
	private String ibprgr;

	@Column(name="IBPRI1")
	private Double ibpri1;

	@Column(name="IBPRI2")
	private Double ibpri2;

	@Column(name="IBPRP0")
	private String ibprp0;

	@Column(name="IBPRP1")
	private String ibprp1;

	@Column(name="IBPRP2")
	private String ibprp2;

	@Column(name="IBPRP3")
	private String ibprp3;

	@Column(name="IBPRP4")
	private String ibprp4;

	@Column(name="IBPRP5")
	private String ibprp5;

	@Column(name="IBPRP6")
	private String ibprp6;

	@Column(name="IBPRP7")
	private String ibprp7;

	@Column(name="IBPRP8")
	private String ibprp8;

	@Column(name="IBPRP9")
	private String ibprp9;

	@Column(name="IBQUED")
	private Double ibqued;

	@Column(name="IBROPI")
	private Double ibropi;

	@Column(name="IBROQI")
	private Double ibroqi;

	@Column(name="IBRPRC")
	private String ibrprc;

	@Column(name="IBRQMN")
	private Double ibrqmn;

	@Column(name="IBRQMX")
	private Double ibrqmx;

	@Column(name="IBRWLA")
	private String ibrwla;

	@Column(name="IBSAFE")
	private Double ibsafe;

	@Column(name="IBSBDD")
	private Double ibsbdd;

	@Column(name="IBSCPSELL")
	private String ibscpsell;

	@Column(name="IBSERV")
	private Double ibserv;

	@Column(name="IBSETL")
	private Double ibsetl;

	@Column(name="IBSFLT")
	private Double ibsflt;

	@Column(name="IBSHCM")
	private String ibshcm;

	@Column(name="IBSHCN")
	private String ibshcn;

	@Column(name="IBSLD")
	private Double ibsld;

	@Column(name="IBSNS")
	private String ibsns;

	@Column(name="IBSRCE")
	private String ibsrce;

	@Column(name="IBSRKF")
	private String ibsrkf;

	@Column(name="IBSRNK")
	private Double ibsrnk;

	@Column(name="IBSRNR")
	private String ibsrnr;

	@Column(name="IBSRP0")
	private String ibsrp0;

	@Column(name="IBSRP1")
	private String ibsrp1;

	@Column(name="IBSRP2")
	private String ibsrp2;

	@Column(name="IBSRP3")
	private String ibsrp3;

	@Column(name="IBSRP4")
	private String ibsrp4;

	@Column(name="IBSRP5")
	private String ibsrp5;

	@Column(name="IBSRP6")
	private String ibsrp6;

	@Column(name="IBSRP7")
	private String ibsrp7;

	@Column(name="IBSRP8")
	private String ibsrp8;

	@Column(name="IBSRP9")
	private String ibsrp9;

	@Column(name="IBSTDG")
	private String ibstdg;

	@Column(name="IBSTDP")
	private Double ibstdp;

	@Column(name="IBSTKT")
	private String ibstkt;

	@Column(name="IBTAX1")
	private String ibtax1;

	@Column(name="IBTDAY")
	private Double ibtday;

	@Column(name="IBTFLA")
	private String ibtfla;

	@Column(name="IBTHGD")
	private String ibthgd;

	@Column(name="IBTHRP")
	private Double ibthrp;

	@Column(name="IBTIMB")
	private String ibtimb;

	@Column(name="IBTX")
	private String ibtx;

	@Column(name="IBU1DD")
	private Double ibu1dd;

	@Column(name="IBU2DD")
	private Double ibu2dd;

	@Column(name="IBU3DD")
	private Double ibu3dd;

	@Column(name="IBU4DD")
	private Double ibu4dd;

	@Column(name="IBU5DD")
	private Double ibu5dd;

	@Column(name="IBUMTH")
	private String ibumth;

	@Column(name="IBUPC")
	private Double ibupc;

	@Column(name="IBUPMJ")
	private BigDecimal ibupmj;

	@Column(name="IBURAB")
	private Double iburab;

	@Column(name="IBURAT")
	private Double iburat;

	@Column(name="IBURCD")
	private String iburcd;

	@Column(name="IBURDT")
	private BigDecimal iburdt;

	@Column(name="IBURRF")
	private String iburrf;

	@Column(name="IBUSER")
	private String ibuser;

	@Column(name="IBVEND")
	private Double ibvend;

	@Column(name="IBWARR")
	private String ibwarr;

	@Column(name="IBWOMO")
	private Double ibwomo;

	@Column(name="IBXDCK")
	private String ibxdck;

	public F4102() {
	}

	public F4102PK getId() {
		return this.id;
	}

	public void setId(F4102PK id) {
		this.id = id;
	}

	public String getIbabci() {
		return this.ibabci;
	}

	public void setIbabci(String ibabci) {
		this.ibabci = ibabci;
	}

	public String getIbabcm() {
		return this.ibabcm;
	}

	public void setIbabcm(String ibabcm) {
		this.ibabcm = ibabcm;
	}

	public String getIbabcs() {
		return this.ibabcs;
	}

	public void setIbabcs(String ibabcs) {
		this.ibabcs = ibabcs;
	}

	public Double getIbacq() {
		return this.ibacq;
	}

	public void setIbacq(Double ibacq) {
		this.ibacq = ibacq;
	}

	public String getIbaing() {
		return this.ibaing;
	}

	public void setIbaing(String ibaing) {
		this.ibaing = ibaing;
	}

	public String getIbaitm() {
		return this.ibaitm;
	}

	public void setIbaitm(String ibaitm) {
		this.ibaitm = ibaitm;
	}

	public Double getIbanpl() {
		return this.ibanpl;
	}

	public void setIbanpl(Double ibanpl) {
		this.ibanpl = ibanpl;
	}

	public String getIbapsc() {
		return this.ibapsc;
	}

	public void setIbapsc(String ibapsc) {
		this.ibapsc = ibapsc;
	}

	public String getIbashl() {
		return this.ibashl;
	}

	public void setIbashl(String ibashl) {
		this.ibashl = ibashl;
	}

	public Double getIbavrt() {
		return this.ibavrt;
	}

	public void setIbavrt(Double ibavrt) {
		this.ibavrt = ibavrt;
	}

	public String getIbback() {
		return this.ibback;
	}

	public void setIbback(String ibback) {
		this.ibback = ibback;
	}

	public Double getIbbbdd() {
		return this.ibbbdd;
	}

	public void setIbbbdd(Double ibbbdd) {
		this.ibbbdd = ibbbdd;
	}

	public Double getIbbqty() {
		return this.ibbqty;
	}

	public void setIbbqty(Double ibbqty) {
		this.ibbqty = ibbqty;
	}

	public Double getIbbuyr() {
		return this.ibbuyr;
	}

	public void setIbbuyr(Double ibbuyr) {
		this.ibbuyr = ibbuyr;
	}

	public Double getIbcarp() {
		return this.ibcarp;
	}

	public void setIbcarp(Double ibcarp) {
		this.ibcarp = ibcarp;
	}

	public Double getIbcars() {
		return this.ibcars;
	}

	public void setIbcars(Double ibcars) {
		this.ibcars = ibcars;
	}

	public String getIbcdcd() {
		return this.ibcdcd;
	}

	public void setIbcdcd(String ibcdcd) {
		this.ibcdcd = ibcdcd;
	}

	public String getIbckav() {
		return this.ibckav;
	}

	public void setIbckav(String ibckav) {
		this.ibckav = ibckav;
	}

	public String getIbcmcg() {
		return this.ibcmcg;
	}

	public void setIbcmcg(String ibcmcg) {
		this.ibcmcg = ibcmcg;
	}

	public String getIbcmdm() {
		return this.ibcmdm;
	}

	public void setIbcmdm(String ibcmdm) {
		this.ibcmdm = ibcmdm;
	}

	public String getIbcmgl() {
		return this.ibcmgl;
	}

	public void setIbcmgl(String ibcmgl) {
		this.ibcmgl = ibcmgl;
	}

	public Double getIbcomh() {
		return this.ibcomh;
	}

	public void setIbcomh(Double ibcomh) {
		this.ibcomh = ibcomh;
	}

	public String getIbcoty() {
		return this.ibcoty;
	}

	public void setIbcoty(String ibcoty) {
		this.ibcoty = ibcoty;
	}

	public Double getIbcuth() {
		return this.ibcuth;
	}

	public void setIbcuth(Double ibcuth) {
		this.ibcuth = ibcuth;
	}

	public String getIbcycl() {
		return this.ibcycl;
	}

	public void setIbcycl(String ibcycl) {
		this.ibcycl = ibcycl;
	}

	public Double getIbdefd() {
		return this.ibdefd;
	}

	public void setIbdefd(Double ibdefd) {
		this.ibdefd = ibdefd;
	}

	public String getIbdfenditm() {
		return this.ibdfenditm;
	}

	public void setIbdfenditm(String ibdfenditm) {
		this.ibdfenditm = ibdfenditm;
	}

	public Double getIbdftpct() {
		return this.ibdftpct;
	}

	public void setIbdftpct(Double ibdftpct) {
		this.ibdftpct = ibdftpct;
	}

	public String getIbdsgp() {
		return this.ibdsgp;
	}

	public void setIbdsgp(String ibdsgp) {
		this.ibdsgp = ibdsgp;
	}

	public String getIbeco() {
		return this.ibeco;
	}

	public void setIbeco(String ibeco) {
		this.ibeco = ibeco;
	}

	public BigDecimal getIbecod() {
		return this.ibecod;
	}

	public void setIbecod(BigDecimal ibecod) {
		this.ibecod = ibecod;
	}

	public String getIbecty() {
		return this.ibecty;
	}

	public void setIbecty(String ibecty) {
		this.ibecty = ibecty;
	}

	public Double getIbexpd() {
		return this.ibexpd;
	}

	public void setIbexpd(Double ibexpd) {
		this.ibexpd = ibexpd;
	}

	public String getIbfifo() {
		return this.ibfifo;
	}

	public void setIbfifo(String ibfifo) {
		this.ibfifo = ibfifo;
	}

	public String getIbfrgd() {
		return this.ibfrgd;
	}

	public void setIbfrgd(String ibfrgd) {
		this.ibfrgd = ibfrgd;
	}

	public Double getIbfrmp() {
		return this.ibfrmp;
	}

	public void setIbfrmp(Double ibfrmp) {
		this.ibfrmp = ibfrmp;
	}

	public String getIbfuf1() {
		return this.ibfuf1;
	}

	public void setIbfuf1(String ibfuf1) {
		this.ibfuf1 = ibfuf1;
	}

	public String getIbglpt() {
		return this.ibglpt;
	}

	public void setIbglpt(String ibglpt) {
		this.ibglpt = ibglpt;
	}

	public String getIbifla() {
		return this.ibifla;
	}

	public void setIbifla(String ibifla) {
		this.ibifla = ibifla;
	}

	public String getIbinmg() {
		return this.ibinmg;
	}

	public void setIbinmg(String ibinmg) {
		this.ibinmg = ibinmg;
	}

	public String getIbitc() {
		return this.ibitc;
	}

	public void setIbitc(String ibitc) {
		this.ibitc = ibitc;
	}

	public String getIbjobn() {
		return this.ibjobn;
	}

	public void setIbjobn(String ibjobn) {
		this.ibjobn = ibjobn;
	}

	public String getIbkanexll() {
		return this.ibkanexll;
	}

	public void setIbkanexll(String ibkanexll) {
		this.ibkanexll = ibkanexll;
	}

	public String getIbkbit() {
		return this.ibkbit;
	}

	public void setIbkbit(String ibkbit) {
		this.ibkbit = ibkbit;
	}

	public String getIblaf() {
		return this.iblaf;
	}

	public void setIblaf(String iblaf) {
		this.iblaf = iblaf;
	}

	public String getIblecm() {
		return this.iblecm;
	}

	public void setIblecm(String iblecm) {
		this.iblecm = iblecm;
	}

	public Double getIbledd() {
		return this.ibledd;
	}

	public void setIbledd(Double ibledd) {
		this.ibledd = ibledd;
	}

	public BigDecimal getIblfdj() {
		return this.iblfdj;
	}

	public void setIblfdj(BigDecimal iblfdj) {
		this.iblfdj = iblfdj;
	}

	public String getIbline() {
		return this.ibline;
	}

	public void setIbline(String ibline) {
		this.ibline = ibline;
	}

	public String getIblitm() {
		return this.iblitm;
	}

	public void setIblitm(String iblitm) {
		this.iblitm = iblitm;
	}

	public Double getIbllx() {
		return this.ibllx;
	}

	public void setIbllx(Double ibllx) {
		this.ibllx = ibllx;
	}

	public String getIblmfg() {
		return this.iblmfg;
	}

	public void setIblmfg(String iblmfg) {
		this.iblmfg = iblmfg;
	}

	public String getIblnpa() {
		return this.iblnpa;
	}

	public void setIblnpa(String iblnpa) {
		this.iblnpa = iblnpa;
	}

	public String getIblnty() {
		return this.iblnty;
	}

	public void setIblnty(String iblnty) {
		this.iblnty = iblnty;
	}

	public String getIblotc() {
		return this.iblotc;
	}

	public void setIblotc(String iblotc) {
		this.iblotc = iblotc;
	}

	public String getIblots() {
		return this.iblots;
	}

	public void setIblots(String iblots) {
		this.iblots = iblots;
	}

	public Double getIbltcm() {
		return this.ibltcm;
	}

	public void setIbltcm(Double ibltcm) {
		this.ibltcm = ibltcm;
	}

	public Double getIbltcv() {
		return this.ibltcv;
	}

	public void setIbltcv(Double ibltcv) {
		this.ibltcv = ibltcv;
	}

	public String getIbltfm() {
		return this.ibltfm;
	}

	public void setIbltfm(String ibltfm) {
		this.ibltfm = ibltfm;
	}

	public Double getIbltlv() {
		return this.ibltlv;
	}

	public void setIbltlv(Double ibltlv) {
		this.ibltlv = ibltlv;
	}

	public Double getIbltmf() {
		return this.ibltmf;
	}

	public void setIbltmf(Double ibltmf) {
		this.ibltmf = ibltmf;
	}

	public Double getIbltpu() {
		return this.ibltpu;
	}

	public void setIbltpu(Double ibltpu) {
		this.ibltpu = ibltpu;
	}

	public String getIbmake() {
		return this.ibmake;
	}

	public void setIbmake(String ibmake) {
		this.ibmake = ibmake;
	}

	public String getIbmerl() {
		return this.ibmerl;
	}

	public void setIbmerl(String ibmerl) {
		this.ibmerl = ibmerl;
	}

	public String getIbmlot() {
		return this.ibmlot;
	}

	public void setIbmlot(String ibmlot) {
		this.ibmlot = ibmlot;
	}

	public Double getIbmlq() {
		return this.ibmlq;
	}

	public void setIbmlq(Double ibmlq) {
		this.ibmlq = ibmlq;
	}

	public Double getIbmmpc() {
		return this.ibmmpc;
	}

	public void setIbmmpc(Double ibmmpc) {
		this.ibmmpc = ibmmpc;
	}

	public Double getIbmovd() {
		return this.ibmovd;
	}

	public void setIbmovd(Double ibmovd) {
		this.ibmovd = ibmovd;
	}

	public String getIbmpsp() {
		return this.ibmpsp;
	}

	public void setIbmpsp(String ibmpsp) {
		this.ibmpsp = ibmpsp;
	}

	public String getIbmpst() {
		return this.ibmpst;
	}

	public void setIbmpst(String ibmpst) {
		this.ibmpst = ibmpst;
	}

	public String getIbmrpc() {
		return this.ibmrpc;
	}

	public void setIbmrpc(String ibmrpc) {
		this.ibmrpc = ibmrpc;
	}

	public String getIbmrpd() {
		return this.ibmrpd;
	}

	public void setIbmrpd(String ibmrpd) {
		this.ibmrpd = ibmrpd;
	}

	public String getIbmrpp() {
		return this.ibmrpp;
	}

	public void setIbmrpp(String ibmrpp) {
		this.ibmrpp = ibmrpp;
	}

	public Double getIbmtf1() {
		return this.ibmtf1;
	}

	public void setIbmtf1(Double ibmtf1) {
		this.ibmtf1 = ibmtf1;
	}

	public Double getIbmtf2() {
		return this.ibmtf2;
	}

	public void setIbmtf2(Double ibmtf2) {
		this.ibmtf2 = ibmtf2;
	}

	public Double getIbmtf3() {
		return this.ibmtf3;
	}

	public void setIbmtf3(Double ibmtf3) {
		this.ibmtf3 = ibmtf3;
	}

	public Double getIbmtf4() {
		return this.ibmtf4;
	}

	public void setIbmtf4(Double ibmtf4) {
		this.ibmtf4 = ibmtf4;
	}

	public Double getIbmtf5() {
		return this.ibmtf5;
	}

	public void setIbmtf5(Double ibmtf5) {
		this.ibmtf5 = ibmtf5;
	}

	public Double getIbmult() {
		return this.ibmult;
	}

	public void setIbmult(Double ibmult) {
		this.ibmult = ibmult;
	}

	public String getIbopc() {
		return this.ibopc;
	}

	public void setIbopc(String ibopc) {
		this.ibopc = ibopc;
	}

	public Double getIbopth() {
		return this.ibopth;
	}

	public void setIbopth(Double ibopth) {
		this.ibopth = ibopth;
	}

	public Double getIbopv() {
		return this.ibopv;
	}

	public void setIbopv(Double ibopv) {
		this.ibopv = ibopv;
	}

	public String getIbordw() {
		return this.ibordw;
	}

	public void setIbordw(String ibordw) {
		this.ibordw = ibordw;
	}

	public String getIborig() {
		return this.iborig;
	}

	public void setIborig(String iborig) {
		this.iborig = iborig;
	}

	public String getIborpr() {
		return this.iborpr;
	}

	public void setIborpr(String iborpr) {
		this.iborpr = iborpr;
	}

	public String getIbot1y() {
		return this.ibot1y;
	}

	public void setIbot1y(String ibot1y) {
		this.ibot1y = ibot1y;
	}

	public String getIbot2y() {
		return this.ibot2y;
	}

	public void setIbot2y(String ibot2y) {
		this.ibot2y = ibot2y;
	}

	public String getIbovr() {
		return this.ibovr;
	}

	public void setIbovr(String ibovr) {
		this.ibovr = ibovr;
	}

	public Double getIbpctm() {
		return this.ibpctm;
	}

	public void setIbpctm(Double ibpctm) {
		this.ibpctm = ibpctm;
	}

	public String getIbpdgr() {
		return this.ibpdgr;
	}

	public void setIbpdgr(String ibpdgr) {
		this.ibpdgr = ibpdgr;
	}

	public Double getIbpefd() {
		return this.ibpefd;
	}

	public void setIbpefd(Double ibpefd) {
		this.ibpefd = ibpefd;
	}

	public String getIbpid() {
		return this.ibpid;
	}

	public void setIbpid(String ibpid) {
		this.ibpid = ibpid;
	}

	public String getIbpoc() {
		return this.ibpoc;
	}

	public void setIbpoc(String ibpoc) {
		this.ibpoc = ibpoc;
	}

	public String getIbprgr() {
		return this.ibprgr;
	}

	public void setIbprgr(String ibprgr) {
		this.ibprgr = ibprgr;
	}

	public Double getIbpri1() {
		return this.ibpri1;
	}

	public void setIbpri1(Double ibpri1) {
		this.ibpri1 = ibpri1;
	}

	public Double getIbpri2() {
		return this.ibpri2;
	}

	public void setIbpri2(Double ibpri2) {
		this.ibpri2 = ibpri2;
	}

	public String getIbprp0() {
		return this.ibprp0;
	}

	public void setIbprp0(String ibprp0) {
		this.ibprp0 = ibprp0;
	}

	public String getIbprp1() {
		return this.ibprp1;
	}

	public void setIbprp1(String ibprp1) {
		this.ibprp1 = ibprp1;
	}

	public String getIbprp2() {
		return this.ibprp2;
	}

	public void setIbprp2(String ibprp2) {
		this.ibprp2 = ibprp2;
	}

	public String getIbprp3() {
		return this.ibprp3;
	}

	public void setIbprp3(String ibprp3) {
		this.ibprp3 = ibprp3;
	}

	public String getIbprp4() {
		return this.ibprp4;
	}

	public void setIbprp4(String ibprp4) {
		this.ibprp4 = ibprp4;
	}

	public String getIbprp5() {
		return this.ibprp5;
	}

	public void setIbprp5(String ibprp5) {
		this.ibprp5 = ibprp5;
	}

	public String getIbprp6() {
		return this.ibprp6;
	}

	public void setIbprp6(String ibprp6) {
		this.ibprp6 = ibprp6;
	}

	public String getIbprp7() {
		return this.ibprp7;
	}

	public void setIbprp7(String ibprp7) {
		this.ibprp7 = ibprp7;
	}

	public String getIbprp8() {
		return this.ibprp8;
	}

	public void setIbprp8(String ibprp8) {
		this.ibprp8 = ibprp8;
	}

	public String getIbprp9() {
		return this.ibprp9;
	}

	public void setIbprp9(String ibprp9) {
		this.ibprp9 = ibprp9;
	}

	public Double getIbqued() {
		return this.ibqued;
	}

	public void setIbqued(Double ibqued) {
		this.ibqued = ibqued;
	}

	public Double getIbropi() {
		return this.ibropi;
	}

	public void setIbropi(Double ibropi) {
		this.ibropi = ibropi;
	}

	public Double getIbroqi() {
		return this.ibroqi;
	}

	public void setIbroqi(Double ibroqi) {
		this.ibroqi = ibroqi;
	}

	public String getIbrprc() {
		return this.ibrprc;
	}

	public void setIbrprc(String ibrprc) {
		this.ibrprc = ibrprc;
	}

	public Double getIbrqmn() {
		return this.ibrqmn;
	}

	public void setIbrqmn(Double ibrqmn) {
		this.ibrqmn = ibrqmn;
	}

	public Double getIbrqmx() {
		return this.ibrqmx;
	}

	public void setIbrqmx(Double ibrqmx) {
		this.ibrqmx = ibrqmx;
	}

	public String getIbrwla() {
		return this.ibrwla;
	}

	public void setIbrwla(String ibrwla) {
		this.ibrwla = ibrwla;
	}

	public Double getIbsafe() {
		return this.ibsafe;
	}

	public void setIbsafe(Double ibsafe) {
		this.ibsafe = ibsafe;
	}

	public Double getIbsbdd() {
		return this.ibsbdd;
	}

	public void setIbsbdd(Double ibsbdd) {
		this.ibsbdd = ibsbdd;
	}

	public String getIbscpsell() {
		return this.ibscpsell;
	}

	public void setIbscpsell(String ibscpsell) {
		this.ibscpsell = ibscpsell;
	}

	public Double getIbserv() {
		return this.ibserv;
	}

	public void setIbserv(Double ibserv) {
		this.ibserv = ibserv;
	}

	public Double getIbsetl() {
		return this.ibsetl;
	}

	public void setIbsetl(Double ibsetl) {
		this.ibsetl = ibsetl;
	}

	public Double getIbsflt() {
		return this.ibsflt;
	}

	public void setIbsflt(Double ibsflt) {
		this.ibsflt = ibsflt;
	}

	public String getIbshcm() {
		return this.ibshcm;
	}

	public void setIbshcm(String ibshcm) {
		this.ibshcm = ibshcm;
	}

	public String getIbshcn() {
		return this.ibshcn;
	}

	public void setIbshcn(String ibshcn) {
		this.ibshcn = ibshcn;
	}

	public Double getIbsld() {
		return this.ibsld;
	}

	public void setIbsld(Double ibsld) {
		this.ibsld = ibsld;
	}

	public String getIbsns() {
		return this.ibsns;
	}

	public void setIbsns(String ibsns) {
		this.ibsns = ibsns;
	}

	public String getIbsrce() {
		return this.ibsrce;
	}

	public void setIbsrce(String ibsrce) {
		this.ibsrce = ibsrce;
	}

	public String getIbsrkf() {
		return this.ibsrkf;
	}

	public void setIbsrkf(String ibsrkf) {
		this.ibsrkf = ibsrkf;
	}

	public Double getIbsrnk() {
		return this.ibsrnk;
	}

	public void setIbsrnk(Double ibsrnk) {
		this.ibsrnk = ibsrnk;
	}

	public String getIbsrnr() {
		return this.ibsrnr;
	}

	public void setIbsrnr(String ibsrnr) {
		this.ibsrnr = ibsrnr;
	}

	public String getIbsrp0() {
		return this.ibsrp0;
	}

	public void setIbsrp0(String ibsrp0) {
		this.ibsrp0 = ibsrp0;
	}

	public String getIbsrp1() {
		return this.ibsrp1;
	}

	public void setIbsrp1(String ibsrp1) {
		this.ibsrp1 = ibsrp1;
	}

	public String getIbsrp2() {
		return this.ibsrp2;
	}

	public void setIbsrp2(String ibsrp2) {
		this.ibsrp2 = ibsrp2;
	}

	public String getIbsrp3() {
		return this.ibsrp3;
	}

	public void setIbsrp3(String ibsrp3) {
		this.ibsrp3 = ibsrp3;
	}

	public String getIbsrp4() {
		return this.ibsrp4;
	}

	public void setIbsrp4(String ibsrp4) {
		this.ibsrp4 = ibsrp4;
	}

	public String getIbsrp5() {
		return this.ibsrp5;
	}

	public void setIbsrp5(String ibsrp5) {
		this.ibsrp5 = ibsrp5;
	}

	public String getIbsrp6() {
		return this.ibsrp6;
	}

	public void setIbsrp6(String ibsrp6) {
		this.ibsrp6 = ibsrp6;
	}

	public String getIbsrp7() {
		return this.ibsrp7;
	}

	public void setIbsrp7(String ibsrp7) {
		this.ibsrp7 = ibsrp7;
	}

	public String getIbsrp8() {
		return this.ibsrp8;
	}

	public void setIbsrp8(String ibsrp8) {
		this.ibsrp8 = ibsrp8;
	}

	public String getIbsrp9() {
		return this.ibsrp9;
	}

	public void setIbsrp9(String ibsrp9) {
		this.ibsrp9 = ibsrp9;
	}

	public String getIbstdg() {
		return this.ibstdg;
	}

	public void setIbstdg(String ibstdg) {
		this.ibstdg = ibstdg;
	}

	public Double getIbstdp() {
		return this.ibstdp;
	}

	public void setIbstdp(Double ibstdp) {
		this.ibstdp = ibstdp;
	}

	public String getIbstkt() {
		return this.ibstkt;
	}

	public void setIbstkt(String ibstkt) {
		this.ibstkt = ibstkt;
	}

	public String getIbtax1() {
		return this.ibtax1;
	}

	public void setIbtax1(String ibtax1) {
		this.ibtax1 = ibtax1;
	}

	public Double getIbtday() {
		return this.ibtday;
	}

	public void setIbtday(Double ibtday) {
		this.ibtday = ibtday;
	}

	public String getIbtfla() {
		return this.ibtfla;
	}

	public void setIbtfla(String ibtfla) {
		this.ibtfla = ibtfla;
	}

	public String getIbthgd() {
		return this.ibthgd;
	}

	public void setIbthgd(String ibthgd) {
		this.ibthgd = ibthgd;
	}

	public Double getIbthrp() {
		return this.ibthrp;
	}

	public void setIbthrp(Double ibthrp) {
		this.ibthrp = ibthrp;
	}

	public String getIbtimb() {
		return this.ibtimb;
	}

	public void setIbtimb(String ibtimb) {
		this.ibtimb = ibtimb;
	}

	public String getIbtx() {
		return this.ibtx;
	}

	public void setIbtx(String ibtx) {
		this.ibtx = ibtx;
	}

	public Double getIbu1dd() {
		return this.ibu1dd;
	}

	public void setIbu1dd(Double ibu1dd) {
		this.ibu1dd = ibu1dd;
	}

	public Double getIbu2dd() {
		return this.ibu2dd;
	}

	public void setIbu2dd(Double ibu2dd) {
		this.ibu2dd = ibu2dd;
	}

	public Double getIbu3dd() {
		return this.ibu3dd;
	}

	public void setIbu3dd(Double ibu3dd) {
		this.ibu3dd = ibu3dd;
	}

	public Double getIbu4dd() {
		return this.ibu4dd;
	}

	public void setIbu4dd(Double ibu4dd) {
		this.ibu4dd = ibu4dd;
	}

	public Double getIbu5dd() {
		return this.ibu5dd;
	}

	public void setIbu5dd(Double ibu5dd) {
		this.ibu5dd = ibu5dd;
	}

	public String getIbumth() {
		return this.ibumth;
	}

	public void setIbumth(String ibumth) {
		this.ibumth = ibumth;
	}

	public Double getIbupc() {
		return this.ibupc;
	}

	public void setIbupc(Double ibupc) {
		this.ibupc = ibupc;
	}

	public BigDecimal getIbupmj() {
		return this.ibupmj;
	}

	public void setIbupmj(BigDecimal ibupmj) {
		this.ibupmj = ibupmj;
	}

	public Double getIburab() {
		return this.iburab;
	}

	public void setIburab(Double iburab) {
		this.iburab = iburab;
	}

	public Double getIburat() {
		return this.iburat;
	}

	public void setIburat(Double iburat) {
		this.iburat = iburat;
	}

	public String getIburcd() {
		return this.iburcd;
	}

	public void setIburcd(String iburcd) {
		this.iburcd = iburcd;
	}

	public BigDecimal getIburdt() {
		return this.iburdt;
	}

	public void setIburdt(BigDecimal iburdt) {
		this.iburdt = iburdt;
	}

	public String getIburrf() {
		return this.iburrf;
	}

	public void setIburrf(String iburrf) {
		this.iburrf = iburrf;
	}

	public String getIbuser() {
		return this.ibuser;
	}

	public void setIbuser(String ibuser) {
		this.ibuser = ibuser;
	}

	public Double getIbvend() {
		return this.ibvend;
	}

	public void setIbvend(Double ibvend) {
		this.ibvend = ibvend;
	}

	public String getIbwarr() {
		return this.ibwarr;
	}

	public void setIbwarr(String ibwarr) {
		this.ibwarr = ibwarr;
	}

	public Double getIbwomo() {
		return this.ibwomo;
	}

	public void setIbwomo(Double ibwomo) {
		this.ibwomo = ibwomo;
	}

	public String getIbxdck() {
		return this.ibxdck;
	}

	public void setIbxdck(String ibxdck) {
		this.ibxdck = ibxdck;
	}

}