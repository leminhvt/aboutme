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
				action="${pageContext.request.contextPath}/admin/information/add"
				method="post">
				<div>
					<div class="row mb-10"></div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="name">Họ và tên </label> <input type="text"
									id="name" value="" name="name" class="form-control" />
								<form:errors path="information.name"></form:errors>
							</div>
							<div class="form-group">
								<label for="birthday">Ngày sinh</label> <input
									class="form-control" type="date" name="ngaysinh" value="">
								<form:errors path="information.ngaysinh"></form:errors>
							</div>
							<div class="form-group">
								<label for="email">Email</label> <input type="text" id="email"
									value="" name="email" class="form-control" />
								<form:errors path="information.email"></form:errors>
							</div>
							<div class="form-group">
								<label for="address">Địa chỉ</label> <input type="text"
									id="address" value="" name="diachi" class="form-control" />
								<form:errors path="information.diachi"></form:errors>
							</div>
							<div class="form-group">
								<label for="phone">Số điện thoại</label> <input type="text"
									id="phone" value="" name="sdt" class="form-control" />
								<form:errors path="information.sdt"></form:errors>
							</div>
							<div class="form-group">
								<label for="introduce">Nội dung</label>
								<textarea id="detail" class="form-control" rows="3"
									name="noidung"></textarea>
								<form:errors path="information.noidung"></form:errors>
							</div>
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