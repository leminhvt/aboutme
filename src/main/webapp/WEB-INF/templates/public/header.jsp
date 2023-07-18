<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<nav
	class="navbar fixed-top shadow-sm navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-lg-5">
	<a href="${pageContext.request.contextPath}/" class="navbar-brand ml-lg-3">
		<h1 class="m-0 display-5">
			<span class="text-primary">About</span>me
		</h1>
	</a>
	<button type="button" class="navbar-toggler" data-toggle="collapse"
		data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse px-lg-3" id="navbarCollapse">
		<div class="navbar-nav m-auto py-0">
			<a href="#home" class="nav-item nav-link active">Home</a> <a
				href="#about" class="nav-item nav-link">About</a> <a
				href="#qualification" class="nav-item nav-link">Quality</a> <a
				href="#skill" class="nav-item nav-link">Skill</a> <a href="#blog"
				class="nav-item nav-link">Blog</a> <a href="#contact"
				class="nav-item nav-link">Contact</a>
		</div>
		<a href="" class="btn btn-outline-primary d-none d-lg-block">Hire
			Me</a>
	</div>
</nav>