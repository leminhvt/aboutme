<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý liên hệ</div>
		</div>
	</div>
	<hr>
	<div class="row">
	</div>
	${msg}
	<div class="row">
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Địa chỉ</th>
						<th>SĐT</th>
						<th>Nội dung</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty listC }">
							<c:forEach items="${listC}" var="contact">
								<tr class="odd gradeX">
									<td>${contact.id}</td>
									<td>${contact.name}</td>
									<td>${contact.email}</td>
									<td>${contact.diachi}</td>
									<td>${contact.sdt}</td>
									<td>${contact.noidung}</td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/contact/send/${contact.id}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span>Liên hệ</a> <a
										onclick="return confirm('Bạn có muốn xóa ${contact.name}')"
										href="${pageContext.request.contextPath}/admin/contact/del/${contact.id}"
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