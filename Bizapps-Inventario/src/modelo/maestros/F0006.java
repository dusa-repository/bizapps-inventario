package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * The persistent class for the F0006 database table.
 * 
 */
@Entity
public class F0006 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MCMCU")
	private String mcmcu;

	@Column(name="MCADDS")
	private String mcadds;

	@Column(name="MCALCL")
	private String mcalcl;

	@Column(name="MCALS")
	private String mcals;

	@Column(name="MCAN8")
	private double mcan8;

	@Column(name="MCAN8O")
	private double mcan8o;

	@Column(name="MCANPA")
	private double mcanpa;

	@Column(name="MCAPSB")
	private String mcapsb;

	@Column(name="MCBPTP")
	private String mcbptp;

	@Column(name="MCBTYP")
	private String mcbtyp;

	@Column(name="MCCAC")
	private double mccac;

	@Column(name="MCCC01")
	private String mccc01;

	@Column(name="MCCC02")
	private String mccc02;

	@Column(name="MCCC03")
	private String mccc03;

	@Column(name="MCCC04")
	private String mccc04;

	@Column(name="MCCC05")
	private String mccc05;

	@Column(name="MCCC06")
	private String mccc06;

	@Column(name="MCCC07")
	private String mccc07;

	@Column(name="MCCC08")
	private String mccc08;

	@Column(name="MCCC09")
	private String mccc09;

	@Column(name="MCCC10")
	private String mccc10;

	@Column(name="MCCERT")
	private String mccert;

	@Column(name="MCCNTY")
	private String mccnty;

	@Column(name="MCCO")
	private String mcco;

	@Column(name="MCCT")
	private String mcct;

	@Column(name="MCD1J")
	private BigDecimal mcd1j;

	@Column(name="MCD2J")
	private BigDecimal mcd2j;

	@Column(name="MCD3J")
	private BigDecimal mcd3j;

	@Column(name="MCD4J")
	private BigDecimal mcd4j;

	@Column(name="MCD5J")
	private BigDecimal mcd5j;

	@Column(name="MCD6J")
	private BigDecimal mcd6j;

	@Column(name="MCDC")
	private String mcdc;

	@Column(name="MCDL01")
	private String mcdl01;

	@Column(name="MCDL02")
	private String mcdl02;

	@Column(name="MCDL03")
	private String mcdl03;

	@Column(name="MCDL04")
	private String mcdl04;

	@Column(name="MCEEO")
	private String mceeo;

	@Column(name="MCERC")
	private String mcerc;

	@Column(name="MCEXR1")
	private String mcexr1;

	@Column(name="MCFMOD")
	private String mcfmod;

	@Column(name="MCFPDJ")
	private BigDecimal mcfpdj;

	@Column(name="MCGLBA")
	private String mcglba;

	@Column(name="MCINTA")
	private String mcinta;

	@Column(name="MCINTL")
	private String mcintl;

	@Column(name="MCISS")
	private String mciss;

	@Column(name="MCJOBN")
	private String mcjobn;

	@Column(name="MCLDM")
	private String mcldm;

	@Column(name="MCLF")
	private double mclf;

	@Column(name="MCLMTH")
	private String mclmth;

	@Column(name="MCMCUS")
	private String mcmcus;

	@Column(name="MCND01")
	private String mcnd01;

	@Column(name="MCND02")
	private String mcnd02;

	@Column(name="MCND03")
	private String mcnd03;

	@Column(name="MCND04")
	private String mcnd04;

	@Column(name="MCND05")
	private String mcnd05;

	@Column(name="MCND06")
	private String mcnd06;

	@Column(name="MCND07")
	private String mcnd07;

	@Column(name="MCND08")
	private String mcnd08;

	@Column(name="MCND09")
	private String mcnd09;

	@Column(name="MCND10")
	private String mcnd10;

	@Column(name="MCOBJ1")
	private String mcobj1;

	@Column(name="MCOBJ2")
	private String mcobj2;

	@Column(name="MCOBJ3")
	private String mcobj3;

	@Column(name="MCPAC")
	private double mcpac;

	@Column(name="MCPC")
	private double mcpc;

	@Column(name="MCPCA")
	private double mcpca;

	@Column(name="MCPCC")
	private double mcpcc;

	@Column(name="MCPECC")
	private String mcpecc;

	@Column(name="MCPID")
	private String mcpid;

	@Column(name="MCRP01")
	private String mcrp01;

	@Column(name="MCRP02")
	private String mcrp02;

	@Column(name="MCRP03")
	private String mcrp03;

	@Column(name="MCRP04")
	private String mcrp04;

	@Column(name="MCRP05")
	private String mcrp05;

	@Column(name="MCRP06")
	private String mcrp06;

	@Column(name="MCRP07")
	private String mcrp07;

	@Column(name="MCRP08")
	private String mcrp08;

	@Column(name="MCRP09")
	private String mcrp09;

	@Column(name="MCRP10")
	private String mcrp10;

	@Column(name="MCRP11")
	private String mcrp11;

	@Column(name="MCRP12")
	private String mcrp12;

	@Column(name="MCRP13")
	private String mcrp13;

	@Column(name="MCRP14")
	private String mcrp14;

	@Column(name="MCRP15")
	private String mcrp15;

	@Column(name="MCRP16")
	private String mcrp16;

	@Column(name="MCRP17")
	private String mcrp17;

	@Column(name="MCRP18")
	private String mcrp18;

	@Column(name="MCRP19")
	private String mcrp19;

	@Column(name="MCRP20")
	private String mcrp20;

	@Column(name="MCRP21")
	private String mcrp21;

	@Column(name="MCRP22")
	private String mcrp22;

	@Column(name="MCRP23")
	private String mcrp23;

	@Column(name="MCRP24")
	private String mcrp24;

	@Column(name="MCRP25")
	private String mcrp25;

	@Column(name="MCRP26")
	private String mcrp26;

	@Column(name="MCRP27")
	private String mcrp27;

	@Column(name="MCRP28")
	private String mcrp28;

	@Column(name="MCRP29")
	private String mcrp29;

	@Column(name="MCRP30")
	private String mcrp30;

	@Column(name="MCSBLI")
	private String mcsbli;

	@Column(name="MCSTYL")
	private String mcstyl;

	@Column(name="MCSUB1")
	private String mcsub1;

	@Column(name="MCTA")
	private String mcta;

	@Column(name="MCTC01")
	private String mctc01;

	@Column(name="MCTC02")
	private String mctc02;

	@Column(name="MCTC03")
	private String mctc03;

	@Column(name="MCTC04")
	private String mctc04;

	@Column(name="MCTC05")
	private String mctc05;

	@Column(name="MCTC06")
	private String mctc06;

	@Column(name="MCTC07")
	private String mctc07;

	@Column(name="MCTC08")
	private String mctc08;

	@Column(name="MCTC09")
	private String mctc09;

	@Column(name="MCTC10")
	private String mctc10;

	@Column(name="MCTOU")
	private double mctou;

	@Column(name="MCTSBU")
	private String mctsbu;

	@Column(name="MCTXA1")
	private String mctxa1;

	@Column(name="MCTXJS")
	private double mctxjs;

	@Column(name="MCUPMJ")
	private BigDecimal mcupmj;

	@Column(name="MCUPMT")
	private double mcupmt;

	@Column(name="MCUSER")
	private String mcuser;

	public F0006() {
	}

	public String getMcmcu() {
		return this.mcmcu;
	}

	public void setMcmcu(String mcmcu) {
		this.mcmcu = mcmcu;
	}

	public String getMcadds() {
		return this.mcadds;
	}

	public void setMcadds(String mcadds) {
		this.mcadds = mcadds;
	}

	public String getMcalcl() {
		return this.mcalcl;
	}

	public void setMcalcl(String mcalcl) {
		this.mcalcl = mcalcl;
	}

	public String getMcals() {
		return this.mcals;
	}

	public void setMcals(String mcals) {
		this.mcals = mcals;
	}

	public double getMcan8() {
		return this.mcan8;
	}

	public void setMcan8(double mcan8) {
		this.mcan8 = mcan8;
	}

	public double getMcan8o() {
		return this.mcan8o;
	}

	public void setMcan8o(double mcan8o) {
		this.mcan8o = mcan8o;
	}

	public double getMcanpa() {
		return this.mcanpa;
	}

	public void setMcanpa(double mcanpa) {
		this.mcanpa = mcanpa;
	}

	public String getMcapsb() {
		return this.mcapsb;
	}

	public void setMcapsb(String mcapsb) {
		this.mcapsb = mcapsb;
	}

	public String getMcbptp() {
		return this.mcbptp;
	}

	public void setMcbptp(String mcbptp) {
		this.mcbptp = mcbptp;
	}

	public String getMcbtyp() {
		return this.mcbtyp;
	}

	public void setMcbtyp(String mcbtyp) {
		this.mcbtyp = mcbtyp;
	}

	public double getMccac() {
		return this.mccac;
	}

	public void setMccac(double mccac) {
		this.mccac = mccac;
	}

	public String getMccc01() {
		return this.mccc01;
	}

	public void setMccc01(String mccc01) {
		this.mccc01 = mccc01;
	}

	public String getMccc02() {
		return this.mccc02;
	}

	public void setMccc02(String mccc02) {
		this.mccc02 = mccc02;
	}

	public String getMccc03() {
		return this.mccc03;
	}

	public void setMccc03(String mccc03) {
		this.mccc03 = mccc03;
	}

	public String getMccc04() {
		return this.mccc04;
	}

	public void setMccc04(String mccc04) {
		this.mccc04 = mccc04;
	}

	public String getMccc05() {
		return this.mccc05;
	}

	public void setMccc05(String mccc05) {
		this.mccc05 = mccc05;
	}

	public String getMccc06() {
		return this.mccc06;
	}

	public void setMccc06(String mccc06) {
		this.mccc06 = mccc06;
	}

	public String getMccc07() {
		return this.mccc07;
	}

	public void setMccc07(String mccc07) {
		this.mccc07 = mccc07;
	}

	public String getMccc08() {
		return this.mccc08;
	}

	public void setMccc08(String mccc08) {
		this.mccc08 = mccc08;
	}

	public String getMccc09() {
		return this.mccc09;
	}

	public void setMccc09(String mccc09) {
		this.mccc09 = mccc09;
	}

	public String getMccc10() {
		return this.mccc10;
	}

	public void setMccc10(String mccc10) {
		this.mccc10 = mccc10;
	}

	public String getMccert() {
		return this.mccert;
	}

	public void setMccert(String mccert) {
		this.mccert = mccert;
	}

	public String getMccnty() {
		return this.mccnty;
	}

	public void setMccnty(String mccnty) {
		this.mccnty = mccnty;
	}

	public String getMcco() {
		return this.mcco;
	}

	public void setMcco(String mcco) {
		this.mcco = mcco;
	}

	public String getMcct() {
		return this.mcct;
	}

	public void setMcct(String mcct) {
		this.mcct = mcct;
	}

	public BigDecimal getMcd1j() {
		return this.mcd1j;
	}

	public void setMcd1j(BigDecimal mcd1j) {
		this.mcd1j = mcd1j;
	}

	public BigDecimal getMcd2j() {
		return this.mcd2j;
	}

	public void setMcd2j(BigDecimal mcd2j) {
		this.mcd2j = mcd2j;
	}

	public BigDecimal getMcd3j() {
		return this.mcd3j;
	}

	public void setMcd3j(BigDecimal mcd3j) {
		this.mcd3j = mcd3j;
	}

	public BigDecimal getMcd4j() {
		return this.mcd4j;
	}

	public void setMcd4j(BigDecimal mcd4j) {
		this.mcd4j = mcd4j;
	}

	public BigDecimal getMcd5j() {
		return this.mcd5j;
	}

	public void setMcd5j(BigDecimal mcd5j) {
		this.mcd5j = mcd5j;
	}

	public BigDecimal getMcd6j() {
		return this.mcd6j;
	}

	public void setMcd6j(BigDecimal mcd6j) {
		this.mcd6j = mcd6j;
	}

	public String getMcdc() {
		return this.mcdc;
	}

	public void setMcdc(String mcdc) {
		this.mcdc = mcdc;
	}

	public String getMcdl01() {
		return this.mcdl01;
	}

	public void setMcdl01(String mcdl01) {
		this.mcdl01 = mcdl01;
	}

	public String getMcdl02() {
		return this.mcdl02;
	}

	public void setMcdl02(String mcdl02) {
		this.mcdl02 = mcdl02;
	}

	public String getMcdl03() {
		return this.mcdl03;
	}

	public void setMcdl03(String mcdl03) {
		this.mcdl03 = mcdl03;
	}

	public String getMcdl04() {
		return this.mcdl04;
	}

	public void setMcdl04(String mcdl04) {
		this.mcdl04 = mcdl04;
	}

	public String getMceeo() {
		return this.mceeo;
	}

	public void setMceeo(String mceeo) {
		this.mceeo = mceeo;
	}

	public String getMcerc() {
		return this.mcerc;
	}

	public void setMcerc(String mcerc) {
		this.mcerc = mcerc;
	}

	public String getMcexr1() {
		return this.mcexr1;
	}

	public void setMcexr1(String mcexr1) {
		this.mcexr1 = mcexr1;
	}

	public String getMcfmod() {
		return this.mcfmod;
	}

	public void setMcfmod(String mcfmod) {
		this.mcfmod = mcfmod;
	}

	public BigDecimal getMcfpdj() {
		return this.mcfpdj;
	}

	public void setMcfpdj(BigDecimal mcfpdj) {
		this.mcfpdj = mcfpdj;
	}

	public String getMcglba() {
		return this.mcglba;
	}

	public void setMcglba(String mcglba) {
		this.mcglba = mcglba;
	}

	public String getMcinta() {
		return this.mcinta;
	}

	public void setMcinta(String mcinta) {
		this.mcinta = mcinta;
	}

	public String getMcintl() {
		return this.mcintl;
	}

	public void setMcintl(String mcintl) {
		this.mcintl = mcintl;
	}

	public String getMciss() {
		return this.mciss;
	}

	public void setMciss(String mciss) {
		this.mciss = mciss;
	}

	public String getMcjobn() {
		return this.mcjobn;
	}

	public void setMcjobn(String mcjobn) {
		this.mcjobn = mcjobn;
	}

	public String getMcldm() {
		return this.mcldm;
	}

	public void setMcldm(String mcldm) {
		this.mcldm = mcldm;
	}

	public double getMclf() {
		return this.mclf;
	}

	public void setMclf(double mclf) {
		this.mclf = mclf;
	}

	public String getMclmth() {
		return this.mclmth;
	}

	public void setMclmth(String mclmth) {
		this.mclmth = mclmth;
	}

	public String getMcmcus() {
		return this.mcmcus;
	}

	public void setMcmcus(String mcmcus) {
		this.mcmcus = mcmcus;
	}

	public String getMcnd01() {
		return this.mcnd01;
	}

	public void setMcnd01(String mcnd01) {
		this.mcnd01 = mcnd01;
	}

	public String getMcnd02() {
		return this.mcnd02;
	}

	public void setMcnd02(String mcnd02) {
		this.mcnd02 = mcnd02;
	}

	public String getMcnd03() {
		return this.mcnd03;
	}

	public void setMcnd03(String mcnd03) {
		this.mcnd03 = mcnd03;
	}

	public String getMcnd04() {
		return this.mcnd04;
	}

	public void setMcnd04(String mcnd04) {
		this.mcnd04 = mcnd04;
	}

	public String getMcnd05() {
		return this.mcnd05;
	}

	public void setMcnd05(String mcnd05) {
		this.mcnd05 = mcnd05;
	}

	public String getMcnd06() {
		return this.mcnd06;
	}

	public void setMcnd06(String mcnd06) {
		this.mcnd06 = mcnd06;
	}

	public String getMcnd07() {
		return this.mcnd07;
	}

	public void setMcnd07(String mcnd07) {
		this.mcnd07 = mcnd07;
	}

	public String getMcnd08() {
		return this.mcnd08;
	}

	public void setMcnd08(String mcnd08) {
		this.mcnd08 = mcnd08;
	}

	public String getMcnd09() {
		return this.mcnd09;
	}

	public void setMcnd09(String mcnd09) {
		this.mcnd09 = mcnd09;
	}

	public String getMcnd10() {
		return this.mcnd10;
	}

	public void setMcnd10(String mcnd10) {
		this.mcnd10 = mcnd10;
	}

	public String getMcobj1() {
		return this.mcobj1;
	}

	public void setMcobj1(String mcobj1) {
		this.mcobj1 = mcobj1;
	}

	public String getMcobj2() {
		return this.mcobj2;
	}

	public void setMcobj2(String mcobj2) {
		this.mcobj2 = mcobj2;
	}

	public String getMcobj3() {
		return this.mcobj3;
	}

	public void setMcobj3(String mcobj3) {
		this.mcobj3 = mcobj3;
	}

	public double getMcpac() {
		return this.mcpac;
	}

	public void setMcpac(double mcpac) {
		this.mcpac = mcpac;
	}

	public double getMcpc() {
		return this.mcpc;
	}

	public void setMcpc(double mcpc) {
		this.mcpc = mcpc;
	}

	public double getMcpca() {
		return this.mcpca;
	}

	public void setMcpca(double mcpca) {
		this.mcpca = mcpca;
	}

	public double getMcpcc() {
		return this.mcpcc;
	}

	public void setMcpcc(double mcpcc) {
		this.mcpcc = mcpcc;
	}

	public String getMcpecc() {
		return this.mcpecc;
	}

	public void setMcpecc(String mcpecc) {
		this.mcpecc = mcpecc;
	}

	public String getMcpid() {
		return this.mcpid;
	}

	public void setMcpid(String mcpid) {
		this.mcpid = mcpid;
	}

	public String getMcrp01() {
		return this.mcrp01;
	}

	public void setMcrp01(String mcrp01) {
		this.mcrp01 = mcrp01;
	}

	public String getMcrp02() {
		return this.mcrp02;
	}

	public void setMcrp02(String mcrp02) {
		this.mcrp02 = mcrp02;
	}

	public String getMcrp03() {
		return this.mcrp03;
	}

	public void setMcrp03(String mcrp03) {
		this.mcrp03 = mcrp03;
	}

	public String getMcrp04() {
		return this.mcrp04;
	}

	public void setMcrp04(String mcrp04) {
		this.mcrp04 = mcrp04;
	}

	public String getMcrp05() {
		return this.mcrp05;
	}

	public void setMcrp05(String mcrp05) {
		this.mcrp05 = mcrp05;
	}

	public String getMcrp06() {
		return this.mcrp06;
	}

	public void setMcrp06(String mcrp06) {
		this.mcrp06 = mcrp06;
	}

	public String getMcrp07() {
		return this.mcrp07;
	}

	public void setMcrp07(String mcrp07) {
		this.mcrp07 = mcrp07;
	}

	public String getMcrp08() {
		return this.mcrp08;
	}

	public void setMcrp08(String mcrp08) {
		this.mcrp08 = mcrp08;
	}

	public String getMcrp09() {
		return this.mcrp09;
	}

	public void setMcrp09(String mcrp09) {
		this.mcrp09 = mcrp09;
	}

	public String getMcrp10() {
		return this.mcrp10;
	}

	public void setMcrp10(String mcrp10) {
		this.mcrp10 = mcrp10;
	}

	public String getMcrp11() {
		return this.mcrp11;
	}

	public void setMcrp11(String mcrp11) {
		this.mcrp11 = mcrp11;
	}

	public String getMcrp12() {
		return this.mcrp12;
	}

	public void setMcrp12(String mcrp12) {
		this.mcrp12 = mcrp12;
	}

	public String getMcrp13() {
		return this.mcrp13;
	}

	public void setMcrp13(String mcrp13) {
		this.mcrp13 = mcrp13;
	}

	public String getMcrp14() {
		return this.mcrp14;
	}

	public void setMcrp14(String mcrp14) {
		this.mcrp14 = mcrp14;
	}

	public String getMcrp15() {
		return this.mcrp15;
	}

	public void setMcrp15(String mcrp15) {
		this.mcrp15 = mcrp15;
	}

	public String getMcrp16() {
		return this.mcrp16;
	}

	public void setMcrp16(String mcrp16) {
		this.mcrp16 = mcrp16;
	}

	public String getMcrp17() {
		return this.mcrp17;
	}

	public void setMcrp17(String mcrp17) {
		this.mcrp17 = mcrp17;
	}

	public String getMcrp18() {
		return this.mcrp18;
	}

	public void setMcrp18(String mcrp18) {
		this.mcrp18 = mcrp18;
	}

	public String getMcrp19() {
		return this.mcrp19;
	}

	public void setMcrp19(String mcrp19) {
		this.mcrp19 = mcrp19;
	}

	public String getMcrp20() {
		return this.mcrp20;
	}

	public void setMcrp20(String mcrp20) {
		this.mcrp20 = mcrp20;
	}

	public String getMcrp21() {
		return this.mcrp21;
	}

	public void setMcrp21(String mcrp21) {
		this.mcrp21 = mcrp21;
	}

	public String getMcrp22() {
		return this.mcrp22;
	}

	public void setMcrp22(String mcrp22) {
		this.mcrp22 = mcrp22;
	}

	public String getMcrp23() {
		return this.mcrp23;
	}

	public void setMcrp23(String mcrp23) {
		this.mcrp23 = mcrp23;
	}

	public String getMcrp24() {
		return this.mcrp24;
	}

	public void setMcrp24(String mcrp24) {
		this.mcrp24 = mcrp24;
	}

	public String getMcrp25() {
		return this.mcrp25;
	}

	public void setMcrp25(String mcrp25) {
		this.mcrp25 = mcrp25;
	}

	public String getMcrp26() {
		return this.mcrp26;
	}

	public void setMcrp26(String mcrp26) {
		this.mcrp26 = mcrp26;
	}

	public String getMcrp27() {
		return this.mcrp27;
	}

	public void setMcrp27(String mcrp27) {
		this.mcrp27 = mcrp27;
	}

	public String getMcrp28() {
		return this.mcrp28;
	}

	public void setMcrp28(String mcrp28) {
		this.mcrp28 = mcrp28;
	}

	public String getMcrp29() {
		return this.mcrp29;
	}

	public void setMcrp29(String mcrp29) {
		this.mcrp29 = mcrp29;
	}

	public String getMcrp30() {
		return this.mcrp30;
	}

	public void setMcrp30(String mcrp30) {
		this.mcrp30 = mcrp30;
	}

	public String getMcsbli() {
		return this.mcsbli;
	}

	public void setMcsbli(String mcsbli) {
		this.mcsbli = mcsbli;
	}

	public String getMcstyl() {
		return this.mcstyl;
	}

	public void setMcstyl(String mcstyl) {
		this.mcstyl = mcstyl;
	}

	public String getMcsub1() {
		return this.mcsub1;
	}

	public void setMcsub1(String mcsub1) {
		this.mcsub1 = mcsub1;
	}

	public String getMcta() {
		return this.mcta;
	}

	public void setMcta(String mcta) {
		this.mcta = mcta;
	}

	public String getMctc01() {
		return this.mctc01;
	}

	public void setMctc01(String mctc01) {
		this.mctc01 = mctc01;
	}

	public String getMctc02() {
		return this.mctc02;
	}

	public void setMctc02(String mctc02) {
		this.mctc02 = mctc02;
	}

	public String getMctc03() {
		return this.mctc03;
	}

	public void setMctc03(String mctc03) {
		this.mctc03 = mctc03;
	}

	public String getMctc04() {
		return this.mctc04;
	}

	public void setMctc04(String mctc04) {
		this.mctc04 = mctc04;
	}

	public String getMctc05() {
		return this.mctc05;
	}

	public void setMctc05(String mctc05) {
		this.mctc05 = mctc05;
	}

	public String getMctc06() {
		return this.mctc06;
	}

	public void setMctc06(String mctc06) {
		this.mctc06 = mctc06;
	}

	public String getMctc07() {
		return this.mctc07;
	}

	public void setMctc07(String mctc07) {
		this.mctc07 = mctc07;
	}

	public String getMctc08() {
		return this.mctc08;
	}

	public void setMctc08(String mctc08) {
		this.mctc08 = mctc08;
	}

	public String getMctc09() {
		return this.mctc09;
	}

	public void setMctc09(String mctc09) {
		this.mctc09 = mctc09;
	}

	public String getMctc10() {
		return this.mctc10;
	}

	public void setMctc10(String mctc10) {
		this.mctc10 = mctc10;
	}

	public double getMctou() {
		return this.mctou;
	}

	public void setMctou(double mctou) {
		this.mctou = mctou;
	}

	public String getMctsbu() {
		return this.mctsbu;
	}

	public void setMctsbu(String mctsbu) {
		this.mctsbu = mctsbu;
	}

	public String getMctxa1() {
		return this.mctxa1;
	}

	public void setMctxa1(String mctxa1) {
		this.mctxa1 = mctxa1;
	}

	public double getMctxjs() {
		return this.mctxjs;
	}

	public void setMctxjs(double mctxjs) {
		this.mctxjs = mctxjs;
	}

	public BigDecimal getMcupmj() {
		return this.mcupmj;
	}

	public void setMcupmj(BigDecimal mcupmj) {
		this.mcupmj = mcupmj;
	}

	public double getMcupmt() {
		return this.mcupmt;
	}

	public void setMcupmt(double mcupmt) {
		this.mcupmt = mcupmt;
	}

	public String getMcuser() {
		return this.mcuser;
	}

	public void setMcuser(String mcuser) {
		this.mcuser = mcuser;
	}

}