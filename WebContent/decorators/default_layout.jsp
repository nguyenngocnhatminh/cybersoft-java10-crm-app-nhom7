<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
	<head>
	    <meta charset="utf-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	    <title>
	    	<dec:title />
	    </title>
		<jsp:include page="/decorators/components/header.jsp" />
		<dec:head />
	</head>
	
	<body class="layout-fixed">
	    <div class="preloader"></div>
	    <!-- Header Layout -->
	    <div class="mdk-header-layout js-mdk-header-layout">
	        <!-- Header -->
	        <jsp:include page="/decorators/components/header_bar.jsp"></jsp:include>
	        <!-- // END Header -->
	
	        <!-- Header Layout Content -->
	        <div class="mdk-header-layout__content page">
	        	<jsp:include page="/decorators/components/navigation_bar.jsp"></jsp:include>
	            <dec:body />
	        </div>
	        <!-- // END Header Layout Content -->
	    </div>
	    <!-- // END Header Layout -->
	
	    <jsp:include page="/decorators/components/navigation_slide.jsp" />
	    <jsp:include page="/decorators/components/footer.jsp" />

	</body>
</html>