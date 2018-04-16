<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

</head>
<body>

<div class="col-xs-offset-3 col-xs-5 thumbnail">

 ${question.question} 

<form action="NextQuestion" method="post">

<table class="table table-condensed" >
<tr>
	<td>
		<input type="radio" name="answer" value="${question.options[0]}" >${question.options[0]}
	</td>
</tr>
<tr>
	<td>
	<input type="radio" name="answer" value="${question.options[1]}" >${question.options[1]}
	</td>
</tr>

<tr>
	<td>
		<input type="radio" name="answer" value="${question.options[2]}" >${question.options[2]}
	</td>
</tr>

<tr>
	<td>
		<input type="radio" name="answer" value="${question.options[3]}" >${question.options[3]}
	</td>
</tr>

</table>
<input type="submit" value="next ">
</form>
</div>




</body>
</html>