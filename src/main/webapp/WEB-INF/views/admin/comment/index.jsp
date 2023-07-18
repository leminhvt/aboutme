<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý bình luận</div>
		</div>
	</div>
	<hr>
	${msg}
	<div class="row">
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên Tin</th>
						<th>Người bình luận</th>
						<th>Nội dung</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty listC }">
							<c:forEach items="${listC}" var="comment">
								<tr class="odd gradeX">
									<td>${comment.id_cmt}</td>
									<td>${comment.news.tentin}</td>
									<td>${comment.user}</td>
									<td>${comment.noidung}</td>
									<td class="center text-center"><a
										onclick="return confirm('Bạn có muốn xóa ${comment.news.tentin}')"
										href="${pageContext.request.contextPath}/admin/comment/del/${comment.id_cmt}"
										title="" class="btn btn-danger"><span
											class="glyphicon glyphicon-trash"></span> Xóa</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<td>Không có tin tức nào</td>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.row -->
</div>