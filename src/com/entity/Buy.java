package com.entity;

import com.util.VeDate;

public class Buy {
	private String buyid = "B" + VeDate.getStringId();
	private String buyno;
	private String vegsid;
	private String num;
	private String price;
	private String adminid;
	private String addtime;
	private String memo;
	private String vegsname;
	private String realname;

	public String getBuyid() {
		return buyid;
	}

	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}

	public String getBuyno() {
		return this.buyno;
	}

	public void setBuyno(String buyno) {
		this.buyno = buyno;
	}

	public String getVegsid() {
		return this.vegsid;
	}

	public void setVegsid(String vegsid) {
		this.vegsid = vegsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getVegsname() {
		return this.vegsname;
	}

	public void setVegsname(String vegsname) {
		this.vegsname = vegsname;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}
