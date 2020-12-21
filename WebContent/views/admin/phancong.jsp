
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
<title>Tables</title>

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
								<c:when test="${param.mess eq 'erorr' }">
									<div
										class="sufee-alert alert with-close alert-danger alert-dismissible fade show">
										<span class="badge badge-pill badge-danger">Erorr</span> Không hợp lệ
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
								<c:when test="${param.mess eq 'success' }">
									<div
										class="sufee-alert alert with-close alert-success alert-dismissible fade show">
										<span class="badge badge-pill badge-success">Success</span>
										Them thanh cong
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
							</c:choose>
							<div class="user-data m-b-30">
								<h3 class="title-3 m-b-30">
									<i class="zmdi zmdi-account-calendar"></i>Phân công
								</h3>
								<div class="card-body card-block">
									<form action="/KiemDinhUTT/kiemdinh/phancong" method="post"
										class="form-horizontal">
										<div class="table-data__tool">
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Người
													đánh giá</label> <select name="taikhoan" id="select"
													class="form-control" required>
													<c:forEach items="${taikhoan}" var="taikhoan">
														<option value="${taikhoan.id_tk }">${taikhoan.hoten }</option>
													</c:forEach>
												</select>
											</div>
											<div class="col col-md-3">
												<label for="select" class=" form-control-label">Tiêu
													Chuẩn</label> <select name="tieuchuan" id="select"
													class="form-control" required>
													<c:forEach items="${tieuChuanList}" var="tieuChuanList">
														<option value="${tieuChuanList.id_tieuchuan }">${tieuChuanList.tentieuchuan}</option>
													</c:forEach>
												</select>
											</div>
											<div class="col col-md-3"></div>
											<div class="col col-md-3"></div>

										</div>
										<div class="card-footer">
											<button type="submit" class="btn btn-primary btn-sm">
												<i class="fa fa-dot-circle-o"></i> Submit
											</button>
										</div>
									</form>
								</div>
							</div>
							<!-- USER DATA-->

							<div class="user-data m-b-30">
								<h3 class="title-3 m-b-30">
									<i class="zmdi zmdi-account-calendar"></i>Phân Công
								</h3>
								<div class="table-data__tool">
									<div class="table-data__tool-left"></div>
									<div class="table-data__tool-right">

										<form class="form-header"
											action="/QuanLyDiem/giaovien/category/search" method="POST">
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
												<td>Họ Tên</td>
												<td>Tiêu Chuẩn</td>
												<td></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${phancong}" var="phancong">
												<tr>
													<td>
														<div class="table-data__info">
															<h6>${phancong.id_phancong}</h6>
														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6>${phancong.taikhoan.hoten}</h6>
														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6>${phancong.tieuchuan.tentieuchuan}</h6>
														</div>
													</td>
													<td><c:if test="${loginTaiKhoan.role eq 0 }">
															<div class="table-data-feature">
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Edit">
																	<a
																		href="/QuanLyDiem/giaovien/updatePM?id_phanmon=${phanmon.id_phanmon }">
																		<i class="zmdi zmdi-edit"></i>
																	</a>
																</button>
																<button class="item" data-toggle="tooltip"
																	data-placement="top" title="Delete">
																	<a
																		href="/QuanLyDiem/giaovien/deletePM?id_phanmon=${phanmon.id_phanmon }"
																		onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
																		class="zmdi zmdi-delete"></i></a>
																</button>
															</div>
														</c:if></td>
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
