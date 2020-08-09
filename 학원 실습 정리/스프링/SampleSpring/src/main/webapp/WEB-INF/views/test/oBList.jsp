<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 게시판</title>
<style type="text/css">
.wrap {
	width: 1000px;
}
.top_wrap, .userNm, .txt, .wrBtn, .table_area, .mdBtn {
	display: inline-block;
}
.userNm {
	width: 100px;
	font-weight: bold;
}
.txt {
	width: 750px;
}

.tb {
	border-collapse: collapse;
}

.wrBtn, .mdBtn {
	width: 100px;
}


</style>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$(".mdBtn").hide();
	if("${param.page}" != "") {
		$("#page").val("${param.page}");
	}
	reloadList();
	
	$(".wrBtn").on("click", function() {
		if($.trim($("#oBCon").val()) == "") {
			alert("내용을 입력하여 주세요.");
		} else {
			writeAjax();
		}
	});
	
	
	$(".paging_area").on("click", "span", function() {
		$("#page").val($(this).attr("name"));
		reloadList();
	});
	
	$(".tbd").on("click", "span", function() {
		if($(this).is("#delete")) {
			$("#bNo").attr("value", $(this).attr("name"));
			$("#bmNo").attr("value", '${sBmNo}');
			var params = $("#actionForm").serialize();
			/* ajax 기본 형태  */
			$.ajax({
				type : "post",			  //전송방식
				url : "oBDeleteAjax", 	  //주소
				dataType : "json",  	  //데이터 형태
				data : params,    		  //보낼데이터
				success : function(res) { //성공 시 다음 함수를 실행하며, 돌아오는 값을 res란 이름으로 받는다.
					if(res.result == "success") {
						reloadList();
						redrawWrite();
					} else {
						alert("오류가 발생했습니다.");					
					}
				},
				error : function(request, status, error) { // 실행 중 에러 발생 시 
					console.log("text : " + request.responseTxt); //반환텍스트
					console.log("error : " + error); //에러내용
				}			
			});
		} else if($(this).is("#modify")) {
			$("#bNo").attr("value", $(this).attr("name"));
			$("#bmNo").attr("value", '${sBmNo}');
			redrawModify();
		};
	});
});
	

function writeAjax() {
	$("#bNo").attr("value", $(this).attr("name"));
	var params = $("#actionForm").serialize();
	$.ajax({
		type : "post",			  
		url : "oBWriteAjax", 	  
		dataType : "json",  	  
		data : params,    		  
		success : function(res) { 
			if(res.result == "success") {
				reloadList();
			} else {
				alert("오류가 발생했습니다.");					
			}
		},
		error : function(request, status, error) { 
			console.log("text : " + request.responseTxt);
			console.log("error : " + error); 
		}			
	});
}

function reloadList() {
	$("#oBCon").val('');
	var params = $("#actionForm").serialize();
	$.ajax({
		type : "post",
		url : "oBListAjax",
		dataType : "json",
		data : params,
		success : function(res) {
			if(res.result == "success") {
				redrawList(res.list);
				redrawPaging(res.pb);
			} else {
				alert("조회중 문제가 발생하였습니다.");
			}
		},
		error : function(request, status, error) {
			console.log("text : " + request.responseTxt);
			console.log("error : " + error);
		}
	});
}


function redrawModify() {
	var params = $("#actionForm").serialize();
	$.ajax({
		type : "post",
		url : "oBConAjax",
		dataType : "json",
		data : params,
		success : function(res) {
			if(res.result == "success") {
				var html = "";
				html += "<div class=\"top_wrap\">";
				html += "<div class=\"userNm\">";
				html += "${sBmNm}";
				html +=	"</div>";
				html += "<div class=\"txt\">";
				html += "<textarea rows=\"1\" cols=\"100\" name=\"oBCon\" id=\"oBCon\">"+ res.data[0].CON + "</textarea>";
				html += "</div>";
				html += "<div class=\"mdBtn\">";
				html += "수정";
				html += "</div>";
				html += "</div>";
				$(".top_wrap").html(html);
				$(".mdBtn").on("click", function() {
					if($.trim($("#oBCon").val()) == "") {
						alert("내용을 입력하여 주세요.");
					} else {
						oBUpdate();
					}
				});
			} else {
				alert("조회중 문제가 발생하였습니다.");
			}
		},
		error : function(request, status, error) {
			console.log("text : " + request.responseTxt);
			console.log("error : " + error);
		}
	});
}


