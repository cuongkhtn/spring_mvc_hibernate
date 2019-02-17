package com.quoccuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.SizeDao;
import com.quoccuong.daoimp.SizeImp;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Service
public class SizeService implements SizeImp {

	@Autowired
	SizeDao sizedao;
	public List<Size> laySizeSP() {
		// TODO Auto-generated method stub
		return sizedao.laySizeSP();
	}
}
