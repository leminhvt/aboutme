<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>DỰ ÁN ABOUTME - LÊ MINH</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link
	href="${pageContext.request.contextPath}/publicUrl/img/favicon.ico"
	rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/publicUrl/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/publicUrl/lib/lightbox/css/lightbox.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="${pageContext.request.contextPath}/publicUrl/css/style.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/publicUrl/js/jquery-3.6.4.min.js"></script>
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="51">

	<tiles:insertAttribute name="header"></tiles:insertAttribute>

	<tiles:insertAttribute name="body"></tiles:insertAttribute>

	<tiles:insertAttribute name="footer"></tiles:insertAttribute>

	<!-- Scroll to Bottom -->
	<i class="fa fa-2x fa-angle-down text-white scroll-to-bottom"></i>

	<!-- Back to Top -->
	<a href="#" class="btn btn-outline-dark px-0 back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/typed/typed.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/easing/easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/waypoints/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/isotope/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/lib/lightbox/js/lightbox.min.js"></script>

	<!-- Contact Javascript File -->
	<script
		src="${pageContext.request.contextPath}/publicUrl/mail/jqBootstrapValidation.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/publicUrl/mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="${pageContext.request.contextPath}/publicUrl/js/main.js"></script>
</body>

</html>