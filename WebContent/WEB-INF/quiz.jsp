<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="stylesheet/style.css">
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/quiz.js"></script>
<script>
	$(document).ready(function(){
$("#login").hide();	
$(".redRectangle").animate({height:'150%'},1000);
$("#login").slideDown(1000);

});

</script>

</head>
<body>

<div class="row redRectangle">
	<br>
</div>


<div class="row">
<br>
</div>


  <div class=" col-md-offset-3 col-md-6 card quizContainer" id="login">


        <div class="question"></div>
        <ul class="choiceList"></ul>
        <div class="quizMessage"></div>
        <div class="result"></div>
        <div class="nextButton button">Next Question</div>
        <br>
    </div>

</body>
</html>
