<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
<style type="text/css">
html, body {
	height: 100%;
	margin: 0px;
	padding: 0px;
}
table {
	border-collapse: collapse;
	width: 100%;
	height: 100%;
}
tr {
	height: 40px;
}
thead > tr {
	border-top: 2px solid #000000;
	background-color: #EEEEEE;
	font-size: 13px;
}
tbody {
	font-size: 14px;
}
tbody > tr {
	text-align: center;
	border-bottom: 1px solid #F2F2F2;
}
tbody > tr:hover {
	background-color: #E8E3FF;
}
tbody > tr > .title:hover {
	text-decoration:underline;
	cursor: pointer;
}

span {
	cursor: pointer;
}
.wrap {
	width: 1000px;
}
.blank {
	padding-top: 20px;
	padding-bottom: 10px;
	display: inline-block;
	width: 30%;	
}

.currPage {
	font-weight: bold;
	background-color: #E8E3FF;
	padding: 10px;
}

#searchBtn, #addBtn, .searchGbn {
	background-color: #E8E3FF;
	border: groove 1px;
}

.startEnd {
	background-color: #F2F2F2;
	padding: 10px;
	margin-left: 20px;
	margin-right: 20px;
	font-weight: bold;
}


</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		$("#actionForm").attr("action", "book");
		$("#actionForm").submit();
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		$("#actionForm").attr("action", "book");
		$("#actionForm").submit();
	});
	
	$("#addBtn").on("click", function() {
		location.href = "add";	
	});
	
	$(".title").on("click", function() {
		$("#bookNo").val($(this).parent("tr").attr("name"));
		$("#actionForm").attr("action", "content");
		$("#actionForm").submit();
	});
	
	
});
</script>
</head>
<body>
<div class="wrap">
	<table>
		<colgroup>
			<col width="50px"></col>
			<col width="450px"></col>
			<col width="280px"></col>
			<col width="100px"></col>
			<col width="100px"></col>
		</colgroup>
		<thead>
			<tr>
				<th>책번호</th>
				<th>책제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="data" items="${list}">
				<tr name="${data.B_NO}">
					<td>${data.B_NO}</td>
					<td class="title">${data.B_TITLE}</td>
					<td>${data.B_AUTHOR}</td>
					<td>${data.B_PUBLISH}</td>
					<td>${data.B_PRICE}원</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="paging_area">
		<div class="blank"></div>
		<span name="1" class="startEnd">처음</span>
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
					<span name="${i}" class="currPage">${i}</span>
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
		<span name="${pb.maxPcount}" class="startEnd">마지막</span>
		<div class="blank"></div>
	</div>
	<br/>
	<form action="#" id="actionForm" method="post">
		<input type="hidden" id="bookNo" name="bookNo" />
		<input type="hidden" id="page" name="page" value="${page}" />
		<select name="searchGbn" class="searchGbn">
			<c:choose>
				<c:when test="${param.searchGbn eq 0}">
					<option value="0" selected="selected">책제목</option>
				</c:when>
				<c:otherwise>
					<option value="0">책제목</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${param.searchGbn eq 1}">
					<option value="1" selected="selected">저자</option>
				</c:when>
				<c:otherwise>
					<option value="1">저자</option>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${param.searchGbn eq 2}">
					<option value="2" selected="selected">출판사</option>
				</c:when>
				<c:otherwise>
					<option value="2">출판사</option>
				</c:otherwise>	
			</c:choose>
		</select>
		<input type="text" class="searchTxt" name="searchTxt" value="${param.searchTxt}" />
		<input type="button" value="검색" id="searchBtn" />
		<input type="button" value="등록" id="addBtn" />
	</form>
</div>
</body>
</html>