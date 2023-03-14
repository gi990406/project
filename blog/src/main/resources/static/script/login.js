/**
 * 회원 정보의 검증
 */
window.onload = function() {
	document.getElementById("loginBtn").onclick = loginValid;
}

 function loginValid() {
	 alert("로그인 버튼 클릭")
	 let blogid = document.getElementById("blogid");
	 let blogpwd= document.getElementById("blogpwd");
	 
	 if(blogid.value.trim().length < 3 || blogid.value.trim().length > 10) {
		 alert("ID는 3~10자 사이로 입력하세요");
		 blogid.focus();
		 blogid.select();
		 return false;
	 }
	 
	 if(blogpwd.value.trim().length < 3 || blogpwd.value.trim().length > 10) {
		 alert("비밀번호는 3~6자 사이로 입력하세요");
		 blogpwd.focus();
		 blogpwd.select();
		 return false;
	 }
	 
	 document.getElementById("loginForm").submit();
 }