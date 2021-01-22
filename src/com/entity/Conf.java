package com.entity;

import com.util.VeDate;

public class Conf {
	private String confid = "C" + VeDate.getStringId();
	private String cycles;
	private String themax;
	private String themin;
	private String parama;
	private String paramb;

	public String getConfid() {
		return confid;
	}

	public void setConfid(String confid) {
		this.confid = confid;
	}

	public String getCycles() {
		return this.cycles;
	}

	public void setCycles(String cycles) {
		this.cycles = cycles;
	}

	public String getThemax() {
		return this.themax;
	}

	public void setThemax(String themax) {
		this.themax = themax;
	}

	public String getThemin() {
		return this.themin;
	}

	public void setThemin(String themin) {
		this.themin = themin;
	}

	public String getParama() {
		return this.parama;
	}

	public void setParama(String parama) {
		this.parama = parama;
	}

	public String getParamb() {
		return this.paramb;
	}

	public void setParamb(String paramb) {
		this.paramb = paramb;
	}
}
