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
<title>Thông tin phụ lục</title>

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
								<strong>${phuluc.tenphuluc }</strong>
							</div>
							<div class="card-body card-block">
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Tiêu
											đề</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${phuluc.tieude_phuluc }</label>
									</div>
								</div>
								<div class="row form-group">
									<div class="col col-md-2">
										<label for="text-input" class=" form-control-label">Nội
											dung</label>
									</div>
									<div class="col-12 col-md-10">
										<label for="text-input" class=" form-control-label">${phuluc.noidung_phuluc }</label>
									</div>
								</div>
								<div class="card-footer">
									<button type="button" class="btn btn-primary btn-sm">
										<a style="color: #212529"
											href="/KiemDinhUTT/kiemdinh/phuluc/update?id_phuluc=${phuluc.id_phuluc }">
											<i class="zmdi zmdi-edit"></i>Update
										</a>
									</button>
									<button type="button" class="btn btn-danger btn-sm">
										<a style="color: #212529"
											href="/KiemDinhUTT/kiemdinh/phuluc/delete?id_phuluc=${phuluc.id_phuluc }"
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
