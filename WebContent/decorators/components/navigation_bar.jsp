<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.cybersoft.nhom7.util.Path"%>
<div class="page__header mb-0">
	<div class="container page__container">
		<div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
			<button class="navbar-toggler navbar-toggler-right"
				data-toggle="collapse" data-target="#navbarsExample03" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="navbar-collapse collapse" id="navbarsExample03">
				<ul class="nav navbar-nav flex">
					<li class="nav-item"><a class="nav-link active"
						href="<c:url value="<%-- <%=Path.HOME %> --%>" />"> Dashboard
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() + Path.ROLE_INDEX%>">Role</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() + Path.USER_INDEX%>">User</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath() + Path.PROJECT_INDEX%>">Project</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Task</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
