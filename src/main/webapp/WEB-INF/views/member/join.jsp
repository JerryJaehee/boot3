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
	
	<div class="container mt-4">
	
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform:uppercase;">회원가입</h4>
			</div>
		</div>
		
	<form action="./join" method="post" enctype="multipart/form-data">
	  <div class="mb-3">
	  		  <div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">id</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="staticText" name="id">
			    </div>
			  </div>
		  <div class="mb-3 row">
		    <label for="exampleInputPassword1" class="col-sm-2 col-form-label">Password</label>
		     <div class="col-sm-10">
			      <input type="password" class="form-control" id="staticText" name="pw">
			    </div>
		  </div>
	    	<div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="staticText" name="name">
			    </div>
			  </div>
		     <div class="mb-3 row">
		    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">Email</label>
		     <div class="col-sm-10">
			      <input type="email" class="form-control" id="staticText" name="email">
			    </div>
		  </div>
		  
		     <div class="mb-3 row">
		    <label for="exampleInputEmail1" class="col-sm-2 col-form-label">phone</label>
		     <div class="col-sm-10">
			      <input type="text" class="form-control" id="staticText" name="phone">
			    </div>
		  </div>
		  
		  <div class="mb-3">
		  <label for="formFile" class="form-label">프로필사진</label>
		  <input class="form-control" type="file" id="formFile" name="proFile">
		</div>
		  </div>
		   <button type="submit" class="btn btn-primary">JOIN</button>
	</form>
</div>
		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>