function oBUpdate() {
	var params = $("#actionForm").serialize();
	$.ajax({
		type : "post",			  
		url : "oBUpdateAjax", 	  
		dataType : "json",  	  
		data : params,    		  
		success : function(res) { 
			if(res.result == "success") {
				reloadList();
				redrawWrite();
			} else {
				alert("오류가 발생했습니다.");					
			}
		},
		error : function(request, status, error) { 
			console.log("text : " + request.responseTxt);
			console.log("error : " + error); 
		}			
	});
}

function redrawWrite() {
	var html = "";
	html += "<div class=\"top_wrap\">";
	html += "<div class=\"userNm\">";
	html += "${sBmNm}";
	html +=	"</div>";
	html += "<div class=\"txt\">";
	html += "<textarea rows=\"1\" cols=\"100\" name=\"oBCon\" id=\"oBCon\"></textarea>";
	html += "</div>";
	html += "<div class=\"wrBtn\">";
	html += "글쓰기";
	html += "</div>";
	html += "<div class=\"mdBtn\">";
	html += "수정";
	html += "</div>";
	html += "</div>";
	$(".top_wrap").html(html);
	$(".mdBtn").hide();
	$(".wrBtn").on("click", function() {
		writeAjax();
	});
}

function redrawList(list) {
	if(list.length == 0) {
		var html = "";
		html += "<tr>";
		html += "<td colspan=\"4\">조회 결과가 없습니다.</td>";
		html += "</tr>";
		$(".tb tbody").html(html);
	} else {
		var html = "";
		for(var i = 0 ; i < list.length ; i++) {
			html += "<tr id=\"" + list[i].NO + "\" class=\"" + list[i].BM_NO + "\" name=\"subject\">";
			if(list[i].BM_ID == "${sBmId}"){
				html += "<td><b>" + list[i].NO + "</b><br/><span id=\"modify\" name=\"" + list[i].NO + "\">수정</span>/<span id=\"delete\" name=\"" + list[i].NO + "\">삭제</span></td>";
			} else {
				html += "<td><b>" + list[i].NO + "</b></td>";
			}
			html += "<td>" + list[i].CON + "</td>";
			html += "<td>" + list[i].BM_NM + "</td>";
			html += "<td>" + list[i].DT + "</td>";
			html += "</tr>";
		}
		$(".tb tbody").html(html);
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

<div class="wrap">
	<form action="#" id="actionForm" method="post">
		<input type="hidden" name="page" id="page" value="1" />
		<input type="hidden" name="bNo" id="bNo" />
		<input type="hidden" name="bmNo" id="bmNo" />
		<div class="top_wrap">
			<div class="userNm">
				${sBmNm}
			</div>
			<div class="txt">
				<textarea rows="1" cols="100" name="oBCon" id="oBCon"></textarea>
			</div>
			<div class="wrBtn">
				글쓰기
			</div>
			<div class="mdBtn">
				수정
			</div>
		</div>
	</form>
	<div class="table_area">
		<table class="tb">
			<colgroup>
				<col width="100px"></col>
				<col width="600px"></col>
				<col width="100px"></col>
				<col width="100px"></col>
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody class="tbd">
				<tr>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="paging_area">
		<span name="1">처음</span>
		<span name="1">이전</span>
		<span name="1">1</span>
		<span name="1">다음</span>
		<span name="1">마지막</span>
	</div>
</div>
</body>
</html>