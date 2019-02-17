package com.quoccuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quoccuong.service.DanhMucService;
import com.quoccuong.service.SanPhamService;

@Controller
@RequestMapping("sanpham")
public class SanPhamController {
	@Autowired
	SanPhamService sanphamservice;
	@Autowired
	DanhMucService danhmucservice;
	@GetMapping("/{id}")
	public String sanpham(@PathVariable int id,ModelMap modelmap)
	{
		modelmap.addAttribute("dmsp",danhmucservice.layDMSP());
		modelmap.addAttribute("listSP",sanphamservice.loadTheoDM(id));
		return "sanpham";
	}
}
