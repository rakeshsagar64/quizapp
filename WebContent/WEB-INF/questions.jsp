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

	<script type="text/javascript">
		$(document).ready(function(){
			$(".redRectangle").animate({height:'150%'},1000);
			
		});	
	
	</script>

</head>
<body>


<div class="redRectangle" >
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





<div class="col-xs-offset-2 col-xs-7">
<table class="table card" id="editTable">

	<c:forEach var="question" items="${sessionScope.questions}" varStatus="questionNumber">
		<tr>
			
			<td>
				<h4>${questionNumber.count}</h4>
			</td>
			
			<td>
				<h4>${question.question}</h4>
			</td>
			<td>
				<h4>${question.correctAns}</h4>
			</td>
			<td>
				<a href="EditButton?questionId=${questionNumber.count-1}"><span class="glyphicon glyphicon-pencil heading-icon-small"></span></a>
			</td>
			<td>
				<a href=""><span class="glyphicon glyphicon-trash heading-icon-small"></span></a>
			</td>

		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>