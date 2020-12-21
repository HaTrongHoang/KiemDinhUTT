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
								<strong>Đánh giá</strong>
							</div>
							<div class="card-body card-block">
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Họ
											Tên</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.user.hoten }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Mô
											tả</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.mota }</label>
									</div>
								</div>

								<div class="row form-group">
									<div class="col col-md-2">
										<label class=" form-control-label">Điểm mạnh</label>
									</div>
									<div class="col col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.diemmanh }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Điểm
											tồn tại</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.diemtontai }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Kế
											hoạch</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.kehoach }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Tự
											đánh giá</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.tudanhgia }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Thời
											gian</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${danhgia.thoigian }</label>
									</div>
								</div>
								<div class="card-footer">

									<button type="button" class="btn btn-danger btn-sm">
										<a style="color: #212529"
											href="/KiemDinhUTT/kiemdinh/tieuchi/danhgia/delete?id_danhgia=${danhgia.id_danhgia }"
											onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
											class="zmdi zmdi-delete"></i>Delete</a>
									</button>
								</div>
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
