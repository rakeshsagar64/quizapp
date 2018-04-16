<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<script  src="js/app.js"></script>

	<script>
	$(document).ready(function(){
$("#box1").hide();
$("#box2").hide();
$("#box3").hide();
$(".redRectangle").animate({height:'150%'},1000);
$("#box1").slideDown(500,function(){
	$("#box2").slideDown(500,function(){
		$("#box3").slideDown(500);
		
	});
	
	
});

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




<div class="col-md-offset-3 col-md-6 col-xs-12">
	<div class="thumbnail card" id="box1">

		<c:choose>
			<c:when test="${empty message}">
				<h4>Add Subject</h4>
			</c:when>
			<c:otherwise>
					<h4>${message}</h4>
			</c:otherwise>
		</c:choose>
		
		<form action="AddSubject" method="post">
			
					<input type="text" class="form-control validate" name="subject" id="subject" placeholder="Enter subject name">
						<span id="subject_symbol"></span>
						<p id="subject_message"></p>
						<div class="row">
					<button type="submit" class="col-xs-offset-3 col-xs-5 button">Add Subjects</button>
				</div>
			</form>

	</div>


	
	<div class="thumbnail card" id="box2">

		<c:choose>
			<c:when test="${empty message}">
				<h4>Add Question</h4>
			</c:when>
			<c:otherwise>
					<h4>${message}</h4>
			</c:otherwise>
		</c:choose>
		
			<form action="AddQuestion" method="post">

		<select name="coursename" class="form-control">
			<option value="select" selected="selected">Select...</option>
			<c:forEach items="${sessionScope.subjectList}" var="subject">
				<option value="${subject}">${subject}</option>
			</c:forEach>

		</select>
		<p style="color:red">${error}</p>	
		<div class="row">
				<button type="submit" class="col-xs-offset-3 col-xs-5 button">Add Question</button>
		</div>
		
	</form>
	</div>


<div class="thumbnail card" id="box3">
	<c:choose>
			<c:when test="${empty message}">
				<h4>Edit Question</h4>
			</c:when>
			<c:otherwise>
					<h4>${message}</h4>
			</c:otherwise>
		</c:choose>
	
	

	<form action="EditController" method="get">
		<select name="coursename" class="form-control">
		<option value="select" selected="selected">Select...</option>
			<c:forEach items="${sessionScope.subjectList}" var="subject">
				<option value="${subject}">${subject}</option>
			</c:forEach>
		</select>
		<div class="row">
		<button type="submit" class="col-xs-offset-3 col-xs-5 button">Select Subject</button>
		</div>
	</form>
	</div>
</div>

</body>
</html>