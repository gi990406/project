/**
 * 회원 정보의 검증
 */
window.onload = function() {
	document.getElementById("loginBtn").onclick = loginValid;
}

 function loginValid() {
	 alert("로그인 버튼 클릭")
	 let memberid = document.getElementById("memberid");
	 let memberpwd= document.getElementById("memberpwd");
	 
	 if(memberid.value.trim().length < 3 || memberid.value.trim().length > 6) {
		 alert("ID는 3~6자 사이로 입력하세요");
		 memberid.focus();
		 memberid.select();
		 return false;
	 }
	 
	 if(memberpwd.value.trim().length < 3 || memberpwd.value.trim().length > 6) {
		 alert("비밀번호는 3~6자 사이로 입력하세요");
		 mempwd1.focus();
		 mempwd1.select();
		 return false;
	 }
	 
	 document.getElementById("loginForm").submit();
 }