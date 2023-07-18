<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/templates/taglib.jsp"%>
<!-- Video Modal Start -->
<div class="modal fade" id="videoModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<!-- 16:9 aspect ratio -->
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item" src="" id="video"
						allowscriptaccess="always" allow="autoplay"></iframe>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Video Modal End -->


<!-- Header Start -->
<div
	class="container-fluid bg-primary d-flex align-items-center mb-5 py-5"
	id="home" style="min-height: 100vh;">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-5 px-5 pl-lg-0 pb-5 pb-lg-0">
				<img class="img-fluid w-100 rounded-circle shadow-sm"
					src="${pageContext.request.contextPath}/publicUrl/img/leminh.jpg"
					alt="">
			</div>
			<div class="col-lg-7 text-center text-lg-left">
				<h3 class="text-white font-weight-normal mb-3">I'm</h3>
				<h1 class="display-3 text-uppercase text-primary mb-2"
					style="-webkit-text-stroke: 2px #ffffff;">LE MINH</h1>
				<h1
					class="typed-text-output d-inline font-weight-lighter text-white"></h1>
				<div class="typed-text d-none">Web Designer, Web Developer,
					Front End Developer, Apps Designer, Apps Developer</div>
				<div
					class="d-flex align-items-center justify-content-center justify-content-lg-start pt-5">
					<a href="" class="btn btn-outline-light mr-5">Download CV</a>
					<button type="button" class="btn-play" data-toggle="modal"
						data-src="https://www.youtube.com/embed/DWRcNpR6Kdc"
						data-target="#videoModal">
						<span></span>
					</button>
					<h5
						class="font-weight-normal text-white m-0 ml-4 d-none d-sm-block">Play
						Video</h5>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Header End -->


<!-- About Start -->
<div class="container-fluid py-5" id="about">
	<div class="container">
		<div
			class="position-relative d-flex align-items-center justify-content-center">
			<h1 class="display-1 text-uppercase text-white"
				style="-webkit-text-stroke: 1px #dee2e6;">About</h1>
			<h1 class="position-absolute text-uppercase text-primary">About
				Me</h1>
		</div>
		<div class="row align-items-center">
			<div class="col-lg-5 pb-4 pb-lg-0">
				<img class="img-fluid rounded w-100"
					src="${pageContext.request.contextPath}/publicUrl/img/leminh.jpg"
					alt="">
			</div>
			<div class="col-lg-7">
				<h3 class="mb-4">Web Developer</h3>
				<p class="font-weight-bold mb-1">${information.noidung}</p>
				<div class="row mb-3">
					<div class="col-sm-6 py-2">
						<h6>
							Name: <span class="text-secondary">${information.name}</span>
						</h6>
					</div>
					<div class="col-sm-6 py-2">
						<h6>
							Birthday: <span class="text-secondary">${information.ngaysinh}</span>
						</h6>
					</div>
					<div class="col-sm-6 py-2">
						<h6>
							Address: <span class="text-secondary">${information.diachi}</span>
						</h6>
					</div>
					<div class="col-sm-6 py-2">
						<h6>
							Phone: <span class="text-secondary">${information.sdt}</span>
						</h6>
					</div>
					<div class="col-sm-6 py-2">
						<h6>
							Email: <span class="text-secondary">${information.email}</span>
						</h6>
					</div>
					<div class="col-sm-6 py-2">
						<h6>
							Freelance: <span class="text-secondary">Available</span>
						</h6>
					</div>
				</div>
				<a href="" class="btn btn-outline-primary mr-4">Hire Me</a> <a
					href="" class="btn btn-outline-primary">Learn More</a>
			</div>
		</div>
	</div>
</div>
<!-- About End -->


<!-- Qualification Start -->
<div class="container-fluid py-5" id="qualification">
	<div class="container">
		<div
			class="position-relative d-flex align-items-center justify-content-center">
			<h1 class="display-1 text-uppercase text-white"
				style="-webkit-text-stroke: 1px #dee2e6;">Quality</h1>
			<h1 class="position-absolute text-uppercase text-primary">Education
				& Expericence</h1>
		</div>
		<div class="row align-items-center">
			<div class="col-lg-6">
				<h3 class="mb-4">My Education</h3>
				<div class="border-left border-primary pt-2 pl-4 ml-2">
					<c:choose>
						<c:when test="${not empty listM}">
							<c:forEach items="${listM}" var="manage">
								<div class="position-relative mb-4">
									<i class="far fa-dot-circle text-primary position-absolute"
										style="top: 2px; left: -32px;"></i>
									<h5 class="font-weight-bold mb-1">${manage.ten}</h5>
									<p class="mb-2">
										<small>${manage.thoigian}</small>
									</p>
									<p>${manage.phanloai}</p>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<p>Không có chặng đường nào</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Qualification End -->


