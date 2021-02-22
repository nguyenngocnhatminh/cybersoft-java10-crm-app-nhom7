<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<c:set var="user" value="${USER_LOGIN }" scope = "session"></c:set>
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
		<div class="row">
			<div class="col-lg-3">
				<h1 class="h4 mb-1">${user.fullname}</h1>
				<p class="text-muted">${user.email }</p>
				<p>${user.roledes }</p>
				<div class="text-muted d-flex align-items-center">
					<i class="material-icons mr-1">location_on</i>
					<div class="flex">${user.address }</div>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="tab-content">
					<div class="tab-pane active" id="activity">
						<div class="card">
							<div class="px-4 py-3">
								<div class="d-flex mb-1">
									<div class="avatar avatar-sm mr-3">
										<img src="<c:url value = "${user.avatar }" />" alt="Avatar"
											class="avatar-img rounded-circle">
									</div>
									<div class="flex">
										<div class="d-flex align-items-center mb-1">
											<strong class="text-15pt">${user.fullname}</strong> <small
												class="ml-2 text-muted">4 days ago</small>
										</div>
										<div>
											<p>This is what photoshop can do
										</div>

										<a href="" class="card my-3 text-body decoration-0"> <img
											src="assets/images/avatars/photoshopsaga.jpg" alt="image"
											class="rounded card-img-top"> <span
											class="card-footer d-flex flex-column"> <strong>Photoshop</strong>
												<span>Uploaded by someone</span> <span class="text-muted">tuanphan.dev</span>
										</span>
										</a>

										<div class="d-flex align-items-center">
											<a href=""
												class="text-muted d-flex align-items-center decoration-0"><i
												class="material-icons mr-1" style="font-size: inherit;">favorite_border</i>
												2711</a> <a href=""
												class="text-muted d-flex align-items-center decoration-0 ml-3"><i
												class="material-icons mr-1" style="font-size: inherit;">thumb_up</i>
												1911</a>
										</div>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>
		<!-- END Page Content -->
	</div>

	<!-- // END Header Layout Content -->
</body>
</html>