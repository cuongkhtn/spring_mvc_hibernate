$("#btn-dangnhap").click(function()
		{
			var tenDangNhap=$("#tenDangNhap").val();
			var matKhau=$("#matKhau").val();  
			$.ajax(
			{
				url:"http://localhost:8080/minishopp/login",
				type:"post",
				data:
					{
						tenDangNhap:tenDangNhap,
						matKhau:matKhau
					},
				success:function(value)
				{
					if(value=="true")
						{
						window.location.href = "/minishopp/";
						//alert("a");
						}				
					else
					{
						alert("thua");
					}
				}
			})
		});

$(".btn-giohang").click(function()
		{
			var tenmau=$(this).closest("tr").find(".mau").text();
			var mamau=$(this).closest("tr").find(".mau").attr("data-mau");
			var tensize=$(this).closest("tr").find(".size").text();
			var masize=$(this).closest("tr").find(".size").attr("data-size");
			var soluong=$(this).closest("tr").find(".soluong").text();
			var tensp=$("#tensp").text();
			var giatien=$("#giatien").attr("data-giatien");
			var machitiet=$(this).attr("data-machitiet");
			var masp=$("#tensp").attr("data-masp");
			$.ajax(
					{
						url:"http://localhost:8080/minishopp/chitiet/giohang",
						type:"get",
						data:
							{
							giatien:giatien,
							mamau:mamau,
							masize:masize,
							masp:masp,
							tenmau:tenmau,
							tensize:tensize,
							tensp:tensp,
							machitiet:machitiet
							},
						success:function(value)
						{
							$("#ligh").find("div").addClass("circle-giohang");
							$("#ligh").find("div").html("<span>"+value+"</span>");
							
						}
					})
			
		});

$("#dangky").click(function()
		{
			$(this).addClass("actived");
			$("#dangnhap").removeClass("actived");
			$("#loginform").hide();
			$("#signupform").show();
		});
$("#dangnhap").click(function()
		{
			$(this).addClass("actived");
			$("#dangky").removeClass("actived");
			$("#signupform").hide();
			$("#loginform").show();
		});
$("#btn-dangky").click(function()
		{
			var tenDangNhap=$("#tenDangNhapdk").val();
			var matKhau=$("#matKhausu").val();  
			var matKhausunl=$("#matKhausunl").val();
			$.ajax(
					{
						url:"http://localhost:8080/minishopp/login/signup",
						type:"post",
						data:
							{
								tenDangNhap:tenDangNhap,
								matKhau:matKhau, 	
								matKhausunl:matKhausunl
							},
					success:function(value)
					{
						if(value=="true")
						{
						//window.location.href = "/minishopp/";
						//alert("a");
							alert("ok");
						}				
						else
						{
							alert("thua");
						}
					}
					})
		});
tongtienfc();
function tongtienfc()
{
	var tongtienall=0;
	$(".giatiengh").each(function()
			{
				tongtienall=tongtienall+parseInt($(this).text());
				
			})
	$("#tongtienall").html(tongtienall);
}
$(".idadtsp").click(function()
		{
			var idadtsp=5*($(this).text()-1);
			$("#checkAll").prop("checked",false);
			$.ajax(
					{
						url:"http://localhost:8080/minishopp/admin/themsanphamajax",
						type:"GET",
						data:
							{
								idadtsp:idadtsp,
							},
					success:function(value)
					{
						//alert("thua");
						var tbodysanpham=$("#table-sp").find("tbody");
						tbodysanpham.empty();
						tbodysanpham.append(value);
						
					}
					})
		})	
$(".soluonggh").change(function()
		{
			//alert("thua");
			var soluong=$(this).val();
			var mamau=$(this).closest("tr").find(".mamaugh").attr("data-mau");
			var masize=$(this).closest("tr").find(".masizegh").attr("data-size");
			var masp=$(this).closest("tr").find(".maspgh").attr("data-masp");
			var giatien=$(this).closest("tr").find(".giatiengh").attr("data-giatien");
			var tongtien=giatien*soluong;	
			$(this).closest("tr").find(".giatiengh").html(tongtien);	
			tongtienfc();
			$.ajax({
				url:"http://localhost:8080/minishopp/giohang/capnhat",
				type:"get",
				data:
					{
					soluong:soluong,					
					masize:masize,
					mamau:mamau,
					masp:masp
					},
				success:function(value)
				{
					
				}
			})
		});
$("#checkAll").click(function()
		{
			 if (this.checked) {
			      $("#table-sanpham input").prop("checked",true);			    		  
			  } else {
				  $("#table-sanpham input").prop("checked",false);		
			  }      
		})
		
$(".xoa").click(function()
		{
			var thiss=$(this).closest("tr");
			var mamau=$(this).closest("tr").find(".mamaugh").attr("data-mau");
			var masize=$(this).closest("tr").find(".masizegh").attr("data-size");
			var masp=$(this).closest("tr").find(".maspgh").attr("data-masp");
			$.ajax(
			{
				url:"http://localhost:8080/minishopp/giohang/xoa",
				type:"get",
				data:
					{				
						masize:masize,
						mamau:mamau,
						masp:masp
					},
				success:function(value)
				{
					thiss.closest("tr").remove();
					//alert("thua");
					
				}
			}).done(function()
					{
						tongtienfc();
					});		
		});
$("#btnxoa").click(function()
		{
			      $("#table-sanpham input").each(function()
			    		  {
			    	  		if(this.checked)
			    	  			{
			    	  				var idSanPham=$(this).attr("data-idd");
			    	  				alert(idSanPham);
			    	  			$.ajax({
			    					url:"http://localhost:8080/minishopp/admin/xoasanpham",
			    					type:"post",
			    					data:
			    						{
			    							idSanPham:idSanPham
			    						},
			    					success:function(value)
			    					{
			    						
			    					}
			    	  			})
			    		  }
		})	
	})
	var files=[];
	var tenhinh="";
