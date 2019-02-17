package com.quoccuong.entity;

import java.util.Set;

public class JsonSP {
	private int idSanPham;
	DanhMucSanPham danhMucSanPham;
	Set<KhuyenMai> danhSachKhuyenMai;
	Set<ChiTietSanPham> chitietsanpham;
	private String tenSanPham;
	private int giaTien;
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
	public Set<KhuyenMai> getDanhSachKhuyenMai() {
		return danhSachKhuyenMai;
	}
	public void setDanhSachKhuyenMai(Set<KhuyenMai> danhSachKhuyenMai) {
		this.danhSachKhuyenMai = danhSachKhuyenMai;
	}
	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}
	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhSanPham() {
		return hinhSanPham;
	}
	public void setHinhSanPham(String hinhSanPham) {
		this.hinhSanPham = hinhSanPham;
	}
	private String moTa;
	private String hinhSanPham;
}
