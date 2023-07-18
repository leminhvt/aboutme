<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm tin tức</div>
		</div>
		<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/new/add"
				method="post" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên tin</label> <input type="text"
									class="form-control" placeholder="Nhập tên tin" name="tentin">
									<form:errors path="new.tentin"></form:errors>
							</div>
							<div class="form-group">
								<label>Danh mục tin</label> <select name="id"
									class="form-control">
									<c:choose>
										<c:when test="${not empty listC }">
											<c:forEach items="${listC}" var="cat">
												<option value="${cat.id}">${cat.tendanhmuc}</option>
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
							</div>
							<div class="form-group">
								<label for="name">Nội dung</label> <input type="text"
									class="form-control" id="noidung" placeholder="" name="noidung">
							</div>
							<form:errors path="new.noidung"></form:errors>
							<script type="text/javascript">
								var editor = CKEDITOR.replace('noidung');
							</script>

						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-sm-12">
							<input type="submit" value="Thêm" class="btn btn-success" /> <input
								type="reset" value="Nhập lại" class="btn btn-default" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>