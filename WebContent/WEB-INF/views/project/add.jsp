<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo mới dự án</title>
<link rel="shortcut icon"
	href="<c:url value ="/assets/images/favicon.ico"/>" />

<!-- Perfect Scrollbar -->
<link type="text/css"
	href="<c:url value ="/assets/vendor/perfect-scrollbar.css"/>"
	rel="stylesheet" />

<!-- App CSS -->
<link type="text/css" href="<c:url value ="/assets/css/app.css"/>"
	rel="stylesheet" />
<link type="text/css" href="<c:url value ="/assets/css/app.rtl.css"/>"
	rel="stylesheet" />

<!-- Material Design Icons -->
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-material-icons.css"/>"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-material-icons.rtl.css"/>"
	rel="stylesheet" />

<!-- Font Awesome FREE Icons -->
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-fontawesome-free.css"/>"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-fontawesome-free.rtl.css"/>"
	rel="stylesheet" />

<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr.css"/>"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr.rtl.css"/>"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr-airbnb.css"/>"
	rel="stylesheet" />
<link type="text/css" href="/assets/css/vendor-flatpickr-airbnb.rtl.css"
	rel="stylesheet" />

<!-- Flatpickr -->
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr.rtl.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr-airbnb.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr-airbnb.rtl.css"/>"
	rel="stylesheet">

<!-- DateRangePicker -->
<link type="text/css"
	href="<c:url value ="/assets/vendor/daterangepicker.css"/>"
	rel="stylesheet">

<!-- Quill Theme -->
<link type="text/css"
	href="<c:url value = "/assets/css/vendor-quill.css"/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value ="assets/css/vendor-quill.rtl.css"/>"
	rel="stylesheet">

<link rel="stylesheet"
	href="<c:url value ="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"/>">
<script src="<c:url value ="https://code.jquery.com/jquery-3.2.1.slim.min.js"/>"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="<c:url value ="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"/>"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="<c:url value ="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"/>"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">User</li>
							<li class="breadcrumb-item active" aria-current="page">User
								add</li>
						</ol>
					</nav>
					<h1 class="m-0">Thêm mới dự án</h1>
				</div>
				<div class="ml-auto">
					<a href="<%=request.getContextPath() + Path.PROJECT_INDEX%>"
						class="btn btn-light"> Quay lại</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<form action="<%=request.getContextPath() + Path.PROJECT_ADD%>"
				method="post">
				<div class="row no-gutters">
					<div class="col-lg-12 card-form__body card-body">
						<%
							if (request.getAttribute("message") != null) {
						%>
						<h3 class="text-danger"><%=request.getAttribute("message")%></h3>
						<%
							}
						%>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="fname">Tên dự án</label> <input name="name"
										type="text" class="form-control" placeholder="Project name">
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="fname">Mô tả</label>
									<div style="height: 150px;" data-toggle="quill"
										data-quill-placeholder="Description"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Ngày bắt đầu</label> <input
										id="flatpickrSample01" name="startdate" type="text"
										class="form-control" placeholder="Start date"
										data-toggle="flatpickr" value="">

								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Ngày kết thúc</label><input
										id="flatpickrSample01" name="enddate" type="text"
										class="form-control" placeholder="End date"
										data-toggle="flatpickr" value="">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="fname">Thành viên</label> <input list="members"
										id="members" class="form-control">
									<datalist id="members">
										<option value="Edge">
										<option value="Firefox">
										<option value="Chrome">
										<option value="Opera">
										<option value="Safari">
									</datalist>
									<input type='button' value='Thêm thành viên' id='add' />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<input class="form-control" placeholder="Members" id="member"
									name="member">
							</div>
							
						</div>
						<div class="row">
							<div class="col-md-6">
								<button type="submit" class="btn btn-light">Hoàn tất</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- App Settings FAB -->
	<div id="app-settings" hidden>
		<app-settings layout-active="fixed"
			:layout-location="{
      'default': 'index.html',
      'fixed': 'dashboard.html',
      'fluid': 'fluid-dashboard.html',
      'mini': 'mini-dashboard.html'}">
		</app-settings>
	</div>

	<!-- jQuery -->
	<script src="<c:url value ="/assets/vendor/jquery.min.js"/>"></script>

	<!-- Bootstrap -->
	<script src="<c:url value ="/assets/vendor/popper.min.js"/>"></script>
	<script src="<c:url value ="/assets/vendor/bootstrap.min.js"/>"></script>

	<!-- Perfect Scrollbar -->
	<script src="<c:url value ="/assets/vendor/perfect-scrollbar.min.js"/>"></script>

	<!-- DOM Factory -->
	<script src="<c:url value ="/assets/vendor/dom-factory.js"/>"></script>

	<!-- MDK -->
	<script src="<c:url value ="/assets/vendor/material-design-kit.js"/>"></script>

	<!-- App -->
	<script src="<c:url value ="/assets/js/toggle-check-all.js"/>"></script>
	<script src="<c:url value ="/assets/js/check-selected-row.js"/>"></script>
	<script src="<c:url value ="/assets/js/dropdown.js"/>"></script>
	<script src="<c:url value ="/assets/js/sidebar-mini.js"/>"></script>
	<script src="<c:url value ="/assets/js/app.js"/>"></script>

	<!-- App Settings (safe to remove) -->
	<script src="<c:url value ="/assets/js/app-settings.js"/>"></script>

	<!-- Flatpickr -->
	<script
		src="<c:url value ="/assets/vendor/flatpickr/flatpickr.min.js"/>"></script>
	<script src="<c:url value ="/assets/js/flatpickr.js"/>"></script>

	<!-- Global Settings -->
	<script src="<c:url value ="/assets/js/settings.js"/>"></script>

	<!-- DateRangePicker -->
	<script src="<c:url value ="/assets/vendor/moment.min.js"/>"></script>
	<script src="<c:url value ="/assets/vendor/daterangepicker.js"/>"></script>
	<script src="<c:url value ="/assets/js/daterangepicker.js"/>"></script>

	<!-- Quill -->
	<script src="<c:url value ="/assets/vendor/quill.min.js"/>"></script>
	<script src="<c:url value ="/assets/js/quill.js"/>"></script>
</body>
</html>