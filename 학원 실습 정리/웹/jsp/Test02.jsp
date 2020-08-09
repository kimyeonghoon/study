<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../javascript/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#sendBtn").on("click", function() {
		$("#actionForm").submit(); // #actionForm을 실행하겠다.
	});
});
</script>
</head>
<body>
<!-- 
	form : 값을 전송하기 위한 태그
	action : 값을 보낼 경로
	for으로 값을 전송할 때 name은 key
					 value은 value
					 
	키와 값으로 매핑되어 전송.
	name=value & .....
	  k	   v 
	  
	
	${param.msg} - parameter : 넘어오는 정보
	               msg : key
	  
 -->
 
 <!--
 
 주소?키=값&키=값.....     => [Get 방식]의 데이터 전송 방식
 
 데이터가 주소창에 보이기 때문에 보안에 취약함
 대외적으로 알려야하는 것은 보통 Get방식 사용.
  
  
주소에 헤더를 통하여 데이터 전송 => [Post 방식]의 데이터 전송 방식 
패스워드와 같은 정보는 post방식으로 전송
 
 -->
 
<!-- 
 	[[정보.....       ]] http://www.naver.com/~
-->
 
<!-- [post방식]  -->
<form action="Test02s.jsp" id="actionForm" method="post">
	<input type="text" name="msg" />
	<input type="button" value="send" id="sendBtn" />
</form>



<!--
[get방식]
<form action="Test02s.jsp" id="actionForm">
	<input type="text" name="msg" />
	<input type="button" value="send" id="sendBtn" />
</form>
-->


</body>
</html>