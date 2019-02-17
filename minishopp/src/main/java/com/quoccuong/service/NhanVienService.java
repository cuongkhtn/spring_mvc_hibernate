package com.quoccuong.service;
//bus
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.NhanVienDao;
import com.quoccuong.daoimp.NhanVienImp;
import com.quoccuong.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp {
	
	@Autowired
	NhanVienDao nhanviendao;
	public boolean KiemTraDangNhap(String email, String pass) {
		boolean kt=nhanviendao.KiemTraDangNhap(email, pass);
		return kt;
	}
	public boolean themNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		return nhanviendao.themNhanVien(nhanVien);
	}
} 