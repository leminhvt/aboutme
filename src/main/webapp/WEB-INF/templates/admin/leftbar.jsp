<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="col-md-2">
	<div class="sidebar content-box" style="display: block;">
		<!-- Nav-bar -->
		<ul class="nav">
			<!-- Main menu -->
			<security:authorize
				access="hasAnyRole('ROLE_ADMIN','ROLE_EDITOR','ROLE_USER')">
				<li class="current"><a
					href="${pageContext.request.contextPath}/admincp"><i
						class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
			</security:authorize>

			<security:authorize access="hasAnyRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/cat/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý danh mục</a></li>
			</security:authorize>

			<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_EDITOR')">
				<li><a
					href="${pageContext.request.contextPath}/admin/new/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý tin tức</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/comment/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý bình luận</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/user/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý người dùng</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/contact/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý liên hệ</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/information/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý thông tin</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/skill/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý kỹ năng</a></li>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/project/index"><i
						class="glyphicon glyphicon-list"></i> Quản lý dự án</a></li>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a
					href="${pageContext.request.contextPath}/admin/manage/index"><i
						class="glyphicon glyphicon-list"></i>Quản lý chặng đường</a></li>
			</security:authorize>

			<li class="submenu"><a href="#"> <i
					class="glyphicon glyphicon-list"></i> Pages <span
					class="caret pull-right"></span>
			</a> <!-- Sub menu -->
				<ul>
					<li><a href="${pageContext.request.contextPath}/auth/logout">Login</a></li>
					<li><a href="javascript:void(0)">Signup</a></li>
				</ul></li>
		</ul>
		<!-- /.nav-bar -->
	</div>
</div>