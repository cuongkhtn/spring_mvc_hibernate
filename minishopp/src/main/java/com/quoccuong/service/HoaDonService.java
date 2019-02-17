package com.quoccuong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.HoaDonDao;
import com.quoccuong.daoimp.HoaDonImp;
import com.quoccuong.entity.GioHang;
import com.quoccuong.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {
	@Autowired
	HoaDonDao hoadondao;
	public int them(HoaDon hd) {
		// TODO Auto-generated method stub
		return hoadondao.them(hd);
	}
	
}
