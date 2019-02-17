<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="utf-8">
<title>Giỏ Hàng</title>

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
		        <li ><a href="#">TRANG CHỦ <span class="sr-only">(current)</span></a></li>
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
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container">
		<div class="col-xs-6">
		<h3>Danh Sách Sản Phẩm</h3>
			<table class="table">
				<thead>
					<tr>
						<td><h5>Tên Sản Phẩm</h5></td>
						<td><h5>Màu Sản Phẩm</h5></td>
						<td><h5>Size</h5></td>
						<td><h5>Số Lượng</h5></td>
						<td><h5>Giá Tiền</h5></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sanpham" items="${giohang}">
						<tr>
							<td class="maspgh" data-masp="${sanpham.getMasp()}">${sanpham.getTensp()}</td>
							<td class="mamaugh" data-mau="${sanpham.getMamau()}">${sanpham.getTenmau()}</td>
							<td class="masizegh" data-size="${sanpham.getMasize()}">${sanpham.getTensize()}</td>
							<td ><input class="soluonggh" type="number" min="1" value="${sanpham.getSoluong()}"></td>
							<td class="giatiengh" data-giatien="${sanpham.getGiatien()}">${sanpham.getGiatien()*sanpham.getSoluong()}</td>
							<td class="btn btn-danger xoa">Xóa</td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
			<h4 >Tổng Tiền: <span  id="tongtienall" style="color:red">1,500,000 </span><span style="color:red">VNĐ</span></h4>
		</div>
		<div class="col-xs-6">
			<h3>Thông Tin Người Nhận/Mua</h3>
			<div class="form-group">
				<form action="" method="post">
					<label for="tenKhachHang">Tên người mua/nhận</label>
					<input class="form-control" id="tenKhachHang" name="tenKhachHang">
					<label for="soDT">Điện thoại liên lạc</label>
					<input class="form-control" id="soDT" name="soDT">
					<div class="radio">
						<label><input type="radio" name="hinhThucGiaoHang" value="Giao hàng tận nơi" checked>Giao hàng tận nơi</label>
					</div>
					<div class="radio">
						<label><input type="radio" name="hinhThucGiaoHang" value="Nhận tại cửa hàng" >Nhận tại cửa hàng</label>
					</div>
					<label for="diaChiGiaoHang">Địa chỉ nhận hàng</label>
					<input class="form-control" id="diaChiGiaoHang" name="diaChiGiaoHang">
					<label for="ghiChu">Ghi chú</label>
					<textarea rows="5" cols="" class="form-control" id="ghiChu" name="ghiChu"></textarea>
					<br><br>
					<input style="margin-left: 440px;" type="submit" class="btn btn-primary" value="Đặt Hàng"/>
				</form>
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