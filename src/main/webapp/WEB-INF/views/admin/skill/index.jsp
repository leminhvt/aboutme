<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý kỹ năng</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/skill/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
	</div>
	${msg}
	<div class="row">
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên Kỹ năng</th>
						<th>Giá trị</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty listK }">
							<c:forEach items="${listK}" var="skill">
								<tr class="odd gradeX">
									<td>${skill.id}</td>
									<td>${skill.tenkynang}</td>
									<td>${skill.giatri}</td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/skill/edit/${skill.id}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span>Sửa</a> <a
										onclick="return confirm('Bạn có muốn xóa ${skill.tenkynang}')"
										href="${pageContext.request.contextPath}/admin/skill/del/${skill.id}"
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