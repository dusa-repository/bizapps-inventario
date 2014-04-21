package modelo.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import modelo.pk.F40203PK;


/**
 * The persistent class for the F40203 database table.
 * 
 */
@Entity
public class F40203 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private F40203PK id;

	@Column(name="FSA1TR")
	private String fsa1tr;

	@Column(name="FSA2TR")
	private String fsa2tr;

	@Column(name="FSA3TR")
	private String fsa3tr;

	@Column(name="FSA4TR")
	private String fsa4tr;

	@Column(name="FSA5TR")
	private String fsa5tr;

	@Column(name="FSFID")
	private String fsfid;

	@Column(name="FSLND2")
	private String fslnd2;

	@Column(name="FSLNDS")
	private String fslnds;

	@Column(name="FSNXTR")
	private String fsnxtr;

	@Column(name="FSORNN")
	private double fsornn;

	@Column(name="FSSTDS")
	private String fsstds;

	@Column(name="FSWRTH")
	private String fswrth;

	public F40203() {
	}

	public F40203PK getId() {
		return this.id;
	}

	public void setId(F40203PK id) {
		this.id = id;
	}

	public String getFsa1tr() {
		return this.fsa1tr;
	}

	public void setFsa1tr(String fsa1tr) {
		this.fsa1tr = fsa1tr;
	}

	public String getFsa2tr() {
		return this.fsa2tr;
	}

	public void setFsa2tr(String fsa2tr) {
		this.fsa2tr = fsa2tr;
	}

	public String getFsa3tr() {
		return this.fsa3tr;
	}

	public void setFsa3tr(String fsa3tr) {
		this.fsa3tr = fsa3tr;
	}

	public String getFsa4tr() {
		return this.fsa4tr;
	}

	public void setFsa4tr(String fsa4tr) {
		this.fsa4tr = fsa4tr;
	}

	public String getFsa5tr() {
		return this.fsa5tr;
	}

	public void setFsa5tr(String fsa5tr) {
		this.fsa5tr = fsa5tr;
	}

	public String getFsfid() {
		return this.fsfid;
	}

	public void setFsfid(String fsfid) {
		this.fsfid = fsfid;
	}

	public String getFslnd2() {
		return this.fslnd2;
	}

	public void setFslnd2(String fslnd2) {
		this.fslnd2 = fslnd2;
	}

	public String getFslnds() {
		return this.fslnds;
	}

	public void setFslnds(String fslnds) {
		this.fslnds = fslnds;
	}

	public String getFsnxtr() {
		return this.fsnxtr;
	}

	public void setFsnxtr(String fsnxtr) {
		this.fsnxtr = fsnxtr;
	}

	public double getFsornn() {
		return this.fsornn;
	}

	public void setFsornn(double fsornn) {
		this.fsornn = fsornn;
	}

	public String getFsstds() {
		return this.fsstds;
	}

	public void setFsstds(String fsstds) {
		this.fsstds = fsstds;
	}

	public String getFswrth() {
		return this.fswrth;
	}

	public void setFswrth(String fswrth) {
		this.fswrth = fswrth;
	}

}