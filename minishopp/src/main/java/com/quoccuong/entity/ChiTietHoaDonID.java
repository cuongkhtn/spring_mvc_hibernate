package com.quoccuong.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ChiTietHoaDonID implements Serializable {
	private int idHoaDon;
	private int idChiTietSanPham;
	public int getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public int getIdChiTietSanPham() {
		return idChiTietSanPham;
	}
	public void setIdChiTietSanPham(int idChiTietSanPham) {
		this.idChiTietSanPham = idChiTietSanPham;
	}
}