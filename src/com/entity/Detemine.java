package com.entity;

import com.util.VeDate;

public class Detemine {
	private String detemineid = "D" + VeDate.getStringId();
	private String adminid;
	private String vegsid;
	private double num;
	private String addtime;
	private String realname;
	private String vegsname;
	private double snum;
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getSnum() {
		return snum;
	}

	public void setSnum(double snum) {
		this.snum = snum;
	}

	public String getDetemineid() {
		return detemineid;
	}

	public void setDetemineid(String detemineid) {
		this.detemineid = detemineid;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getVegsid() {
		return this.vegsid;
	}

	public void setVegsid(String vegsid) {
		this.vegsid = vegsid;
	}

	public double getNum() {
		return this.num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getVegsname() {
		return this.vegsname;
	}

	public void setVegsname(String vegsname) {
		this.vegsname = vegsname;
	}
}
