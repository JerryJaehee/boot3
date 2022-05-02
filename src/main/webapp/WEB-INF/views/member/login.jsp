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
<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<div class="container">
	
  <form action="./login" method="post">
	
	<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform:uppercase;">로그인</h4>
			</div>
		</div>
    <div class="form-floating mt-4">
      <input type="text" class="form-control" id="floatingInput" placeholder="id" value="${cookie.remember.value}" name="id">
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="pw">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" name="remember" value="1"> Remember me
      </label>
    </div> 
    <button class="w-100 btn btn-lg btn-primary mt-4" type="submit">Sign in</button>
 	<div class="row">
 		<button id="find" type="button" class="btn btn-danger">ID 찾기</button>
 	</div>
  </form>
  
  
  </div>

<script type="text/javascript">
	$("#find").click(function() {
		location.href="./findId";
	});
</script>


</body>
</html>