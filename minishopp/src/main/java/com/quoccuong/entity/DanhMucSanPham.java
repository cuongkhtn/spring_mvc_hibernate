package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="danhmucsanpham")
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idDanhMucSanPham;
	private String tenDanhMuc;
	private String hinhDanhMuc;
	@OneToMany()
	@JoinColumn(name="idDanhMucSanPham")
	Set<SanPham> danhSachSanPham;
	public Set<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}
	public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}
	public int getIdDanhMucSanPham() {
		return idDanhMucSanPham;
	}
	public void setIdDanhMucSanPham(int idDanhMucSanPham) {
		this.idDanhMucSanPham = idDanhMucSanPham;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getHinhDanhMuc() {
		return hinhDanhMuc;
	}
	public void setHinhDanhMuc(String hinhDanhMuc) {
		this.hinhDanhMuc = hinhDanhMuc;
	}
}
