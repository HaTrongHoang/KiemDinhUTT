<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Thông tin người dùng</title>

<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
</head>

<body>

	<!-- HEADER -->
	<jsp:include page="/views/admin/common/header.jsp"></jsp:include>
	<!-- MAIN CONTENT-->
	<div class="main-content">
		<div class="section__content section__content--p30">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-11">
						<div class="card">
							<div class="card-header">
								<strong>Thông tin người dùng</strong>
							</div>
							<div class="card-body card-block">
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Ảnh</label>
									</div>
									<div class="col-12 col-md-3">
										<img
											src="${pageContext.request.contextPath }/upload/user/${tkDetail.img }"
											name="img" alt="..." class="img-thumbnail">
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Họ
											Tên</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.hoten }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Tài
											Khoản</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.taikhoan }</label>
									</div>
								</div>

								<div class="row form-group">
									<div class="col col-md-3">
										<label class=" form-control-label">Giới tính</label>
									</div>
									<div class="col col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.gioitinh }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Địa
											chỉ</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.diachi }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Ngày
											sinh</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.ngaysinh }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Số
											điện thoại</label>
									</div>
									<div class="col-12 col-md-9">
										<label for="text-input" class=" form-control-label">${tkDetail.sdt }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-3">
										<label for="text-input" class=" form-control-label">Chức
											vụ</label>
									</div>
									<div class="col-12 col-md-9">
										<c:if test="${tkDetail.role eq 0 }">
											<label for="text-input" class=" form-control-label">Admin</label>
										</c:if>
										<c:if test="${tkDetail.role eq 1 }">
											<label for="text-input" class=" form-control-label">Member</label>
										</c:if>
									</div>
								</div>

								<c:if test="${loginTaiKhoan.role eq 0 }">
									<div class="card-footer">
										<button type="button" class="btn btn-primary btn-sm">
											<a style="color: #212529"
												href="/KiemDinhUTT/kiemdinh/taikhoan/update?id_tk=${tkDetail.id_tk }">
												<i class="zmdi zmdi-edit"></i>Update
											</a>
										</button>
										<button type="button" class="btn btn-danger btn-sm">
											<a style="color: #212529"
												href="/KiemDinhUTT/kiemdinh/taikhoan/delete?id_tk=${tkDetail.id_tk }"
												onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
												class="zmdi zmdi-delete"></i>Delete</a>
										</button>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	</div>

	<jsp:include page="/views/admin/common/scriptJS.jsp"></jsp:include>
</body>

</html>
<!-- end document-->
