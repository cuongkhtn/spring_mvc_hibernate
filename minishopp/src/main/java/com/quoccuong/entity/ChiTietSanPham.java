package com.quoccuong.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idChiTietSanPham;
	@OneToMany()
	@JoinColumn(name="idChiTietSanPham")
	Set<ChiTietHoaDon> danhSachHoaDon;
	@OneToOne()
	@JoinColumn(name="idSanPham")
	SanPham sanpham;
	@OneToOne()
	@JoinColumn(name="idSize")
	size size;
	@OneToOne()
	@JoinColumn(name="idMauSanPham")
	MauSanPham mauSanPham;
	public int getIdChiTietSanPham() {
		return idChiTietSanPham;
	}
	public void setIdChiTietSanPham(int idChiTietSanPham) {
		this.idChiTietSanPham = idChiTietSanPham;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public size getSize() {
		return size;
	}
	public void setSize(size size) {
		this.size = size;
	}
	public MauSanPham getMauSanPham() {
		return mauSanPham;
	}
	public Set<ChiTietHoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}
	public void setDanhSachHoaDon(Set<ChiTietHoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public void setMauSanPham(MauSanPham mauSanPham) {
		this.mauSanPham = mauSanPham;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	private int soLuong;
	private String ngayNhap;
}
