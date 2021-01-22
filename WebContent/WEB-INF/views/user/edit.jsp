<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa người dùng</title>
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
					<h1 class="m-0">Chỉnh sửa người dùng</h1>
				</div>
				<div class="ml-auto">
					<a href="<%=request.getContextPath() + Path.USER_INDEX%>"
						class="btn btn-light"> Quay lại</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<form action="<%=request.getContextPath() + Path.USER_ADD%>"
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
							<div class="col-md-6">
								<div class="form-group">
									<label>Avatar</label>
									<div class="dz-clickable media align-items-center"
										data-toggle="dropzone" data-dropzone-url="http://"
										data-dropzone-clickable=".dz-clickable"
										data-dropzone-files='["<%=request.getContextPath()%>/assets/images/account-add-photo.svg"]'>
										<div class="dz-preview dz-file-preview dz-clickable mr-3">
											<div class="avatar" style="width: 80px; height: 80px;">
												<img
													src="<%=request.getContextPath()%>/assets/images/account-add-photo.svg"
													class="avatar-img rounded" alt="..." data-dz-thumbnail>
											</div>
										</div>
										<div class="media-body">
											<button class="btn btn-sm btn-primary dz-clickable"  >Choose
												photo</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Tên đăng nhập</label> <input name="username"
										type="text" class="form-control" placeholder="Username">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Mật khẩu</label> <input name="password"
										type="password" class="form-control" placeholder="Username">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Email</label> <input name="email"
										type="text" class="form-control" placeholder="Email">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Họ tên</label> <input name="fullname"
										type="text" class="form-control" placeholder="Full name">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Địa chỉ</label> <input name="address"
										type="text" class="form-control" placeholder="Address">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Số điện thoại</label> <input name="sdt"
										type="text" class="form-control" placeholder="Email">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Quyền</label> <select name="roleid"
										class="form-control">
										<option value="">Quản trị hệ thống</option>
									</select>
								</div>
							</div>

						</div>

						<div class="row">
							<button type="submit" class="btn btn-light">Hoàn tất</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>