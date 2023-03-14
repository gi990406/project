/**
 * 회원 정보의 검증
 */
 function validation() {
	 let memberid = document.getElementById("memberid");
	 let mempwd1  = document.getElementById("mempwd1");
	 let mempwd2  = document.getElementById("mempwd2");
	 let membername= document.getElementById("membername");
	 
	 if(memberid.value.trim().length < 3 || memberid.value.trim().length > 6) {
		 alert("ID는 3~6자 사이로 입력하세요");
		 memberid.focus();
		 memberid.select();
		 return false;
	 }
	 
	 if(mempwd1.value.trim().length < 3 || mempwd1.value.trim().length > 6) {
		 alert("비밀번호는 3~6자 사이로 입력하세요");
		 mempwd1.focus();
		 mempwd1.select();
		 return false;
	 }

	  if(mempwd2.value.trim() !== mempwd2.value.trim()) {
		 alert("비밀번호를 정확히 입력하세요");
		 mempwd2.focus();
		 mempwd2.select();
		 return false;
	 }
	 
	 if(membername.value.trim().length == 0) {
		 alert("이름을 입력하세요");
		 membername.focus();
		 membername.select();
		 return false;
	 }
	 return true;
 }