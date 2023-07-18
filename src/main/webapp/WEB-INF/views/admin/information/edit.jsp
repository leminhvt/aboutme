<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm thông tin</div>
		</div>
		<div class="content-box-large box-with-header">
			<form
				action="${pageContext.request.contextPath}/admin/information/edit/${information.id}"
				method="post">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Họ và tên </label> <input type="text"
									id="name" value="${information.name}" name="name" class="form-control" />
							</div>
							<div class="form-group">
								<label for="birthday">Ngày sinh</label> <input
									class="form-control" type="date" name="ngaysinh" value="${information.ngaysinh}">
							</div>
							<div class="form-group">
								<label for="email">Email</label> <input type="text" id="email"
									value="${information.email}" name="email" class="form-control" />
							</div>
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text"
									id="address" value="${information.diachi}" name="diachi" class="form-control" />
							</div>
							<div class="form-group">
								<label for="phone">Số điện thoại</label> <input type="text"
									id="phone" value="${information.sdt}" name="sdt" class="form-control" />
							</div>
							<div class="form-group">
								<label for="introduce">Nội dung</label>
								<textarea id="detail" class="form-control" rows="3"
									name="noidung">${information.noidung}</textarea>
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