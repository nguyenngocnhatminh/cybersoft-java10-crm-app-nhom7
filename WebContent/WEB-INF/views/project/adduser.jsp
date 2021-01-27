<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.cybersoft.nhom7.util.Path"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Quản lý thành viên của project</title>
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
</head>

<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Project</li>
							<li class="breadcrumb-item active" aria-current="page">Project
								Member</li>
						</ol>
					</nav>
					<h1 class="m-0">Quản lý thành viên của project</h1>
				</div>
				<div class="ml-auto">
					<a href="<%=request.getContextPath() + Path.PROJECT_INDEX%>"
						class="btn btn-light"> Lưu</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<div class="row no-gutters">
				<%
					if (request.getAttribute("message") != null) {
				%>
				<h3 class="text-danger"><%=request.getAttribute("message")%></h3>
				<%
					}
				%>
				<div class="col-lg-12 card-form__body border-left">
					<div class="search-form search-form--light m-3">
						<input type="text" class="form-control search"
							placeholder="Search">
						<button class="btn" type="button">
							<i class="material-icons">search</i>
						</button>
					</div>
					<div class="table-responsive border-bottom" data-toggle="lists"
						data-lists-values='["js-lists-values-employee-name"]'>
						<table class="table mb-0 thead-border-top-0">
							<thead class="bg-white">
								<tr>
									<th style="width: 18px;">
										<div class="custom-control custom-checkbox">
											<input type="checkbox"
												class="custom-control-input js-toggle-check-all"
												data-target="#staff" id="customCheckAll"> <label
												class="custom-control-label" for="customCheckAll"><span
												class="text-hide">Toggle all</span></label>
										</div>
									</th>
									<th><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Nhân viên</a></th>
									<th><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Username</a></th>
									<th><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Email</a></th>
									<th>Ngày tham gia</th>
									<th>Chức vụ</th>
									<th></th>
								</tr>
							</thead>
							<tbody class="list" id="staff">
								<c:forEach items="${userprojects}" var="user">
									<tr class="selected">
										<td>
											<div class="custom-control custom-checkbox">
												<input type="checkbox"
													<c:if test="${user.projectid != 0}">checked</c:if>
													class="custom-control-input js-check-selected-row"
													id="${user.userid }"> <label
													class="custom-control-label" for="${user.userid}"><span
													class="text-hide">Check</span></label>
											</div>
										</td>
										<td>
											<div class="media align-items-center">
												<div class="avatar avatar-xs mr-2">
													<img src="<c:url value="${user.avatar}" />"
														class="avatar-img rounded-circle">
												</div>
												<div class="media-body">

													<span class="js-lists-values-employee-name">${user.userfullname }</span>

												</div>
											</div>

										</td>
										<td>${user.username }</td>
										<td>${user.useremail }</td>
										<td><input id="flatpickrSample01" type="text"
											class="form-control" placeholder="Ngày tham gia"
											data-toggle="flatpickr" name="joindate"
											value="${user.joinDate }"></td>
										<td><input type="text" name="role" value="${user.role}"
											class="form-control"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>
			</div>
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
</body>