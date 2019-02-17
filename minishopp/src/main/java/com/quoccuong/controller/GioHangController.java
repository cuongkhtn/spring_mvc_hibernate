package com.quoccuong.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quoccuong.entity.ChiTietHoaDon;
import com.quoccuong.entity.ChiTietHoaDonID;
import com.quoccuong.entity.GioHang;
import com.quoccuong.entity.HoaDon;
import com.quoccuong.service.ChiTietHoaDonService;
import com.quoccuong.service.HoaDonService;

@Controller
@RequestMapping("/giohang")
@SessionAttributes({"giohang"})
public class GioHangController {
	
	@GetMapping()
	public String giohang(HttpSession httpSession,ModelMap modelmap)
	{
		/*if(null!=httpSession.getAttribute("giohang"))
		{
			modelmap.addAttribute("gh",giohang);
		}*/
		return "giohang";
	}
	@GetMapping("/capnhat")
	public void capnhat(HttpSession httpsession,@RequestParam int soluong,@RequestParam int masize,@RequestParam int mamau,@RequestParam int masp)
	{
		if(null!=httpsession.getAttribute("giohang"))
		{
			List<GioHang> gh=(List<GioHang>) httpsession.getAttribute("giohang");
			int vt=kiemTraTonTai(gh,httpsession,masp,masize,mamau);
			System.out.println(vt);
			gh.get(vt).setSoluong(soluong);		
		}
		else
		{
			System.out.println("a");
		}
	}
	@GetMapping("/xoa")
	@ResponseBody
	public String xoa(HttpSession httpsession,@RequestParam int masize,@RequestParam int mamau,@RequestParam int masp)
	{
		if(null!=httpsession.getAttribute("giohang"))
		{
			List<GioHang> gh=(List<GioHang>) httpsession.getAttribute("giohang");
			int vt=kiemTraTonTai(gh,httpsession,masp,masize,mamau);
			gh.remove(vt);
		}
		return "a";
	}
	@Autowired
	HoaDonService hoadonservice;
	@Autowired
	ChiTietHoaDonService chitiethoadonservice;
	@PostMapping()
	public void dathang(HttpSession httpsession,@RequestParam String tenKhachHang,@RequestParam String soDT,@RequestParam String diaChiGiaoHang,@RequestParam String hinhThucGiaoHang,@RequestParam String ghiChu)
	{

		
		if(null!=httpsession.getAttribute("giohang"))
		{
			List<GioHang> gh=(List<GioHang>) httpsession.getAttribute("giohang");
			HoaDon hd=new HoaDon();
			hd.setTenKhachHang(tenKhachHang);
			hd.setSoDT(soDT);
			hd.setDiaChiGiaoHang(diaChiGiaoHang);
			hd.setHinhThucGiaoHang(hinhThucGiaoHang);
			hd.setGhiChu(ghiChu);
			int kt=hoadonservice.them(hd);
			if(kt>0)
			{
				System.out.println("ok");
				//Set<ChiTietHoaDon> list=new HashSet<ChiTietHoaDon>();
				for(GioHang giohang:gh)
				{
					ChiTietHoaDonID chiTietHoaDonID=new ChiTietHoaDonID();
					chiTietHoaDonID.setIdChiTietSanPham(giohang.getMachitiet());
					chiTietHoaDonID.setIdHoaDon(kt);
					ChiTietHoaDon chiTietHoaDon=new ChiTietHoaDon();
					chiTietHoaDon.setChitiethoadonid(chiTietHoaDonID);
					chiTietHoaDon.setGiaTien(giohang.getGiatien());
					chiTietHoaDon.setSoLuong(giohang.getSoluong());
					chitiethoadonservice.themcthd(chiTietHoaDon);
				}
			}
			else
				System.out.println("a");
		}
	}
	private int kiemTraTonTai(List<GioHang> gh,HttpSession httpsession,int masp,int masize,int mamau)
	{
		for(int i=0;i<gh.size();i++)
		{
			if(gh.get(i).getMasp()==masp && gh.get(i).getMasize()==masize && gh.get(i).getMamau()==mamau)
					{
						return i;
					}
		}
		return -1;
	}
}
