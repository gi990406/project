$(function(){
	$("#blogid").keyup(function() {
		let mid = $(this).val();
		console.log(mid);
		if(mid.trim().length < 3 || mid.trim().length > 10 ) {
			$("#checkResult").css("color" , "red");
			$("#checkResult").text('아이디는 3~10자');
			
			return false;	
		} 
		$("#checkResult").css("color", "blue");

	})
})








