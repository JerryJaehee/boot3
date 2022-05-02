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
<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<h1>Update page</h1>
	
	<div class="container mt-4">
	<div class="row mt-4">
		<div class="alert alert-light" role="alert">
	  		<h4 style="text-transform: uppercase;">${board} Update</h4>
		</div>
	</div>
	
	
	<div class="row mt-4">
		<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		  <div class="row mb-3">
		    <label for="title" class="col-sm-2 col-form-label">Title</label>
		    <div class="col-sm-10">
		      <input type="text" value="${vo.title}" name="title" class="form-control" id="title">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="writer" class="col-sm-2 col-form-label">Writer</label>
		    <div class="col-sm-10">
		      <input type="text" value="${vo.writer}" name="writer" class="form-control" id="writer">
		    </div>
		  </div>
		 <div class="row mb-3">
		    <label for="contents" class="col-sm-2 col-form-label">Contents</label>
		    <div class="col-sm-10">
		      <textarea name="contents" class="form-control" id="contents">${vo.contents}</textarea>
		    </div>
		  </div>
		  
		  <div class="row mb-3">
		    <label for="files" class="col-sm-2 col-form-label">File</label>
		    <div class="col-sm-10">
		      <input type="file" name="files" class="form-control" id="files">
		    </div>
		  </div>
		  
		  <div class="row mb-3">
		    <label for="files" class="col-sm-2 col-form-label">File</label>
		    <div class="col-sm-10">
		      <input type="file" name="files" class="form-control" id="files">
		    </div>
		  </div>
		  
		  
		  
		 
		  <button type="submit" class="btn btn-primary">Update</button>
		</form>
	
	</div>
	
	
</div>	

<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript" src="../js/summernote.js"></script>
 <script type="text/javascript">
 
	summernoteInit("contents","${vo.contents}");
	fileAddInit({vo.filesVOs.size()});
	fileDeleteInit();
 
 </script>
 

</body>
</html>