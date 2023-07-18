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
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath}/admin/new/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
		<div class="col-sm-6" style="text-align: right;">
			<form method="get"
				action="${pageContext.request.contextPath}/admin/new/search">
				<input type="text" name="search" /> <input type="submit"
					value="Tìm kiếm" />
			</form>
			<br />
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
									<td class="centercenter centercenter-${land.id_tin}"><a
										href="javascript:void(0)"
										onclick="return getActive(${land.id_tin},${land.trangthai})">
											<c:choose>
												<c:when test="${land.trangthai == 1}">
													<img
														src="<%=request.getContextPath()%>/adminUrl/images/active.gif"
														alt="" />
												</c:when>
												<c:otherwise>
													<img
														src="<%=request.getContextPath()%>/adminUrl/images/deactive.gif"
														alt="" />
												</c:otherwise>
											</c:choose>
									</a></td>
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

			<!-- Pagination -->
			<nav class="text-center" aria-label="...">
				<ul class="pagination">
					<c:choose>
						<c:when test="${page == 1}">
							<li class="active"><a href="#"> << </a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/admin/new/index?page=${page - 1}">
									<< </a></li>
						</c:otherwise>
					</c:choose>

					<c:forEach begin="1" end="${numberOfPage}" step="1"
						varStatus="loop">
						<c:choose>
							<c:when test="${loop.count == page}">
								<li class="active"><a
									href="${pageContext.request.contextPath}/admin/new/index?page=${loop.count}">${loop.count}</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="${pageContext.request.contextPath}/admin/new/index?page=${loop.count}">${loop.count}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>

					<c:choose>
						<c:when test="${page == numberOfPage}">
							<li class="active"><a href="#"> >> </a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/admin/new/index?page=${page + 1}">
									>> </a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<!-- /.pagination -->
		</div>
	</div>
	<!-- /.row -->
</div>
<script type="text/javascript">
	function getActive(id,trangthai){
		
		$.ajax({
			url: '<%=request.getContextPath()%>/admin/new/status',
			type: 'POST',
			cache: false,
			data: {
				atrangthai: trangthai,
				aid : id
				},
			success: function(data){
				$(".centercenter-"+id).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
		
	}
		
</script>