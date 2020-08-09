<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
.b {
	border-collapse: collapse;
	margin-top: 10px;	
}

.b thead tr {
	border-top: 1px solid #85929E;
	border-bottom: 1px solid #85929E;
	background-color: #27AE60
}
.b tbody tr {
	border-bottom: 1px solid #85929E;
}

</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	if("${param.page}" != "") {
		$("#page").val("${param.page}");
	}
	if("${param.searchTxt}" != "") {
		$("#searchTxt").val("${param.searchTxt}");
	}
	if("${param.searchGbn}" != "") {
		$("#searchGbn").val("${param.searchGbn}");
	}
		
	reloadList();
	
	$("#logoutBtn").on("click", function() {
		location.href = "bLogout";
	});
	
	$("#oBList").on("click", function() {
		location.href = "oBList";
	});
	
	$("#insertBtn").on("click", function() {
		$("#actionForm").attr("action", "bWrite");
		$("#actionForm").submit();
	});
	
	$(".paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		reloadList();
	});
	
	$("#searchBtn").on("click", function() {
		$("#page").val("1");
		reloadList();
	});
	
	$("[name='searchTxt']").on("keypress", function() {
		if(event.keyCode == 13) {
			$("#searchBtn").click();
			return false;
		}		
	});
	
	$(".b tbody").on("click", "tr", function() {
		if($(this).is("[name]")) {
			$("#bNo").val($(this).attr("name"));
			
			$("#actionForm").attr("action", "bRead");
			$("#actionForm").submit();
		}
	});
});

function reloadList() {
	var params = $("#actionForm").serialize();
	
	$.ajax({
		type : "post",			  //전송방식
		url : "bListAjax", 	  //주소
		dataType : "json",  	  //데이터 형태
		data : params,    		  //보낼데이터
		success : function(res) { //성공 시 다음 함수를 실행하며, 돌아오는 값을 res란 이름으로 받는다.
			if(res.result == "success") {
				redrawList(res.list);
				redrawPaging(res.pb);
			} else {
				alert("조회중 문제가 발생하였습니다.");
			}
		},
		error : function(request, status, error) { // 실행 중 에러 발생 시 
			console.log("text : " + request.responseTxt); //반환텍스트
			console.log("error : " + error); //에러내용
		}
	});
}

function redrawList(list) {
	if(list.length == 0) {
		var html = "";
		html += "<tr>";
		html += "<td colspan=\"5\">조회 결과가 없습니다.</td>";
		html += "</tr>";
		$(".b tbody").html(html);
	} else {
		var html = "";
		for(var i = 0 ; i < list.length ; i++) {
			html += "<tr name=\"" + list[i].B_NO + "\">";
			html += "<td>" + list[i].B_NO + "</td>";
			html += "<td>" + list[i].B_TITLE + "</td>";
			html += "<td>" + list[i].BM_NM + "</td>";
			html += "<td>" + list[i].B_DT + "</td>";
			html += "<td>" + list[i].B_HIT + "</td>";
			html += "</tr>";
		}
		$(".b tbody").html(html);
	}
}

function redrawPaging(pb) {
	var html = "<span name=\"1\">처음</span>&nbsp;";
	
	if($("#page").val() == 1) {
		html += "<span name=\"1\">이전</span>&nbsp;";
	} else {
		html += "<span name=\"" + ($("#page").val() * 1 - 1) + "\">이전</span>&nbsp;";
	}
	
	for(var i = pb.startPcount ; i <= pb.endPcount ; i++) {
		if(i == $("#page").val()) {
			html += "<span name=\"" + i + "\"><b>" + i + "</b></span>&nbsp;";
		} else {
			html += "<span name=\"" + i + "\">" + i + "</span>&nbsp;";
		}
	}
	
	if($("#page").val() == pb.maxPcount) {
		html += "<span name=\"" + pb.maxPcount + "\">다음</span>&nbsp;";
	} else {
		html += "<span name=\"" + ($("#page").val() * 1 + 1) + "\">다음</span>&nbsp;";
	}
	html += "<span name=\"" + pb.maxPcount + "\">마지막</span>";
	
	$(".paging_area").html(html);
}

</script>
</head>
<body>
<!-- 세션에 있는 것을 바로 불러올 수 있음 -->
${sBmNm}님 어서오세요.<input type="button" value="로그아웃" id="logoutBtn" /> <input type="button" id="oBList" name="oBList" value="한줄 게시판"/><br/>
<form action="#" id="actionForm" method="post">
	<input type="hidden" name="bNo" id="bNo" />
	<input type="hidden" name="page" id="page" value="1" />
	<select name="searchGbn" id ="searchGbn">
		<option value="0">전체</option>	
		<option value="1">제목</option>	
		<option value="2">작성자</option>	
		<option value="3">내용</option>	
	</select>
	<input type="text" name="searchTxt" id="searchTxt" placeholder="검색어를 입력해주세요." />
<input type="button" value="검색" id="searchBtn" />
<input type="button" value="등록" id="insertBtn" />
</form>
<table class="b">
	<colgroup>
		<col width="100px"></col>
		<col width="400px"></col>
		<col width="100px"></col>
		<col width="120px"></col>
		<col width="60px"></col>
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
		</tr>
	</tbody>
</table>
<div class="paging_area">
	<span name="1">처음</span>
	<span name="1">이전</span>
	<span name="1">1</span>
	<span name="1">다음</span>
	<span name="1">마지막</span>
</div>

</body>
</html>