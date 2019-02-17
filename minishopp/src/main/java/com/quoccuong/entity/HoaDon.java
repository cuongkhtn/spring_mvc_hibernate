package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idHoaDon;
	private String tenKhachHang;
	private String soDT;
	private String diaChiGiaoHang;
	private Boolean tinhTrang;
	private String ngayMua;
	private String hinhThucGiaoHang;
	private String ghiChu;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idHoaDon")
	Set<ChiTietHoaDon> danhSachHoaDon;
	public Set<ChiTietHoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}
	public String getHinhThucGiaoHang() {
		return hinhThucGiaoHang;
	}
	public void setHinhThucGiaoHang(String hinhThucGiaoHang) {
		this.hinhThucGiaoHang = hinhThucGiaoHang;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public void setDanhSachHoaDon(Set<ChiTietHoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}
	public int getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}
	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}
	public Boolean getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}
}
