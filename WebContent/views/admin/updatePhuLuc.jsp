<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>
</head>

<body>
	<div class="page-wrapper">
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
									<strong>Thêm mới</strong>
								</div>
								<div class="card-body card-block">
									<form action="/KiemDinhUTT/kiemdinh/phuluc/update?id_phuluc=${phuluc.id_phuluc }" method="post"
										class="form-horizontal">
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Tên
													phụ lục</label>
											</div>
											<div class="col-12 col-md-9">
												<input type="text" id="text-input" name="tenphuluc"
													class="form-control" value="${phuluc.tenphuluc }" required>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Tiêu
													đề</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="tieude_phuluc" placeholder="Content..."
													class="form-control ">${phuluc.tieude_phuluc }</textarea>
											</div>
										</div>
										<div class="row form-group">
											<div class="col col-md-3">
												<label for="textarea-input" class=" form-control-label">Nội
													dung</label>
											</div>
											<div class="col-12 col-md-9">
												<textarea name="noidung_phuluc"
													class="form-control ckeditor">${phuluc.noidung_phuluc }</textarea>
											</div>
										</div>
										<div class="card-footer">
											<button type="submit" class="btn btn-primary btn-sm">
												<i class="fa fa-dot-circle-o"></i> Submit
											</button>
											<button type="reset" class="btn btn-danger btn-sm">
												<i class="fa fa-ban"></i> Reset
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/admin/common/scriptJS.jsp"></jsp:include>
	<script>
		var editor = CKEDITOR.replace('editor');
		CKFinder.setupCKEditor(editor, '/KiemDinhUTT/Scripts/ckfinder/');
	</script>


</body>
</html>