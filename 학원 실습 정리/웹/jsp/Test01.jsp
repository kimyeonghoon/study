<!-- JSP(Java Server Pages) : Java + html
jsp 실행 -> [servlet engine(자바 실행 후 실행결과 돌려줌)] => Java 실행 => 실행결과(HTML) -> Web Browser

jstl.jar
standard.jar
.jar(java application resources) java파일을 묶어 놓은 것. 실행파일 또는 일종의 라이브러리로 제공되는 경우 있음
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
	<% %> : Java코드영역. 요즘에는 이 방식을 안씀.
	<%@ %> : 설정 영역
	
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse; 
}

.even, .odd {
	border: 1px solid #444444;
}

.even {
	background-color: #8888FF;
}

</style>

</head>
<body>
<!-- 반복문 forEach -->
<c:forEach var="i" begin="1" end="10" step="1" varStatus="s">
<%-- el tag : ${i} 형태. 값을 가져오거나 변경... --%>
<%-- 
	status.index : 목록형 데이터인 경우 목록의 인덱스 0번부터 몇 번째인지의 인덱스 값을 가져옴
				      목록형이 아닌 경우 몇개째인지 가져옴.
	status.count : 몇 개째인지 가져옴
--%>
<%--
	eq : 같다
	ne : 다르다
 --%>
<%-- 조건문 if(단발성 조건) --%>
<%--
<c:if test="${i % 2 ne 0}">
${i},${s.index},${s.current},${s.count}<br/>
</c:if>
--%>
<%-- choose ~ when ~ otherwise : if ~ else와 동일 --%>
<c:choose>
	<c:when test="${i % 2 eq 0}">
		<b>${i}</b><br/>
	</c:when>
	<c:otherwise>
		${i}<br/>
	</c:otherwise>
</c:choose>
</c:forEach>

<table>
	<thead>
		<tr>
			<th>No</th>
			<th>Title</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i" begin="0" end="9">
			<c:choose>
				<c:when test="${i % 2 eq 0}">
					<tr class="even">
						<td>${10 - i}</td>
						<td>Test${10 - i}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr class="odd">
						<td>${10 - i}</td>
						<td>Test${10 - i}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tbody>
</table>

<!-- 구구단 출력을 코어태그를 활용하여 출력하시오. -->
<c:forEach var="i" begin ="2" end="9">
	<p><b>${i}단</b><br/>
	<c:forEach var="j" begin="1" end="9">
		${i} * ${j} = ${i * j}<br/>
	</c:forEach>
	</p>
</c:forEach>
</body>
</html>