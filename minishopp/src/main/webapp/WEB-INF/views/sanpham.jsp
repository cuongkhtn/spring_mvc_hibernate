<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="utf-8">
<title>Trang Sản Phẩm</title>

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
					<li><a href="${dmsp.getIdDanhMucSanPham()}" style="color:black">${dmsp.getTenDanhMuc()}</a></li>					
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
			<div class="col-xs-10">
			<c:forEach var="sanpham" items="${listSP}" begin = "1" end = "1">
				<h3 style="margin-left:20px">${sanpham.getDanhMucSanPham().getTenDanhMuc()}</h3>
			</c:forEach>
			<br>
				<c:forEach var="sanpham" items="${listSP}">
					<div class="col-md-3 col-xs-12 col-sm-6 spha wow zoomIn" data-wow-delay="0.1s">
					  	<div class="card thumbnail" style="width: 18rem;">
					  	<a href="../chitiet/${sanpham.getIdSanPham()}">
						  <img class="card-img-top" alt="Card image cap" src="<c:url value="${sanpham.getHinhSanPham()}"/>"/>
						  </a>
						  <div class="card-body">
						    <h5 class="card-title">${sanpham.getTenSanPham()} </h5>
						    <h5 class="card-price">${sanpham.getGiaTien()} VNĐ</h5>
						    <a href="#" class="btn btn-primary">Thêm vào giỏ</a>
						  </div>
						</div>
					</div>
				</c:forEach>
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