package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0116PK;


/**
 * The persistent class for the F0116 database table.
 * 
 */
@Entity
public class F0116 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0116PK id;

	@Column(name="ALADD1")
	private String aladd1;

	@Column(name="ALADD2")
	private String aladd2;

	@Column(name="ALADD3")
	private String aladd3;

	@Column(name="ALADD4")
	private String aladd4;

	@Column(name="ALADDS")
	private String aladds;

	@Column(name="ALADDZ")
	private String aladdz;

	@Column(name="ALBKML")
	private String albkml;

	@Column(name="ALCAAD")
	private Double alcaad;

	@Column(name="ALCOUN")
	private String alcoun;

	@Column(name="ALCRTE")
	private String alcrte;

	@Column(name="ALCTR")
	private String alctr;

	@Column(name="ALCTY1")
	private String alcty1;

	@Column(name="ALEFTF")
	private String aleftf;

	@Column(name="ALJOBN")
	private String aljobn;

	@Column(name="ALPID")
	private String alpid;

	@Column(name="ALSYNCS")
	private Double alsyncs;

	@Column(name="ALUPMJ")
	private BigDecimal alupmj;

	@Column(name="ALUPMT")
	private Double alupmt;

	@Column(name="ALUSER")
	private String aluser;

	public F0116() {
	}

	public F0116PK getId() {
		return this.id;
	}

	public void setId(F0116PK id) {
		this.id = id;
	}

	public String getAladd1() {
		return this.aladd1;
	}

	public void setAladd1(String aladd1) {
		this.aladd1 = aladd1;
	}

	public String getAladd2() {
		return this.aladd2;
	}

	public void setAladd2(String aladd2) {
		this.aladd2 = aladd2;
	}

	public String getAladd3() {
		return this.aladd3;
	}

	public void setAladd3(String aladd3) {
		this.aladd3 = aladd3;
	}

	public String getAladd4() {
		return this.aladd4;
	}

	public void setAladd4(String aladd4) {
		this.aladd4 = aladd4;
	}

	public String getAladds() {
		return this.aladds;
	}

	public void setAladds(String aladds) {
		this.aladds = aladds;
	}

	public String getAladdz() {
		return this.aladdz;
	}

	public void setAladdz(String aladdz) {
		this.aladdz = aladdz;
	}

	public String getAlbkml() {
		return this.albkml;
	}

	public void setAlbkml(String albkml) {
		this.albkml = albkml;
	}

	public Double getAlcaad() {
		return this.alcaad;
	}

	public void setAlcaad(Double alcaad) {
		this.alcaad = alcaad;
	}

	public String getAlcoun() {
		return this.alcoun;
	}

	public void setAlcoun(String alcoun) {
		this.alcoun = alcoun;
	}

	public String getAlcrte() {
		return this.alcrte;
	}

	public void setAlcrte(String alcrte) {
		this.alcrte = alcrte;
	}

	public String getAlctr() {
		return this.alctr;
	}

	public void setAlctr(String alctr) {
		this.alctr = alctr;
	}

	public String getAlcty1() {
		return this.alcty1;
	}

	public void setAlcty1(String alcty1) {
		this.alcty1 = alcty1;
	}

	public String getAleftf() {
		return this.aleftf;
	}

	public void setAleftf(String aleftf) {
		this.aleftf = aleftf;
	}

	public String getAljobn() {
		return this.aljobn;
	}

	public void setAljobn(String aljobn) {
		this.aljobn = aljobn;
	}

	public String getAlpid() {
		return this.alpid;
	}

	public void setAlpid(String alpid) {
		this.alpid = alpid;
	}

	public Double getAlsyncs() {
		return this.alsyncs;
	}

	public void setAlsyncs(Double alsyncs) {
		this.alsyncs = alsyncs;
	}

	public BigDecimal getAlupmj() {
		return this.alupmj;
	}

	public void setAlupmj(BigDecimal alupmj) {
		this.alupmj = alupmj;
	}

	public Double getAlupmt() {
		return this.alupmt;
	}

	public void setAlupmt(Double alupmt) {
		this.alupmt = alupmt;
	}

	public String getAluser() {
		return this.aluser;
	}

	public void setAluser(String aluser) {
		this.aluser = aluser;
	}

}