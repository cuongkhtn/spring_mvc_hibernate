package com.quoccuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.DanhMucDao;
import com.quoccuong.daoimp.DanhMucImp;
import com.quoccuong.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp {
	@Autowired
	DanhMucDao danhmucdao;
	public List<DanhMucSanPham> layDMSP() {
		// TODO Auto-generated method stub
		return danhmucdao.layDMSP();
	}
}
