<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Sửa chặng đường</div>
		</div>
		<div class="content-box-large box-with-header">
			<form action="${pageContext.request.contextPath}/admin/manage/edit/${manage.id}"
				method="post">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Tên chặng đường</label> 
								<input type="text" class="form-control" placeholder="Nhập tên chặng đường" name="ten" value="${manage.ten}">
							</div>
							<div class="form-group">
								<label for="name">Thời gian</label> 
								<input type="text" class="form-control" placeholder="Nhập thời gian" name="thoigian" value="${manage.thoigian}">
							</div>
							<div class="form-group">
								<label for="name">Phân loại</label> 
								<input type="text" class="form-control" placeholder="Nhập phân loại" name="phanloai" value="${manage.phanloai}">
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