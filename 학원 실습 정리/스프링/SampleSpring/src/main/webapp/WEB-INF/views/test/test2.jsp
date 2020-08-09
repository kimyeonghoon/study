<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#cancelBtn").on("click", function() {
		history.back();
	});
	
	$("#addBtn").on("click", function() {
		if($.trim($("#customer").val()) == "") {
			alert("고객이 비어 있습니다.");
		} else if($.trim($("#product").val()) == "") {
			alert("제품이 비어 있습니다.");
		} else if($.trim($("#price").val()) == "") {
			alert("단가가 비어 있습니다.");
		} else if($.trim($("#quantity").val()) == "") {
			alert("수량이 비어 있습니다.");
		} else if($.trim($("#sell").val()) == "") {
			alert("판매가 비어 있습니다.");
		} else {
			$("#actionForm").submit();
		}
	});  
});
</script>


</head>
<body>
<form action="test2s" id="actionForm" method="post">
	고객<input type="text" name="customer" id="customer" />
	<br/>
	제품<input type="text" name="product" id="product" />
	<br/>
	단가<input type="number" name="price" id="price" />
	<br/>
	수량<input type="number" name="quantity" id="quantity" />
	<br/>
	판매<input type="number" name="sell" id="sell" />
	<br/>
	<input type="button" value="등록" id="addBtn" />
	<input type="button" value="취소" id="cancelBtn" />
</form>
</body>
</html>