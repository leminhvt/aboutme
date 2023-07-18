<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<div class="row content" style="margin-top: 40px">
	<div class="col-sm-3 sidenav">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href=""
				style="background-color: #003322; font-size: 20px; color: white; border-radius: 10px; margin-left: 20px">Bài
					viết xem nhiều</a></li>
			<c:choose>
				<c:when test="${not empty listN}">
					<c:forEach items="${listN}" var="news">
						<li style="margin-left: 15px"><a href=""> <img
								width="100%" height=""
								src="${pageContext.request.contextPath}/files/${news.hinhanh}"
								alt="">
						</a>
							<h5 style="margin-left: 10%">
								<span class="glyphicon glyphicon-eye-open"></span>Lượt
								đọc:${news.cout}.
							</h5> <a
							style="width: 100% !important; padding: none; font-size: 16px"
							href="${pageContext.request.contextPath}/blog/${news.id_tin}">${news.tentin}</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					Không có bài viết xem nhiều
				</c:otherwise>
			</c:choose>
		</ul>
		<br>
	</div>

	<div class="col-sm-6">
		<br>
		<h2 style="color: #003322">${newnew.category.tendanhmuc}</h2>
		<hr>
		<h2 id="view">${newnew.tentin}</h2>
		<br>
		<h5 class="abc-${newnew.id_tin}">
			<span class="glyphicon glyphicon-eye-open"></span>Lượt
			đọc:${newnew.cout}.
		</h5>
		<br>
		<p></p>
		<p>${newnew.noidung}</p>

		<br>
		<div class="hidden-form">
			<h2 style="color: #003322">Tham gia bình luận:</h2>
			<br> <i class="er" style="color: red"> </i>
			<form action="javascript:void(0)" method="post">
				<div class="form-group">
					<input style="margin-bottom: 0.5%; border-radius: 3px" id="user"
						type="text" name="user" placeholder="nhập tên của bạn" required=""
						value="" fdprocessedid="9ngjq">
					<textarea class="form-control" name="noidung" id="noidung"
						placeholder="nhập bình luận" rows="3"></textarea>


				</div>
				<button type="submit" class="btn btn-success" fdprocessedid="o1ppj"
					onclick="return getProductInfo(${newnew.id_tin})">Gửi bình
					luận</button>
			</form>
		</div>
		<br> <br>
		<div class="show-cmt">
			<h2 style="color: #003322">Comment</h2>
			<br>
			<div class="rowrow">
				<c:choose>
					<c:when test="${not empty comments}">
						<c:forEach items="${comments}" var="comment">
							<div class="col-sm-2 text-center">
								<h4>${comment.user}</h4>
							</div>
							<div class="col-sm-10">
								<p>${comment.noidung}</p>
								<p>${comment.ngayBL}</p>
								<br>
							</div>
							<div class="clearfix"></div>

						</c:forEach>
					</c:when>
					<c:otherwise>
					Không có bình luận nào
				</c:otherwise>
				</c:choose>
			</div>
		</div>
		<br>
		<h2 style="color: #003322">BÀI VIẾT CÙNG CHUYÊN MỤC</h2>
		<div class="row">
			<c:choose>
				<c:when test="${not empty listNN}">
					<c:forEach items="${listNN}" var="newone">
						<div class="col-sm-4">
							<a onclick="return getActive(${newone.id_tin})"
								href="${pageContext.request.contextPath}/blog/${newone.id_tin}">
								<img
								src="${pageContext.request.contextPath}/files/${newone.hinhanh}"
								class="img-responsive" style="width: 100%; height: 180px"
								alt="Image"><br>
								<h3>${newone.tentin}</h3> <br> <br>
							</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="col-sm-3">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#section1"
				style="background-color: #003322; font-size: 20px; color: white; border-radius: 10px">Danh
					mục bài viết</a></li>
			<c:choose>
				<c:when test="${not empty listC}">
					<c:forEach items="${listC}" var="cat">
						<c:choose>
							<c:when test="${idCat == cat.id}">
								<li><a
									style="font-size: 16px; color: black; border-radius: 10px ;background-color: #ffdb3a;"
									href="${pageContext.request.contextPath}/cat/${cat.id}">${cat.tendanhmuc}</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									style="font-size: 16px; color: black; border-radius: 10px"
									href="${pageContext.request.contextPath}/cat/${cat.id}">${cat.tendanhmuc}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:when>
				<c:otherwise>
					không có danh mục nào
				</c:otherwise>
			</c:choose>
		</ul>
		<br>
	</div>
</div>
<script type="text/javascript">
function getProductInfo(id_tin){
	var name = $("#user").val();
	var cmt =$("#noidung").val();
	$.ajax({
		url: '<%=request.getContextPath()%>/xuly-comment',
			type : 'POST',
			cache : false,
			data : {
				user: name,
				noidung : cmt,
				id_tin :id_tin
			},
			success : function(data) {
				$(".rowrow").html(data);
			},
			error : function() {
				alert('Có lỗi xảy ra');
			}
		});
		return false;

	}
</script>
