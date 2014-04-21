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
	private Object abab3;

	@Column(name="ABAC01")
	private Object abac01;

	@Column(name="ABAC02")
	private Object abac02;

	@Column(name="ABAC03")
	private Object abac03;

	@Column(name="ABAC04")
	private Object abac04;

	@Column(name="ABAC05")
	private Object abac05;

	@Column(name="ABAC06")
	private Object abac06;

	@Column(name="ABAC07")
	private Object abac07;

	@Column(name="ABAC08")
	private Object abac08;

	@Column(name="ABAC09")
	private Object abac09;

	@Column(name="ABAC10")
	private Object abac10;

	@Column(name="ABAC11")
	private Object abac11;

	@Column(name="ABAC12")
	private Object abac12;

	@Column(name="ABAC13")
	private Object abac13;

	@Column(name="ABAC14")
	private Object abac14;

	@Column(name="ABAC15")
	private Object abac15;

	@Column(name="ABAC16")
	private Object abac16;

	@Column(name="ABAC17")
	private Object abac17;

	@Column(name="ABAC18")
	private Object abac18;

	@Column(name="ABAC19")
	private Object abac19;

	@Column(name="ABAC20")
	private Object abac20;

	@Column(name="ABAC21")
	private Object abac21;

	@Column(name="ABAC22")
	private Object abac22;

	@Column(name="ABAC23")
	private Object abac23;

	@Column(name="ABAC24")
	private Object abac24;

	@Column(name="ABAC25")
	private Object abac25;

	@Column(name="ABAC26")
	private Object abac26;

	@Column(name="ABAC27")
	private Object abac27;

	@Column(name="ABAC28")
	private Object abac28;

	@Column(name="ABAC29")
	private Object abac29;

	@Column(name="ABAC30")
	private Object abac30;

	@Column(name="ABACTIN")
	private Object abactin;

	@Column(name="ABAEMPGP")
	private Object abaempgp;

	@Column(name="ABALKY")
	private Object abalky;

	@Column(name="ABALP1")
	private Object abalp1;

	@Column(name="ABALPH")
	private Object abalph;

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
	private Object abat1;

	@Column(name="ABAT2")
	private Object abat2;

	@Column(name="ABAT3")
	private Object abat3;

	@Column(name="ABAT4")
	private Object abat4;

	@Column(name="ABAT5")
	private Object abat5;

	@Column(name="ABATE")
	private Object abate;

	@Column(name="ABATP")
	private Object abatp;

	@Column(name="ABATPR")
	private Object abatpr;

	@Column(name="ABATR")
	private Object abatr;

	@Column(name="ABCAAD")
	private double abcaad;

	@Column(name="ABCLASS01")
	private Object abclass01;

	@Column(name="ABCLASS02")
	private Object abclass02;

	@Column(name="ABCLASS03")
	private Object abclass03;

	@Column(name="ABCLASS04")
	private Object abclass04;

	@Column(name="ABCLASS05")
	private Object abclass05;

	@Column(name="ABCM")
	private Object abcm;

	@Column(name="ABDC")
	private Object abdc;

	@Column(name="ABDUNS")
	private Object abduns;

	@Column(name="ABEFTB")
	private BigDecimal abeftb;

	@Column(name="ABEXCHG")
	private Object abexchg;

	@Column(name="ABGLBA")
	private Object abglba;

	@Column(name="ABGROWTHR")
	private double abgrowthr;

	@Column(name="ABJOBN")
	private Object abjobn;

	@Column(name="ABLNGP")
	private Object ablngp;

	@Column(name="ABMCU")
	private Object abmcu;

	@Column(name="ABMSGA")
	private Object abmsga;

	@Column(name="ABNOE")
	private double abnoe;

	@Column(name="ABPDI")
	private BigDecimal abpdi;

	@Column(name="ABPERRS")
	private double abperrs;

	@Column(name="ABPID")
	private Object abpid;

	@Column(name="ABPRGF")
	private Object abprgf;

	@Column(name="ABPTI")
	private double abpti;

	@Column(name="ABREVRNG")
	private Object abrevrng;

	@Column(name="ABRMK")
	private Object abrmk;

	@Column(name="ABSBLI")
	private Object absbli;

	@Column(name="ABSCCLTP")
	private Object absccltp;

	@Column(name="ABSIC")
	private Object absic;

	@Column(name="ABSYNCS")
	private double absyncs;

	@Column(name="ABTAX")
	private Object abtax;

	@Column(name="ABTAXC")
	private Object abtaxc;

	@Column(name="ABTICKER")
	private Object abticker;

	@Column(name="ABTX2")
	private Object abtx2;

	@Column(name="ABTXCT")
	private Object abtxct;

	@Column(name="ABUPMJ")
	private BigDecimal abupmj;

	@Column(name="ABUPMT")
	private double abupmt;

	@Column(name="ABURAB")
	private double aburab;

	@Column(name="ABURAT")
	private double aburat;

	@Column(name="ABURCD")
	private Object aburcd;

	@Column(name="ABURDT")
	private BigDecimal aburdt;

	@Column(name="ABURRF")
	private Object aburrf;

	@Column(name="ABUSER")
	private Object abuser;

	@Column(name="ABYEARSTAR")
	private Object abyearstar;

	public F0101() {
	}

	public double getAban8() {
		return this.aban8;
	}

	public void setAban8(double aban8) {
		this.aban8 = aban8;
	}

	public Object getAbab3() {
		return this.abab3;
	}

	public void setAbab3(Object abab3) {
		this.abab3 = abab3;
	}

	public Object getAbac01() {
		return this.abac01;
	}

	public void setAbac01(Object abac01) {
		this.abac01 = abac01;
	}

	public Object getAbac02() {
		return this.abac02;
	}

	public void setAbac02(Object abac02) {
		this.abac02 = abac02;
	}

	public Object getAbac03() {
		return this.abac03;
	}

	public void setAbac03(Object abac03) {
		this.abac03 = abac03;
	}

	public Object getAbac04() {
		return this.abac04;
	}

	public void setAbac04(Object abac04) {
		this.abac04 = abac04;
	}

	public Object getAbac05() {
		return this.abac05;
	}

	public void setAbac05(Object abac05) {
		this.abac05 = abac05;
	}

	public Object getAbac06() {
		return this.abac06;
	}

	public void setAbac06(Object abac06) {
		this.abac06 = abac06;
	}

	public Object getAbac07() {
		return this.abac07;
	}

	public void setAbac07(Object abac07) {
		this.abac07 = abac07;
	}

	public Object getAbac08() {
		return this.abac08;
	}

	public void setAbac08(Object abac08) {
		this.abac08 = abac08;
	}

	public Object getAbac09() {
		return this.abac09;
	}

	public void setAbac09(Object abac09) {
		this.abac09 = abac09;
	}

	public Object getAbac10() {
		return this.abac10;
	}

	public void setAbac10(Object abac10) {
		this.abac10 = abac10;
	}

	public Object getAbac11() {
		return this.abac11;
	}

	public void setAbac11(Object abac11) {
		this.abac11 = abac11;
	}

	public Object getAbac12() {
		return this.abac12;
	}

	public void setAbac12(Object abac12) {
		this.abac12 = abac12;
	}

	public Object getAbac13() {
		return this.abac13;
	}

	public void setAbac13(Object abac13) {
		this.abac13 = abac13;
	}

	public Object getAbac14() {
		return this.abac14;
	}

	public void setAbac14(Object abac14) {
		this.abac14 = abac14;
	}

	public Object getAbac15() {
		return this.abac15;
	}

	public void setAbac15(Object abac15) {
		this.abac15 = abac15;
	}

	public Object getAbac16() {
		return this.abac16;
	}

	public void setAbac16(Object abac16) {
		this.abac16 = abac16;
	}

	public Object getAbac17() {
		return this.abac17;
	}

	public void setAbac17(Object abac17) {
		this.abac17 = abac17;
	}

	public Object getAbac18() {
		return this.abac18;
	}

	public void setAbac18(Object abac18) {
		this.abac18 = abac18;
	}

	public Object getAbac19() {
		return this.abac19;
	}

	public void setAbac19(Object abac19) {
		this.abac19 = abac19;
	}

	public Object getAbac20() {
		return this.abac20;
	}

	public void setAbac20(Object abac20) {
		this.abac20 = abac20;
	}

	public Object getAbac21() {
		return this.abac21;
	}

	public void setAbac21(Object abac21) {
		this.abac21 = abac21;
	}

	public Object getAbac22() {
		return this.abac22;
	}

	public void setAbac22(Object abac22) {
		this.abac22 = abac22;
	}

	public Object getAbac23() {
		return this.abac23;
	}

	public void setAbac23(Object abac23) {
		this.abac23 = abac23;
	}

	public Object getAbac24() {
		return this.abac24;
	}

	public void setAbac24(Object abac24) {
		this.abac24 = abac24;
	}

	public Object getAbac25() {
		return this.abac25;
	}

	public void setAbac25(Object abac25) {
		this.abac25 = abac25;
	}

	public Object getAbac26() {
		return this.abac26;
	}

	public void setAbac26(Object abac26) {
		this.abac26 = abac26;
	}

	public Object getAbac27() {
		return this.abac27;
	}

	public void setAbac27(Object abac27) {
		this.abac27 = abac27;
	}

	public Object getAbac28() {
		return this.abac28;
	}

	public void setAbac28(Object abac28) {
		this.abac28 = abac28;
	}

	public Object getAbac29() {
		return this.abac29;
	}

	public void setAbac29(Object abac29) {
		this.abac29 = abac29;
	}

	public Object getAbac30() {
		return this.abac30;
	}

	public void setAbac30(Object abac30) {
		this.abac30 = abac30;
	}

	public Object getAbactin() {
		return this.abactin;
	}

	public void setAbactin(Object abactin) {
		this.abactin = abactin;
	}

	public Object getAbaempgp() {
		return this.abaempgp;
	}

	public void setAbaempgp(Object abaempgp) {
		this.abaempgp = abaempgp;
	}

	public Object getAbalky() {
		return this.abalky;
	}

	public void setAbalky(Object abalky) {
		this.abalky = abalky;
	}

	public Object getAbalp1() {
		return this.abalp1;
	}

	public void setAbalp1(Object abalp1) {
		this.abalp1 = abalp1;
	}

	public Object getAbalph() {
		return this.abalph;
	}

	public void setAbalph(Object abalph) {
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

	public Object getAbat1() {
		return this.abat1;
	}

	public void setAbat1(Object abat1) {
		this.abat1 = abat1;
	}

	public Object getAbat2() {
		return this.abat2;
	}

	public void setAbat2(Object abat2) {
		this.abat2 = abat2;
	}

	public Object getAbat3() {
		return this.abat3;
	}

	public void setAbat3(Object abat3) {
		this.abat3 = abat3;
	}

	public Object getAbat4() {
		return this.abat4;
	}

	public void setAbat4(Object abat4) {
		this.abat4 = abat4;
	}

	public Object getAbat5() {
		return this.abat5;
	}

	public void setAbat5(Object abat5) {
		this.abat5 = abat5;
	}

	public Object getAbate() {
		return this.abate;
	}

	public void setAbate(Object abate) {
		this.abate = abate;
	}

	public Object getAbatp() {
		return this.abatp;
	}

	public void setAbatp(Object abatp) {
		this.abatp = abatp;
	}

	public Object getAbatpr() {
		return this.abatpr;
	}

	public void setAbatpr(Object abatpr) {
		this.abatpr = abatpr;
	}

	public Object getAbatr() {
		return this.abatr;
	}

	public void setAbatr(Object abatr) {
		this.abatr = abatr;
	}

	public double getAbcaad() {
		return this.abcaad;
	}

	public void setAbcaad(double abcaad) {
		this.abcaad = abcaad;
	}

	public Object getAbclass01() {
		return this.abclass01;
	}

	public void setAbclass01(Object abclass01) {
		this.abclass01 = abclass01;
	}

	public Object getAbclass02() {
		return this.abclass02;
	}

	public void setAbclass02(Object abclass02) {
		this.abclass02 = abclass02;
	}

	public Object getAbclass03() {
		return this.abclass03;
	}

	public void setAbclass03(Object abclass03) {
		this.abclass03 = abclass03;
	}

	public Object getAbclass04() {
		return this.abclass04;
	}

	public void setAbclass04(Object abclass04) {
		this.abclass04 = abclass04;
	}

	public Object getAbclass05() {
		return this.abclass05;
	}

	public void setAbclass05(Object abclass05) {
		this.abclass05 = abclass05;
	}

	public Object getAbcm() {
		return this.abcm;
	}

	public void setAbcm(Object abcm) {
		this.abcm = abcm;
	}

	public Object getAbdc() {
		return this.abdc;
	}

	public void setAbdc(Object abdc) {
		this.abdc = abdc;
	}

	public Object getAbduns() {
		return this.abduns;
	}

	public void setAbduns(Object abduns) {
		this.abduns = abduns;
	}

	public BigDecimal getAbeftb() {
		return this.abeftb;
	}

	public void setAbeftb(BigDecimal abeftb) {
		this.abeftb = abeftb;
	}

	public Object getAbexchg() {
		return this.abexchg;
	}

	public void setAbexchg(Object abexchg) {
		this.abexchg = abexchg;
	}

	public Object getAbglba() {
		return this.abglba;
	}

	public void setAbglba(Object abglba) {
		this.abglba = abglba;
	}

	public double getAbgrowthr() {
		return this.abgrowthr;
	}

	public void setAbgrowthr(double abgrowthr) {
		this.abgrowthr = abgrowthr;
	}

	public Object getAbjobn() {
		return this.abjobn;
	}

	public void setAbjobn(Object abjobn) {
		this.abjobn = abjobn;
	}

	public Object getAblngp() {
		return this.ablngp;
	}

	public void setAblngp(Object ablngp) {
		this.ablngp = ablngp;
	}

	public Object getAbmcu() {
		return this.abmcu;
	}

	public void setAbmcu(Object abmcu) {
		this.abmcu = abmcu;
	}

	public Object getAbmsga() {
		return this.abmsga;
	}

	public void setAbmsga(Object abmsga) {
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

	public Object getAbpid() {
		return this.abpid;
	}

	public void setAbpid(Object abpid) {
		this.abpid = abpid;
	}

	public Object getAbprgf() {
		return this.abprgf;
	}

	public void setAbprgf(Object abprgf) {
		this.abprgf = abprgf;
	}

	public double getAbpti() {
		return this.abpti;
	}

	public void setAbpti(double abpti) {
		this.abpti = abpti;
	}

	public Object getAbrevrng() {
		return this.abrevrng;
	}

	public void setAbrevrng(Object abrevrng) {
		this.abrevrng = abrevrng;
	}

	public Object getAbrmk() {
		return this.abrmk;
	}

	public void setAbrmk(Object abrmk) {
		this.abrmk = abrmk;
	}

	public Object getAbsbli() {
		return this.absbli;
	}

	public void setAbsbli(Object absbli) {
		this.absbli = absbli;
	}

	public Object getAbsccltp() {
		return this.absccltp;
	}

	public void setAbsccltp(Object absccltp) {
		this.absccltp = absccltp;
	}

	public Object getAbsic() {
		return this.absic;
	}

	public void setAbsic(Object absic) {
		this.absic = absic;
	}

	public double getAbsyncs() {
		return this.absyncs;
	}

	public void setAbsyncs(double absyncs) {
		this.absyncs = absyncs;
	}

	public Object getAbtax() {
		return this.abtax;
	}

	public void setAbtax(Object abtax) {
		this.abtax = abtax;
	}

	public Object getAbtaxc() {
		return this.abtaxc;
	}

	public void setAbtaxc(Object abtaxc) {
		this.abtaxc = abtaxc;
	}

	public Object getAbticker() {
		return this.abticker;
	}

	public void setAbticker(Object abticker) {
		this.abticker = abticker;
	}

	public Object getAbtx2() {
		return this.abtx2;
	}

	public void setAbtx2(Object abtx2) {
		this.abtx2 = abtx2;
	}

	public Object getAbtxct() {
		return this.abtxct;
	}

	public void setAbtxct(Object abtxct) {
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

	public Object getAburcd() {
		return this.aburcd;
	}

	public void setAburcd(Object aburcd) {
		this.aburcd = aburcd;
	}

	public BigDecimal getAburdt() {
		return this.aburdt;
	}

	public void setAburdt(BigDecimal aburdt) {
		this.aburdt = aburdt;
	}

	public Object getAburrf() {
		return this.aburrf;
	}

	public void setAburrf(Object aburrf) {
		this.aburrf = aburrf;
	}

	public Object getAbuser() {
		return this.abuser;
	}

	public void setAbuser(Object abuser) {
		this.abuser = abuser;
	}

	public Object getAbyearstar() {
		return this.abyearstar;
	}

	public void setAbyearstar(Object abyearstar) {
		this.abyearstar = abyearstar;
	}

}