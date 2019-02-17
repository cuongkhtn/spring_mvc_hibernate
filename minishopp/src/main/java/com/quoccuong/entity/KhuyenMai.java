package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="khuyenmai")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idKhuyenMai;
	private String tenKhuyenMai;
	private String thoiGianBatDau;
	private String thoiGianKetTHuc;
	private String moTa;
	private String hinhKhuyenMai;
	@ManyToMany
	@JoinTable(name="chitietkhuyenmai",
	joinColumns= {@JoinColumn(name="idKhuyenMai",referencedColumnName="idKhuyenMai")},
	inverseJoinColumns= {@JoinColumn(name="idSanPham",referencedColumnName="idSanPham")})
	Set<SanPham> danhSachSanPham;
	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}
	public int getIdKhuyenMai() {
		return idKhuyenMai;
	}
	public void setIdKhuyenMai(int idKhuyenMai) {
		this.idKhuyenMai = idKhuyenMai;
	}
	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}
	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}
	public String getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(String thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public String getThoiGianKetTHuc() {
		return thoiGianKetTHuc;
	}
	public void setThoiGianKetTHuc(String thoiGianKetTHuc) {
		this.thoiGianKetTHuc = thoiGianKetTHuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhKhuyenMai() {
		return hinhKhuyenMai;
	}
	public void setHinhKhuyenMai(String hinhKhuyenMai) {
		this.hinhKhuyenMai = hinhKhuyenMai;
	}
}
