package modelo.maestros;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the F40205 database table.
 * 
 */
@Entity
public class F40205 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LFLNTY")
	private String lflnty;

	@Column(name="LFAFT")
	private String lfaft;

	@Column(name="LFAPI")
	private String lfapi;

	@Column(name="LFARI")
	private String lfari;

	@Column(name="LFART")
	private String lfart;

	@Column(name="LFCDSC")
	private String lfcdsc;

	@Column(name="LFCMI")
	private String lfcmi;

	@Column(name="LFCSJ")
	private String lfcsj;

	@Column(name="LFDCTO")
	private String lfdcto;

	@Column(name="LFEV01")
	private String lfev01;

	@Column(name="LFEV02")
	private String lfev02;

	@Column(name="LFEV03")
	private String lfev03;

	@Column(name="LFEV04")
	private String lfev04;

	@Column(name="LFEV05")
	private String lfev05;

	@Column(name="LFEXVR")
	private String lfexvr;

	@Column(name="LFGLC")
	private String lfglc;

	@Column(name="LFGLI")
	private String lfgli;

	@Column(name="LFGWO")
	private String lfgwo;

	@Column(name="LFIDC1")
	private String lfidc1;

	@Column(name="LFIDC2")
	private String lfidc2;

	@Column(name="LFIDC3")
	private String lfidc3;

	@Column(name="LFIDC4")
	private String lfidc4;

	@Column(name="LFIVI")
	private String lfivi;

	@Column(name="LFLND2")
	private String lflnd2;

	@Column(name="LFLNDS")
	private String lflnds;

	@Column(name="LFPDC1")
	private String lfpdc1;

	@Column(name="LFPDC2")
	private String lfpdc2;

	@Column(name="LFPDC3")
	private String lfpdc3;

	@Column(name="LFPDC4")
	private String lfpdc4;

	@Column(name="LFPRFT")
	private String lfprft;

	@Column(name="LFPRRQ")
	private String lfprrq;

	@Column(name="LFRSGN")
	private String lfrsgn;

	@Column(name="LFTX01")
	private String lftx01;

	@Column(name="LFTX02")
	private String lftx02;

	@Column(name="LFTXYN")
	private String lftxyn;

	public F40205() {
	}

	public String getLflnty() {
		return this.lflnty;
	}

	public void setLflnty(String lflnty) {
		this.lflnty = lflnty;
	}

	public String getLfaft() {
		return this.lfaft;
	}

	public void setLfaft(String lfaft) {
		this.lfaft = lfaft;
	}

	public String getLfapi() {
		return this.lfapi;
	}

	public void setLfapi(String lfapi) {
		this.lfapi = lfapi;
	}

	public String getLfari() {
		return this.lfari;
	}

	public void setLfari(String lfari) {
		this.lfari = lfari;
	}

	public String getLfart() {
		return this.lfart;
	}

	public void setLfart(String lfart) {
		this.lfart = lfart;
	}

	public String getLfcdsc() {
		return this.lfcdsc;
	}

	public void setLfcdsc(String lfcdsc) {
		this.lfcdsc = lfcdsc;
	}

	public String getLfcmi() {
		return this.lfcmi;
	}

	public void setLfcmi(String lfcmi) {
		this.lfcmi = lfcmi;
	}

	public String getLfcsj() {
		return this.lfcsj;
	}

	public void setLfcsj(String lfcsj) {
		this.lfcsj = lfcsj;
	}

	public String getLfdcto() {
		return this.lfdcto;
	}

	public void setLfdcto(String lfdcto) {
		this.lfdcto = lfdcto;
	}

	public String getLfev01() {
		return this.lfev01;
	}

	public void setLfev01(String lfev01) {
		this.lfev01 = lfev01;
	}

	public String getLfev02() {
		return this.lfev02;
	}

	public void setLfev02(String lfev02) {
		this.lfev02 = lfev02;
	}

	public String getLfev03() {
		return this.lfev03;
	}

	public void setLfev03(String lfev03) {
		this.lfev03 = lfev03;
	}

	public String getLfev04() {
		return this.lfev04;
	}

	public void setLfev04(String lfev04) {
		this.lfev04 = lfev04;
	}

	public String getLfev05() {
		return this.lfev05;
	}

	public void setLfev05(String lfev05) {
		this.lfev05 = lfev05;
	}

	public String getLfexvr() {
		return this.lfexvr;
	}

	public void setLfexvr(String lfexvr) {
		this.lfexvr = lfexvr;
	}

	public String getLfglc() {
		return this.lfglc;
	}

	public void setLfglc(String lfglc) {
		this.lfglc = lfglc;
	}

	public String getLfgli() {
		return this.lfgli;
	}

	public void setLfgli(String lfgli) {
		this.lfgli = lfgli;
	}

	public String getLfgwo() {
		return this.lfgwo;
	}

	public void setLfgwo(String lfgwo) {
		this.lfgwo = lfgwo;
	}

	public String getLfidc1() {
		return this.lfidc1;
	}

	public void setLfidc1(String lfidc1) {
		this.lfidc1 = lfidc1;
	}

	public String getLfidc2() {
		return this.lfidc2;
	}

	public void setLfidc2(String lfidc2) {
		this.lfidc2 = lfidc2;
	}

	public String getLfidc3() {
		return this.lfidc3;
	}

	public void setLfidc3(String lfidc3) {
		this.lfidc3 = lfidc3;
	}

	public String getLfidc4() {
		return this.lfidc4;
	}

	public void setLfidc4(String lfidc4) {
		this.lfidc4 = lfidc4;
	}

	public String getLfivi() {
		return this.lfivi;
	}

	public void setLfivi(String lfivi) {
		this.lfivi = lfivi;
	}

	public String getLflnd2() {
		return this.lflnd2;
	}

	public void setLflnd2(String lflnd2) {
		this.lflnd2 = lflnd2;
	}

	public String getLflnds() {
		return this.lflnds;
	}

	public void setLflnds(String lflnds) {
		this.lflnds = lflnds;
	}

	public String getLfpdc1() {
		return this.lfpdc1;
	}

	public void setLfpdc1(String lfpdc1) {
		this.lfpdc1 = lfpdc1;
	}

	public String getLfpdc2() {
		return this.lfpdc2;
	}

	public void setLfpdc2(String lfpdc2) {
		this.lfpdc2 = lfpdc2;
	}

	public String getLfpdc3() {
		return this.lfpdc3;
	}

	public void setLfpdc3(String lfpdc3) {
		this.lfpdc3 = lfpdc3;
	}

	public String getLfpdc4() {
		return this.lfpdc4;
	}

	public void setLfpdc4(String lfpdc4) {
		this.lfpdc4 = lfpdc4;
	}

	public String getLfprft() {
		return this.lfprft;
	}

	public void setLfprft(String lfprft) {
		this.lfprft = lfprft;
	}

	public String getLfprrq() {
		return this.lfprrq;
	}

	public void setLfprrq(String lfprrq) {
		this.lfprrq = lfprrq;
	}

	public String getLfrsgn() {
		return this.lfrsgn;
	}

	public void setLfrsgn(String lfrsgn) {
		this.lfrsgn = lfrsgn;
	}

	public String getLftx01() {
		return this.lftx01;
	}

	public void setLftx01(String lftx01) {
		this.lftx01 = lftx01;
	}

	public String getLftx02() {
		return this.lftx02;
	}

	public void setLftx02(String lftx02) {
		this.lftx02 = lftx02;
	}

	public String getLftxyn() {
		return this.lftxyn;
	}

	public void setLftxyn(String lftxyn) {
		this.lftxyn = lftxyn;
	}

}