<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- HEADER MOBILE-->
<header class="header-mobile d-block d-lg-none">
	<div class="header-mobile__bar">
		<div class="container-fluid">
			<div class="header-mobile-inner">
				<a class="logo" href="/KiemDinhUTT/admin/home"> <img
					src="/KiemDinhUTT/Images/logo.png" alt="UTT" />
				</a>
				<button class="hamburger hamburger--slider" type="button">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
				</button>
			</div>
		</div>
	</div>
	<nav class="navbar-mobile">
		<div class="container-fluid">
			<ul class="navbar-mobile__list list-unstyled">
				<!--  <li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-tachometer-alt"></i>Dashboard
				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a href="index.html">Dashboard 1</a></li>
						<li><a href="index2.html">Dashboard 2</a></li>
						<li><a href="index3.html">Dashboard 3</a></li>
						<li><a href="index4.html">Dashboard 4</a></li>
					</ul></li>
				<li><a href="chart.html"> <i class="fas fa-chart-bar"></i>Charts
				</a></li>-->
				<li><a href="/KiemDinhUTT/kiemdinh/taikhoan"> <i
						class="zmdi zmdi-account-calendar"></i>Quản lý tài khoản
				</a></li>

				<li><a href="/KiemDinhUTT/kiemdinh/tieuchuan"> <i
						class="fa fa-bars" aria-hidden="true"></i> Quản lý tiêu chuẩn
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/phuluc"> <i
						class="fa fa-bars" aria-hidden="true"></i> Quản lý phụ lục
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/tongquat"> <i
						class="fa fa-bars" aria-hidden="true"></i> Tổng quat
				</a></li>
				<!-- <li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-copy"></i>Pages
				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a href="login.html">Login</a></li>
						<li><a href="register.html">Register</a></li>
						<li><a href="forget-pass.html">Forget Password</a></li>
					</ul></li>
				<li class="has-sub"><a class="js-arrow" href="#"> <i
						class="fas fa-desktop"></i>UI Elements
				</a>
					<ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
						<li><a href="button.html">Button</a></li>
						<li><a href="badge.html">Badges</a></li>
						<li><a href="tab.html">Tabs</a></li>
						<li><a href="card.html">Cards</a></li>
						<li><a href="alert.html">Alerts</a></li>
						<li><a href="progress-bar.html">Progress Bars</a></li>
						<li><a href="modal.html">Modals</a></li>
						<li><a href="switch.html">Switchs</a></li>
						<li><a href="grid.html">Grids</a></li>
						<li><a href="fontawesome.html">Fontawesome Icon</a></li>
						<li><a href="typo.html">Typography</a></li>
					</ul></li>-->
			</ul>
		</div>
	</nav>
</header>
<!-- END HEADER MOBILE-->

<!-- MENU SIDEBAR-->
<aside class="menu-sidebar d-none d-lg-block">
	<div class="logo">
		<a href="/KiemDinhUTT/admin/home"> <img
			src="/KiemDinhUTT/Images/logo.png" alt="UTT" />
		</a>
	</div>
	<div class="menu-sidebar__content js-scrollbar1">
		<nav class="navbar-sidebar">
			<ul class="list-unstyled navbar__list">
				<li><a href="/KiemDinhUTT/kiemdinh/taikhoan"> <i
						class="zmdi zmdi-account-calendar"></i>Quản lý tài khoản
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/tieuchuan"> <i
						class="fa fa-bars" aria-hidden="true"></i> Quản lý tiêu chuẩn
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/phuluc"> <i
						class="fa fa-bars" aria-hidden="true"></i> Quản lý phục lục
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/tongquat"> <i
						class="fa fa-bars" aria-hidden="true"></i> Quản lý tổng quát
				</a></li>
				<li><a href="/KiemDinhUTT/kiemdinh/phancong"> <i
						class="fa fa-bars" aria-hidden="true"></i> Phân công
				</a></li>
			</ul>
		</nav>
	</div>
</aside>
<!-- END MENU SIDEBAR-->

<!-- PAGE CONTAINER-->
<div class="page-container">
	<!-- HEADER DESKTOP-->
	<header class="header-desktop">
		<div class="section__content section__content--p30">
			<div class="container-fluid">
				<div class="header-wrap">
					<form class="form-header" action="" method="POST"></form>
					<div class="header-button ">
						<div class="account-wrap">
							<div class="account-item clearfix js-item-menu">
								<div>
									<div class="image">
										<img
											src="${pageContext.request.contextPath }/upload/user/${sessionScope.loginTaiKhoan.img}"
											alt="${sessionScope.loginTaiKhoan.hoten}" />
									</div>
									<label> ${sessionScope.loginTaiKhoan.hoten}</label>
								</div>
								<div class="account-dropdown js-dropdown">
									<div class="info clearfix">
										<!--  <div class="content">
											<h5 class="name">
												<a href="#"></a>
											</h5>
										</div>-->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- HEADER DESKTOP-->