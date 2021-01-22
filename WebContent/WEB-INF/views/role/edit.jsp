<%@page import="com.cybersoft.nhom7.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo mới quyền</title>
</head>
<body>
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Role</li>
							<li class="breadcrumb-item active" aria-current="page">Role
								add</li>
						</ol>
					</nav>
					<h1 class="m-0">Chỉnh sửa quyền</h1>
				</div>
				<div class="ml-auto">
					<a href="<%=request.getContextPath() + Path.ROLE_INDEX%>"
						class="btn btn-light"> Quay lại</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container page__container">
		<!-- Page Content -->
		<div class="card card-form">
			<form action = "<%=request.getContextPath()+Path.ROLE_EDIT%>" method = "post">
				<div class="row no-gutters">
					<div class="col-lg-12 card-form__body card-body">
					<%if(request.getAttribute("message") != null) {%>
						<h3 class = "text-danger"><%=request.getAttribute("message") %></h3>
					<%} %>
					<input type = "hidden" name = "id" value = "${role.id }">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="fname">Tên quyền</label> <input name="rolename"
										type="text" class="form-control" placeholder="Name" value ="${role.name }">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="lname">Mô tả</label> <input name = "description" type="text"
										class="form-control" placeholder="Description" value = "${role.description }">
								</div>
							</div>
						</div>
						<div class="ml-auto" >
							<button type = "submit"
								class="btn btn-light"> Chỉnh sửa</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>