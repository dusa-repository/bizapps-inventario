package modelo.maestros;

import java.io.Serializable;
import javax.persistence.*;

import modelo.pk.F4108PK;

import java.math.BigDecimal;


/**
 * The persistent class for the F4108 database table.
 * 
 */
@Entity
public class F4108 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F4108PK id;

	@Column(name="IOAITM")
	private String ioaitm;

	@Column(name="IOBBDJ")
	private BigDecimal iobbdj;

	@Column(name="IOBODJ")
	private BigDecimal iobodj;

	@Column(name="IOCHDF")
	private String iochdf;

	@Column(name="IODCTO")
	private String iodcto;

	@Column(name="IODLEJ")
	private BigDecimal iodlej;

	@Column(name="IODOC1")
	private Double iodoc1;

	@Column(name="IODOCO")
	private Double iodoco;

	@Column(name="IOJOBN")
	private String iojobn;

	@Column(name="IOKCOO")
	private String iokcoo;

	@Column(name="IOLDSC")
	private String ioldsc;

	@Column(name="IOLITM")
	private String iolitm;

	@Column(name="IOLOT1")
	private String iolot1;

	@Column(name="IOLOT2")
	private String iolot2;

	@Column(name="IOLOT3")
	private String iolot3;

	@Column(name="IOLOTC")
	private String iolotc;

	@Column(name="IOLOTG")
	private String iolotg;

	@Column(name="IOLOTP")
	private Double iolotp;

	@Column(name="IOLOTR")
	private String iolotr;

	@Column(name="IOLOTS")
	private String iolots;

	@Column(name="IOLRP0")
	private String iolrp0;

	@Column(name="IOLRP1")
	private String iolrp1;

	@Column(name="IOLRP2")
	private String iolrp2;

	@Column(name="IOLRP3")
	private String iolrp3;

	@Column(name="IOLRP4")
	private String iolrp4;

	@Column(name="IOLRP5")
	private String iolrp5;

	@Column(name="IOLRP6")
	private String iolrp6;

	@Column(name="IOLRP7")
	private String iolrp7;

	@Column(name="IOLRP8")
	private String iolrp8;

	@Column(name="IOLRP9")
	private String iolrp9;

	@Column(name="IOMMEJ")
	private BigDecimal iommej;

	@Column(name="IOOHDJ")
	private BigDecimal ioohdj;

	@Column(name="IOPID")
	private String iopid;

	@Column(name="IORLOT")
	private String iorlot;

	@Column(name="IOSBDJ")
	private BigDecimal iosbdj;

	@Column(name="IOSERN")
	private String iosern;

	@Column(name="IOTDAY")
	private Double iotday;

	@Column(name="IOU1DJ")
	private BigDecimal iou1dj;

	@Column(name="IOU2DJ")
	private BigDecimal iou2dj;

	@Column(name="IOU3DJ")
	private BigDecimal iou3dj;

	@Column(name="IOU4DJ")
	private BigDecimal iou4dj;

	@Column(name="IOU5DJ")
	private BigDecimal iou5dj;

	@Column(name="IOUA01")
	private BigDecimal ioua01;

	@Column(name="IOUA02")
	private BigDecimal ioua02;

	@Column(name="IOUA03")
	private BigDecimal ioua03;

	@Column(name="IOUA04")
	private BigDecimal ioua04;

	@Column(name="IOUA05")
	private BigDecimal ioua05;

	@Column(name="IOUA06")
	private BigDecimal ioua06;

	@Column(name="IOUB01")
	private Double ioub01;

	@Column(name="IOUB02")
	private Double ioub02;

	@Column(name="IOUB03")
	private Double ioub03;

	@Column(name="IOUB04")
	private Double ioub04;

	@Column(name="IOUB05")
	private Double ioub05;

	@Column(name="IOUB06")
	private Double ioub06;

	@Column(name="IOUPMJ")
	private BigDecimal ioupmj;

	@Column(name="IOUSER")
	private String iouser;

	@Column(name="IOVEND")
	private Double iovend;

	@Column(name="IOWPDF")
	private String iowpdf;

	public F4108() {
	}

	public F4108PK getId() {
		return this.id;
	}

	public void setId(F4108PK id) {
		this.id = id;
	}

	public String getIoaitm() {
		return this.ioaitm;
	}

	public void setIoaitm(String ioaitm) {
		this.ioaitm = ioaitm;
	}

	public BigDecimal getIobbdj() {
		return this.iobbdj;
	}

	public void setIobbdj(BigDecimal iobbdj) {
		this.iobbdj = iobbdj;
	}

	public BigDecimal getIobodj() {
		return this.iobodj;
	}

	public void setIobodj(BigDecimal iobodj) {
		this.iobodj = iobodj;
	}

	public String getIochdf() {
		return this.iochdf;
	}

	public void setIochdf(String iochdf) {
		this.iochdf = iochdf;
	}

	public String getIodcto() {
		return this.iodcto;
	}

	public void setIodcto(String iodcto) {
		this.iodcto = iodcto;
	}

	public BigDecimal getIodlej() {
		return this.iodlej;
	}

	public void setIodlej(BigDecimal iodlej) {
		this.iodlej = iodlej;
	}

	public Double getIodoc1() {
		return this.iodoc1;
	}

	public void setIodoc1(Double iodoc1) {
		this.iodoc1 = iodoc1;
	}

	public Double getIodoco() {
		return this.iodoco;
	}

	public void setIodoco(Double iodoco) {
		this.iodoco = iodoco;
	}

	public String getIojobn() {
		return this.iojobn;
	}

	public void setIojobn(String iojobn) {
		this.iojobn = iojobn;
	}

	public String getIokcoo() {
		return this.iokcoo;
	}

	public void setIokcoo(String iokcoo) {
		this.iokcoo = iokcoo;
	}

	public String getIoldsc() {
		return this.ioldsc;
	}

	public void setIoldsc(String ioldsc) {
		this.ioldsc = ioldsc;
	}

	public String getIolitm() {
		return this.iolitm;
	}

	public void setIolitm(String iolitm) {
		this.iolitm = iolitm;
	}

	public String getIolot1() {
		return this.iolot1;
	}

	public void setIolot1(String iolot1) {
		this.iolot1 = iolot1;
	}

	public String getIolot2() {
		return this.iolot2;
	}

	public void setIolot2(String iolot2) {
		this.iolot2 = iolot2;
	}

	public String getIolot3() {
		return this.iolot3;
	}

	public void setIolot3(String iolot3) {
		this.iolot3 = iolot3;
	}

	public String getIolotc() {
		return this.iolotc;
	}

	public void setIolotc(String iolotc) {
		this.iolotc = iolotc;
	}

	public String getIolotg() {
		return this.iolotg;
	}

	public void setIolotg(String iolotg) {
		this.iolotg = iolotg;
	}

	public Double getIolotp() {
		return this.iolotp;
	}

	public void setIolotp(Double iolotp) {
		this.iolotp = iolotp;
	}

	public String getIolotr() {
		return this.iolotr;
	}

	public void setIolotr(String iolotr) {
		this.iolotr = iolotr;
	}

	public String getIolots() {
		return this.iolots;
	}

	public void setIolots(String iolots) {
		this.iolots = iolots;
	}

	public String getIolrp0() {
		return this.iolrp0;
	}

	public void setIolrp0(String iolrp0) {
		this.iolrp0 = iolrp0;
	}

	public String getIolrp1() {
		return this.iolrp1;
	}

	public void setIolrp1(String iolrp1) {
		this.iolrp1 = iolrp1;
	}

	public String getIolrp2() {
		return this.iolrp2;
	}

	public void setIolrp2(String iolrp2) {
		this.iolrp2 = iolrp2;
	}

	public String getIolrp3() {
		return this.iolrp3;
	}

	public void setIolrp3(String iolrp3) {
		this.iolrp3 = iolrp3;
	}

	public String getIolrp4() {
		return this.iolrp4;
	}

	public void setIolrp4(String iolrp4) {
		this.iolrp4 = iolrp4;
	}

	public String getIolrp5() {
		return this.iolrp5;
	}

	public void setIolrp5(String iolrp5) {
		this.iolrp5 = iolrp5;
	}

	public String getIolrp6() {
		return this.iolrp6;
	}

	public void setIolrp6(String iolrp6) {
		this.iolrp6 = iolrp6;
	}

	public String getIolrp7() {
		return this.iolrp7;
	}

	public void setIolrp7(String iolrp7) {
		this.iolrp7 = iolrp7;
	}

	public String getIolrp8() {
		return this.iolrp8;
	}

	public void setIolrp8(String iolrp8) {
		this.iolrp8 = iolrp8;
	}

	public String getIolrp9() {
		return this.iolrp9;
	}

	public void setIolrp9(String iolrp9) {
		this.iolrp9 = iolrp9;
	}

	public BigDecimal getIommej() {
		return this.iommej;
	}

	public void setIommej(BigDecimal iommej) {
		this.iommej = iommej;
	}

	public BigDecimal getIoohdj() {
		return this.ioohdj;
	}

	public void setIoohdj(BigDecimal ioohdj) {
		this.ioohdj = ioohdj;
	}

	public String getIopid() {
		return this.iopid;
	}

	public void setIopid(String iopid) {
		this.iopid = iopid;
	}

	public String getIorlot() {
		return this.iorlot;
	}

	public void setIorlot(String iorlot) {
		this.iorlot = iorlot;
	}

	public BigDecimal getIosbdj() {
		return this.iosbdj;
	}

	public void setIosbdj(BigDecimal iosbdj) {
		this.iosbdj = iosbdj;
	}

	public String getIosern() {
		return this.iosern;
	}

	public void setIosern(String iosern) {
		this.iosern = iosern;
	}

	public Double getIotday() {
		return this.iotday;
	}

	public void setIotday(Double iotday) {
		this.iotday = iotday;
	}

	public BigDecimal getIou1dj() {
		return this.iou1dj;
	}

	public void setIou1dj(BigDecimal iou1dj) {
		this.iou1dj = iou1dj;
	}

	public BigDecimal getIou2dj() {
		return this.iou2dj;
	}

	public void setIou2dj(BigDecimal iou2dj) {
		this.iou2dj = iou2dj;
	}

	public BigDecimal getIou3dj() {
		return this.iou3dj;
	}

	public void setIou3dj(BigDecimal iou3dj) {
		this.iou3dj = iou3dj;
	}

	public BigDecimal getIou4dj() {
		return this.iou4dj;
	}

	public void setIou4dj(BigDecimal iou4dj) {
		this.iou4dj = iou4dj;
	}

	public BigDecimal getIou5dj() {
		return this.iou5dj;
	}

	public void setIou5dj(BigDecimal iou5dj) {
		this.iou5dj = iou5dj;
	}

	public BigDecimal getIoua01() {
		return this.ioua01;
	}

	public void setIoua01(BigDecimal ioua01) {
		this.ioua01 = ioua01;
	}

	public BigDecimal getIoua02() {
		return this.ioua02;
	}

	public void setIoua02(BigDecimal ioua02) {
		this.ioua02 = ioua02;
	}

	public BigDecimal getIoua03() {
		return this.ioua03;
	}

	public void setIoua03(BigDecimal ioua03) {
		this.ioua03 = ioua03;
	}

	public BigDecimal getIoua04() {
		return this.ioua04;
	}

	public void setIoua04(BigDecimal ioua04) {
		this.ioua04 = ioua04;
	}

	public BigDecimal getIoua05() {
		return this.ioua05;
	}

	public void setIoua05(BigDecimal ioua05) {
		this.ioua05 = ioua05;
	}

	public BigDecimal getIoua06() {
		return this.ioua06;
	}

	public void setIoua06(BigDecimal ioua06) {
		this.ioua06 = ioua06;
	}

	public Double getIoub01() {
		return this.ioub01;
	}

	public void setIoub01(Double ioub01) {
		this.ioub01 = ioub01;
	}

	public Double getIoub02() {
		return this.ioub02;
	}

	public void setIoub02(Double ioub02) {
		this.ioub02 = ioub02;
	}

	public Double getIoub03() {
		return this.ioub03;
	}

	public void setIoub03(Double ioub03) {
		this.ioub03 = ioub03;
	}

	public Double getIoub04() {
		return this.ioub04;
	}

	public void setIoub04(Double ioub04) {
		this.ioub04 = ioub04;
	}

	public Double getIoub05() {
		return this.ioub05;
	}

	public void setIoub05(Double ioub05) {
		this.ioub05 = ioub05;
	}

	public Double getIoub06() {
		return this.ioub06;
	}

	public void setIoub06(Double ioub06) {
		this.ioub06 = ioub06;
	}

	public BigDecimal getIoupmj() {
		return this.ioupmj;
	}

	public void setIoupmj(BigDecimal ioupmj) {
		this.ioupmj = ioupmj;
	}

	public String getIouser() {
		return this.iouser;
	}

	public void setIouser(String iouser) {
		this.iouser = iouser;
	}

	public Double getIovend() {
		return this.iovend;
	}

	public void setIovend(Double iovend) {
		this.iovend = iovend;
	}

	public String getIowpdf() {
		return this.iowpdf;
	}

	public void setIowpdf(String iowpdf) {
		this.iowpdf = iowpdf;
	}

}