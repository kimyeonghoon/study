<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#joinBtn").on("click", function() {
		if($.trim($("#bmId").val()) == "") {
			alert("아이디를 입력해주세요.");
		} else if($.trim($("#bmPw").val()) == "") {
			alert("패스워드를 입력해주세요.");
		} else if($.trim($("#bmPwRe").val()) == "") {
			alert("패스워드를 입력해주세요.");
		} else if($.trim($("#bmNm").val()) == "") {
			alert("이름을 입력해주세요.");
		} else if($("#bmPw").val() != $("#bmPwRe").val()) {
			alert("패스워드가 일치하지 않습니다.")
		} else {
			$("#actionForm").submit();
		} 
	});  
	
	$("#cancelBtn").on("click", function() {
		history.back();
	});
});

</script>
</head>
<body>
<form action="bJoins" id="actionForm" method="post">
	아이디<input type="text" name="bmId" id="bmId" /><br/>
	비밀번호<input type="password" name="bmPw" id="bmPw" /><br/>
	<!-- 비밀번호 확인의 경우 단순히 값이 일치하는지만 확인하므로 
		 폼으로 보낼 필요 없음(name X)
	-->
	비밀번호확인<input type="password" id="bmPwRe" /><br/>
	이름<input type="text" name="bmNm" id="bmNm" /><br/>
	<input type="button" value="가입" id="joinBtn">
	<input type="button" value="취소" id="cancelBtn">
</form>
</body>
</html>