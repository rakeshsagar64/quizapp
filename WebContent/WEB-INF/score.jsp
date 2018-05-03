

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="stylesheet/style.css">
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function(){
		$("#login").hide();	
		$("#login").slideDown(1000);
		
	});

</script>

</head>
<body id="body" >



<div class="row">
<br>
<br>
</div>


  <div class="col-md-offset-3 col-md-6 card" id="login">
<div class="col-xs-offset-5 ">
<span class=" heading-icon glyphicon glyphicon-education"></span>
</div>

<div class="heading">
    <h4 >Candidate Score Card</h4>
</div>
<br>
<h3 style="text-align:center">Congratulations you have scored</h3><br>
<h2 style="text-align:center">${score}</h2><br>
<h3 style="text-align:center">in your ${sessionScope.courseName} exam</h3>
<br>
<a style="width:100%" href="Logout" class="col-xs-offset-5 button" id="close">Close</a>
<br>
<br>

</div>
</body>
</html>