$("#hinhanh").change(function(event)
		{
			files=event.target.files;
			tenhinh="/resources/images/"+files[0].name;
			forms=new FormData();
			forms.append("file",files[0]);
			
			$.ajax({
						url:"http://localhost:8080/minishopp/admin/upload",
						type:"post",
						data:forms,
						contentType:false,
						processData:false,
						enctype:"multipart/form-data",
						success:function(value){
							
						}
			})
		})
		
$("body").on("click","#btn-themct",function()
		{
			$(this).remove();
			var clone=$(".clone").clone().removeClass("clone");
			$("#cloneto").append(clone);
			
		})
$("#btn-them").click(function(event)
		{
			event.preventDefault();
			var formdata=$("#form_sanpham").serializeArray();
			json = {};			 
			arraychitiet=[];
			 $.each(formdata, function(i, field){
				    json[field.name]=field.value;
				    if(field.name=="danhMucSanPham")
				    	{
				    		objectDanhmuc={};
				    		objectDanhmuc["idDanhMucSanPham"]=field.value;
				    		json[field.name]=objectDanhmuc;
				    	}
				  });
			 $("#cloneto .cloneid").each(function()
					 {
				 		objectChiTiet = {};
				 		objectMau={};				 		
				 		objectSize={};
				 		mausanpham=$(this).find("#mauSanPham").val();
				 		sizesanpham=$(this).find("#size").val();
				 		soluong=parseInt($(this).find("#soLuong").val());
				 		objectMau["idMauSanPham"]=mausanpham;
				 		objectSize["idSize"]=sizesanpham;
				 		objectChiTiet["mauSanPham"]=objectMau;
				 		objectChiTiet["size"]=objectSize;
				 		objectChiTiet["soLuong"]=soluong;
				 		arraychitiet.push(objectChiTiet);
				 		alert(mausanpham);
					 })				
					 json["chitietsanpham"]=arraychitiet;
			 		 json["hinhSanPham"]=tenhinh;
			 		 alert(tenhinh);
			 $.ajax({
				 url:"http://localhost:8080/minishopp/admin/themsanpham",
					type:"post",
					data:{
							dataJson:JSON.stringify(json)
						},
					success:function(value){
					}
			 })
		})	
		var idSanPham1;
$("body").on("click",".updatesanpham",function()
		{
			
			var idSanPham=$(this).attr("data-id");
			idSanPham1=idSanPham;
			$.ajax(				
					{
						 url:"http://localhost:8080/minishopp/admin/laysptheoma",
							type:"post",
							data:{
								idSanPham:idSanPham
								},
							success:function(value){
								console.log(value);
								$("#tenSanPham").val(value.tenSanPham);
								$("#giaTien").val(value.giaTien);
								$("#moTa").val(value.moTa);
								$("#danhMucSanPham").val(value.danhMucSanPham.idDanhMucSanPham);
								$("#cloneto").html("");
								$(".a").remove();
								for(var i=0;i<value.chitietsanpham.length;i++)
									{
										var clone=$(".clone").clone().removeClass("clone");
										$("#cloneto").append(clone);
										clone.find("#mauSanPham").val(value.chitietsanpham[i].mauSanPham.idMauSanPham);
										clone.find("#size").val(value.chitietsanpham[i].size.idSize);
										clone.find("#soLuong").val(value.chitietsanpham[i].soLuong);
										if(i != value.chitietsanpham.length-1)
											{
												clone.find("#btn-themct").remove();
											}
										$("#cloneto").append(clone);
									}
							}
					}
			)
			$("#btn-them").addClass("xoabutton");
			$("#btn-update").removeClass("xoabutton");
			$("#btn-thoat").removeClass("xoabutton");
		})
$("#btn-thoat").click(function()
		{
			$(this).addClass("xoabutton");
			$("#btn-update").addClass("xoabutton");
			$("#btn-them").removeClass("xoabutton");
		})
		
$("body").on("click","#btn-update",function()
		{
			event.preventDefault();
			var formdata=$("#form_sanpham").serializeArray();
			json = {};			 
			arraychitiet=[];
			 $.each(formdata, function(i, field){
				    json[field.name]=field.value;
				    if(field.name=="danhMucSanPham")
				    	{
				    		objectDanhmuc={};
				    		objectDanhmuc["idDanhMucSanPham"]=field.value;
				    		json[field.name]=objectDanhmuc;
				    	}
				  });
			 $("#cloneto .cloneid").each(function()
					 {
				 		objectChiTiet = {};
				 		objectMau={};				 		
				 		objectSize={};
				 		mausanpham=$(this).find("#mauSanPham").val();
				 		sizesanpham=$(this).find("#size").val();
				 		soluong=parseInt($(this).find("#soLuong").val());
				 		objectMau["idMauSanPham"]=mausanpham;
				 		objectSize["idSize"]=sizesanpham;
				 		objectChiTiet["mauSanPham"]=objectMau;
				 		objectChiTiet["size"]=objectSize;
				 		objectChiTiet["soLuong"]=soluong;
				 		arraychitiet.push(objectChiTiet);
				 		alert(mausanpham);
					 })			
					 json["idSanPham"]=idSanPham1;
					 json["chitietsanpham"]=arraychitiet;
			 		 json["hinhSanPham"]=tenhinh;
			 		 alert(tenhinh);
			 $.ajax({
				 url:"http://localhost:8080/minishopp/admin/updatesanpham",
					type:"post",
					data:{
							dataJson:JSON.stringify(json)
						},
					success:function(value){
					}
			 })
		})	