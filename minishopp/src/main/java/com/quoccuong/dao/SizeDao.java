package com.quoccuong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.SizeImp;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SizeDao implements SizeImp{
	@Autowired
	SessionFactory sessionfactory;
	@Transactional
	public List<Size> laySizeSP() {
		Session session=sessionfactory.getCurrentSession();
		String str="From size";
		List<Size> listSize= session.createQuery(str).getResultList();
		return listSize;
	}
}
