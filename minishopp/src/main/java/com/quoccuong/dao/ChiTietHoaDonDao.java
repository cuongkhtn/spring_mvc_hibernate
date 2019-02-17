package com.quoccuong.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.ChiTietHoaDonImp;
import com.quoccuong.entity.ChiTietHoaDon;
import com.quoccuong.entity.ChiTietHoaDonID;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public int themcthd(ChiTietHoaDon cthd) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		ChiTietHoaDonID id=(ChiTietHoaDonID) session.save(cthd);
		if(id!=null)
		{
			return 1;
		}
		else
			return -1;
		
	}
	
}
