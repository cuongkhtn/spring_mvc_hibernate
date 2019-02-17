package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="mausanpham")
public class MauSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idMauSanPham;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idMauSanPham")
	Set<ChiTietSanPham> chiTietSanPham;
	public Set<ChiTietSanPham> getChiTietSanPham() {
		return chiTietSanPham;
	}
	public void setChiTietSanPham(Set<ChiTietSanPham> chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	private String mauSP;
	public int getIdMauSanPham() {
		return idMauSanPham;
	}
	public void setIdMauSanPham(int idMauSanPham) {
		this.idMauSanPham = idMauSanPham;
	}
	public String getMauSP() {
		return mauSP;
	}
	public void setMauSP(String mauSP) {
		this.mauSP = mauSP;
	}
}
