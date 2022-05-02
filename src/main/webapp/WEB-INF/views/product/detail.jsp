<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:import url="../temp/header_css.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<c:import url="./temp_detail.jsp"></c:import>

	<div class="container">
		<h1><spring:message code="product.detail.info" arguments="${vo.productPrice}, ${vo.productCount}" argumentSeparator=","></spring:message></h1>
	</div>
	
	
	<c:import url="../temp/header-script.jsp"></c:import>
</body>
</html>