package com.quoccuong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quoccuong.entity.DanhMucSanPham;
import com.quoccuong.entity.SanPham;
import com.quoccuong.service.DanhMucService;
import com.quoccuong.service.NhanVienService;
import com.quoccuong.service.SanPhamService;



@Controller
@RequestMapping("/")
@SessionAttributes("tk")
public class TrangChuController {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired 
	NhanVienService nhanvienservice;
	@Autowired 
	SanPhamService sanphamservice;
	@Autowired
	DanhMucService danhmucservice;
	@GetMapping
	@Transactional
	/*public String Default(@SessionAttribute("tk") String user,ModelMap modelMap,HttpSession httpSession)
	  {	
	 	if(httpSession.getAttribute("user")!=null
	 	{
	 	
	 	}
	  }
	  */
	//public String Default(@SessionAttribute("tk") String user,ModelMap modelMap,HttpSession httpSession) 
	public String Default(ModelMap modelmap) {
		/*Session session=sessionFactory.getCurrentSession();
		String sql="from nhanvien";
		@SuppressWarnings("unchecked")
		List<NhanVien> list=session.createQuery(sql).getResultList();
		for (NhanVien nv : list) {
			System.out.println(nv.getTenNhanVien());
		}*/
		List<DanhMucSanPham> dmsp=danhmucservice.layDMSP();
		modelmap.addAttribute("dmsp",dmsp);
		List<SanPham> list=sanphamservice.lay_DS_SanPhamHot();
		modelmap.addAttribute("listSP",list);
		return "Trangchu";
	}
	
	/*@PostMapping
	@Transactional
	public String AddEmployees(@RequestParam String name,@RequestParam int tuoi)
	{
		Session session=sessionFactory.getCurrentSession();
		NhanVien nhanvien=new NhanVien(name, tuoi);
		session.save(nhanvien);
		return "Trangchu";
		
		//------------------
		//---update---
		//nhanvien.setTuoi(30);
		//session.update(nhanvien);
	}*/
	/*	@PostMapping
		@Transactional
		public String UpdateEmployees()
		{
			Session session=sessionFactory.getCurrentSession();
			String sql="from nhanvien where tenNhanVien='cuong' and tuoi=18";
			NhanVien nhanvien=(NhanVien) session.createQuery(sql).getSingleResult();
			nhanvien.setTuoi(100);
			session.update(nhanvien);
			//seesion.delete(nhanvien); //xóa
			return "Trangchu";
		}*/
}
