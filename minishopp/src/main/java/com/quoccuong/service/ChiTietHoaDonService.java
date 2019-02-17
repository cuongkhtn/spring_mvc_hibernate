package com.quoccuong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.ChiTietHoaDonDao;
import com.quoccuong.daoimp.ChiTietHoaDonImp;
import com.quoccuong.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
@Autowired
ChiTietHoaDonDao chiTietHoaDonDao;
	public int themcthd(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		return chiTietHoaDonDao.themcthd(cthd);
	}
}
