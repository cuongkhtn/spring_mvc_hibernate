package com.quoccuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.MauDao;
import com.quoccuong.daoimp.MauImp;
import com.quoccuong.entity.MauSanPham;

@Service
public class MauService implements MauImp {
	@Autowired
	MauDao maudao;
	public List<MauSanPham> layMauSP() {
		
		return maudao.layMauSP();
	}

}
