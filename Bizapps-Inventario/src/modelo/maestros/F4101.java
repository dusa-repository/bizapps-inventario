package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the F4101 database table.
 * 
 */
@Entity
public class F4101 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMITM")
	private double imitm;

	@Column(name="IMABCI")
	private Object imabci;

	@Column(name="IMABCM")
	private Object imabcm;

	@Column(name="IMABCS")
	private Object imabcs;

	@Column(name="IMACQ")
	private double imacq;

	@Column(name="IMAING")
	private Object imaing;

	@Column(name="IMAITM")
	private Object imaitm;

	@Column(name="IMALN")
	private Object imaln;

	@Column(name="IMANPL")
	private double imanpl;

	@Column(name="IMAPSC")
	private Object imapsc;

	@Column(name="IMASHL")
	private Object imashl;

	@Column(name="IMAUOM")
	private Object imauom;

	@Column(name="IMAVRT")
	private double imavrt;

	@Column(name="IMBACK")
	private Object imback;

	@Column(name="IMBBDD")
	private double imbbdd;

	@Column(name="IMBPFG")
	private Object imbpfg;

	@Column(name="IMBUYR")
	private double imbuyr;

	@Column(name="IMCARP")
	private double imcarp;

	@Column(name="IMCARS")
	private double imcars;

	@Column(name="IMCDCD")
	private Object imcdcd;

	@Column(name="IMCKAV")
	private Object imckav;

	@Column(name="IMCLEV")
	private Object imclev;

	@Column(name="IMCMCG")
	private Object imcmcg;

	@Column(name="IMCMDM")
	private Object imcmdm;

	@Column(name="IMCMETH")
	private Object imcmeth;

	@Column(name="IMCMGL")
	private Object imcmgl;

	@Column(name="IMCOBY")
	private Object imcoby;

	@Column(name="IMCOMH")
	private double imcomh;

	@Column(name="IMCONB")
	private Object imconb;

	@Column(name="IMCONT")
	private Object imcont;

	@Column(name="IMCOTY")
	private Object imcoty;

	@Column(name="IMCUTH")
	private double imcuth;

	@Column(name="IMCYCL")
	private Object imcycl;

	@Column(name="IMDEFD")
	private double imdefd;

	@Column(name="IMDFENDITM")
	private Object imdfenditm;

	@Column(name="IMDFTPCT")
	private double imdftpct;

	@Column(name="IMDLTL")
	private double imdltl;

	@Column(name="IMDPPO")
	private Object imdppo;

	@Column(name="IMDRAW")
	private Object imdraw;

	@Column(name="IMDSC1")
	private Object imdsc1;

	@Column(name="IMDSC2")
	private Object imdsc2;

	@Column(name="IMDSGP")
	private Object imdsgp;

	@Column(name="IMDSZE")
	private Object imdsze;

	@Column(name="IMDUAL")
	private Object imdual;

	@Column(name="IMEQTY")
	private Object imeqty;

	@Column(name="IMEXPD")
	private double imexpd;

	@Column(name="IMEXPI")
	private Object imexpi;

	@Column(name="IMFIFO")
	private Object imfifo;

	@Column(name="IMFRGD")
	private Object imfrgd;

	@Column(name="IMFRMP")
	private double imfrmp;

	@Column(name="IMGCMP")
	private Object imgcmp;

	@Column(name="IMGLPT")
	private Object imglpt;

	@Column(name="IMIFLA")
	private Object imifla;

	@Column(name="IMINMG")
	private Object iminmg;

	@Column(name="IMITC")
	private Object imitc;

	@Column(name="IMJOBN")
	private Object imjobn;

	@Column(name="IMKANEXLL")
	private Object imkanexll;

	@Column(name="IMKBIT")
	private Object imkbit;

	@Column(name="IMLAF")
	private Object imlaf;

	@Column(name="IMLECM")
	private Object imlecm;

	@Column(name="IMLEDD")
	private double imledd;

	@Column(name="IMLINE")
	private Object imline;

	@Column(name="IMLITM")
	private Object imlitm;

	@Column(name="IMLLX")
	private double imllx;

	@Column(name="IMLMFG")
	private Object imlmfg;

	@Column(name="IMLNPA")
	private Object imlnpa;

	@Column(name="IMLNTY")
	private Object imlnty;

	@Column(name="IMLOTC")
	private Object imlotc;

	@Column(name="IMLOTS")
	private Object imlots;

	@Column(name="IMLTCM")
	private double imltcm;

	@Column(name="IMLTFM")
	private Object imltfm;

	@Column(name="IMLTLV")
	private double imltlv;

	@Column(name="IMLTMF")
	private double imltmf;

	@Column(name="IMLTPU")
	private double imltpu;

	@Column(name="IMMAKE")
	private Object immake;

	@Column(name="IMMIC")
	private Object immic;

	@Column(name="IMMLQ")
	private double immlq;

	@Column(name="IMMMPC")
	private double immmpc;

	@Column(name="IMMPSP")
	private Object immpsp;

	@Column(name="IMMPST")
	private Object immpst;

	@Column(name="IMMRPP")
	private Object immrpp;

	@Column(name="IMMTF1")
	private double immtf1;

	@Column(name="IMMTF2")
	private double immtf2;

	@Column(name="IMMTF3")
	private double immtf3;

	@Column(name="IMMTF4")
	private double immtf4;

	@Column(name="IMMTF5")
	private double immtf5;

	@Column(name="IMOPC")
	private Object imopc;

	@Column(name="IMOPTH")
	private double imopth;

	@Column(name="IMOPV")
	private double imopv;

	@Column(name="IMORDW")
	private Object imordw;

	@Column(name="IMORPR")
	private Object imorpr;

	@Column(name="IMOT1Y")
	private Object imot1y;

	@Column(name="IMOT2Y")
	private Object imot2y;

	@Column(name="IMOVR")
	private Object imovr;

	@Column(name="IMPCTM")
	private double impctm;

	@Column(name="IMPDGR")
	private Object impdgr;

	@Column(name="IMPEFD")
	private double impefd;

	@Column(name="IMPID")
	private Object impid;

	@Column(name="IMPLEV")
	private Object implev;

	@Column(name="IMPMTH")
	private Object impmth;

	@Column(name="IMPOC")
	private Object impoc;

	@Column(name="IMPPLV")
	private Object impplv;

	@Column(name="IMPRGR")
	private Object imprgr;

	@Column(name="IMPRI1")
	private double impri1;

	@Column(name="IMPRI2")
	private double impri2;

	@Column(name="IMPRP0")
	private Object imprp0;

	@Column(name="IMPRP1")
	private Object imprp1;

	@Column(name="IMPRP2")
	private Object imprp2;

	@Column(name="IMPRP3")
	private Object imprp3;

	@Column(name="IMPRP4")
	private Object imprp4;

	@Column(name="IMPRP5")
	private Object imprp5;

	@Column(name="IMPRP6")
	private Object imprp6;

	@Column(name="IMPRP7")
	private Object imprp7;

	@Column(name="IMPRP8")
	private Object imprp8;

	@Column(name="IMPRP9")
	private Object imprp9;

	@Column(name="IMPRPO")
	private Object imprpo;

	@Column(name="IMPTSC")
	private Object imptsc;

	@Column(name="IMRPRC")
	private Object imrprc;

	@Column(name="IMRVNO")
	private Object imrvno;

	@Column(name="IMRWLA")
	private Object imrwla;

	@Column(name="IMSBDD")
	private double imsbdd;

	@Column(name="IMSCC0")
	private Object imscc0;

	@Column(name="IMSCPSELL")
	private Object imscpsell;

	@Column(name="IMSEG0")
	private Object imseg0;

	@Column(name="IMSEG1")
	private Object imseg1;

	@Column(name="IMSEG2")
	private Object imseg2;

	@Column(name="IMSEG3")
	private Object imseg3;

	@Column(name="IMSEG4")
	private Object imseg4;

	@Column(name="IMSEG5")
	private Object imseg5;

	@Column(name="IMSEG6")
	private Object imseg6;

	@Column(name="IMSEG7")
	private Object imseg7;

	@Column(name="IMSEG8")
	private Object imseg8;

	@Column(name="IMSEG9")
	private Object imseg9;

	@Column(name="IMSFLT")
	private double imsflt;

	@Column(name="IMSHCM")
	private Object imshcm;

	@Column(name="IMSHCN")
	private Object imshcn;

	@Column(name="IMSLD")
	private double imsld;

	@Column(name="IMSNS")
	private Object imsns;

	@Column(name="IMSRCE")
	private Object imsrce;

	@Column(name="IMSRNR")
	private Object imsrnr;

	@Column(name="IMSRP0")
	private Object imsrp0;

	@Column(name="IMSRP1")
	private Object imsrp1;

	@Column(name="IMSRP2")
	private Object imsrp2;

	@Column(name="IMSRP3")
	private Object imsrp3;

	@Column(name="IMSRP4")
	private Object imsrp4;

	@Column(name="IMSRP5")
	private Object imsrp5;

	@Column(name="IMSRP6")
	private Object imsrp6;

	@Column(name="IMSRP7")
	private Object imsrp7;

	@Column(name="IMSRP8")
	private Object imsrp8;

	@Column(name="IMSRP9")
	private Object imsrp9;

	@Column(name="IMSRTX")
	private Object imsrtx;

	@Column(name="IMSTDG")
	private Object imstdg;

	@Column(name="IMSTDP")
	private double imstdp;

	@Column(name="IMSTKT")
	private Object imstkt;

	@Column(name="IMSUTM")
	private Object imsutm;

	@Column(name="IMTDAY")
	private double imtday;

	@Column(name="IMTFLA")
	private Object imtfla;

	@Column(name="IMTHGD")
	private Object imthgd;

	@Column(name="IMTHRP")
	private double imthrp;

	@Column(name="IMTMPL")
	private Object imtmpl;

	@Column(name="IMU1DD")
	private double imu1dd;

	@Column(name="IMU2DD")
	private double imu2dd;

	@Column(name="IMU3DD")
	private double imu3dd;

	@Column(name="IMU4DD")
	private double imu4dd;

	@Column(name="IMU5DD")
	private double imu5dd;

	@Column(name="IMUMDF")
	private Object imumdf;

	@Column(name="IMUMS0")
	private Object imums0;

	@Column(name="IMUMS1")
	private Object imums1;

	@Column(name="IMUMS2")
	private Object imums2;

	@Column(name="IMUMS3")
	private Object imums3;

	@Column(name="IMUMS4")
	private Object imums4;

	@Column(name="IMUMS5")
	private Object imums5;

	@Column(name="IMUMS6")
	private Object imums6;

	@Column(name="IMUMS7")
	private Object imums7;

	@Column(name="IMUMS8")
	private Object imums8;

	@Column(name="IMUMTH")
	private Object imumth;

	@Column(name="IMUMUP")
	private Object imumup;

	@Column(name="IMUMVW")
	private Object imumvw;

	@Column(name="IMUOM1")
	private Object imuom1;

	@Column(name="IMUOM2")
	private Object imuom2;

	@Column(name="IMUOM3")
	private Object imuom3;

	@Column(name="IMUOM4")
	private Object imuom4;

	@Column(name="IMUOM6")
	private Object imuom6;

	@Column(name="IMUOM8")
	private Object imuom8;

	@Column(name="IMUOM9")
	private Object imuom9;

	@Column(name="IMUPCN")
	private Object imupcn;

	@Column(name="IMUPMJ")
	private BigDecimal imupmj;

	@Column(name="IMURAB")
	private double imurab;

	@Column(name="IMURAT")
	private double imurat;

	@Column(name="IMURCD")
	private Object imurcd;

	@Column(name="IMURDT")
	private BigDecimal imurdt;

	@Column(name="IMURRF")
	private Object imurrf;

	@Column(name="IMUSER")
	private Object imuser;

	@Column(name="IMUVM1")
	private Object imuvm1;

	@Column(name="IMUWUM")
	private Object imuwum;

	@Column(name="IMVCUD")
	private double imvcud;

	@Column(name="IMVMINV")
	private Object imvminv;

	@Column(name="IMWARR")
	private Object imwarr;

	@Column(name="IMWTRQ")
	private Object imwtrq;

	@Column(name="IMXDCK")
	private Object imxdck;

	public F4101() {
	}

	public double getImitm() {
		return this.imitm;
	}

	public void setImitm(double imitm) {
		this.imitm = imitm;
	}

	public Object getImabci() {
		return this.imabci;
	}

	public void setImabci(Object imabci) {
		this.imabci = imabci;
	}

	public Object getImabcm() {
		return this.imabcm;
	}

	public void setImabcm(Object imabcm) {
		this.imabcm = imabcm;
	}

	public Object getImabcs() {
		return this.imabcs;
	}

	public void setImabcs(Object imabcs) {
		this.imabcs = imabcs;
	}

	public double getImacq() {
		return this.imacq;
	}

	public void setImacq(double imacq) {
		this.imacq = imacq;
	}

	public Object getImaing() {
		return this.imaing;
	}

	public void setImaing(Object imaing) {
		this.imaing = imaing;
	}

	public Object getImaitm() {
		return this.imaitm;
	}

	public void setImaitm(Object imaitm) {
		this.imaitm = imaitm;
	}

	public Object getImaln() {
		return this.imaln;
	}

	public void setImaln(Object imaln) {
		this.imaln = imaln;
	}

	public double getImanpl() {
		return this.imanpl;
	}

	public void setImanpl(double imanpl) {
		this.imanpl = imanpl;
	}

	public Object getImapsc() {
		return this.imapsc;
	}

	public void setImapsc(Object imapsc) {
		this.imapsc = imapsc;
	}

	public Object getImashl() {
		return this.imashl;
	}

	public void setImashl(Object imashl) {
		this.imashl = imashl;
	}

	public Object getImauom() {
		return this.imauom;
	}

	public void setImauom(Object imauom) {
		this.imauom = imauom;
	}

	public double getImavrt() {
		return this.imavrt;
	}

	public void setImavrt(double imavrt) {
		this.imavrt = imavrt;
	}

	public Object getImback() {
		return this.imback;
	}

	public void setImback(Object imback) {
		this.imback = imback;
	}

	public double getImbbdd() {
		return this.imbbdd;
	}

	public void setImbbdd(double imbbdd) {
		this.imbbdd = imbbdd;
	}

	public Object getImbpfg() {
		return this.imbpfg;
	}

	public void setImbpfg(Object imbpfg) {
		this.imbpfg = imbpfg;
	}

	public double getImbuyr() {
		return this.imbuyr;
	}

	public void setImbuyr(double imbuyr) {
		this.imbuyr = imbuyr;
	}

	public double getImcarp() {
		return this.imcarp;
	}

	public void setImcarp(double imcarp) {
		this.imcarp = imcarp;
	}

	public double getImcars() {
		return this.imcars;
	}

	public void setImcars(double imcars) {
		this.imcars = imcars;
	}

	public Object getImcdcd() {
		return this.imcdcd;
	}

	public void setImcdcd(Object imcdcd) {
		this.imcdcd = imcdcd;
	}

	public Object getImckav() {
		return this.imckav;
	}

	public void setImckav(Object imckav) {
		this.imckav = imckav;
	}

	public Object getImclev() {
		return this.imclev;
	}

	public void setImclev(Object imclev) {
		this.imclev = imclev;
	}

	public Object getImcmcg() {
		return this.imcmcg;
	}

	public void setImcmcg(Object imcmcg) {
		this.imcmcg = imcmcg;
	}

	public Object getImcmdm() {
		return this.imcmdm;
	}

	public void setImcmdm(Object imcmdm) {
		this.imcmdm = imcmdm;
	}

	public Object getImcmeth() {
		return this.imcmeth;
	}

	public void setImcmeth(Object imcmeth) {
		this.imcmeth = imcmeth;
	}

	public Object getImcmgl() {
		return this.imcmgl;
	}

	public void setImcmgl(Object imcmgl) {
		this.imcmgl = imcmgl;
	}

	public Object getImcoby() {
		return this.imcoby;
	}

	public void setImcoby(Object imcoby) {
		this.imcoby = imcoby;
	}

	public double getImcomh() {
		return this.imcomh;
	}

	public void setImcomh(double imcomh) {
		this.imcomh = imcomh;
	}

	public Object getImconb() {
		return this.imconb;
	}

	public void setImconb(Object imconb) {
		this.imconb = imconb;
	}

	public Object getImcont() {
		return this.imcont;
	}

	public void setImcont(Object imcont) {
		this.imcont = imcont;
	}

	public Object getImcoty() {
		return this.imcoty;
	}

	public void setImcoty(Object imcoty) {
		this.imcoty = imcoty;
	}

	public double getImcuth() {
		return this.imcuth;
	}

	public void setImcuth(double imcuth) {
		this.imcuth = imcuth;
	}

	public Object getImcycl() {
		return this.imcycl;
	}

	public void setImcycl(Object imcycl) {
		this.imcycl = imcycl;
	}

	public double getImdefd() {
		return this.imdefd;
	}

	public void setImdefd(double imdefd) {
		this.imdefd = imdefd;
	}

	public Object getImdfenditm() {
		return this.imdfenditm;
	}

	public void setImdfenditm(Object imdfenditm) {
		this.imdfenditm = imdfenditm;
	}

	public double getImdftpct() {
		return this.imdftpct;
	}

	public void setImdftpct(double imdftpct) {
		this.imdftpct = imdftpct;
	}

	public double getImdltl() {
		return this.imdltl;
	}

	public void setImdltl(double imdltl) {
		this.imdltl = imdltl;
	}

	public Object getImdppo() {
		return this.imdppo;
	}

	public void setImdppo(Object imdppo) {
		this.imdppo = imdppo;
	}

	public Object getImdraw() {
		return this.imdraw;
	}

	public void setImdraw(Object imdraw) {
		this.imdraw = imdraw;
	}

	public Object getImdsc1() {
		return this.imdsc1;
	}

	public void setImdsc1(Object imdsc1) {
		this.imdsc1 = imdsc1;
	}

	public Object getImdsc2() {
		return this.imdsc2;
	}

	public void setImdsc2(Object imdsc2) {
		this.imdsc2 = imdsc2;
	}

	public Object getImdsgp() {
		return this.imdsgp;
	}

	public void setImdsgp(Object imdsgp) {
		this.imdsgp = imdsgp;
	}

	public Object getImdsze() {
		return this.imdsze;
	}

	public void setImdsze(Object imdsze) {
		this.imdsze = imdsze;
	}

	public Object getImdual() {
		return this.imdual;
	}

	public void setImdual(Object imdual) {
		this.imdual = imdual;
	}

	public Object getImeqty() {
		return this.imeqty;
	}

	public void setImeqty(Object imeqty) {
		this.imeqty = imeqty;
	}

	public double getImexpd() {
		return this.imexpd;
	}

	public void setImexpd(double imexpd) {
		this.imexpd = imexpd;
	}

	public Object getImexpi() {
		return this.imexpi;
	}

	public void setImexpi(Object imexpi) {
		this.imexpi = imexpi;
	}

	public Object getImfifo() {
		return this.imfifo;
	}

	public void setImfifo(Object imfifo) {
		this.imfifo = imfifo;
	}

	public Object getImfrgd() {
		return this.imfrgd;
	}

	public void setImfrgd(Object imfrgd) {
		this.imfrgd = imfrgd;
	}

	public double getImfrmp() {
		return this.imfrmp;
	}

	public void setImfrmp(double imfrmp) {
		this.imfrmp = imfrmp;
	}

	public Object getImgcmp() {
		return this.imgcmp;
	}

	public void setImgcmp(Object imgcmp) {
		this.imgcmp = imgcmp;
	}

	public Object getImglpt() {
		return this.imglpt;
	}

	public void setImglpt(Object imglpt) {
		this.imglpt = imglpt;
	}

	public Object getImifla() {
		return this.imifla;
	}

	public void setImifla(Object imifla) {
		this.imifla = imifla;
	}

	public Object getIminmg() {
		return this.iminmg;
	}

	public void setIminmg(Object iminmg) {
		this.iminmg = iminmg;
	}

	public Object getImitc() {
		return this.imitc;
	}

	public void setImitc(Object imitc) {
		this.imitc = imitc;
	}

	public Object getImjobn() {
		return this.imjobn;
	}

	public void setImjobn(Object imjobn) {
		this.imjobn = imjobn;
	}

	public Object getImkanexll() {
		return this.imkanexll;
	}

	public void setImkanexll(Object imkanexll) {
		this.imkanexll = imkanexll;
	}

	public Object getImkbit() {
		return this.imkbit;
	}

	public void setImkbit(Object imkbit) {
		this.imkbit = imkbit;
	}

	public Object getImlaf() {
		return this.imlaf;
	}

	public void setImlaf(Object imlaf) {
		this.imlaf = imlaf;
	}

	public Object getImlecm() {
		return this.imlecm;
	}

	public void setImlecm(Object imlecm) {
		this.imlecm = imlecm;
	}

	public double getImledd() {
		return this.imledd;
	}

	public void setImledd(double imledd) {
		this.imledd = imledd;
	}

	public Object getImline() {
		return this.imline;
	}

	public void setImline(Object imline) {
		this.imline = imline;
	}

	public Object getImlitm() {
		return this.imlitm;
	}

	public void setImlitm(Object imlitm) {
		this.imlitm = imlitm;
	}

	public double getImllx() {
		return this.imllx;
	}

	public void setImllx(double imllx) {
		this.imllx = imllx;
	}

	public Object getImlmfg() {
		return this.imlmfg;
	}

	public void setImlmfg(Object imlmfg) {
		this.imlmfg = imlmfg;
	}

	public Object getImlnpa() {
		return this.imlnpa;
	}

	public void setImlnpa(Object imlnpa) {
		this.imlnpa = imlnpa;
	}

	public Object getImlnty() {
		return this.imlnty;
	}

	public void setImlnty(Object imlnty) {
		this.imlnty = imlnty;
	}

	public Object getImlotc() {
		return this.imlotc;
	}

	public void setImlotc(Object imlotc) {
		this.imlotc = imlotc;
	}

	public Object getImlots() {
		return this.imlots;
	}

	public void setImlots(Object imlots) {
		this.imlots = imlots;
	}

	public double getImltcm() {
		return this.imltcm;
	}

	public void setImltcm(double imltcm) {
		this.imltcm = imltcm;
	}

	public Object getImltfm() {
		return this.imltfm;
	}

	public void setImltfm(Object imltfm) {
		this.imltfm = imltfm;
	}

	public double getImltlv() {
		return this.imltlv;
	}

	public void setImltlv(double imltlv) {
		this.imltlv = imltlv;
	}

	public double getImltmf() {
		return this.imltmf;
	}

	public void setImltmf(double imltmf) {
		this.imltmf = imltmf;
	}

	public double getImltpu() {
		return this.imltpu;
	}

	public void setImltpu(double imltpu) {
		this.imltpu = imltpu;
	}

	public Object getImmake() {
		return this.immake;
	}

	public void setImmake(Object immake) {
		this.immake = immake;
	}

	public Object getImmic() {
		return this.immic;
	}

	public void setImmic(Object immic) {
		this.immic = immic;
	}

	public double getImmlq() {
		return this.immlq;
	}

	public void setImmlq(double immlq) {
		this.immlq = immlq;
	}

	public double getImmmpc() {
		return this.immmpc;
	}

	public void setImmmpc(double immmpc) {
		this.immmpc = immmpc;
	}

	public Object getImmpsp() {
		return this.immpsp;
	}

	public void setImmpsp(Object immpsp) {
		this.immpsp = immpsp;
	}

	public Object getImmpst() {
		return this.immpst;
	}

	public void setImmpst(Object immpst) {
		this.immpst = immpst;
	}

	public Object getImmrpp() {
		return this.immrpp;
	}

	public void setImmrpp(Object immrpp) {
		this.immrpp = immrpp;
	}

	public double getImmtf1() {
		return this.immtf1;
	}

	public void setImmtf1(double immtf1) {
		this.immtf1 = immtf1;
	}

	public double getImmtf2() {
		return this.immtf2;
	}

	public void setImmtf2(double immtf2) {
		this.immtf2 = immtf2;
	}

	public double getImmtf3() {
		return this.immtf3;
	}

	public void setImmtf3(double immtf3) {
		this.immtf3 = immtf3;
	}

	public double getImmtf4() {
		return this.immtf4;
	}

	public void setImmtf4(double immtf4) {
		this.immtf4 = immtf4;
	}

	public double getImmtf5() {
		return this.immtf5;
	}

	public void setImmtf5(double immtf5) {
		this.immtf5 = immtf5;
	}

	public Object getImopc() {
		return this.imopc;
	}

	public void setImopc(Object imopc) {
		this.imopc = imopc;
	}

	public double getImopth() {
		return this.imopth;
	}

	public void setImopth(double imopth) {
		this.imopth = imopth;
	}

	public double getImopv() {
		return this.imopv;
	}

	public void setImopv(double imopv) {
		this.imopv = imopv;
	}

	public Object getImordw() {
		return this.imordw;
	}

	public void setImordw(Object imordw) {
		this.imordw = imordw;
	}

	public Object getImorpr() {
		return this.imorpr;
	}

	public void setImorpr(Object imorpr) {
		this.imorpr = imorpr;
	}

	public Object getImot1y() {
		return this.imot1y;
	}

	public void setImot1y(Object imot1y) {
		this.imot1y = imot1y;
	}

	public Object getImot2y() {
		return this.imot2y;
	}

	public void setImot2y(Object imot2y) {
		this.imot2y = imot2y;
	}

	public Object getImovr() {
		return this.imovr;
	}

	public void setImovr(Object imovr) {
		this.imovr = imovr;
	}

	public double getImpctm() {
		return this.impctm;
	}

	public void setImpctm(double impctm) {
		this.impctm = impctm;
	}

	public Object getImpdgr() {
		return this.impdgr;
	}

	public void setImpdgr(Object impdgr) {
		this.impdgr = impdgr;
	}

	public double getImpefd() {
		return this.impefd;
	}

	public void setImpefd(double impefd) {
		this.impefd = impefd;
	}

	public Object getImpid() {
		return this.impid;
	}

	public void setImpid(Object impid) {
		this.impid = impid;
	}

	public Object getImplev() {
		return this.implev;
	}

	public void setImplev(Object implev) {
		this.implev = implev;
	}

	public Object getImpmth() {
		return this.impmth;
	}

	public void setImpmth(Object impmth) {
		this.impmth = impmth;
	}

	public Object getImpoc() {
		return this.impoc;
	}

	public void setImpoc(Object impoc) {
		this.impoc = impoc;
	}

	public Object getImpplv() {
		return this.impplv;
	}

	public void setImpplv(Object impplv) {
		this.impplv = impplv;
	}

	public Object getImprgr() {
		return this.imprgr;
	}

	public void setImprgr(Object imprgr) {
		this.imprgr = imprgr;
	}

	public double getImpri1() {
		return this.impri1;
	}

	public void setImpri1(double impri1) {
		this.impri1 = impri1;
	}

	public double getImpri2() {
		return this.impri2;
	}

	public void setImpri2(double impri2) {
		this.impri2 = impri2;
	}

	public Object getImprp0() {
		return this.imprp0;
	}

	public void setImprp0(Object imprp0) {
		this.imprp0 = imprp0;
	}

	public Object getImprp1() {
		return this.imprp1;
	}

	public void setImprp1(Object imprp1) {
		this.imprp1 = imprp1;
	}

	public Object getImprp2() {
		return this.imprp2;
	}

	public void setImprp2(Object imprp2) {
		this.imprp2 = imprp2;
	}

	public Object getImprp3() {
		return this.imprp3;
	}

	public void setImprp3(Object imprp3) {
		this.imprp3 = imprp3;
	}

	public Object getImprp4() {
		return this.imprp4;
	}

	public void setImprp4(Object imprp4) {
		this.imprp4 = imprp4;
	}

	public Object getImprp5() {
		return this.imprp5;
	}

	public void setImprp5(Object imprp5) {
		this.imprp5 = imprp5;
	}

	public Object getImprp6() {
		return this.imprp6;
	}

	public void setImprp6(Object imprp6) {
		this.imprp6 = imprp6;
	}

	public Object getImprp7() {
		return this.imprp7;
	}

	public void setImprp7(Object imprp7) {
		this.imprp7 = imprp7;
	}

	public Object getImprp8() {
		return this.imprp8;
	}

	public void setImprp8(Object imprp8) {
		this.imprp8 = imprp8;
	}

	public Object getImprp9() {
		return this.imprp9;
	}

	public void setImprp9(Object imprp9) {
		this.imprp9 = imprp9;
	}

	public Object getImprpo() {
		return this.imprpo;
	}

	public void setImprpo(Object imprpo) {
		this.imprpo = imprpo;
	}

	public Object getImptsc() {
		return this.imptsc;
	}

	public void setImptsc(Object imptsc) {
		this.imptsc = imptsc;
	}

	public Object getImrprc() {
		return this.imrprc;
	}

	public void setImrprc(Object imrprc) {
		this.imrprc = imrprc;
	}

	public Object getImrvno() {
		return this.imrvno;
	}

	public void setImrvno(Object imrvno) {
		this.imrvno = imrvno;
	}

	public Object getImrwla() {
		return this.imrwla;
	}

	public void setImrwla(Object imrwla) {
		this.imrwla = imrwla;
	}

	public double getImsbdd() {
		return this.imsbdd;
	}

	public void setImsbdd(double imsbdd) {
		this.imsbdd = imsbdd;
	}

	public Object getImscc0() {
		return this.imscc0;
	}

	public void setImscc0(Object imscc0) {
		this.imscc0 = imscc0;
	}

	public Object getImscpsell() {
		return this.imscpsell;
	}

	public void setImscpsell(Object imscpsell) {
		this.imscpsell = imscpsell;
	}

	public Object getImseg0() {
		return this.imseg0;
	}

	public void setImseg0(Object imseg0) {
		this.imseg0 = imseg0;
	}

	public Object getImseg1() {
		return this.imseg1;
	}

	public void setImseg1(Object imseg1) {
		this.imseg1 = imseg1;
	}

	public Object getImseg2() {
		return this.imseg2;
	}

	public void setImseg2(Object imseg2) {
		this.imseg2 = imseg2;
	}

	public Object getImseg3() {
		return this.imseg3;
	}

	public void setImseg3(Object imseg3) {
		this.imseg3 = imseg3;
	}

	public Object getImseg4() {
		return this.imseg4;
	}

	public void setImseg4(Object imseg4) {
		this.imseg4 = imseg4;
	}

	public Object getImseg5() {
		return this.imseg5;
	}

	public void setImseg5(Object imseg5) {
		this.imseg5 = imseg5;
	}

	public Object getImseg6() {
		return this.imseg6;
	}

	public void setImseg6(Object imseg6) {
		this.imseg6 = imseg6;
	}

	public Object getImseg7() {
		return this.imseg7;
	}

	public void setImseg7(Object imseg7) {
		this.imseg7 = imseg7;
	}

	public Object getImseg8() {
		return this.imseg8;
	}

	public void setImseg8(Object imseg8) {
		this.imseg8 = imseg8;
	}

	public Object getImseg9() {
		return this.imseg9;
	}

	public void setImseg9(Object imseg9) {
		this.imseg9 = imseg9;
	}

	public double getImsflt() {
		return this.imsflt;
	}

	public void setImsflt(double imsflt) {
		this.imsflt = imsflt;
	}

	public Object getImshcm() {
		return this.imshcm;
	}

	public void setImshcm(Object imshcm) {
		this.imshcm = imshcm;
	}

	public Object getImshcn() {
		return this.imshcn;
	}

	public void setImshcn(Object imshcn) {
		this.imshcn = imshcn;
	}

	public double getImsld() {
		return this.imsld;
	}

	public void setImsld(double imsld) {
		this.imsld = imsld;
	}

	public Object getImsns() {
		return this.imsns;
	}

	public void setImsns(Object imsns) {
		this.imsns = imsns;
	}

	public Object getImsrce() {
		return this.imsrce;
	}

	public void setImsrce(Object imsrce) {
		this.imsrce = imsrce;
	}

	public Object getImsrnr() {
		return this.imsrnr;
	}

	public void setImsrnr(Object imsrnr) {
		this.imsrnr = imsrnr;
	}

	public Object getImsrp0() {
		return this.imsrp0;
	}

	public void setImsrp0(Object imsrp0) {
		this.imsrp0 = imsrp0;
	}

	public Object getImsrp1() {
		return this.imsrp1;
	}

	public void setImsrp1(Object imsrp1) {
		this.imsrp1 = imsrp1;
	}

	public Object getImsrp2() {
		return this.imsrp2;
	}

	public void setImsrp2(Object imsrp2) {
		this.imsrp2 = imsrp2;
	}

	public Object getImsrp3() {
		return this.imsrp3;
	}

	public void setImsrp3(Object imsrp3) {
		this.imsrp3 = imsrp3;
	}

	public Object getImsrp4() {
		return this.imsrp4;
	}

	public void setImsrp4(Object imsrp4) {
		this.imsrp4 = imsrp4;
	}

	public Object getImsrp5() {
		return this.imsrp5;
	}

	public void setImsrp5(Object imsrp5) {
		this.imsrp5 = imsrp5;
	}

	public Object getImsrp6() {
		return this.imsrp6;
	}

	public void setImsrp6(Object imsrp6) {
		this.imsrp6 = imsrp6;
	}

	public Object getImsrp7() {
		return this.imsrp7;
	}

	public void setImsrp7(Object imsrp7) {
		this.imsrp7 = imsrp7;
	}

	public Object getImsrp8() {
		return this.imsrp8;
	}

	public void setImsrp8(Object imsrp8) {
		this.imsrp8 = imsrp8;
	}

	public Object getImsrp9() {
		return this.imsrp9;
	}

	public void setImsrp9(Object imsrp9) {
		this.imsrp9 = imsrp9;
	}

	public Object getImsrtx() {
		return this.imsrtx;
	}

	public void setImsrtx(Object imsrtx) {
		this.imsrtx = imsrtx;
	}

	public Object getImstdg() {
		return this.imstdg;
	}

	public void setImstdg(Object imstdg) {
		this.imstdg = imstdg;
	}

	public double getImstdp() {
		return this.imstdp;
	}

	public void setImstdp(double imstdp) {
		this.imstdp = imstdp;
	}

	public Object getImstkt() {
		return this.imstkt;
	}

	public void setImstkt(Object imstkt) {
		this.imstkt = imstkt;
	}

	public Object getImsutm() {
		return this.imsutm;
	}

	public void setImsutm(Object imsutm) {
		this.imsutm = imsutm;
	}

	public double getImtday() {
		return this.imtday;
	}

	public void setImtday(double imtday) {
		this.imtday = imtday;
	}

	public Object getImtfla() {
		return this.imtfla;
	}

	public void setImtfla(Object imtfla) {
		this.imtfla = imtfla;
	}

	public Object getImthgd() {
		return this.imthgd;
	}

	public void setImthgd(Object imthgd) {
		this.imthgd = imthgd;
	}

	public double getImthrp() {
		return this.imthrp;
	}

	public void setImthrp(double imthrp) {
		this.imthrp = imthrp;
	}

	public Object getImtmpl() {
		return this.imtmpl;
	}

	public void setImtmpl(Object imtmpl) {
		this.imtmpl = imtmpl;
	}

	public double getImu1dd() {
		return this.imu1dd;
	}

	public void setImu1dd(double imu1dd) {
		this.imu1dd = imu1dd;
	}

	public double getImu2dd() {
		return this.imu2dd;
	}

	public void setImu2dd(double imu2dd) {
		this.imu2dd = imu2dd;
	}

	public double getImu3dd() {
		return this.imu3dd;
	}

	public void setImu3dd(double imu3dd) {
		this.imu3dd = imu3dd;
	}

	public double getImu4dd() {
		return this.imu4dd;
	}

	public void setImu4dd(double imu4dd) {
		this.imu4dd = imu4dd;
	}

	public double getImu5dd() {
		return this.imu5dd;
	}

	public void setImu5dd(double imu5dd) {
		this.imu5dd = imu5dd;
	}

	public Object getImumdf() {
		return this.imumdf;
	}

	public void setImumdf(Object imumdf) {
		this.imumdf = imumdf;
	}

	public Object getImums0() {
		return this.imums0;
	}

	public void setImums0(Object imums0) {
		this.imums0 = imums0;
	}

	public Object getImums1() {
		return this.imums1;
	}

	public void setImums1(Object imums1) {
		this.imums1 = imums1;
	}

	public Object getImums2() {
		return this.imums2;
	}

	public void setImums2(Object imums2) {
		this.imums2 = imums2;
	}

	public Object getImums3() {
		return this.imums3;
	}

	public void setImums3(Object imums3) {
		this.imums3 = imums3;
	}

	public Object getImums4() {
		return this.imums4;
	}

	public void setImums4(Object imums4) {
		this.imums4 = imums4;
	}

	public Object getImums5() {
		return this.imums5;
	}

	public void setImums5(Object imums5) {
		this.imums5 = imums5;
	}

	public Object getImums6() {
		return this.imums6;
	}

	public void setImums6(Object imums6) {
		this.imums6 = imums6;
	}

	public Object getImums7() {
		return this.imums7;
	}

	public void setImums7(Object imums7) {
		this.imums7 = imums7;
	}

	public Object getImums8() {
		return this.imums8;
	}

	public void setImums8(Object imums8) {
		this.imums8 = imums8;
	}

	public Object getImumth() {
		return this.imumth;
	}

	public void setImumth(Object imumth) {
		this.imumth = imumth;
	}

	public Object getImumup() {
		return this.imumup;
	}

	public void setImumup(Object imumup) {
		this.imumup = imumup;
	}

	public Object getImumvw() {
		return this.imumvw;
	}

	public void setImumvw(Object imumvw) {
		this.imumvw = imumvw;
	}

	public Object getImuom1() {
		return this.imuom1;
	}

	public void setImuom1(Object imuom1) {
		this.imuom1 = imuom1;
	}

	public Object getImuom2() {
		return this.imuom2;
	}

	public void setImuom2(Object imuom2) {
		this.imuom2 = imuom2;
	}

	public Object getImuom3() {
		return this.imuom3;
	}

	public void setImuom3(Object imuom3) {
		this.imuom3 = imuom3;
	}

	public Object getImuom4() {
		return this.imuom4;
	}

	public void setImuom4(Object imuom4) {
		this.imuom4 = imuom4;
	}

	public Object getImuom6() {
		return this.imuom6;
	}

	public void setImuom6(Object imuom6) {
		this.imuom6 = imuom6;
	}

	public Object getImuom8() {
		return this.imuom8;
	}

	public void setImuom8(Object imuom8) {
		this.imuom8 = imuom8;
	}

	public Object getImuom9() {
		return this.imuom9;
	}

	public void setImuom9(Object imuom9) {
		this.imuom9 = imuom9;
	}

	public Object getImupcn() {
		return this.imupcn;
	}

	public void setImupcn(Object imupcn) {
		this.imupcn = imupcn;
	}

	public BigDecimal getImupmj() {
		return this.imupmj;
	}

	public void setImupmj(BigDecimal imupmj) {
		this.imupmj = imupmj;
	}

	public double getImurab() {
		return this.imurab;
	}

	public void setImurab(double imurab) {
		this.imurab = imurab;
	}

	public double getImurat() {
		return this.imurat;
	}

	public void setImurat(double imurat) {
		this.imurat = imurat;
	}

	public Object getImurcd() {
		return this.imurcd;
	}

	public void setImurcd(Object imurcd) {
		this.imurcd = imurcd;
	}

	public BigDecimal getImurdt() {
		return this.imurdt;
	}

	public void setImurdt(BigDecimal imurdt) {
		this.imurdt = imurdt;
	}

	public Object getImurrf() {
		return this.imurrf;
	}

	public void setImurrf(Object imurrf) {
		this.imurrf = imurrf;
	}

	public Object getImuser() {
		return this.imuser;
	}

	public void setImuser(Object imuser) {
		this.imuser = imuser;
	}

	public Object getImuvm1() {
		return this.imuvm1;
	}

	public void setImuvm1(Object imuvm1) {
		this.imuvm1 = imuvm1;
	}

	public Object getImuwum() {
		return this.imuwum;
	}

	public void setImuwum(Object imuwum) {
		this.imuwum = imuwum;
	}

	public double getImvcud() {
		return this.imvcud;
	}

	public void setImvcud(double imvcud) {
		this.imvcud = imvcud;
	}

	public Object getImvminv() {
		return this.imvminv;
	}

	public void setImvminv(Object imvminv) {
		this.imvminv = imvminv;
	}

	public Object getImwarr() {
		return this.imwarr;
	}

	public void setImwarr(Object imwarr) {
		this.imwarr = imwarr;
	}

	public Object getImwtrq() {
		return this.imwtrq;
	}

	public void setImwtrq(Object imwtrq) {
		this.imwtrq = imwtrq;
	}

	public Object getImxdck() {
		return this.imxdck;
	}

	public void setImxdck(Object imxdck) {
		this.imxdck = imxdck;
	}

}