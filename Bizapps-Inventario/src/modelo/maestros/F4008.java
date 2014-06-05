package modelo.maestros;

import java.io.Serializable;
import javax.persistence.*;

import modelo.pk.F4008PK;

import java.math.BigDecimal;


/**
 * The persistent class for the F4008 database table.
 * 
 */
@Entity
public class F4008 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4008PK id;

	@Column(name="TAAITM")
	private String taaitm;

	@Column(name="TAEFTJ")
	private BigDecimal taeftj;

	@Column(name="TAFVTY")
	private String tafvty;

	@Column(name="TAGL01")
	private String tagl01;

	@Column(name="TAGL02")
	private String tagl02;

	@Column(name="TAGL03")
	private String tagl03;

	@Column(name="TAGL04")
	private String tagl04;

	@Column(name="TAGL05")
	private String tagl05;

	@Column(name="TALITM")
	private String talitm;

	@Column(name="TAMTAX")
	private Double tamtax;

	@Column(name="TATA1")
	private Double tata1;

	@Column(name="TATA2")
	private Double tata2;

	@Column(name="TATA3")
	private Double tata3;

	@Column(name="TATA4")
	private Double tata4;

	@Column(name="TATA5")
	private Double tata5;

	@Column(name="TATAXA")
	private String tataxa;

	@Column(name="TATC1")
	private String tatc1;

	@Column(name="TATC2")
	private String tatc2;

	@Column(name="TATC3")
	private String tatc3;

	@Column(name="TATC4")
	private String tatc4;

	@Column(name="TATC5")
	private String tatc5;

	@Column(name="TATT1")
	private String tatt1;

	@Column(name="TATT2")
	private String tatt2;

	@Column(name="TATT3")
	private String tatt3;

	@Column(name="TATT4")
	private String tatt4;

	@Column(name="TATT5")
	private String tatt5;

	@Column(name="TATXR1")
	private Double tatxr1;

	@Column(name="TATXR2")
	private Double tatxr2;

	@Column(name="TATXR3")
	private Double tatxr3;

	@Column(name="TATXR4")
	private Double tatxr4;

	@Column(name="TATXR5")
	private Double tatxr5;

	@Column(name="TAUOM")
	private String tauom;

	public F4008() {
	}

	public F4008PK getId() {
		return this.id;
	}

	public void setId(F4008PK id) {
		this.id = id;
	}

	public String getTaaitm() {
		return this.taaitm;
	}

	public void setTaaitm(String taaitm) {
		this.taaitm = taaitm;
	}

	public BigDecimal getTaeftj() {
		return this.taeftj;
	}

	public void setTaeftj(BigDecimal taeftj) {
		this.taeftj = taeftj;
	}

	public String getTafvty() {
		return this.tafvty;
	}

	public void setTafvty(String tafvty) {
		this.tafvty = tafvty;
	}

	public String getTagl01() {
		return this.tagl01;
	}

	public void setTagl01(String tagl01) {
		this.tagl01 = tagl01;
	}

	public String getTagl02() {
		return this.tagl02;
	}

	public void setTagl02(String tagl02) {
		this.tagl02 = tagl02;
	}

	public String getTagl03() {
		return this.tagl03;
	}

	public void setTagl03(String tagl03) {
		this.tagl03 = tagl03;
	}

	public String getTagl04() {
		return this.tagl04;
	}

	public void setTagl04(String tagl04) {
		this.tagl04 = tagl04;
	}

	public String getTagl05() {
		return this.tagl05;
	}

	public void setTagl05(String tagl05) {
		this.tagl05 = tagl05;
	}

	public String getTalitm() {
		return this.talitm;
	}

	public void setTalitm(String talitm) {
		this.talitm = talitm;
	}

	public Double getTamtax() {
		return this.tamtax;
	}

	public void setTamtax(Double tamtax) {
		this.tamtax = tamtax;
	}

	public Double getTata1() {
		return this.tata1;
	}

	public void setTata1(Double tata1) {
		this.tata1 = tata1;
	}

	public Double getTata2() {
		return this.tata2;
	}

	public void setTata2(Double tata2) {
		this.tata2 = tata2;
	}

	public Double getTata3() {
		return this.tata3;
	}

	public void setTata3(Double tata3) {
		this.tata3 = tata3;
	}

	public Double getTata4() {
		return this.tata4;
	}

	public void setTata4(Double tata4) {
		this.tata4 = tata4;
	}

	public Double getTata5() {
		return this.tata5;
	}

	public void setTata5(Double tata5) {
		this.tata5 = tata5;
	}

	public String getTataxa() {
		return this.tataxa;
	}

	public void setTataxa(String tataxa) {
		this.tataxa = tataxa;
	}

	public String getTatc1() {
		return this.tatc1;
	}

	public void setTatc1(String tatc1) {
		this.tatc1 = tatc1;
	}

	public String getTatc2() {
		return this.tatc2;
	}

	public void setTatc2(String tatc2) {
		this.tatc2 = tatc2;
	}

	public String getTatc3() {
		return this.tatc3;
	}

	public void setTatc3(String tatc3) {
		this.tatc3 = tatc3;
	}

	public String getTatc4() {
		return this.tatc4;
	}

	public void setTatc4(String tatc4) {
		this.tatc4 = tatc4;
	}

	public String getTatc5() {
		return this.tatc5;
	}

	public void setTatc5(String tatc5) {
		this.tatc5 = tatc5;
	}

	public String getTatt1() {
		return this.tatt1;
	}

	public void setTatt1(String tatt1) {
		this.tatt1 = tatt1;
	}

	public String getTatt2() {
		return this.tatt2;
	}

	public void setTatt2(String tatt2) {
		this.tatt2 = tatt2;
	}

	public String getTatt3() {
		return this.tatt3;
	}

	public void setTatt3(String tatt3) {
		this.tatt3 = tatt3;
	}

	public String getTatt4() {
		return this.tatt4;
	}

	public void setTatt4(String tatt4) {
		this.tatt4 = tatt4;
	}

	public String getTatt5() {
		return this.tatt5;
	}

	public void setTatt5(String tatt5) {
		this.tatt5 = tatt5;
	}

	public Double getTatxr1() {
		return this.tatxr1;
	}

	public void setTatxr1(Double tatxr1) {
		this.tatxr1 = tatxr1;
	}

	public Double getTatxr2() {
		return this.tatxr2;
	}

	public void setTatxr2(Double tatxr2) {
		this.tatxr2 = tatxr2;
	}

	public Double getTatxr3() {
		return this.tatxr3;
	}

	public void setTatxr3(Double tatxr3) {
		this.tatxr3 = tatxr3;
	}

	public Double getTatxr4() {
		return this.tatxr4;
	}

	public void setTatxr4(Double tatxr4) {
		this.tatxr4 = tatxr4;
	}

	public Double getTatxr5() {
		return this.tatxr5;
	}

	public void setTatxr5(Double tatxr5) {
		this.tatxr5 = tatxr5;
	}

	public String getTauom() {
		return this.tauom;
	}

	public void setTauom(String tauom) {
		this.tauom = tauom;
	}

}