/**
 * 회원 정보의 검증
 */
 function validation() {
	 let blogid = document.getElementById("blogid");
	 let blogpwd  = document.getElementById("blogpwd");
	 let blogername= document.getElementById("blogername");
	 
	 if(blogid.value.trim().length < 3 || blogid.value.trim().length > 10) {
		 alert("ID는 3~10자 사이로 입력하세요");
		 blogid.focus();
		 blogid.select();
		 return false;
	 }
	 
	 if(blogpwd.value.trim().length < 3 || blogpwd.value.trim().length > 10) {
		 alert("비밀번호는 3~10자 사이로 입력하세요");
		 blogpwd.focus();
		 blogpwd.select();
		 return false;
	 }

	 if(blogername.value.trim().length == 0) {
		 alert("이름을 입력하세요");
		 blogername.focus();
		 blogername.select();
		 return false;
	 }
	 return true;
 }
