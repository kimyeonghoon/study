<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>거래 상세보기</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#backBtn").on("click", function() {
		$("#actionForm").attr("action", "test1");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "test4");
		$("#actionForm").submit();
	});
	
	$("#delBtn").on("click", function() {
		if(confirm("지울 겁니까?")) {
			$("#actionForm").attr("action","test5");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="sellId" value="${param.sellId}" />
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
거래ID : ${data.SELL_ID}<br/>
고객 : ${data.CUSTOMER}<br/>
제품 : ${data.PRODUCT}<br/>
단가 : ${data.PRICE}<br/>
수량 : ${data.QUANTITY}<br/>
판매 : ${data.SELL}<br/>
<input type="button" value="수정" id="updateBtn" />
<input type="button" value="삭제" id="delBtn" />
<input type="button" value="뒤로가기" id="backBtn" />

</body>
</html>