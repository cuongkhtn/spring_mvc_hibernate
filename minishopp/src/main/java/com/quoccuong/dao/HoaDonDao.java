package com.quoccuong.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.HoaDonImp;
import com.quoccuong.entity.HoaDon;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp{

	@Autowired 
	SessionFactory sessionFactory;
	@Transactional
	public int them(HoaDon hd) {
		// TODO Auto-generated method stub		
		Session session=sessionFactory.getCurrentSession();
		int id=(Integer) session.save(hd);
		if(id>0)
		{
			return id;
		}
		else
			return -1;
		
	}
	
}
