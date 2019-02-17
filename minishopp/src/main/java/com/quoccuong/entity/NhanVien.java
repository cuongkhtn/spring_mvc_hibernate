package com.quoccuong.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idNhanVien;
	private String hoTen;
	private String diaChi;
	private String gioiTinh;
	private String cmnd;
	private int soDT;
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public ChucVu getChucvu() {
		return chucvu;
	}
	public void setChucvu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}
	private String email;
	private String tenDangNhap;
	private String matKhau;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idChucVu")
	ChucVu chucvu=new ChucVu();
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public int getSoDT() {
		return soDT;
	}
	public void setSoDT(int soDT) {
		this.soDT = soDT;
	}
	public String getEmail() {
		return email;
	}
	public NhanVien() {
		super();
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
