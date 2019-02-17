package com.quoccuong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.DanhMucImp;
import com.quoccuong.entity.DanhMucSanPham;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<DanhMucSanPham> layDMSP() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String sql="From danhmucsanpham";
		List<DanhMucSanPham> list=session.createQuery(sql).getResultList();
		return list;
	}

}
