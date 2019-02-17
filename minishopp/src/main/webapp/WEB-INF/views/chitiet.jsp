<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="utf-8">
<title>Trang Chi Tiết</title>

</head>
<body >

	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-default none_navbar">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header ">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"><img id="icon-hdct" src="<c:url value="/resources/img/yame-f-logo-white.png"/>"/></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-center ">
		        <li ><a href="../">TRANG CHỦ <span class="sr-only">(current)</span></a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="#">Action</a></li>
			            <li><a href="#">Another action</a></li>
			            <li><a href="#">Something else here</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">Separated link</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="#">One more separated link</a></li>
			          </ul>  
			        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      <c:choose>  
		     <c:when test="${tk ==null}">
		        <li><a href="../login">ĐĂNG NHẬP</a></li>
		        <li><a href="#">ĐĂNG KÝ</a></li>	       
		      </c:when>		   	
		   	<c:when test="${tk !=null}">
		       	<li><a href="">${tk.toUpperCase()}</a></li>
		       	<li><a href="#">ĐĂNG XUẤT</a></li>
			</c:when>
		</c:choose>
		<li id="ligh"><a href="#"><i class="fas fa-shopping-cart"></i>
				<c:if test="${giohang.size() >0 }">
					<div class="circle-giohang"><span>${giohang.size()}</span></div>
		        </c:if>
		         <c:if test="${giohang.size()==null}">
		        	<div ><span>${giohang.size()}</span></div>
		        </c:if>
		        </a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container fontw">
		<div class="row">
		<div class="col-xs-2 menu" >
			<h3 >Danh mục sản phẩm</h3>
			<ul>
				<c:forEach var="dmsp" items="${dmsp}">
					<li><a href="../sanpham/${dmsp.getIdDanhMucSanPham()}" style="color:black">${dmsp.getTenDanhMuc()}</a></li>						
					<!-- <ul>
							<li><a href="#"></a>
								Áo Sơ Mi
							</li>
							<li><a href="#"></a>
								Áo Khoác
							</li>
							<li><a href="#"></a>
								Quần Tây	
							</li>
							<li><a href="#"></a>
								Quần Sort
							</li>
						</ul> -->
				</c:forEach>		
			</ul>
			</div>
			<div class="col-xs-3">
				<img id="anh" alt="Ảnh chi tiết" src="<c:url value="${sp.getHinhSanPham()}"/>"/>
			</div>
			<div class="col-xs-5">
				<h3 id="tensp" data-masp="${sp.getIdSanPham()}">${sp.getTenSanPham()}</h3>
				<h4 style="color:green"; id="giatien" data-giatien="${sp.getGiaTien()}">${sp.getGiaTien()} VNĐ</h4>
				<table class="table">
					<thead>
					<tr >
						<td><h5 class="fontw">Màu Sản Phẩm</h5></td>
						<td><h5 class="fontw">Size</h5></td>
						<td><h5 class="fontw">Số Lượng</h5></td>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="ctsp" items="${sp.getChitietsanpham()}">
					<tr>
						<td class="mau" data-mau="${ctsp.getMauSanPham().getIdMauSanPham()}">${ctsp.getMauSanPham().getMauSP()}</td>
						<td class="size" data-size="${ctsp.getSize().getIdSize()}">${ctsp.getSize().getSize()}</td>
						<td class="soluong">${ctsp.getSoLuong()}</td>
						<td><button type="button" data-machitiet="${ctsp.getIdChiTietSanPham()}" class="btn btn-danger btn-giohang"  style="height: 40px;margin-top: -4px;" > <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px"
						width="27" height="27" viewBox="0 0 224 224" style="fill:#000000;margin-bottom: -7px"><g fill="none" fill-rule="nonzero" stroke="none" stroke-width="1" 
						stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" 
						font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><path d="M0,224v-224h224v224z" fill="none">
						</path><g fill="#ffffff"><g id="surface1"><path d="M35,49c-3.85547,0 -7,3.14453 -7,7c0,3.85547 3.14453,7 7,7h15.53125l18.375,73.5c1.55859,6.23438 7.13672,10.5 13.5625,10.5h80.28125c6.31641,0 11.67578,-4.18359 13.34375,-10.28125l18.15625,-66.71875h-117.25l3.5,14h95.59375l-13.34375,49h-80.28125l-18.375,-73.5c-1.55859,-6.23437 -7.13672,-10.5 -13.5625,-10.5zM154,147c-11.51172,0 -21,9.48828 -21,21c0,11.51172 9.48828,21 21,21c11.51172,0 21,-9.48828 21,-21c0,-11.51172 -9.48828,-21 -21,-21zM91,147c-11.51172,0 -21,9.48828 -21,21c0,11.51172 9.48828,21 21,21c11.51172,0 21,-9.48828 21,-21c0,-11.51172 -9.48828,-21 -21,-21zM91,161c3.9375,0 7,3.0625 7,7c0,3.9375 -3.0625,7 -7,7c-3.9375,0 -7,-3.0625 -7,-7c0,-3.9375 3.0625,-7 7,-7zM154,161c3.9375,0 7,3.0625 7,7c0,3.9375 -3.0625,7 -7,7c-3.9375,0 -7,-3.0625 -7,-7c0,-3.9375 3.0625,-7 7,-7z"></path></g></g></g></svg>Chọn Mua</button></td>
					</tr>
					</c:forEach>
					</tbody>		
				</table>
			</div>			
			<div class="col-xs-2" style="margin-top:25px;">
			<p>${sp.getMoTa()}</p>
			</div>
		</div>
	</div>
	<div id="footer" class="container-fluid ">
		<div class="row">
			<div class="col-sm-4 col-xs-12 wow tada">
			<p><span>THÔNG TIN SHOP</span></p>
			<span>Yame là một thương hiệu thời trang đầy uy tín,luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng.</span>
			</div>
			<div class="col-sm-4 col-xs-12 wow tada">
			<p><span>LIÊN HỆ</span></p>
			<span>43 Nguyễn Trãi,phường 12,Quận 5 TP.Hồ Chí Minh</span>
			<span>cuonganh365@gmail.com</span>
			<span>0357235365</span>
			</div>
			<div class="col-sm-4 col-xs-12 wow tada">
			<p><span>GÓP Ý</span></p>
			<form action="" method="post">
			 	<input  type="text" placeholder="Email"/>
				<textarea  rows="4" cols="50" placeholder="Nội dung..."></textarea>
				<button  id="form-submit" style="margin-bottom: 8px;box-shadow: none">Gửi</button>
			</form>
			
			</div>
		</div>
	</div>	
</body>
<jsp:include page="footer.jsp"/>
</html>