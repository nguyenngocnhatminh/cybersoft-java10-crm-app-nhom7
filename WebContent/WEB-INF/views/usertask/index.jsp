<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.cybersoft.nhom7.util.Path"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Quản lý công việc</title>
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
							<li class="breadcrumb-item active" aria-current="page">User</li>
						</ol>
					</nav>
					<h1 class="m-0">Quản lý công việc</h1>
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
									<th ><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Tên</a></th>
									<th><a href="javascript:void(0)" class="sort"
										data-sort="js-lists-values-employee-title">Mô tả</a></th>
									<th>Ngày bắt đầu</a></th>
									<th>Ngày kết thúc</th>
									<th>Người tạo</th>
									<th>Loại công việc</th>
									<th>Trạng thái</th>
									<th>Xem chi tiết</th>
								</tr>
							</thead>
							<tbody class="list" id="staff">
							<c:forEach items = "${task }" var = "item">
									<tr class="selected">
										<td>${item.name }</td>
										<td>${item.description }</td>
										<td>${item.startdate }</td>
										<td>${item.enddate }</td>
										<td>${item.username }</td>
										<td>${item.categorydes }</td>
										<td>${item.statusdes }</td>
									<td><a
										href="<%=request.getContextPath() + Path.TASK_INDEX%>?projectid=${item.projectid}"
										class="text-muted"><i class="fas fa-eye"></i></a></td>
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