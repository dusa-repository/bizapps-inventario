package modelo.maestros;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F0111PK;


/**
 * The persistent class for the F0111 database table.
 * 
 */
@Entity
public class F0111 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F0111PK id;

	@Column(name="WWACTIN")
	private String wwactin;

	@Column(name="WWALP1")
	private String wwalp1;

	@Column(name="WWALPH")
	private String wwalph;

	@Column(name="WWATTL")
	private String wwattl;

	@Column(name="WWCAAD")
	private Double wwcaad;

	@Column(name="WWCFRGUID")
	private String wwcfrguid;

	@Column(name="WWDC")
	private String wwdc;

	@Column(name="WWDDATE")
	private Double wwddate;

	@Column(name="WWDMON")
	private Double wwdmon;

	@Column(name="WWDSS5")
	private Double wwdss5;

	@Column(name="WWDYR")
	private Double wwdyr;

	@Column(name="WWFUCO")
	private String wwfuco;

	@Column(name="WWGEND")
	private String wwgend;

	@Column(name="WWGNNM")
	private String wwgnnm;

	@Column(name="WWJOBN")
	private String wwjobn;

	@Column(name="WWMDNM")
	private String wwmdnm;

	@Column(name="WWMLN1")
	private String wwmln1;

	@Column(name="WWMLNM")
	private String wwmlnm;

	@Column(name="WWNICK")
	private String wwnick;

	@Column(name="WWNTYP")
	private String wwntyp;

	@Column(name="WWPCF")
	private String wwpcf;

	@Column(name="WWPCM")
	private String wwpcm;

	@Column(name="WWPID")
	private String wwpid;

	@Column(name="WWREM1")
	private String wwrem1;

	@Column(name="WWSLNM")
	private String wwslnm;

	@Column(name="WWSRNM")
	private String wwsrnm;

	@Column(name="WWSYNCS")
	private Double wwsyncs;

	@Column(name="WWTYC")
	private String wwtyc;

	@Column(name="WWUPMJ")
	private BigDecimal wwupmj;

	@Column(name="WWUPMT")
	private Double wwupmt;

	@Column(name="WWUSER")
	private String wwuser;

	@Column(name="WWW001")
	private String www001;

	@Column(name="WWW002")
	private String www002;

	@Column(name="WWW003")
	private String www003;

	@Column(name="WWW004")
	private String www004;

	@Column(name="WWW005")
	private String www005;

	@Column(name="WWW006")
	private String www006;

	@Column(name="WWW007")
	private String www007;

	@Column(name="WWW008")
	private String www008;

	@Column(name="WWW009")
	private String www009;

	@Column(name="WWW010")
	private String www010;

	@Column(name="WWWN001")
	private String wwwn001;

	@Column(name="WWWN002")
	private String wwwn002;

	@Column(name="WWWN003")
	private String wwwn003;

	@Column(name="WWWN004")
	private String wwwn004;

	@Column(name="WWWN005")
	private String wwwn005;

	@Column(name="WWWN006")
	private String wwwn006;

	@Column(name="WWWN007")
	private String wwwn007;

	@Column(name="WWWN008")
	private String wwwn008;

	@Column(name="WWWN009")
	private String wwwn009;

	@Column(name="WWWN010")
	private String wwwn010;

	public F0111() {
	}

	public F0111PK getId() {
		return this.id;
	}

	public void setId(F0111PK id) {
		this.id = id;
	}

	public String getWwactin() {
		return this.wwactin;
	}

	public void setWwactin(String wwactin) {
		this.wwactin = wwactin;
	}

	public String getWwalp1() {
		return this.wwalp1;
	}

	public void setWwalp1(String wwalp1) {
		this.wwalp1 = wwalp1;
	}

	public String getWwalph() {
		return this.wwalph;
	}

	public void setWwalph(String wwalph) {
		this.wwalph = wwalph;
	}

	public String getWwattl() {
		return this.wwattl;
	}

	public void setWwattl(String wwattl) {
		this.wwattl = wwattl;
	}

	public Double getWwcaad() {
		return this.wwcaad;
	}

	public void setWwcaad(Double wwcaad) {
		this.wwcaad = wwcaad;
	}

	public String getWwcfrguid() {
		return this.wwcfrguid;
	}

	public void setWwcfrguid(String wwcfrguid) {
		this.wwcfrguid = wwcfrguid;
	}

	public String getWwdc() {
		return this.wwdc;
	}

	public void setWwdc(String wwdc) {
		this.wwdc = wwdc;
	}

	public Double getWwddate() {
		return this.wwddate;
	}

	public void setWwddate(Double wwddate) {
		this.wwddate = wwddate;
	}

	public Double getWwdmon() {
		return this.wwdmon;
	}

	public void setWwdmon(Double wwdmon) {
		this.wwdmon = wwdmon;
	}

	public Double getWwdss5() {
		return this.wwdss5;
	}

	public void setWwdss5(Double wwdss5) {
		this.wwdss5 = wwdss5;
	}

	public Double getWwdyr() {
		return this.wwdyr;
	}

	public void setWwdyr(Double wwdyr) {
		this.wwdyr = wwdyr;
	}

	public String getWwfuco() {
		return this.wwfuco;
	}

	public void setWwfuco(String wwfuco) {
		this.wwfuco = wwfuco;
	}

	public String getWwgend() {
		return this.wwgend;
	}

	public void setWwgend(String wwgend) {
		this.wwgend = wwgend;
	}

	public String getWwgnnm() {
		return this.wwgnnm;
	}

	public void setWwgnnm(String wwgnnm) {
		this.wwgnnm = wwgnnm;
	}

	public String getWwjobn() {
		return this.wwjobn;
	}

	public void setWwjobn(String wwjobn) {
		this.wwjobn = wwjobn;
	}

	public String getWwmdnm() {
		return this.wwmdnm;
	}

	public void setWwmdnm(String wwmdnm) {
		this.wwmdnm = wwmdnm;
	}

	public String getWwmln1() {
		return this.wwmln1;
	}

	public void setWwmln1(String wwmln1) {
		this.wwmln1 = wwmln1;
	}

	public String getWwmlnm() {
		return this.wwmlnm;
	}

	public void setWwmlnm(String wwmlnm) {
		this.wwmlnm = wwmlnm;
	}

	public String getWwnick() {
		return this.wwnick;
	}

	public void setWwnick(String wwnick) {
		this.wwnick = wwnick;
	}

	public String getWwntyp() {
		return this.wwntyp;
	}

	public void setWwntyp(String wwntyp) {
		this.wwntyp = wwntyp;
	}

	public String getWwpcf() {
		return this.wwpcf;
	}

	public void setWwpcf(String wwpcf) {
		this.wwpcf = wwpcf;
	}

	public String getWwpcm() {
		return this.wwpcm;
	}

	public void setWwpcm(String wwpcm) {
		this.wwpcm = wwpcm;
	}

	public String getWwpid() {
		return this.wwpid;
	}

	public void setWwpid(String wwpid) {
		this.wwpid = wwpid;
	}

	public String getWwrem1() {
		return this.wwrem1;
	}

	public void setWwrem1(String wwrem1) {
		this.wwrem1 = wwrem1;
	}

	public String getWwslnm() {
		return this.wwslnm;
	}

	public void setWwslnm(String wwslnm) {
		this.wwslnm = wwslnm;
	}

	public String getWwsrnm() {
		return this.wwsrnm;
	}

	public void setWwsrnm(String wwsrnm) {
		this.wwsrnm = wwsrnm;
	}

	public Double getWwsyncs() {
		return this.wwsyncs;
	}

	public void setWwsyncs(Double wwsyncs) {
		this.wwsyncs = wwsyncs;
	}

	public String getWwtyc() {
		return this.wwtyc;
	}

	public void setWwtyc(String wwtyc) {
		this.wwtyc = wwtyc;
	}

	public BigDecimal getWwupmj() {
		return this.wwupmj;
	}

	public void setWwupmj(BigDecimal wwupmj) {
		this.wwupmj = wwupmj;
	}

	public Double getWwupmt() {
		return this.wwupmt;
	}

	public void setWwupmt(Double wwupmt) {
		this.wwupmt = wwupmt;
	}

	public String getWwuser() {
		return this.wwuser;
	}

	public void setWwuser(String wwuser) {
		this.wwuser = wwuser;
	}

	public String getWww001() {
		return this.www001;
	}

	public void setWww001(String www001) {
		this.www001 = www001;
	}

	public String getWww002() {
		return this.www002;
	}

	public void setWww002(String www002) {
		this.www002 = www002;
	}

	public String getWww003() {
		return this.www003;
	}

	public void setWww003(String www003) {
		this.www003 = www003;
	}

	public String getWww004() {
		return this.www004;
	}

	public void setWww004(String www004) {
		this.www004 = www004;
	}

	public String getWww005() {
		return this.www005;
	}

	public void setWww005(String www005) {
		this.www005 = www005;
	}

	public String getWww006() {
		return this.www006;
	}

	public void setWww006(String www006) {
		this.www006 = www006;
	}

	public String getWww007() {
		return this.www007;
	}

	public void setWww007(String www007) {
		this.www007 = www007;
	}

	public String getWww008() {
		return this.www008;
	}

	public void setWww008(String www008) {
		this.www008 = www008;
	}

	public String getWww009() {
		return this.www009;
	}

	public void setWww009(String www009) {
		this.www009 = www009;
	}

	public String getWww010() {
		return this.www010;
	}

	public void setWww010(String www010) {
		this.www010 = www010;
	}

	public String getWwwn001() {
		return this.wwwn001;
	}

	public void setWwwn001(String wwwn001) {
		this.wwwn001 = wwwn001;
	}

	public String getWwwn002() {
		return this.wwwn002;
	}

	public void setWwwn002(String wwwn002) {
		this.wwwn002 = wwwn002;
	}

	public String getWwwn003() {
		return this.wwwn003;
	}

	public void setWwwn003(String wwwn003) {
		this.wwwn003 = wwwn003;
	}

	public String getWwwn004() {
		return this.wwwn004;
	}

	public void setWwwn004(String wwwn004) {
		this.wwwn004 = wwwn004;
	}

	public String getWwwn005() {
		return this.wwwn005;
	}

	public void setWwwn005(String wwwn005) {
		this.wwwn005 = wwwn005;
	}

	public String getWwwn006() {
		return this.wwwn006;
	}

	public void setWwwn006(String wwwn006) {
		this.wwwn006 = wwwn006;
	}

	public String getWwwn007() {
		return this.wwwn007;
	}

	public void setWwwn007(String wwwn007) {
		this.wwwn007 = wwwn007;
	}

	public String getWwwn008() {
		return this.wwwn008;
	}

	public void setWwwn008(String wwwn008) {
		this.wwwn008 = wwwn008;
	}

	public String getWwwn009() {
		return this.wwwn009;
	}

	public void setWwwn009(String wwwn009) {
		this.wwwn009 = wwwn009;
	}

	public String getWwwn010() {
		return this.wwwn010;
	}

	public void setWwwn010(String wwwn010) {
		this.wwwn010 = wwwn010;
	}

}