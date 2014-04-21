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
	private Object fsa1tr;

	@Column(name="FSA2TR")
	private Object fsa2tr;

	@Column(name="FSA3TR")
	private Object fsa3tr;

	@Column(name="FSA4TR")
	private Object fsa4tr;

	@Column(name="FSA5TR")
	private Object fsa5tr;

	@Column(name="FSFID")
	private Object fsfid;

	@Column(name="FSLND2")
	private Object fslnd2;

	@Column(name="FSLNDS")
	private Object fslnds;

	@Column(name="FSNXTR")
	private Object fsnxtr;

	@Column(name="FSORNN")
	private double fsornn;

	@Column(name="FSSTDS")
	private Object fsstds;

	@Column(name="FSWRTH")
	private Object fswrth;

	public F40203() {
	}

	public F40203PK getId() {
		return this.id;
	}

	public void setId(F40203PK id) {
		this.id = id;
	}

	public Object getFsa1tr() {
		return this.fsa1tr;
	}

	public void setFsa1tr(Object fsa1tr) {
		this.fsa1tr = fsa1tr;
	}

	public Object getFsa2tr() {
		return this.fsa2tr;
	}

	public void setFsa2tr(Object fsa2tr) {
		this.fsa2tr = fsa2tr;
	}

	public Object getFsa3tr() {
		return this.fsa3tr;
	}

	public void setFsa3tr(Object fsa3tr) {
		this.fsa3tr = fsa3tr;
	}

	public Object getFsa4tr() {
		return this.fsa4tr;
	}

	public void setFsa4tr(Object fsa4tr) {
		this.fsa4tr = fsa4tr;
	}

	public Object getFsa5tr() {
		return this.fsa5tr;
	}

	public void setFsa5tr(Object fsa5tr) {
		this.fsa5tr = fsa5tr;
	}

	public Object getFsfid() {
		return this.fsfid;
	}

	public void setFsfid(Object fsfid) {
		this.fsfid = fsfid;
	}

	public Object getFslnd2() {
		return this.fslnd2;
	}

	public void setFslnd2(Object fslnd2) {
		this.fslnd2 = fslnd2;
	}

	public Object getFslnds() {
		return this.fslnds;
	}

	public void setFslnds(Object fslnds) {
		this.fslnds = fslnds;
	}

	public Object getFsnxtr() {
		return this.fsnxtr;
	}

	public void setFsnxtr(Object fsnxtr) {
		this.fsnxtr = fsnxtr;
	}

	public double getFsornn() {
		return this.fsornn;
	}

	public void setFsornn(double fsornn) {
		this.fsornn = fsornn;
	}

	public Object getFsstds() {
		return this.fsstds;
	}

	public void setFsstds(Object fsstds) {
		this.fsstds = fsstds;
	}

	public Object getFswrth() {
		return this.fswrth;
	}

	public void setFswrth(Object fswrth) {
		this.fswrth = fswrth;
	}

}