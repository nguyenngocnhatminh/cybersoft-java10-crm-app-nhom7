<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Quản lý task</title>
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
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-flatpickr-airbnb.rtl.css"/>"
	rel="stylesheet" />

<!-- Dragula -->
<link type="text/css"
	href="<c:url value ="/assets/vendor/dragula/dragula.min.css"/>"
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
							<li class="breadcrumb-item active" aria-current="page">Task</li>
						</ol>
					</nav>
					<h1 class="m-0">Quản lý task</h1>
				</div>
				<div class="ml-auto">

					<a
						href="<%=request.getContextPath() + Path.TASK_ADD%>?projectid=${projectid}"
						class="btn btn-light"> Tạo task</a>
				</div>
			</div>
		</div>
	</div>
	<div class="trello-container">
		<div class="trello-board page__container" data-toggle="dragula"
			data-dragula-containers='${statustoggledata }'>
			<c:forEach items="${listStatus}" var="status">
				<div class="trello-board__tasks">
					<div class="card bg-light border">
						<div class="card-header card-header-sm bg-white border-primary">
							<h4 class="card-header__title">${status.description }</h4>
						</div>
						<input type="hidden" value="${status.id }">
						<div class="card-body p-2">
							<div class="trello-board__tasks-list card-list"
								id="trello-tasks-${status.id }">
								<c:forEach items="${tasks}" var="task">
									<c:if test="${task.statusid == status.id}">
										<div class="trello-board__tasks-item card shadow-none border">
											<div class="p-3">
												<p class="m-0 d-flex align-items-center">
													<a href="<%=request.getContextPath()+Path.TASK_EDIT%>?id=${task.id}">${task.name}</a> <span
														class="badge badge-light-gray ml-auto">${task.categorydes }</span>
												</p>

												<p class="d-flex align-items-center mb-2 small">
													<i class="material-icons icon-14pt mr-1 text-muted">folder_open</i>
													<span class="text-muted mr-2">Stack</span> <i
														class="material-icons icon-14pt mr-1 text-muted">comment</i>
													<span class="text-muted"><strong>28</strong>
														comments</span>
												</p>
												<div class="media align-items-center">
													<div class="media-left mr-2">

														<div class="avatar avatar-xxs" data-toggle="tooltip"
															data-placement="top" title="${task.username }">
															<img
																src="<c:url value = "${task.useravatar }"/>"
																alt="Avatar" class="avatar-img rounded-circle">
														</div>

													</div>
													<div class="media-body small media-middle"></div>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</div>

							<a href="#" class="btn btn-link text-muted btn-block mt-2">+
								Add Card</a>
						</div>
					</div>
				</div>
			</c:forEach>
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

	<!-- Dragula -->
	<script src="<c:url value ="/assets/vendor/dragula/dragula.min.js"/>"></script>
	<script src="<c:url value ="/assets/js/dragula.js"/>"></script>

</body>
</html>