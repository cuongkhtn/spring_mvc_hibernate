package com.quoccuong.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.quoccuong.daoimp.NhanVienImp;
import com.quoccuong.entity.NhanVien;

@Repository//để spring biết đây là class dao
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienImp {
	@Autowired 
	SessionFactory sessionFactory;
	@Transactional
	public boolean themNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
	
		Session session=sessionFactory.getCurrentSession();
		int maNhanVien=(Integer) session.save(nhanVien);
		if(maNhanVien>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}	
	@Transactional
	public boolean KiemTraDangNhap(String email, String pass) {
		Session session=sessionFactory.getCurrentSession();
		String str="from nhanvien where matKhau='"+pass+"' and tenDangNhap='"+email+"'";
		try {
			NhanVien nhanvien=(NhanVien) session.createQuery(str).getSingleResult();
			if(nhanvien!=null)
			{
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
}
