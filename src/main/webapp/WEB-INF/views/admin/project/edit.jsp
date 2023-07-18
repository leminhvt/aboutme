<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Sửa dự án</div>
		</div>
		<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/project/edit/${project.id}"
				method="post" enctype="multipart/form-data">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="tenduan">Tên dự án</label> <input type="text"
									class="form-control" placeholder="Nhập tên dự án" value="${project.tenduan}"
									name="tenduan">
							</div>
							<div class="form-group">
								<label for="link">Link</label> <input type="text"
									class="form-control" placeholder="" name="link" value="${project.link}"> 
							</div>
							<div class="form-group">
								<label>Thêm hình ảnh</label> <input name="picture" type="file"
									class="btn btn-default" id="exampleInputFile1">
								<p class="help-block">
									<em>Định dạng: jpg, png, jpeg,...</em>
								</p>
								<p>
									<img style="width: 100px"
										src="${pageContext.request.contextPath}/files/${project.hinhanh}">
								</p>
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