<!-- Skill Start -->
<div class="container-fluid py-5" id="skill">
	<div class="container">
		<div
			class="position-relative d-flex align-items-center justify-content-center">
			<h1 class="display-1 text-uppercase text-white"
				style="-webkit-text-stroke: 1px #dee2e6;">Skills</h1>
			<h1 class="position-absolute text-uppercase text-primary">My
				Skills</h1>
		</div>
		<div class="row align-items-center">
			<div class="col-md-6">
				<div class="skill mb-4">
					<c:choose>
						<c:when test="${not empty listK}">
							<c:forEach items="${listK}" var="skill">
								<div class="d-flex justify-content-between">
									<h6 class="font-weight-bold">${skill.tenkynang}</h6>
									<h6 class="font-weight-bold">${skill.giatri}</h6>
								</div>
								<div class="progress">
									<div class="progress-bar bg-primary" role="progressbar"
										aria-valuenow="95" aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							Không có skill nào
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Skill End -->

<!-- Blog Start -->
<div class="container-fluid pt-5" id="blog">
	<div class="container">
		<div
			class="position-relative d-flex align-items-center justify-content-center">
			<h1 class="display-1 text-uppercase text-white"
				style="-webkit-text-stroke: 1px #dee2e6;">Blog</h1>
			<h1 class="position-absolute text-uppercase text-primary">Latest
				Blog</h1>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${not empty listL}">
					<c:forEach items="${listL}" var="land">
						<div class="col-lg-4 mb-5">
							<div class="position-relative mb-4">
								<img style="width: 20px; height: 200px"
									class="img-fluid rounded w-100"
									src="${pageContext.request.contextPath}/files/${land.hinhanh}"
									alt="">
							</div>
							<a  href="${pageContext.request.contextPath}/blog/${land.id_tin}" class="font-weight-bold mb-1">${land.tentin}</a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					Không có tin tức nào
				</c:otherwise>
			</c:choose>
		</div>
		
		<!-- Pagination -->
		<nav class="text-center" aria-label="...">
			<ul class="pagination">
				<c:choose>
					<c:when test="${page == 1}">
						<li class="active"><a href="#"> << </a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="${pageContext.request.contextPath}/?page=${page - 1}">
								<< </a></li>
					</c:otherwise>
				</c:choose>

				<c:forEach begin="1" end="${numberOfPage}" step="1" varStatus="loop">
					<c:choose>
						<c:when test="${loop.count == page}">
							<li class="active"><a
								href="${pageContext.request.contextPath}/?page=${loop.count}">${loop.count}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.request.contextPath}/?page=${loop.count}">${loop.count}</a></li>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				<c:choose>
					<c:when test="${page == numberOfPage}">
						<li class="active"><a href="#"> >> </a></li>
					</c:when>
					<c:otherwise>
						<li><a
							href="${pageContext.request.contextPath}/?page=${page + 1}">
								>> </a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
		<!-- /.pagination -->
		
	</div>
</div>
<!-- Blog End -->

<!-- Contact Start -->
<div class="container-fluid py-5" id="contact">
	<div class="container">
		<div
			class="position-relative d-flex align-items-center justify-content-center">
			<h1 class="display-1 text-uppercase text-white"
				style="-webkit-text-stroke: 1px #dee2e6;">Contact</h1>
			<h1 class="position-absolute text-uppercase text-primary">Contact
				Me</h1>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="contact-form text-center">
					<div id="success"></div>
					<form name="sentMessage" id="contactForm" novalidate="novalidate">
						<div class="form-row">
							<div class="control-group col-sm-6">
								<input type="text" class="form-control p-4" id="name"
									placeholder="Your Name" required="required"
									data-validation-required-message="Please enter your name" />
								<p class="help-block text-danger"></p>
							</div>
							<div class="control-group col-sm-6">
								<input type="email" class="form-control p-4" id="email"
									placeholder="Your Email" required="required"
									data-validation-required-message="Please enter your email" />
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="control-group">
							<input type="text" class="form-control p-4" id="subject"
								placeholder="Subject" required="required"
								data-validation-required-message="Please enter a subject" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<textarea class="form-control py-3 px-4" rows="5" id="message"
								placeholder="Message" required="required"
								data-validation-required-message="Please enter your message"></textarea>
							<p class="help-block text-danger"></p>
						</div>
						<div>
							<button class="btn btn-outline-primary" type="submit"
								id="sendMessageButton">Send Message</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Contact End -->


