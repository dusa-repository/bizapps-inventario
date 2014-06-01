package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0008PK;


/**
 * The persistent class for the F0008 database table.
 * 
 */
@Entity
public class F0008 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0008PK id;

	@Column(name="CDCTRY")
	private Double cdctry;

	@Column(name="CDD01J")
	private BigDecimal cdd01j;

	@Column(name="CDD02J")
	private BigDecimal cdd02j;

	@Column(name="CDD03J")
	private BigDecimal cdd03j;

	@Column(name="CDD04J")
	private BigDecimal cdd04j;

	@Column(name="CDD05J")
	private BigDecimal cdd05j;

	@Column(name="CDD06J")
	private BigDecimal cdd06j;

	@Column(name="CDD07J")
	private BigDecimal cdd07j;

	@Column(name="CDD08J")
	private BigDecimal cdd08j;

	@Column(name="CDD09J")
	private BigDecimal cdd09j;

	@Column(name="CDD10J")
	private BigDecimal cdd10j;

	@Column(name="CDD11J")
	private BigDecimal cdd11j;

	@Column(name="CDD12J")
	private BigDecimal cdd12j;

	@Column(name="CDD13J")
	private BigDecimal cdd13j;

	@Column(name="CDD14J")
	private BigDecimal cdd14j;

	@Column(name="CDFY")
	private Double cdfy;

	@Column(name="CDJOBN")
	private String cdjobn;

	@Column(name="CDPID")
	private String cdpid;

	@Column(name="CDPNT")
	private String cdpnt;

	@Column(name="CDUPMJ")
	private BigDecimal cdupmj;

	@Column(name="CDUPMT")
	private Double cdupmt;

	@Column(name="CDUSER")
	private String cduser;

	public F0008() {
	}

	public F0008PK getId() {
		return this.id;
	}

	public void setId(F0008PK id) {
		this.id = id;
	}

	public Double getCdctry() {
		return this.cdctry;
	}

	public void setCdctry(Double cdctry) {
		this.cdctry = cdctry;
	}

	public BigDecimal getCdd01j() {
		return this.cdd01j;
	}

	public void setCdd01j(BigDecimal cdd01j) {
		this.cdd01j = cdd01j;
	}

	public BigDecimal getCdd02j() {
		return this.cdd02j;
	}

	public void setCdd02j(BigDecimal cdd02j) {
		this.cdd02j = cdd02j;
	}

	public BigDecimal getCdd03j() {
		return this.cdd03j;
	}

	public void setCdd03j(BigDecimal cdd03j) {
		this.cdd03j = cdd03j;
	}

	public BigDecimal getCdd04j() {
		return this.cdd04j;
	}

	public void setCdd04j(BigDecimal cdd04j) {
		this.cdd04j = cdd04j;
	}

	public BigDecimal getCdd05j() {
		return this.cdd05j;
	}

	public void setCdd05j(BigDecimal cdd05j) {
		this.cdd05j = cdd05j;
	}

	public BigDecimal getCdd06j() {
		return this.cdd06j;
	}

	public void setCdd06j(BigDecimal cdd06j) {
		this.cdd06j = cdd06j;
	}

	public BigDecimal getCdd07j() {
		return this.cdd07j;
	}

	public void setCdd07j(BigDecimal cdd07j) {
		this.cdd07j = cdd07j;
	}

	public BigDecimal getCdd08j() {
		return this.cdd08j;
	}

	public void setCdd08j(BigDecimal cdd08j) {
		this.cdd08j = cdd08j;
	}

	public BigDecimal getCdd09j() {
		return this.cdd09j;
	}

	public void setCdd09j(BigDecimal cdd09j) {
		this.cdd09j = cdd09j;
	}

	public BigDecimal getCdd10j() {
		return this.cdd10j;
	}

	public void setCdd10j(BigDecimal cdd10j) {
		this.cdd10j = cdd10j;
	}

	public BigDecimal getCdd11j() {
		return this.cdd11j;
	}

	public void setCdd11j(BigDecimal cdd11j) {
		this.cdd11j = cdd11j;
	}

	public BigDecimal getCdd12j() {
		return this.cdd12j;
	}

	public void setCdd12j(BigDecimal cdd12j) {
		this.cdd12j = cdd12j;
	}

	public BigDecimal getCdd13j() {
		return this.cdd13j;
	}

	public void setCdd13j(BigDecimal cdd13j) {
		this.cdd13j = cdd13j;
	}

	public BigDecimal getCdd14j() {
		return this.cdd14j;
	}

	public void setCdd14j(BigDecimal cdd14j) {
		this.cdd14j = cdd14j;
	}

	public Double getCdfy() {
		return this.cdfy;
	}

	public void setCdfy(Double cdfy) {
		this.cdfy = cdfy;
	}

	public String getCdjobn() {
		return this.cdjobn;
	}

	public void setCdjobn(String cdjobn) {
		this.cdjobn = cdjobn;
	}

	public String getCdpid() {
		return this.cdpid;
	}

	public void setCdpid(String cdpid) {
		this.cdpid = cdpid;
	}

	public String getCdpnt() {
		return this.cdpnt;
	}

	public void setCdpnt(String cdpnt) {
		this.cdpnt = cdpnt;
	}

	public BigDecimal getCdupmj() {
		return this.cdupmj;
	}

	public void setCdupmj(BigDecimal cdupmj) {
		this.cdupmj = cdupmj;
	}

	public Double getCdupmt() {
		return this.cdupmt;
	}

	public void setCdupmt(Double cdupmt) {
		this.cdupmt = cdupmt;
	}

	public String getCduser() {
		return this.cduser;
	}

	public void setCduser(String cduser) {
		this.cduser = cduser;
	}

}