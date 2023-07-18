<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row content" style="margin-top: 40px">
	<div class="col-sm-3 sidenav">


		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href=""
				style="background-color: #003322; font-size: 20px; color: white; border-radius: 10px; margin-left: 20px">Bài
					viết xem nhiều</a></li>
			<c:choose>
				<c:when test="${not empty listN}">
					<c:forEach items="${listN}" var="news">
						<li style="margin-left: 15px"><a href=""> <img
								width="100%" height=""
								src="${pageContext.request.contextPath}/files/${news.hinhanh}"
								alt="">
						</a>
							<h5 style="margin-left: 10%">
								<span class="glyphicon glyphicon-eye-open"></span>Lượt
								đọc:${news.cout}.
							</h5> <a
							style="width: 100% !important; padding: none; font-size: 16px"
							href="${pageContext.request.contextPath}/blog/${news.id_tin}">${news.tentin}</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					Không có bài viết xem nhiều
				</c:otherwise>
			</c:choose>
		</ul>
		<br>
	</div>

	<div class="col-sm-6">

		<br>
		<h2 style="color: #003322">${category.tendanhmuc}</h2>
		<hr>
		<c:choose>
			<c:when test="${not empty listNN}">
				<c:forEach items="${listNN}" var="newnew">
					<div class="news-item">
						<a href="${pageContext.request.contextPath}/blog/${newnew.id_tin}"><img
							src="${pageContext.request.contextPath}/files/${newnew.hinhanh}"
							class="img-responsive" style="width: 100%; height: 180px"
							alt="Image"><br>
							<h3 style="height: 50px; font-size: 20px">${newnew.tentin}</h3> <br>
							<br> </a>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				không có tin tức nào
			</c:otherwise>
		</c:choose>


		<div class="clearfix"></div>
	</div>
	<div class="col-sm-3">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#section1"
				style="background-color: #003322; font-size: 20px; color: white; border-radius: 10px">Danh
					mục bài viết</a></li>
			<c:choose>
				<c:when test="${not empty listC}">
					<c:forEach items="${listC}" var="cat">
						<c:choose>
							<c:when test="${idCat == cat.id}">
								<li><a
									style="font-size: 16px; color: black; border-radius: 10px; background-color: #ffdb3a;"
									href="${pageContext.request.contextPath}/cat/${cat.id}">${cat.tendanhmuc}</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									style="font-size: 16px; color: black; border-radius: 10px"
									href="${pageContext.request.contextPath}/cat/${cat.id}">${cat.tendanhmuc}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:when>
				<c:otherwise>
					không có danh mục nào
				</c:otherwise>
			</c:choose>
		</ul>
		<br>
	</div>
</div>
