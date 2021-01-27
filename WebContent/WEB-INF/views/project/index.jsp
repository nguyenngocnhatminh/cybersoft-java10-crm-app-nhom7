<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.cybersoft.nhom7.util.Path"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Quản lý quyền</title>
<link type="text/css"
	href="<c:url value="/assets/css/vendor-flatpickr.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value="/assets/css/vendor-flatpickr.rtl.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value="/assets/css/vendor-flatpickr-airbnb.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value="/assets/css/vendor-flatpickr-airbnb.rtl.css" />"
	rel="stylesheet" />
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
						</ol>
					</nav>
					<h1 class="m-0">Quản lý dự án</h1>
				</div>
				<div class="ml-auto">
					<a href="<%=request.getContextPath() + Path.PROJECT_ADD%>"
						class="btn btn-light"> Tạo mới</a>
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
									<th><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Tên dự án</a></th>
									<th>Mô tả</th>
									<th>Ngày bắt đầu</th>
									<th>Ngày kết thúc</th>
									<th>Người tạo</th>
									<th>Quản lý thành viên</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody class="list" id="staff">
								<c:forEach items="${projects}" var="project">
									<tr class="selected">
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${project.name}</span>

												</div>
											</div>
										</td>
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${project.description}</span>

												</div>
											</div>
										</td>
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${project.startdate}</span>

												</div>
											</div>
										</td>
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${project.enddate}</span>
												</div>
											</div>
										</td>
										<td>
											<div class="media align-items-center">
												<div class="media-body">
													<span class="js-lists-values-employee-name">${project.createusername}</span>
												</div>
											</div>
										</td>
										<td><a class="media align-items-center"
											href="<%=request.getContextPath()+Path.PROJECT_USER%>?id=${project.id}"
											class="text-muted"><i class="fas fa-user"></i></a></td>
										<td><span class="badge badge-warning">${role.description}</span></td>
										<td><a
											href="<%=request.getContextPath()+Path.PROJECT_EDIT%>?id=${project.id}"
											class="text-muted"><i class="fas fa-edit"></i></a></td>
										<td><a
											href="<%=request.getContextPath()+Path.PROJECT_DELETE%>?id=${project.id}"
											class="text-muted"><i class="fas fa-trash-alt"></i></a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


				</div>
			</div>
		</div>
	</div>
</body>