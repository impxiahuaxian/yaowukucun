package com.entity;

import java.util.UUID;

public class Orders {
	private String ordersid = "O" + UUID.randomUUID();
	private String ordercode;
	private String adminid;
	private String vegsid;
	private String num;
	private String price;
	private String total;
	private String addtime;
	private String status;
	private String realname;
	private String vegsname;
	private String snum;

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
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

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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
