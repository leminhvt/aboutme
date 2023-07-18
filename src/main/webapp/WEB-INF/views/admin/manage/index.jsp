<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý chặng đường</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/manage/add"
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
						<th>Tên</th>
						<th>Thời gian</th>
						<th>Phân loại</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty listM }">
							<c:forEach items="${listM}" var="manage">
								<tr class="odd gradeX">
									<td>${manage.id}</td>
									<td>${manage.ten}</td>
									<td>${manage.thoigian}</td>
									<td>${manage.phanloai}</td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/manage/edit/${manage.id}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span>Sửa</a> <a
										onclick="return confirm('Bạn có muốn xóa ${manage.ten}')"
										href="${pageContext.request.contextPath}/admin/manage/del/${manage.id}"
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