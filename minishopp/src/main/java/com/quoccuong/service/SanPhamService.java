package com.quoccuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.SanPhamDao;
import com.quoccuong.daoimp.SanPhamImp;
import com.quoccuong.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp {
	@Autowired
	SanPhamDao sanphamdao;
	public List<SanPham> lay_DS_SanPhamHot() {
		// TODO Auto-generated method stub
		return sanphamdao.lay_DS_SanPhamHot();
	}
	public SanPham chiTietSanPham(int id) {
		// TODO Auto-generated method stub
		return sanphamdao.chiTietSanPham(id);
	}
	public List<SanPham> loadTheoDM(int id) {
		// TODO Auto-generated method stub
		return sanphamdao.loadTheoDM(id);
	}
	public List<SanPham> lay_DS_SanPhamAdmin(int vtbd) {
		// TODO Auto-generated method stub
		return sanphamdao.lay_DS_SanPhamAdmin(vtbd);
	}
	public void xoaSP(int idSanPham)
	{
		sanphamdao.xoaSP(idSanPham);
	}
	public int themSanPham(SanPham sanpham) {
		// TODO Auto-generated method stub
		return sanphamdao.themSanPham(sanpham);
	}
	public boolean updateSP(SanPham sanpham) {
		// TODO Auto-generated method stub
		sanphamdao.updateSP(sanpham);
		return false;
	}
	
}
