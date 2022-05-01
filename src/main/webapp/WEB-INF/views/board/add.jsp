<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">


<c:import url="../temp/header_css.jsp"></c:import>
<c:import url="../temp/header-script.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<div class="container mt-4">
	
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform:uppercase;">${board} List</h4>
			</div>
		</div>
		<div class="row mt-4">
			<form action="./add" method="post" enctype="multipart/form-data">
			
			  <div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">Writer</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="writer" name="writer" value="${member.id}" readonly="readonly">
			    </div>
			  </div>
			  
			  <div class="mb-3 row">
			    <label for="staticText" class="col-sm-2 col-form-label">Title</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="title" name="title">
			    </div>
			  </div>
			  
			  <div class="mb-3 row">
			  <label for="exampleFormControlTextarea1" class="col-form-label col-sm-2">Contents</label>
			  <textarea class="form-control" id="summernote" rows="3" name="contents"></textarea>
			</div>

			<button type="button" class="btn btn-outline-danger d-block my-4" id="fileAdd">FileADD</button>
			
			<div id="fileResult">
				
			</div>
			
			<button type="submit" class="btn btn-primary">ADD</button>
			</form>
		
		</div>
	</div>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
 <script type="text/javascript">
 summernoteInit("summernote","");
 
 	let count = 0;
 
 	$("#fileAdd").click(function() {
 		if(count>4) {
 			alert('최대 5개만 가능합니다.');
 			return ;
 		}
 		let result = '<div class="input-group">';
 		result = result + ' <input type="file" name="files" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">';
 		result = result + '  <button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>'
 		result = result + '</div>';
 		
 		$("#fileResult").append(result);
 		count++;
 	});
 	
 	$("#fileResult").on("click", ".del", function() {
 		$(this).parent().remove();
 		count--;
 	})
 	
 </script>
 
</body>
</html>