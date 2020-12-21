<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Majestic Login Form Widget Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- css files -->
<link href="/KiemDinhUTT/Content/animate-custom.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="/KiemDinhUTT/Content/stylelogin.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- /css files -->
<link rel='shortcut icon' type='image/x-icon' href='/KiemDinhUTT/Images/a.png' />
<link href="/KiemDinhUTT/Content/font-awesome.css" rel="stylesheet" />
</head>
<body>

	<h1 class="w3ls">BÁO CÁO TỰ ĐÁNH GIÁ KIỂM ĐỊNH</h1>
	<p class="stylepName">Đại Học Công Nghệ GTVT</p>
	<div id="container_demo">


		<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
			id="tologin"></a>
		<div id="wrapper">
			<div id="login" class="animate form">
				<form action="/KiemDinhUTT/login" method="post">
					<form action="#" method="post" autocomplete="on">
						<h2>Đăng nhập</h2>
						<p>
							<label for="username" class="uname" data-icon="u"><span>Tài Khoản</span></label> <input id="username" name="taikhoan"
								required="required" type="text"
								placeholder="Tài khoản." />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p"><span>Mật Khẩu</span></label>
						<div class="group">
							<input id="password" name="matkhau" required="required"
								type="password" placeholder="Mật khẩu." /> <span
								toggle="#password"
								class="fa fa-fw fa-eye-slash field-icon toggle-password"
								style="margin-top: 27px;"></span>
						</div>


						</p>

						<p class="login button">
							<input type="submit" value="Đăng nhập" />
						</p>

					</form>
				</form>

			</div>

		</div>
	</div>
	<p class="agileits">
		Đại học Công Nghệ GTVT | Websites <a
			href="utt.edu.vn" target="_blank">UTT</a>
	</p>
</body>
</html>


<script src="/KiemDinhUTT/Scripts/jquery-3.2.1.min.js"></script>

<!-- script for show password -->
<script>
	$(".toggle-password").click(function() {

		$(this).toggleClass("fa-eye fa-eye-slash");
		var input = $($(this).attr("toggle"));
		if (input.attr("type") == "password") {
			input.attr("type", "text");
		} else {
			input.attr("type", "password");
		}
	});
</script>
<!-- /script for show password -->
<style>
.group {
	display: flex;
}

.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
	width: 35%;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}

.stylepName {
	text-align: center;
	font-size: 29px;
	margin-bottom: 20px;
	background-color: #fa6900;
	color: white;
	padding: 13px;
	border-radius: 32px;
	width: 35%;
	margin-left: auto;
	margin-right: auto;
	font-family: SFUFuturaRegular;
}
</style>