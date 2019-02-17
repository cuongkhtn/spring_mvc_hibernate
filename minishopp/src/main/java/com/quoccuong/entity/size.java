package com.quoccuong.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="size")
public class size {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int idSize;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idSize")
	Set<ChiTietSanPham> chiTietSanPham;
	private String size;
	public int getIdSize() {
		return idSize;
	}
	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public Set<ChiTietSanPham> getChiTietSanPham() {
		return chiTietSanPham;
	}
	public void setChiTietSanPham(Set<ChiTietSanPham> chiTietSanPham) {
		this.chiTietSanPham = chiTietSanPham;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
