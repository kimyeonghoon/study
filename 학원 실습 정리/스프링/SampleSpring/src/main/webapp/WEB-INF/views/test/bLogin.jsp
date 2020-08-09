<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#joinBtn").on("click", function() {
		location.href = "bJoin";	
	});
	
	$("#loginBtn").on("click", function() {
		if($.trim($("#bmId").val()) == "") {
			alert("아이디를 입력해 주세요.");
			$("#bmId").focus();
		} else if($.trim($("#bmPw").val()) == "") {
			alert("비밀번호를 입력해 주세요.");
			$("#bmPw").focus();
		} else {
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="bLogins" id="actionForm" method="post">
<input type="text" name="bmId" id="bmId" placeholder="아이디" /><br/>
<input type="password" name="bmPw" id="bmPw" placeholder="비밀번호" /><br/>
<input type="button" value="로그인" id="loginBtn" />
<input type="button" value="회원가입" id="joinBtn" />
</form>

</body>
</html>