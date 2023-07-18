<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý tin tức</div>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="panel-body">
			<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tên tin</th>
						<th>Danh mục</th>
						<th>Hình ảnh</th>
						<th>Trạng thái</th>
						<th>Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty listL }">
							<c:forEach items="${listL}" var="land">
								<tr class="odd gradeX">
									<td>${land.id_tin}</td>
									<td>${land.tentin}</td>
									<td>${land.category.tendanhmuc}</td>
									<td><img style="width: 100px"
										src="${pageContext.request.contextPath}/files/${land.hinhanh}" />
									</td>
									<td>${land.trangthai}</td>
									<td class="center text-center"><a
										href="${pageContext.request.contextPath}/admin/new/edit/${land.id_tin}"
										title="" class="btn btn-primary"><span
											class="glyphicon glyphicon-pencil "></span> Sửa</a> <a
										onclick="return confirm('Bạn có muốn xóa ${land.tentin}')"
										href="${pageContext.request.contextPath}/admin/new/del/${land.id_tin}"
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