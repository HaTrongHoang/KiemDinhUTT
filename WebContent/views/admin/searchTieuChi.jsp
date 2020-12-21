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
								<c:when test="${param.mess eq 'exist' }">
									<div
										class="sufee-alert alert with-close alert-danger alert-dismissible fade show">
										<span class="badge badge-pill badge-danger">Erorr</span> Danh
										muc ton tai
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:when>
								<c:when test="${param.mess eq 'addsuccess' }">
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
							<!-- USER DATA-->
							<div class="user-data m-b-30">
								<h3 class="title-3 m-b-30">
									<i class="zmdi zmdi-account-calendar"></i>Search "${key }"
								</h3>
								<div class="table-data__tool">
									<div class="table-data__tool-left">
										<button class=" au-btn-icon au-btn--small">
											<a
												href="/KiemDinhUTT/kiemdinh/tieuchi/add?id_tieuchuan=${id_tieuchuan }"><i
												class="zmdi zmdi-plus"></i>THÊM TIÊU CHI</a>
										</button>
									</div>
									<div class="table-data__tool-right">

										<form class="form-header"
											action="/KiemDinhUTT/kiemdinh/tieuchi/search?id_tieuchuan=${id_tieuchuan }"
											method="POST">
											<input class="au-input au-input--xl" type="text" name="key"
												placeholder="Search ..." />
											<button class="au-btn--submit" type="submit">
												<i class="zmdi zmdi-search"></i>
											</button>
										</form>
									</div>
								</div>
								<div class="card-body card-block">
									<div class="table-responsive table-data">
										<table class="table">
											<thead>
												<tr>
													<td>ID</td>
													<td>Tên tiêu chí</td>
													<td>Tiêu chuẩn</td>
													<td></td>
												</tr>
											</thead>
											<tbody>
												<div class="table-data__tool">
													<c:forEach items="${tieuchiListSearch}" var="tieuchi">
														<tr>
															<td>
																<div class="table-data__info ">
																	<h6>${tieuchi.id_tieuchi}</h6>
																</div>
															</td>
															<td>
																<div class="table-data__info">
																	<a
																		href="/KiemDinhUTT/kiemdinh/tieuchi?id_tk=${tk.id_tk }"><h6>${tieuchi.tentieuchi}</h6></a>
																</div>
															</td>
															<td>
																<div class="table-data__info">
																	<h6>${tieuchi.tieuchuan.tentieuchuan}</h6>
																</div>
															</td>
															<td>
																<div class="table-data__info" style="width: 500px; word-wrap: break-word;">
																	<h6>${tieuchi.noidung_tieuchi}</h6>
																</div>
															</td>
															<td>
																<div class="table-data-feature">
																	<button class="item" data-toggle="tooltip"
																		data-placement="top" title="Edit">
																		<a
																			href="/KiemDinhUTT/kiemdinh/tieuchi/update?id_tieuchi=${tieuchi.id_tieuchi }">
																			<i class="zmdi zmdi-edit"></i>
																		</a>
																	</button>
																	<button class="item" data-toggle="tooltip"
																		data-placement="top" title="Delete">
																		<a
																			href="/KiemDinhUTT/kiemdinh/tieuchi/delete?id_tieuchi=${tieuchi.id_tieuchi }"
																			onclick="return confirm('Bạn có chắc chắn muốn xóa không?');"><i
																			class="zmdi zmdi-delete"></i></a>
																	</button>
																</div>
															</td>
														</tr>
													</c:forEach>
												</div>
											</tbody>
										</table>
									</div>
								</div>

								<div class="user-data__footer">
									<nav aria-label="Page navigation example ">
										<ul class="pagination justify-content-center">
											<c:choose>
												<c:when test="${page le totalPage }">
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?id_tieuchuan=${id_tieuchuan }&key=${key }&page=1">Previous</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?id_tieuchuan=${id_tieuchuan }&key=${key }&page=${page-1 }">Previous</a></li>
												</c:otherwise>
											</c:choose>
											<c:forEach items="${pageList}" var="page">
												<li
													class="page-item <c:if test="${param.page eq page}"> active </c:if> "><a
													class="page-link"
													href="${requestScope.request_uri}?id_tieuchuan=${id_tieuchuan }&key=${key }&page=${page}">${page}</a></li>
											</c:forEach>
											<c:choose>
												<c:when test="${page ge totalPage }">
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?id_tieuchuan=${id_tieuchuan }&key=${key }&page=${totalPage}">Next</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="${requestScope.request_uri}?id_tieuchuan=${id_tieuchuan }&key=${key }&page=${page +1 }">Next</a></li>
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
