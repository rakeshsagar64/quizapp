$(document).ready(function(){
	var count=0;
	var maxValid=$("input").filter(".validate").length;
	$(".validate").on("focus blur change",function(){
		var textBox=$(this).attr("id");
		$.post("Validator",{input:$(this).val()},function(data,status){
			console.log(textBox);
				if(data==="error"){
					console.log(data);
					$("#"+textBox+"_symbol").addClass("glyphicon glyphicon-remove").text("the field cannot be left blank");
				if(count>0){
					count=count-1;
					}
				
				else{
					count=0;
					
				}
				}
				else{
				$("#"+textBox+"_symbol").removeClass("glyphicon glyphicon-remove").addClass("glyphicon glyphicon-ok").text("");
					count=count+1;
				
			}
				
				if(count>=maxValid){
					$("#submitButton").removeClass("disabled");
						count=0;	
				}
				else{
					$("#submitButton").addClass("disabled");
					
					
				}
				
			});
		
	});
	
	
	
	
	
})