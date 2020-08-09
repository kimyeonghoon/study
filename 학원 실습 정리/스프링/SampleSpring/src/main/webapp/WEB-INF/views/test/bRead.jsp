<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#backBtn").on("click", function() {
		$("#actionForm").attr("action", "bMain");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		var params = $("#actionForm").serialize();
		/* ajax 기본 형태  */
		$.ajax({
			type : "post",			  //전송방식
			url : "bDeleteAjax", 	  //주소
			dataType : "json",  	  //데이터 형태
			data : params,    		  //보낼데이터
			success : function(res) { //성공 시 다음 함수를 실행하며, 돌아오는 값을 res란 이름으로 받는다.
				if(res.result == "success") {
					location.href ="bMain";
				} else if(res.result == "fail") {
					alert("삭제 정보가 올바르지 않습니다.");					
				} else {
					alert("삭제 중 문제가 발생하여ㅛㅆ습니다.")
				}
			},
			error : function(request, status, error) { // 실행 중 에러 발생 시 
				console.log("text : " + request.responseTxt); //반환텍스트
				console.log("error : " + error); //에러내용
			}
		});
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "bUpdate");
		$("#actionForm").submit();
	});
	
	
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="bNo" value="${param.bNo}" />
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
번호 : ${data.B_NO}<br/>
제목 : ${data.B_TITLE}<br/>
작성자 : ${data.BM_NM}<br/>
작성일 : ${data.B_DT}<br/>
조회수 : ${data.B_HIT}<br/>
- 내용 -<br/>
${data.B_CON}<br/>
<c:if test="${sBmNo eq data.BM_NO}">
	<input type="button" value="수정" id="updateBtn" />
	<input type="button" value="삭제" id="deleteBtn" />
</c:if>
<input type="button" value="뒤로가기" id="backBtn" />
</body>
</html>