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

	


<div class=" card">
<table class="table">

	<form action="EditQuestionController" method="post">
<tr>
		<td>
		Question
		</td>
		<td>
		<textarea style="width:100%" type="text" name="question" placeholder="Question here" value="${questiontoedit.question}">
		</textarea>
		</td>
</tr>
<tr>
		<td>
		Option 1
		</td>
		<td>
		<textarea type ="text"	name="option_a" placeholder="option_a" value="${questiontoedit.options[0]}">
		</textarea>
		</td>
</tr>
<tr>
		<td>
		Option 2
		</td>
		<td>
		<textarea type ="text"	name="option_b" placeholder="option_b" value="${questiontoedit.options[1]}">
		</textarea>
		</td>
</tr>
<tr>
		<td>
		Option 3
		</td>
		<td>
		<textarea type ="text"	name="option_c" placeholder="option_c" value="${questiontoedit.options[2]}">
		</textarea>
		</td>
</tr>
<tr>
		<td>
		Option 4
		</td>
		<td>
		<textarea type ="text"	name="option_d" placeholder="option_d" value="${questiontoedit.options[3]}">
		</textarea>
		</td>
</tr>
<tr>
		<td>
		Correct Answer
		</td>
		<td>
		<input type="radio" name="correctanswer" value="${questiontoedit.options[0]}">option 1
		<input type="radio" name="correctanswer" value="${questiontoedit.options[1]}">option 2
		<input type="radio" name="correctanswer" value="${questiontoedit.options[2]}">option 3
		<input type="radio" name="correctanswer" value="${questiontoedit.options[3]}">option 4
		
		</td>
</tr>
<tr>	
		<td>
		<input type="submit" value="Edit">	
		</td>
</tr>
	</form>
</table>	
</div>	
	
</body>
</html>