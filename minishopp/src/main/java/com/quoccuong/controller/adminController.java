package com.quoccuong.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quoccuong.entity.ChiTietSanPham;
import com.quoccuong.entity.DanhMucSanPham;
import com.quoccuong.entity.JsonSP;
import com.quoccuong.entity.MauSanPham;
import com.quoccuong.entity.SanPham;
import com.quoccuong.entity.size;
import com.quoccuong.service.DanhMucService;
import com.quoccuong.service.MauService;
import com.quoccuong.service.SanPhamService;
import com.quoccuong.service.SizeService;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@Controller
@RequestMapping("/admin")
public class adminController {
	@Autowired 
	SanPhamService sanphamservice;
	@Autowired
	DanhMucService danhmucservice;
	@Autowired
	MauService mauservice;
	@Autowired
	SizeService sizeservice;
	@GetMapping()
	public String admin() {
		return "admin";
	}
	@GetMapping("/themsanpham")
	public String themsanpham(ModelMap modelmap) {
		modelmap.addAttribute("dssp",sanphamservice.lay_DS_SanPhamAdmin(0));
		double sl=Math.ceil(sanphamservice.lay_DS_SanPhamAdmin(-1).size()/5.0);
		modelmap.addAttribute("slsp",sl);
		modelmap.addAttribute("dmsp",danhmucservice.layDMSP());
		modelmap.addAttribute("listmau",mauservice.layMauSP());
		modelmap.addAttribute("listsize",sizeservice.laySizeSP());
		return "adminsanpham";
	}
	@GetMapping(path="/themsanphamajax", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String themsanpham(@RequestParam int idadtsp) {
		String html="";
		List<SanPham> listSP = sanphamservice.lay_DS_SanPhamAdmin(idadtsp);
		for(SanPham sanpham:listSP)
		{
			html+="<tr id='table-sanpham'>";
			html+="<td><label><input type='checkbox' data-idd="+sanpham.getIdSanPham()+"></label></td>";
			html+="<td ><p style='margin-left: 35px'>"+sanpham.getIdSanPham()+"</p></td>";
			html+="<td >"+sanpham.getTenSanPham()+"</td>";
			html+="<td >"+sanpham.getGiaTien()+"</td>";	
			html+="<td class='btn btn-primary updatesanpham' data-id="+sanpham.getIdSanPham()+">Update</td>";	
			html+="</tr>";
			
		}
		return html;
	}
	@PostMapping("/xoasanpham")
	public void xoasanpham(@RequestParam int idSanPham)
	{
		sanphamservice.xoaSP(idSanPham);
	}
	@Autowired
	ServletContext context;
	@PostMapping("/upload")
	public void upload(MultipartHttpServletRequest request)
	{
		String path_save_file=context.getRealPath("/resources/images/");
		Iterator<String> listNames=request.getFileNames();
		MultipartFile mpf=request.getFile(listNames.next());
		File file_save=new File(path_save_file+mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path_save_file);
	}
	@PostMapping(path="/laysptheoma", produces="application/json; charset=utf-8")
	@ResponseBody
	public JsonSP laysptheoma(@RequestParam int idSanPham)
	{
		JsonSP jsonsp=new JsonSP();
		SanPham sanpham=sanphamservice.chiTietSanPham(idSanPham);
		jsonsp.setTenSanPham(sanpham.getTenSanPham());
		jsonsp.setIdSanPham(sanpham.getIdSanPham());
		jsonsp.setGiaTien(sanpham.getGiaTien());
		jsonsp.setHinhSanPham(sanpham.getHinhSanPham());
		jsonsp.setMoTa(sanpham.getMoTa());
		DanhMucSanPham dmsp=new DanhMucSanPham();
		dmsp.setIdDanhMucSanPham(sanpham.getDanhMucSanPham().getIdDanhMucSanPham());
		dmsp.setTenDanhMuc(sanpham.getDanhMucSanPham().getTenDanhMuc());
		jsonsp.setDanhMucSanPham(dmsp);
		Set<ChiTietSanPham> listChiTietSP=new HashSet<ChiTietSanPham>();
		for(ChiTietSanPham chitietsanpham:sanpham.getChitietsanpham())
		{
			ChiTietSanPham chitietsanpham2=new ChiTietSanPham();
			chitietsanpham2.setIdChiTietSanPham(chitietsanpham.getIdChiTietSanPham());
			MauSanPham mausanpham=new MauSanPham();
			mausanpham.setMauSP(chitietsanpham.getMauSanPham().getMauSP());
			mausanpham.setIdMauSanPham(chitietsanpham.getMauSanPham().getIdMauSanPham());
			chitietsanpham2.setMauSanPham(mausanpham);
			size size=new size();
			size.setIdSize(chitietsanpham.getSize().getIdSize());
			size.setSize(chitietsanpham.getSize().getSize());
			chitietsanpham2.setSize(size);
			chitietsanpham2.setSoLuong(chitietsanpham.getSoLuong());
			listChiTietSP.add(chitietsanpham2);
		}
		jsonsp.setChitietsanpham(listChiTietSP);
		return jsonsp;
	}
	@PostMapping("themsanpham")
	public void themsp(@RequestParam String dataJson)
	{
			ObjectMapper objectMapper=new ObjectMapper();
			try {
				SanPham sanpham=objectMapper.readValue(dataJson, SanPham.class);
				/*System.out.println(sanpham.getHinhSanPham());*/
				if(sanphamservice.themSanPham(sanpham)!=-1)
				{
					System.out.println("ok");
				}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dataJson);
	}
	@PostMapping("/updatesanpham")
	public void updatesanpham(@RequestParam String dataJson)
	{
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			SanPham sanpham=objectMapper.readValue(dataJson, SanPham.class);
			/*System.out.println(sanpham.getHinhSanPham());*/
			if(sanphamservice.updateSP(sanpham))
			{
				System.out.println("ok");
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dataJson);
}
}
