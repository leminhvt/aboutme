<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Sửa tin tức</div>
		</div>
		<div class="content-box-large box-with-header">
			<form
				action="${pageContext.request.contextPath}/admin/new/edit/${land.id_tin}"
				method="post" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên tin</label> <input type="text"
									value="${land.tentin}" class="form-control"
									placeholder="Nhập tên tin" name="tentin">
							</div>
							<div class="form-group">
								<label>Danh mục tin</label> <select name="id"
									class="form-control">
									<c:choose>
										<c:when test="${not empty listC }">
											<c:forEach items="${listC}" var="cat">
												<c:choose>
													<c:when test="${cat.id == land.category.id}">
														<option selected="selected" value="${cat.id}">${cat.tendanhmuc}</option>
													</c:when>
													<c:otherwise>
														<option value="${cat.id}">${cat.tendanhmuc}</option>
													</c:otherwise>
												</c:choose>

											</c:forEach>
										</c:when>
										<c:otherwise>
											<option>Không có danh mục nào</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							<div class="form-group">
								<label>Thêm hình ảnh</label> <input name="picture" type="file"
									class="btn btn-default" id="exampleInputFile1">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
								<p>
									<img style="width: 100px"
										src="${pageContext.request.contextPath}/files/${land.hinhanh}">
								</p>
							</div>
							<div class="form-group">
								<label for="name">Nội dung</label> <input type="text"
									value="${land.noidung}" class="form-control" placeholder=""
									name="noidung" id="noidung">
							</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Sửa" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>