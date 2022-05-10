<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style type="text/css">
.haroo-body {
	display: flex;
}
</style>
<title>haroo 그룹웨어-근태현황</title>
</head>
<body>
	<header class="p-3 bg-dark text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="/"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
					<li><a href="#" class="nav-link px-2 text-white">Features</a></li>
					<li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
					<li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
					<li><a href="#" class="nav-link px-2 text-white">About</a></li>
				</ul>
				<div class="text-end">
					<button type="button" class="btn btn-outline-light me-2">Login</button>
					<button type="button" class="btn btn-warning">Sign-up</button>
				</div>
			</div>
		</div>
	</header>
	<nav>
		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="#">인사정보</a></li>
			<li class="nav-item"><a class="nav-link" href="#">근태관리</a></li>
			<li class="nav-item"><a class="nav-link" href="#">캘린더</a></li>
			<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
			<li class="nav-item"><a class="nav-link" href="#">설문조사</a></li>
			<li class="nav-item"><a class="nav-link" href="#">전자결재</a></li>
			<li class="nav-item"><a class="nav-link disabled">채팅</a></li>
		</ul>
	</nav>

	<!-- 바디 -->
	<div class="haroo-body">

		<!-- 사이드바 -->
		<div class="p-3 bg-white" style="width: 280px;">
			<a href="#"
				class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
				<svg class="bi me-2" width="30" height="24">
					<use xlink:href="#bootstrap"></use></svg> <span class="fs-5 fw-semibold">근태관리
			</span>
			</a>
			<ul class="list-unstyled ps-0">
				<li class="mb-1">
					<button class="btn btn-toggle align-items-center rounded collapsed"
						data-bs-toggle="collapse" data-bs-target="#home-collapse"
						aria-expanded="false">근태현황</button>
				</li>
				<li class="mb-1"><input
					class="btn btn-toggle align-items-center rounded collapsed"
					data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
					aria-expanded="false" type="submit" value="휴가현황"
					href="/haroo/dayoff/list?emNo=${dayoff.emNo}"></li>

				<li class="border-top my-3"></li>
			</ul>
		</div>
		<!-- end 사이드바 -->

		<!-- 근태버튼  -->
		<div class="p-3 container-sm">
			<input class="btn btn-outline-primary" type="submit" value="출근">
			<input class="btn btn-outline-secondary" type="submit" value="퇴근">
			<div class="form-check form-switch">
				<input class="form-check-input" type="checkbox" role="switch"
					id="flexSwitchCheckDefault"> <label
					class="form-check-label" for="flexSwitchCheckDefault">외근</label>
			</div>
			<div class="row">
				<div class="col-3">
					<select class="form-select form-select-sm"
						aria-label=".form-select-sm example">
						<option selected>일별 조회</option>
						<option value="1">월별 조회</option>
					</select>
				</div>
				<div class="col-4">
				<input class="btn btn-outline-success" type="submit" value="조회">
				</div>
			</div>
			<br>

			<!-- 근태목록  -->
			<h4>정보보안팀 근태 목록</h4><br>
			<h5>今日 : 2022/05/04</h5>
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">사번</th>
						<th scope="col">사원</th>
						<th scope="col">부서</th>
						<th scope="col">출근일수</th>
						<th scope="col">근무상태</th>
						<th scope="col">비고</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">111</th>
						<td>Mark</td>
						<td>정보보안팀</td>
						<td>2</td>
						<td>휴가</td>
						<td>반차</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
	<!-- end 바디 -->


	<!-- 푸터 -->
	<div class="container">
		<footer
			class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
			<p class="col-md-4 mb-0 text-muted">&copy; 2021 Company, Inc</p>

			<a href="/"
				class="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
				<h3>haroo</h3>
			</a>

			<ul class="nav col-md-4 justify-content-end">
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-muted">Home</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-muted">Features</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-muted">Pricing</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-muted">FAQs</a></li>
				<li class="nav-item"><a href="#"
					class="nav-link px-2 text-muted">About</a></li>
			</ul>
		</footer>
	</div>
	<!-- end 푸터 -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


</body>
</html>