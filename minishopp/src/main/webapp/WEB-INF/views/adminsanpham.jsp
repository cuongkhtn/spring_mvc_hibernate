<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
--><%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Pooled Admin Panel Category Flat Bootstrap Responsive Web Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pooled Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
<!-- Custom CSS -->
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/morris.css"/>"/>
<!-- Graph CSS -->
<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.css"/>"/>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!-- //jQuery -->
<link href='//fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'/>
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="<c:url value="/resources/css/icon-font.min.css"/>"/>
<!-- //lined-icons -->
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
<div class="left-content container">
	<div class="row">
	<div class="col-xs-6">
	<h3>Sản phẩm</h3>
	<br>
	<form id="form_sanpham" action="">
		<h4>Tên sản phẩm</h4>
		<input type="text" class="form-control" name="tenSanPham" id="tenSanPham" placeholder="Nhập vào tên sản phẩm">
		<h4>Giá tiền</h4>
		<input type="text" class="form-control" name="giaTien" id="giaTien" placeholder="Nhập vào giá tiền">	
		<h4>Danh mục</h4>
		 <select  class="form-control" name="danhMucSanPham" id="danhMucSanPham">
			 <c:forEach var="item" items="${dmsp}">
	        	<option  value="${item.idDanhMucSanPham}">${item.getTenDanhMuc()}</option>
	        </c:forEach>
     	 </select>
		<h4>Mô tả</h4>
		<textarea rows="5" style="min-width: 100%"  name="moTa" id="moTa" placeholder="Nhập vào mô tả"></textarea>
		<h4>Hình ảnh</h4>
		<input type="file" class="form-control" name="hinhanh" id="hinhanh">	
		</form>
		<div class="clone cloneid">
		<h4>Chi tiết</h4>
			 <select  class="form-control" name="mauSanPham" id="mauSanPham" >
				 <c:forEach var="item" items="${listmau}">
		        	<option value="${item.getIdMauSanPham()}">${item.getMauSP()}</option>
		        </c:forEach>
	     	 </select>
	     	 <br>
	     	  <select  class="form-control" name="size" id="size" >
				 <c:forEach var="item" items="${listsize}">
		        	<option value="${item.getIdSize()}">${item.getSize()}</option>
		        </c:forEach>
	     	 </select>
	     	 <br>
	     	 <input  class="form-control" type="number" name="soLuong" id="soLuong" min="1"  placeholder="Số lượng">
			<br>			
			<button style="display:block;float:right" type="button" class="btn btn-info" id="btn-themct">Thêm Chi Tiết</button>
		</div>
		<button style="display:block;float:right" type="button" class="btn btn-info a" id="btn-themct">Thêm Chi Tiết</button>
		<br>
		<div id="cloneto"></div>
		<br>
		<button type="button" class="btn btn-info" id="btn-them">Thêm sản phẩm</button>
		<button type="button" class="btn btn-info xoabutton" id="btn-update">Update</button>
		<button type="button" class="btn btn-info xoabutton" id="btn-thoat">Thoát</button>
		
	</div>
	<div class="col-xs-6">
		<br>
	<br>
	<br>
		<div style="float:right">
			<button class="btn btn-primary" id="btnthem">Thêm sản phẩm</button>
			<button class="btn btn-primary" id="btnxoa">Xóa</button>
		</div>
		<table class="table" id="table-sp">
					<thead>
					<tr >
						<td><h5><input type="checkbox" id="checkAll"></h5></td>
						<td><h5 class="fontw">Mã Sản Phẩm</h5></td>
						<td><h5 class="fontw">Tên Sản Phẩm</h5></td>
						<td><h5 class="fontw">Giá Tiền</h5></td>			
					</tr>
					</thead>
					<tbody>
					 <c:forEach var="dssp" items="${dssp}">
					<tr id="table-sanpham">
						<td><label><input type="checkbox" data-idd="${dssp.getIdSanPham()}"></label></td>
						<td ><p style="margin-left: 35px" >${dssp.getIdSanPham()}</p></td>
						<td >${dssp.getTenSanPham()}</td>
						<td >${dssp.getGiaTien()}</td>
						<td class="btn btn-primary updatesanpham"  data-id="${dssp.getIdSanPham()}">Update</td>						
					</tr>
					</c:forEach>
					</tbody>		
				</table>
				<ul class="pagination">
				<c:forEach  var="i" begin="1" end="${slsp}">
					  <li class="idadtsp"><a href="#" >${i}</a></li>
				</c:forEach>
				</ul>
	</div>
