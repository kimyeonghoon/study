<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 수정 성공/실패</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${res}' == "true") {
		$("#backForm").submit();
	} else {
		alert("수정에 실패하였습니다.");
		history.back();
	}
});


//)
</script>
</head>

<body>
<form action="content" id="backForm" method="post">
	<input type="hidden" name="bookNo" value="${param.bookNo}" />
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
</body>
</html>