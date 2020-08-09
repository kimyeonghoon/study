<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 보기</title>
<style type="text/css">
html, body {
	height: 100%;
	margin: 0px;
	padding: 0px;
}
.bookInfo {
	padding: 10px;
}
.bookContent {
	padding: 10px;
}
table {
 	border-collapse: collapse;
}
.paraStyle {
	font-size: 20px;
	font-weight: bold;
}
.gbn {
	font-weight: bold;
}

.wrap {
	background-color: #FEEEEE;
}

</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#cancelBtn").on("click", function() {
		$("#actionForm").attr("action", "book");
		$("#actionForm").submit();
	});
	
	$("#updateBtn").on("click", function() {
		$("#actionForm").attr("action", "modify");
		$("#actionForm").submit();
	});
	
	$("#deleteBtn").on("click", function() {
		if(confirm("삭제하시겠습니까?")) {
			$("#actionForm").attr("action", "deletesend");
			$("#actionForm").submit();
		}
	});
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="bookNo" value="${param.bookNo}" />
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
<div class="wrap">
	<div class="bookInfo">
		<table>
			<colgroup>
				<col width="100px"></col>
				<col width="700px"></col>
			</colgroup>
			<tbody>
				<tr>
					<td class="gbn">책 번호</td>
					<td>${content.B_NO}</td>
				</tr>
				<tr>
					<td class="gbn">제목</td>
					<td>${content.B_TITLE}</td>
				</tr>
				<tr>
					<td class="gbn">저자</td>
					<td>${content.B_AUTHOR}</td>
				</tr>
				<tr>
					<td class="gbn">출판사</td>
					<td>${content.B_PUBLISH}</td>
				</tr>
				<tr>
					<td class="gbn">가격</td>
					<td>${content.B_PRICE}원</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="bookContent">	
		<p class="paraStyle">책 내용</p>
		${content.B_INFO}
	</div>
	<div class="buttons">
		<input type="button" value="수정" id="updateBtn" />
		<input type="button" value="삭제" id="deleteBtn" />
		<input type="button" value="뒤로가기" id="cancelBtn" />
	</div>
</div>
</body>
</html>