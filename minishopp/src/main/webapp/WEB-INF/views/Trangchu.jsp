<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="utf-8">
<title>Trang Chu</title>

</head>
<body >

	<div id="header" class="container-fluid">
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
		      <a class="navbar-brand" href="#"><img id="icon-hd" src="<c:url value="/resources/img/yame-f-logo-white.png"/>"/></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-center ">
		        <li ><a href="#">TRANG CHỦ <span class="sr-only">(current)</span></a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">SẢN PHẨM<span class="caret"></span></a>
			          <ul class="dropdown-menu">
							<c:forEach var="dmsp" items="${dmsp}">
								<li><a href="sanpham/${dmsp.getIdDanhMucSanPham()}" style="color: black !important;" data-iddm="${dmsp.getIdDanhMucSanPham()}">${dmsp.getTenDanhMuc()}</a></li>	
								<li role="separator" class="divider"></li>				
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
			        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		      <c:choose>  
		     <c:when test="${tk ==null}">
		        <li><a href="login">ĐĂNG NHẬP</a></li>
		        <li><a href="#">ĐĂNG KÝ</a></li>
		        <li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
		      </c:when>
		   	
		   	<c:when test="${tk !=null}">
		       	<li><a href="">${tk.toUpperCase()}</a></li>
		       	<li><a href="#">ĐĂNG XUẤT</a></li>
		        <li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
			</c:when>
		</c:choose>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		<div class="event_header container wow rubberBand">
			<span>Ngay 1/11-20/11/2018</span><br>
			<span style="font-size: 50px;">Mua 1 Tặng 1</span><br>
			<button>XEM NGAY</button>
		</div>
	</div>
	<div id="info" class="container-fluid ">
		<div   class="row">
			<div class=" col-sm-1"></div>
			<div class=" col-sm-10">
				<div class=" col-sm-4 wow fadeInLeft">
				<i class="fas fa-medal fa-3x"></i><br>
				<span style="font-size: 28px;">CHẤT LƯỢNG</span><br>
				<span>Chúng tôi cam kết sẽ mang đến cho các bạn chất lượng sản phẩm tốt nhất</span>
			</div>
			<div class="col-sm-4 wow fadeInDown" data-wow-delay="0.5s">
				<i class="fas fa-piggy-bank fa-3x "></i><br>
				<span style="font-size: 28px;">TIẾT KIỆM CHI PHÍ</span><br>
				<span>Cam kết giá rẻ nhất Việt Nam giúp các bạn tiếp kiệm 20% cho từng sản phẩm</span>
			</div>
			<div class="col-sm-4 wow fadeInUp" data-wow-delay="1s">
				<i class="fas fa-shipping-fast fa-3x "></i><br>
				<span style="font-size: 28px;">GIAO HÀNG</span><br>
				<span>Cam kết giao hàng tận nơi trong ngày.Để mang sản phẩm đến cho khách hàng nhanh nhất</span>
			</div>
			</div>
			<div class=" col-sm-1"></div>
		</div>		
	</div>
	<div  id="sph" class="container-fluid ">
		<span>SẢN PHẨM HOT</span> 
		
		<div class="row">
		<div class="col-sm-1">
		</div>
		<div class="col-sm-10">
		<c:forEach var="sanpham" items="${listSP}">
			<div class="col-md-3 col-xs-12 col-sm-6 spha wow zoomIn" data-wow-delay="0.1s">
			  	<div class="card thumbnail" style="width: 18rem;">
			  	<a href="chitiet/${sanpham.getIdSanPham()}">
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
		<div class="col-sm-1">
		</div>
		</div>
	</div>
	
	<!-- ------------------------------------------------------- -->
	

	

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