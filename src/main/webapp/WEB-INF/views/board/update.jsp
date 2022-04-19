<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<h1>Update page</h1>
	
	<div class="container mt-4">
	
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform:uppercase;">${board} List</h4>
			</div>
		</div>
		<div class="row mt-4">
			<form action="./update" method="post" enctype="multipart/form-data">
			  <input type="hidden" value="${vo.num}" name="num">
			  <div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">Writer</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="staticText" name="writer" value="${vo.writer}" disabled="disabled">
			    </div>
			  </div>
			  
			  <div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">Title</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="staticText" name="title" value="${vo.title}">
			    </div>
			  </div>
			  
			  <div class="mb-3 row">
			  <label for="exampleFormControlTextarea1" class="col-form-label col-sm-2">Contents</label>
			  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="contents">${vo.contents}</textarea>
			</div>
			
<!-- 			<div class="row mb-3">
  <label for="formFile" class="form-label">File</label>
  <input class="form-control" type="file" id="formFile" name="files">
</div>

<div class="row mb-3">
  <label for="formFile" class="form-label">File</label>
  <input class="form-control" type="file" id="formFile" name="files">
</div> -->
			<button type="submit" class="btn btn-primary">UPDATE</button>
			</form>
		
		</div>
	</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>