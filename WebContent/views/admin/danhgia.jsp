<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Quản lý người dùng</title>

<jsp:include page="/views/admin/common/linkCss.jsp"></jsp:include>

</head>

<body>
	</script>
	<div class="page-wrapper">
		<!-- header -->
		<jsp:include page="/views/admin/common/header.jsp"></jsp:include>
		<!--end header -->
		<!-- MAIN CONTENT-->
		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<c:choose>
								<c:when test="${param.mess eq 'update' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Sua thanh cong
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
								<c:when test="${param.mess eq 'delete' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Xoa thanh cong
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
							</c:choose>
							<!-- USER DATA-->
							<div class="user-data m-b-30">
								<h3 class="title-3 m-b-30">
									<i class="zmdi zmdi-account-calendar"></i>Danh sách đánh giá
								</h3>
								<div class="table-data__tool">
									<div class="table-data__tool-left">
										
									</div>
									<div class="table-data__tool-right">

										<form class="form-header"
											action="/KiemDinhUTT/kiemdinh/taikhoan/search" method="POST">
											<input class="au-input au-input--xl" type="text" name="key"
												placeholder="Search ..." />
											<button class="au-btn--submit" type="submit">
												<i class="zmdi zmdi-search"></i>
											</button>
										</form>
									</div>
								</div>
								<div class="table-responsive table-data">
									<table class="table">
										<thead>
											<tr>
												<td>ID</td>
												<td>Người đánh giá</td>
												<td>Thời gian</td>
												<td>Tiêu chí</td>
												<td>Tiêu chuẩn</td>
												<td></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${danhgiaList}" var="danhgiaList">
												<tr>
													<td>
														<div class="table-data__info">
															<h6>${danhgiaList.id_danhgia}</h6>
														</div>
													</td>

													<td>
														<div class="table-data__info">
															<a
																href="/KiemDinhUTT/kiemdinh/tieuchi/danhgia/detail?id_danhgia=${danhgiaList.id_danhgia }"><h6>${danhgiaList.user.hoten}</h6></a>
														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6>${danhgiaList.thoigian}</h6>
														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6>${danhgiaList.tieuchi.tentieuchi}</h6>
														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6>${danhgiaList.tieuchi.tieuchuan.tentieuchuan}</h6>
														</div>
													</td>
													<td>
														<div class="table-data-feature">
															<button class="item" data-toggle="tooltip"
																data-placement="top" title="Delete">
																<a
																	href="/KiemDinhUTT/kiemdinh/tieuchi/danhgia/delete?id_danhgia=${danhgiaList.id_danhgia }"
																	onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
																	class="zmdi zmdi-delete"></i></a>
															</button>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>

								<div class="user-data__footer">
									<nav aria-label="Page navigation example ">
										<ul class="pagination justify-content-center">
											<c:choose>
												<c:when test="${page le totalPage }">
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?page=1">Previous</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?page=${page-1 }">Previous</a></li>
												</c:otherwise>
											</c:choose>
											<c:forEach items="${pageList}" var="page">
												<li
													class="page-item <c:if test="${param.page eq page}"> active </c:if> "><a
													class="page-link"
													href="${requestScope.request_uri}?page=${page}">${page}</a></li>
											</c:forEach>
											<c:choose>
												<c:when test="${page ge totalPage }">
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?page=${totalPage}">Next</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?page=${page +1 }">Next</a></li>
												</c:otherwise>
											</c:choose>
										</ul>
									</nav>
								</div>
							</div>
							<!-- END USER DATA-->
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
