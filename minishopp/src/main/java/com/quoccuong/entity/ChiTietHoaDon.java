package com.quoccuong.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name="chitiethoadon")
public class ChiTietHoaDon 
{
	@EmbeddedId
	ChiTietHoaDonID chitiethoadonid;
	public ChiTietHoaDonID getChitiethoadonid() {
		return chitiethoadonid;
	}
	public void setChitiethoadonid(ChiTietHoaDonID chitiethoadonid) {
		this.chitiethoadonid = chitiethoadonid;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	private int soLuong;
	private int giaTien;
}
