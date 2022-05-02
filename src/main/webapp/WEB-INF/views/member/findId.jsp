<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../temp/header_css.jsp"></c:import>
<c:import url="../temp/header-script.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<div class="container">
	<div class="row"><h1>ID 찾기</h1></div>
	<form action="./findId" method="POST">
		<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">Email address</label>
	  <input type="email" name="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
</div>
	  <button type="submit" class="btn btn-success">아이디 찾기</button>
	</form>
</div>

</body>
</html>