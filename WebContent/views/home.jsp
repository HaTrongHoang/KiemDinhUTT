<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Báo cáo tự đánh giá kiểm định - CSGD</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="BAO CAO TU DANH GIA KIEM DINH CHAT LUONG GIAO DUC" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
















</script>
<!-- Bootstrap Core CSS -->
<link href="/KiemDinhUTT/Content/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- Custom CSS -->
<link href="/KiemDinhUTT/Content/style.css" rel='stylesheet'
	type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="/KiemDinhUTT/Content/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js-->
<script src="/KiemDinhUTT/Scripts/jquery-1.11.1.min.js"></script>
<script src="/KiemDinhUTT/Scripts/modernizr.custom.js"></script>
<!--webfonts-->
<!--//webfonts-->
<!--animate-->
<link href="/KiemDinhUTT/Content/animate.css" rel="stylesheet"
	type="text/css" media="all">
<script src="/KiemDinhUTT/Scripts/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="/KiemDinhUTT/Scripts/metisMenu.min.js"></script>
<script src="/KiemDinhUTT/Scripts/custom.js"></script>
<link href="/KiemDinhUTT/Content/custom.css" rel="stylesheet">
<!--//Metis Menu -->

<link rel='shortcut icon' type='image/x-icon' href='Images/a.png' />

</head>
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<jsp:include page="/views/common/header.jsp"></jsp:include>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">





			<div class="main-page">


				<div class="row">
					<div class="col-md-4 compose-left">
						<div class="folder widget-shadow">
							<ul>
								<li class="head">TỔNG QUÁT VỀ CƠ SỞ GIÁO DỤC</li>
								<c:forEach items="${tongquatList }" var="tongquatList">
									<li><a
										href="/KiemDinhUTT/utt/tongquat?id_tongquat=${ tongquatList.id_tongquat}"><i
											class="fa fa-flag-o"></i>${ tongquatList.tieude_tongquat}</a></li>
								</c:forEach>
							</ul>


						</div>
					</div>
					<c:forEach items="${tieuChuan }" var="tieuchuan">
						<div class="col-md-4 compose-left">
							<div class="folder widget-shadow">
								<ul>
									<li class="head">${tieuchuan.tentieuchuan }</li>
									<c:forEach items="${tieuChi }" var="tieuchi">
										<c:if
											test="${tieuchi.tieuchuan.id_tieuchuan eq tieuchuan.id_tieuchuan }">
											<li><a
												href="/KiemDinhUTT/utt/danhgia?id_tieuchi=${tieuchi.id_tieuchi }"><i
													class="fa fa-flag-o"></i>${tieuchi.tentieuchi }</a></li>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</div>
					</c:forEach>
					<div class="col-md-4 compose-left">
						<div class="folder widget-shadow">
							<ul>
								<li class="head">PHỤ LỤC</li>
								<c:forEach items="${phulucList }" var="phulucList">
									<li><a
										href="/KiemDinhUTT/utt/phuluc?id_phuluc=${phulucList.id_phuluc}"><i
											class="fa fa-flag-o"></i>${phulucList.tenphuluc }:${phulucList.tieude_phuluc }
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>



		</div>
		<!--footer-->
		<div class="footer">
			<p class="agileits">
				Đại học Công Nghệ GTVT | Websites <a href="http://utt.edu.vn"
					target="_blank">UTT</a>
			</p>
		</div>
		<!--//footer-->
	</div>
	<!-- Classie -->
	<script src="/KiemDinhUTT/Scripts/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'), showLeftPush = document
				.getElementById('showLeftPush'), body = document.body;

		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};

		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
	<!--scrolling js-->
	<script src="/KiemDinhUTT/Scripts/jquery.nicescroll.js"></script>
	<script src="/KiemDinhUTT/Scripts/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
	<script src="/KiemDinhUTT/Scripts/bootstrap.js"></script>
</body>
</html>
