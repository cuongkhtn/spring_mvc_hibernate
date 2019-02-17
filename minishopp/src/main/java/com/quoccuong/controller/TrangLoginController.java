package com.quoccuong.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.quoccuong.entity.NhanVien;
import com.quoccuong.service.NhanVienService;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes("tk")
public class TrangLoginController {
	@RequestMapping
	public String Trangchu()
	{
		return"Tranglogin";
	}
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	NhanVienService nhanvienservice;
	@PostMapping
	@ResponseBody//tra ve string
	public String login(@RequestParam String tenDangNhap,@RequestParam String matKhau,ModelMap modelmap)
	{
		boolean kt=nhanvienservice.KiemTraDangNhap(tenDangNhap, matKhau);
		if(kt==true)
		{
			//return "redirect:/";
			modelmap.addAttribute("tk",tenDangNhap);
			return ""+kt;
		}
		else
		{
			//modelmap.addAttribute("kiemtradangnhap","Đăng nhập thất bại!");
			//return false;
			return ""+kt+"a";
		}		
	}
	
	@PostMapping("/signup")
	@ResponseBody
	public String singup(@RequestParam String tenDangNhap,@RequestParam String matKhau,@RequestParam String matKhausunl,ModelMap modelmap)
	{
		if(checkEmail(tenDangNhap)==true)
		{
			NhanVien nhanVien=new NhanVien();
			nhanVien.setEmail(tenDangNhap);
			nhanVien.setTenDangNhap(tenDangNhap);
			nhanVien.setMatKhau(matKhau);		
			boolean ktt=nhanvienservice.themNhanVien(nhanVien);
			if(ktt==true)
			{
				//return "redirect:/";
				modelmap.addAttribute("ktdangky","Thêm Thành Công");
				return ""+ktt;
			}
			else
			{
				modelmap.addAttribute("ktdangky","Thêm thất bại!");
				//return false;
				return ""+ktt+"a";
			}	
		}
		else
		{
			modelmap.addAttribute("ktemail","Vui lòng nhập email đúng định dạng hợp lệ");
			return "a";
		}
	}
	private static boolean checkEmail(String email) {
	        String emailPattern = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	        Pattern regex = Pattern.compile(emailPattern);
	        Matcher matcher = regex.matcher(email);
	        if (matcher.find()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
}
