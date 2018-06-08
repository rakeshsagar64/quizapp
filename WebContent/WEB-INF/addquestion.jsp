<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	
	
	<div class="col-xs-offset-2 col-xs-7 card">
<table class="table">
	
	
	<form action="AddQuestionController" method="post">
		<tr>
		<td>
			Question
		</td>
		<td>
			<textarea  name="question" placeholder="Question here"></textarea>
		</td>
		</tr>
		<tr>
		<td>
		option 1
		</td>
		<td>
			<textarea type ="text"	name="option_a" placeholder="option_a">
			</textarea>
		</td>
		</tr>
		<tr>
		<td>
		option 2
		</td>
		<td>
			<textarea type ="text"	name="option_b" placeholder="option_b">
		</textarea>
		</td>
		</tr>
		<tr>
		<td>
		option 3
		</td>
		<td>
		<textarea type ="text"	name="option_c" placeholder="option_c">
		</textarea>
		</td>
		</tr>
		<tr>
		<td>
		option 4
		</td>
		<td>
		<textarea type ="text"	name="option_d" placeholder="option_d">
		</textarea>
		</td>
		</tr>
		<tr>
			<td>
		Correct Answer
		</td>
		<td>
		<textarea rows="" cols="" name="correctanswer"></textarea>
		
		</td>
		</tr>
		<tr>
		<td>
		<input type="submit" value="Submit">	
		</td>
		</tr>
	</form>
	</table>
	</div>
</body>
</html>