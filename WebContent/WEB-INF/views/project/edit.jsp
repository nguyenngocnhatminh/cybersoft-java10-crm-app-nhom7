<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa dự án</title>
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
								edit</li>
						</ol>
					</nav>
					<h1 class="m-0">Chỉnh sửa dự án</h1>
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
			<form action="<%=request.getContextPath() + Path.PROJECT_EDIT%>"
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
						<input type = "hidden" name ="id" value = "${project.id }">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="fname">Tên dự án</label> <input name="name"
										type="text" class="form-control" value="${project.name }" placeholder="Project name">
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label for="fname">Mô tả</label>
									<input name="description"
										type="text" class="form-control" value ="${project.description }" placeholder="Description">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Ngày bắt đầu</label> <input
										id="flatpickrSample01" type="text" class="form-control"
										placeholder="Flatpickr example" data-toggle="flatpickr"
										name = "startdate" value="${project.startdate }">


								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Ngày kết thúc</label> <input
										id="flatpickrSample01" type="text" class="form-control"
										placeholder="Flatpickr example" data-toggle="flatpickr"
										name ="enddate" value="${project.enddate }">

								</div>
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