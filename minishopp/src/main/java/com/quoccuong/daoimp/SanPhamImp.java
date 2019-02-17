package com.quoccuong.daoimp;

import java.util.List;

import com.quoccuong.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> lay_DS_SanPhamHot();
	SanPham chiTietSanPham(int id);
	List<SanPham> loadTheoDM(int id);
	int themSanPham(SanPham sanpham);
	boolean updateSP(SanPham sanpham);
}
