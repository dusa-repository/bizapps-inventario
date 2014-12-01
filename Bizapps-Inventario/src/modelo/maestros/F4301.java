package modelo.maestros;

import java.io.Serializable;

import javax.persistence.*;
import modelo.pk.F4301PK;
import java.math.BigDecimal;

/**
 * The persistent class for the F4301 database table.
 * 
 */
@Entity
public class F4301 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4301PK id;

	@Column(name = "PHADDJ")
	private BigDecimal phaddj;

	@Column(name = "PHAN8")
	private Double phan8;

	@Column(name = "PHANBY")
	private double phanby;

	@Column(name = "PHANCR")
	private Double phancr;

	@Column(name = "PHARTG")
	private String phartg;

	@Column(name = "PHASN")
	private String phasn;

	@Column(name = "PHATXT")
	private String phatxt;

	@Column(name = "PHAVCH")
	private String phavch;

	@Column(name = "PHBCRC")
	private String phbcrc;

	@Column(name = "PHCNDJ")
	private BigDecimal phcndj;

	@Column(name = "PHCNID")
	private String phcnid;

	@Column(name = "PHCORD")
	private double phcord;

	@Column(name = "PHCOT")
	private String phcot;

	@Column(name = "PHCRCD")
	private String phcrcd;

	@Column(name = "PHCRMD")
	private String phcrmd;

	@Column(name = "PHCRR")
	private double phcrr;

	@Column(name = "PHCRRM")
	private String phcrrm;

	@Column(name = "PHDCT4")
	private String phdct4;

	@Column(name = "PHDEL1")
	private String phdel1;

	@Column(name = "PHDEL2")
	private String phdel2;

	@Column(name = "PHDESC")
	private String phdesc;

	@Column(name = "PHDOC1")
	private double phdoc1;

	@Column(name = "PHDRQJ")
	private BigDecimal phdrqj;

	@Column(name = "PHDRQT")
	private double phdrqt;

	@Column(name = "PHEXR1")
	private String phexr1;

	@Column(name = "PHFAP")
	private double phfap;

	@Column(name = "PHFRTC")
	private String phfrtc;

	@Column(name = "PHFRTH")
	private String phfrth;

	@Column(name = "PHFUF1")
	private String phfuf1;

	@Column(name = "PHFUF2")
	private String phfuf2;

	@Column(name = "PHHOLD")
	private String phhold;

	@Column(name = "PHINMG")
	private String phinmg;

	@Column(name = "PHINVC")
	private double phinvc;

	@Column(name = "PHJOBN")
	private String phjobn;

	@Column(name = "PHLGCT")
	private String phlgct;

	@Column(name = "PHLNGP")
	private String phlngp;

	@Column(name = "PHMATY")
	private String phmaty;

	@Column(name = "PHMCU")
	private String phmcu;

	@Column(name = "PHMKFR")
	private double phmkfr;

	@Column(name = "PHMOT")
	private String phmot;

	@Column(name = "PHNTR")
	private String phntr;

	@Column(name = "PHOCTO")
	private String phocto;

	@Column(name = "PHOKCO")
	private String phokco;

	@Column(name = "PHOORN")
	private String phoorn;

	@Column(name = "PHOPDJ")
	private BigDecimal phopdj;

	@Column(name = "PHORBY")
	private String phorby;

	@Column(name = "PHOSTS")
	private String phosts;

	@Column(name = "PHOTOT")
	private double photot;

	@Column(name = "PHPCRT")
	private double phpcrt;

	@Column(name = "PHPDDJ")
	private BigDecimal phpddj;

	@Column(name = "PHPEFJ")
	private BigDecimal phpefj;

	@Column(name = "PHPID")
	private String phpid;

	@Column(name = "PHPPDJ")
	private BigDecimal phppdj;

	@Column(name = "PHPRGP")
	private String phprgp;

	@Column(name = "PHPROM")
	private String phprom;

	@Column(name = "PHPRP5")
	private String phprp5;

	@Column(name = "PHPRPY")
	private String phprpy;

	@Column(name = "PHPSDJ")
	private BigDecimal phpsdj;

	@Column(name = "PHPTC")
	private String phptc;

	@Column(name = "PHPURG")
	private String phpurg;

	@Column(name = "PHRCD")
	private String phrcd;

	@Column(name = "PHRCTO")
	private String phrcto;

	@Column(name = "PHRKCO")
	private String phrkco;

	@Column(name = "PHRMK")
	private String phrmk;

	@Column(name = "PHRORN")
	private String phrorn;

	@Column(name = "PHRSHT")
	private double phrsht;

	@Column(name = "PHRTNR")
	private String phrtnr;

	@Column(name = "PHSHAN")
	private double phshan;

	@Column(name = "PHTDAY")
	private double phtday;

	@Column(name = "PHTKBY")
	private String phtkby;

	@Column(name = "PHTRDJ")
	private BigDecimal phtrdj;

	@Column(name = "PHTXA1")
	private String phtxa1;

	@Column(name = "PHTXCT")
	private String phtxct;

	@Column(name = "PHUPMJ")
	private BigDecimal phupmj;

	@Column(name = "PHURAB")
	private double phurab;

	@Column(name = "PHURAT")
	private double phurat;

	@Column(name = "PHURCD")
	private String phurcd;

	@Column(name = "PHURDT")
	private BigDecimal phurdt;

	@Column(name = "PHURRF")
	private String phurrf;

	@Column(name = "PHUSER")
	private String phuser;

	@Column(name = "PHVR01")
	private String phvr01;

	@Column(name = "PHVR02")
	private String phvr02;

	@Column(name = "PHVUMD")
	private String phvumd;

	@Column(name = "PHWUMD")
	private String phwumd;

	@Column(name = "PHZON")
	private String phzon;

	public F4301() {
	}

	public F4301PK getId() {
		return this.id;
	}

	public void setId(F4301PK id) {
		this.id = id;
	}

	public BigDecimal getPhaddj() {
		return this.phaddj;
	}

	public void setPhaddj(BigDecimal phaddj) {
		this.phaddj = phaddj;
	}

	public Double getPhan8() {
		return this.phan8;
	}

	public void setPhan8(Double phan8) {
		this.phan8 = phan8;
	}

	public double getPhanby() {
		return this.phanby;
	}

	public void setPhanby(double phanby) {
		this.phanby = phanby;
	}

	public Double getPhancr() {
		return this.phancr;
	}

	public void setPhancr(Double phancr) {
		this.phancr = phancr;
	}

	public String getPhartg() {
		return this.phartg;
	}

	public void setPhartg(String phartg) {
		this.phartg = phartg;
	}

	public String getPhasn() {
		return this.phasn;
	}

	public void setPhasn(String phasn) {
		this.phasn = phasn;
	}

	public String getPhatxt() {
		return this.phatxt;
	}

	public void setPhatxt(String phatxt) {
		this.phatxt = phatxt;
	}

	public String getPhavch() {
		return this.phavch;
	}

	public void setPhavch(String phavch) {
		this.phavch = phavch;
	}

	public String getPhbcrc() {
		return this.phbcrc;
	}

	public void setPhbcrc(String phbcrc) {
		this.phbcrc = phbcrc;
	}

	public BigDecimal getPhcndj() {
		return this.phcndj;
	}

	public void setPhcndj(BigDecimal phcndj) {
		this.phcndj = phcndj;
	}

	public String getPhcnid() {
		return this.phcnid;
	}

	public void setPhcnid(String phcnid) {
		this.phcnid = phcnid;
	}

	public double getPhcord() {
		return this.phcord;
	}

	public void setPhcord(double phcord) {
		this.phcord = phcord;
	}

	public String getPhcot() {
		return this.phcot;
	}

	public void setPhcot(String phcot) {
		this.phcot = phcot;
	}

	public String getPhcrcd() {
		return this.phcrcd;
	}

	public void setPhcrcd(String phcrcd) {
		this.phcrcd = phcrcd;
	}

	public String getPhcrmd() {
		return this.phcrmd;
	}

	public void setPhcrmd(String phcrmd) {
		this.phcrmd = phcrmd;
	}

	public double getPhcrr() {
		return this.phcrr;
	}

	public void setPhcrr(double phcrr) {
		this.phcrr = phcrr;
	}

	public String getPhcrrm() {
		return this.phcrrm;
	}

	public void setPhcrrm(String phcrrm) {
		this.phcrrm = phcrrm;
	}

	public String getPhdct4() {
		return this.phdct4;
	}

	public void setPhdct4(String phdct4) {
		this.phdct4 = phdct4;
	}

	public String getPhdel1() {
		return this.phdel1;
	}

	public void setPhdel1(String phdel1) {
		this.phdel1 = phdel1;
	}

	public String getPhdel2() {
		return this.phdel2;
	}

	public void setPhdel2(String phdel2) {
		this.phdel2 = phdel2;
	}

	public String getPhdesc() {
		return this.phdesc;
	}

	public void setPhdesc(String phdesc) {
		this.phdesc = phdesc;
	}

	public double getPhdoc1() {
		return this.phdoc1;
	}

	public void setPhdoc1(double phdoc1) {
		this.phdoc1 = phdoc1;
	}

	public BigDecimal getPhdrqj() {
		return this.phdrqj;
	}

	public void setPhdrqj(BigDecimal phdrqj) {
		this.phdrqj = phdrqj;
	}

	public double getPhdrqt() {
		return this.phdrqt;
	}

	public void setPhdrqt(double phdrqt) {
		this.phdrqt = phdrqt;
	}

	public String getPhexr1() {
		return this.phexr1;
	}

	public void setPhexr1(String phexr1) {
		this.phexr1 = phexr1;
	}

	public double getPhfap() {
		return this.phfap;
	}

	public void setPhfap(double phfap) {
		this.phfap = phfap;
	}

	public String getPhfrtc() {
		return this.phfrtc;
	}

	public void setPhfrtc(String phfrtc) {
		this.phfrtc = phfrtc;
	}

	public String getPhfrth() {
		return this.phfrth;
	}

	public void setPhfrth(String phfrth) {
		this.phfrth = phfrth;
	}

	public String getPhfuf1() {
		return this.phfuf1;
	}

	public void setPhfuf1(String phfuf1) {
		this.phfuf1 = phfuf1;
	}

	public String getPhfuf2() {
		return this.phfuf2;
	}

	public void setPhfuf2(String phfuf2) {
		this.phfuf2 = phfuf2;
	}

	public String getPhhold() {
		return this.phhold;
	}

	public void setPhhold(String phhold) {
		this.phhold = phhold;
	}

	public String getPhinmg() {
		return this.phinmg;
	}

	public void setPhinmg(String phinmg) {
		this.phinmg = phinmg;
	}

	public double getPhinvc() {
		return this.phinvc;
	}

	public void setPhinvc(double phinvc) {
		this.phinvc = phinvc;
	}

	public String getPhjobn() {
		return this.phjobn;
	}

	public void setPhjobn(String phjobn) {
		this.phjobn = phjobn;
	}

	public String getPhlgct() {
		return this.phlgct;
	}

	public void setPhlgct(String phlgct) {
		this.phlgct = phlgct;
	}

	public String getPhlngp() {
		return this.phlngp;
	}

	public void setPhlngp(String phlngp) {
		this.phlngp = phlngp;
	}

	public String getPhmaty() {
		return this.phmaty;
	}

	public void setPhmaty(String phmaty) {
		this.phmaty = phmaty;
	}

	public String getPhmcu() {
		return this.phmcu;
	}

	public void setPhmcu(String phmcu) {
		this.phmcu = phmcu;
	}

	public double getPhmkfr() {
		return this.phmkfr;
	}

	public void setPhmkfr(double phmkfr) {
		this.phmkfr = phmkfr;
	}

	public String getPhmot() {
		return this.phmot;
	}

	public void setPhmot(String phmot) {
		this.phmot = phmot;
	}

	public String getPhntr() {
		return this.phntr;
	}

	public void setPhntr(String phntr) {
		this.phntr = phntr;
	}

	public String getPhocto() {
		return this.phocto;
	}

	public void setPhocto(String phocto) {
		this.phocto = phocto;
	}

	public String getPhokco() {
		return this.phokco;
	}

	public void setPhokco(String phokco) {
		this.phokco = phokco;
	}

	public String getPhoorn() {
		return this.phoorn;
	}

	public void setPhoorn(String phoorn) {
		this.phoorn = phoorn;
	}

	public BigDecimal getPhopdj() {
		return this.phopdj;
	}

	public void setPhopdj(BigDecimal phopdj) {
		this.phopdj = phopdj;
	}

	public String getPhorby() {
		return this.phorby;
	}

	public void setPhorby(String phorby) {
		this.phorby = phorby;
	}

	public String getPhosts() {
		return this.phosts;
	}

	public void setPhosts(String phosts) {
		this.phosts = phosts;
	}

	public double getPhotot() {
		return this.photot;
	}

	public void setPhotot(double photot) {
		this.photot = photot;
	}

	public double getPhpcrt() {
		return this.phpcrt;
	}

	public void setPhpcrt(double phpcrt) {
		this.phpcrt = phpcrt;
	}

	public BigDecimal getPhpddj() {
		return this.phpddj;
	}

	public void setPhpddj(BigDecimal phpddj) {
		this.phpddj = phpddj;
	}

	public BigDecimal getPhpefj() {
		return this.phpefj;
	}

	public void setPhpefj(BigDecimal phpefj) {
		this.phpefj = phpefj;
	}

	public String getPhpid() {
		return this.phpid;
	}

	public void setPhpid(String phpid) {
		this.phpid = phpid;
	}

	public BigDecimal getPhppdj() {
		return this.phppdj;
	}

	public void setPhppdj(BigDecimal phppdj) {
		this.phppdj = phppdj;
	}

	public String getPhprgp() {
		return this.phprgp;
	}

	public void setPhprgp(String phprgp) {
		this.phprgp = phprgp;
	}

	public String getPhprom() {
		return this.phprom;
	}

	public void setPhprom(String phprom) {
		this.phprom = phprom;
	}

	public String getPhprp5() {
		return this.phprp5;
	}

	public void setPhprp5(String phprp5) {
		this.phprp5 = phprp5;
	}

	public String getPhprpy() {
		return this.phprpy;
	}

	public void setPhprpy(String phprpy) {
		this.phprpy = phprpy;
	}

	public BigDecimal getPhpsdj() {
		return this.phpsdj;
	}

	public void setPhpsdj(BigDecimal phpsdj) {
		this.phpsdj = phpsdj;
	}

	public String getPhptc() {
		return this.phptc;
	}

	public void setPhptc(String phptc) {
		this.phptc = phptc;
	}

	public String getPhpurg() {
		return this.phpurg;
	}

	public void setPhpurg(String phpurg) {
		this.phpurg = phpurg;
	}

	public String getPhrcd() {
		return this.phrcd;
	}

	public void setPhrcd(String phrcd) {
		this.phrcd = phrcd;
	}

	public String getPhrcto() {
		return this.phrcto;
	}

	public void setPhrcto(String phrcto) {
		this.phrcto = phrcto;
	}

	public String getPhrkco() {
		return this.phrkco;
	}

	public void setPhrkco(String phrkco) {
		this.phrkco = phrkco;
	}

	public String getPhrmk() {
		return this.phrmk;
	}

	public void setPhrmk(String phrmk) {
		this.phrmk = phrmk;
	}

	public String getPhrorn() {
		return this.phrorn;
	}

	public void setPhrorn(String phrorn) {
		this.phrorn = phrorn;
	}

	public double getPhrsht() {
		return this.phrsht;
	}

	public void setPhrsht(double phrsht) {
		this.phrsht = phrsht;
	}

	public String getPhrtnr() {
		return this.phrtnr;
	}

	public void setPhrtnr(String phrtnr) {
		this.phrtnr = phrtnr;
	}

	public double getPhshan() {
		return this.phshan;
	}

	public void setPhshan(double phshan) {
		this.phshan = phshan;
	}

	public double getPhtday() {
		return this.phtday;
	}

	public void setPhtday(double phtday) {
		this.phtday = phtday;
	}

	public String getPhtkby() {
		return this.phtkby;
	}

	public void setPhtkby(String phtkby) {
		this.phtkby = phtkby;
	}

	public BigDecimal getPhtrdj() {
		return this.phtrdj;
	}

	public void setPhtrdj(BigDecimal phtrdj) {
		this.phtrdj = phtrdj;
	}

	public String getPhtxa1() {
		return this.phtxa1;
	}

	public void setPhtxa1(String phtxa1) {
		this.phtxa1 = phtxa1;
	}

	public String getPhtxct() {
		return this.phtxct;
	}

	public void setPhtxct(String phtxct) {
		this.phtxct = phtxct;
	}

	public BigDecimal getPhupmj() {
		return this.phupmj;
	}

	public void setPhupmj(BigDecimal phupmj) {
		this.phupmj = phupmj;
	}

	public double getPhurab() {
		return this.phurab;
	}

	public void setPhurab(double phurab) {
		this.phurab = phurab;
	}

	public double getPhurat() {
		return this.phurat;
	}

	public void setPhurat(double phurat) {
		this.phurat = phurat;
	}

	public String getPhurcd() {
		return this.phurcd;
	}

	public void setPhurcd(String phurcd) {
		this.phurcd = phurcd;
	}

	public BigDecimal getPhurdt() {
		return this.phurdt;
	}

	public void setPhurdt(BigDecimal phurdt) {
		this.phurdt = phurdt;
	}

	public String getPhurrf() {
		return this.phurrf;
	}

	public void setPhurrf(String phurrf) {
		this.phurrf = phurrf;
	}

	public String getPhuser() {
		return this.phuser;
	}

	public void setPhuser(String phuser) {
		this.phuser = phuser;
	}

	public String getPhvr01() {
		return this.phvr01;
	}

	public void setPhvr01(String phvr01) {
		this.phvr01 = phvr01;
	}

	public String getPhvr02() {
		return this.phvr02;
	}

	public void setPhvr02(String phvr02) {
		this.phvr02 = phvr02;
	}

	public String getPhvumd() {
		return this.phvumd;
	}

	public void setPhvumd(String phvumd) {
		this.phvumd = phvumd;
	}

	public String getPhwumd() {
		return this.phwumd;
	}

	public void setPhwumd(String phwumd) {
		this.phwumd = phwumd;
	}

	public String getPhzon() {
		return this.phzon;
	}

	public void setPhzon(String phzon) {
		this.phzon = phzon;
	}

	@Override
	public String toString() {
		return "F4301 [id=" + id.toString() + ", phaddj=" + phaddj + ", phan8=" + phan8 + ", phanby=" + phanby + ", phancr="
				+ phancr + ", phartg=" + phartg + ", phasn=" + phasn + ", phatxt=" + phatxt + ", phavch=" + phavch
				+ ", phbcrc=" + phbcrc + ", phcndj=" + phcndj + ", phcnid=" + phcnid + ", phcord=" + phcord
				+ ", phcot=" + phcot + ", phcrcd=" + phcrcd + ", phcrmd=" + phcrmd + ", phcrr=" + phcrr + ", phcrrm="
				+ phcrrm + ", phdct4=" + phdct4 + ", phdel1=" + phdel1 + ", phdel2=" + phdel2 + ", phdesc=" + phdesc
				+ ", phdoc1=" + phdoc1 + ", phdrqj=" + phdrqj + ", phdrqt=" + phdrqt + ", phexr1=" + phexr1
				+ ", phfap=" + phfap + ", phfrtc=" + phfrtc + ", phfrth=" + phfrth + ", phfuf1=" + phfuf1 + ", phfuf2="
				+ phfuf2 + ", phhold=" + phhold + ", phinmg=" + phinmg + ", phinvc=" + phinvc + ", phjobn=" + phjobn
				+ ", phlgct=" + phlgct + ", phlngp=" + phlngp + ", phmaty=" + phmaty + ", phmcu=" + phmcu + ", phmkfr="
				+ phmkfr + ", phmot=" + phmot + ", phntr=" + phntr + ", phocto=" + phocto + ", phokco=" + phokco
				+ ", phoorn=" + phoorn + ", phopdj=" + phopdj + ", phorby=" + phorby + ", phosts=" + phosts
				+ ", photot=" + photot + ", phpcrt=" + phpcrt + ", phpddj=" + phpddj + ", phpefj=" + phpefj
				+ ", phpid=" + phpid + ", phppdj=" + phppdj + ", phprgp=" + phprgp + ", phprom=" + phprom + ", phprp5="
				+ phprp5 + ", phprpy=" + phprpy + ", phpsdj=" + phpsdj + ", phptc=" + phptc + ", phpurg=" + phpurg
				+ ", phrcd=" + phrcd + ", phrcto=" + phrcto + ", phrkco=" + phrkco + ", phrmk=" + phrmk + ", phrorn="
				+ phrorn + ", phrsht=" + phrsht + ", phrtnr=" + phrtnr + ", phshan=" + phshan + ", phtday=" + phtday
				+ ", phtkby=" + phtkby + ", phtrdj=" + phtrdj + ", phtxa1=" + phtxa1 + ", phtxct=" + phtxct
				+ ", phupmj=" + phupmj + ", phurab=" + phurab + ", phurat=" + phurat + ", phurcd=" + phurcd
				+ ", phurdt=" + phurdt + ", phurrf=" + phurrf + ", phuser=" + phuser + ", phvr01=" + phvr01
				+ ", phvr02=" + phvr02 + ", phvumd=" + phvumd + ", phwumd=" + phwumd + ", phzon=" + phzon + "]";
	}

}