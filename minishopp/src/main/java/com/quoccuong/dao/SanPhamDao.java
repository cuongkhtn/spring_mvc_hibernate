package com.quoccuong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quoccuong.daoimp.SanPhamImp;
import com.quoccuong.entity.SanPham;

@Repository//để spring biết đây là class dao
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<SanPham> lay_DS_SanPhamHot() {
		Session session=sessionFactory.getCurrentSession();
		String sql="from sanpham";	
		@SuppressWarnings("unchecked")
		List<SanPham> listSP=(List<SanPham>) session.createQuery(sql).setFirstResult(0).setMaxResults(12).getResultList();
		return listSP;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<SanPham> lay_DS_SanPhamAdmin(int vtbd) {
		Session session=sessionFactory.getCurrentSession();
		String sql="from sanpham";	
		List<SanPham> listSP;
		if(vtbd >=0)
		{
	
			listSP=(List<SanPham>) session.createQuery(sql).setFirstResult(vtbd).setMaxResults(5).getResultList();
		}
		else
		{	
			listSP=(List<SanPham>) session.createQuery(sql).getResultList();
		}
		return listSP;
	}
	@Transactional
	public SanPham chiTietSanPham(int id) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		String sql="from sanpham where idSanPham="+id+"";
		SanPham sp= (SanPham)session.createQuery(sql).getSingleResult();
		return sp;
	}
	@Transactional
	public List<SanPham> loadTheoDM(int id) {
		Session session=sessionFactory.getCurrentSession();
		String sql="from sanpham where idDanhMucSanPham="+id;	
		@SuppressWarnings("unchecked")
		List<SanPham> listSP=(List<SanPham>) session.createQuery(sql).setFirstResult(0).setMaxResults(12).getResultList();
		return listSP;
	}
	@Transactional
	public void xoaSP(int idSanPham)
	{
		System.out.println("xóa");
		Session session=sessionFactory.getCurrentSession();
		SanPham sp=new SanPham();
		sp.setIdSanPham(idSanPham);
		session.delete(sp);		
	}
	@Transactional
	public int themSanPham(SanPham sanpham) {
		Session session =sessionFactory.getCurrentSession();
		int i=(Integer) session.save(sanpham);
		if(i>0)
		{
			return 1;
		}
		else
			return -1;
	}
	@Transactional
	public boolean updateSP(SanPham sanpham) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.update(sanpham);
		return false;
	}
} 	
