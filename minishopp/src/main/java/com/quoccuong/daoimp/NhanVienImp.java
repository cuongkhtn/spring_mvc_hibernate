package com.quoccuong.daoimp;

import com.quoccuong.entity.NhanVien;

public interface NhanVienImp {
	boolean KiemTraDangNhap(String email,String pass);
	boolean themNhanVien(NhanVien nhanVien);
}
