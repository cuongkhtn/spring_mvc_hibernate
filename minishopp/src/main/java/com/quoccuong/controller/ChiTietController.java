package com.quoccuong.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quoccuong.entity.DanhMucSanPham;
import com.quoccuong.entity.GioHang;
import com.quoccuong.entity.SanPham;
import com.quoccuong.service.DanhMucService;
import com.quoccuong.service.SanPhamService;

@Controller
@RequestMapping("/chitiet")
@SessionAttributes({"giohang"})
public class ChiTietController {
	@Autowired
	DanhMucService danhmucservice;
	@Autowired 
	SanPhamService sanphamservice;
	List<GioHang> gh=new ArrayList<GioHang>();
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham,ModelMap modelmap)
	{
		SanPham sp=sanphamservice.chiTietSanPham(masanpham);
		List<DanhMucSanPham> dmsp=danhmucservice.layDMSP();
		modelmap.addAttribute("sp",sp);
		modelmap.addAttribute("dmsp",dmsp);
		return "chitiet";
	}
	@GetMapping("/giohang")
	@ResponseBody
	public String GioHang(@RequestParam int giatien,@RequestParam int machitiet,@RequestParam int mamau,@RequestParam int masize,@RequestParam int masp,@RequestParam String tenmau,@RequestParam String tensize,@RequestParam String tensp,HttpSession httpsession)
	{
		if(null == httpsession.getAttribute("giohang"))
			{
				List<GioHang> gh=new ArrayList<GioHang>();
				GioHang giohang=new GioHang();
				giohang.setGiatien(giatien);
				giohang.setMamau(mamau);
				giohang.setMasize(masize);
				giohang.setMasp(masp);
				giohang.setSoluong(1);
				giohang.setTenmau(tenmau);
				giohang.setTensize(tensize);
				giohang.setTensp(tensp);
				giohang.setMachitiet(machitiet);
				gh.add(giohang);
				httpsession.setAttribute("giohang", gh); 	
				
			}else
			{
				List<GioHang> gh=(List<GioHang>) httpsession.getAttribute("giohang");
				int vitri=kiemTraTonTai(gh,httpsession,masp,masize,mamau);
				if(vitri==-1)
				{
					GioHang giohang=new GioHang();
					giohang.setGiatien(giatien);
					giohang.setMamau(mamau);
					giohang.setMasize(masize);
					giohang.setMasp(masp);
					giohang.setSoluong(1);
					giohang.setTenmau(tenmau);
					giohang.setTensize(tensize);
					giohang.setTensp(tensp);
					giohang.setMachitiet(machitiet);
					gh.add(giohang);
				}
				else
				{
					int soluongmoi=gh.get(vitri).getSoluong()+1;
					gh.get(vitri).setSoluong(soluongmoi);
				}
			}
			@SuppressWarnings("unchecked")
			List<GioHang> gh=(List<GioHang>) httpsession.getAttribute("giohang");
			/*for(GioHang giohang :gh)
			{
				System.out.println(giohang.getSoluong());
			}*/
			return ""+gh.size();
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
