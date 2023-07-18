<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<c:choose>
	<c:when test="${not empty comments}">
		<c:forEach items="${comments}" var="comment">
			<div class="rowrow">
				<div class="col-sm-2 text-center">
					<h4>${comment.user}</h4>
				</div>
				<div class="col-sm-10">
					`
					<p>${comment.noidung}</p>
					<p>${comment.ngayBL}</p>
					<br>
				</div>
				<div class="clearfix"></div>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
		Không có bình luận nào
	</c:otherwise>
</c:choose>