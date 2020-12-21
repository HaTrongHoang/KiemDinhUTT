<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.thang.DaoImpl.TieuChuanDaoImpl"%>
<%@ page import="com.thang.dao.TieuChuanDao"%>
<%@ page import="com.thang.model.TieuChuan"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thang.DaoImpl.TieuChiDaoImpl"%>
<%@ page import="com.thang.dao.TieuChiDao"%>
<%@ page import="com.thang.model.TieuChi"%>
<%@ page import="com.thang.model.PhuLuc"%>
<%@ page import="com.thang.DaoImpl.PhuLucDaoImpl"%>
<%@ page import="com.thang.dao.PhuLucDao"%>
<%@ page import="com.thang.model.TongQuat"%>
<%@ page import="com.thang.DaoImpl.TongQuatDaoImpl"%>
<%@ page import="com.thang.dao.TongQuatDao"%>
<%
	TieuChuanDao tieuChuanDao = new TieuChuanDaoImpl();
List<TieuChuan> tieuChuan = tieuChuanDao.getAll();
request.setAttribute("tieuChuan", tieuChuan);
TieuChiDao tieuChiDao = new TieuChiDaoImpl();
List<TieuChi> tieuchi = tieuChiDao.getAll();
request.setAttribute("tieuChi", tieuchi);

PhuLucDao phulucDao = new PhuLucDaoImpl();
List<PhuLuc> phulucList = phulucDao.getAll();
request.setAttribute("phulucList", phulucList);

TongQuatDao tongquatDao = new TongQuatDaoImpl();
List<TongQuat> tongquatList = tongquatDao.getAll();
request.setAttribute("tongquatList", tongquatList);
%>
<!--left-fixed -navigation-->
<div class=" sidebar" role="navigation">
	<div class="navbar-collapse">
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left"
			id="cbp-spmenu-s1">
			<ul class="nav" id="side-menu">
				<li><a href="tong-quan"><i class="fa fa-list-alt nav_icon"></i>Tổng
						quan</a></li>
				<li>
					<p
						style="margin-left: 20px; color: yellow; font-weight: bold; margin-bottom: 10px;">PHẦN
						I: TỔNG QUÁT VỀ CƠ SỞ GIÁO DỤC</p>
				</li>
				<c:forEach items="${tongquatList }" var="tongquatList">
					<li><a
						href="/KiemDinhUTT/utt/tongquat?id_tongquat=${ tongquatList.id_tongquat}"><i
							class="fa fa-clipboard nav_icon"></i>${tongquatList.tieude_tongquat }</a></li>
				</c:forEach>
				<li>
					<p
						style="margin-left: 20px; color: yellow; font-weight: bold; margin-bottom: 10px;">PHẦN
						II: TỰ ĐÁNH GIÁ VỀ CHẤT LƯỢNG CƠ SỞ GIÁO DỤC</p>

				</li>
				<c:forEach items="${tieuChuan }" var="tieuchuan">
					<li><a href="#"><i class="fa fa-book nav_icon"></i>${tieuchuan.tentieuchuan}
							<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level collapse">
							<c:forEach items="${tieuChi }" var="tieuchi">
								<c:if
									test="${tieuchi.tieuchuan.id_tieuchuan eq tieuchuan.id_tieuchuan }">
									<li><a
										href="/KiemDinhUTT/utt/danhgia?id_tieuchi=${tieuchi.id_tieuchi }">${tieuchi.tentieuchi }</a></li>
								</c:if>
							</c:forEach>
						</ul> <!-- /nav-second-level --></li>
				</c:forEach>
				<li><p
						style="margin-left: 20px; color: yellow; font-weight: bold; margin-bottom: 10px;">PHẦN
						III: PHỤ LỤC</p></li>
				<c:forEach items="${phulucList }" var="phulucList">
					<li><a href="noi-dung-danh-gia-PHAN31PHULUC1"><i
							class="fa fa-angle-double-right nav_icon"></i>${phulucList.tenphuluc }:${phulucList.tieude_phuluc }</a></li>
				</c:forEach>

			</ul>
			<!-- //sidebar-collapse -->
		</nav>
	</div>
</div>
<!--left-fixed -navigation-->
<!-- header-starts -->
<div class="sticky-header header-section ">
	<div class="header-left">
		<!--toggle button start-->
		<button id="showLeftPush">
			<i class="fa fa-bars"></i>
		</button>
		<!--toggle button end-->
		<!--logo -->
		<div class="logo">
			<a href="#">
				<h1>BÁO CÁO TỰ ĐÁNH GIÁ KIỂM ĐỊNH</h1> <span>Đại học Công
					Nghệ GTVT</span>
			</a>
		</div>
		<!--//logo-->

		<div class="clearfix"></div>
	</div>
	<div class="header-right">
		<!--notification menu end -->
		<div class="profile_details">
			<ul>
				<li class="dropdown profile_details_drop"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false">
						<div class="profile_img">
							<span class="prfil-img"><img
								style="width: 50px; height: 50px; border-radius: 50%"
								src="${pageContext.request.contextPath }/upload/user/${sessionScope.loginClient.img}"
								alt=""> </span>
							<div class="user-name">
								<p>${sessionScope.loginClient.hoten }</p>
							</div>
							<i class="fa fa-angle-down lnr"></i> <i
								class="fa fa-angle-up lnr"></i>
						</div>
				</a>
					<ul class="dropdown-menu drp-mnu">
						<li><a href="/KiemDinhUTT/logout"><i class="fas fa-sign-out-alt"></i>
								Đăng xuất</a></li>

					</ul></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>