<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<div class="container mt-4">

		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform: uppercase;">${board}
					List</h4>
			</div>
		</div>

		<!-- 검색 창 -->
		<div class="row mt-4">
			<form action="./list" method="get" class="d-flex">

				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">본문</option>
					<option value="col3">작성자</option>
				</select> <input type="search" name="search" value="${pager.search}"
					placeholder="Search" class="com-2">
				<button type="submit" class="btn btn-outline-success">Search</button>

			</form>
		</div>


		<div class="row mt-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">글번호</th>
						<th scope="col">글제목</th>
						<th scope="col">작성자</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.list}" var="vo">
						<tr>
							<th scope="row">${vo.num}</th>
							<td><a href="./detail?num=${vo.num}" class="link-info">${vo.title}</a></td>
							<td>${vo.writer}</td>
							<td>${vo.hit}</td>
							<td>${vo.regDate}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<div class="row justify-content-end">
			<a href="./add" type="button" class="col-1 btn btn-outline-primary ">WRITE</a>
		</div>

		<div class="row">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li class="page-item">
					<a class="page-link" href="./list?pn=${pager.pre?pager.startNum-1:1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
					 <span aria-hidden="true">&laquo;</span>
					</a>
					</li>

					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<a class="page-link"
							href="./list?pn=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
					</c:forEach>
					
					<li class="page-item">
					<a class="page-link" href="./list?pn=${pager.next?pager.lastNum+1:pager.lastNum}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
					 <span aria-hidden="true">&raquo;</span>
					</a>
					</li>
				</ul>
			</nav>

		</div>


</div>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
</body>
</html>