<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<!-- Dropzone -->
<link rel="shortcut icon"
	href="<c:url value = "/assets/images/favicon.ico" />" />

<!-- Perfect Scrollbar -->
<link type="text/css"
	href="<c:url value = "/assets/vendor/perfect-scrollbar.css"/>"
	rel="stylesheet" />

<!-- App CSS -->
<link type="text/css" href="<c:url value ="/assets/css/app.css" />"
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
	href="<c:url value ="/assets/css/vendor-fontawesome-free.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-fontawesome-free.rtl.css" />"
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

<!-- Dropzone -->
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-dropzone.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value ="/assets/css/vendor-dropzone.rtl.css"/>"
	rel="stylesheet">

<script type = "text/javascript">
	function changeAvatar()
	{
		var avatarsrc = document.getElementById("imgAvatar").src;
		document.getElementById("avatar").value = avatarsrc;

	}
</script>

<c:set var="user" value="${USER_LOGIN }" scope="session"></c:set>
</head>
<body>
	<div
		style="padding-bottom: calc(5.125rem/ 2); position: relative; margin-bottom: 1.5rem;">
		<div class="bg-primary" style="min-height: 150px;">
			<div class="d-flex align-items-end container page__container"
				style="position: absolute; left: 0; right: 0; bottom: 0;">
				<div class="avatar avatar-xl">
					<img src="<c:url value = "${user.avatar }" />" alt="avatar"
						class="avatar-img rounded" style="border: 2px solid white;">
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- Page Content -->
		<form method= "post" action ="<%=request.getContextPath()+Path.PROFILE_EDIT%>">
			<div class="row">
				<input type = "hidden" value =${user.id } name = "id">
				<div class="col-lg-3">
					<h1 class="h4 mb-1">${user.fullname}</h1>
					<p class="text-muted">${user.email }</p>
					<p>${user.roledes }</p>
					<div class="text-muted d-flex align-items-center">
						<i class="material-icons mr-1">location_on</i>
						<div class="flex">${user.address }</div>
					</div>
				</div>
				<div class="col-lg-8 card-form__body card-body">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Tên đăng nhập</label> <input name="username"
									type="text" class="form-control" value="${user.username }"
									readonly placeholder="Username">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Mật khẩu</label> <input name="password"
									type="password" class="form-control" placeholder="password">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Email</label> <input name="email" type="text"
									class="form-control" value="${user.email }" readonly
									placeholder="Email">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Họ tên</label> <input name="fullname"
									type="text" class="form-control" value="${user.fullname }"
									placeholder="Full name">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Địa chỉ</label> <input name="address"
									type="text" class="form-control" value="${user.address }"
									placeholder="Address">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Số điện thoại</label> <input name="phone"
									type="text" class="form-control" value="${user.phone }"
									placeholder="Phone">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="fname">Quyền</label> <select name="roleid"
									class="form-control">
									<c:forEach items="${roles}" var="role">
										<option value="${role.id }"
											<c:if test = "${role.id == user.roleid }">selected = "selected" </c:if>>${role.description}</option>
									</c:forEach>
								</select>
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
		<!-- END Page Content -->
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
	<script src="<c:url value = "/assets/js/settings.js" />"></script>

	<!-- Dropzone -->
	<script src="<c:url value = "/assets/vendor/dropzone.min.js"/>"></script>
	<script src="<c:url value = "/assets/js/dropzone.js"/>"></script>
</body>
</html>