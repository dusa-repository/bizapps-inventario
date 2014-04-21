package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the F0101 database table.
 * 
 */
@Entity
public class F0101 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ABAN8")
	private double aban8;

	@Column(name="ABAB3")
	private String abab3;

	@Column(name="ABAC01")
	private String abac01;

	@Column(name="ABAC02")
	private String abac02;

	@Column(name="ABAC03")
	private String abac03;

	@Column(name="ABAC04")
	private String abac04;

	@Column(name="ABAC05")
	private String abac05;

	@Column(name="ABAC06")
	private String abac06;

	@Column(name="ABAC07")
	private String abac07;

	@Column(name="ABAC08")
	private String abac08;

	@Column(name="ABAC09")
	private String abac09;

	@Column(name="ABAC10")
	private String abac10;

	@Column(name="ABAC11")
	private String abac11;

	@Column(name="ABAC12")
	private String abac12;

	@Column(name="ABAC13")
	private String abac13;

	@Column(name="ABAC14")
	private String abac14;

	@Column(name="ABAC15")
	private String abac15;

	@Column(name="ABAC16")
	private String abac16;

	@Column(name="ABAC17")
	private String abac17;

	@Column(name="ABAC18")
	private String abac18;

	@Column(name="ABAC19")
	private String abac19;

	@Column(name="ABAC20")
	private String abac20;

	@Column(name="ABAC21")
	private String abac21;

	@Column(name="ABAC22")
	private String abac22;

	@Column(name="ABAC23")
	private String abac23;

	@Column(name="ABAC24")
	private String abac24;

	@Column(name="ABAC25")
	private String abac25;

	@Column(name="ABAC26")
	private String abac26;

	@Column(name="ABAC27")
	private String abac27;

	@Column(name="ABAC28")
	private String abac28;

	@Column(name="ABAC29")
	private String abac29;

	@Column(name="ABAC30")
	private String abac30;

	@Column(name="ABACTIN")
	private String abactin;

	@Column(name="ABAEMPGP")
	private String abaempgp;

	@Column(name="ABALKY")
	private String abalky;

	@Column(name="ABALP1")
	private String abalp1;

	@Column(name="ABALPH")
	private String abalph;

	@Column(name="ABAN81")
	private double aban81;

	@Column(name="ABAN82")
	private double aban82;

	@Column(name="ABAN83")
	private double aban83;

	@Column(name="ABAN84")
	private double aban84;

	@Column(name="ABAN85")
	private double aban85;

	@Column(name="ABAN86")
	private double aban86;

	@Column(name="ABAT1")
	private String abat1;

	@Column(name="ABAT2")
	private String abat2;

	@Column(name="ABAT3")
	private String abat3;

	@Column(name="ABAT4")
	private String abat4;

	@Column(name="ABAT5")
	private String abat5;

	@Column(name="ABATE")
	private String abate;

	@Column(name="ABATP")
	private String abatp;

	@Column(name="ABATPR")
	private String abatpr;

	@Column(name="ABATR")
	private String abatr;

	@Column(name="ABCAAD")
	private double abcaad;

	@Column(name="ABCLASS01")
	private String abclass01;

	@Column(name="ABCLASS02")
	private String abclass02;

	@Column(name="ABCLASS03")
	private String abclass03;

	@Column(name="ABCLASS04")
	private String abclass04;

	@Column(name="ABCLASS05")
	private String abclass05;

	@Column(name="ABCM")
	private String abcm;

	@Column(name="ABDC")
	private String abdc;

	@Column(name="ABDUNS")
	private String abduns;

	@Column(name="ABEFTB")
	private BigDecimal abeftb;

	@Column(name="ABEXCHG")
	private String abexchg;

	@Column(name="ABGLBA")
	private String abglba;

	@Column(name="ABGROWTHR")
	private double abgrowthr;

	@Column(name="ABJOBN")
	private String abjobn;

	@Column(name="ABLNGP")
	private String ablngp;

	@Column(name="ABMCU")
	private String abmcu;

	@Column(name="ABMSGA")
	private String abmsga;

	@Column(name="ABNOE")
	private double abnoe;

	@Column(name="ABPDI")
	private BigDecimal abpdi;

	@Column(name="ABPERRS")
	private double abperrs;

	@Column(name="ABPID")
	private String abpid;

	@Column(name="ABPRGF")
	private String abprgf;

	@Column(name="ABPTI")
	private double abpti;

	@Column(name="ABREVRNG")
	private String abrevrng;

	@Column(name="ABRMK")
	private String abrmk;

	@Column(name="ABSBLI")
	private String absbli;

	@Column(name="ABSCCLTP")
	private String absccltp;

	@Column(name="ABSIC")
	private String absic;

	@Column(name="ABSYNCS")
	private double absyncs;

	@Column(name="ABTAX")
	private String abtax;

	@Column(name="ABTAXC")
	private String abtaxc;

	@Column(name="ABTICKER")
	private String abticker;

	@Column(name="ABTX2")
	private String abtx2;

	@Column(name="ABTXCT")
	private String abtxct;

	@Column(name="ABUPMJ")
	private BigDecimal abupmj;

	@Column(name="ABUPMT")
	private double abupmt;

	@Column(name="ABURAB")
	private double aburab;

	@Column(name="ABURAT")
	private double aburat;

	@Column(name="ABURCD")
	private String aburcd;

	@Column(name="ABURDT")
	private BigDecimal aburdt;

	@Column(name="ABURRF")
	private String aburrf;

	@Column(name="ABUSER")
	private String abuser;

	@Column(name="ABYEARSTAR")
	private String abyearstar;

	public F0101() {
	}

	public double getAban8() {
		return this.aban8;
	}

	public void setAban8(double aban8) {
		this.aban8 = aban8;
	}

	public String getAbab3() {
		return this.abab3;
	}

	public void setAbab3(String abab3) {
		this.abab3 = abab3;
	}

	public String getAbac01() {
		return this.abac01;
	}

	public void setAbac01(String abac01) {
		this.abac01 = abac01;
	}

	public String getAbac02() {
		return this.abac02;
	}

	public void setAbac02(String abac02) {
		this.abac02 = abac02;
	}

	public String getAbac03() {
		return this.abac03;
	}

	public void setAbac03(String abac03) {
		this.abac03 = abac03;
	}

	public String getAbac04() {
		return this.abac04;
	}

	public void setAbac04(String abac04) {
		this.abac04 = abac04;
	}

	public String getAbac05() {
		return this.abac05;
	}

	public void setAbac05(String abac05) {
		this.abac05 = abac05;
	}

	public String getAbac06() {
		return this.abac06;
	}

	public void setAbac06(String abac06) {
		this.abac06 = abac06;
	}

	public String getAbac07() {
		return this.abac07;
	}

	public void setAbac07(String abac07) {
		this.abac07 = abac07;
	}

	public String getAbac08() {
		return this.abac08;
	}

	public void setAbac08(String abac08) {
		this.abac08 = abac08;
	}

	public String getAbac09() {
		return this.abac09;
	}

	public void setAbac09(String abac09) {
		this.abac09 = abac09;
	}

	public String getAbac10() {
		return this.abac10;
	}

	public void setAbac10(String abac10) {
		this.abac10 = abac10;
	}

	public String getAbac11() {
		return this.abac11;
	}

	public void setAbac11(String abac11) {
		this.abac11 = abac11;
	}

	public String getAbac12() {
		return this.abac12;
	}

	public void setAbac12(String abac12) {
		this.abac12 = abac12;
	}

	public String getAbac13() {
		return this.abac13;
	}

	public void setAbac13(String abac13) {
		this.abac13 = abac13;
	}

	public String getAbac14() {
		return this.abac14;
	}

	public void setAbac14(String abac14) {
		this.abac14 = abac14;
	}

	public String getAbac15() {
		return this.abac15;
	}

	public void setAbac15(String abac15) {
		this.abac15 = abac15;
	}

	public String getAbac16() {
		return this.abac16;
	}

	public void setAbac16(String abac16) {
		this.abac16 = abac16;
	}

	public String getAbac17() {
		return this.abac17;
	}

	public void setAbac17(String abac17) {
		this.abac17 = abac17;
	}

	public String getAbac18() {
		return this.abac18;
	}

	public void setAbac18(String abac18) {
		this.abac18 = abac18;
	}

	public String getAbac19() {
		return this.abac19;
	}

	public void setAbac19(String abac19) {
		this.abac19 = abac19;
	}

	public String getAbac20() {
		return this.abac20;
	}

	public void setAbac20(String abac20) {
		this.abac20 = abac20;
	}

	public String getAbac21() {
		return this.abac21;
	}

	public void setAbac21(String abac21) {
		this.abac21 = abac21;
	}

	public String getAbac22() {
		return this.abac22;
	}

	public void setAbac22(String abac22) {
		this.abac22 = abac22;
	}

	public String getAbac23() {
		return this.abac23;
	}

	public void setAbac23(String abac23) {
		this.abac23 = abac23;
	}

	public String getAbac24() {
		return this.abac24;
	}

	public void setAbac24(String abac24) {
		this.abac24 = abac24;
	}

	public String getAbac25() {
		return this.abac25;
	}

	public void setAbac25(String abac25) {
		this.abac25 = abac25;
	}

	public String getAbac26() {
		return this.abac26;
	}

	public void setAbac26(String abac26) {
		this.abac26 = abac26;
	}

	public String getAbac27() {
		return this.abac27;
	}

	public void setAbac27(String abac27) {
		this.abac27 = abac27;
	}

	public String getAbac28() {
		return this.abac28;
	}

	public void setAbac28(String abac28) {
		this.abac28 = abac28;
	}

	public String getAbac29() {
		return this.abac29;
	}

	public void setAbac29(String abac29) {
		this.abac29 = abac29;
	}

	public String getAbac30() {
		return this.abac30;
	}

	public void setAbac30(String abac30) {
		this.abac30 = abac30;
	}

	public String getAbactin() {
		return this.abactin;
	}

	public void setAbactin(String abactin) {
		this.abactin = abactin;
	}

	public String getAbaempgp() {
		return this.abaempgp;
	}

	public void setAbaempgp(String abaempgp) {
		this.abaempgp = abaempgp;
	}

	public String getAbalky() {
		return this.abalky;
	}

	public void setAbalky(String abalky) {
		this.abalky = abalky;
	}

	public String getAbalp1() {
		return this.abalp1;
	}

	public void setAbalp1(String abalp1) {
		this.abalp1 = abalp1;
	}

	public String getAbalph() {
		return this.abalph;
	}

	public void setAbalph(String abalph) {
		this.abalph = abalph;
	}

	public double getAban81() {
		return this.aban81;
	}

	public void setAban81(double aban81) {
		this.aban81 = aban81;
	}

	public double getAban82() {
		return this.aban82;
	}

	public void setAban82(double aban82) {
		this.aban82 = aban82;
	}

	public double getAban83() {
		return this.aban83;
	}

	public void setAban83(double aban83) {
		this.aban83 = aban83;
	}

	public double getAban84() {
		return this.aban84;
	}

	public void setAban84(double aban84) {
		this.aban84 = aban84;
	}

	public double getAban85() {
		return this.aban85;
	}

	public void setAban85(double aban85) {
		this.aban85 = aban85;
	}

	public double getAban86() {
		return this.aban86;
	}

	public void setAban86(double aban86) {
		this.aban86 = aban86;
	}

	public String getAbat1() {
		return this.abat1;
	}

	public void setAbat1(String abat1) {
		this.abat1 = abat1;
	}

	public String getAbat2() {
		return this.abat2;
	}

	public void setAbat2(String abat2) {
		this.abat2 = abat2;
	}

	public String getAbat3() {
		return this.abat3;
	}

	public void setAbat3(String abat3) {
		this.abat3 = abat3;
	}

	public String getAbat4() {
		return this.abat4;
	}

	public void setAbat4(String abat4) {
		this.abat4 = abat4;
	}

	public String getAbat5() {
		return this.abat5;
	}

	public void setAbat5(String abat5) {
		this.abat5 = abat5;
	}

	public String getAbate() {
		return this.abate;
	}

	public void setAbate(String abate) {
		this.abate = abate;
	}

	public String getAbatp() {
		return this.abatp;
	}

	public void setAbatp(String abatp) {
		this.abatp = abatp;
	}

	public String getAbatpr() {
		return this.abatpr;
	}

	public void setAbatpr(String abatpr) {
		this.abatpr = abatpr;
	}

	public String getAbatr() {
		return this.abatr;
	}

	public void setAbatr(String abatr) {
		this.abatr = abatr;
	}

	public double getAbcaad() {
		return this.abcaad;
	}

	public void setAbcaad(double abcaad) {
		this.abcaad = abcaad;
	}

	public String getAbclass01() {
		return this.abclass01;
	}

	public void setAbclass01(String abclass01) {
		this.abclass01 = abclass01;
	}

	public String getAbclass02() {
		return this.abclass02;
	}

	public void setAbclass02(String abclass02) {
		this.abclass02 = abclass02;
	}

	public String getAbclass03() {
		return this.abclass03;
	}

	public void setAbclass03(String abclass03) {
		this.abclass03 = abclass03;
	}

	public String getAbclass04() {
		return this.abclass04;
	}

	public void setAbclass04(String abclass04) {
		this.abclass04 = abclass04;
	}

	public String getAbclass05() {
		return this.abclass05;
	}

	public void setAbclass05(String abclass05) {
		this.abclass05 = abclass05;
	}

	public String getAbcm() {
		return this.abcm;
	}

	public void setAbcm(String abcm) {
		this.abcm = abcm;
	}

	public String getAbdc() {
		return this.abdc;
	}

	public void setAbdc(String abdc) {
		this.abdc = abdc;
	}

	public String getAbduns() {
		return this.abduns;
	}

	public void setAbduns(String abduns) {
		this.abduns = abduns;
	}

	public BigDecimal getAbeftb() {
		return this.abeftb;
	}

	public void setAbeftb(BigDecimal abeftb) {
		this.abeftb = abeftb;
	}

	public String getAbexchg() {
		return this.abexchg;
	}

	public void setAbexchg(String abexchg) {
		this.abexchg = abexchg;
	}

	public String getAbglba() {
		return this.abglba;
	}

	public void setAbglba(String abglba) {
		this.abglba = abglba;
	}

	public double getAbgrowthr() {
		return this.abgrowthr;
	}

	public void setAbgrowthr(double abgrowthr) {
		this.abgrowthr = abgrowthr;
	}

	public String getAbjobn() {
		return this.abjobn;
	}

	public void setAbjobn(String abjobn) {
		this.abjobn = abjobn;
	}

	public String getAblngp() {
		return this.ablngp;
	}

	public void setAblngp(String ablngp) {
		this.ablngp = ablngp;
	}

	public String getAbmcu() {
		return this.abmcu;
	}

	public void setAbmcu(String abmcu) {
		this.abmcu = abmcu;
	}

	public String getAbmsga() {
		return this.abmsga;
	}

	public void setAbmsga(String abmsga) {
		this.abmsga = abmsga;
	}

	public double getAbnoe() {
		return this.abnoe;
	}

	public void setAbnoe(double abnoe) {
		this.abnoe = abnoe;
	}

	public BigDecimal getAbpdi() {
		return this.abpdi;
	}

	public void setAbpdi(BigDecimal abpdi) {
		this.abpdi = abpdi;
	}

	public double getAbperrs() {
		return this.abperrs;
	}

	public void setAbperrs(double abperrs) {
		this.abperrs = abperrs;
	}

	public String getAbpid() {
		return this.abpid;
	}

	public void setAbpid(String abpid) {
		this.abpid = abpid;
	}

	public String getAbprgf() {
		return this.abprgf;
	}

	public void setAbprgf(String abprgf) {
		this.abprgf = abprgf;
	}

	public double getAbpti() {
		return this.abpti;
	}

	public void setAbpti(double abpti) {
		this.abpti = abpti;
	}

	public String getAbrevrng() {
		return this.abrevrng;
	}

	public void setAbrevrng(String abrevrng) {
		this.abrevrng = abrevrng;
	}

	public String getAbrmk() {
		return this.abrmk;
	}

	public void setAbrmk(String abrmk) {
		this.abrmk = abrmk;
	}

	public String getAbsbli() {
		return this.absbli;
	}

	public void setAbsbli(String absbli) {
		this.absbli = absbli;
	}

	public String getAbsccltp() {
		return this.absccltp;
	}

	public void setAbsccltp(String absccltp) {
		this.absccltp = absccltp;
	}

	public String getAbsic() {
		return this.absic;
	}

	public void setAbsic(String absic) {
		this.absic = absic;
	}

	public double getAbsyncs() {
		return this.absyncs;
	}

	public void setAbsyncs(double absyncs) {
		this.absyncs = absyncs;
	}

	public String getAbtax() {
		return this.abtax;
	}

	public void setAbtax(String abtax) {
		this.abtax = abtax;
	}

	public String getAbtaxc() {
		return this.abtaxc;
	}

	public void setAbtaxc(String abtaxc) {
		this.abtaxc = abtaxc;
	}

	public String getAbticker() {
		return this.abticker;
	}

	public void setAbticker(String abticker) {
		this.abticker = abticker;
	}

	public String getAbtx2() {
		return this.abtx2;
	}

	public void setAbtx2(String abtx2) {
		this.abtx2 = abtx2;
	}

	public String getAbtxct() {
		return this.abtxct;
	}

	public void setAbtxct(String abtxct) {
		this.abtxct = abtxct;
	}

	public BigDecimal getAbupmj() {
		return this.abupmj;
	}

	public void setAbupmj(BigDecimal abupmj) {
		this.abupmj = abupmj;
	}

	public double getAbupmt() {
		return this.abupmt;
	}

	public void setAbupmt(double abupmt) {
		this.abupmt = abupmt;
	}

	public double getAburab() {
		return this.aburab;
	}

	public void setAburab(double aburab) {
		this.aburab = aburab;
	}

	public double getAburat() {
		return this.aburat;
	}

	public void setAburat(double aburat) {
		this.aburat = aburat;
	}

	public String getAburcd() {
		return this.aburcd;
	}

	public void setAburcd(String aburcd) {
		this.aburcd = aburcd;
	}

	public BigDecimal getAburdt() {
		return this.aburdt;
	}

	public void setAburdt(BigDecimal aburdt) {
		this.aburdt = aburdt;
	}

	public String getAburrf() {
		return this.aburrf;
	}

	public void setAburrf(String aburrf) {
		this.aburrf = aburrf;
	}

	public String getAbuser() {
		return this.abuser;
	}

	public void setAbuser(String abuser) {
		this.abuser = abuser;
	}

	public String getAbyearstar() {
		return this.abyearstar;
	}

	public void setAbyearstar(String abyearstar) {
		this.abyearstar = abyearstar;
	}

}