</div>
</div>
  <!--//content-inner-->
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo1">
						<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
					</header>
						<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                           <div class="menu">
									<ul id="menu" >
										<li><a href="index.html"><i class="fa fa-tachometer"></i> <span>Dashboard</span><div class="clearfix"></div></a></li>
										
										
										 <li id="menu-academico" ><a href="#"><i class="fas fa-cube"></i><span>Thêm Sản Phẩm</span><div class="clearfix"></div></a></li>
									<li><a href="gallery.html"><i class="fa fa-picture-o" aria-hidden="true"></i><span>Gallery</span><div class="clearfix"></div></a></li>
									<li id="menu-academico" ><a href="charts.html"><i class="fa fa-bar-chart"></i><span>Charts</span><div class="clearfix"></div></a></li>
									 <li id="menu-academico" ><a href="#"><i class="fa fa-list-ul" aria-hidden="true"></i><span> Short Codes</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="icons.html">Icons</a></li>
											<li id="menu-academico-avaliacoes" ><a href="typography.html">Typography</a></li>
											<li id="menu-academico-avaliacoes" ><a href="faq.html">Faq</a></li>
										  </ul>
										</li>
									<li id="menu-academico" ><a href="errorpage.html"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i><span>Error Page</span><div class="clearfix"></div></a></li>
									  <li id="menu-academico" ><a href="#"><i class="fa fa-cogs" aria-hidden="true"></i><span> UI Components</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										   <ul id="menu-academico-sub" >
										   <li id="menu-academico-avaliacoes" ><a href="button.html">Buttons</a></li>
											<li id="menu-academico-avaliacoes" ><a href="grid.html">Grids</a></li>
										  </ul>
										</li>
									 <li><a href="tabels.html"><i class="fa fa-table"></i>  <span>Tables</span><div class="clearfix"></div></a></li>
									<li><a href="maps.html"><i class="fa fa-map-marker" aria-hidden="true"></i>  <span>Maps</span><div class="clearfix"></div></a></li>
							        <li id="menu-academico" ><a href="#"><i class="fa fa-file-text-o"></i>  <span>Pages</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
										 <ul id="menu-academico-sub" >
											<li id="menu-academico-boletim" ><a href="calendar.html">Calendar</a></li>
											<li id="menu-academico-avaliacoes" ><a href="signin.html">Sign In</a></li>
											<li id="menu-academico-avaliacoes" ><a href="signup.html">Sign Up</a></li>
											

										  </ul>
									 </li>
									<li><a href="#"><i class="fa fa-check-square-o nav_icon"></i><span>Forms</span> <span class="fa fa-angle-right" style="float: right"></span><div class="clearfix"></div></a>
									  <ul>
										<li><a href="input.html"> Input</a></li>
										<li><a href="validation.html">Validation</a></li>
									</ul>
									</li>
								  </ul>
								</div>
							  </div>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }
											
											toggle = !toggle;
										});
							</script>
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script type="text/javascript" src='<c:url value="/resources/js/scripts.js"/>'/></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src='<c:url value="/resources/js/bootstrap.min.js"/>'/></script>
   <!-- /Bootstrap Core JavaScript -->	   
<!-- morris JavaScript -->	
<script type="text/javascript" src='<c:url value="/resources/js/raphael-min.js"/>'/></script>
<script type="text/javascript" src='<c:url value="/resources/js/morris.js"/>'/></script>
<script type="text/javascript" src='<c:url value="/resources/js/custom.js"/>'/></script>
<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2014 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2014 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2014 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2014 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2015 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2015 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2015 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2015 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2016 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
				{period: '2016 Q2', iphone: 8442, ipad: 5723, itouch: 1801}
			],
			lineColors:['#ff4a43','#a2d200','#22beef'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
	});
	</script>
</body>
</html>