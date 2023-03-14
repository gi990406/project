/**
 * jquary ajax를 이용해 id 중복확인 체크 
 */

$(function(){
	$("#memberid").keyup(function() {
		let mid = $(this).val();
		console.log(mid);
		if(mid.trim().length < 3 || mid.trim().length > 6 ) {
			$("#checkResult").css("color" , "red");
			$("#checkResult").text('아이디는 3~6자');
			
			return false;	
		} 
		$("#checkResult").css("color", "blue");
		
		$.ajax({
			method : "GET"
			, url : "idCheck"
			, data : {"memberid" : mid}
			, success : function(resp) {
				if(resp == 'OK') {  
					$("#checkResult").css("color", "blue");
					$("#checkResult").text('사용가능한 아이디입니다.');
				} else if(resp=='Fail') {
					$("#checkResult").css("color", "red");
					$("#checkResult").text('사용할 수 없는 아이디입니다.');
				}
			}
		})
	})
})








