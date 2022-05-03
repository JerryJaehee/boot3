<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
		<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-light" role="alert">
				<h4 style="text-transform: uppercase;">${board}Join</h4>
			</div>
		</div>


		<div class="row mt-4">
			<form:form method="post" enctype="multipart/form-data" modelAttribute="memberVO">
				<div class="row mb-3">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-10">
						<form:input path="id" cssClass="form-control" id="id"/>
						<div>
							<form:errors path="id"></form:errors>
						</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="pw" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<form:password path="pw" cssClass="form-control" id="pw"/>
						<div>
							<form:errors path="pw" cssStyle="color:red;"></form:errors>
						</div>
					</div>
				</div>


 				<div class="row mb-3">
					<label for="checkPw" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
					<!-- 	<input type="password" name="checkPw" class="form-control"
							id="checkPw"> -->
						<form:password path="checkPw" cssClass="form-control" id="checkPw"/>
						<div>
							<form:errors path="checkPw" cssStyle="color:red;"></form:errors>
						</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="name" class="col-sm-2 col-form-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" id="name"/>
						<div>
							<form:errors path="name"></form:errors>
						</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="Email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" cssClass="form-control" id="email"/>
						<div>
							<form:errors path="email" cssStyle="color:red;"></form:errors>
						</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="phone" class="col-sm-2 col-form-label">Phone</label>
					<div class="col-sm-10">
						<form:input path="phone" cssClass="form-control" id="phone"/>
						<div>
							<form:errors path="phone" cssStyle="color:red;"></form:errors>
						</div>
					</div>
				</div>
				<div class="row mb-3">
					<label for="files" class="col-sm-2 col-form-label">File</label>
					<div class="col-sm-10">
						<input type="file" name="files" class="form-control" id="files">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Join</button>
			</form:form>

		</div>

		<div class="row mt-4">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value=""	id="all"> 
				<label class="form-check-label"	for=all> checkbox-ALL </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""	id="check1">
				<label class="form-check-label"	for="check1"> checkbox2 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""	id="check2"> 
				<label class="form-check-label"	for="check2"> checkbox3 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""	id="check3"> 
				<label class="form-check-label"	for="check3"> checkbox4 </label>
			</div>

		</div>


	</div>



	<script type="text/javascript">
		$("#all").click(function(){
			$(".ch").prop("checked", $("#all").prop("checked"));
			
		});
		
		$(".ch").on("click", function() {
			let check= true;
			
			$(".ch").each(function(idx, item) {
				if(!$(item).prop("checked")){
					check=false;
				}
			});
			
			$("#all").prop("checked", check);
			
		});
	
	</script>
</body>
</html>