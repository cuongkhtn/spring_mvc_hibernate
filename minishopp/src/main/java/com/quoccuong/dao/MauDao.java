package com.quoccuong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.MauImp;
import com.quoccuong.entity.MauSanPham;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class MauDao implements MauImp {
	@Autowired
	SessionFactory sessionfactory;
	@Transactional
	public List<MauSanPham> layMauSP() {		
			Session session=sessionfactory.getCurrentSession();
			String str="From mausanpham";
			List<MauSanPham> listMau= session.createQuery(str).getResultList();
			return listMau;
	}
}
