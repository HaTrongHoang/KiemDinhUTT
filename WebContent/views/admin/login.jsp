<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
<title>Dăng nhập</title>
</head>
<body>
	<div class="page-wrapper">
		<div class="page-content--bge5">
			<div class="container">
				
				<div class="login-wrap">
					<div class="login-content">
						<div class="login-logo">
							<img src="/KiemDinhUTT/Images/logo.png" alt="UTT">
						</div>
						<div class="login-form">
							<form action="/KiemDinhUTT/login-admin" method="post">
								<div class="form-group">
									<label>Username</label> <input class="au-input au-input--full"
										type="text" name="taikhoan" placeholder="Username" required>
								</div>
								<div class="form-group">
									<label>Password</label> <input class="au-input au-input--full"
										type="password" name="matkhau" placeholder="Password"
										required>
								</div>
								<button class="au-btn au-btn--block au-btn--green m-b-20"
									type="submit">sign in</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/admin/common/scriptJS.jsp"></jsp:include>

</body>
</html>