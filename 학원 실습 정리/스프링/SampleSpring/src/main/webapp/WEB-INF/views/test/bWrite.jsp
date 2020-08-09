<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성</title>
<script type="text/javascript" src="resources/script/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="resources/script/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
$(document).ready(function() {
/* 	CKEDITOR.disableAutoInLine = false;
	CKEDITOR.inline ("test", {
		toolbarGroups : [
			{ name: 'basicstyles', groups: [ 'basicstyles'] },
			{ name: 'styles', groups: [ 'styles' ] },
			{ name: 'colors', groups: [ 'colors' ] },
		],
		removeButtons : 'Subscript,Superscript'
	}); */
	
	CKEDITOR.replace("bCon", {
		// 옵션
		language : "ko",
		enterMode : "2", //enterMode 2번 : 엔터를 줄바꿈으로 인식하겠다.
		resize_enabled : false, //resize_enabled : 크기 변환 여부
		width : 800,
		height : 300,
	});
	
	/* 엔터키 무력화 */
 	$("#actionForm input").on("keypress", function(event) {
		if(event.keypress == 13) {
			return false;
		}
	});  
	
	$("#cancelBtn").on("click", function() {
		$("#backForm").submit();
	});
	
	$("#writeBtn").on("click", function() {
		//CKEDITOR.instances['bCon'].getData() 
		// : CKEditor 객체 중 bCon에 연결된 객체에서 데이터를 가져오겠다.
		$("#bCon").val(CKEDITOR.instances['bCon'].getData());
		
		if($.trim($("#bTitle").val()) == "") {
			alert("제목을 입력하여 주세요.");
		} else if($("#bCon").val() == "") {
			alert("내용을 입력하여 주세요.");
		} else {		
			var params = $("#actionForm").serialize();
			/* ajax 기본 형태  */
			$.ajax({
				type : "post",			  //전송방식
				url : "bWriteAjax", 	  //주소
				dataType : "json",  	  //데이터 형태
				data : params,    		  //보낼데이터
				success : function(res) { //성공 시 다음 함수를 실행하며, 돌아오는 값을 res란 이름으로 받는다.
					if(res.result == "success") {
						location.href ="bMain";
					} else {
						alert("오류가 발생했습니다.");					
					}
				},
				error : function(request, status, error) { // 실행 중 에러 발생 시 
					console.log("text : " + request.responseTxt); //반환텍스트
					console.log("error : " + error); //에러내용
				}
			});
		}
	});
});
</script>
</head>
<body>
<form action="bMain" id="backForm" method="post">
	<input type="hidden" name="page" value="${param.page}" />
	<input type="hidden" name="searchGbn" value="${param.searchGbn}" />
	<input type="hidden" name="searchTxt" value="${param.searchTxt}" />
</form>
<form action="#" id="actionForm">
<input type="hidden" name="bmNo" value="${sBmNo}" />
제목<input type="text" name="bTitle" id="bTitle" /><br/>
작성자 : ${sBmNm}<br/>
내용<br/>
<textarea row="10" cols="20" name="bCon" id="bCon"></textarea><br/>
<input type="button" value="작성" id="writeBtn" />
<input type="button" value="취소" id="cancelBtn" />
</form>
<!-- <div id="test" contenteditable="true">인라인 에디터 영역</div> -->
</body>
</html>