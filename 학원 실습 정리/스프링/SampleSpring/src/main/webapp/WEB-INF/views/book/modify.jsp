<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 수정</title>
<style type="text/css">
html, body {
	height: 100%;
	margin: 0px;
	padding: 0px;
}
</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$("#cancelBtn").on("click", function() {
		history.back();
	});
	$("textarea").val(`${fn:replace(fn:replace(content.B_INFO, '"', '\\"'), "'", "\\'")}`);
	$("#modifyBtn").on("click", function() {
		if($.trim($("#b_title").val()) == "") {
			alert("책 제목을 입력해주세요.");
		} else if($.trim($("#b_author").val()) == "") {
			alert("저자를 입력해주세요.");
		} else if($.trim($("#b_publish").val()) == "") {
			alert("출판사를 입력해주세요.");
		} else if($.trim($("#b_price").val()) == "") {
			alert("가격을 입력해주세요.");
		} else if($.trim($("#b_info").val()) == "") {
			alert("내용을 입력해주세요.");
		} else {
			$("#actionForm").attr("action", "modifysend");
			$("#actionForm").submit();
		}
	});  
});
</script>
</head>
<body>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
	<input type="hidden" name="bookNo" value="${param.bookNo}" />
	<table>
		<tbody> 
			<tr>
				<td>책번호</td>			
				<td>${content.B_NO}</td>			
			</tr>
			<tr>
				<td>제목</td>			
				<td><input type="text" name="b_title" id="b_title" maxlength="100" value="${content.B_TITLE}" placeholder="책 제목을 입력해주세요."/></td>			
			</tr>
			<tr>
				<td>저자</td>			
				<td><input type="text" name="b_author" id="b_author" maxlength="25" value="${content.B_AUTHOR}" placeholder="저자를 입력해주세요." /></td>			
			</tr>
			<tr>
				<td>출판사</td>			
				<td><input type="text" name="b_publish" id="b_publish" maxlength="25" value="${content.B_PUBLISH}" placeholder="출판사를 입력해주세요." /></td>			
			</tr>
			<tr>
				<td>가격</td>			
				<td><input type="number" name="b_price" id="b_price" value="${content.B_PRICE}" placeholder="가격을 입력해주세요." /></td>			
			</tr>
			<tr>
				<td>책 내용</td>			
				<td><textarea name="b_info" id="b_info" rows="30" cols="22" maxlength="1000" placeholder="내용을 입력해주세요."></textarea>
			</tr>
		</tbody>
	</table>
	<input type="button" value="수정" id="modifyBtn" />
	<input type="button" value="취소" id="cancelBtn" />
</form>
</body>
</html>