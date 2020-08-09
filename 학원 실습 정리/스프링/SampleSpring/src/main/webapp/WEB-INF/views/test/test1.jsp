<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.paging_area span {
	cursor: pointer;
	margin: 0px 2px;
}

.paging_area span:hover {
	text-decoration: underline;
}

</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		$("#actionForm").attr("action", "test1")
		$("#actionForm").submit();
	});
	$(".paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		$("#actionForm").attr("action", "test1")
		$("#actionForm").submit();
	});
	$("#addBtn").on("click", function() {
		location.href = "test2";	
	});
	
	$("tbody").on("click", "tr", function() {
		$("#sellId").val($(this).attr("name"));
		$("#actionForm").attr("action", "test3");
		$("#actionForm").submit();
	});
	
});
</script>
</head>
<body>
<!-- 검색의 경우 상태를 유지할 필요가 있음  -->
<!-- action에서 #은 아무 동작도 하지 않겠다라는 의미(주소창에 #이 추가가 되지만 변화X) -->
<!-- 하나의 폼을 여러 군데에서 사용할 때, 이동 직전에 속성을 바꿈 -->

<form action="#" id="actionForm" method="post">
	<input type="hidden" id="page" name="page" value="${page}" />
	<!-- sellId의 값도 같이 넘김 -->
	<input type="hidden" id="sellId" name="sellId" />
	<select name="searchGbn">
	<c:choose>
		<c:when test="${param.searchGbn eq 0}">
			<option value="0" selected="selected">거래ID</option>
		</c:when>
		<c:otherwise>
			<option value="0">거래ID</option>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${param.searchGbn eq 1}">
			<option value="1" selected="selected">고객</option>
		</c:when>
		<c:otherwise>
			<option value="1">고객</option>
		</c:otherwise>
	</c:choose>
		<c:choose>
		<c:when test="${param.searchGbn eq 2}">
			<option value="2" selected="selected">제품</option>
		</c:when>
		<c:otherwise>
			<option value="2">제품</option>
		</c:otherwise>
	</c:choose>
	</select>
	<input type="text" name="searchTxt" value="${param.searchTxt}" />
	<input type="button" value="검색" id="searchBtn" />
	<input type="button" value="등록" id="addBtn" />
</form>
<table border="1">
	<thead>
		<tr>
			<th>거래ID</th>
			<th>고객</th>
			<th>제품</th>
			<th>단가</th>
			<th>수량</th>
			<th>판매</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${list}">
			<!-- 기준값 부여하기 위해 name 지정 -->
			<tr name="${data.SELL_ID}">
				<td>${data.SELL_ID}</td>
				<td>${data.CUSTOMER}</td>
				<td>${data.PRODUCT}</td>
				<td>${data.PRICE}</td>
				<td>${data.QUANTITY}</td>
				<td>${data.SELL}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="paging_area">
	<span name="1">처음</span>
	<c:choose>
		<c:when test="${page eq 1}">
			<span name="1">이전</span>
		</c:when>
		<c:otherwise>
			<span name="${page - 1}">이전</span>
		</c:otherwise>
	</c:choose>
	<c:forEach var="i" begin="${pb.startPcount}" end="${pb.endPcount}" step="1">
		<c:choose>
			<c:when test="${i eq page}">
				<span name="${i}"><b>${i}</b></span>
			</c:when>
			<c:otherwise>
				<span name="${i}">${i}</span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:choose>
		<c:when test="${page eq pb.maxPcount}">
			<span name="${page}">다음</span>
		</c:when>	
		<c:otherwise>
			<span name="${page + 1}">다음</span>
		</c:otherwise>
	</c:choose>
	<span name="${pb.maxPcount}">마지막</span>
</div>
</body>
</html>