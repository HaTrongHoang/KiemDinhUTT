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

<link rel='shortcut icon' type='image/x-icon' href='../Images/a.png' />

</head>
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<jsp:include page="/views/common/header.jsp"></jsp:include>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<h3 class="title1">${phuluc.tenphuluc }:${phuluc.tieude_phuluc }</h3>
			<div class="main-page general">
				<div class="panel-info widget-shadow">

					<div class="col-md-12 panel-grids">
						<div class="panel panel-success" style="margin-bottom: 10px;">
							<div class="panel-body">
								<div class="panel-heading"
									style="color: white; background-color: red;">
									<h3 class="panel-title"
										style="font-weight: bold; font-size: 18px;">Nội dung</h3>
								</div>
								<div class="panel-body">${phuluc.noidung_phuluc }</div>
							</div>
						</div>
					</div>
					<!--  <div class="col-md-3 panel-grids">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title"
									style="font-weight: bold; font-size: 18px;">Tài liệu</h3>
							</div>
							<ul>
								<c:forEach items="${mcList }" var="mcList">
									<li>

										<div class="chat-right"
											style="width: 240px; word-wrap: break-word;">

											<a class="fa fa-file"
												href="${pageContext.request.contextPath }/upload/file/${mcList.tenfile }"
												target="_blank">${mcList.tenfile }</a>

										</div>

										<div class="clearfix"></div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>-->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!--footer-->
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
		var editor = CKEDITOR.replace('editor');
		CKFinder.setupCKEditor(editor, '/KiemDinhUTT/Scripts/ckfinder/');
	</script>
	<script src="/KiemDinhUTT/Scripts/ckeditor/ckeditor.js"></script>
	<script src="/KiemDinhUTT/Scripts/ckfinder/ckfinder.js"></script>
	<!--scrolling js-->

	<script src="/KiemDinhUTT/Scripts/jquery.nicescroll.js"></script>
	<script src="/KiemDinhUTT/Scripts/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
	<script src="/KiemDinhUTT/Scripts/bootstrap.js"></script>
</body>
</html>