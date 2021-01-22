package com.entity;

import com.util.VeDate;

public class Vegs {
	private String vegsid = "D" + VeDate.getStringId();
	private String vegsname;
	private String cateid;
	private String price;
	private String snum;
	private String product;
	private String memo;
	private String addtime;
	private String catename;
	private String vno;

	public String getVno() {
		return vno;
	}

	public void setVno(String vno) {
		this.vno = vno;
	}

	public String getVegsid() {
		return vegsid;
	}

	public void setVegsid(String vegsid) {
		this.vegsid = vegsid;
	}

	public String getVegsname() {
		return this.vegsname;
	}

	public void setVegsname(String vegsname) {
		this.vegsname = vegsname;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSnum() {
		return this.snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}
}
