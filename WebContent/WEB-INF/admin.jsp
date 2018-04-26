<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="stylesheet/style.css">


 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="js/app.js"></script>

<script>
	$(document).ready(function(){
$("#login").hide();	
$(".redRectangle").animate({height:'150%'},1000);
$("#login").slideDown(1000);

});

</script>




</head>
<body>


<div class="row redRectangle" >
<br>
</div>

  <div class="row">
  <br>
  </div>


  <div class="row">
  <br>
  </div>

  <div class="row">
  <br>
  </div>


<div class="col-md-offset-3 col-md-6 col-xs-12 card" id="login">

  <div class="col-xs-offset-5 ">
  <span class=" heading-icon glyphicon glyphicon-user"></span>
  </div>
<c:choose>
	<c:when test="${empty message}">
	<div class="heading">Admin Login </div>
	</c:when>
	<c:otherwise>
	<div class="heading">${message}</div>
	</c:otherwise>
</c:choose>

	<form action="AdminController" method="post">
<table class="table ">
	<tr>
		<td>
		<p>User name</p>
		</td>

		<td>
		<input type="text" placeholder="username" class="form-control validate" name="username" id="username">
		</td>

		<td>
		<span id="username_symbol"></span>
		<p id="username_message"></p>
		</td>

	</tr>
	<tr>
		<td>
		<p>Password</p>
		</td>

	<td>
	<input type="password" placeholder="password" class="form-control validate" name="password" id="password">
	</td>

		<td>
		<span id="password_symbol"></span>
		<p id="password_message"></p>
		</td>
	</tr>

	<tr>
		<td>
		<button type="Submit" id="submitButton" class="col-xs-offset-5 button">Login</button>
		</td>
	</tr>
</table>
	</form>
</div>
</body>
</html>