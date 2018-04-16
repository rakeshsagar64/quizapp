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
$(".redRectangle").animate({height:'150%'},1000);
$("#login").slideDown(1000);

});

</script>

</head>
<body id="body" >

<div class="row redRectangle" >
<br>
</div>


<div class="row">
<br>
</div>


  <div class="col-md-offset-3 col-md-6 card" id="login">
<div class="col-xs-offset-5 ">
<span class=" heading-icon glyphicon glyphicon-education"></span>
</div>

<div class="heading">
    <h4 >Candidate Detail Form</h4>
</div>
<form action="QuizController" method="post" >
<table class="table ">
<th>
</th>
<tr>

	<td>
	<p>Candidate Name:-</p>
	</td>
	<td>
		<input type="text" class="form-control validate" placeholder="Enter the candidate name" name="name" id="name">

	</td>
	<td>
	<span id="name_symbol"></span>
	<p id="name_message"></p>
	</td>
</tr>
<tr>
	<td>
	<p>Course Name:-</p>
	</td>
	<td>
		<!-- <input type="text" class="form-control validate" placeholder="Enter the course name" name="coursename" id="coursename"> -->
	<select name="coursename" class="form-control">
		<c:forEach items="${applicationScope.subjectList}" var="subject">
		<option value="${subject}">${subject}</option>


		</c:forEach>
	</select>
	</td>
	<td>
	<span id="coursename_symbol"></span>
	<p id="coursename_message"></p>
	</td>
<tr>
<td>
<button type="submit" id="submitButton" class="col-xs-offset-6 button disabled">Submit</button>
</td>
</tr>

</tr>
</table>

</form>
</div>




</body>
</html>