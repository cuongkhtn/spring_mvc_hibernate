package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity(name="sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idSanPham;
	@OneToOne()
	@JoinColumn(name="idDanhMucSanPham")
	DanhMucSanPham danhMucSanPham;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="chitietkhuyenmai",
	joinColumns= {@JoinColumn(name="idSanPham",referencedColumnName="idSanPham")},
	inverseJoinColumns= {@JoinColumn(name="idKhuyenMai",referencedColumnName="idKhuyenMai")})
	Set<KhuyenMai> danhSachKhuyenMai;
	public Set<KhuyenMai> getDanhSachKhuyenMai() {
		return danhSachKhuyenMai;
	}
	public void setDanhSachKhuyenMai(Set<KhuyenMai> danhSachKhuyenMai) {
		this.danhSachKhuyenMai = danhSachKhuyenMai;
	}
	public DanhMucSanPham getDanhMucSanPham() {
		return danhMucSanPham;
	}
	public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
		this.danhMucSanPham = danhMucSanPham;
	}
	//private int idDanhMucSanPham;
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="idSanPham")
	Set<ChiTietSanPham> chitietsanpham;
	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}
	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}
	private String tenSanPham;
	private int giaTien;
	private String moTa;
	private String hinhSanPham;
	public int getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(int idSanPham) {
		this.idSanPham = idSanPham;
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
}
