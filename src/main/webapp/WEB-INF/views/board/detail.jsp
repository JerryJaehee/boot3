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
			<h4 class="text-center" style="text-transform:uppercase;">${board} detail Page</h4>
		</div>
	</div>
	<div class="card row mt-4" style="width: 18rem;">
		<ul class="list-group list-group-flush">
			<li class="list-group-item">${vo.writer}</li>
			<li class="list-group-item">${vo.title}</li>
			<li class="list-group-item">${vo.contents}</li>
			<li class="list-group-item">
				<c:forEach items="${vo.filesVOs}" var="f">
					<a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>
				</c:forEach>
			</li>
		</ul>
	</div>
		<div class="mt-4">
			<a role="button" href="./update?num=${vo.num}" class="btn btn-success">UPDATE</a>
			<a role="button" href="./delete?num=${vo.num}" class="btn btn-danger">DELETE</a>
		</div>
	</div>
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>