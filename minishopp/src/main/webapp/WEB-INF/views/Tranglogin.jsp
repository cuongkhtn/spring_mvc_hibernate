<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp"/>
<meta charset="ISO-8859-1">
<title>practice_1</title>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
			<div id="top-left" class="header-login">
				<span id="wc">WELCOME</span><br>
				<span id="wc1">Hãy tạo nên phong cách của bạn cùng Minishop</span>
			</div>
			<div id="bottom-left">
				<p><i class="far fa-circle"></i><span> Luôn cập nhật xu hướng thời trang mới nhất</span></p>
				<p><i class="far fa-circle"></i><span> Giảm hơn 50% tất cả các mặt hàng giành cho khách VIP</span></p>
				<p><i class="far fa-circle"></i><span> Tận tình tư vấn để tạo nên phong cách cho bạn</span></p>
			</div>
			</div>
			<div id="container-login-right" class="header-login">
				<div id="header-right">
					<span class="actived" id="dangnhap">ĐĂNG NHẬP</span>/<span id="dangky">ĐĂNG KÝ</span><br>
				</div>
				<div id="loginform">
					<form action="" method="post">
				    <i class="fas fa-envelope fa-2x"></i>
					<input  id="tenDangNhap" name="tenDangNhap" type="text" placeholder="Email"/><br>
					 <i class="fas fa-lock fa-2x i2"></i>
					<input  id="matKhau" name="matKhau" type="password" placeholder="Mật khẩu"/><br> 
					<!-- <button  id="btn-dangnhap">ĐỒNG Ý</button>	 -->
					</form>
					<button  id="btn-dangnhap">ĐỒNG Ý</button>
				</div> 
				<div id="signupform">
					<form action="" method="post">
				    <i class="fas fa-envelope fa-2x"></i>
					<input  id="tenDangNhapdk" name="tenDangNhapdk" type="text" placeholder="Email"/><br>
					 <i class="fas fa-lock fa-2x i2"></i>
					<input  id="matKhausu" name="matKhausu" type="password" placeholder="Mật khẩu"/><br> 
					<i class="fas fa-lock fa-2x i2"></i>
					<input  id="matKhausunl" name="matKhausunl" type="password" placeholder="Nhập lại Mật khẩu"/><br> 
					</form>
					<button  id="btn-dangky">ĐĂNG KÝ</button>				
				</div>
				<p>${kiemtradangnhap}<p>
				<p>${ktdangky}<p>
				<p>${ktemail}<p>
				<div id="icon-right">
					<%-- <img alt="facebook" src='<c:url value="/resources/img/icon_fb.png" />' />
					<img alt="google" src='<c:url value="/resources/img/icon_google.png" /> '/> --%>
					<i class="fab fa-facebook-square fa-3x"></i>
					<i class="fab fa-google-plus fa-3x"></i>
				</div>
			</div>
		</div>	
	</div>
</body>
<jsp:include page="footer.jsp"/>
</html>